🏋️ Java Fitness Tracker

A simple Fitness Tracking Application written in Java that helps users track their workouts, BMI, calories burned, and session history.
This project is designed to practice OOP, ArrayList, and file handling concepts in Java.

📌 Features
👤 User Management

Add, update, or remove users

Automatically calculate BMI on registration

Automatically calculate calories burned based on:

Workout type

Age group

BMI multiplier

Duration

📝 Workout Session Management

Add new workout sessions

Auto-stamp sessions with the current date

Store sessions using ArrayList

Remove sessions by ID or index

List all sessions with dates

🧮 Statistics & Reports

Search user by ID

Calculate Average BMI

Filter users by calories burned

Rank top performers 🥇

Count users per workout type

Save data to file for persistence

🕒 Age & BMI Multiplier Logic
Condition	Multiplier
Age < 25	1.05
Age > 45	0.95
BMI > 25	1.10
🧱 Project Structure
📁 FitnessTrackerProject
├── 📄 UserFitnessStats.java        # Stores user info, BMI & calories logic
├── 📄 Session.java                 # Stores session details with date
├── 📄 FitnessStatsTracker.java     # Core operations (CRUD, search, filter, stats)
├── 📄 Main.java                    # Runs the program with a console menu
├── 📄 users_data.txt               # Saved user data
└── 📄 README.md

🧮 Formula Used
BMI
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

Calories Burned
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

Where:

MET depends on Workout Type

Multiplier depends on Age & BMI

🏃 Workout Types & MET Values
Workout Type	MET
Running	8.0
Cycling	6.0
Walking	3.0
Strength	5.0
Yoga	2.5
🧠 Main Class – Program Entry Point

The Main class acts as the console-based interface of the Fitness Stats Tracker.
It allows users to interact with the system through a simple, numbered menu.

✨ Features

🆕 Add new users

🏋️ Add workout sessions

🔍 Search users by ID

📊 Calculate average BMI

🔥 Filter users by calories burned

📝 View and remove sessions

🥇 Display top performers

📈 Count users per workout type

💾 Save data to file

🚪 Exit the program

🧾 Code: Main.java
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        FitnessStatsTracker tracker = new FitnessStatsTracker();
        boolean running = true;

        while (running) {
            System.out.println("\n================= 🏋️ FITNESS TRACKER MENU =================");
            System.out.println("1️⃣  Add New User");
            System.out.println("2️⃣  Add Workout Session");
            System.out.println("3️⃣  Show All Users");
            System.out.println("4️⃣  Show All Sessions");
            System.out.println("5️⃣  Search User by ID");
            System.out.println("6️⃣  Show Average BMI");
            System.out.println("7️⃣  Filter Users by Calories Burned");
            System.out.println("8️⃣  Remove Session");
            System.out.println("9️⃣  Show Top Performers");
            System.out.println("🔟  Count Users per Workout Type");
            System.out.println("💾  Save Data to File");
            System.out.println("0️⃣  Exit");
            System.out.println("============================================================");
            System.out.print("👉 Enter your choice: ");

            int choice = sc.nextInt();
            sc.nextLine();

            switch (choice) {
                case 1:
                    System.out.print("Enter User ID: ");
                    String userId = sc.nextLine();

                    System.out.print("Enter Name: ");
                    String name = sc.nextLine();

                    System.out.println("Workout Types: Cardio, Strength, Yoga, HIIT, Cycling, Walking");
                    System.out.print("Enter Workout Type: ");
                    String typeStr = sc.nextLine();
                    UserFitnessStats.WorkoutType type = UserFitnessStats.WorkoutType.valueOf(typeStr);

                    System.out.print("Enter Age: ");
                    int age = sc.nextInt();

                    System.out.print("Enter Duration (minutes): ");
                    int duration = sc.nextInt();

                    System.out.print("Enter Height (in feet): ");
                    double height = sc.nextDouble();

                    System.out.print("Enter Weight (in kg): ");
                    double weight = sc.nextDouble();

                    UserFitnessStats user = new UserFitnessStats(userId, name, type, age, duration, height, weight);
                    tracker.addUser(user);
                    break;

                case 2:
                    System.out.print("Enter User ID for session: ");
                    String uid = sc.nextLine();
                    tracker.addSession(uid);
                    break;

                case 3:
                    tracker.userMap.forEach((id, u) -> System.out.println(u));
                    break;

                case 4:
                    tracker.showAllSessions();
                    break;

                case 5:
                    System.out.print("Enter User ID to search: ");
                    String searchId = sc.nextLine();
                    tracker.searchUserById(searchId);
                    break;

                case 6:
                    double avgBmi = tracker.calculateAverageBMI();
                    System.out.printf("📊 Average BMI of all users: %.2f%n", avgBmi);
                    break;

                case 7:
                    System.out.print("Enter minimum calories burned to filter: ");
                    double minCal = sc.nextDouble();
                    tracker.displayUsersByCalories(minCal);
                    break;

                case 8:
                    System.out.print("Enter session index to remove: ");
                    int index = sc.nextInt();
                    tracker.removeSession(index);
                    break;

                case 9:
                    tracker.displayTopPerformers();
                    break;

                case 10:
                    tracker.countUsersPerWorkoutType();
                    break;

                case 11:
                    System.out.print("Enter file name to save data (e.g., data.csv): ");
                    String fileName = sc.nextLine();
                    tracker.saveDataToFile(fileName);
                    break;

                case 0:
                    System.out.println("👋 Exiting Fitness Tracker... Stay Fit!");
                    running = false;
                    break;

                default:
                    System.out.println("⚠️ Invalid choice! Please try again.");
            }
        }

        sc.close();
    }
}

🧪 Sample Run
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

The application saves all user data in a .txt file so it can be retrieved later even after closing the program.
Sessions can also be exported optionally.

🚀 Tech Stack

Language: Java (JDK 17+)

Concepts Used:

OOP (Classes, Objects, Encapsulation)

Inheritance & Composition

ArrayList & Loops

File Handling

Java Time API (LocalDate)

🧑‍💻 Author

Syed Sayeel Abbas
📚 Software Engineering Student (2nd Semester)
💻 Passionate about Java, OOP & Web Development

📝 License

This project is open source and available under the MIT License
.

⭐ How to Run
# 1. Clone the repo
git clone https://github.com/SyedSayeelAbbas/MUET-UNI-24SW116-Codes.git

# 2. Open the project in any IDE (IntelliJ / VS Code / Eclipse)

# 3. Navigate to:
ThirdSemester/DSA Lab Codes/Lab Code/FinalLabproject/

# 4. Compile and run
javac Main.java
java Main

🏅 Future Improvements

GUI Interface using JavaFX or Swing

Database integration (MySQL / SQLite)

More workout types with dynamic MET values

Weekly/monthly progress graphs

Export reports to PDF/CSV

⭐ If you like this project, don’t forget to star the repo!
