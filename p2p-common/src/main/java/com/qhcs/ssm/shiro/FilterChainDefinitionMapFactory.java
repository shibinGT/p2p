package com.qhcs.ssm.shiro;

import java.util.LinkedHashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.qhcs.ssm.dao.AuthMapper;
import com.qhcs.ssm.entity.Auth;

public class FilterChainDefinitionMapFactory {

	@Autowired
	private AuthMapper authMapper;

	public LinkedHashMap<String, String> filterChainDefinitionMap() {
		// 从数据库里面把收保护的资源查询处理

		LinkedHashMap<String, String> map = new LinkedHashMap<>();
		System.out.println("开始查询权限集合....");
		List<Auth> auths = authMapper.getList();
		System.out.println("auths:" + auths.size());
		for (Auth auth : auths) {
			map.put(auth.getAuthResource(), auth.getAuthCode());
			System.out.println(auth.getAuthResource() + "=" + auth.getAuthCode());
		}
		return map;

	}

}
