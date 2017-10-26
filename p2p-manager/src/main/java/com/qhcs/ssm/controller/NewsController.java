package com.qhcs.ssm.controller;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.apache.shiro.SecurityUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.github.pagehelper.PageInfo;
import com.qhcs.security.cache.Constants;

import com.qhcs.security.cache.RedisCache;

import com.qhcs.ssm.entity.Employee;
import com.qhcs.ssm.entity.News;
import com.qhcs.ssm.service.NewsService;
/**
 * 
 *@TODO:新闻控制
 * @author ：shibin
 *@version:2017年10月23日
 */
@RequestMapping("/news")
@Controller
public class NewsController {
	@Autowired
	private NewsService newsService;
	
	
	/**
	 * 
	 *TODO:跳转到添加
	 *@version:2017年10月21日
	 *@aothor：shibin
	 * @param news
	 * @param model
	 * @return
	 */
	@RequestMapping("/toAddNews")
	public String toAddNews(){				
		return "addNewsPage";
	}
	/**
	 * 
	 *TODO:查看所有新闻列表
	 *@version:2017年10月21日
	 *@aothor：shibin
	 * @return
	 */
	@RequestMapping("/queryNewsList")
	public String queryNewsList(News news,Model model){
		//查询列表
		PageInfo<News> pageInfo=newsService.queryNewsList(news);
		//把列表丢到model里
		model.addAttribute("pageInfo",pageInfo);
		return "NewsList";
	}
	/**
	 * 
	 *TODO:添加新闻
	 *@version:2017年10月21日
	 *@aothor：shibin
	 * @return
	 */
	@RequestMapping("/addNews")
	public String addNews(News news,Model model){
		//以下获取登录用户，有封装好的
		ApplicationContext ctx = new ClassPathXmlApplicationContext("applicationContext.xml");
		//
		RedisCache redisCache=ctx.getBean(RedisCache.class);
		//
		String currentUser = (String)SecurityUtils.getSubject().getPrincipal();
		Employee employee=(Employee)redisCache.get(Constants.getUserSessionKey(currentUser));
		//页面已经输入了模块名称，标题，内容
		//操作人的ID
		news.setNewsEmployeeId(employee.getEmployeeId());
		//新闻更新时间
		news.setNewsUpdateTime(new Date());
		//新闻最后修改时间
		news.setNewsModificationTime(new Date());
		//新闻状态,预览
		news.setNewsReleaseStatus(0);
		newsService.addNews(news);
		
		return "redirect:/news/queryNewsList";
	}
	/**
	 * 
	 *TODO:根据ID删除新闻
	 *@version:2017年10月23日
	 *@aothor：shibin
	 * @param newsId
	 * @return 列表页面
	 */
	@RequestMapping("/delNews/{id}")
	public String delNews(@PathVariable("id") Integer newsId){
		System.err.println(newsId);
		newsService.delNews(newsId);
		return "redirect:/news/queryNewsList";
	}
	/**
	 * 
	 *TODO:根据ID上下或下架新闻
	 *@version:2017年10月24日
	 *@aothor：shibin
	 * @param newsId
	 * @return 列表页面
	 */
	@RequestMapping("/updateNewsStatus/{id}")
	public String updateNewsStatus(@PathVariable Integer newsId){
		//ID查到新闻信息
		News news=newsService.queryNewsById(newsId);
		//拿到状态,如果等于0或2.。预览或下架中
		if(news.getNewsReleaseStatus()==0||news.getNewsReleaseStatus()==2){
			//把状态改为发布
			newsService.updateNewsStatus(1, newsId);
		
		}else{
			//如果为发布中
		
		}
		return "redirect:/news/queryNewsList";
	}
}
