/*Task # 14 Write a program in C++ to compute the total 
and average of four numbers. (take values for numbers from the user at runtime)  

Expected output
Input 1st two numbers (separated by space) : 25 20
Input last two numbers (separated by space) : 15 25
The total of four numbers is : 85
The average of four numbers is : 21.25
*/
#include <iostream>
using namespace std;
int main()
{
    float f,g,h,j;
    cout<<"Input 1st two numbers : ";
    cin>>f>>g;
    cout<<"Input 1st two numbers : ";
    cin>>h>>j;
    double sum=f+g+h+j;
    double average=sum/4;
    cout<<"The total of four numbers is : "<<sum<<endl;
    cout<<"The average of four numbers is : "<<average;
    return 0;
    
}