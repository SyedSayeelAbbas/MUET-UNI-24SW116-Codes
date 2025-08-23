/*Task # 2: Generate a series of Odd numbers and even numbers (up to 20) using for  loop.
Expected output 
Odd		  even
1	          2
3		      4
*/
#include<iostream>
using namespace std;
int main()
{   int n,i;
    cout<<"Enter the start of the number :"; cin>>i;
    cout<<"Enter the end of the number :"; cin>>n;
    cout<<"Odd\tEven"<<endl;
    for(i;i<=n;i++){
        if(i%2==0){
        cout<<"\t"<<i<<endl;}
        else if (i%2!=0){
        cout<<i;
        }
        else cout<<"Error";
    }
}