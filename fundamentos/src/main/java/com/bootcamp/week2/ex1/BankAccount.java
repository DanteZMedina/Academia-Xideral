package com.bootcamp.week2.ex1;

public class BankAccount {
	
	private double balance; 
	private String owner; 
	
	public BankAccount (String owner, double initialBalance) { 
		this.owner = owner;
		this.balance = initialBalance;
	}
	
	public String getOwner() {
	    return owner;
	}
	
	public double getBalance() { 
		return balance;
	}
	
	public void deposit (double amt) { 
		if (amt <= 0 ) { 
			throw new InvalidAmountException ("La cantidad debe ser positiva");
		}
		balance += amt;
	}
	
	public void withdraw (double amt) throws InsufficientBalanceException { 
		if (amt <= 0 ) { 
			//uncheked 
			throw new InvalidAmountException("La cantidad debe ser positiva");
		}
		if (balance < amt) {
			//checked
	        throw new InsufficientBalanceException(amt - balance);
	    }
		balance -= amt;
	}
	
	public void transfer (BankAccount target, double amt) { 
		
		try (TransactionLog log = new TransactionLog()) { 
			this.withdraw(amt);
			target.deposit(amt);
			
			log.log("Transerencia de: " + owner + "Completada") ;
		}
		catch (InsufficientBalanceException e) { 
			System.out.println(e.getMessage());
		}
	}
	
	
	
	
	
	
	

}
