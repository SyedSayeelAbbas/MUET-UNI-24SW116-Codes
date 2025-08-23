#include <iostream>
using namespace std;
int main()
{   while(true){
	cout<<"***Hour to Minutes Program***"<<endl;
	int Hours;
	cout<<"Enter the value for convertion from hour to minutes :";
	cin>>Hours;
	cout<<"\nIn "<<Hours<<" hour there is :"<<Hours*60<<"minutes";
	cout<<"to exit press Q :";
	char input;
	cin>>input;
	if(input=='Q') break;
	}
	return 0;
}
