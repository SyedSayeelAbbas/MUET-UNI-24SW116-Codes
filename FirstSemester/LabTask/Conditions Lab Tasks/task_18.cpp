/*Task # 18  A shop will give discount of 10% if the cost of purchased quantity is more than 1000.
Ask user for quantity
Suppose, one unit will cost 100.
Judge and print total cost for user.
*/
#include<iostream>
#include<conio.h>
using namespace std;
int main()
{
    int o,g;
    cout<<"Enter quntity to buy :"; cin>>o;
    g=(100*o);
    if(g>=1000) cout<<"you get 10% discount of "<<(g*0.10)<<"Rs";
    else cout<<"you has not purchase enough";
}