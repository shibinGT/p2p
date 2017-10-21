package com.qhcs.ssm.service;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.qhcs.ssm.dao.ManagerIndexMapper;
import com.qhcs.ssm.entity.RegisterCount;

@Service
public class ManagerIndexService {

	@Autowired
	private ManagerIndexMapper managerIndexMapper;

	public String getRegNumByDate() {

		System.out.println("=========@@@@@@@@@@@@@@@========");
		return getDays(managerIndexMapper.getRegNumByDate());

	}

	/**
	 * 
	 * 获取近十五天注册人数并将结果转换为字符串
	 * 
	 * @version 2017年10月20日下午7:28:43
	 * @author lijing
	 */
	public String getDays(List<RegisterCount> registerCount) {

		// 临时时间变量 初始为当前时间
		Date dayTemp = new Date();
		String jsonStr = "[";
		// 近15天全部数据
		boolean equal;
		List<RegisterCount> allDays = new LinkedList<>();
		for (int i = 1; i <= 15; i++) {
			equal = false;
			for (RegisterCount register : registerCount) {
				// 有注册数据则写为注册人数
				if (register.getRegDate().getDate() == dayTemp.getDate()) {
					equal = true;
					allDays.add(register);
					break;
				}
			}
			// 没人注册的天数设置成0
			if (!equal) {
				allDays.add(new RegisterCount(dayTemp, 0));
			}
			// 减少一天
			dayTemp = new Date(dayTemp.getTime() - 24 * 60 * 60 * 1000);

		}
		System.out.println("size:" + allDays.size());
		DateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
		// 循环拿出字符串拼接
		for (int i = allDays.size() - 1; i > 0; i--) {
			jsonStr = jsonStr + '[' + '"' + formatter.format(allDays.get(i).getRegDate()) + '"' + ','
					+ allDays.get(i).getNumber() + "],";
		}
		jsonStr = jsonStr.substring(0, jsonStr.length() - 1) + "]";
		// 格式化字符串
		System.out.println("==========================￥￥￥￥￥￥￥￥￥￥￥￥￥￥￥￥================\n\n\n\n" + jsonStr);

		return jsonStr;
	}
}
