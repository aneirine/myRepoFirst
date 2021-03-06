package com.shortn0tes.feignexample.repos;

import com.shortn0tes.feignexample.model.Profit;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProfitRepo extends CrudRepository<Profit, Long> {

}
