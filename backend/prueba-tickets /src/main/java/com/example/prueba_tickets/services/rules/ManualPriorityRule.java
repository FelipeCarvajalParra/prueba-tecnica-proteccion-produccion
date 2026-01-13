package com.example.prueba_tickets.services.rules;

import com.example.prueba_tickets.models.Ticket;
import org.springframework.stereotype.Component;

@Component
public class ManualPriorityRule implements PriorityRule {

    @Override
    public int apply(Ticket ticket) {
        return ticket.getManualPriority();
    }
}
