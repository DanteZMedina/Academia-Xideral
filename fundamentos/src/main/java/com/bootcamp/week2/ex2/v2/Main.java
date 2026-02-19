package com.bootcamp.week2.ex2.v2;

import java.util.NoSuchElementException;

public class Main {

	public static void main(String[] args) {
		
		SimpleStack<Integer> stack = new SimpleStack<>();
		
		System.out.println("=== Stack de Enteros ===");
		stack.push(10);
		stack.push(20);
		stack.push(30);
		System.out.println("Despues de push 10, 20, 30: " + stack);
		System.out.println("Peek: " + stack.peek());
		System.out.println("Size: " + stack.size());
		
		System.out.print("Iterando (LIFO): ");
		for (Integer n : stack) {
			System.out.print(n + " ");
		}
		System.out.println();
		
		System.out.println("Pop: " + stack.pop());
        System.out.println("Pop: " + stack.pop());
        System.out.println("Peek despues de pops: " + stack.peek());
        System.out.println("Size: " + stack.size());

        System.out.println("\n=== Stack de Strings ===");
        SimpleStack<String> palabras = new SimpleStack<>();
        palabras.push("Hola");
        palabras.push("Mundo");
        palabras.push("Java");

        System.out.print("For-each: ");
        for (String s : palabras) {
            System.out.print(s + " ");
        }
        System.out.println();

        System.out.println("\n=== Error: pop en stack vacio ===");
        SimpleStack<Integer> vacio = new SimpleStack<>();
        try {
            vacio.pop();
        } catch (NoSuchElementException e) {
            System.out.println("Error: " + e.getMessage());
        }

	}

}
