/*Task # 16: Write a program that declares an int variable, 
assign it a value of your choice. The program checks as:
	if the number is even make it odd number.
	if the number is odd prints its square. 
	if the number is equal to 0 make it a double figure number and prints its cube.
*/
#include <iostream>
using namespace std;
int main()
{	int e;
	cout<<"Enter your number :"; cin>>e;
    if(e==0) cout<<"in double figure :"<<e+10<<" and in cuic form is "<<(e+10)*(e+10)*(e+10);
	else if(e%2==0) cout<<"value "<<(e)<<" in odd "<<e+1;
	else if (e%2!=0) cout<<"value "<<(e)<<" in square is"<<e*e;
	return 0;
}