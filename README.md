# 🎵 ScreenSound

![Java](https://img.shields.io/badge/Java-ED8B00?style=for-the-badge&logo=java&logoColor=white)
![Spring Boot](https://img.shields.io/badge/Spring_Boot-6DB33F?style=for-the-badge&logo=spring-boot&logoColor=white)
![Hibernate](https://img.shields.io/badge/Hibernate-59666C?style=for-the-badge&logo=hibernate&logoColor=white)
![PostgreSQL](https://img.shields.io/badge/PostgreSQL-4169E1?style=for-the-badge&logo=postgresql&logoColor=white)

## 📌 Sobre o Projeto

O **ScreenSound** é uma aplicação de linha de comando (CLI) desenvolvida em Java, para cadastrar artistas e músicas em um catálogo persistido em banco de dados.

Neste projeto, construí um **CRUD completo via terminal** usando Spring Data JPA para a persistência dos dados, com relacionamento bidirecional entre artistas e músicas, além de integração com uma **API externa** (Wikipedia) para buscar biografias resumidas dos artistas cadastrados diretamente no terminal.

## ⚙️ Funcionalidades

- **Cadastro de artistas:** registro com nome e tipo (`SOLO`, `DUO`, `BAND`).
- **Cadastro de músicas:** associação de músicas a um artista já cadastrado, com título e álbum.
- **Listagem de músicas:** exibição de todas as músicas registradas, agrupadas por artista.
- **Busca por artista:** consulta de músicas filtrando pelo nome do artista, via *query* JPQL customizada.
- **Biografia via Wikipedia:** busca o resumo biográfico do artista consultando a API REST da Wikipedia em tempo real.

## 🛠️ Tecnologias Utilizadas

- Java 17
- Spring Boot
- Spring Data JPA
- Hibernate
- PostgreSQL
- Java HttpClient (consumo nativo da API da Wikipedia)
- Maven

## 🚀 Como Executar o Projeto

### Pré-requisitos

- Java 17 ou superior
- Maven
- PostgreSQL em execução

### Passo a passo

1. Clone este repositório:
   ```bash
   git clone https://github.com/jg-abreu/desafio-alura-screensound-java.git
   ```

2. Navegue até a pasta do projeto:
   ```bash
   cd desafio-alura-screensound-java
   ```

3. Configure o banco de dados em `src/main/resources/application.properties`:
   ```properties
   spring.datasource.url=jdbc:postgresql://localhost:5432/screensound_db
   spring.datasource.username=postgres
   spring.datasource.password=sua_senha_aqui
   ```

4. Execute a aplicação:
   ```bash
   ./mvnw spring-boot:run
   ```

5. Use o menu exibido no terminal para cadastrar artistas, cadastrar músicas, listar, buscar por artista e consultar biografias:
   ```
   *** Screen Sound Music ***

   1 - Register artists
   2 - Register songs
   3 - List songs
   4 - Search songs by artist
   5 - Search artist details

   9 - Exit
   ```

## 👨‍💻 Autor

**João Abreu**
Desenvolvedor Backend Java | Spring Boot | PostgreSQL | API REST

[🔗 LinkedIn](https://linkedin.com/in/SEU-USUARIO) · [🔗 GitHub](https://github.com/jg-abreu)
