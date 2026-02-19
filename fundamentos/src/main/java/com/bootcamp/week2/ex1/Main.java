package com.bootcamp.week2.ex1;

public class Main {

	public static void main(String[] args) {
		
		BankAccount cliente1 = new BankAccount ("Dante" , 2500);
		BankAccount cliente2 = new BankAccount ("Zoe" , 2500);
		
		cliente1.transfer(cliente2, 5000);
		
		System.out.println("Disponible en cuenta de " + cliente1.getOwner() + " $"+ cliente1.getBalance());
		System.out.println("Disponible en cuenta de " + cliente2.getOwner() + " $"+ cliente2.getBalance());

	}

}
