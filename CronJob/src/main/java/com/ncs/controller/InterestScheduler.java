package com.ncs.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import com.ncs.model.AccountMappingList;

@Component
public class InterestScheduler {
	
	

	@Scheduled(cron = "00 35 9 * * *")
	private  AccountMappingList getAllAccountMapping() 
	{
		String url="http://192.168.1.6:8082/";
		RestTemplate restTemplate=new RestTemplate();
		System.out.println("testing:::");
		AccountMappingList result = restTemplate.getForObject(url+"accountMapping", AccountMappingList.class);
		result.getObj().forEach(p -> p.setAmount( p.getAmount()+(p.getAmount()/100)));
		RestTemplate restTemplateList=new RestTemplate();
		ResponseEntity<AccountMappingList> obj=restTemplateList.postForEntity(url+"accountMappingList", result, AccountMappingList.class);
		System.out.println(obj);
		 return result;
}
}
