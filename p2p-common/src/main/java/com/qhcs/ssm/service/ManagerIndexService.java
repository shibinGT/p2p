package com.qhcs.ssm.service;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.qhcs.security.cache.RedisManager;
import com.qhcs.ssm.dao.ManagerIndexMapper;
import com.qhcs.ssm.entity.Project;
import com.qhcs.ssm.entity.RegisterCount;

@Service
public class ManagerIndexService {

	@Autowired
	private ManagerIndexMapper managerIndexMapper;

	@Autowired
	private RedisManager redis;

	/**
	 * 
	 * 获取注册人数数据
	 * 
	 * @version 2017年10月21日下午2:12:11
	 * @author lijing
	 * @return
	 */
	public String getRegNumByDate() {

		return getDays(managerIndexMapper.getRegNumByDate());
	}

	/**
	 * 
	 * 取出近7天应还款的项目列表
	 * 
	 * @version 2017年10月21日下午2:14:30
	 * @author lijing
	 * @return
	 */
	public List<Project> getRepaymentList() {
		return managerIndexMapper.getRepaymentList();
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
				// 没人注册的天数设置成0
			}
			if (!equal) {
				allDays.add(new RegisterCount(dayTemp, 0));
			}

			// 减少一天
			dayTemp = new Date(dayTemp.getTime() - 24 * 60 * 60 * 1000);
		}
		DateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
		// 循环拿出字符串拼接

		for (int i = allDays.size() - 1; i >= 0; i--) {
			jsonStr = jsonStr + '[' + '"' + formatter.format(allDays.get(i).getRegDate()) + '"' + ','
					+ allDays.get(i).getNumber() + "],";
		}
		System.out.println("\n\n" + allDays.size()
				+ "\n===============================@@@@@@@@@@@@@================\n\n" + jsonStr);
		jsonStr = jsonStr.substring(0, jsonStr.length() - 1) + "]";
		// 格式化字符串

		return jsonStr;
	}

	/**
	 * 
	 * 查询投资的并添加到redis里面，每隔一个小时取出更新一次
	 * 
	 * @version 2017年10月23日上午11:02:56
	 * @author lijing
	 * @return
	 */
	public void setTotalInvestMoney() {
		Runnable runnable = new Runnable() {
			public void run() {
				// 今日金额
				redis.set("todayMoney", managerIndexMapper.getTodayInvestMoney().toString());
				// 总金额
				redis.set("totalMoney", managerIndexMapper.getTotalInvestMoney().toString());
				System.out.println("定时设置");
			}
		};
		ScheduledExecutorService service = Executors.newSingleThreadScheduledExecutor();

		// 第二个参数为首次执行的延时时间，第三个参数为定时执行的间隔时间
		service.scheduleAtFixedRate(runnable, 1L, 3600L, TimeUnit.SECONDS);

		// 今日金额

	}

}
