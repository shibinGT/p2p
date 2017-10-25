/**
 * 
 */
package com.qhcs.ssm.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.qhcs.ssm.entity.Message;

/**
 * 系统消息dao层
 *
 */
public interface MessageMapper {

	/**
	 * 根据用户id进行查询消息列表 并进行排序
	 * 
	 * @param message
	 *            消息
	 * @param order
	 *            排序依据
	 * @return
	 */
	public List<Message> queryList(@Param("message") Message message, @Param("order") String order);

	/**
	 * 根据 id的list 批量删除消息
	 * 
	 * @param lists
	 * @return
	 */
	public boolean batchDel(@Param("lists") List<Integer> lists);

	/**
	 * 根据用户id批量修改消息的状态
	 * 
	 * @param lists
	 *            消息的id的list
	 * @param userId
	 *            用户id
	 * @param status
	 *            改变后的状态
	 * @return
	 */
	public boolean batchRead(@Param("lists") List<Integer> lists, @Param("userId") Integer userId,
			@Param("status") Integer status);


}
