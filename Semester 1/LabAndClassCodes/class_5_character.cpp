#include <iostream>
#include <conio.h>
using namespace std;
int main ()
{
	char ch;
	cout<<"Enter any character :"; 
	ch=getch();
	//ch=getche(); //out and input both remain same 
	//and getch() wil work without ch but it will not store 
	system("cls"); //it clear the previous input or output or statement in console 
	//but that statments will be save in the memory
	cout<<"\ncharacter after your charcter entered is :"<<(char)(ch+1);
	cout<<"\ncharacter before your entered one :"<<(char)(ch-1);
	//(a==0) ? cout<<"ood":cout<<"even";
	return 0;
}
