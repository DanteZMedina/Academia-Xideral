package com.bootcamp.week2.ex1.v2;

public class BankAccount {
	
	private double balance;
	private boolean locked; 
	
	public BankAccount(double initialBalance ) { 
		this.balance = initialBalance;
		this.locked = false; 
	}
	
	public double getBalance() { 
		return balance;
	}
	
	public void deposit(double amount ) { 
		//TODO si amount <= 0 lanzar InvalidAmountException
		//TODO: sumar al balance
		if (amount <= 0) { 
			throw new InvalidAmountException ("Monto invalido: ");
		}
		balance += amount;
	}
	
	public void withdraw(double amount) throws InsufficientBalanceException {
		//TODO: Si amount > balance lanzar InsufficientBalanceException con deficit
		//TODO: restar del balance
	    if (amount <= 0) {
	        throw new InvalidAmountException("Monto invalido: " + amount);
	    }

	    if (amount > balance) {
	        double deficit = amount - balance;
	        throw new InsufficientBalanceException(
	            String.format("Fondos insuficientes para retirar $%.2f", amount),
	            deficit
	        );
	    }

	    balance -= amount;
		
	}
	
	public void transfer (BankAccount target, double amount) throws InsufficientBalanceException { 
		//TODO: Usar try-with-resources con TransactionLog
		//dentro: withdraw, target.deposit, log ambas operaciones
	    try (TransactionLog log = new TransactionLog()) {

	        this.withdraw(amount);
	        log.log(String.format(
	            "Retiro de $%.2f de cuenta origen. Saldo: $%.2f",
	            amount, this.balance
	        ));

	        target.deposit(amount);
	        log.log(String.format(
	            "Deposito de $%.2f en cuenta destino. Saldo: $%.2f",
	            amount, target.balance
	        ));
	    }
		
	}
	

	

}
