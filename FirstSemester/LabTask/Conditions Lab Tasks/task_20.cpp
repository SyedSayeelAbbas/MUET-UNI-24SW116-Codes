/*Task # 20 Write a C++ program that takes an uppercase character from the user and display its equivalent lower case character.
Expected output

Upper case character ‘D’
Lower case character: ‘d’
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