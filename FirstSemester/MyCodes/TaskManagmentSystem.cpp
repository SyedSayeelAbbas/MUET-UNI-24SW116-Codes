#include <iostream>
#include <windows.h>
#include <conio.h>
#include <vector>
#include <string>
using namespace std;

void showloading(){
    system("cls");
    for(int i=0;i<2;i++){
        cout<<"Thanks For choosing,Plz wait!^-^"<<endl;
        for(int j=0;j<2;j++)
        {
        Sleep(500);
        cout<<">>>";
        }
        Sleep(250);
        system("cls");
    }
    system("cls");
}
void processing(){
    system("cls");
    for(int i=0;i<2;i++){
        cout<<"Processing Data*-*"<<endl;
        for(int j=0;j<2;j++)
        {
        Sleep(500);
        cout<<"?????";
        }
        Sleep(250);
        system("cls");
    }
}
// Structure to manage Assignees
struct Assignee {
    string id,name,email,phone;
};

// Structure to manage Tasks
struct Task {
    string taskId,assigneeId,taskName,status;
};

// Structure to manage Checklist Items
struct ChecklistItem {
    string taskId;
    vector<string> items;
    vector<bool> completionStatus; // It will Check if each checklist item is completed
};
// Class for the Task Management System
class TaskManagementSystem {
private:
    vector<Assignee> assignees;
    vector<Task> tasks;
    vector<ChecklistItem> checklists;

public:
    // Add Assignee
    void addAssignee() {
    showloading();
        Assignee a;
        cout<<"Enter Assignee ID: ";
        cin>>a.id;
        cout<<"Enter Name: ";
        cin.ignore();
        getline(cin, a.name);
        cout<<"Enter Email: ";
        cin>>a.email;
        cout<<"Enter Phone Number: ";
        cin>>a.phone;
        assignees.push_back(a);//to store
        processing();
        cout<<"You have Successfully added a Assignee!^_^!\n\n";
        cout<<"Press any key to continue"; getch();
        system("cls");
    }

    // View All Assignees
    void viewAssignees() {
    showloading();
        if (assignees.empty()) {
            cout<<"Rigth Now There is no assignees available!(?_?!)\n";
        cout<<"Press any key to continue"; getch();
        system("cls");
            return;
        }
        cout<<"\n\t\t\t{Assignees}\n";
        cout<<"----------------------------------------------------------------------------------\n";
        for (const auto& a : assignees) {
            cout<<"ID No is: "<<a.id<<"\nName of Assignee is: "<<a.name
            <<"\nEmail Of "<<a.name<<" is :"<< a.email<<"\nPhone is: "<<a.phone<<
            "\n----------------------------------------------------------------------------------\n\n";
        }
        cout<<"Press any key to continue"; getch();
        system("cls");
    }

    // Update Assignee
    void updateAssignee() {
    showloading();
        string id;
        cout << "Enter Assignee ID to update: ";
        cin >> id;
    processing();
        for (auto& a : assignees) {
            if (a.id == id) {
                cout << "Enter new Name: ";
                cin.ignore();
                getline(cin, a.name);
                cout << "Enter new Email: ";
                cin >> a.email;
                cout << "Enter new Phone: ";
                cin >> a.phone;
                processing();
                cout << "Assignee updated successfully!\n\n";
                cout<<"Press any key to continue."; getch();
                return;
            }
        }
        cout << "Assignee not found.\n\n";
        cout<<"Press any key to continue."; getch();
    }

    // Delete Assignee
    void deleteAssignee() {
    showloading();
        string id;
        cout << "Enter Assignee ID to delete: ";
        cin >> id;
    processing();
        for (size_t i = 0; i < assignees.size(); ++i) {
            if (assignees[i].id == id) {
                assignees.erase(assignees.begin() + i);
                cout << "Assignee deleted successfully!\n\n";
                cout<<"Press any Key to continue."; getch();
                return;
            }
        }
        cout << "Assignee not found.\n\n";
        cout<<"Press any Key to countinue."; getch();
    }

    // Add Task
    void addTask() {
    showloading();
        Task t;
        cout << "Enter Task ID: ";
        cin >> t.taskId;
        cout << "Enter Assignee ID: ";
        cin >> t.assigneeId;
        cout << "Enter Task Name: ";
        cin.ignore();
        getline(cin, t.taskName);
        cout << "Enter Task Status (Pending/In Progress/Completed): ";
        cin >> t.status;
        tasks.push_back(t);
    processing();
        cout << "Task added successfully!\n";
        cout<<"Press any Key to countinue."; getch();
    }

    // View Tasks for an Assignee
    void viewTasks() {
    showloading();
        string assigneeId;
        cout << "Enter Assignee ID to view tasks: ";
        cin >> assigneeId;
    processing();
        cout << "\n--- Tasks ---\n";
        for (const auto& t : tasks) {
            if (t.assigneeId == assigneeId) {
                cout<<"Task ID: " << t.taskId <<", Name: "<<t.taskName
                <<", Status: "<<t.status<<"\n";
            }
        }
        cout<<"Press any Key to countinue."; getch();
    }

    // Update Task
    void updateTask() {
    showloading();
        string taskId;
        cout << "Enter Task ID to update: ";
        cin >> taskId;
    processing();
        for (auto& t : tasks) {
            if (t.taskId == taskId) {
                cout << "Enter new Task Name: ";
                cin.ignore();
                getline(cin, t.taskName);
                cout << "Enter new Task Status: ";
                cin >> t.status;
    processing();
                cout << "Task updated successfully!\n";
                cout<<"Press any Key to countinue."; getch();
                return;
            }
        }
        cout << "Task not found.\n";
        cout<<"Press any Key to countinue."; getch();
    }

