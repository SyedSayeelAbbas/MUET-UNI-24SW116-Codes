#include<iostream>
using namespace std;
int main()
{
    int x;
    cout<<"enter any number :";
    cin>>x;
    // if((x>='a'&&x<='z') || (x>='A'&&x<='Z')) 
    // cout<<"Enter number only";
    if(x<0) 
    cout<<"it is a negative number";
    else if (x>0) 
    cout<<"it is a positive number";
    else cout<<"0 is no +ve nor -ve";
    if(x>9 &&x<100) cout<<"\nits is double digit number";
}