/*Task # 12: Write a program that accepts three numbers 
from the user and prints "increasing" if the numbers are
 in increasing order, "decreasing" if the numbers are 
in decreasing order.
Test Data
Input first number: 15 
Input second number: 25
Input third number: 35
Expected Output:
Increasing order
*/
#include<iostream>
#include<conio.h>
using namespace std;
int main()
{
    int a,b,c;
    cout<<"Enter first value:"; cin>>a;
    cout<<"Enter second value:"; cin>>b;
    cout<<"Enter third value:"; cin>>c;
    if(a<b && a<c && b<c)
    {cout<<"increasing";}
    else {cout<<"decreasing";}
    return 0;
}