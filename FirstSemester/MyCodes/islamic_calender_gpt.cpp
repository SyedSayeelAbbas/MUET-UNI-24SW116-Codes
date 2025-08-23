#include <iostream>
#include <conio.h>
#include <cmath>
using namespace std;

int main() {
    float d, y, j;
    string m, password;
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
            cin >> d;
            cin.ignore(); // Ignore leftover newline
            cout << "Enter month (jan, feb, mar, apr, may, jun, jul, aug, sep, oct, nov, dec): "; 
            getline(cin, m);
            cout << "Enter Year: "; 
            cin >> y;

            // Convert Gregorian year to Islamic year
            y = ((y - 622) * 33) / 32;
            j = round(y); // Round the year

            // Determine Islamic date based on month and date
            if (m == "jan") {
                if (d >= 1 && d <= 12) {
                    cout << "The Islamic Date of your input is: " << d + 18 << "- Jumada al-Awwal - " << j - 1;
                } else {
                    cout << "The Islamic Date of your input is: " << d - 12 << "- Jumada al-Thani - " << j - 1;
                }
            } else if (m == "feb") {
                if (d >= 1 && d <= 10) {
                    cout << "The Islamic Date of your input is: " << d + 20 << "- Jumada al-Thani - " << j - 1;
                } else {
                    cout << "The Islamic Date of your input is: " << d - 10 << "- Rajab - " << j - 1;
                }
            } else if (m == "mar") {
                if (d >= 1 && d <= 10) {
                    cout << "The Islamic Date of your input is: " << d + 20 << "- Rajab - " << j - 1;
                } else {
                    cout << "The Islamic Date of your input is: " << d - 10 << "- Shaban - " << j - 1;
                }
            } else if (m == "apr") {
                if (d >= 1 && d <= 9) {
                    cout << "The Islamic Date of your input is: " << d + 21 << "- Shaban - " << j - 1;
                } else {
                    cout << "The Islamic Date of your input is: " << d - 9 << "- Ramadan - " << j - 1;
                }
            } else if (m == "may") {
                if (d >= 1 && d <= 9) {
                    cout << "The Islamic Date of your input is: " << d + 22 << "- Ramadan - " << j - 1;
                } else {
                    cout << "The Islamic Date of your input is: " << d - 9 << "- Shawwal - " << j - 1;
                }
            } else if (m == "jun") {
                if (d >= 1 && d <= 7) {
                    cout << "The Islamic Date of your input is: " << d + 23 << "- Shawwal - " << j - 1;
                } else {
                    cout << "The Islamic Date of your input is: " << d - 8 << "- Dhu al-Qa'dah - " << j - 1;
                }
            } else if (m == "jul") {
                if (d >= 1 && d <= 7) {
                    cout << "The Islamic Date of your input is: " << d + 24 << "- Dhu al-Qa'dah - " << j - 1;
                } else {
                    cout << "The Islamic Date of your input is: " << d - 13 << "- Dhu al-Hijjah - " << j - 1;
                }
            } else if (m == "aug") {
                if (d >= 1 && d <= 7) {
                    cout << "The Islamic Date of your input is: " << d + 26 << "- Dhu al-Hijjah - " << j - 1;
                } else {
                    cout << "The Islamic Date of your input is: " << d - 7 << "- Muharram - " << j;
                }
            } else if (m == "sep") {
                if (d >= 1 && d <= 3) {
                    cout << "The Islamic Date of your input is: " << d + 27 << "- Muharram - " << j;
                } else {
                    cout << "The Islamic Date of your input is: " << d - 3 << "- Safar - " << j;
                }
            } else if (m == "oct") {
                if (d >= 1 && d <= 3) {
                    cout << "The Islamic Date of your input is: " << d + 27 << "- Safar - " << j;
                } else {
                    cout << "The Islamic Date of your input is: " << d - 3 << "- Rabi' al-Awwal - " << j;
                }
            } else if (m == "nov") {
                if (d >= 1 && d <= 2) {
                    cout << "The Islamic Date of your input is: " << d + 28 << "- Rabi' al-Awwal - " << j;
                } else {
                    cout << "The Islamic Date of your input is: " << d - 10 << "- Rabi' al-Thani - " << j;
                }
            } else if (m == "dec") {
                if (d >= 1 && d <= 10) {
                    cout << "The Islamic Date of your input is: " << d << "- Rabi' al-Thani - " << j;
                } else if (d >= 11 && d <= 30) {
                    cout << "The Islamic Date of your input is: " << d - 10 << "- Jumada al-Awwal - " << j;
                } else {
                    cout << "The Islamic Date of your input is: " << d - 30 << "- Jumada al-Thani - " << j;
                }
            } else {
                cout << "Something went wrong. Please enter a valid date (1 to 31) and month (in lowercase)!\n";
            }

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
