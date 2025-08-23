/*Task#6 Write a C++ program that prompts the user to enter any character and the program checks as:
the character is a lower
case character case or upper case character
if it is a lower case then convert it into upper case. 
if it is an upper case then convert it into lower case.
*/
#include<iostream>
#include<conio.h>
using namespace std;
int main()
{
    char x;
    cout<<"Enter your lower or upper case character :";
    x=getch();
    system("cls");
    if(x>='a'&&x<='z')
    {
        cout<<"Your entered Character "<<(x)<<" in upper case is "
        <<(char)(x-32);
    }
    else if(x>='A'&&x<='Z'){cout<<"Your entered Character "
    <<(x)<<" in lower case is "
    <<(char)(x+32);}
    else cout<<"Something is wrong";
}
