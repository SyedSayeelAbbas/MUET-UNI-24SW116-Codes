#include <iostream>
#include <conio.h>
using namespace std;
int main ()
{
	char a;
	string password="";
	cout<<"Enter your password :";
	a=getch();
	cout<<"*";
	password+=a;
	a=getch();
	cout<<"*";
	password+=a;
	cout<<"\npress any key to view the password :";
	getch();
	cout<<password;
	return 0;
}
