/*Task # 7: Write a program called SumAndAverage to produce the sum of 1, 2, 3, ..., to 100.
 Also compute and display the average. The output shall look like:
The sum is 5050
The average is 50.0
*/
#include <iostream>
#include <conio.h>
using namespace std;
int main()
{
    int s=0;
    float a,g;
    for(int i=1;i<=100;i++)
    {   g=i;
        s+=i;
    }
    a=(s)/g;
    cout<<"the sum is :"<<s<<"\nThe average is :"<<a;
}