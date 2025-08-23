#include <iostream>
#include <conio.h>
using namespace std;
int main ()
{
	int x;
	cout<<"Enter your age :"; cin>>x;
	if(x>18 || x==18) {cout<<"You are eligible to vote";}
	//x>=18 more than one statement is 
	//known as compound statement
	else cout<<"you are below 18 so you are no eligible";
	return 0;
}
