package com.qhcs.ssm.service;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.qhcs.ssm.dao.NewsMapper;
import com.qhcs.ssm.entity.News;

@Service
public class NewsService {
	@Autowired
	private NewsMapper newsMapper;
	
	/**
	 * 
	 *TODO:查找新闻列表
	 *@version:2017年10月21日
	 *@aothor：shibin
	 * @param news
	 * @return
	 */
	public PageInfo<News> queryNewsList(News news){
		PageHelper.startPage(news.getPageNum(), news.getPageSize());
		//查询新闻列表
		List<News>list=newsMapper.queryNewsList(news);
		System.out.println("----------新闻列表----------------------");
		
		System.out.println(list);
		//封装，把list封装成 PageInfo
		PageInfo<News> pageInfo=new PageInfo<>(list);
		return pageInfo;
	}
	/**
	 * 
	 *TODO:添加新闻
	 *@version:2017年10月21日
	 *@aothor：shibin
	 * @param news
	 * @return
	 */
	public boolean addNews(News news){
		return newsMapper.addNews(news);
	}
	/**
	 * 
	 *TODO:新闻上下架
	 *@version:2017年10月21日
	 *@aothor：shibin
	 * @param newsStatus
	 * @param newsId
	 * @return
	 */
	public boolean updateNewsStatus(Integer newsStatus,Integer newsId){
		return newsMapper.updateNewsStatus(newsStatus, newsId);
	}
	/**
	 * 
	 *TODO:根据ID删除新闻
	 *@version:2017年10月21日
	 *@aothor：shibin
	 * @param newsStatus
	 * @param newsId
	 * @return
	 */
	public boolean delNews(@Param("newsId")Integer newsId){
		return newsMapper.delNews(newsId);
	}
	
	/**
	 * 
	 *TODO:根据ID查找新闻
	 *@version:2017年10月24日
	 *@aothor：shibin
	 * @param newsId
	 * @return
	 */
	public News queryNewsById(Integer newsId){
		return newsMapper.queryNewsById(newsId);
	}
	
}
