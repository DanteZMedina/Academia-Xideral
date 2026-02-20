package com.bootcamp.week2.ex5;

abstract class PizzaDecorator implements PizzaOrder{

    protected final PizzaOrder wrapped;
    PizzaDecorator (PizzaOrder wrapped) {
        this.wrapped = wrapped;
    }
    
}
