package com.bootcamp.week2.ex3;

public class Main {

	public static void main(String[] args) {
		TicketDashboard dashboard = new TicketDashboard();
		
		dashboard.addTicket(TicketStatus.OPEN, Priority.CRITICAL);
		dashboard.addTicket(TicketStatus.OPEN, Priority.HIGH);
		dashboard.addTicket(TicketStatus.RESOLVED, Priority.LOW);
		dashboard.addTicket(TicketStatus.IN_PROGRESS, Priority.MEDIUM);
		dashboard.addTicket(TicketStatus.CLOSED, Priority.HIGH);
		
		dashboard.printDashboard();
		
		System.out.println(
				dashboard.isActive(TicketStatus.OPEN));

	}

}
