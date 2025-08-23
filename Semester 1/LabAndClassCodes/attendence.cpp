#include <iostream>
#include <conio.h>
using namespace std;
int main ()
{
	float classes,attend,percent;
	cout<<"Enter number of classes held :"; cin>>classes;
	cout<<"Enter number of classes attend :"; cin>>attend;
	percent=100*(attend/classes);
	if(percent>=75) cout<<"You are eligible as your attendence is :"<<percent<<"%";
	else { cout<<"You are not eligible :"<<percent<"%";
	}
	return 0;
}
