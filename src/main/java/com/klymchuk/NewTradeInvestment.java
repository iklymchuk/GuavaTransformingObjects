package com.klymchuk;

import java.math.BigDecimal;

import com.google.common.base.Objects;

public class NewTradeInvestment {
	
	private String key;
	private String name;
	private BigDecimal price;
	
	public String getKey() {
		return key;
	}
	public void setKey(String key) {
		this.key = key;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public BigDecimal getPrice() {
		return price;
	}
	public void setPrice(BigDecimal price) {
		this.price = price;
	}
	@Override
	public String toString() {
		return Objects.toStringHelper(this)
				.add("key", key)
				.add("name", name)
				.add("price", price)
				.toString();	
	}
	
	

}
