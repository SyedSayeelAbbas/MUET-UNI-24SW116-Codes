/*Task #2: A student will not be allowed to sit in exam if 
his/her attendance is less than 75%.

Take following input from user
Number of classes held
Number of classes attended.
And print
percentage of class attended
Is student is allowed to sit in exam or not.
*/
#include<iostream>
using namespace std;
int main()
{
    float attend,held,percent;
    cout<<"Enter number of classes held :";
    cin>>held;
    cout<<"Enter number of classes attend :";
    cin>>attend;
    percent=100*(attend/held);
    if(!(percent>='a'&&percent<='z')&&!(percent>='A'&&percent<='Z')
    &&(percent>0))
    {
        if(percent>=75) {cout<<"You are allowed to attempt the exam";}
        else cout<<"You are not allowed to attempt the exam";
    }
    else  cout<<"someting is worng check code plz";
    return 0;
}