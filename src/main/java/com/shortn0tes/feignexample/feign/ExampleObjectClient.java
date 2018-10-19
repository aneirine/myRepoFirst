package com.shortn0tes.feignexample.feign;

import com.shortn0tes.feignexample.model.ExampleObject;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;


public interface ExampleObjectClient {

	@RequestMapping(method = RequestMethod.POST)
	ExampleObject createExampleObject(ExampleObject exampleObject);

	@RequestMapping(method = RequestMethod.GET)
    List<ExampleObject> getExampleObjects();

	@RequestMapping(method = RequestMethod.GET)
	ExampleObject getExampleObject();

    @RequestMapping(method = RequestMethod.PUT)
    ExampleObject updateExampleObject(ExampleObject exampleObject);

    @RequestMapping(method = RequestMethod.DELETE)
    void deleteExampleObject();


}
