package com.avi.webflux6.stocktrading.service;

import java.math.BigDecimal;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestParam;

import com.avi.webflux6.stocktrading.dto.StockRequest;
import com.avi.webflux6.stocktrading.dto.StockResponse;
import com.avi.webflux6.stocktrading.exception.StockCreationException;
import com.avi.webflux6.stocktrading.exception.StockNotFoundException;
import com.avi.webflux6.stocktrading.model.Stock;
import com.avi.webflux6.stocktrading.repository.StockRepository;
import com.avi.webflux6.stocktrading.repository.StockWebFluxRepository;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
@Slf4j
@AllArgsConstructor
public class StockService {

	@Autowired
	private MongoOperations mongo;
	
	@Autowired
	private StockWebFluxRepository stockWebFluxRepo;
	
	public Mono<StockResponse> getWebFluxOneStock(String id) {
		return stockWebFluxRepo.findById(id).map(
				StockResponse::fromModel
				).switchIfEmpty(
						Mono.error(
								new StockNotFoundException(
										"Stock not found id: "+id)))
				.doFirst(() -> log.info("warning"))
				.doOnNext(stock -> log.info("Stock found: {}", stock))
                .doOnError(ex -> log.error("Something went wrong while retrieving the stock with id: {}", id, ex))
                .doOnTerminate(() -> log.info("Finalized retrieving stock"))
                .doFinally(signalType -> log.info("Finalized retrieving stock with signal type: {}", signalType));
	}
	
	public Flux<StockResponse> getWebFluxAllStock(BigDecimal priceGeaterThan) {
		return stockWebFluxRepo.findAll()
				.filter(stock->stock.getPrice().compareTo(priceGeaterThan)>0)
				.map(StockResponse::fromModel)
				.doFirst(() -> log.info("Retrieving all stocks"))
                .doOnNext(stock -> log.info("Stock found: {}", stock))
                .doOnError(ex -> log.warn("Something went wrong while retrieving the stocks", ex))
                .doOnTerminate(() -> log.info("Finalized retrieving stocks"))
                .doFinally(signalType -> log.info("Finalized retrieving stock with signal type: {}", signalType));
	}
	
	public Mono<StockResponse> createWebFluxStock(StockRequest stockRequest){
	
		return Mono.just(stockRequest)
				.map(StockRequest::toModel)
				.flatMap(stock->stockWebFluxRepo.save(stock))
				.map(StockResponse::fromModel)
				.onErrorMap(ex-> new StockCreationException(ex.getMessage()));
//				.onErrorReturn(StockResponse.builder().build());
		
//		return stockWebFluxRepo.save(stockRequest.toModel())
//				.map(StockResponse::fromModel)
//				;
	}
}
