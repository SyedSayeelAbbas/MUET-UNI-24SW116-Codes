/*Task #: 15 Write a C++ program that takes a single character 
as input and tells whether it is a vowel or a consonant. 
(Use Conditional operator)
*/
#include <iostream>
#include <conio.h>
using namespace std;
int main()
{
    char x;
    cout<<"Enter alphabet :";
    x=getche();
     if((x>='a'&& x<='z')||(x>='A'&& x<='Z'))
     {
        if(x=='a'||x=='i'||x=='u'||x=='e'||x=='o')
        {
            cout<<"\n"<<(x)<<" is a vowwel";
        }
        else cout<<"\n"<<(x)<<" is a consunent";
     }
     else cout<<"\nEnter alphabet only\ntry again";
}
