/*Task 5:rebuld a C++ Program that takes an integer as an input and print its factorial*/
#include <iostream>
using namespace std;

int main()
{
    int factorial = 1, num;
    cout << "Enter a number: ";
    cin >> num;

    if (num == 0)
        cout << "Factorial of 0 is 1" << endl;
    else if (num < 0)
        cout << "Negative numbers do not have factorials" << endl;
    else
    {
        while (num > 0)
        {
            factorial *= num;
            num -= 1;
        }
        cout << "Factorial is " << factorial << endl;
    }

    return 0;
}
