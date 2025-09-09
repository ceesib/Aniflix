# 🎬 Aniflix Backend

**Aniflix** is a backend-first anime streaming platform inspired by Netflix's architecture, built with a strong focus on **clean code**, **modular microservices**, and **core Java principles**. This project is designed to help me apply and solidify my understanding of:

- ✅ Object-Oriented Programming (OOP)
- ✅ SOLID Principles
- ✅ REST API Design
- ✅ Authentication & Security
- ✅ Relational Database Modeling
- ✅ Java backend systems

---

## 🚀 Project Goals

This project aims to simulate the backend infrastructure of an anime streaming platform. Users will be able to register, browse anime titles, watch episodes (via links), manage watchlists, and more — all powered by Java microservices.

The system will start without any frameworks to deepen my understanding of raw HTTP handling, routing, and service management — and later evolve into a fully-fledged Spring Boot microservice architecture.

---

## 🧱 Tech Stack (Backend-Only)

| Component              | Technology       |
|------------------------|------------------|
| Programming Language   | Java (JDK 17+)    |
| Web Server (initial)   | `HttpServer` / SparkJava |
| REST Handling          | Custom / SparkJava |
| JSON Parsing           | Gson / Jackson    |
| Database               | PostgreSQL (via JDBC) |
| Authentication         | JWT (via java-jwt) |
| Build Tool             | Maven or Gradle   |
| Testing                | JUnit 5, Mockito  |

---
## Frontend 
| Component        | Technology                                      |
| ---------------- | ----------------------------------------------- |
| Core Languages   | HTML, CSS, JavaScript                           |
| Framework        | React (CRA or Vite)                             |
| Routing          | React Router                                    |
| State Management | React Hooks / Context API (later Redux/Zustand) |
| UI Styling       | CSS Modules / Tailwind / Material UI            |
| HTTP Requests    | Fetch API / Axios                               |


## 🧩 Core Microservices

Each service is designed to be modular and testable. Initial implementation will be in a **monolithic layout**, with future plans to split services out into independent microservices.

### 1. **Auth Service**
- Register new users
- Login and issue JWT tokens
- Password encryption with BCrypt
- Role-based access control

### 2. **User Service**
- User profile management
- Watchlist CRUD
- Track viewing history

### 3. **Anime Catalog Service**
- CRUD for anime titles, genres, and episodes
- Genre and tag-based browsing
- Episode data and stream URLs

### 4. **Admin Service**
- Admin authentication
- Anime and episode upload interfaces (API-level)
- Manage users and roles

### 5. **Watch History & Analytics** (Planned)
- Store user viewing events
- Generate simple watch stats (recently watched, most viewed)

---

## 🔐 Security

- JWT-based authentication
- Stateless session management
- BCrypt password hashing
- Protected routes by user roles (`USER`, `ADMIN`)

---

## 🗃️ Database Schema (Simplified View)
User(id, username, email, password, role)
Anime(id, title, description, release_year, rating)
Genre(id, name)
AnimeGenre(anime_id, genre_id) -- many-to-many
Episode(id, anime_id, title, episode_number, video_url)
WatchHistory(id, user_id, episode_id, timestamp)
Watchlist(id, user_id, anime_id)


---

## 📦 Project Status

> 🛠️ Currently building out the initial service layer and REST routes using raw Java. No frameworks yet. Spring Boot integration will follow in a later stage.

---

## ✨ Why This Project?

This is a self-directed portfolio project meant to:
- Reinforce backend fundamentals through real-world architecture
- Deepen my Java expertise without depending on frameworks at the start
- Build a clean, scalable backend worthy of production-grade standards
- Prepare for future integration with Spring Boot and distributed systems

---

## 🗓️ Roadmap (Next Milestones)

- [ ] Set up basic HTTP server
- [ ] Implement AuthService (JWT-based)
- [ ] Design and connect PostgreSQL database
- [ ] Build AnimeCatalogService with search/filter
- [ ] Add Watchlist functionality
- [ ] Secure endpoints with role-based JWT
- [ ] Begin migration to Spring Boot

---

## 📁 Folder Structure (Preliminary)
aniflix-backend/
├── server/ # Core server + routing
├── service/ # Business logic (Auth, Anime, User)
├── model/ # Domain models (User, Anime, Episode)
├── db/ # DB connection and queries
├── util/ # Utilities (JWT, JSON, etc.)
├── Main.java # App entry point
└── README.md

