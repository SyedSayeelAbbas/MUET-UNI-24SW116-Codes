#include <iostream>
#include <conio.h>
using namespace std;
int main()
{
    int a,b;
    char n;
    cout<<"Enter"; cin>>a;
    cout<<"Enter"; cin>>b;
    cout<<"operator:";
    n=getch();
    switch (n)
    {
    case '%':
        cout<<a%b;
        break;
    
    default:
        cout<<"error";
        break;
    }
}