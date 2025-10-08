🏋️ Java Fitness Tracker

“Track your workouts. Know your numbers. Be your best.” 💪


A lightweight, console-based fitness tracker built with pure Java ☕.
This project helps users track workouts, calculate BMI, estimate calories burned, and analyze performance — all using simple, clean code designed to practice DSA + OOP concepts.

✨ Why This Project?

✅ Simple to use
🏋️ Fitness-focused logic (BMI, calories, MET)
📊 Real-time session tracking with LocalDate
🧠 Strengthens Java fundamentals (OOP + ArrayList + File Handling)
💾 Data is saved locally for persistence

🚀 Key Features
👤 User Management

➕ Add, ✏️ Update, 🗑️ Remove users

💪 Auto-calculate BMI on registration

🔥 Calculate calories burned based on workout type, BMI, age, and duration

📝 Workout Sessions

🆕 Add new workout sessions

🕒 Auto-date sessions with LocalDate

🧾 Store & manage session history using ArrayList

🗑️ Remove sessions by ID or index

📅 Display all sessions with dates

📊 Smart Statistics

🔍 Search user by ID

🧮 Calculate average BMI

🔥 Filter users by calories burned

🥇 Rank top performers

📈 Count users per workout type

💾 Save data to file

🧮 Formulas Used
🧠 BMI:
BMI
=
Weight (kg)
(Height (m))
2
BMI=
(Height (m))
2
Weight (kg)
	​

🔥 Calories Burned:
Calories
=
MET
×
Weight (kg)
×
Duration (hours)
×
Multiplier
Calories=MET×Weight (kg)×Duration (hours)×Multiplier
| Age   | Multiplier |
| ----- | ---------- |
| < 25  | 1.05       |
| 25–45 | 1.00       |
| > 45  | 0.95       |
🏃 Workout MET Values
| Workout Type | MET |
| ------------ | --- |
| 🏃 Running   | 8.0 |
| 🚴 Cycling   | 6.0 |
| 🚶 Walking   | 3.0 |
| 🏋️ Strength | 5.0 |
| 🧘 Yoga      | 2.5 |
🧱 Project Structure
📁 FitnessTrackerProject
├── 📄 UserFitnessStats.java        # User data, BMI & calorie logic
├── 📄 Session.java                 # Session details with date
├── 📄 FitnessStatsTracker.java     # Core logic (CRUD, stats, filter)
├── 📄 Main.java                    # Entry point (Console menu)
├── 📄 users_data.txt               # Saved user data
└── 📄 README.md
🧠 Main Class (Entry Point)

The Main class provides a menu-driven console interface for user interaction.

🪄 Menu Options

1️⃣ Add New User

2️⃣ Add Workout Session

3️⃣ Show All Users

4️⃣ Show All Sessions

5️⃣ Search User by ID

6️⃣ Show Average BMI

7️⃣ Filter Users by Calories

8️⃣ Remove Session

9️⃣ Show Top Performers

🔟 Count Users per Workout Type

💾 Save Data

0️⃣ Exit Program

🧾 Sample Run
================= 🏋️ FITNESS TRACKER MENU =================
1️⃣  Add New User
2️⃣  Add Workout Session
3️⃣  Show All Users
4️⃣  Show All Sessions
5️⃣  Search User by ID
6️⃣  Show Average BMI
7️⃣  Filter Users by Calories Burned
8️⃣  Remove Session
9️⃣  Show Top Performers
🔟  Count Users per Workout Type
💾  Save Data to File
0️⃣  Exit
============================================================
👉 Enter your choice: 1
Enter User ID: U001
Enter Name: Sayeel
Workout Type: Cardio
Age: 20
Duration: 45 min
Height: 6.3 ft
Weight: 108.3 kg
✅ User added successfully!

💾 Data Persistence

📝 All user data is saved to users_data.txt

🔁 Sessions can also be exported or extended

🔒 Ensures your data isn’t lost between runs

# 1️⃣ Clone the repository
git clone https://github.com/SyedSayeelAbbas/MUET-UNI-24SW116-Codes.git

# 2️⃣ Navigate to the project folder
cd ThirdSemester/DSA\ Lab\ Codes/Lab\ Code/FinalLabproject/

# 3️⃣ Compile the project
javac Main.java

# 4️⃣ Run the program
java Main
🧠 Tech Stack

☕ Java 17+

🧱 OOP (Encapsulation, Composition, Enum)

🧮 Data Structures (ArrayList, Map)

🗓️ Java Time API (LocalDate)

💾 File Handling for persistence

🏅 Future Enhancements

🖼️ GUI Interface with JavaFX / Swing

🗃️ Database integration (MySQL / SQLite)

📊 Dynamic MET values

📆 Progress charts & analytics

📤 Export reports to PDF/CSV

👨‍💻 Author

Syed Sayeel Abbas
📚 Software Engineering Student | MUET
💻 Passionate about Java, OOP & Web Development
⭐ GitHub

📝 License

This project is open source and available under the MIT License
.

🌟 Support the Project

If you like this project:

⭐ Star the repo

🍴 Fork it & improve

🐛 Open issues or PRs to contribute

“Small progress is still progress — track it, improve it, own it.” 🫡
