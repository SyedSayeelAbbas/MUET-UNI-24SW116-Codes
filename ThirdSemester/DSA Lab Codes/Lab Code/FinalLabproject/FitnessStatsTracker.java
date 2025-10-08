import java.util.*;
import java.io.*;
import java.time.LocalDate;
import java.util.Scanner;

class UserFitnessStats {

    // Enum for workout types (safer than Strings)
    public enum WorkoutType {
        Cardio, Strength, Yoga, HIIT, Cycling, Walking
    }

    // All the User Stats
    private String userId, name;
    private WorkoutType workoutType;
    private int age, duration; // duration in minutes
    private double height, weight, caloriesBurned, bmi;

    // Constructor
    public UserFitnessStats(String userId, String name, WorkoutType workoutType,
                            int age, int duration, double height, double weight) {

        if (height <= 0 || weight <= 0 || duration <= 0 || age <= 0) {
            throw new IllegalArgumentException("Invalid input: Height, weight, age and duration must be positive.");
        }

        this.userId = userId;
        this.name = name;
        this.workoutType = workoutType;
        this.age = age;
        this.duration = duration;
        this.height = height;
        this.weight = weight;

        // Automatic calculations
        this.bmi = calculateBMI();
        this.caloriesBurned = calculateCaloriesBurned();
    }

    // All Getters
    public String getUserId() { return userId; }
    public String getName() { return name; }
    public WorkoutType getWorkoutType() { return workoutType; }
    public int getAge() { return age; }
    public int getDuration() { return duration; }
    public double getHeight() { return height; }
    public double getWeight() { return weight; }
    public double getBMI() { return bmi; }
    public double getCaloriesBurned() { return caloriesBurned; }

    // BMI Calculation (fixed formula)
    private double calculateBMI() {
        double heightInMeters = this.height * 0.3048; // convert feet to meters
        return this.weight / (heightInMeters * heightInMeters);
    }

    // MET Calculation with multipliers
    private double getMET(WorkoutType type) {
        double baseMET;

        switch (type) {
            case Cardio:   baseMET = 7.0; break;
            case Strength: baseMET = 6.0; break;
            case Yoga:     baseMET = 3.0; break;
            case HIIT:     baseMET = 9.0; break;
            case Cycling:  baseMET = 8.0; break;
            case Walking:  baseMET = 4.0; break;
            default:
                throw new IllegalStateException("Invalid workout type");
        }

        // Age multiplier
        double ageMultiplier;
        if (age < 25) ageMultiplier = 1.05;
        else if (age <= 35) ageMultiplier = 1.00;
        else if (age <= 45) ageMultiplier = 0.98;
        else if (age <= 60) ageMultiplier = 0.95;
        else ageMultiplier = 0.92;

        // BMI multiplier
        double bmiMultiplier;
        if (bmi < 18.5) bmiMultiplier = 0.95;
        else if (bmi <= 24.9) bmiMultiplier = 1.00;
        else if (bmi <= 29.9) bmiMultiplier = 1.10;
        else bmiMultiplier = 1.15;

        return baseMET * ageMultiplier * bmiMultiplier;
    }

    // Calories burned calculation
    private double calculateCaloriesBurned() {
        double met = getMET(this.workoutType);
        // formula: MET × Weight (kg) × Duration (hours)
        double hours = this.duration / 60.0;
        return met * this.weight * hours;
    }

    // BMI Category (optional but nice for UI)
    public String getBMICategory() {
        if (bmi < 18.5) return "Underweight";
        if (bmi <= 24.9) return "Normal";
        if (bmi <= 29.9) return "Overweight";
        return "Obese";
    }

    // ToString (clean output)
    @Override
    public String toString() {
        StringBuilder s = new StringBuilder();
        s.append("****** User Fitness Details ******\n");
        s.append("User ID: ").append(userId).append("\n");
        s.append("Name: ").append(name).append("\n");
        s.append("Workout Type: ").append(workoutType).append("\n");
        s.append("Age: ").append(age).append(" years\n");
        s.append("Duration: ").append(duration).append(" min\n");
        s.append("Height: ").append(String.format("%.2f", height)).append(" ft\n");
        s.append("Weight: ").append(String.format("%.2f", weight)).append(" kg\n");
        s.append("BMI: ").append(String.format("%.2f", bmi)).append(" (").append(getBMICategory()).append(")\n");
        s.append("Calories Burned: ").append(String.format("%.2f", caloriesBurned)).append(" kcal\n");
        s.append("***********************************");
        return s.toString();
    }
}

class Session {
    private String workoutType;
    private int duration; // in minutes
    private double caloriesBurned;
    private double bmi;
    private LocalDate date;
    private static int sessionCounter = 0;
    private int sessionId;

    public Session(String workoutType, int duration, double caloriesBurned, double bmi) {
        this.sessionId = ++sessionCounter;
        this.workoutType = workoutType;
        this.duration = duration;
        this.caloriesBurned = caloriesBurned;
        this.bmi = bmi;
        this.date = LocalDate.now();
    }

    // Getters and setters
    public int getSessionId() { return sessionId; }
    public String getWorkoutType() { return workoutType; }
    public int getDuration() { return duration; }
    public double getCaloriesBurned() { return caloriesBurned; }
    public double getBmi() { return bmi; }
    public LocalDate getDate() { return date; }
}




