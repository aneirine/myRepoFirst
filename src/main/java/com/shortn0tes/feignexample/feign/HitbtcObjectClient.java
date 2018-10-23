package com.shortn0tes.feignexample.feign;

import com.shortn0tes.feignexample.model.hitbtc.HitbtcObject;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;


@FeignClient(name = "hitbtc", url = "${feign.hitbtc.url}/orderbook")
public interface HitbtcObjectClient {

    @RequestMapping(method = RequestMethod.POST)
    HitbtcObject createHitbtcObject(HitbtcObject hitbtcObject);

    @RequestMapping(method = RequestMethod.GET)
    List<HitbtcObject> getHitbtcObjects();

    @RequestMapping(method = RequestMethod.GET, value = "/ETHBTC")
    HitbtcObject getHitbtcObject();

    @RequestMapping(method = RequestMethod.PUT)
    HitbtcObject updateHitbtcObject(HitbtcObject hitbtcObject);

    @RequestMapping(method = RequestMethod.DELETE)
    void deleteHitbtcObject();


}
