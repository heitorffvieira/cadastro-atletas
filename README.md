# Cadastro de Atletas
Sistema web para gerenciamento de atletas, desenvolvido com Java e Spring Boot no backend e HTML, CSS e JavaScript no frontend, utilizando arquitetura RESTful para comunicação entre as camadas.

## Funcionalidades
- Cadastro de atletas
- Listagem de atletas
- Edição de dados
- Remoção de atletas
- Comunicação entre frontend e API REST

## Tecnologias Utilizadas

### Backend
- Java
- Spring Boot
- Spring Web
- Spring Data JPA
- H2 Database
- Lombok
- DevTools
- Maven

### Frontend
- HTML5
- CSS3
- JavaScript 

## Como Executar o Projeto

### Backend
- Acesse a pasta do backend:
````cd apiCadastroAtletas````

- Execute o projeto:
```` ./mvnw spring-boot:run````

- A API ficará disponível em:
````http://localhost:8080````

### Frontend

- Acesse a pasta:
````cd frontCadastroAtletas````

- Abra o arquivo index.html no navegador.

## Endpoints Principais (API)
````
GET /athletes – Lista todos os atletas

POST /athletes – Cadastra um atleta

PUT /athletes/{id} – Atualiza um atleta

DELETE /athletes/{id} – Remove um atleta
