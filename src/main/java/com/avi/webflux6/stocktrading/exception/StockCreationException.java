package com.avi.webflux6.stocktrading.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ProblemDetail;
import org.springframework.web.bind.annotation.GetMapping;

import lombok.AllArgsConstructor;

public class StockCreationException extends RuntimeException {
	
	public StockCreationException(String message) {
		super(message);
	}
	
	public ProblemDetail asProblemDetail() {
		ProblemDetail problemDetail = 
				ProblemDetail.forStatusAndDetail(
						HttpStatus.BAD_REQUEST, getMessage());
	problemDetail.setTitle("Unable to create stock");
	return problemDetail;
	}
}
