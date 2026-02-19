package com.bootcamp.week2.ex1;

public class InsufficientBalanceException extends Exception {
	
	private final double deficit;
	
	public InsufficientBalanceException(double deficit) { 
		super ("Saldo insuficiente. Faltan: " + deficit);
		this.deficit = deficit;
	}
	
	public double getDeficit() { 
		return deficit;
	}

}
