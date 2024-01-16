package com.avi.webflux6.stocktrading.model;

import java.math.BigDecimal;
import java.time.LocalDate;

import org.springframework.data.mongodb.core.mapping.Document;

import com.mongodb.lang.NonNull;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@Builder
@NoArgsConstructor
@Document("stock")
public class Stock {
	private String id;
	
	@NonNull
	private String name;
	
	@NonNull
	private BigDecimal price;
	private String date;
	/*
	 * public String getName() { return name; } public void setName(String name) {
	 * this.name = name; } public String getId() { return id; } public void
	 * setId(String id) { this.id = id; } public BigDecimal getPrice() { return
	 * price; } public void setPrice(int price) { this.price = price; } public
	 * String getDate() { return date; } public void setDate(String date) {
	 * this.date = date; }
	 */
}
