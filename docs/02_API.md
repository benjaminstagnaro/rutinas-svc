# Rutinas — Contrato de la API REST

## Base

- **Base path**: /api/rutinas
- **Formato**: JSON — **Puerto**: 8080 (configurable con `PORT`)

## Recursos

| Método | Ruta | Códigos de estado | Descripción |
|--------|------|-------------------|-------------|
| GET | /api/rutinas | 200 | Lista todos los recursos |
| GET | /api/rutinas/{id} | 200 / 404 | Obtiene un recurso por id |
| POST | /api/rutinas | 201 / 400 | Crea un recurso |
| PUT | /api/rutinas/{id} | 200 / 404 / 400 | Actualiza un recurso |
| DELETE | /api/rutinas/{id} | 204 / 404 | Elimina un recurso |

## Atributos de un recurso

| Campo | Tipo | Obligatorio | Descripción |
|-------|------|-------------|-------------|
| id | Long | - | Identificador autogenerado |
| nombre | String | Sí | Nombre del recurso |

| nivel | String | No | Nivel de dificultad (básico, medio, alto) |
| duracionMin | BigDecimal | No | Duración estimada en minutos |

## Ejemplos con curl

```bash
# Listar
curl http://localhost:8080/api/rutinas

# Crear
curl -X POST http://localhost:8080/api/rutinas \
  -H "Content-Type: application/json" \
  -d '{"nombre":"Mi recurso"}'

# Obtener por id
curl http://localhost:8080/api/rutinas/1

# Actualizar
curl -X PUT http://localhost:8080/api/rutinas/1 \
  -H "Content-Type: application/json" \
  -d '{"nombre":"Recurso actualizado"}'

# Eliminar
curl -X DELETE http://localhost:8080/api/rutinas/1
```
