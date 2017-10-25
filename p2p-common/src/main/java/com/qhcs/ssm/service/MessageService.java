/**
 * 
 */
package com.qhcs.ssm.service;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.qhcs.ssm.dao.MessageMapper;
import com.qhcs.ssm.entity.Message;

/**
 * 系统消息的service层
 *
 */
@Service
public class MessageService {

	@Autowired
	private MessageMapper mapper;

	/**
	 * 根据用户id进行查询消息列表 并进行排序
	 * 
	 * @param message
	 *            消息
	 * @param order
	 *            排序依据
	 * @return
	 */
	public PageInfo<Message> queryList(Message message, String order) {

		PageHelper.startPage(message.getPageNum(), message.getPageSize());

		List<Message> messages = mapper.queryList(message, order);
		// 封装，把list封装成 PageInfo
		PageInfo<Message> page = new PageInfo<>(messages);
		return page;
	}

	/**
	 * 根据 id的list 批量删除消息
	 * 
	 * @param lists
	 * @return
	 */
	public boolean batchDel(List<Integer> lists) {
		return mapper.batchDel(lists);
	}

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
			@Param("status") Integer status) {
		return mapper.batchRead(lists, userId, status);
	}

}
