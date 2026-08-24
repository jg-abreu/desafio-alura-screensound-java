# ScreenSound - Music & Artist Catalog CLI 🎵

A command-line interface (CLI) application built with **Java 17**, **Spring Boot**, and **Spring Data JPA** to manage artists, songs, and fetch artist biographies using the **Wikipedia API**.

---

## 📌 Features

- **Artist Management:** Register artists and categorize them by type (`SOLO`, `DUO`, `BAND`).
- **Song Catalog:** Associate songs with registered artists in a bidirectional relational mapping (`OneToMany` / `ManyToOne`).
- **Custom JPQL Queries:** Search songs by artist name dynamically using JPQL.
- **External API Integration:** Fetch summarized artist biographies directly from the **Wikipedia REST API**.
- **Data Persistence:** Relational database management using **PostgreSQL** (or H2 in memory) and **Hibernate/JPA**.

---

## 🛠️ Tech Stack

- **Java 17**
- **Spring Boot 3.x**
    - Spring Data JPA
- **PostgreSQL** (or H2 Database)
- **Java HttpClient** (Native REST queries)
- **Maven** (Dependency management)

---

## 🚀 How to Run

### Prerequisites
- JDK 17+ installed
- Maven installed (or use `./mvnw`)
- PostgreSQL database running (configured in `application.properties`)

### Steps

1. **Clone the repository:**
   ```bash
   git clone [https://github.com/jg-abreu/desafio-alura-screensound-java.git](https://github.com/jg-abreu/desafio-alura-screensound-java.git)
   cd desafio-alura-screensound-java