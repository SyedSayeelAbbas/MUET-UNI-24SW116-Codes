#include <iostream>
using namespace std;
int main()
{
    int age;
    cout<<"Enter your age to :";
    cin>>age;
    if(age==10) cout<<"You are 10 year old\nand eligible for the game";
    else if (age>10) cout<<"You are to old for this game";
    else cout<<"You are too younge for the game"; 
    return 0;
}