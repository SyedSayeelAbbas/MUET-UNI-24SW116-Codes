#include<iostream>
using namespace std;
int main()
{   cout<<"\tCONVERTION FROM HOURS TO MINUTES AND SECONDS"<<endl;
    int Hours;
    cout<<"Enter the number of Hours :";
    cin>>Hours;
    cout<<"The number of minutes you get by entering "<<Hours<<" hour is :"<<Hours*60<<"min\nAnd the number of seconds from "<<Hours<<" hour is :"<<Hours*60*60<<"sec";
    return 0;
}