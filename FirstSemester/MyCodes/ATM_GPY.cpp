#include<iostream>
#include<conio.h>
#include<windows.h>
using namespace std;

int main() {
    string password;
    char p, dw, cs;
    int deposit, withdraw, balance;
    int pinAttempts = 0;
    bool loggedIn = false;
    
    cout << "\t***Welcome To ATM***" << endl;
    
    // PIN entry with 3 attempts
    while (pinAttempts < 3 && !loggedIn) {
        password = "";  // Reset the password on each attempt
        cout << "Enter 4-Digits for PIN: ";
        
        for (int i = 1; i <= 4; i++) {
            p = getch();  // Use getch() to hide PIN input
            cout << "*";   // Mask the PIN with '*'
            password += p;
        }

        system("cls");
        cout << "Loading, please wait";
        for (int l = 1; l <= 3; l++) {
            Sleep(500);
            cout << ".";
        }

        system("cls");

        // Check if entered PIN matches one of the valid PINs
        if (password == "1981") {
            balance = 100000;
            loggedIn = true;
        } else if (password == "1987") {
            balance = 50000;
            loggedIn = true;
        } else if (password == "2004") {
            balance = 30000;
            loggedIn = true;
        } else if (password == "2006") {
            balance = 15000;
            loggedIn = true;
        } else if (password == "2008") {
            balance = 5000;
            loggedIn = true;
        } else {
            pinAttempts++;
            if (pinAttempts < 3) {
                cout << "\nIncorrect PIN. Attempts left: " << 3 - pinAttempts << endl;
            } else {
                cout << "Too many incorrect attempts. Exiting." << endl;
                return 0;
            }
        }
    }

    // After successful login
    if (loggedIn) {
        while (true) {  // Keep looping for account operations
            cout << "Select Account" << endl;
            cout << "1: Current\t2: Saving" << endl;
            cs = getch();  // Account type selection
            system("cls");

            cout << "1: Deposit\t\t2: Withdraw\n3: Check Balance\t4: Exit" << endl;
            cout << "\n\t";
            dw = getch();  // Operation selection
            system("cls");

            if (dw == '1') {  // Deposit
                cout << "Enter the amount to deposit: ";
                cin >> deposit;
                system("cls");
                balance += deposit;
                cout << "Your Total Balance: " << balance << endl;
            } 
            else if (dw == '2') {  // Withdraw
                cout << "Enter the amount to withdraw: ";
                cin >> withdraw;
                system("cls");
                if (withdraw <= balance) {
                    balance -= withdraw;
                    cout << "Your Remaining Balance: " << balance << endl;
                } else {
                    cout << "Insufficient balance for withdrawal!" << endl;
                }
            } 
            else if (dw == '3') {  // Check balance
                cout << "Your balance is: " << balance << endl;
            } 
            else if (dw == '4') {  // Exit
                cout << "You have exited the process. Thank you!" << endl;
                break;
            } 
            else {
                cout << "Please select the correct option." << endl;
            }
        }
    }

    return 0;
}
