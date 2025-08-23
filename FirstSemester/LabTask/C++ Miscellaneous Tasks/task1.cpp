/*Write a C++ a program to accomplish the following
•	Declare the variables x, y, z and result to be of type int.
•	Prompt the user to enter three integers separated by ‘ , ’ a comma. 
•	  compute the sum, assign to result variable and Print the sum of all three integers.
Expected Output
Enter three whole numbers separated by commas.
4,6,10
Sum = 20.*/

#include<iostream>
using namespace std;
int main()
{
    int x,y,z;
    cout<<"Enter your first value :";
    cin>>x;
    cout<<"Enter your second value :";
    cin>>y;
    cout<<"Enter your third value :";
    cin>>z;
    cout<<x<<","<<y<<","<<z<<endl;
    cout<<"The sum of above three values is : "<<x+y+z;
    return 0; 
}
