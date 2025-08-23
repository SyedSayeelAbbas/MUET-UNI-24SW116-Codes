#include <iostream>
using namespace std;
int main()
{
	char v,c;
	cout<<"Enter any character :";
	cin>>v;
	cout<<"Enter any character :";
	cin>>c;
	cout<<"Lower value "<<(char)(v+32);
	cout<<"upper value "<<(char)(c-32);
	return 0;
}
