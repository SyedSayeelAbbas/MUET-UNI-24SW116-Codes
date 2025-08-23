#include <iostream>
using namespace std;
int main()
{
    int p;
	string b,a;
	cout<<"Enter book name : ";
	getline(cin,b);
	cout<<"Enter book price : ";
	cin>>p;
	cin.ignore();
	cout<<"Enter author name : ";
	getline(cin,a);
	cout<<"Book name is : "<<b<<"\n"<<"Book price :"<<p<<"RS"<<"\n"<<"Author name is : "<<a;
	cout<<"\n\t END PROGRAM";
	return 0;
}
