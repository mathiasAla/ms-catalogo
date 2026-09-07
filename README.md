# ms-catalogo

Microservicio de Catálogo — Biblioteca Digital EDUCA+
Asignatura: Java: Diseño y Construcción de Soluciones Nativas en Nube

## Propósito general
Administrar la búsqueda y el inventario de libros físicos y recursos disponibles.

## Funciones clave
- Buscar libros por título, autor o categoría.
- administrar el inventario 
- consultar la disponibilidad de los ejemplares.

## Interacciones con otros microservicios
Es consultado por ms-préstamos para verificar la disponibilidad y por la app/frontend para realizar búsquedas.

## Justificación del aislamiento
Es el servicio que recibe más consultas, por lo que necesita escalar de forma independiente sin verse afectado por otros procesos como préstamos o autenticación.

## Tecnología
- Java 17 + Spring Boot (Spring Web)
- Maven
- Base de datos: SQL (PostgreSQL) o NoSQL (MongoDB) — según volumen de
  consultas, útil para búsquedas flexibles por categoría/autor
- Comunicación: REST API (vía API Gateway)
- Escalabilidad: múltiples instancias detrás del Service Registry
