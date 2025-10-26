import java.util.*;
import java.time.LocalDate;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.FileWriter;
import java.io.BufferedWriter;
import java.io.PrintWriter;

class UserFitnessStats {
    private String userId, name;
    private String workoutType;
    private int age, duration;
    private double height, weight, caloriesBurned, bmi;

    public UserFitnessStats(String userId, String name, String workoutType, int age, int duration,
                            double height, double weight) {
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
        this.bmi = calculateBMI();
        this.caloriesBurned = calculateCaloriesBurned();
    }

    public String getUserId(){
        return userId;
    }
    public String getName(){
        return name;
    }
    public String getWorkoutType(){
        return workoutType;
    }
    public int getAge(){
        return age;
    }
    public int getDuration(){
        return duration;
    }
    public double getHeight(){
        return height;
    }
    public double getWeight(){
        return weight;
    }
    public double getBMI(){
        return bmi;
    }
    public double getCaloriesBurned(){
        return caloriesBurned;
    }

    private double calculateBMI(){
        double heightInMeters = this.height * 0.3048;
        return this.weight / (heightInMeters * heightInMeters);
    }

    private double getMET(String  type){
        double baseMET;

        switch (type) {
            case ("Cardio"):{
                baseMET = 7.0;
            } break;
            case ("Strength"):{
                baseMET = 6.0;
            } break;
            case ("Yoga"):{
                baseMET = 3.0;
            } break;
            case ("HIIT"):{
                baseMET = 9.0;
            } break;
            case ("Cycling"):{
                baseMET = 8.0;
            } break;
            case ("Walking"):{
                baseMET = 4.0;
            } break;
            default:{
                throw new IllegalStateException("Invalid workout type");
            }
        }
        double ageMultiplier;
        if (age < 25){
            ageMultiplier = 1.05;
        }
        else if (age <= 35){
            ageMultiplier = 1.00;
        }
        else if (age <= 45){
            ageMultiplier = 0.98;
        }
        else if (age <= 60){
            ageMultiplier = 0.95;
        }
        else{
            ageMultiplier = 0.92;
        }

        double bmiMultiplier;
        if (bmi < 18.5){
            bmiMultiplier = 0.95;
        }
        else if (bmi <= 24.9){
            bmiMultiplier = 1.00;
        }
        else if (bmi <= 29.9){
            bmiMultiplier = 1.10;
        }
        else{
            bmiMultiplier = 1.15;
        }
        double answer=(baseMET * ageMultiplier * bmiMultiplier);
        return answer;
    }

    private double calculateCaloriesBurned(){
        double met = getMET(this.workoutType);
        double hours = this.duration / 60.0;
        return met * this.weight * hours;
    }

    public String getBMICategory(){
        if (bmi < 18.5) return "Underweight";
        if (bmi <= 24.9) return "Normal";
        if (bmi <= 29.9) return "Overweight";
        return "Obese";
    }

    @Override
    public String toString(){
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
        s.append("*");
        return s.toString();
    }
}

class Session {
    private String workoutType;
    private int duration;
    private double caloriesBurned;
    private double bmi;
    private LocalDate date;
    private static int sessionCounter = 0;
    private int sessionId;

    public Session(String workoutType, int duration, double caloriesBurned, double bmi){
        this.sessionId = ++sessionCounter;
        this.workoutType = workoutType;
        this.duration = duration;
        this.caloriesBurned = caloriesBurned;
        this.bmi = bmi;
        this.date = LocalDate.now();
    }

    public int getSessionId(){
        return sessionId;
    }
    public String getWorkoutType(){
        return workoutType;
    }
    public int getDuration(){
        return duration;
    }
    public double getCaloriesBurned(){
        return caloriesBurned;
    }
    public double getBmi(){
        return bmi;
    }
    public LocalDate getDate(){
        return date;
    }
}

public class FitnessStatsTracker {
    private HashMap<String, UserFitnessStats> userMap = new HashMap<>();
    private ArrayList<Session> sessions = new ArrayList<>();

    public Collection<UserFitnessStats> getAllUsers() {
        return userMap.values();
    }

    public void addUser(UserFitnessStats user){
        userMap.put(user.getUserId(), user);
        System.out.println("User added successfully: " + user.getName());
    }

    public UserFitnessStats searchUserById(String userId){
        UserFitnessStats user = userMap.get(userId);
        if (user == null){
            System.out.println("User not found.");
            return null;
        }
        System.out.println(user);
        return user;
    }

    public double calculateAverageBMI(){
        if (userMap.isEmpty()) return 0;
        double totalBmi = 0;
        for (UserFitnessStats user : userMap.values()){
            totalBmi += user.getBMI();
        }
        return totalBmi / userMap.size();
    }

