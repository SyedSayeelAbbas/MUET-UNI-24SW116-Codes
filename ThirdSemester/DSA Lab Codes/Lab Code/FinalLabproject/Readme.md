🏋️‍♂️ Fitness Stats Tracker

A Java console-based application for tracking user fitness stats and workout sessions.

This project was developed as a 3rd Semester DSA practical project at MUET, Jamshoro, to demonstrate the use of Data Structures and Algorithms (HashMap, ArrayList) in real-world applications.

📌 Features

The Fitness Stats Tracker allows users to:

Add new users with details like ID, name, age, height, weight, and workout type.

Log workout sessions including duration, calories burned, and BMI.

View all registered users and their fitness stats.

Display all workout sessions.

Search for users by User ID.

Calculate the average BMI of all users.

Filter users based on calories burned.

Remove or update specific workout sessions.

Rank users to show top performers.

Count users in different BMI categories.

Count users per workout type.

Load user data automatically from a CSV file.

Exit the application safely through a menu-driven interface.

🛠️ Technologies Used

Java – Core programming language.

HashMap – Fast lookup and updates for user fitness data.

ArrayList – Storing multiple workout sessions efficiently.

Scanner – Console input handling.

📐 How It Works

User Registration: Add personal info. BMI is calculated automatically. Data stored in a HashMap.

Workout Sessions: Sessions include type, duration, calories, and BMI. Stored in ArrayList.

Data Analysis: Calculate average BMI, filter users, count BMI/workout type categories, rank top performers.

Search, Update, Delete: Users and sessions can be searched, updated, or removed easily.

Menu Interface: All features are accessible via a simple number-based menu.

🧮 Formulas

BMI: BMI = Weight (kg) / (Height (m))²

Calories Burned: Calories = MET × Weight (kg) × Duration (hours)

MET values vary by workout type (Cardio, Strength, Yoga, HIIT, Cycling, Walking) and are adjusted based on age and BMI.

💡 Sample Test Case

Input:

User: Ali (ID: U001), Age 21, Height 5.7 ft, Weight 70 kg

Workout: Cardio, Duration 60 min

Output:

BMI: 24.1 (Normal)

Calories Burned: 514.5 kcal

Session recorded successfully

User added to top performers list

🧩 OOP Concepts

Encapsulation: Private attributes with getters/setters.

Abstraction: BMI and calorie calculations hidden in methods.

Composition: FitnessStatsTracker uses UserFitnessStats and Session objects.

Modularity: Separate classes for readability and maintenance.

🚀 Project Scope

Personal fitness tracking.

Gym and training center management.

Workout data analysis and reporting.

Academic demonstration of DSA in practical applications.

🌱 Future Improvements

Load/save data automatically from CSV or database.

Add a GUI using JavaFX or Swing.

Include graphs/charts for BMI and calories.

Integrate machine learning to predict calorie trends.

👥 Group Members

Syed Sayeel Abbas (24SW116) – Developer

Waseem (24SW164) – Tester
