/**
 * 
 */
package com.avi.webflux6.stocktrading.repository;

import org.springframework.data.mongodb.repository.ReactiveMongoRepository;

import com.avi.webflux6.stocktrading.model.Stock;

/**
 * 09 Jan 24
 * @avi - this class for explore webflux 6 reactive programming 
 */
public interface StockWebFluxRepository extends ReactiveMongoRepository<Stock, String> {

}
