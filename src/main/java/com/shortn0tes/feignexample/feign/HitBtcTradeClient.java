package com.shortn0tes.feignexample.feign;

import com.shortn0tes.feignexample.trades.HitBtcTrade;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.HashSet;

@FeignClient(name = "hitbtctrade", url = "https://api.hitbtc.com/api/2/public/trades/")
public interface HitBtcTradeClient {

    @RequestMapping(method = RequestMethod.GET, value = "{pair}?sort=DESC")
    HashSet<HitBtcTrade> getHitbtcObjects(@PathVariable("pair") String pair);
}
