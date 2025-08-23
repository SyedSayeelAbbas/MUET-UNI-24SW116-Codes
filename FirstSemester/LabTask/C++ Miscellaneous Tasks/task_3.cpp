/*Write a C++ a program to accomplish the following
•	Declare the variables x, y, z 
•	Prompt the user to enter three integers separated by ‘ ??’ two question mark characters. 
•	  Print all three integers WITHOUT . ‘ ??’ two question mark characters.
Expected Output
Enter three numbers separated by ?? 
4??6??10
4610
*/
#include<iostream>
using namespace std;
int main()
{
    int x,y,z;
    cout<<"Enter your three integers ??\n";
    cin>>x>>y>>z;
    cout<<x<<"??"<<y<<"??"<<z<<endl;
    cout<<x<<y<<z;
    return 0;
}    