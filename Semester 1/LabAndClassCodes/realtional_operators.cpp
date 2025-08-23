#include <iostream>
using namespace std;
int main ()
{
	int a,b;
	cout<<"Enter value of a and b :"; cin>>a>>b;
	int input;
	cout<<"enter to choose \n1 to choose a>b\n2 to choose a<b\nEnter:"; cin>>input;
	if (input==1) cout<<boolalpha<<(a>b);
	else if (input==2) cout<<boolalpha<<(a<b);
	return 0;
}
