package com.shortn0tes.feignexample.feign;

import com.shortn0tes.feignexample.trades.ExmoTrade;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;
import java.util.Map;

@FeignClient(name = "exmotrade", url = "https://api.exmo.com/v1/trades/")
public interface ExmoTradeClient {

    @RequestMapping(method = RequestMethod.GET)
    Map<String, List<ExmoTrade>> getListExmoTrade(@RequestParam("pair") String pair);



}