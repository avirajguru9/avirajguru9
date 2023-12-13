package com.avi.webflux6.stocktrading.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.stereotype.Service;

@Service
public class StockService {

	@Autowired
	private MongoOperations mongo;
}
