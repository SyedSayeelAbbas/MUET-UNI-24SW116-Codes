/*Create a C++ program that accepts a student's score and determines the grade using the following rules:  
- 90-100: A  
- 80-89: B  
- 70-79: C  
- 60-69: D  
- Below 60: F
*/
#include <iostream>
using namespace std;
int main()
{
    int mark;
    cout<<"Enter your mark :";
    if(!(cin>>mark))
    {cout<<"wrong input";}
    else if (mark>=90 and mark<=100){cout<<"You have obtained "<<mark<<" and get  A Grade";}
    else if (mark>=80 and mark<90){cout<<"You have obtained "<<mark<<" and get B Grade";}
    else if (mark>=70 and mark<80){cout<<"You have obtained "<<mark<<" and get  C Grade";}
    else if (mark>=60 and mark<70){cout<<"You have obtained "<<mark<<" and get  D Grade";}
    else if (mark<60){cout<<"You have obtained "<<mark<<" and get  F Grade";}
    return 0;
}   