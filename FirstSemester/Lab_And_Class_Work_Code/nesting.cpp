#include <iostream>
using namespace std;
int main()
{
	int num;
	cout<<"Enter :";
	cin>>num;
	if(num!=0){
		if(num>0) cout<<"positive number";
		else cout<<"negative number ";
	}
	else cout <<"not positive or negative\nas zero equal zero ";
}
