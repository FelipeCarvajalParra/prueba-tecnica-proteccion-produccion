package com.example.prueba_tickets.services.rules;

import com.example.prueba_tickets.models.Ticket;
import org.springframework.stereotype.Component;

@Component
public class TypePriorityRule implements PriorityRule {

    @Override
    public int apply(Ticket ticket) {
        return switch (ticket.getType()) {
            case INCIDENT -> 5;
            case REQUEST -> 3;
            case QUERY -> 1;
        };
    }
}
