# Estoque API

API REST para gerenciamento de produtos e categorias, desenvolvida com Spring Boot e PostgreSQL.

## Tecnologias Utilizadas

- Java 21
- Spring Boot 3.5
- Spring Data JPA
- PostgreSQL
- MapStruct
- Lombok
- SpringDoc OpenAPI (Swagger)
- Bean Validation

## Como Executar

### Pré-requisitos

- Java 21
- PostgreSQL instalado e rodando
- Maven

### Configuração do Banco de Dados

Crie um banco de dados no PostgreSQL:

```sql
CREATE DATABASE estoque_db;
```

### Configuração do application.yml

```yaml
spring:
  datasource:
    url: jdbc:postgresql://localhost:5432/estoque_db
    username: seu_usuario
    password: sua_senha
  jpa:
    hibernate:
      ddl-auto: update
    show-sql: true
```

### Rodando a Aplicação

```bash
mvn clean install
mvn spring-boot:run
```

A aplicação estará disponível em: `http://localhost:8080`

A documentação Swagger estará disponível em: `http://localhost:8080/swagger-ui/index.html`

---

## Endpoints da Aplicação

### Categorias

- **GET /api/categorias**
    - Retorna a lista de todas as categorias cadastradas.
    - Resposta: `200 OK`

- **GET /api/categorias/{id}**
    - Retorna uma categoria pelo ID.
    - Resposta: `200 OK`
    - Erro: `404 Not Found` — categoria não encontrada.

- **POST /api/categorias**
    - Cadastra uma nova categoria.
    - Body: `{ "nome": "Eletrônicos" }`
    - Resposta: `201 Created`
    - Erro: `400 Bad Request` — dados inválidos.

- **PUT /api/categorias/{id}**
    - Atualiza uma categoria existente pelo ID.
    - Body: `{ "nome": "Novo Nome" }`
    - Resposta: `200 OK`
    - Erro: `404 Not Found` — categoria não encontrada.
    - Erro: `400 Bad Request` — dados inválidos.

- **DELETE /api/categorias/{id}**
    - Remove uma categoria pelo ID.
    - Resposta: `204 No Content`
    - Erro: `404 Not Found` — categoria não encontrada.

---

### Produtos

- **GET /api/produtos**
    - Retorna a lista de todos os produtos cadastrados.
    - Resposta: `200 OK`

- **GET /api/produtos/{id}**
    - Retorna um produto pelo ID.
    - Resposta: `200 OK`
    - Erro: `404 Not Found` — produto não encontrado.

- **POST /api/produtos**
    - Cadastra um novo produto.
    - Body:
      ```json
      {
        "nome": "Notebook Dell",
        "descricao": "Notebook i7 16GB",
        "preco": 3999.00,
        "categoriaId": 1
      }
      ```
    - Resposta: `201 Created`
    - Erro: `400 Bad Request` — dados inválidos.

- **PUT /api/produtos/{id}**
    - Atualiza um produto existente pelo ID.
    - Body:
      ```json
      {
        "nome": "Notebook Dell Atualizado",
        "descricao": "Notebook i9 32GB",
        "preco": 5999.00,
        "categoriaId": 1
      }
      ```
    - Resposta: `200 OK`
    - Erro: `404 Not Found` — produto não encontrado.
    - Erro: `400 Bad Request` — dados inválidos.

- **DELETE /api/produtos/{id}**
    - Remove um produto pelo ID.
    - Resposta: `204 No Content`
    - Erro: `404 Not Found` — produto não encontrado.

---

## Estrutura do Projeto

```
src/main/java/com/alanf/estoque
├── controller      # Endpoints REST
├── service         # Regras de negócio
├── repository      # Acesso ao banco de dados
├── entity          # Entidades JPA
├── dto             # Objetos de transferência de dados
│   ├── categoria
│   └── produto
├── mapper          # Conversão entre DTOs e entidades (MapStruct)
└── exception       # Exceções customizadas e handler global
```

## Padrão de Erros

Todos os erros retornam o seguinte formato JSON:

```json
{
  "status": 404,
  "mensagem": "Categoria não encontrada",
  "timestamp": "03/05/2026 10:00:00"
}
```