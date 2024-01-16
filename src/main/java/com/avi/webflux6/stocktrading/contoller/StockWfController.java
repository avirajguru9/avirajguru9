package com.avi.webflux6.stocktrading.contoller;

import java.math.BigDecimal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.avi.webflux6.stocktrading.dto.StockRequest;
import com.avi.webflux6.stocktrading.dto.StockResponse;
import com.avi.webflux6.stocktrading.model.Stock;
import com.avi.webflux6.stocktrading.service.StockService;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/stockwf")
public class StockWfController {
	@Autowired
	private StockService stockService;
	
	@GetMapping("getonestock/{id}")
	public Mono<StockResponse> getOneStock(@PathVariable String id){
		return this.stockService.getWebFluxOneStock(id);
	}
	@GetMapping("getallstock")
	public Flux<StockResponse> getAllStock(
			@RequestParam(required = false, defaultValue = "0") 
			BigDecimal priceGeaterThan
	){
		return this.stockService.getWebFluxAllStock(priceGeaterThan);
	}
	
	@PostMapping("addstock")
	public Mono<StockResponse> addStock(@RequestBody StockRequest stock){
		return this.stockService.createWebFluxStock(stock);
	}
}
