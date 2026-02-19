package com.bootcamp.week2.ex3;

public enum Priority {
	
	LOW ( 1, 48),
	MEDIUM ( 2, 24 ),
	HIGH (3, 8), 
	CRITICAL ( 4, 1 );
	
	private final int level; 
	private final int responseTimeHours;
	
	Priority (int level, int responseTimeHours) { 
		this.level = level;
		this.responseTimeHours = responseTimeHours;
	}
	
	public String getLabel() { 
		return name() + " (Nivel " + level + ")";
	}
	
	public int getResponseTimeHours() { 
		return responseTimeHours;
	}

}
