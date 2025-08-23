#include<iostream>
using namespace std;
int main()
{
    int a,b,c;
    cout<<"Enter your first number : ";
    cin>>a;
    cout<<"Enter your second number : ";
    cin>>b;
    cout<<"Enter your third number : ";
    cin>>c;
    if(a>b and a>c and b>c ){
        cout<<"The value "<<a<<" is the greatest number\n and value of "<<c<<" is the lowest number"<<endl;
    }
    else if(a>b and a>c and c>b ){
        cout<<"The value "<<a<<" is the greatest number\n and value of "<<b<<" is the lowest number"<<endl;
    }
    else if(b>a and b>c and a>c ){
        cout<<"The value "<<b<<" is the greatest number\n and value of "<<c<<" is the lowest number"<<endl;
    }
    else if(b>a and b>c and c>a ){
        cout<<"The value "<<b<<" is the greatest number\n and value of "<<a<<" is the lowest number"<<endl;
    }
    else if(c>a and c>b and a>b ){
        cout<<"The value "<<c<<" is the greatest number\n and value of "<<b<<" is the lowest number"<<endl;
    }
    else if(c>a and c>b and b>a ){
        cout<<"The value "<<c<<" is the greatest number\n and value of "<<a<<" is the lowest number"<<endl;
    }
    else if(c==a and c==b and b==a ){
        cout<<"All values of three numbers are same which is :"<<c<<endl;
    }
    else cout<<"There is an error in program\ncheck your code";
    cout<<"\n\tEND PROGRAM";
    return 0;
}