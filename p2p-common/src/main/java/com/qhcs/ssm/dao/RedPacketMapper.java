package com.qhcs.ssm.dao;

import com.qhcs.ssm.entity.RedPacket;

/**
 * 
 *@TODO:红包操作DAO
 * @author ：shibin
 *@version:2017年10月20日
 */
public interface RedPacketMapper {
	/**
	 * 
	 *TODO:添加红包
	 *@version:2017年10月20日
	 *@aothor：shibin
	 * @param redPacket
	 * @return
	 */
	public boolean addRedPacket(RedPacket redPacket);
}
