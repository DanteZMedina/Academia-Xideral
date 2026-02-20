package com.bootcamp.week2.ex5;

enum Size {
    SMALL (8.99),
    MEDIUM(12.99),
    LARGE(16.99);
    
    private final double basePrice;
    
    Size (double baseprice ) { 
        this.basePrice = baseprice;
    }

    public double getBasePrice() { 
        return basePrice;
    }
}
