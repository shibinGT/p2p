package com.qhcs.p2p.test;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.qhcs.ssm.entity.BankCard;
import com.qhcs.ssm.service.BankCardService;

public class Test {
	public static void main(String[] args) {
		ApplicationContext applicationContext = new ClassPathXmlApplicationContext("applicationContext.xml");
		BankCardService service = applicationContext.getBean(BankCardService.class);
		// service.updateAccountByUserId(56.2, 1);
		BankCard bankCard = new BankCard();
		bankCard.setBankCardNumber("54500004");
		System.out.println("=========" + service.addBankCard(bankCard, -5000.0, 11));
		System.out.println(bankCard.getBankCardId());
	}

}