    public void displayUsersByCalories(double minCalories){
        boolean found = false;
        for (UserFitnessStats user : userMap.values()){
            if (user.getCaloriesBurned() > minCalories){
                System.out.println(user);
                found = true;
            }
        }
        if (!found) System.out.println("No users found above " + minCalories + " calories.");
    }

    public void addSession(String userId){
        UserFitnessStats user = userMap.get(userId);
        if (user != null){
            Session newSession = new Session(
                    user.getWorkoutType(),
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

    public void removeSession(int index){
        if (index >= 0 && index < sessions.size()) {
            sessions.remove(index);
            System.out.println(" Session removed successfully.");
        } else {
            System.out.println("Invalid session index.");
        }
    }

    public void updateSession(int index, String newWorkoutType, int newDuration) {
        if (index >= 0 && index < sessions.size()) {
            Session s = sessions.get(index);
            sessions.set(index, new Session(
                    newWorkoutType,
                    newDuration,
                    s.getCaloriesBurned(), // or recalculate if needed
                    s.getBmi()
            ));
            System.out.println("Session updated successfully.");
        } else {
            System.out.println("Invalid session index.");
        }
    }


    public void updateUserWorkout(String userId, int newDuration, double newWeight){
        UserFitnessStats user = userMap.get(userId);
        if (user != null) {
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

    public void displayTopPerformers() {
        List<UserFitnessStats> sorted = new ArrayList<>(userMap.values());
        Collections.sort(sorted, (u1, u2) -> Double.compare(u2.getCaloriesBurned(), u1.getCaloriesBurned()));

        System.out.println(" Top Performers:");
        for (int i = 0; i < sorted.size(); i++) {
            UserFitnessStats u = sorted.get(i);
            System.out.println((i + 1) + ". " + u.getName() + " - " + u.getCaloriesBurned() + " kcal");
        }
    }

    public void showAllSessions(){
        if (sessions.isEmpty()){
            System.out.println("No sessions recorded.");
            return;
        }
        int index = 0;
        for (Session s : sessions){
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

    public void showBMICategoryCount(){
        int underweight = 0, normal = 0, overweight = 0, obese = 0;
        for (UserFitnessStats user : userMap.values()) {
            String category = user.getBMICategory();
            switch (category) {
                case "Underweight": underweight++; break;
                case "Normal": normal++; break;
                case "Overweight": overweight++; break;
                case "Obese": obese++; break;
            }
        }
        System.out.println("\n BMI Category Count:");
        System.out.println("Underweight: " + underweight);
        System.out.println("Normal: " + normal);
        System.out.println("Overweight: " + overweight);
        System.out.println("Obese: " + obese);
    }

    public void showWorkoutTypeCount() {
        HashMap<String, Integer> typeCount = new HashMap<>();
        for (UserFitnessStats user : userMap.values()) {
            String type = user.getWorkoutType();
            typeCount.put(type, typeCount.getOrDefault(type, 0) + 1);
        }

        System.out.println("\nWorkout Type Count:");
        for (Map.Entry<String, Integer> entry : typeCount.entrySet()) {
            System.out.println(entry.getKey() + ": " + entry.getValue());
        }
    }

    public void loadUsersFromCSV(String filePath) {
        String line = "";
        int count = 0;
        int lineNumber = 0;

        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            String header = br.readLine(); // skip header
            lineNumber++;

            while ((line = br.readLine()) != null) {
                lineNumber++;
                String[] values = line.split(",");

                try {
                    String userId, name, workoutType;
                    int age, duration;
                    double height, weight;

                    if (values.length >= 10) {

                        age = (int) Double.parseDouble(values[0].trim());
                        String gender = values[1].trim();
                        weight = Double.parseDouble(values[2].trim());
                        height = Double.parseDouble(values[3].trim()) * 3.281;
                        double calories = Double.parseDouble(values[8].trim());
                        workoutType = values[9].trim();

                        userId = "K" + count;
                        name = gender + "_" + age;
                        duration = (int) (calories / 10);

                    } else if (values.length >= 7) {
                        userId = values[0].trim();
                        name = values[1].trim();
                        workoutType = values[2].trim();
                        age = Integer.parseInt(values[3].trim());
                        duration = Integer.parseInt(values[4].trim());
                        height = Double.parseDouble(values[5].trim());
                        weight = Double.parseDouble(values[6].trim());
                    } else {
                        System.out.println("Skipping invalid row: " + line);
                        continue;
                    }

                    UserFitnessStats user = new UserFitnessStats(
                            userId, name, workoutType, age, duration, height, weight
                    );
                    userMap.put(userId, user);
                    count++;

                } catch (Exception e) {
                    System.out.println("Skipping invalid row at line " + lineNumber + ": " + line);
                }
            }

            System.out.println("Loaded " + count + " users from " + filePath + " successfully.");

        } catch (IOException e) {
            System.out.println("Error reading CSV file: " + e.getMessage());
        }
    }


}

class calo{
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        FitnessStatsTracker tracker = new FitnessStatsTracker();
        boolean running = true;
        String csvPath = "src/fitness_data.csv";

        while (running) {
            System.out.println("\n================= FITNESS TRACKER MENU =================");
            System.out.println("1)  Add New User");
            System.out.println("2)  Add Workout Session");
            System.out.println("3)  Show All Users");
            System.out.println("4)  Show All Sessions");
            System.out.println("5)  Search User by ID");
            System.out.println("6)  Show Average BMI");
            System.out.println("7)  Filter Users by Calories Burned");
            System.out.println("8)  Remove Session");
            System.out.println("9)  Show Top Performers");
            System.out.println("10) Update Session");
            System.out.println("11) BMI Category Count");
            System.out.println("12)Count users per workout type (Cardio, Strength, Yoga, etc.)");
            System.out.println("13) Load Users from CSV File");
            System.out.println("0)  Exit");
            System.out.println("============================================================");
            System.out.print(" Enter your choice: ");

            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    System.out.print("Enter User ID: ");
                    String userId = scanner.next();
                    System.out.print("Enter Name: ");
                    String name = scanner.next();
                    System.out.print("Enter Workout Type (Cardio, Strength, etc.): ");
                    String workoutType = scanner.next();
                    System.out.print("Enter Age: ");
                    int age = scanner.nextInt();
                    System.out.print("Enter Duration (min): ");
                    int duration = scanner.nextInt();
                    System.out.print("Enter Height (ft): ");
                    double height = scanner.nextDouble();
                    System.out.print("Enter Weight (kg): ");
                    double weight = scanner.nextDouble();

                    try {
                        UserFitnessStats user = new UserFitnessStats(userId, name, workoutType, age, duration, height, weight);
                        tracker.addUser(user);

                        try (FileWriter fw = new FileWriter(csvPath, true);
                             BufferedWriter bw = new BufferedWriter(fw);
                             PrintWriter out = new PrintWriter(bw)) {


                            java.io.File file = new java.io.File(csvPath);
                            if (file.length() == 0) {
                                out.println("UserID,Name,WorkoutType,Age,Duration,Height,Weight");
                            }

                            out.println(userId + "," + name + "," + workoutType + "," + age + "," + duration + "," + height + "," + weight);
                            System.out.println("User saved to CSV file: " + csvPath);

                        } catch (IOException e) {
                            System.out.println("Error saving user to CSV: " + e.getMessage());
                        }

                    } catch (IllegalArgumentException e) {
                        System.out.println("Error: " + e.getMessage());
                    }
                    break;

                case 2:
                    System.out.print("Enter User ID for session: ");
                    String uid = scanner.nextLine();
                    tracker.addSession(uid);
                    break;

                case 3:
                    for (UserFitnessStats u : tracker.getAllUsers()) {
                        System.out.println(u);
                    }
                    break;

                case 4:
                    tracker.showAllSessions();
                    break;

                case 5:
                    System.out.print("Enter User ID to search: ");
                    String searchId = scanner.nextLine();
                    tracker.searchUserById(searchId);
                    break;

                case 6:
                    double avgBmi = tracker.calculateAverageBMI();
                    System.out.printf("Average BMI of all users: %.2f%n", avgBmi);
                    break;

                case 7:
                    System.out.print("Enter minimum calories burned to filter: ");
                    double minCal = scanner.nextDouble();
                    tracker.displayUsersByCalories(minCal);
                    break;

                case 8:
                    System.out.print("Enter session index to remove: ");
                    int index = scanner.nextInt();
                    tracker.removeSession(index);
                    break;

                case 9:
                    tracker.displayTopPerformers();
                    break;

                case 10:
                    System.out.print("Enter session index to update: ");
                    int updateIndex = scanner.nextInt();
                    scanner.nextLine();
                    System.out.print("Enter new workout type: ");
                    String newType = scanner.nextLine();
                    System.out.print("Enter new duration: ");
                    int newDuration = scanner.nextInt();
                    tracker.updateSession(updateIndex, newType, newDuration);
                    break;

                case 11:
                    tracker.showBMICategoryCount();
                    break;

                case 12:
                    tracker.showWorkoutTypeCount();
                    break;

                case 13:
                    System.out.print("Enter CSV file path : ");
                    csvPath = scanner.nextLine();
                    tracker.loadUsersFromCSV(csvPath);
                    break;

                case 0:
                    System.out.println("Exiting Fitness Tracker");
                    running = false;
                    break;

                default:
                    System.out.println("Invalid choice! Please try again.");
            }
        }
        scanner.close();
    }
}
