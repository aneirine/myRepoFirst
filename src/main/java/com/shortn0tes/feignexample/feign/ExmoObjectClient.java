package com.shortn0tes.feignexample.feign;

import com.shortn0tes.feignexample.model.ExmoObject;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;


public interface ExmoObjectClient {

	@RequestMapping(method = RequestMethod.POST, value = "/?pair={pair}")
	ExmoObject createExmoObject(ExmoObject exmoObject);

	@RequestMapping(method = RequestMethod.GET, value = "/?pair={pair}")
    List<ExmoObject> getExmoObjects();

	@RequestMapping(method = RequestMethod.GET, value = "/?pair={pair}")
	ExmoObject getExmoObject(@PathVariable("pair") String pair);


}
