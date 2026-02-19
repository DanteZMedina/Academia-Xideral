package com.bootcamp.week2.ex2;

public class Main {
    public static void main(String[] args) {
        SimpleStack<Integer> stack = new SimpleStack<>();

        stack.push(1);
        stack.push(2);
        stack.push(3);

        System.out.println(stack.peek()); // 3

        for (int n : stack) {
            System.out.println(n);
        }

        System.out.println(stack.pop()); // 3
        System.out.println(stack.pop()); // 2
    }
}