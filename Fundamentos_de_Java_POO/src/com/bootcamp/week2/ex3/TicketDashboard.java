package com.bootcamp.week2.ex3;

import java.util.EnumMap;
import java.util.EnumSet;

public class TicketDashboard {

	private EnumMap<TicketStatus, Integer> statusCounters = new EnumMap<>(TicketStatus.class);

	private EnumMap<Priority, Integer> priorityCounters = new EnumMap<>(Priority.class);

	private EnumSet<TicketStatus> activeStatuses = EnumSet.of(TicketStatus.OPEN, TicketStatus.IN_PROGRESS);

	public TicketDashboard() {

		for (TicketStatus status : TicketStatus.values()) {
			statusCounters.put(status, 0);
		}

		for (Priority p : Priority.values()) {
			priorityCounters.put(p, 0);
		}
	}

	public void addTicket(TicketStatus status, Priority priority) {
		statusCounters.put(status, statusCounters.get(status) + 1);
		priorityCounters.put(priority, priorityCounters.get(priority) + 1);
	}

	public void printDashboard() {
		System.out.println("=== By Status ===");
		for (TicketStatus s : statusCounters.keySet()) {
			System.out.println(s + ": " + statusCounters.get(s));
		}

		System.out.println("\n=== By Priority ===");
		for (Priority p : priorityCounters.keySet()) {
			System.out.println(p.getLabel() + ": " + priorityCounters.get(p));
		}
	}

	public boolean isActive(TicketStatus status) {
		return activeStatuses.contains(status);
	}
}
