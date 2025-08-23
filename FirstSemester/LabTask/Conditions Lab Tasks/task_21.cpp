/*Task # 21 Write a C++ program, which takes three int 
values from the user, and print their addition and average.*/
#include <iostream>
#include <conio.h>
using namespace std;
int main ()
{
    int a,b,c;
    cout<<"enter 3 integers :"; cin>>a>>b>>c;
    if((a>9 && b>9 && c>9) && (a<100 && b<100 && c<100))
    {
    cout<<"addition of 3 integers"<<a+b+c<<" and average of these 3 integers is :"<<(float)(a+b+c)/30;
    }
    else cout<<"plz enter teo digit number in all three integers";
    return 0;
}