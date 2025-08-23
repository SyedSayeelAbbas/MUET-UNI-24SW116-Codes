#include <iostream>
using namespace std;
int main()
{
    int factorial=1,num,i,c;
    cout<<"Enter :"; cin>>i; c=i;
    if (i==0) {cout<<"1";}
    else if(i<0){ cout<<"Negative number cannt have factorial";}
    for(i;i>0;i-=1)
    {
        factorial*=i;
    }
    cout<<"the Factorial of "<<c<<" is :"<<factorial;
    return 0;
}