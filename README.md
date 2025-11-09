# 🏨 Java Hotel Management System

A **desktop-based hotel management application** built entirely in **Java** using the **Swing UI framework**.  
This system provides a complete solution for managing hotel operations — including **employee management**, **guest bookings**, **room records**, and **payment processing**.  

It emphasizes **Object-Oriented Programming (OOP)** principles such as **inheritance**, **polymorphism**, and **interfaces**, with persistent data storage via **Java Serialization**.

> 💡 *Developed by Odhran Porter* — A demonstration of desktop app development and OOP design in Java.

---

## ✨ Features

### 🖥️ Desktop GUI
- A **multi-window desktop application** built with **Java Swing**.
- Intuitive **menu-driven interface** for easy navigation between system modules.

### 🧑‍💼 Employee Management
- Full **CRUD functionality** for managing employee records:
  - Add, view, edit, and delete employees.
- Stores personal and salary details.
- Employee data is **persisted between sessions** using Java Serialization.

### 🛏️ Guest & Room Management
- Manage **guest information**, including name, contact details, and booking history.
- Handles **room assignment** and **availability tracking**.
- Ensures that bookings are consistent and prevent double-occupancy.

### 💳 Payment Processing
- Implements logic for **guest billing and payments**.
- Includes data models for `CreditCard` and `Date` handling.
- Demonstrates interface-based polymorphism through the `Payable` interface.

### 🏛️ Object-Oriented Design
- Strong focus on **OOP principles**:
  - **Inheritance:** `Person` superclass for `Employee` and `Guest`.
  - **Polymorphism:** Shared methods overridden in subclasses.
  - **Interfaces:** `Payable` interface for defining payment behavior.
  - **Encapsulation & Abstraction:** Private fields and public accessors ensure data security.

### 💾 Data Persistence
- All employee data is **serialized** into an `employees.bin` file.
- Data automatically **loads on startup** and **saves on exit**.
- Demonstrates practical use of `ObjectOutputStream` and `ObjectInputStream`.

---

## 🧰 Tech Stack

| Component | Technology |
|------------|-------------|
| **Language** | ☕ Java |
| **UI Framework** | 🖥️ Java Swing |
| **Data Persistence** | 💾 Java Serialization (`.bin` file) |
| **IDE** | ⚙️ Eclipse |
| **Core Concepts** | 🏛️ OOP, Inheritance, Interfaces, Exception Handling |

---
