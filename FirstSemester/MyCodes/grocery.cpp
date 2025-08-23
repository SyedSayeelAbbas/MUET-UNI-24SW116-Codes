/*Write a program that continuously accepts item names 
and prices from the user until they enter 
"STOP." The program should then display the total number of 
items entered and the total price of all items.*/
#include <iostream>
#include <string>
using namespace std;

int main() {
    string itemName;
    double price, totalPrice = 0.0;
    int itemCount = 0;

    while (true) {
        cout << "Enter item name (or type 'STOP' to finish): ";
        cin >> itemName;

        if (itemName == "STOP") {
            break;
        }

        cout << "Enter price of " << itemName << ": ";
        cin >> price;

        totalPrice += price;
        itemCount++;
    }

    cout << "\nTotal number of items entered: " << itemCount << endl;
    cout << "Total price of all items: $" << totalPrice << endl;

    return 0;
}
