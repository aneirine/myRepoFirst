package com.shortn0tes.feignexample.repos;

import org.aspectj.bridge.Message;
import org.springframework.data.repository.CrudRepository;

public interface PriceRepo extends CrudRepository<Message, Long> {


}
