#include<iostream>
#include<conio.h>
using namespace std;
int main()
{
    char e;
    int a,b;
    cout<<"Enter your First value :"; cin>>a; system("cls");
    cout<<"Enter your Second value :"; cin>>b; system("cls");
    cout<<"operators +,-,x,/"<<endl;
    cout<<"Choose your opetrator :"; e=getch(); system("cls");
    switch (e)
    {
    case '+':
        cout<<"The sum of:"<<(a)<<"+"<<(b)<<"="<<a+b;
        break;
    case '-':
        cout<<"The subtraction of:"<<(a)<<"-"<<(b)<<"="<<a-b;
        break;
    case 'x':
        cout<<"The multipiaction of:"<<(a)<<"x"<<(b)<<"="<<a*b;
        break;
    case '/':
        cout<<"The division of:"<<(a)<<"/"<<(b)<<"="<<a/b;
        break;
    
    default:
        cout<<"something is wrong";
        break;
    }
    return 0;
}