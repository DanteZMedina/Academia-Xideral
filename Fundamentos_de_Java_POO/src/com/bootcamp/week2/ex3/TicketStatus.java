package com.bootcamp.week2.ex3;

public enum TicketStatus {
	
	OPEN,
	IN_PROGRESS,
	RESOLVED,
	CLOSED;
	
	public boolean canTransitionTo(TicketStatus t) { 
		switch (this) { 
			case OPEN:
				return t == IN_PROGRESS;
			case IN_PROGRESS:
				return t == RESOLVED;
			case RESOLVED:
				return t == CLOSED;
			default:
				return false;
		}
	}

}
