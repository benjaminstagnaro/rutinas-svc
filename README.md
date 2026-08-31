# Rutinas — Microservicio rutinas

Microservicio correspondiente al **caso caso15 — FitLife** (una plataforma de entrenamiento y bienestar) de la Evaluación Parcial N°1.

| | |
|---|---|
| Asignatura | JVY0101 — Java: Diseño y Construcción de Soluciones Nativas en Nube |
| Stack | Spring Boot 3.3 · Java 21 · Maven · Spring Data JPA · H2 · springdoc-openapi |
| Calidad | JaCoCo cobertura LINE 100% · Cucumber (BDD) alineado a endpoints REST |
| Entrega | Docker / Docker Compose |

## Responsabilidad (SRP)

administra los datos y la lógica del dominio de Rutinas del caso caso15 (FitLife). Su base de datos es una **H2 en memoria** (un solo microservicio por base), cumpliendo aislamiento de datos por dominio.

## Página de presentación

Al ejecutar el servicio, `http://localhost:8080/` muestra la página de presentación del microservicio con documentación y enlaces a:

- **Swagger UI**: `/swagger-ui/index.html`
- **OpenAPI (yaml)**: `/v3/api-docs.yaml`
- **ReDoc**: `/redoc.html`
- **H2 Console**: `/h2-console`

## Endpoints

| Método | Ruta | Descripción |
|--------|------|-------------|
| GET | /api/rutinas | Lista todos los recursos |
| GET | /api/rutinas/{id} | Obtiene un recurso por id |
| POST | /api/rutinas | Crea un recurso |
| PUT | /api/rutinas/{id} | Actualiza un recurso |
| DELETE | /api/rutinas/{id} | Elimina un recurso |

## Documentación del proyecto

La documentación completa está en la carpeta [`docs/`](docs/):

- [`docs/00_Resumen.md`](docs/00_Resumen.md) — propósito, responsabilidad y tecnologías
- [`docs/01_Arquitectura.md`](docs/01_Arquitectura.md) — componentes, arquitectura y patrones
- [`docs/02_API.md`](docs/02_API.md) — contrato REST y ejemplos curl
- [`docs/03_Pruebas.md`](docs/03_Pruebas.md) — tests unitarios, cobertura y Cucumber
- [`docs/04_Despliegue.md`](docs/04_Despliegue.md)
- [`docs/05_Justificacion.md`](docs/05_Justificacion.md) — justificación del servicio: RF/RNF/seguridad cubiertos, stack y por qué cada tecnología AWS
- [`docs/diagramas/`](docs/diagramas/) — C4 (contexto, contenedores, componentes), secuencia e infraestructura AWS — Docker, Docker Compose e integración

## Cómo ejecutar locmente

```bash
mvn spring-boot:run
```

## Cómo ejecutar con Docker

```bash
docker compose up --build
# http://localhost:8080
```

## Cómo ejecutar las pruebas

```bash
mvn test      # unit tests + Cucumber
mvn verify    # + verificación de cobertura JaCoCo (100% LINE, falla si baja)
```





## Modelo de ramificación

**Modelo elegido: GitFlow.**

Se eligió GitFlow porque permite mantener una estructura ordenada entre el desarrollo y las versiones estables del proyecto. La rama `develop` se utilizará para integrar los cambios realizados mediante ramas `feature/`, mientras que `main` contendrá las versiones estables y listas para entregar. Además, las ramas `hotfix/` permitirán solucionar errores importantes sin afectar directamente el desarrollo de nuevas funcionalidades.

| Modelo      | Cómo funciona                        | Ideal para                                   |
| ----------- | ------------------------------------ | -------------------------------------------- |
| GitFlow     | main + develop + feature/ + hotfix/  | proyectos con entregas planificadas por hito |
| GitHub Flow | solo main + feature/ + PR            | despliegue continuo, equipos chicos          |
| Trunk-based | rama única + ramas de vida muy corta | entrega continua                             |

## Convenciones de trabajo

**Commits:** `tipo(alcance): descripcion`, utilizando minúsculas y sin tildes. Los tipos principales serán `feat`, `fix`, `docs` y `chore`.

**Naming de ramas:** se utilizará `feature/<nombre-corto>` para nuevas funcionalidades y `hotfix/<nombre-corto>` para correcciones urgentes.

**Flujo de merge:** todos los cambios deberán ingresar mediante un Pull Request. No se realizarán `push` directamente a `main` ni `develop`. Antes de fusionar un Pull Request se realizará una revisión del propio cambio y, una vez completado el merge, se eliminará la rama utilizada.
