/*Task # 13 Implement a C++ program with name Address.cpp. An address has
a house number,
a street,
an optional apartment number,
a city,
a state and a
postal code.
Supply values at run time and print the address with 
the street on one line and the city, state, and 
postal code on the next line.
*/
#include <iostream>
#include <conio.h>
using namespace std;
int main()
{
    string area,city,state,no_ap;
    int house_no,postal,street;
    cout<<"Enter house number :";
    cin>>house_no;
    cin.ignore();
    cout<<"Enter street no:";
    cin>>street;
    cin.ignore();
    cout<<"Enter apartment no(Optional):";
    getline(cin,no_ap);
    cout<<"Enter area/soceity:";
    getline(cin,area);
    cout<<"Enter city :";
    getline(cin,city);
    cout<<"Enter state :";
    getline(cin,state);
    cout<<"Enter postal code :";
    cin>>postal;
    cout<<house_no<<"/"<<street<<","<<area<<" "<<no_ap<<" ,"<<city<<" ,"<<state<<" \n"
    <<postal;
    return 0;
}
