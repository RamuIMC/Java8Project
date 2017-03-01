package com.project.chapter6;

public class Transaction {
	
	private String currency;
	private String name;
	private int value;
	
	
	public Transaction() {
		
	}
	
	
	public Transaction(String currency, String name, int value) {
		//super();
		this.currency = currency;
		this.name = name;
		this.value = value;
	}


	public String getCurrency() {
		return currency;
	}
	public void setCurrency(String currency) {
		this.currency = currency;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getValue() {
		return value;
	}
	public void setValue(int value) {
		this.value = value;
	}
	
	
	
		

}
