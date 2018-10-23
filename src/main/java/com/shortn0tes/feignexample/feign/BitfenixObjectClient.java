package com.shortn0tes.feignexample.feign;

import com.shortn0tes.feignexample.model.bitfenix.BitfenixObject;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

@FeignClient(name = "bitfenix", url = "${feign.bitfenix.url}/book")
public interface BitfenixObjectClient {

    @RequestMapping(method = RequestMethod.POST)
    BitfenixObject createBitfenixObject(BitfenixObject bitfenixObject);

    @RequestMapping(method = RequestMethod.GET)
    List<BitfenixObject> getBitfenixObjects();

    @RequestMapping(method = RequestMethod.GET, value = "/ETHBTC")
    BitfenixObject getBitfenixObject();

    @RequestMapping(method = RequestMethod.PUT)
    BitfenixObject updateBitfenixObject(BitfenixObject bitfenixObject);

    @RequestMapping(method = RequestMethod.DELETE)
    void deleteBitfenixObject();


}