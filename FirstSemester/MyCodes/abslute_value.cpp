#include <iostream>
using namespace std;
int main()
{
    int a;
    cout<<"Enter your number : ";
    cin>>a;
    if(a>0){
        cout<<"The absolute value of your vale "<<a<<" is "<<a<<endl;
    }
    else if(a<=0) cout<<"the absolue value of "<<a<<" is "<<-a;
    return 0;
}
