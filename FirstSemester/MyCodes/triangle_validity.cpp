#include <iostream>
using namespace std;
int main()
{
    int a,b,c;
    cout<<"Enter the values for three side of triangle "<<endl;
    cin>>a>>b>>c;
    // if(a+b>c) cout<<"This is a triangle\n";
    // else if(c+b>a) cout<<"This is a triangle\n";
    // else if(a+c>b) cout<<"This is a triangle\n";
    if(a+b>c and a+c>b and b+c>a) cout<<"This is a triangle\n";
    else cout<<"This is not a triangle\n";
    cout<<"PROGRAM END";
    return 0;
}