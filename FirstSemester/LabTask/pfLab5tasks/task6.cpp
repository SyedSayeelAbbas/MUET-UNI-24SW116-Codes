#include <iostream>
#include <conio.h>
using namespace std;

int main()
{
    char a, b;
    int count = 0;
    string characters = "";

    cout << "Enter first character: ";
    a = getche();
    cout << endl;
    cout << "Enter second character: ";
    b = getche();
    system("cls");

    if (a < b) {
        for (int i = a + 1; i < b; i++) {
            characters += char(i);
            count++;
        }
    } else if (a > b) {
        for (int i = b + 1; i < a; i++) {
            characters += char(i);
            count++;
        }
    }

    cout << "Characters between " << a << " and " << b << " are: " << characters << endl;
    cout << "Total count is: " << count << endl;

    return 0;
}
