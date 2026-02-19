package com.bootcamp.week2.ex1.v2;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		BankAccount cuenta1 = new BankAccount(1000.00);
		BankAccount cuenta2 = new BankAccount(500.00);
		
		// Operaciones validas
		
		try { 
			cuenta1.deposit(500);
			System.out.printf("Deposito exitoso. Saldo: $%.2f%n", cuenta1.getBalance());
			
			cuenta1.withdraw(200);
			System.out.printf("Retiro exitoso. Saldo: $%.2f%n", cuenta1.getBalance());
			
			cuenta1.transfer(cuenta2, 300);
			System.out.printf("Transferencia exitosa. saldo cuenta1: $%.2f, cuenta2:"
					+ "$%.2f%n", cuenta1.getBalance(), cuenta2.getBalance());
		}
		catch (InsufficientBalanceException e) { 
			System.out.println("Error: " + e.getMessage());
		}
		
		System.out.println("\n=== Manejo de Errores ===");
		
		//TODO: Multi-catch para monto invalido
		try { 
			cuenta1.deposit(-100);
		}
		catch (InvalidAmountException e) { 
			System.out.println("Error: " + e.getMessage());
		}
		
		//TODO: Fondos insuficientes con deficit
		try { 
			cuenta1.withdraw(999999);
		}
		catch (InsufficientBalanceException e) {
            System.out.printf("Error: %s (deficit: $%.2f)%n",
                e.getMessage(), e.getDeficit());
		}

	}

}
