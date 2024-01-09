package com.avi.webflux6.stocktrading.dto;

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
public class StockResponse {
	private String id;
	@JsonProperty("stockname")
	private String name;
	private int price;
	private String date;
	
	public static StockResponse fromModel(Stock stock) {
		return StockResponse.builder()
				.id(stock.getId())
				.name(stock.getName())
				.price(stock.getPrice())
				.date(stock.getDate()).build();
	}
}
