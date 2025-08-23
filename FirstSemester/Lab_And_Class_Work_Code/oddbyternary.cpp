#include <iostream>
using namespace std;
int main()
{	int e;
	cout<<"Enter your number "; cin>>e;
    if(e==0) cout<<"in double figure :"<<e+10;
	else if(e%2==0) cout<<"value "<<(e)<<" in odd "<<e+1;
	//else if(e==0) cout<<"in double figure :"<<e+10;
	else if (e%2!=0) cout<<"value "<<(e)<<" in square is"<<e*e;
	return 0;
}