public class FitnessStatsTracker {
    private HashMap<String, UserFitnessStats> userMap = new HashMap<>();
    private ArrayList<Session> sessions = new ArrayList<>();

    //Add a new user
    public void addUser(UserFitnessStats user) {
        userMap.put(user.getUserId(), user);
        System.out.println("User added successfully: " + user.getName());
    }

    //Search user by ID
    public UserFitnessStats searchUserById(String userId) {
        UserFitnessStats user = userMap.get(userId);
        if (user == null) {
            System.out.println("User not found.");
            return null;
        }
        System.out.println(user);
        return user;
    }

    //Average BMI calculation
    public double calculateAverageBMI() {
        if (userMap.isEmpty()) return 0;
        double totalBmi = 0;
        for (UserFitnessStats user : userMap.values()) {
            totalBmi += user.getBMI();
        }
        return totalBmi / userMap.size();
    }

    //Filter users by calories burned
    public void displayUsersByCalories(double minCalories) {
        boolean found = false;
        for (UserFitnessStats user : userMap.values()) {
            if (user.getCaloriesBurned() > minCalories) {
                System.out.println(user);
                found = true;
            }
        }
        if (!found) System.out.println("No users found above " + minCalories + " calories.");
    }

    // Add new session
    public void addSession(String userId) {
        UserFitnessStats user = userMap.get(userId);
        if (user != null) {
            Session newSession = new Session(
                    user.getWorkoutType().toString(),
                    user.getDuration(),
                    user.getCaloriesBurned(),
                    user.getBMI()
            );
            sessions.add(newSession);
            System.out.println("Session added for " + user.getName() + " on " + newSession.getDate());
        } else {
            System.out.println("User not found.");
        }
    }

    // Remove session by index (ID alternative)
    public void removeSession(int index) {
        if (index >= 0 && index < sessions.size()) {
            sessions.remove(index);
            System.out.println(" Session removed successfully.");
        } else {
            System.out.println("Invalid session index.");
        }
    }

    // Update stats if user logs another workout (recalculate BMI & calories)
    public void updateUserWorkout(String userId, int newDuration, double newWeight) {
        UserFitnessStats user = userMap.get(userId);
        if (user != null) {
            // Create new object with updated values
            UserFitnessStats updatedUser = new UserFitnessStats(
                    user.getUserId(),
                    user.getName(),
                    user.getWorkoutType(),
                    user.getAge(),
                    newDuration,
                    user.getHeight(),
                    newWeight
            );
            userMap.put(userId, updatedUser);
            System.out.println("Stats updated for " + updatedUser.getName());
        } else {
            System.out.println("User not found.");
        }
    }

    //  Top performer ranking (sort users by calories burned)
    public void displayTopPerformers() {
        List<UserFitnessStats> sorted = new ArrayList<>(userMap.values());
        sorted.sort((a, b) -> Double.compare(b.getCaloriesBurned(), a.getCaloriesBurned()));

        System.out.println("🏆 Top Performers:");
        int rank = 1;
        for (UserFitnessStats u : sorted) {
            System.out.println(rank + ". " + u.getName() + " - " + u.getCaloriesBurned() + " kcal");
            rank++;
        }
    }

    //  Count users per workout type
    public void countUsersPerWorkoutType() {
        HashMap<String, Integer> countMap = new HashMap<>();
        for (UserFitnessStats user : userMap.values()) {
            String type = user.getWorkoutType().toString();
            countMap.put(type, countMap.getOrDefault(type, 0) + 1);
        }

        System.out.println(" Users per workout type:");
        for (Map.Entry<String, Integer> entry : countMap.entrySet()) {
            System.out.println(entry.getKey() + ": " + entry.getValue());
        }
    }

    //  Save all data to file (CSV / text)
    public void saveDataToFile(String fileName) {
        try (PrintWriter writer = new PrintWriter(new FileWriter(fileName))) {
            writer.println("UserID,Name,WorkoutType,Age,Duration,Height,Weight,BMI,Calories");
            for (UserFitnessStats user : userMap.values()) {
                writer.println(user.getUserId() + "," + user.getName() + "," + user.getWorkoutType() + "," +
                        user.getAge() + "," + user.getDuration() + "," + user.getHeight() + "," +
                        user.getWeight() + "," + user.getBMI() + "," + user.getCaloriesBurned());
            }
            System.out.println(" Data saved to " + fileName);
        } catch (IOException e) {
            System.out.println(" Error saving data: " + e.getMessage());
        }
    }

    //  Session list with correct date
    public void showAllSessions() {
        if (sessions.isEmpty()) {
            System.out.println("No sessions recorded.");
            return;
        }
        int index = 0;
        for (Session s : sessions) {
            System.out.println("Session #" + index);
            System.out.println("Workout: " + s.getWorkoutType());
            System.out.println("Duration: " + s.getDuration() + " min");
            System.out.println("Calories: " + s.getCaloriesBurned());
            System.out.println("BMI: " + s.getBmi());
            System.out.println("Date: " + s.getDate());
            System.out.println("-----------------------------");
            index++;
        }
    }
}

class Main2 {
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
            sc.nextLine(); // consume newline

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
                    tracker.searchUserById(""); // This can be replaced with your tracker.showAllUsers() if added
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

