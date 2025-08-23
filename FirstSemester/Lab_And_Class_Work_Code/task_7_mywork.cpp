#include <iostream>
using namespace std;
int fun1()
{   char x;
    cout<<"Enter your character :";
    cin>>x;
    cout<<"The lower case of character "<<x<<" is :"<<(char)(x+32)<<"\nand lower case value of "<<(char)(x+32)<<" is:"<<(x+32);
}
int fun2()
{   char x;
    cout<<"Enter your character :";
    cin>>x;
    cout<<"The upper case of character "<<x<<" is :"<<(char)(x-32)<<"\nand upper case value of "<<(char)(x-32)<<" is:"<<(x-32);
}
int main()
{
    char input;
    cout<<"Choose A for upper case to lower\nChoose B for lower case to upper case\nEnter :";
    cin>>input;
    if(input=='A') fun1();
    if(input=='B') fun2();
    return 0;
}