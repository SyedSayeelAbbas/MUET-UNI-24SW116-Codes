#include <iostream>
using namespace std;
int main()
{   while(true){
    int salary;
    cout<<"*****PROGRAM TO GET MINIMUME NOTES FOR YOUR SALARY****";
    cout<<"\nEnter your salary :";
    cin>>salary;

   int total1=salary/5000;
    salary%=5000;
    int total2=salary/1000;
    salary%=1000;
    int total3=salary/500;
    salary%=500;
    int total4=salary/100;
    salary%=100;
    int total5=salary/50;
    salary%=50;
    int total6=salary/20;
    salary%=20;
    int total7=salary/10;
    salary%=10;
    int total8=salary/5;
    salary%=5;
    int total9=salary/2;
    salary%=2;
    int total10=salary/1;
    salary%=1;
    cout<<"The minimume quntity of notes and coins you get for your salary is:";
    cout<<"\nRs5000 note : "<<total1;
    cout<<"\nRs1000 note : "<<total2;
    cout<<"\nRs500 note : "<<total3;
    cout<<"\nRs100 note : "<<total4;
    cout<<"\nRs50 note : "<<total5;
    cout<<"\nRs10 note : "<<total7;
    cout<<"\nRs20 note : "<<total6;
    cout<<"\nRs5 coin : "<<total8;
    cout<<"\nRs2 coin : "<<total9;
    cout<<"\nRs1 coin : "<<total10;
    cout<<"\nFOR REUSE OF PROGRAM ENTER R\nOR TO QUIT ENTER  Q :";
    char input;
    cin>>input;
    if(input=='Q') break;
    }
    return 0;
}