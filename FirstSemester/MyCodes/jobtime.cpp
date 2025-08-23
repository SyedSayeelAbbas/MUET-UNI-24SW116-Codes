/*Write a C++ program that asks for the number of days a 
person worked in a week and prints the appropriate message:
- 0-2 days: "Part-time"  
- 3-5 days: "Half-time"  
- 6-7 days: "Full-time"
*/
#include <iostream>
using namespace std;
int main() 
{
    int day;
    cout<<"Enter number of days you work on a job:"; 
    if(!(cin>>day)){
        cout<<"Wrong input";
    }
    else if(day>=0 && day<=2)
    {
        cout<<"You work Part time";
    }
    else if(day>=3 && day<=5)
    {
        cout<<"You work Half time";
    }
    else if(day>=6 && day<=7)
    {
        cout<<"You work full time";
    }
    cout<<"\n\tEND PROGRAM";
    return 0;
}