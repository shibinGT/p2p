package com.qhcs.ssm.dao;

import com.qhcs.ssm.entity.ClientApply;

/**
 * 
 * TODO:用户借款申请表接口，实现增删改查
 * 
 * @version 2017年10月19日下午14:24:09
 * @author xyj
 */
public interface ClientApplyMapper {
	/**
	 * 
	 * TODO:新增一个申请表
	 * 
	 * @version 2017年10月19日上午14:26:35
	 * @author xyj
	 * @param ClientApply
	 * @return 添加成功返回true
	 */
	public boolean addClientApply(ClientApply clientApply);

}
