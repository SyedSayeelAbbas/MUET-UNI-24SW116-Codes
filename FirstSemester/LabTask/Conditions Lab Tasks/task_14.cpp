/*Task #14: Take three numbers from the user and print the greatest number.  Test Data
Input the 1st number: 25 
Input the 2nd number: 78 
Input the 3rd number: 87
Expected Output: 
The greatest: 87
*/
#include<iostream>
#include<conio.h>
using namespace std;
int main()
{
    int a,b,c;
    cout<<"Enter 3 Integers:"; cin>>a>>b>>c;
    if(a>b && a>c) cout<<(a)<<" is greater than "<<(b)<<" and "<<(c);
    else if(b>a && b>c) cout<<(b)<<" is greater than "<<(a)<<" and "<<(c);
    else if(c>a && b<c) cout<<(c)<<" is greater than "<<(b)<<" and "<<(a);
    else cout<<"Something wrong";
    return 0;
}