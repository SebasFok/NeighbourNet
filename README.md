# 🏘️ KampungKaki
**The Neighborhood Operating System**

KampungKaki is a resource-sharing platform designed to bridge the gap between neighbors. By digitizing the "Kampung Spirit," the app allows residents to lend household items, share errands, and build a stronger, more resilient community.

Inspired by my tenure as a **Silver Generation Ambassador (SGA)**, this project addresses social isolation in urban environments by providing a low-friction way for neighbors to connect and support one another.

---

## ✨ Features
- **P2P Item Exchange:** A shared library for household tools (drills, ladders, vacuums).
- **Real-time Availability:** One-click "Toggle" status updates using a reactive Spring Boot backend.
- **Unified Dashboard:** A clean Vue.js interface for browsing community "Lobangs" (opportunities).
- **Decoupled Architecture:** Separated Frontend/Backend modules for better scalability and maintenance.

---

## 🛠️ Technical Stack

| Layer          | Technology                               |
| :---           | :---                                     |
| **Frontend** | Vue.js 3, Axios, Vite                    |
| **Backend** | Java 17+, Spring Boot 3, Spring Data JPA |
| **Database** | PostgreSQL                               |
| **Build Tools**| Maven, Lombok, IntelliJ IDEA             |

---

## 🚀 Getting Started

### Prerequisites
- **Java 17** or higher
- **Node.js** (v18+)
- **PostgreSQL 14+**

### Project Structure
Ensure your directory is flattened as follows:
```text
KampungKaki/
├── frontend/   # Vue.js Project
└── backend/    # Spring Boot Project