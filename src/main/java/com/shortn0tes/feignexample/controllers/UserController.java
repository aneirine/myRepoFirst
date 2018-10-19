package com.shortn0tes.feignexample.controllers;

import com.shortn0tes.feignexample.feign.ExampleObjectClient;
import com.shortn0tes.feignexample.model.ExampleObject;
import feign.Feign;
import feign.Logger;
import feign.jackson.JacksonDecoder;
import feign.jackson.JacksonEncoder;
import org.springframework.cloud.netflix.feign.support.SpringMvcContract;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;


    @Controller
    public class UserController {

        @RequestMapping("/read")
        @ResponseBody
        String read() {
            ExampleObjectClient exampleObjectClient = Feign.builder()
                    .contract(new SpringMvcContract())
                    .encoder(new JacksonEncoder())
                    .decoder(new JacksonDecoder())
                    .logger(new Logger.ErrorLogger())
                    .logLevel(Logger.Level.FULL)
                    .target(ExampleObjectClient.class, "https://api.exmo.com/v1/order_book/?pair=ETH_BTC");


            ExampleObject exampleObject = exampleObjectClient.getExampleObject();

            String str = exampleObject.getEth_btc().getAsk_amount();
            return "This is " + str;
        }
    }




