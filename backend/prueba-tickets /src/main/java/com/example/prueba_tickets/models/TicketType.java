package com.example.prueba_tickets.models;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;

public enum TicketType {

    INCIDENT("INCIDENTE"),
    REQUEST("REQUERIMIENTO"),
    QUERY("CONSULTA");

    private final String jsonValue;

    TicketType(String jsonValue) {
        this.jsonValue = jsonValue;
    }

    @JsonValue
    public String toJson() {
        return jsonValue;
    }

    @JsonCreator
    public static TicketType fromJson(String value) {
        for (TicketType type : values()) {
            if (type.jsonValue.equalsIgnoreCase(value)) {
                return type;
            }
        }
        throw new IllegalArgumentException("Tipo de ticket invalido: " + value);
    }
}
