package com.avi.webflux6.stocktrading.repository;

import java.util.List;

import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.springframework.stereotype.Repository;

import com.avi.webflux6.stocktrading.model.Stock;

@Repository
public interface StockRepository extends MongoRepository<Stock, String> {
//	List<Stock> findByName(String name);
//	Stock deleteById(ObjectId id);
//	boolean existsById(ObjectId id);
}
