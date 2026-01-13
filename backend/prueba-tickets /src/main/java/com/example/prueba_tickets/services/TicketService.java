package com.example.prueba_tickets.services;

import com.example.prueba_tickets.models.Ticket;
import com.example.prueba_tickets.repositories.TicketRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Comparator;
import java.util.List;

@Service
public class TicketService {

    private final TicketRepository repository;
    private final TicketPriorityEngine priorityEngine;

    public TicketService(TicketRepository repository, TicketPriorityEngine priorityEngine) {
        this.repository = repository;
        this.priorityEngine = priorityEngine;
    }

    //crear un ticket
    public Ticket create(Ticket ticket) {
        ticket.setCreationDate(LocalDateTime.now());
        return repository.save(ticket);
    }

    //obtener todoss los tickets sin ordenar
    public List<Ticket> findAll() {
        return repository.findAll();
    }

    //obtener todos los tickets ordenados por la prioridard calculada
    public List<Ticket> findAllOrderedByPriority() {
        return repository.findAll()
                .stream()
                .sorted(Comparator.comparingInt(priorityEngine::calculate).reversed())
                .toList();
    }
}

