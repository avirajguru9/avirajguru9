package com.avi.webflux6.stocktrading.dto;

import java.math.BigDecimal;

import com.avi.webflux6.stocktrading.model.Stock;
import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class StockRequest {

	@JsonProperty("stockname")
	private String name;
	private BigDecimal price;
	private String date;
	
	public Stock toModel() {
		return Stock.builder()
				.name(this.name)
				.price(this.price)
				.date(this.date).build();
	}
}
