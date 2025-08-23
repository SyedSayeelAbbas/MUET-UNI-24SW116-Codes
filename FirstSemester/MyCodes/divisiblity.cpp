#include <iostream>
using namespace std;
int main()
{
    int a;
    cout<<"Enter your number : "; cin>>a;
    if(a%5==0){
        cout<<"Yes, your number is divisble by 5 "<<endl;
        cout<<"Nice work\n";
    }
    else if (a%5!=0){
        cout<<"No, your number is not divisble by 5 "<<endl;
        cout<<"inster a number divisble by 5\n";
    }
    else cout<<"There is a problem with program\nplz check code";
    cout<<"\tEND PROGRAM";
    return 0;                            
}