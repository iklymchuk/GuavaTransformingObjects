package com.klymchuk;

import com.google.common.base.Objects;

public class OldTradeInvestment {
	
	private int oldKey;
	private String oldName;
	private double oldPrice;
	
	public OldTradeInvestment(int oldKey, String oldName, double oldPrice) {
		super();
		this.oldKey = oldKey;
		this.oldName = oldName;
		this.oldPrice = oldPrice;
	}

	public int getOldKey() {
		return oldKey;
	}

	public void setOldKey(int oldKey) {
		this.oldKey = oldKey;
	}

	public String getOldName() {
		return oldName;
	}

	public void setOldName(String oldName) {
		this.oldName = oldName;
	}

	public double getOldPrice() {
		return oldPrice;
	}

	public void setOldPrice(double oldPrice) {
		this.oldPrice = oldPrice;
	}
	
	@Override
	public String toString() {
		return Objects.toStringHelper(this)
				.add("oldKey", oldKey)
				.add("oldName", oldName)
				.add("oldPrice", oldPrice)
				.toString();	
	}

}
