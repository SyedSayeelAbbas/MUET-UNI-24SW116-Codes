#include <iostream>
using namespace std;
int main()
{//and = && , or == ||
    int a;
    cout<<"Enter your number : "; cin>>a;
    if(a%5==0 and a%3==0){
        cout<<"Yes, your number "<<a<<" \nis divisble by 5  and 3"<<endl;
        cout<<"Nice work\n";
    }
    else if (a%5==0 and a%3!=0){
        cout<<"yes, your number "<<a<<" \nis  divisble by 5  but no by 3"<<endl;
        cout<<"insert a number divisble by both 5 and 3\n";
    }
    else if (a%5!=0 and a%3==0){
        cout<<"yes, your number "<<a<<" \nis  divisble by 3  but no by 5"<<endl;
        cout<<"insert a number divisble by both 5 and 3\n";
    }
    else if (a%5!=0 and a%3!=0){
        cout<<"No, your number "<<a<<" \nis not divisble by 3 and 5"<<endl;
        cout<<"insert a number divisble by both 5 and 3\n";
    }
    else cout<<"There is a problem with program\nplz check code";
    cout<<"\tEND PROGRAM";
    return 0;                            
}