package com.shortn0tes.feignexample.feign;

import com.shortn0tes.feignexample.model.exmo.ExmoObject;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;


@FeignClient(name = "exmo", url = "${feign.exmoapi.url}/order_book")
public interface ExmoObjectClient {

    @RequestMapping(method = RequestMethod.POST)
    ExmoObject createExmoObject(ExmoObject exampleObject);

    @RequestMapping(method = RequestMethod.GET)
    List<ExmoObject> getExmoObjects();

    @RequestMapping(method = RequestMethod.GET)
    ExmoObject getExmoObject(@RequestParam("pair") String pair);

    @RequestMapping(method = RequestMethod.PUT)
    ExmoObject updateExmoObject(ExmoObject exampleObject);

    @RequestMapping(method = RequestMethod.DELETE)
    void deleteExmoObject();


}
