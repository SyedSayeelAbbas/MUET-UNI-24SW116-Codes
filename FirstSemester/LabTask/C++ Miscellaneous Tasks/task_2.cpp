/*Write a C++ a program to accomplish the following
•	Declare two float variables numerator and denominator.
•	Prompt the user to values for numerator and denominator separated by ‘ / ’ character.
•	  compute and display there product on the new line.
•	 Expected Output
Enter numerator and denominator separated by / .
12 / 6
Product of 12 / 6 = 2.
*/
#include<iostream>
using namespace std;
int main()
{
    float x,y;
    cout<<"Enter  numerator :";
    cin>>x;
    cout<<"Enter your denuminator value :";
    cin>>y;
    cout<<x<<"/"<<y<<endl;
    cout<<"Your division answer is :"<<x/y;
    return 0;
}