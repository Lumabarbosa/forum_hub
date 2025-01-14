# Fórum Hub

**Fórum Hub** é uma aplicação RESTful desenvolvida com **Spring Boot**, destinada à gestão de tópicos em um fórum. O projeto implementa funcionalidades CRUD e segue boas práticas de arquitetura e segurança.

## Funcionalidades

- Criação, listagem, detalhamento, atualização e exclusão de tópicos.
- Autenticação e autorização baseada em JWT.
- Paginação e ordenação de dados.
- Validação de entradas do usuário.

## Tecnologias Utilizadas

- **Java 17**
- **Spring Boot**
  - Spring Web
  - Spring Data JPA
  - Spring Security
- **Banco de Dados**: MySQL
- **Migrations**: Flyway
- **Validação**: Bean Validation
- **Ferramentas Auxiliares**:
  - Lombok
  - Swagger/OpenAPI para documentação

## Como Executar o Projeto

### Pré-requisitos

- **Java 17**
- **Maven**
- Banco de dados MySQL em execução

### Passo a Passo

1. Clone o repositório:
   ```bash
   git clone https://github.com/Lumabarbosa/forum_hub.git
   ```

2. Navegue até o diretório do projeto:
   ```bash
   cd forum_hub
   ```

3. Configure o arquivo `application.properties` ou `application.yml` com as credenciais do seu banco de dados:
   ```properties
   spring.datasource.url=jdbc:mysql://localhost:3306/forum_hub
   spring.datasource.username=seu_usuario
   spring.datasource.password=sua_senha
   spring.jpa.hibernate.ddl-auto=validate
   spring.flyway.enabled=true
   ```

4. Execute as migrações do Flyway:
   ```bash
   mvn flyway:migrate
   ```

5. Compile e execute a aplicação:
   ```bash
   mvn spring-boot:run
   ```

6. Acesse a aplicação:
   - URL base: `http://localhost:8080`
   - Documentação Swagger: `http://localhost:8080/swagger-ui.html`

## Endpoints Principais

| Método | Endpoint        | Descrição                    |
|--------|-----------------|------------------------------|
| POST   | `/login`        | Autenticação via JWT         |
| POST   | `/topicos`      | Criação de um novo tópico    |
| GET    | `/topicos`      | Listagem de tópicos          |
| GET    | `/topicos/{id}` | Detalhamento de um tópico    |
| PUT    | `/topicos/{id}` | Atualização de um tópico     |
| DELETE | `/topicos/{id}` | Exclusão de um tópico        |

## Estrutura do Projeto

```
forum_hub/
├── src/main/java/br/com/alura/forumhub
│   ├── controller
│   ├── dto
│   ├── infra
│   ├── model
│   ├── repository
│   ├── service
│   └── ForumHubApplication.java
├── src/main/resources
│   ├── db/migration
│   ├── application.properties
│   └── application.yml
└── pom.xml
```

## Contribuição

Contribuições são bem-vindas! Siga os passos abaixo:

1. Faça um fork do projeto.
2. Crie uma nova branch:
   ```bash
   git checkout -b minha-feature
   ```
3. Commit suas mudanças:
   ```bash
   git commit -m "Minha nova feature"
   ```
4. Envie as mudanças para o seu repositório forkado:
   ```bash
   git push origin minha-feature
   ```
5. Abra um Pull Request no repositório principal.

## Licença

Este projeto está licenciado sob a Licença MIT. Consulte o arquivo LICENSE para mais detalhes.

