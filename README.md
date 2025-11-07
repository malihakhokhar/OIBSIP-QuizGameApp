# 🧠 OIBSIP – Quiz Game App

---

## 📋 Overview
The **OIBSIP Quiz Game App** is an interactive Android application developed as part of the **Oasis Infobyte Internship Program**.  
It allows users to **sign up, log in, play quizzes**, and **view their scores**.  
All data — including user authentication, quiz questions, and results — is managed through **Firebase Authentication** and **Firebase Realtime Database**.

---

## 🚀 Features

### 🏠 Welcome Activity
- Displays a clean and attractive splash/welcome screen.

### 📝 Sign Up Activity
- Registers new users using **Firebase Authentication**.  
- Stores user credentials securely in the Firebase backend.

### 🔐 Login Activity
- Allows existing users to log in securely using Firebase Authentication.

### 🎮 Main Activity
- Acts as the central dashboard where users can begin a quiz.

### ❓ Quiz Activity
- Fetches multiple-choice questions from **Firebase Realtime Database**.  
- Displays four options per question.  
- Calculates the user’s score dynamically.

### 🏁 Result Activity
- Displays the final quiz score after submission.  
- Stores user scores in **Firebase Realtime Database**.

---

## 🔥 Firebase Integration

### Firebase Authentication
- Handles secure sign-up and login using email and password.

### Firebase Realtime Database
- Stores:
  - Quiz questions and answers  
  - User details  
  - Final scores  
- Provides real-time data sync for a smooth experience.

---

## 🛠️ Tech Stack

| Component | Technology |
|------------|-------------|
| **Language** | Kotlin |
| **Database** | Firebase Realtime Database |
| **Authentication** | Firebase Authentication |
| **IDE** | Android Studio |
| **Architecture (Optional)** | MVVM |

---

## ⚙️ How to Run the Project

### 1. Clone the Repository
```bash
git clone https://github.com/your-username/OIBSIP-QuizGameApp.git
2. Open in Android Studio
Open the cloned project in Android Studio.

Let Gradle sync automatically.

3. Connect to Firebase
Add your google-services.json file to the /app folder.

Enable Email/Password Authentication in Firebase Console.

Set up the Realtime Database with a structure similar to:

json
Copy code
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
4. Run the App
Select a device or emulator.

Click Run ▶️ to launch the application.

🧭 App Flow
Screen	Function
Welcome	Introductory splash screen
Sign Up	New user registration
Login	Existing user authentication
Main	Start or select quiz
Quiz	Attempt multiple-choice questions
Result	View and store quiz score

🖼️ Output Preview (Optional)
Add screenshots here once available:

<img width="419" height="739" alt="7" src="https://github.com/user-attachments/assets/02d4b71c-681f-49f4-a426-2cb884f80845" />
<img width="388" height="685" alt="6" src="https://github.com/user-attachments/assets/b0aaf21a-6c08-40a3-a54b-34e7ad0a7352" />
<img width="378" height="661" alt="4" src="https://github.com/user-attachments/assets/f9bcdcd6-8114-41c7-8470-efaa2be6c7da" />
<img width="410" height="732" alt="5" src="https://github.com/user-attachments/assets/d6b6c751-24b3-4f76-bc12-33b033eda4a5" />
<img width="412" height="730" alt="2" src="https://github.com/user-attachments/assets/f1a9a011-78ec-469b-8e38-27581234c4b2" />
<img width="380" height="667" alt="3" src="https://github.com/user-attachments/assets/291c9030-b1e9-424c-9cb3-6a0cddc49f92" />
<img width="417" height="735" alt="1" src="https://github.com/user-attachments/assets/74e078c7-903c-4a84-8588-8871dec4c88c" />


👩‍💻 Developer
Maliha Khokhar
Android Developer | OIBSIP Intern
📎 GitHub: https://github.com/malihakhokhar

🙏 Acknowledgment
This project was developed as part of the Oasis Infobyte Internship Program, focusing on practical learning in Android app development, Firebase integration, and user authentication systems.

