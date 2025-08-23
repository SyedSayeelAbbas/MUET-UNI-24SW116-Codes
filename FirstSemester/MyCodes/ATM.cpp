#include<iostream>
#include<conio.h>
#include<windows.h>
using namespace std;
int main()
{
    string password;
    char p,dw,cs;
    int d,w,b;
    int pinAttempts = 0;
    bool loggedIn = false;
    cout<<"\t***Welcome To ATM***"<<endl;
    cout<<"Enter 4-Digits for PIN :";
    for(int i=1;i<=4;i++)
    {
        p=getch();
        cout<<"*";
        password+=p;
    }
    system("cls");
    cout<<"Loading plz wait";
    for(int l=1;l<=3;l++)
    {
    Sleep(500);
    cout<<".";
    }
    system("cls");
    if(password=="1981")
    {
        b=100000;
    }
    else if(password=="1987")
    {
        b=50000;
    }
    else if(password=="2004")
    {
        b=30000;
    }
    else if(password=="2006")
    {
        b=15000;
    }
    else if(password=="2008")
    {
        b=5000;
    }
    else if(password=="2014")
    {
        b=500000;
    }
    else{cout<<"Invalid Password try again";}
        cout<<"Select Account"<<endl;
            cout<<"1:Current\t2:Saving"<<endl;
            cs=getch();
            system("cls");
            cout<<"1:Deposite\t\t2:Withdraw\n3:Check Balance\t\t4:Exit"<<endl;
            cout<<"\n\t";
            dw=getch();
            system("cls");
            if(dw=='1'){
                cout<<"\t**Welcome Ali King***\nThis is a Gold account\n\n"<<"Enter your amount to be deposite :";
                cin>>d;
               // system("cls");
                cout<<"Your Total Balance :"<<b+d;
            }
            else if(dw=='2'){
                cout<<"Enter your amount to be withdrawn :";
                cin>>w;
                //system("cls");
                if(w<=50000){
                cout<<"Your Remaining Balance :"<<b-w;
                }
                else cout<<"Your low balance is low than"<<w;
            }
            else if(dw=='3'){
                cout<<"Your balance is :";
                cout<<b;
            }
            else if(dw=='4')
            {
                cout<<"You have Exit from further procces";
            }
            else {cout<<"Plz select rigth option";}
        
    
    return 0;
}