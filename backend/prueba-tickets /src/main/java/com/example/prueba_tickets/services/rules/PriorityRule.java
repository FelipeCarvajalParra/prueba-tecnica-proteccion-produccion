package com.example.prueba_tickets.services.rules;

import com.example.prueba_tickets.models.Ticket;

public interface PriorityRule {
    int apply(Ticket ticket);
}
