# ms-catalogo

Microservicio de Catálogo - Biblioteca Digital EDUCA+
Asignatura: Java: Diseño y Construcción de Soluciones Nativas en Nube

## Propósito
Administrar el catálogo de libros y sus categorías: búsqueda por título o autor
y gestión del inventario.

## Tecnologías
- Java 21
- Spring Boot 3.3.0 (Web, Data JPA, Validation)
- MySQL 8
- Maven

## Estructura
```
src/main/java/com/educa/mscatalogo/
├── controller/   Endpoints REST
├── service/      Lógica de negocio
├── repository/   Acceso a datos (Spring Data JPA)
├── model/        Entidades JPA (Categoria, Libro)
└── exception/    Manejo global de errores
```

## Requisitos previos
- JDK 21
- Maven 3.9 o superior
- MySQL 8 en ejecución
- Git

## Cómo ejecutarlo

1. Clonar el repositorio:
```bash
git clone https://github.com/TU-USUARIO/ms-catalogo.git
cd ms-catalogo
```

2. Crear la base de datos en MySQL:
```sql
CREATE DATABASE db_catalogo;
```

3. Editar `src/main/resources/application.properties` y colocar el usuario y
la contraseña de MySQL:
```properties
spring.datasource.username=root
spring.datasource.password=TU_PASSWORD
```

4. Compilar y empaquetar (genera `target/ms-catalogo-1.0.0.jar`):
```bash
mvn clean package
```

5. Ejecutar:
```bash
java -jar target/ms-catalogo-1.0.0.jar
```
También se puede usar `mvn spring-boot:run`. El servicio queda en `http://localhost:8082`.

6. (Opcional) Cargar datos de ejemplo, con la aplicación ya iniciada una vez:
```bash
mysql -u root -p < docs/datos_iniciales.sql
```

## Endpoints

| Método | Ruta | Descripción | Código |
|---|---|---|---|
| GET | `/api/categorias` | Listar categorías | 200 |
| GET | `/api/categorias/{id}` | Obtener una categoría | 200 / 404 |
| POST | `/api/categorias` | Crear categoría | 201 / 400 / 409 |
| PUT | `/api/categorias/{id}` | Actualizar categoría | 200 / 400 / 404 |
| DELETE | `/api/categorias/{id}` | Eliminar categoría | 204 / 404 |
| GET | `/api/libros` | Listar libros | 200 |
| GET | `/api/libros/{id}` | Obtener un libro | 200 / 404 |
| GET | `/api/libros/buscar?texto=` | Buscar por título o autor | 200 |
| GET | `/api/libros/categoria/{id}` | Libros de una categoría | 200 / 404 |
| POST | `/api/libros` | Crear libro | 201 / 400 / 404 |
| PUT | `/api/libros/{id}` | Actualizar libro | 200 / 400 / 404 |
| DELETE | `/api/libros/{id}` | Eliminar libro | 204 / 404 |

### Ejemplo: crear un libro
```json
POST /api/libros
{
  "titulo": "Dune",
  "autor": "Frank Herbert",
  "stock": 6,
  "categoria": { "id": 1 }
}
```

## Modelo de datos
Una `Categoria` tiene muchos `Libro` (`@OneToMany`) y cada `Libro` pertenece a
una `Categoria` (`@ManyToOne`, clave foránea `categoria_id`).

## Control de versiones
Ramas: `main` (versión estable), `develop` (integración) y `feature/*`
(cada funcionalidad), integradas mediante Pull Request.