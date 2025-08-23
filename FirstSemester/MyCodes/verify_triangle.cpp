/*Write a program that reads in the length of three sides of a triangle 
and determines whether the triangle is equilateral, isosceles, or scalene.
*/
#include<iostream>
#include<conio.h>
using namespace std;
int main()
{
    int a,b,c;
    cout<<"Enter the the length of first side :";
    cin>>a;
    cout<<"Enter the the length of second side :";
    cin>>b;
    cout<<"Enter the the length of third side :";
    cin>>c;
    if(a==b && b==c && a==c)
    {   system("cls");
        cout<<"triangle is equilateral";
    }
    else if(a==b || b==c || a==c)
    {   system("cls");
        cout<<"isosceles";
    }
    else if(a==b || b==c || a==c)
    {   system("cls");
        cout<<"scalene";
    }
    cout<<"\nPROGRAM END";
    return 0;
}