/*Task # 9: Write a program that accepts two numbers from 
the user and prints compares whether both numbers are equal are not*/
/*Task # 10: Write a program that accepts three numbers from the user 
and prints compares whether all three numbers are equal are not.
*/
#include<iostream>
#include<conio.h>
using namespace std;
int main()
{
    int a,b,c;
    cout<<"Enter 2 Integers:"; cin>>a>>b;
    if(a==b) cout<<"Both are equal";
    else cout<<"They are not equal";

    cout<<"\nEnter 2 Integers:"; cin>>a>>b>>c;
    if(a==b&&a==c) cout<<"all three are equal";
    else cout<<"\nThey are not equal";
}