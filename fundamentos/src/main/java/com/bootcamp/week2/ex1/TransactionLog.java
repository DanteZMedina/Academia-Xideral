package com.bootcamp.week2.ex1;

public class TransactionLog implements AutoCloseable {

	public void log (String message) { 
		System.out.println("Log:" + message);
	}
	
	@Override 
	public void close() { 
		System.out.println("Transaction log closed");
	}
}
