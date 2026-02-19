package com.bootcamp.week2.ex3.v2;

public class Ticket {

	private final int id;
    private final String description;
    private final Priority priority;
    private TicketStatus status;

    public Ticket(int id, String description, Priority priority) {
        this.id = id;
        this.description = description;
        this.priority = priority;
        this.status = TicketStatus.OPEN;
    }

    public void transitionTo(TicketStatus newStatus) {
        // TODO: validar con canTransitionTo, cambiar o imprimir error
    	if (status.canTransitionTo(newStatus)) { 
    		this.status = newStatus;
    		System.out.printf("Ticket %d transiciono a %s%n", id, newStatus);
    	}
    	else { 
    		System.out.printf("Transicion invalida: %s -> %s%n", status, newStatus);
    	}
    }

    // TODO: getters
    public int getId() { return id; }
    public Priority getPriority() { return priority; }
    public TicketStatus getStatus() { return status; }

    @Override
    public String toString() {
        return String.format("Ticket{id=%d, desc='%s', priority=%s, status=%s}",
            id, description, priority.getLabel(), status);
    }
	
}
