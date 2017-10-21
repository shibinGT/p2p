package com.qhcs.ssm.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.qhcs.ssm.dao.RedPacketMapper;
import com.qhcs.ssm.entity.RedPacket;
/**
 * 
 *@TODO:红包业务service
 * @author ：shibin
 *@version:2017年10月20日
 */
@Service
public class RedPacketService {
	@Autowired
	private RedPacketMapper redPacketMapper;
	/**
	 * 
	 *TODO:添加红包
	 *@version:2017年10月20日
	 *@aothor：shibin
	 * @param redPacket
	 * @return
	 */
	public boolean addRedPacket(RedPacket redPacket){
		return redPacketMapper.addRedPacket(redPacket);
	}
}
