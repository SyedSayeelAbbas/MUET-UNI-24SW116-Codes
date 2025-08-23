#include <iostream>
#include <conio.h>
#include <windows.h>
using namespace std;
void showloading() {
    cout<< "Processing, please wait"<<endl;
    for (int i = 1; i <= 5; i++) {
        Sleep(500);
        cout << "?????";
    }
    system("cls");
}
bool enterpin(int &current_balance, int &saving_balance) {
    string password;
    char p;
    int attempts = 0;
    cout<< "\nEnter Your Pin here : ";
    while (attempts < 3) {
        password = "";
        for (int i = 1; i <= 4; i++) {
            p = getch();
            cout<< "*";
            password += p;
        }
        system("cls");
        showloading();
        if (password == "1234") {
            current_balance = 10000;
            saving_balance = 5000;
            return true;
        } else if (password == "8499") {
            current_balance = 20000;
            saving_balance = 15000;
            return true;
        }
        attempts++;
        if (attempts < 3) {
            cout<<"Invalid password. Try again.\nAttempts remaining: "<<(3-attempts)<< endl;
            cout<<"Enter Pin:";
        } else {
            cout<<"You have exceeded the number of attempts. Program exiting.";
            return false;
        }
    }
    return false;
}

void deposit(int &balance) {
    int deposit_amount;
    cout << "Enter the amount to deposit: ";
    cin >> deposit_amount;
    system("cls");
    showloading();
    if (deposit_amount > 0) {
        balance += deposit_amount;
        cout << "You now have a balance of " << balance << " Rs."<<endl;
    } else {
        cout << "Please enter a positive amount.";
    }
}

void withdraw(int &balance) {
    int withdraw_amount;
    char choice;
    cout << "1: 500\t2: 1000\n3: 5000\t4: 10000\n5: Other amount" << endl;
    choice = getch();
    system("cls");

    switch (choice) {
        case '1':
            withdraw_amount = 500;
            break;
        case '2':
            withdraw_amount = 1000;
            break;
        case '3':
            withdraw_amount = 5000;
            break;
        case '4':
            withdraw_amount = 10000;
            break;
        case '5':
            cout << "Enter the amount to withdraw: ";
            cin >> withdraw_amount;
            system("cls");
            break;
        default:
            cout << "Invalid option." << endl;
            return;
    }
    system("cls");
    showloading();
    if (withdraw_amount > 0 && withdraw_amount <= balance) {
        balance -= withdraw_amount;
        cout << "You now have a balance of " << balance << " Rs."<<endl;
    } else if (withdraw_amount > balance) {
        cout << "Insufficient funds."<<endl;
    } else {
        cout << "Please enter a positive amount.";
    }
}

void check_balance(int balance) {
    showloading();
    cout << "Your total balance is: " << balance << " Rs."<<endl;
}

int main() {
    char select;
    int current_balance = 0, saving_balance = 0;
    int *active_account ;
    char account_choice, action_choice;
    cout<< "\tLaunching__Program"<<endl;
    for (int i = 1; i <= 5; i++) {
        Sleep(300);
        cout << "//////////";
    }
    system("cls");
    cout << "\t=================================\n\t\t*** Welcome To ATM ***\n\t==================================" << endl;
    if (!enterpin(current_balance, saving_balance)) {
        return 0;
    }
    while (true) {
        cout << "Select Account Type:\n1: Current Account\n2: Saving Account\n";
        account_choice = getch();
        system("cls");

        if (account_choice == '1') {
            active_account = &current_balance;
            cout << "\t=====================================================\n\t\t"
            <<"You have selected Current Account.\n\t=======================================================\n";
        } else if (account_choice == '2') {
            active_account = &saving_balance;
            cout << "\t=====================================================\n\t\tYou have selected Saving Account.\n\t"
            <<"========================================================\n";
        } else {
            cout << "Invalid selection. Try again.\n";
            continue;
        }

        // Main menu
        while (true) {
            cout << "1: Deposit\t\t\t2: Withdraw\n\n3: Check Balance\t\t4: Switch Account\n\n5: Exit\n";
            cout << "Choose Option: ";
            action_choice = getch();
            system("cls");

            switch (action_choice) {
                case '1':
                    deposit(*active_account);
                    break;
                case '2':
                    withdraw(*active_account);
                    break;
                case '3':
                    check_balance(*active_account);
                    break;
                case '4':
                    cout << "Switching accounts...\n";
                    goto switch_account;
                case '5':
                    cout << "You have exited the program.\nThanks for using the ATM.";
                    return 1;
                default:
                    cout << "Invalid input.";
                    break;
            }
            // Sleep(1000);
            // system("cls");
            cout<<"DO You Want to Do Another Transaction\n1:Yes\t2:No"<<endl;
            select=getch();
            system("cls");
            if(select=='2') {system("cls"); cout<<"You have exited the program.\nThanks for using the ATM."; return 1;}
        }
    switch_account:
        system("cls");
    }
    return 0;
}