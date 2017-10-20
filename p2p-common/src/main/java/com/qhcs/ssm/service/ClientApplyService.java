package com.qhcs.ssm.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.qhcs.ssm.dao.ClientApplyMapper;
import com.qhcs.ssm.entity.ClientApply;

@Service
public class ClientApplyService {

	@Autowired
	private ClientApplyMapper clientApplyMapper;

	/**
	 * 
	 * 新增一个申请表
	 * 
	 * @version 2017年10月19日上午14:26:35
	 * @author lzc
	 * @param ClientApply
	 * @return 添加成功返回true
	 */
	public boolean addClientApply(ClientApply clientApply) {
		return clientApplyMapper.addClientApply(clientApply);
	}

}
