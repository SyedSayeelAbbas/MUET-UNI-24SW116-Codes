#include <iostream>
#include <conio.h>
#include <windows.h>
#include <cmath>
#include <string>
using namespace std;

// Class to map month names to numbers and vice versa
class monthnumber {
public:
    static int getMonthNumber(string monthName) {
        if (monthName == "jan") return 1;
        else if (monthName == "feb") return 2;
        else if (monthName == "mar") return 3;
        else if (monthName == "apr") return 4;
        else if (monthName == "may") return 5;
        else if (monthName == "jun") return 6;
        else if (monthName == "jul") return 7;
        else if (monthName == "aug") return 8;
        else if (monthName == "sep") return 9;
        else if (monthName == "oct") return 10;
        else if (monthName == "nov") return 11;
        else if (monthName == "dec") return 12;
        return -1;  // Invalid month
    }

    static string getIslamicMonthName(int islMonth) {
        string islamicMonths[] = {
            "Muharram", "Safar", "Rabi' al-Awwal", "Rabi' al-Thani", "Jumada al-Awwal",
            "Jumada al-Thani", "Rajab", "Sha'ban", "Ramadan", "Shawwal", "Dhu al-Qa'dah", "Dhu al-Hijjah"
        };
        return islamicMonths[islMonth - 1];
    }
};

// CalendarConverter class to convert between Gregorian and Hijri
class CalendarConverter {
public:
    // Converting Gregorian date to Hijri
    void convertToHijri(int day, int month, int year) {
        double jd, islYear, islMonth, islDay;

        jd = 367 * year - floor((7 * (year + floor((month + 9) / 12))) / 4) +
             floor((275 * month) / 9) + day + 1721013.5;

        islYear = floor((30 * (jd - 1948439.5)) / 10631.0);
        islMonth = ceil(((jd - 1948439.5) - (10631.0 * islYear / 30.0)) / 29.5);
        islDay = ceil(jd - (1948439.5 + 10631.0 * islYear / 30.0) - (islMonth - 1) * 29.5);

        cout << "Islamic Date: " << islDay << " " << monthnumber::getIslamicMonthName(islMonth) << " " << islYear + 1 << endl;
    }

    // Converting Hijri date to Gregorian
    void convertToGregorian(int islDay, int islMonth, int islYear) {
        double jd, gYear, gMonth, gDay;

        jd = 1948439.5 + (10631.0 * islYear / 30.0) + (islMonth - 1) * 29.5 + islDay;

        gYear = floor((4 * (jd - 1721040.5) + 3) / 1461);
        gMonth = floor((5 * (jd - 1721058.5 - floor((1461 * gYear) / 4)) + 2) / 153);
        gDay = jd - 1721058.5 - floor((1461 * gYear) / 4) - floor((153 * gMonth + 2) / 5) + 1;

        gYear = gYear + (gMonth + 2) / 12;
        gMonth = ((int)gMonth + 2) % 12 + 1;

        cout << "Gregorian Date: " << (int)gDay << "/" << (int)gMonth << "/" << (int)gYear << endl;
    }
};

// Main Program class with menu and user interaction
class Program {
private:
    CalendarConverter converter;
    string password;
    char IslamicEvent;

    bool authenticate() {
        char a;
        cout << "Enter password to access your program: ";
        for (int i = 0; i < 4; i++) {
            a = getch();
            cout << "*";
            password += a;
        }
        cout << endl;
        system("cls");
        cout << "Loading Please wait";
        for (int i = 0; i < 5; i++) {
            Sleep(500);
            cout << ".";
        }
        system("cls");
        return password == "Syed";
    }

    void displayMenu() {
        cout << "Choose an option:\n";
        cout << "1. Convert Gregorian to Hijri\n";
        cout << "2. Convert Hijri to Gregorian\n";
        cout << "3. Islamic event date by year\n";
        cout << "4. World event date by year\n";
        cout << "5. Quit\n";
        cout << "Enter your choice: ";
    }

