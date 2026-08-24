# LanguageLearningAppFrontEnd

A desktop language-learning application developed collaboratively as a team using **Java and JavaFX**. The application provides interactive lessons, multiple question formats, user accounts, progress tracking, and other features designed to create an engaging language-learning experience.

## Features

* **User Authentication** - Create an account, log in, and access saved user information
* **Interactive Lessons** - Complete lessons across multiple topics and difficulty levels
* **Multiple Question Types** - Practice using matching, fill-in-the-blank, and other interactive questions
* **Answer Validation** - Receive immediate visual feedback for correct and incorrect answers
* **Text-to-Speech** - Hear lesson content and vocabulary pronounced during exercises
* **Progress Tracking** - Track completed lessons and continue the most recently accessed lesson
* **Leaderboard** - Compare lesson completion progress across users
* **User Profiles** - View account information and unlock avatars by completing lessons
* **Vocabulary Review** - Review vocabulary from previous lessons
* **Password Management** - Update account passwords from the user profile
* **Persistent Data** - Store user and application data using JSON files

## Technologies

* **Java**
* **JavaFX**
* **FXML**
* **JSON**
* **CSS**

## Application Overview

### Authentication

Users can create an account or log in to an existing account. During registration, the application checks existing user data to prevent duplicate usernames and email addresses. Account information is persisted using JSON files.

### Lessons

After logging in, users can select lessons organized by topic and difficulty. The application dynamically loads the appropriate lesson content and supports multiple styles of questions.

Answers are evaluated through the application's backend logic, and users receive immediate feedback indicating whether their response was correct.

### Progress

The application records lesson progress so users can return to the lesson they were most recently working on. Completed lessons contribute to the user's overall progress and leaderboard position.

### Profiles

Each user has a profile containing their account information and learning progress. Completing lessons can also unlock new avatars. Users can review vocabulary, change their password, or log out through the profile interface.

## Architecture

The application uses a JavaFX front end built with **FXML views and Java controllers**. Controllers manage user interactions and communicate with the application's underlying logic to retrieve lessons, process answers, navigate between screens, and update application state.

JSON files provide persistent storage for information such as user accounts and application data.

## Team Development

This project was developed collaboratively as a team for **CSCE 247** at the University of South Carolina. Team members worked together across the application rather than dividing development into completely independent components, contributing to the design, implementation, integration, and testing of the final application.

## Demo

A video demonstration of the completed application is available on YouTube:

[CSCE247 Front End Presentation - Fantastic Four](https://youtu.be/QEfuvEQ60v0)

## What We Learned

This project provided hands-on experience with:

* Building a multi-screen desktop application with JavaFX and FXML
* Connecting front-end interfaces with application logic
* Designing object-oriented software as a team
* Managing application state across multiple screens
* Persisting structured data with JSON
* Implementing multiple interactive question types
* Integrating and testing features developed collaboratively
* Using Git-based team development workflows
