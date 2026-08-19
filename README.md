# Java CLI Library Manager

A command-line Library Management System built with core Java. This application demonstrates fundamental object-oriented programming (OOP) principles, in-memory data management using Java Collections, and robust exception handling. 

This project was developed for the Week 2 Java Internship Task: Core Functionality Implementation.

## Features
- **Add a Book:** Insert new books into the inventory with duplicate ISBN validation.
- **List All Books:** View a formatted tabular display of all books currently in the system.
- **Update a Book:** Modify the title, author, or publication year of an existing book using its unique ISBN.
- **Delete a Book:** Safely remove a book from the collection.
- **Input Validation:** Prevents application crashes from invalid data entry (e.g., entering text when a number is expected).

## Project Structure
- `Book.java`: The entity class representing the book data model (POJO).
- `LibraryManager.java`: The service class handling the business logic and `ArrayList` collection operations.
- `Main.java`: The presentation layer containing the interactive console menu and user input routing.

## Prerequisites
To run this application, you must have the **Java Development Kit (JDK)** installed on your machine.

## How to Compile and Run

1. **Open your terminal** or command prompt.
2. **Navigate** to the directory containing the project files:
   ```bash
   cd path/to/java-cli-library-manager
