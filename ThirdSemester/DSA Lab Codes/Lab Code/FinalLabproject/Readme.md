# 🏋️ Java Fitness Tracker

A simple **Fitness Tracking Application** written in **Java** that helps users track their **workouts, BMI, calories burned**, and session history.  
This project is designed to practice **OOP**, **ArrayList**, and **file handling** concepts in Java.

---

## 📌 Features

- 👤 **User Management**
  - Add, update, or remove users
  - Automatically calculate **BMI** on registration
  - Automatically calculate **calories burned** based on:
    - Workout type
    - Age group
    - BMI multiplier
    - Duration

- 📝 **Workout Session Management**
  - Add new workout sessions
  - Auto-stamp sessions with the **current date**
  - Store sessions using **ArrayList**
  - Remove sessions by ID or index
  - List all sessions with dates

- 🧮 **Statistics & Reports**
  - Search user by ID
  - Calculate **Average BMI**
  - Filter users by **calories burned**
  - Rank top performers 🥇
  - Count users per workout type
  - Save data to file for persistence

- 🕒 **Age & BMI Multiplier Logic**
  - Age < 25 → multiplier = `1.05` (higher burn rate)
  - Age > 45 → multiplier = `0.95` (lower burn rate)
  - BMI > 25  → multiplier = `1.1` (higher burn rate)

---

## 🧱 Project Structure
📁 FitnessTrackerProject
├── 📄 UserFitnessStats.java # Stores user info, BMI & calories logic
├── 📄 Session.java # Stores session details with date
├── 📄 FitnessStatsTracker.java # All core operations (CRUD, search, filter, stats)
├── 📄 Main.java # Runs the program with a simple menu
├── 📄 users_data.txt # Saved user data
└── 📄 README.md


---

## 🧮 Formula Used

### BMI:
\[
\text{BMI} = \frac{\text{Weight (kg)}}{\text{(Height (m))}^2}
\]

### Calories Burned:
\[
\text{Calories} = \text{MET} \times \text{Weight (kg)} \times \text{Duration (hours)} \times \text{Multiplier}
\]

Where:
- MET depends on **Workout Type**
- Multiplier depends on **Age & BMI**

---

## 🏃 Workout Types & MET Values

| Workout Type | MET |
|--------------|-----|
| Running      | 8.0 |
| Cycling      | 6.0 |
| Walking      | 3.0 |
| Strength     | 5.0 |
| Yoga         | 2.5 |

---

## 🖥️ Example Usage (Console)

Enter 1 to Add User
Enter 2 to Add Session
Enter 3 to View All Users
Enter 4 to Filter by Calories
Enter 5 to Show Top Performers
Enter 6 to Save Data
Enter 0 to Exit


---

## 💾 Data Persistence

The application saves all **user data** in a `.txt` file so it can be retrieved later even after closing the program.  
Sessions can also be exported optionally.

---

## 🚀 Tech Stack

- **Language:** Java (JDK 17+)
- **Concepts Used:** 
  - OOP (Classes, Objects, Encapsulation)
  - Inheritance & Composition
  - ArrayList & Loops
  - File Handling
  - Date API (`LocalDate`)

---

## 🧑‍💻 Author

**Syed Sayeel Abbas**  
📚 Software Engineering Student (2nd Semester)  
💻 Passionate about learning Java, OOP & Web Development

---

## 📝 License

This project is open source and available under the [MIT License](LICENSE).

---

## ⭐ How to Run

1. Clone the repo:
   ```bash
   git clone https://github.com/SyedSayeelAbbas/MUET-UNI-24SW116-Codes.git
2. Open the project in any IDE (IntelliJ / VS Code / Eclipse)

3. Navigate To :
    ThirdSemester/DSA Lab Codes/Lab Code/FinalLabproject/


4. Compile and run:
    javac Main.java
    java Main
5. Start adding users and tracking workouts!

   🏅 Future Improvements

GUI Interface using JavaFX or Swing

Database integration (MySQL / SQLite)

More workout types with dynamic MET

Weekly/monthly progress graphs

Export reports to PDF/CSV
⭐ If you like this project, don't forget to star the repo!
