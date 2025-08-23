#include <iostream>
#include <conio.h>
using namespace std;
int main()
{
	string password="";
	char num;
	cout<<"Enter your password :";
	num=getch();
	cout<<"*";
	password+=num;
	num=getch();
	cout<<"*";
	password+=num;
	num=getch();
	cout<<"*";
	password+=num;
	num=getch();
	cout<<"*";
	password+=num;
	cout<<"\n\tPress any key to see password ";
	getch();
	cout<<"\nyour password is :"<<password;
	getch();
	return 0;
}
