package com.example.prueba_tickets.services.rules;

import com.example.prueba_tickets.models.Ticket;
import org.springframework.stereotype.Component;

import java.time.Duration;
import java.time.LocalDateTime;

@Component
public class AgePriorityRule implements PriorityRule {

    @Override
    public int apply(Ticket ticket) {
        long hoursOld = Duration.between(ticket.getCreationDate(), LocalDateTime.now()).toHours();
        return (int) Math.min(hoursOld, 5); //limite de 5 para no desbalancear 
    }
}
