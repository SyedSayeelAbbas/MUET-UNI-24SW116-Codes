/*Task 1:Create a program that declares and initializes variables to hold 
personal information such as name, marks, percentage, grade, and pass/fail status. 
The instructions also specify using all eight data types (int, float, double, char, bool, etc.) 
and explicitly assigning values to the variables.Finally, the program should print 
the values of these variables to the console.*/
#include <iostream>
using namespace std;
int main() {
    int marks = 85;
    float percentage = 85.5;
    double totalMarks = 100.0;
    char grade = 'A';
    bool passStatus = true;
    char name[] = "John Doe";
    cout << "Name: " << name << endl;
    cout << "Marks: " << marks << endl;
    cout << "Percentage: " << percentage << "%" << endl;
    cout << "Total Marks: " << totalMarks << endl;
    cout << "Grade: " << grade << endl;
    cout << "Pass Status: " << (passStatus ? "Pass" : "Fail") << endl;
    return 0;
}