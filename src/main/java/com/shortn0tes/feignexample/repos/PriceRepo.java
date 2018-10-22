package com.shortn0tes.feignexample.repos;

import com.shortn0tes.feignexample.model.Price;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PriceRepo extends CrudRepository<Price, Long> {

}
