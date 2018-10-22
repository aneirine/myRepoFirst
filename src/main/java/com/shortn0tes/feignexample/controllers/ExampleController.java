package com.shortn0tes.feignexample.controllers;

import com.shortn0tes.feignexample.feign.ExampleObjectClient;
import com.shortn0tes.feignexample.model.ExampleObject;
import com.shortn0tes.feignexample.model.Price;
import com.shortn0tes.feignexample.repos.PriceRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Date;


@Controller
public class ExampleController {

    @Autowired
    ExampleObjectClient exampleObjectClient;

    @RequestMapping("/read")
    @ResponseBody
    String read() {
        ExampleObject exampleObject = exampleObjectClient.getExampleObject("ETH_BTC");
        String str = exampleObject.getBook().getAsk_amount();




        return "This is " + str;
    }
}





