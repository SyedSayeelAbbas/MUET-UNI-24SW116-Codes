/*Task #1: Write a C++ program to ask the user to input his/her age.  
Then the program will show if the person is eligible to vote.
A person who is eligible to vote must be older than or equal 
to 18 years old.*/
#include<iostream>
using namespace std;
int main()
{
    int age;
    cout<<"Enter your age :"; cin>>age;
    if(!(age>='a'&&age<='z')&&!(age>='A'&&age<='Z')&&(age>0))
    {
        if(age>=18) {cout<<"You are eligible to vote";}
        else {cout<<"you are not eligible to vote";}
    }
    else {cout<<"plz enter number\n(positive integer) ";}
    return 0;
}
