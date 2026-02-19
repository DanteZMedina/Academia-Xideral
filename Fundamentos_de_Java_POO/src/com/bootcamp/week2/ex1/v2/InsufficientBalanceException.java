package com.bootcamp.week2.ex1.v2;

public class InsufficientBalanceException extends Exception {
	
	private final double deficit; 
	//TODO: Constructor con mensaje y deficit
	
	public InsufficientBalanceException(String message, double deficit) {
		super(message);
		this.deficit = deficit;
	}
	
	public double getDeficit() {
		return deficit;
	}

}
