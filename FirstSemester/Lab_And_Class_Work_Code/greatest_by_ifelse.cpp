#include <iostream>
#include <conio.h>
using namespace std;
int main()
{
	int a,b,c;
	cout<<"Enter three numbers "; 
	cin>>a>>b>>c;
	if (a>b and a>c) {cout<<(a)<<"is greatest";}
	else if (b>a and b>c) {cout<<(b)<<"is greatest";}
	else if (c>a and c>b) {cout<<(c)<<"is greatest";}
	else cout<<"something is wrong";
	return 0;
}
