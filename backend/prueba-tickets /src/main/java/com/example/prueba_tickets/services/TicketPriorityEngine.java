package com.example.prueba_tickets.services;

import com.example.prueba_tickets.models.Ticket;
import com.example.prueba_tickets.services.rules.PriorityRule;

import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class TicketPriorityEngine {

    private final List<PriorityRule> rules;

    public TicketPriorityEngine(List<PriorityRule> rules) {
        this.rules = rules;
    }

    public int calculate(Ticket ticket) {
        return rules.stream()
                .mapToInt(rule -> rule.apply(ticket))
                .sum();
    }
}
