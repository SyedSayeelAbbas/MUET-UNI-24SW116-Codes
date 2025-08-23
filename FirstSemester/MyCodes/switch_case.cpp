#include <iostream>
#include <conio.h>
using namespace std;
int main()
{
    int num1,num2;
    char o,T;
    cout<<"\nEnter your two numbers :";
    cin>>num1;
    cin>>num2;
    cout<<"\nEnter your character to do Arithematic operations "; o=getch();
    switch (o)
    {
    case 'A':
        cout<<"\nThe Sum of your number is :"<<num1+num2;
        break;
    case 'S':
        cout<<"\nThe Subtraction of your number is :"<<num1-num2;
        break;
    case 'M':
        cout<<"\nThe multiplication of your number is :"<<num1*num2;
        break;
    case 'D':
        cout<<"\nThe division of your number is :"<<num1/num2;
        break;
    default:
        break;
    }
}