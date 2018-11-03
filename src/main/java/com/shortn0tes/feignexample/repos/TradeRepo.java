package com.shortn0tes.feignexample.repos;

import com.shortn0tes.feignexample.model.Trade;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TradeRepo extends CrudRepository<Trade, Long> {
}
