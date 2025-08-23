#include <iostream>
#include <conio.h>
using namespace std;
int main()
{
    cout<<"******Welcome to basic Calculator*****"<<endl;
    float a,b;
    char e;
    cout<<"Enter your first value:";
    cin>>a;
    cout<<"\nEnter your second value:";
    cin>>b;
    cout<<"Choose operation\npress a for +\npress b for -\npress c for *\npress d for /\nEnter :"<<endl; e=getch();
    if(e=='a')
	{cout<<"Your addition value is :"<<a+b<<endl;}
	else if (e=='b'){
    cout<<"Your subtraction value is :"<<a-b<<endl;}
    else if (e=='c'){
    cout<<"Your multiplication value is :"<<a*b<<endl;}
    else if (e=='d')
    {cout<<"Your division value is :"<<a/b<<endl;}
    else cout<<"Something is wrong\ncheck code";
    return 0;
}
