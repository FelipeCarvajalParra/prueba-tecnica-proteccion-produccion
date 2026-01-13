package com.example.prueba_tickets.repositories;

import com.example.prueba_tickets.models.Ticket;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;

@Repository
public class TicketRepository {

    private final List<Ticket> tickets = new ArrayList<>();
    private final AtomicLong sequence = new AtomicLong(1);

    public Ticket save(Ticket ticket) {
        ticket.setId(sequence.getAndIncrement());
        tickets.add(ticket);
        return ticket;
    }

    public List<Ticket> findAll() {
        return new ArrayList<>(tickets);
    }

    public void clear() {
        tickets.clear();
        sequence.set(1);
    }
}
