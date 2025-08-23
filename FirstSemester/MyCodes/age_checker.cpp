/*Create a program that accepts the age of a person and outputs 
whether the person is a child (age < 12), a teenager (age 12–18), an adult (age 19–60),
 or a senior (age > 60).
*/
#include <iostream>
using namespace std;
int main()
{
    int age;
    cout<<"Enter your age :";
    if(!(cin>>age))
    {cout<<"wrong input";}
    else if(age<=12){
        cout<<"you are  child";
    }
    else if(age>12 && age<=18){
        cout<<"you are  teenager";
    }
    else if(age>18 && age<=60){
        cout<<"you are  adult";
    }
    else if(age>60){
        cout<<"you are old";
    }
    else cout<<"wrong input";
    return 0;
}