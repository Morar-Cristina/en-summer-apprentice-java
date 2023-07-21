package com.practica.demo.models;

import jakarta.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "event_type")
public class EventType implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "event_type_id")
    private int eventTypeId;

    @Column(name = "event_type_name", length = 30, unique = true)
    private String eventTypeName;

    public EventType() {
    }

    public int getEventTypeId() {
        return eventTypeId;
    }

    public void setEventTypeId(int eventTypeId) {
        this.eventTypeId = eventTypeId;
    }

    public String getEventTypeName() {
        return eventTypeName;
    }

    public void setEventTypeName(String eventTypeName) {
        this.eventTypeName = eventTypeName;
    }
}
