package com.avi.webflux6.stocktrading.contoller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.config.ConfigDataResourceNotFoundException;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.io.*;
import java.lang.reflect.Array;
import java.net.URI;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import com.avi.webflux6.stocktrading.entity.Stock;
import com.avi.webflux6.stocktrading.repository.StockRepository;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

//@CrossOrigin(origins="http://localhost:4200")
//@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/stock")
public class StockController {
	
	@Autowired
	private StockRepository stockRepo;
	
	private final RestTemplate restTemplate;

    @Autowired
    public StockController(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }	
	
	@GetMapping("/{id}")
	public Mono<Stock> getOneStock(@PathVariable String id){
		 //return Mono.just(Stock.builder().Id("Stock - "+id).build());
		return null;
	}
	
	@PostMapping("addstock")
	public Object addStock(@RequestBody Stock stock){
		Stock save = this.stockRepo.save(stock);
//		URI location = ServletUriComponentsBuilder.fromCurrentContextPath().path("/stocks/getstock/{id}").buildAndExpand(save.getId()).toUri();
		return this.getStock(save.getId());
		//URI location = ServletUriComponentsBuilder.fromRequestUri(this.getStock(save.getId())).path("/{id}").buildAndExpand(save.getId()).toUri();
		//return ResponseEntity.created(location).body(stockRepo);
//		ResponseEntity<?> responseEntity = restTemplate.getForEntity(location, String.class);		
//		return responseEntity.getBody();
	}
	
	@PutMapping("updatestock/{id}")
	public ResponseEntity<Stock> updateStock(@PathVariable String id, @RequestBody Stock stockDetails){
		Stock updateStock = stockRepo.findById(id).orElseThrow(()-> new NoSuchElementException ("Stock not fund with id"+id));
		updateStock.setName(stockDetails.getName());
		updateStock.setPrice(stockDetails.getPrice());
		updateStock.setDate(stockDetails.getDate());	
		this.stockRepo.save(updateStock);
		return ResponseEntity.ok(updateStock);
	}
	
	@PatchMapping("updateprice/{id}")
	public ResponseEntity<Stock> updateStockPrice(@PathVariable String id, @RequestParam("price") int price){
		Stock updateStock = stockRepo.findById(id).orElseThrow(()-> new NoSuchElementException ("Stock not fund with id"+id));
		updateStock.setPrice(price);
		this.stockRepo.save(updateStock);
		return ResponseEntity.ok(updateStock);
	}
	
	@GetMapping("getallstock")
	public List<Stock> getAllStock(){
		return stockRepo.findAll();
	}
	
	@GetMapping("getstock/{id}")
	public Optional<Stock> getStock(@PathVariable String id){
		return stockRepo.findById(id);
	}
	
	@DeleteMapping("deletestock/{id}")
	public void deleteStock(@PathVariable String id){
		stockRepo.deleteById(id);
	}
}
