package com.bootcamp.week2.ex6;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class EventBus {
    // Map de EventType a lista de handlers
    private final Map<EventType, List<EventHandler>> listeners = new HashMap<>();
    
    public EventBus() { 
        // Inicializar lista vacía para cada EventType
        for (EventType type : EventType.values()) { 
            listeners.put(type, new ArrayList<>());
        }
    }

    public void subscribe(EventType type, EventHandler handler) {
        listeners.get(type).add(handler);
    }

    public void publish(EventType type, String data) { 
        System.out.printf("[BUS] Publicando %s%n", type);
        //TODO: ejecutar todos los handlers del tipo
        listeners.get(type).forEach(handler -> handler.handle(data));
    }
}
