/*Task 4:Rebuld a program that check the number is prime or not*/
#include <iostream>
#include <conio.h>
using namespace std;
int main()
{
    char v='y';
    int n;
    int isPrime = 1; // 1 means prime, 0 means not prime
    while (v=='y'){
    cout << "Enter the value: ";
    cin >> n;
    if (n < 2)
        cout << n << " is not a prime number" << endl;
    else if (n == 2)
        cout << n << " is a prime number" << endl;
    else if (n % 2 == 0)
        cout << n << " is not a prime number" << endl;
    else
    {
        for (int i = 3; i * i <= n; i += 2)  // Check only odd numbers up to sqrt(n)
        {
            if (n % i == 0)
            {
                isPrime = 0; // If divisible, set flag to 0 (not prime)
                break;
            }
        }

        if (isPrime == 1)
            cout << n << " is a prime number" << endl;
        else
            cout << n << " is not a prime number" << endl;
    }
    cout<<"press y for again \n press n to close :";
            v=getch();
            system("cls");}
    return 0;}
