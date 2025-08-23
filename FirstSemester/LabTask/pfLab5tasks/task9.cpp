/*Task# 9 write a program that takes an inter as an input and prints its factorial
Output
Number :  5
Factorial : 120 
*/#include <iostream>
using namespace std;
int main()
{
    int i,c=1,n=5;
    for(i=1;i<=n;i++){
        c*=i;
    }
    cout<<"number : "<<n<<"\nFactorial :"<<c;
}