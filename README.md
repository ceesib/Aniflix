🎬 Aniflix Backend (with Frontend Integration)

Aniflix is a backend-first anime streaming platform inspired by Netflix's architecture, built with a strong focus on clean code, modular microservices, and core Java principles.

This project will begin with the backend, since handling authentication, routing, and database logic is the foundation.
The frontend (React-based) will be introduced incrementally as we need to test and visualize backend features.

🚀 Project Goals

This project aims to simulate the backend infrastructure of an anime streaming platform. Users will be able to register, browse anime titles, watch episodes (via links), manage watchlists, and more — all powered by Java microservices.

🧱 Tech Stack
🔹 Backend
Component	Technology
Programming Language	Java (JDK 17+)
Web Server (initial)	HttpServer / SparkJava
REST Handling	Custom / SparkJava
JSON Parsing	Gson / Jackson
Database	PostgreSQL (via JDBC)
Authentication	JWT (via java-jwt)
Build Tool	Maven or Gradle
Testing	JUnit 5, Mockito
🔹 Frontend (Added as Needed)
Component	Technology
Core Languages	HTML, CSS, JavaScript
Framework	React (CRA or Vite)
Routing	React Router
State Management	React Hooks / Context API (later Redux/Zustand)
UI Styling	CSS Modules / Tailwind / Material UI
HTTP Requests	Fetch API / Axios
🧩 Core Microservices (Backend)

Auth Service

Register new users

Login and issue JWT tokens

Password encryption with BCrypt

Role-based access control

User Service

User profile management

Watchlist CRUD

Track viewing history

Anime Catalog Service

CRUD for anime titles, genres, and episodes

Genre and tag-based browsing

Episode data and stream URLs

Admin Service

Admin authentication

Anime and episode upload interfaces (API-level)

Manage users and roles

Watch History & Analytics (Planned)

Store user viewing events

Generate simple watch stats (recently watched, most viewed)

🔐 Security (Backend)

JWT-based authentication

Stateless session management

BCrypt password hashing

Protected routes by user roles (USER, ADMIN)

🗃️ Database Schema (Simplified View)
User(id, username, email, password, role)
Anime(id, title, description, release_year, rating)
Genre(id, name)
AnimeGenre(anime_id, genre_id) -- many-to-many
Episode(id, anime_id, title, episode_number, video_url)
WatchHistory(id, user_id, episode_id, timestamp)
Watchlist(id, user_id, anime_id)

📦 Project Status

🛠️ Currently backend-first: building out the service layer and REST routes using raw Java.
Frontend will be introduced alternately when backend features are ready for testing.

🗓️ Roadmap (Next Milestones)

 Set up basic HTTP server (backend)

 Implement AuthService (JWT-based)

 Design and connect PostgreSQL database

 Build AnimeCatalogService with search/filter

 Add Watchlist functionality

 Secure endpoints with role-based JWT

 Introduce React frontend for testing Auth + Catalog APIs

 Migrate backend to Spring Boot

📁 Folder Structure (Preliminary)
aniflix-backend/
├── server/      # Core server + routing
├── service/     # Business logic (Auth, Anime, User)
├── model/       # Domain models (User, Anime, Episode)
├── db/          # DB connection and queries
├── util/        # Utilities (JWT, JSON, etc.)
├── Main.java    # App entry point
└── README.md


Frontend will live in a separate repo or /frontend folder once backend endpoints are ready.

✨ With this structure:

Backend is the foundation.

Frontend will plug in gradually as backend endpoints are completed and need real-world testing.
