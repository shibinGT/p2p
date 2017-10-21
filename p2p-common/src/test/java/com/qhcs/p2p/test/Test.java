package com.qhcs.p2p.test;

import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.qhcs.ssm.dao.ReturnPlanMapper;
import com.qhcs.ssm.entity.Account;
import com.qhcs.ssm.entity.TransactionRecord;
import com.qhcs.ssm.service.AccountService;
import com.qhcs.ssm.service.ReturnPlanService;
import com.qhcs.ssm.service.TransactionRecordService;

public class Test {
	public static void main(String[] args) {
		ApplicationContext ctx = new ClassPathXmlApplicationContext("applicationContext.xml");
		
		//回款计划
		/*ReturnPlanService service = ctx.getBean(ReturnPlanService.class);
		System.out.println("开始查询");
	    List list=	service.queryReturnList();
	    System.out.println("开始结束"+list.size());
	    System.out.println(list);*/
		
		//查询账户信息
	   /* AccountService service2=ctx.getBean(AccountService.class);
	    System.out.println("kaishi------------------------------------");
	    int userID=1;
	    Account account=service2.queryAccountByUserId(userID);
	    System.out.println("赚钱:"+account.getAccountAccumulatedEarnings());
	    System.out.println("结束---------------------------------");*/
		
		//查询交易记录
		/*TransactionRecordService service3=ctx.getBean(TransactionRecordService.class);
		System.out.println("开始-------------------------------------");
		int userId=1;
		TransactionRecord record=service3.queryTransactionRecordByUserId(userId);
		System.out.println("类型----------------------------------------------"+record.getTransactionRecordType());
		System.out.println("----------------------------");*/
	}

}
