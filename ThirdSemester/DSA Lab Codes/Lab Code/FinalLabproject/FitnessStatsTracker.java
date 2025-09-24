import java.util.*;

// A simple class to store details of each fitness user
class FitnessUser {
    private String id;
    private String personName;
    private double bmi;
    private int calories;
    private String workout; // Cardio, Strength, Yoga, etc.

    // constructor
    public FitnessUser(String id, String personName, double bmi, int calories, String workout) {
        this.id = id;
        this.personName = personName;
        this.bmi = bmi;
        this.calories = calories;
        this.workout = workout;
    }

    // getters
    public String getId() {
        return id;
    }

    public double getBmi() {
        return bmi;
    }

    public int getCalories() {
        return calories;
    }

    public String getWorkout() {
        return workout;
    }

    @Override
    public String toString() {
        return "User ID: " + id +
                "\nName: " + personName +
                "\nBMI: " + bmi +
                "\nCalories Burned: " + calories +
                "\nWorkout Type: " + workout +
                "\n---------------------------";
    }
}

// Main tracker class
public class FitnessStatsTracker {
    // storing all users using HashMap for quick searching
    private HashMap<String, FitnessUser> users = new HashMap<>();
    // we keep a list of BMIs separately for avg calculation
    private ArrayList<Double> bmiValues = new ArrayList<>();

    // add new user
    public void addUser(FitnessUser u) {
        users.put(u.getId(), u);
        bmiValues.add(u.getBmi());
    }

    // search a user by their ID
    public FitnessUser findUser(String id) {
        return users.get(id);
    }

    // calculate avg BMI of all users
    public double averageBmi() {
        if (bmiValues.size() == 0) return 0;
        double total = 0;
        for (double b : bmiValues) {
            total = total + b;
        }
        return total / bmiValues.size();
    }

    // show all users who burned more than given calories
    public void showHighCalories(int minCal) {
        System.out.println("\nUsers who burned more than " + minCal + " calories:");
        for (FitnessUser u : users.values()) {
            if (u.getCalories() > minCal) {
                System.out.println(u);
            }
        }
    }

    // count how many users are in each workout type
    public void workoutStats() {
        HashMap<String, Integer> counter = new HashMap<>();
        for (FitnessUser u : users.values()) {
            String type = u.getWorkout();
            if (counter.containsKey(type)) {
                counter.put(type, counter.get(type) + 1);
            } else {
                counter.put(type, 1);
            }
        }
        System.out.println("\nUsers per workout type:");
        for (String t : counter.keySet()) {
            System.out.println(t + ": " + counter.get(t));
        }
    }

    // main testing
    public static void main(String[] args) {
        FitnessStatsTracker tracker = new FitnessStatsTracker();

        // adding sample data
        tracker.addUser(new FitnessUser("U101", "Ali", 22.5, 400, "Cardio"));
        tracker.addUser(new FitnessUser("U102", "Sara", 25.1, 600, "Strength"));
        tracker.addUser(new FitnessUser("U103", "John", 20.7, 300, "Yoga"));
        tracker.addUser(new FitnessUser("U104", "Maria", 28.2, 700, "Cardio"));
        tracker.addUser(new FitnessUser("U105", "Omar", 23.9, 550, "Strength"));

        // testing search
        System.out.println("Looking for user U102:");
        System.out.println(tracker.findUser("U102"));

        // testing avg BMI
        System.out.println("\nAverage BMI of all users: " + tracker.averageBmi());

        // testing calories filter
        tracker.showHighCalories(500);

        // testing workout counter
        tracker.workoutStats();
    }
}

