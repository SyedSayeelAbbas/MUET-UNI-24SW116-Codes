#include <iostream>
#include <string>
#include <vector>
#include <fstream>
#include <iomanip>\























































































































using namespace std;

// Structure to represent a patient
struct Patient {
    int patientID;
    string name;
    int age;
    string gender;
    string disease;
    string assignedDoctor;
    bool isDischarged;

    // Constructor to initialize a patient
    Patient(int id, const string& name, int age, const string& gender, const string& disease, const string& doctor)
        : patientID(id), name(name), age(age), gender(gender), disease(disease), assignedDoctor(doctor), isDischarged(false) {}
};

class HospitalManagementSystem {
private:
    vector<Patient> patients;
    int nextPatientID;

public:
    HospitalManagementSystem() : nextPatientID(1) {}

    // Function to register a new patient
    void registerPatient() {
        string name, gender, disease, doctor;
        int age;
        cout << "Enter patient name: ";
        cin.ignore();  // To handle the leftover newline character
        getline(cin, name);
        cout << "Enter age: ";
        cin >> age;
        cout << "Enter gender: ";
        cin.ignore();
        getline(cin, gender);
        cout << "Enter disease: ";
        getline(cin, disease);
        cout << "Enter assigned doctor's name: ";
        getline(cin, doctor);

        // Create new patient and add to the patient list
        Patient newPatient(nextPatientID++, name, age, gender, disease, doctor);
        patients.push_back(newPatient);
        cout << "Patient registered successfully with Patient ID: " << newPatient.patientID << endl;
    }

    // Function to assign a doctor to a patient
    void assignDoctor() {
        int patientID;
        string doctor;
        cout << "Enter patient ID: ";
        cin >> patientID;
        bool found = false;

        for (auto& patient : patients) {
            if (patient.patientID == patientID && !patient.isDischarged) {
                cout << "Enter new doctor's name: ";
                cin.ignore();
                getline(cin, doctor);
                patient.assignedDoctor = doctor;
                found = true;
                cout << "Doctor assigned to patient " << patientID << endl;
                break;
            }
        }

        if (!found) {
            cout << "Patient not found or already discharged.\n";
        }
    }

    // Function to discharge a patient
    void dischargePatient() {
        int patientID;
        cout << "Enter patient ID to discharge: ";
        cin >> patientID;
        bool found = false;

        for (auto& patient : patients) {
            if (patient.patientID == patientID && !patient.isDischarged) {
                patient.isDischarged = true;
                found = true;
                cout << "Patient " << patientID << " has been discharged.\n";
                break;
            }
        }

        if (!found) {
            cout << "Patient not found or already discharged.\n";
        }
    }

    // Function to view all patients
    void viewPatients() {
        cout << "\n----- Patient Records -----\n";
        cout << "ID\tName\tAge\tGender\tDisease\tAssigned Doctor\tDischarged\n";
        for (const auto& patient : patients) {
            cout << patient.patientID << "\t" << patient.name << "\t" << patient.age << "\t" 
                 << patient.gender << "\t" << patient.disease << "\t" << patient.assignedDoctor 
                 << "\t" << (patient.isDischarged ? "Yes" : "No") << endl;
        }
    }

    // Function to save patients data to file
    void saveData() {
        ofstream outFile("patients.txt");
        for (const auto& patient : patients) {
            outFile << patient.patientID << ","
                    << patient.name << ","
                    << patient.age << ","
                    << patient.gender << ","
                    << patient.disease << ","
                    << patient.assignedDoctor << ","
                    << patient.isDischarged << "\n";
        }
        outFile.close();
        cout << "Patient data saved to file.\n";
    }

    // Function to load patients data from file
    void loadData() {
        ifstream inFile("patients.txt");
        if (!inFile) {
            cout << "No data file found. Starting fresh.\n";
            return;
        }

        string name, gender, disease, doctor;
        int patientID, age, isDischarged;
        while (inFile) {
            inFile >> patientID;
            inFile.ignore();  // Ignore the comma
            getline(inFile, name, ',');
            inFile >> age;
            inFile.ignore();  // Ignore the comma
            getline(inFile, gender, ',');
            getline(inFile, disease, ',');
            getline(inFile, doctor, ',');
            inFile >> isDischarged;
            inFile.ignore();  // Ignore the newline character

            if (inFile) {
                Patient patient(patientID, name, age, gender, disease, doctor);
                patient.isDischarged = (isDischarged == 1);
                patients.push_back(patient);
            }
        }
        inFile.close();
        cout << "Patient data loaded from file.\n";
    }
};

// Main menu function
void showMenu(HospitalManagementSystem& system) {
    int choice;
    do {
        cout << "\n----- Hospital Management System -----\n";
        cout << "1. Register New Patient\n";
        cout << "2. Assign Doctor to Patient\n";
        cout << "3. Discharge Patient\n";
        cout << "4. View All Patients\n";
        cout << "5. Save Patient Data\n";
        cout << "6. Load Patient Data\n";
        cout << "7. Exit\n";
        cout << "Enter your choice: ";
        cin >> choice;

        switch (choice) {
            case 1:
                system.registerPatient();
                break;
            case 2:
                system.assignDoctor();
                break;
            case 3:
                system.dischargePatient();
                break;
            case 4:
                system.viewPatients();
                break;
            case 5:
                system.saveData();
                break;
            case 6:
                system.loadData();
                break;
            case 7:
                cout << "Exiting the system...\n";
                break;
            default:
                cout << "Invalid choice. Please try again.\n";
        }
    } while (choice != 7);
}

int main() {
    HospitalManagementSystem system;
    system.loadData();  // Load existing data from file if available

    // Show the main menu
    showMenu(system);

    return 0;
}