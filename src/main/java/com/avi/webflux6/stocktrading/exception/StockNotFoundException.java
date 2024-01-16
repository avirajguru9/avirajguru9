package com.avi.webflux6.stocktrading.exception;

public class StockNotFoundException extends RuntimeException {
	public StockNotFoundException(String message) {
		super(message);
	}
}
