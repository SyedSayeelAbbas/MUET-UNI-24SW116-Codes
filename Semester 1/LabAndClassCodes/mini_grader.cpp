#include <iostream>
using namespace std;
int main ()
{
	int a;
	cout<<"\t***GRADING SYSTEM****";
	cout<<"\nEnter your marks :";
	cin>>a;
	if(a>=90 && a<101) cout<<"A";
	else if(a>=80 && a<90) cout<<"B";
	else if(a>=70 && a<80) cout<<"C";
	else if(a>=60 && a<70) cout<<"D";
	else cout<<"F grade and you are fail";
}
