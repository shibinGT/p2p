package com.qhcs.ssm.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.qhcs.ssm.entity.News;

/**
 * 
 *@TODO:新闻操作
 * @author ：shibin
 *@version:2017年10月21日
 */
public interface NewsMapper {
	/**
	 * 
	 *TODO:查找新闻列表
	 *@version:2017年10月21日
	 *@aothor：shibin
	 * @param news
	 * @return
	 */
	public List<News> queryNewsList(News news);
	/**
	 * 
	 *TODO:添加新闻
	 *@version:2017年10月21日
	 *@aothor：shibin
	 * @param news
	 * @return
	 */
	public boolean addNews(News news);
	/**
	 * 
	 *TODO:新闻上下架
	 *@version:2017年10月21日
	 *@aothor：shibin
	 * @param newsStatus
	 * @param newsId
	 * @return
	 */
	public boolean updateNewsStatus(@Param("newsStatus")Integer newsStatus,@Param("newsId")Integer newsId);
	/**
	 * 
	 *TODO:根据ID删除新闻
	 *@version:2017年10月21日
	 *@aothor：shibin
	 * @param newsStatus
	 * @param newsId
	 * @return
	 */
	public boolean delNews(@Param("newsId")Integer newsId);
	/**
	 * 
	 *TODO:根据ID查找新闻
	 *@version:2017年10月24日
	 *@aothor：shibin
	 * @param newsId
	 * @return
	 */
	public News queryNewsById(Integer newsId);
}
