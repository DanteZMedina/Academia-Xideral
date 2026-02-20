package com.bootcamp.week2.ex6;

public class EmailStrategy implements NotificationStrategy{

    @Override
    public void send( String message) { 
        System.out.println("[Email] Enviando: " + message);
    }
}
