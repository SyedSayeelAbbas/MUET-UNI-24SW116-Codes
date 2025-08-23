#include <iostream>
using namespace std;
int main()
{
	char x;
	cout<<"Enter your condition :"; x=getch();
	if(x>='A' and x<='Z') cout<<"Your character is in upper case :";
	else if(x>='a' and x<='z') cout<<"Your character is in lower case :";
	else { cout<<"it isnot a alphabet  ";
	}
	return 0;
}
