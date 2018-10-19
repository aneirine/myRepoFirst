package com.shortn0tes.feignexample.controllers;

import com.shortn0tes.feignexample.feign.ExampleObjectClient;
import com.shortn0tes.feignexample.model.ExampleObject;
import feign.Feign;
import feign.Logger;
import feign.jackson.JacksonDecoder;
import feign.jackson.JacksonEncoder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.netflix.feign.support.SpringMvcContract;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;


@Controller
public class ExampleController {

    @Autowired
    ExampleObjectClient exampleObjectClient;

    @RequestMapping("/read")
    @ResponseBody
    String read() {
        ExampleObject exampleObject = exampleObjectClient.getExampleObject();
        String str = exampleObject.getEth_btc().getAsk_amount();
        return "This is " + str;
    }
}




