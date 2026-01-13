package com.example.prueba_tickets.models;

import java.time.LocalDateTime;

import com.fasterxml.jackson.annotation.JsonProperty;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Ticket {

    private Long id;

    @NotNull(message = "El tipo de ticket es obligatorio.")
    @JsonProperty("tipo")
    private TicketType type;

    @NotNull(message = "La prioridad manual es obligatoria.")
    @Min(value = 1, message = "La prioridad manual debe ser mínimo 1.")
    @Max(value = 5, message = "La prioridad manual debe ser máximo 5.")
    @JsonProperty("prioridad")
    private Integer manualPriority; // 1 a 5

    @JsonProperty(access = JsonProperty.Access.READ_ONLY)
    private LocalDateTime creationDate = LocalDateTime.now();

    @NotBlank(message = "El usuario es obligatorio.")
    @JsonProperty("usuario")
    private String user;
}
