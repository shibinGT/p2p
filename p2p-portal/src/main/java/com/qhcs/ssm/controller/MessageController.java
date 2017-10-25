package com.qhcs.ssm.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.github.pagehelper.PageInfo;
import com.qhcs.ssm.entity.Message;
import com.qhcs.ssm.entity.User;
import com.qhcs.ssm.service.MessageService;

@Controller
@RequestMapping("/message")
public class MessageController {

	@Autowired
	private MessageService service;

	/**
	 * 查询消息列表
	 * 
	 * @param message
	 *            消息类
	 * @param order
	 *            排序
	 * @param model
	 *            视图模型
	 * @return 转发到系统消息列表
	 */
	@RequestMapping("/list")
	public String queryList(Message message, String order, Model model, HttpSession session) {
		message.setUserId(((User) session.getAttribute("loginUser")).getUserId());
		PageInfo<Message> pageInfo = service.queryList(message, order);
		model.addAttribute("pageInfo", pageInfo);
		model.addAttribute("status", message.getMessageStatus());
		return "message-list";
	}

	/**
	 * 批量删除消息
	 * 
	 * @param message
	 *            用 message的lists 接收前端传过来的要删除的 消息的id
	 * @return 重定向到 查询消息列表
	 */
	@RequestMapping("/batchDel")
	public String batchDel(Message message) {
		service.batchDel(message.getLists());
		return "redirect:/message/list/";
	}

	/**
	 * 批量修改消息阅读状态
	 * 
	 * @param message
	 *            接收要修改的id的list，修改后的状态，用户id
	 * @return 重定向到 查询消息列表
	 */
	@RequestMapping("/batchRead")
	public String batchRead(Message message) {
		service.batchRead(message.getLists(), message.getUserId(), message.getMessageStatus());
		return "redirect:/message/list";
	}



}
