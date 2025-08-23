#include <iostream>
using namespace std;
int main()
{
    int a;
    cout<<"Enter your number : ";
    cin>>a;//and ya phir &&  or ya phir ||
    if(a>99 && a<1000){
        cout<<"Your number "<<a<<" is a Three digit number"<<endl;
    }
    else cout<<"Your number "<<a<<" is not a Three digit number"<<endl;
    cout<<"\tEND PRAGRAM";   
}     