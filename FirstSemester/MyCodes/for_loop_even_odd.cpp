/*Task 1:Rebuild a series of odd and even number using for and while loop*/
#include <iostream>
using namespace std;
int main()
{   int p;
    cout<<"Enter the number of time to print even or odd number\n"<<"Enter:"; cin>>p;
    for(int i=1;i<=p;i++){
        if(i%2==0) cout<<"Even :"<<i<<" "<<endl;
        if(i%2!=0) cout<<"Odd :"<<i<<" "<<endl;
    }
    cout<<endl<<"by while loop"<<endl;
    int i=1;
    while(i<=p){
    	if(i%2==0) cout<<"Even :"<<i<<" "<<endl;
        if(i%2!=0) cout<<"Odd :"<<i<<" "<<endl;
        i++;
	}
    return 0;
}
