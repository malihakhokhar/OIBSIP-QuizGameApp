OIBSIP – Quiz Game App
Overview

The OIBSIP Quiz Game App is an interactive Android application developed as part of the Oasis Infobyte Internship Program.
This app allows users to sign up, log in, and play quizzes stored in Firebase Realtime Database.
Scores and user data are stored securely with Firebase Authentication and Database integration.

Features
Welcome Activity

Displays the welcome screen when the app starts.

Sign Up Activity

Allows new users to register using an email and password.

Uses Firebase Authentication for user account creation.

Login Activity

Enables registered users to log in securely.

Verifies credentials with Firebase Authentication.

Main Activity

Acts as the home page where users can start the quiz.

Quiz Activity

Displays multiple-choice questions fetched from Firebase Realtime Database.

Users can select answers, and the app calculates the score in real time.

Result Activity

Shows the user’s final score after quiz completion.

The score is stored in Firebase Realtime Database for record keeping.

Firebase Integration
Firebase Authentication

Handles user registration and login securely.

Firebase Realtime Database

Stores quiz questions, options, correct answers, and user scores.

Updates data in real time, allowing smooth interaction between users and the app.

Tech Stack
Component	Technology Used
Language	Kotlin
Database	Firebase Realtime Database
Authentication	Firebase Authentication
IDE	Android Studio
Architecture	MVVM (optional)
How to Run the Project

Clone the Repository

git clone https://github.com/your-username/OIBSIP-QuizGameApp.git


Open in Android Studio

Open the project folder in Android Studio.

Let Gradle sync automatically.

Connect Firebase

Download the google-services.json file from Firebase Console.

Place it in the /app folder of your project.

Enable Email/Password Authentication in Firebase.

Create a Realtime Database and structure it like this:

{
  "questions": {
    "1": {
      "question": "What is the capital of France?",
      "option1": "Paris",
      "option2": "London",
      "option3": "Berlin",
      "option4": "Rome",
      "answer": "Paris"
    }
  },
  "scores": {
    "userID": {
      "username": "Maliha",
      "score": "8"
    }
  }
}


Run the App

Choose an emulator or Android device.

Click Run ▶️ to launch the app.

App Flow
Screen	Description
Welcome	Displays welcome or splash screen
Sign Up	User registration
Forget Password
Login	User authentication
Main	Quiz start screen
Quiz	Multiple-choice questions
Result	Final score display
Output Preview

Add screenshots of the app here (optional):

Welcome Screen
<img width="419" height="739" alt="7" src="https://github.com/user-attachments/assets/cd5abe20-be8d-4bc8-b745-96821b7f003e" />

Login Screen
<img width="378" height="661" alt="4" src="https://github.com/user-attachments/assets/31b99876-5b10-40cf-bed6-11476b22e36c" />

Quiz Screen
<img width="380" height="667" alt="3" src="https://github.com/user-attachments/assets/f447eb52-2a94-4b36-a67e-28d82d177e97" />

Result Screen
<img width="417" height="735" alt="1" src="https://github.com/user-attachments/assets/0273ac88-39dc-46dd-8a9e-82ed65becf18" />

Developer

Maliha Khokhar
Android Developer | OIBSIP Intern
GitHub: https://github.com/malihakhokhar
Acknowledgment

Developed as part of the Oasis Infobyte Internship Program (OIBSIP) to enhance skills in Android development, Firebase integration, and user authentication.
