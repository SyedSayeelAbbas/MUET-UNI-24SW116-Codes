#include <iostream>
#include <conio.h>
#include <cmath>
using namespace std;

// Function to calculate the Islamic date
void convertToHijri(int day, int month, int year) {
    // Conversion algorithm from Gregorian to Hijri
    double jd, islYear, islMonth, islDay;

    // Julian day number (approximation)
    jd = 367 * year - floor((7 * (year + floor((month + 9) / 12))) / 4) + 
         floor((275 * month) / 9) + day + 1721013.5;
    
    // Hijri date calculation
    islYear = floor((30 * (jd - 1948439.5)) / 10631.0);
    islMonth = ceil(((jd - 1948439.5) - (10631.0 * islYear / 30.0)) / 29.5);
    islDay = ceil(jd - (1948439.5 + 10631.0 * islYear / 30.0) - (islMonth - 1) * 29.5);

    cout << "Islamic Date: " << islDay << "-" << islMonth << "-" << islYear + 1 << endl;
}

int main() {
    int day, month, year;
    string password;
    char a;

    // Password input
    cout << "Enter password to access your program: ";
    for (int i = 0; i < 4; i++) {
        a = getch(); // Hide input
        cout << "*"; // Display an asterisk for each character
        password += a;
    }

    // Check the password
    if (password == "Syed") {
        while (true) {
            // Input date, month, and year
            cout << "\nEnter date (1-31): "; 
            cin >> day;
            cout << "Enter month (1-12): "; 
            cin >> month;
            cout << "Enter year: "; 
            cin >> year;

            // Validate the date
            if (day < 1 || day > 31 || month < 1 || month > 12 || year < 1) {
                cout << "Invalid input! Please try again.\n";
                continue;
            }

            // Convert to Islamic date
            convertToHijri(day, month, year);

            // Prompt to continue or quit
            char input;
            cout << "\nPress any key to use it again\nOR press Q to Quit: ";
            input = getch();
            if (input == 'Q' || input == 'q') break; // Allow both uppercase and lowercase
        }
    } else {
        cout << "Incorrect password!";
    }

    return 0;
}
