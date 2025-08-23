#include <iostream>
#include <conio.h>//for get line
using namespace std;
struct person
{
    int age=19;//it is not constant if int main has another value assinged
    string first_name,last_name;
    float heigth;
};

int main(){
    person player1;
    person player2;
    //player1.age=18;//it will fail as then word will be reassinge
    cout<<"Enter first name :";
    getline(cin,player1.first_name);
    cout<<"Enter last name :";
    getline(cin,player1.last_name);
    cout<<"Enter your age of "<<player1.first_name<<" :";
    cin>>player1.age;
    cout<<"Enter Heigth of "<<player1.first_name<<" :"; 
    cin>>player1.heigth;
    cout<<endl;
    cin.ignore();
    cout<<"Enter first name :";
    getline(cin,player2.first_name);
    cout<<"\nEnter last name :";
    getline(cin,player2.last_name);
    cout<<"\nEnter your age of "<<player2.first_name<<" :";
    cin>>player2.age;
    cout<<"\nEnter Heigth of "<<player2.first_name<<" :"; 
    cin>>player2.heigth;
    cout<<endl;
    cout<<"age is :"<<player1.age<<"\nFirst name is :"<<player1.first_name
    <<"\nlast name is :"<<player1.last_name<<"\nHeigth is :"<<player1.heigth<<endl;
    cout<<"age is :"<<player1.age<<"\nFirst name is :"<<player1.first_name
    <<"\nlast name is :"<<player1.last_name<<"\nHeigth is :"<<player2.heigth<<endl;
}