/*Task # 5(a): Consider an integer value give:
  int num=5;
display the square of the number given 
when the spacebar key on the keyboard will pressed.
*/
#include<iostream>
#include<conio.h>
using namespace std;
int main()
{
    int x;
    char y;
    cout<<"Enter number :";
    cin>>x;
    if(x%2==0) cout<<(x)<<" is even"<<endl;
    else cout<<(x)<<" is odd"<<endl;
    cout<<"Press space bar for square"<<endl;
    y=getch();
    if(y==' ') cout<<"square of "<<(x)<<" is "<<x*x;
    return 0;
}