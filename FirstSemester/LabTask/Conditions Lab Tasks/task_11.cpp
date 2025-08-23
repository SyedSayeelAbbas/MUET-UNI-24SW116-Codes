/*Task # 11: Write a program that accepts two numbers from the 
user and prints compares which number is  a greater number among them.
*/
#include<iostream>
#include<conio.h>
using namespace std;
int main()
{
    int a,b;
    cout<<"Enter 2 Integers:"; cin>>a>>b;
    if(a>b) cout<<(a)<<" is greater than "<<(b);
    else cout<<(b)<<" is greater than "<<(a);
    return 0;
}