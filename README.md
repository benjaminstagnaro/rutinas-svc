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



| Modelo | Cómo funciona | Ideal para |
|--------|----------------|------------|
| GitFlow | main + develop + feature/ + hotfix/ | proyectos con entregas planificadas por hito (como este semestre) |
| GitHub Flow | solo main + feature/ + PR | despliegue continuo, equipos chicos |
| Trunk-based | rama única + ramas de vida muy corta | entrega continua, tronco siempre desplegable |

Dado que el curso pide exactamente ramas `main`, `develop`, `feature/` y `hotfix/`, GitFlow es la opción que calza con lo pedido — Se decidió utilizar la metodología GitFlow debido a que proporciona una estructura de ramas clara y organizada, adecuada para el desarrollo colaborativo del proyecto. Esta metodología permite separar el código estable de producción, representado por la rama main, del código en desarrollo, representado por develop.

Además, GitFlow permite utilizar ramas feature/* para desarrollar funcionalidades de manera independiente, evitando afectar directamente las ramas principales. También contempla ramas release/* para preparar y validar nuevas versiones y ramas hotfix/* para solucionar errores críticos en versiones ya publicadas.

La elección de GitFlow también se relaciona directamente con los requerimientos del curso, que establecen el uso de ramas como main y develop. De esta manera, se mantiene una estrategia de control de versiones ordenada, se facilita el trabajo colaborativo y se permite mantener un historial claro del desarrollo y de las distintas versiones del proyecto.

## Convenciones de trabajo

**Commits** (`tipo(alcance): descripción`, en minúsculas, sin tildes):

| Tipo | Uso | Ejemplo |
|------|-----|---------|
| feat | nueva funcionalidad | `feat(ui): agregar version al header` |
| fix | corrección de bug | `fix(home): eliminar texto duplicado` |
| docs | documentación | `docs: agregar changelog` |
| chore | tareas / CI | `chore(ci): agregar workflow de build` |

**Naming de ramas:** `feature/<nombre-corto>` y `hotfix/<nombre-corto>`, minúsculas y separadas por guiones.

**Flujo de merge:** todo cambio entra por pull request, nunca push directo a `main` ni `develop`. Como trabajo solo, reviso mi propio PR antes de aprobarlo (leo la diff completa) y luego lo fusiono. Borro la rama al fusionar.

**Revisión:** aunque trabajo solo, dejo un comentario breve en cada PR explicando qué cambié y por qué, antes de aprobarlo y fusionarlo — así queda la trazabilidad que pide la pauta.