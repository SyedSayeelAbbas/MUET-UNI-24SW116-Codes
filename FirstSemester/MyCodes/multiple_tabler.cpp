#include <iostream>
#include <windows.h>
using namespace std;

int main() {
    int n1, range1, n2, range2;

    // Input for the first table
    cout << "Enter the number for the first table: ";
    cin >> n1;
    system("cls");
    cout << "Enter the range of the first table: ";
    cin >> range1;
    system("cls");

    // Input for the second table
    cout << "Enter the number for the second table: ";
    cin >> n2;
    system("cls");
    cout << "Enter the range of the second table: ";
    cin >> range2;
    system("cls");

    // Loading animation
    cout << "Loading";
    for (int j = 1; j <= 3; j++) {
        Sleep(500);
        cout << ".";
    }
    system("cls");

    // Display the tables side by side
    cout << "Table of " << n1 << "\t\tTable of " << n2 << endl;
    int maxRange = max(range1, range2);

    for (int i = 1; i <= maxRange; i++) {
        // First table output
        if (i <= range1) {
            cout << n1 << " x " << i << " = " << n1 * i << "\t\t";
        } else {
            cout << "\t\t\t";
        }

        // Second table output
        if (i <= range2) {
            cout << n2 << " x " << i << " = " << n2 * i;
        }

        cout << endl;
    }

    return 0;
}
