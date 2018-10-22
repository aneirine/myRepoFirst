package com.shortn0tes.feignexample.feign;

import com.shortn0tes.feignexample.model.ExampleObject;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;


@FeignClient(name = "exmo", url = "${feign.exmoapi.url}/order_book")
public interface ExampleObjectClient {

	@RequestMapping(method = RequestMethod.POST)
	ExampleObject createExampleObject(ExampleObject exampleObject);

	@RequestMapping(method = RequestMethod.GET)
    List<ExampleObject> getExampleObjects();

	@RequestMapping(method = RequestMethod.GET)
	ExampleObject getExampleObject(@RequestParam("pair") String pair);

    @RequestMapping(method = RequestMethod.PUT)
    ExampleObject updateExampleObject(ExampleObject exampleObject);

    @RequestMapping(method = RequestMethod.DELETE)
    void deleteExampleObject();


}
