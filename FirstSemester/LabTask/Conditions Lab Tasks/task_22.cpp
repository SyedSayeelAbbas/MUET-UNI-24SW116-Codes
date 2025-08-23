/*Task # 22 Write a C++ program to convert seconds to minutes and minutes to  hours 
Sample Output:
Input seconds: 3600                                                  
Minutes: 60
Hours: 1
*/
#include <iostream>
using namespace std;
int main()
{
	cout<<"***Hour to Minutes Program***"<<endl;
	float sec;
    cout<<"Enter seconds :";
    cin>>sec;
    cout<<"seconds to minutes :"<<sec<<"sec to "<<sec/60<<"min"<<endl;
    cout<<"minutes to Hours:"<<(sec/60)<<"min to "<<(sec/60)/60<<"hour"<<endl;
    return 0;
}