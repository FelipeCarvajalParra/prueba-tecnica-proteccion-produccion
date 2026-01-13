# Prueba-Tickets

Backend desarrollado en Java con Spring Boot para la gestión de tickets con priorización automática.

---

## Descripción

El proyecto `prueba-tickets` permite:

- Crear tickets con tipo, prioridad manual y usuario.
- Calcular automáticamente la prioridad final de cada ticket mediante un motor desacoplado con reglas independientes.
- Listar tickets en orden de creación o según la prioridad calculada.
- Gestionar tickets completamente en memoria, sin necesidad de base de datos.

El motor de priorización aplica reglas independientes, incluyendo:

- **ManualPriorityRule:** considera la prioridad asignada manualmente.
- **TypePriorityRule:** asigna peso según el tipo de ticket (INCIDENTE, REQUERIMIENTO, CONSULTA).
- **AgePriorityRule:** incrementa la prioridad de tickets antiguos.

---

## Estructura del Proyecto

```
prueba-tickets
├── controllers          # Endpoints REST y manejo de excepciones
├── models               # Modelos de datos: Ticket, TicketType
├── repositories         # Almacenamiento en memoria de tickets
├── services             # Lógica de negocio y motor de priorización
│   └── rules            # Reglas de prioridad independientes
├── resources
│   └── application.properties
├── pom.xml              # Dependencias y configuración de Maven
└── README.md
```

---

## Endpoints

| Método | Ruta                     | Descripción |
|--------|--------------------------|-------------|
| POST   | `/tickets`               | Crear un ticket. Devuelve el ticket con `creationDate` automático. |
| GET    | `/tickets`               | Listar todos los tickets. |
| GET    | `/tickets/prioridad`     | Listar tickets ordenados por prioridad calculada. |

### Ejemplo de request (POST /tickets)

```json
{
  "tipo": "INCIDENTE",
  "prioridad": 3,
  "usuario": "Juan Pérez"
}
```

### Ejemplo de respuesta

```json
{
  "id": 1,
  "tipo": "INCIDENTE",
  "prioridad": 3,
  "creationDate": "2026-01-13T14:37:41.123",
  "usuario": "Juan Pérez"
}
```

### Mensajes de validación

Si los datos son inválidos, la API devuelve mensajes claros en español, por ejemplo:

```json
{
  "manualPriority": "La prioridad manual debe ser máximo 5.",
  "user": "El usuario es obligatorio."
}
```

---

## Requisitos

- Java 17
- Maven 4.x
- Spring Boot 4.0.x

---

## Instalación

1. Clonar el repositorio:

```bash
git clone https://github.com/tu-usuario/prueba-tickets.git
cd prueba-tickets
```

2. Compilar con Maven:

```bash
mvn clean package
```

3. Ejecutar:

```bash
java -jar target/prueba-tickets-0.0.1-SNAPSHOT.jar
```

---

