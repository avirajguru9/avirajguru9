package com.avi.webflux6.stocktrading.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.stereotype.Service;

import com.avi.webflux6.stocktrading.dto.StockRequest;
import com.avi.webflux6.stocktrading.dto.StockResponse;
import com.avi.webflux6.stocktrading.model.Stock;
import com.avi.webflux6.stocktrading.repository.StockRepository;
import com.avi.webflux6.stocktrading.repository.StockWebFluxRepository;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class StockService {

	@Autowired
	private MongoOperations mongo;
	
	@Autowired
	private StockWebFluxRepository stockWebFluxRepo;
	
	public Mono<StockResponse> getWebFluxOneStock(String id) {
		return stockWebFluxRepo.findById(id).map(
				StockResponse::fromModel
				);
	}
	
	public Flux<StockResponse> getWebFluxAllStock() {
		return stockWebFluxRepo.findAll().map(
				StockResponse::fromModel
				);
	}
	
	public Mono<StockResponse> createWebFluxStock(StockRequest stockRequest){
		return stockWebFluxRepo.save(stockRequest.toModel()).map(
				StockResponse::fromModel
				);
	}
}
