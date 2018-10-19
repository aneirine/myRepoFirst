package com.shortn0tes.feignexample.controllers;

import com.shortn0tes.feignexample.feign.ExmoObjectClient;
import com.shortn0tes.feignexample.model.ExmoObject;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;


@Controller
public class UserController {

	@Autowired
	ExmoObjectClient exmoObjectClient;


	@RequestMapping("/read")
	@ResponseBody
	String read() {
		ExmoObject exmoObject = exmoObjectClient.getExmoObject("ETH_BTC");
		String str = exmoObject.getAsk_quantity();

		return str;

	}



}
