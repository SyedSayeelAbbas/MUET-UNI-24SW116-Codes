/*Write a program that takes the temperature in Celsius 
as input and categorizes the weather as:
   - Below 0°C: Freezing  
   - 0°C - 15°C: Cold  
   - 16°C - 30°C: Warm  
   - Above 30°C: Hot
*/
#include<iostream>
#include<conio.h>
using namespace std;
int main()
{
    int temp;
    cout<<"Enter your Temperature :"; 
    if(!(cin>>temp))
    {   system("cls");
        cout<<"Wrong input";
    }
    if(temp>0)
    {   system("cls");
        cout<<"Temprature is Freezing";
    }
    else if(temp>=0 && temp <=15)
    {   system("cls");
        cout<<"Temprature is Cold";
    }
    else if(temp>=16 && temp <=30)
    {   system("cls");
        cout<<"Temprature is Warm";
    }
    else if(temp>30)
    {   system("cls");
        cout<<"Temprature is Hot";
    }
    cout<<"\n\tEND PROGRAM";
    return 0;
}