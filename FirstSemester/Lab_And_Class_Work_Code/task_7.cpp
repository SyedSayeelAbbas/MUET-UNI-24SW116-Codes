#include <iostream>
using namespace std;
int main()
{
    char x;
    cout<<"Enter upper case value for lower case :";
    cin>>x;
    cout<<"The lower case of character "<<x<<" is :"<<(char)(x+32)<<"\nand lower case value of "<<(char)(x+32)<<" is:"<<(x+32);
    //cout<<97-x;
}