    // Delete Task
    void deleteTask() {
    showloading();
        string taskId;
        cout << "Enter Task ID to delete: ";
        cin >> taskId;
    processing();
        for (size_t i = 0; i < tasks.size(); ++i) {
            if (tasks[i].taskId == taskId) {
                tasks.erase(tasks.begin() + i);
                cout << "Task deleted successfully!\n";
                cout<<"Press any Key to countinue."; getch();
                return;
            }
        }
        cout << "Task not found.\n";
        cout<<"Press any Key to countinue."; getch();
    }

    // Add Checklist
    void addChecklist() {
    showloading();
        ChecklistItem c;
        cout << "Enter Task ID to add a checklist: ";
        cin >> c.taskId;
        int numItems;
        cout << "Enter the number of checklist items: ";
        cin >> numItems;
        cin.ignore();
        for (int i = 0; i < numItems; ++i) {
            string item;
            cout << "Enter item " << i + 1 << ": ";
            getline(cin, item);
            c.items.push_back(item);
            c.completionStatus.push_back(false); // Initially not completed
        }
        checklists.push_back(c);
    processing();
        cout << "Checklist added successfully!\n";
        cout<<"Press any Key to countinue."; getch();
    }

    // View Checklist
    void viewChecklist() {
    showloading();
        string taskId;
        cout << "Enter Task ID to view checklist: ";
        cin >> taskId;
    processing();
        for (const auto& c : checklists) {
            if (c.taskId == taskId) {
                cout << "\n--- Checklist ---\n";
                for (size_t i = 0; i < c.items.size(); ++i) {
                    cout << (i + 1) << ". " << c.items[i]
                         << " [" << (c.completionStatus[i] ? "Completed" : "Pending") << "]\n";
                }
                cout<<"Press any Key to countinue."; getch();
                return;
            }
        }
        cout << "Checklist not found.\n";
        cout<<"Press any Key to countinue."; getch();
    }

    // Update Checklist
    void updateChecklist() {
        showloading();
        string taskId;
        cout<<"Enter Task ID to update checklist: ";
        cin>>taskId;

        for (auto& c : checklists) {
            if (c.taskId == taskId) {
                int index;
                cout<<"Enter the checklist item number to mark as completed: ";
                cin>>index;
                if (index > 0 && index <= c.items.size()) {
                    c.completionStatus[index - 1] = true;
                    processing();
                    cout<<"Checklist item marked as completed!\n";
                }
                else {
                    processing();
                    cout<<"Invalid item number.\n";
                }
                cout<<"Press any Key to countinue."; getch();
                return;
            }
        }
        cout<<"Checklist not found.\n";
        cout<<"Press any Key to countinue."; getch();
    }

    // Generate Report
    void generateReport() {
        showloading();
        string assigneeId;
        cout<<"Enter Assignee ID to generate report: ";
        cin>>assigneeId;
        processing();
        for (const auto& a : assignees) {
            if (a.id == assigneeId) {
                cout << "\n--- Report for " << a.name << " ---\n";
                cout << "\nEmail: " << a.email << "\nPhone: " << a.phone << "\n\n";

                cout << "--- Tasks ---\n";
                for (const auto& t : tasks) {
                    if (t.assigneeId == assigneeId) {
                        cout << "\nTask ID: " << t.taskId << "\nName: " << t.taskName
                             << "\nStatus: " << t.status << "\n";

                        // Check for checklist items
                        for (const auto& c : checklists) {
                            if (c.taskId == t.taskId) {
                                cout << "Checklist:\n";
                                for (size_t i = 0; i < c.items.size(); ++i) {
                                    cout << "  - " << c.items[i]
                                         << " [" << (c.completionStatus[i] ? "Completed" : "Pending") << "]\n";
                                }
                            }
                        }
                    }
                }
                cout<<"Press any Key to countinue."; getch();
                return;
            }
        }
        cout << "Assignee not found.\n";
        cout<<"Press any Key to countinue."; getch();
    }
};

int main() {
    cout<<"\t\tProgram Starting"<<endl;
    for(int i=0;i<9;i++){
        Sleep(250);
        cout<<"////////";
    }
    system("cls");
    TaskManagementSystem system;
    int choice;
    do {
        cout<<"\t-*-{Task Management System}-*-\n============================================="<<endl;
        cout<<"1. Add Assignee\t\t2. View Assignees\n3. Update Assignee\t4. Delete Assignee\n";
        cout<<"5. Add Task\t\t6. View Tasks\n7. Update Task\t\t8. Delete Task\n";
        cout<<"9. Add Checklist\t10. View Checklist\n11. Update Checklist\t12. Generate Report\n";
        cout<<"============================================="<<endl;
        cout<<"\t**Choose '0' To Exit The System**\n";
        cout<<"Enter your choice: ";
        cin>>choice;
        switch (choice) {
            case 1: system.addAssignee(); break;
            case 2: system.viewAssignees(); break;
            case 3: system.updateAssignee(); break;
            case 4: system.deleteAssignee(); break;
            case 5: system.addTask(); break;
            case 6: system.viewTasks(); break;
            case 7: system.updateTask(); break;
            case 8: system.deleteTask(); break;
            case 9: system.addChecklist(); break;
            case 10: system.viewChecklist(); break;
            case 11: system.updateChecklist(); break;
            case 12: system.generateReport(); break;
            case 0:  cout << "Exiting...\n"; break;
            default: cout << "Invalid choice.\n";
        }
    } while (choice != 0);

    return 0;
}