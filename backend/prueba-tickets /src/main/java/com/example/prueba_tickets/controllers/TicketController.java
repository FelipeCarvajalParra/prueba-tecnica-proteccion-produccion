package com.example.prueba_tickets.controllers;

import com.example.prueba_tickets.models.Ticket;
import com.example.prueba_tickets.services.TicketService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/tickets")
public class TicketController {

    private final TicketService service;

    public TicketController(TicketService service) {
        this.service = service;
    }

    //crear solicitud
    @PostMapping
    public ResponseEntity<Ticket> create(@Valid @RequestBody Ticket ticket) {
        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(service.create(ticket));
    }

    //listar todas (sin logica de prioridad)
    @GetMapping
    public ResponseEntity<List<Ticket>> findAll() {
        return ResponseEntity.ok(service.findAll());
    }

    //listar pr prioridad calculada
    @GetMapping("/prioridad")
    public ResponseEntity<List<Ticket>> findAllByPriority() {
        return ResponseEntity.ok(service.findAllOrderedByPriority());
    }
}
