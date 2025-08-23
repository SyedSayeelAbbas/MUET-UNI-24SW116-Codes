/*Create a program that accepts the price of an item and 
calculates the discount based on the following conditions:
    - Price > 1000: 20% discount  
    - Price between 500 and 1000: 10% discount  
    - Price < 500: No discount*/
#include<iostream>
#include<conio.h>
using namespace std;
int main()
{
    float Price;
    cout<<"Enter your amount :"; 
    if(!(cin>>Price))
    {
        cout<<"wrong input";
    }
    else if (Price>1000)
    {
        cout<<"You have purchase above 1000 Rs and get discount of 20% in "
        <<Price<<"\n which is "<<Price*0.2;
    }
    else if (Price<=500 || Price<=1000)
    {
        cout<<"You have purchase between 500 Rs to 1000 Rs and get discount of 10% in "
        <<Price<<"\n which is "<<Price*0.1;
    }
    else if (Price<500)
    {
        cout<<"You have purchase below 500 Rs so no discount";
    }
    cout<<"\n\tProgram End";
    return 0;
}