    void displayIslamicEvents(int year) {
        cout << "Events in the year " << year << " in the Islamic calendar:\n";
        cout << "1. Ramadan begins: " << (year * 354.37 + 13) << " (Hijri year)" << endl;
        cout << "2. Eid-ul-Fitr: " << (year * 354.37 + 18) << " (Hijri year)" << endl;
    }

    void displayWorldEvents(int year) {
        cout << "World Events in the year " << year << ":\n";
        cout << "1. New Year: " << (year) << "-01-01 (Gregorian calendar)" << endl;
        cout << "2. Independence Day (USA): " << (year) << "-07-04 (Gregorian calendar)" << endl;
    }

public:
    void run() {
        cout << "****Welcome To Gregorian And Hijri Converter****" << endl;
        if (!authenticate()) {
            cout << "Incorrect password!" << endl;
            return;
        }

        while (true) {
            int choice, day, month, year;
            string monthName;
            displayMenu();
            cin >> choice;
            system("cls");
            cout << "Loading Please wait";
            for (int i = 0; i < 5; i++) {
                Sleep(500);
                cout << ".";
            }
            system("cls");

            if (choice == 1) {
                // Gregorian to Hijri
                cout << "Enter Gregorian day (1-31): ";
                cin >> day;
                cin.ignore();
                cout << "Enter month (jan, feb, mar, etc.): ";
                getline(cin, monthName);
                cout << "Enter year: ";
                cin >> year;
                system("cls");

                month = monthnumber::getMonthNumber(monthName);
                if (day < 1 || day > 31 || month == -1 || year < 1) {
                    cout << "Invalid input! Please try again.\n";
                    continue;
                }
                converter.convertToHijri(day, month, year);
                char Press;
                cout << "Press Q to quit or Press any key to continue...";
                Press = getch();
                if (Press == 'Q' || Press == 'q') {
                    system("cls");
                    cout << "Thanks for using the program. Bye..(^_^)";
                    break;
                }
                system("cls");
            }
            else if (choice == 2) {
                // Hijri to Gregorian
                cout << "Enter Hijri day (1-30): ";
                cin >> day;
                cout << "Choose Hijri month\n1:Muharram\t\t2:Safar\n3:Rabi' al-Awwal\t4:Rabi' al-Thani\n5:Jumada al-Awwal"
                    << "\t6:Jumada al-Thani\n7:Rajab\t\t\t8:Sha'ban\n9:Ramadan\t\t10:Shawwal\n11:Dhu al-Qa'dah\t12:Dhu al-Hijjah\nEnter :";
                cin >> month;
                cout << "Enter Hijri year: ";
                cin >> year;
                system("cls");

                if (day < 1 || day > 30 || month < 1 || month > 12 || year < 1) {
                    cout << "Invalid input! Please try again.\n";
                    continue;
                }
                converter.convertToGregorian(day, month, year);
                char Press;
                cout << "Press Q to quit or Press any key to continue...";
                Press = getch();
                if (Press == 'Q' || Press == 'q') {
                    system("cls");
                    cout << "Thanks for using the program. Bye..(^_^)";
                    break;
                }
                system("cls");
            }
            else if (choice == 3) {
                // Islamic event by year
                cout << "Enter Hijri Year: ";
                cin >> year;
                displayIslamicEvents(year);
                char Press;
                cout << "Press Q to quit or Press any key to continue...";
                Press = getch();
                if (Press == 'Q' || Press == 'q') {
                    system("cls");
                    cout << "Thanks for using the program. Bye..(^_^)";
                    break;
                }
                system("cls");
            }
            else if (choice == 4) {
                // World events by year
                cout << "Enter Gregorian Year: ";
                cin >> year;
                displayWorldEvents(year);
                char Press;
                cout << "Press Q to quit or Press any key to continue...";
                Press = getch();
                if (Press == 'Q' || Press == 'q') {
                    system("cls");
                    cout << "Thanks for using the program. Bye..(^_^)";
                    break;
                }
                system("cls");
            }
            else if (choice == 5) {
                cout << "Thanks for using the program. Bye..(^_^)";
                break;
            }
            else {
                cout << "Invalid choice! Please select a valid option.\n";
            }
        }
    }
};

// Main entry point of the program
int main() {
    Program program;
    program.run();
    return 0;
}
