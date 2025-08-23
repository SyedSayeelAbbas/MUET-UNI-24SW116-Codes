#include <iostream>
#include <conio.h>
#include <cmath>
#include <string>
using namespace std;

// Function to map month name to month number
int getMonthNumber(string monthName) {
    if (monthName == "jan") return 1;
    if (monthName == "feb") return 2;
    if (monthName == "mar") return 3;
    if (monthName == "apr") return 4;
    if (monthName == "may") return 5;
    if (monthName == "jun") return 6;
    if (monthName == "jul") return 7;
    if (monthName == "aug") return 8;
    if (monthName == "sep") return 9;
    if (monthName == "oct") return 10;
    if (monthName == "nov") return 11;
    if (monthName == "dec") return 12;
    return -1; // Invalid month
}

// Function to map Islamic month number to Islamic month name
string getIslamicMonthName(int islMonth) {
    string islamicMonths[] = {
        "Muharram", "Safar", "Rabi' al-Awwal", "Rabi' al-Thani", 
        "Jumada al-Awwal", "Jumada al-Thani", "Rajab", "Sha'ban", 
        "Ramadan", "Shawwal", "Dhu al-Qa'dah", "Dhu al-Hijjah"
    };
    return islamicMonths[islMonth - 1];
}

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

    // Output Islamic date with month name
    cout << "Islamic Date: " << islDay << " " << getIslamicMonthName(islMonth) << " " << islYear + 1 << endl;
}

int main() {
    int day, year;
    string monthName, password;
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
            cin.ignore(); // Ignore leftover newline
            cout << "Enter month (jan, feb, mar, etc.): "; 
            getline(cin, monthName);
            cout << "Enter year: "; 
            cin >> year;

            // Convert month name to number
            int month = getMonthNumber(monthName);
            
            // Validate the date
            if (day < 1 || day > 31 || month == -1 || year < 1) {
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
