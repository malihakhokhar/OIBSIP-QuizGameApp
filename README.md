🎯 OIBSIP - Quiz Game App

An interactive Quiz Game Android Application built as part of the Oasis Infobyte Internship Program (OIBSIP).
This app allows users to sign up, log in, and participate in exciting quizzes. The scores and questions are managed through Firebase Realtime Database for smooth, real-time updates.

📱 Features

Welcome Activity:
Displays a splash or welcome screen to introduce users to the app.

Sign Up Activity:
New users can create an account using their email and password. Authentication is managed through Firebase Authentication.

Login Activity:
Existing users can securely log in to access their quizzes.

Main Activity:
Acts as the app’s home screen — users can select quiz categories or start playing.

Quiz Activity:
Displays multiple-choice questions fetched from the Firebase Realtime Database.

Each question has four options.

Users receive instant feedback after answering.

Result Activity:
Shows the user’s total score after completing the quiz.

The score is also saved in the Firebase Realtime Database for record keeping.

🔥 Firebase Integration

Firebase Authentication:
Used for user registration and login.
Ensures data privacy and secure access.

Firebase Realtime Database:
Used to:

Store quiz questions and answers

Save users’ scores and progress in real-time

🛠️ Tech Stack

Language: Kotlin

Database: Firebase Realtime Database

Authentication: Firebase Auth

IDE: Android Studio

Architecture: MVVM (optional, if you used it)

🚀 How to Run the Project

Clone this repository:

git clone https://github.com/malihakhokhar/OIBSIP-QuizGameApp.git


Open the project in Android Studio.

Connect your project to Firebase:

Add your google-services.json file inside the app/ directory.

Enable Authentication (Email/Password) in Firebase Console.

Create a Realtime Database and structure it as follows:

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


Sync Gradle and run the app on an emulator or device.

📊 Output Overview
Activity	Description
Welcome	Intro or splash screen
Sign Up	Register a new user
Login	Authenticate user with Firebase
Main	Start or choose quiz
Quiz	Play and answer questions
Result	View and save score
📸 Screenshots (optional)

Add screenshots here once available:

Welcome Screen
<img width="419" height="739" alt="7" src="https://github.com/user-attachments/assets/f6fcef53-434d-41ab-8813-67b451384491" />

Login & Signup
<img width="388" height="685" alt="6" src="https://github.com/user-attachments/assets/fb93bd6d-ced6-4844-b698-0da4e2d4a463" />
<img width="378" height="661" alt="4" src="https://github.com/user-attachments/assets/a9563033-45ec-4ac2-b274-ccd98869a15c" />

Forget Password
<img width="410" height="732" alt="5" src="https://github.com/user-attachments/assets/fc45030e-28ca-4d60-816b-70e828e25c20" />

Quiz Screen
<img width="380" height="667" alt="3" src="https://github.com/user-attachments/assets/9ef5ddbd-2eaa-483f-a376-7b37f5c588b5" />

Result Screen
<img width="417" height="735" alt="1" src="https://github.com/user-attachments/assets/bb14ff09-2bd3-4508-89db-2d181e50b1df" />

👩‍💻 Developed By

Maliha Khokhar
Android Developer | OIBSIP Intern
