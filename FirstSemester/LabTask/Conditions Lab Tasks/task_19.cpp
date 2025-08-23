/*Task # 19: Develop a mark sheet application in java which fulfills the following requirements:
The program takes input from the user marks obtained in three subjects; C++, Data Structures and Operating Systems.
•	The program calculates the total marks obtained out of 300.
•	Calculate the percentage.
•	Display the grade secured according to the following:
	90 >			Grade: A
	Between 90 and 80	Grade: B
	Between 79 and 70	Grade: C
	Between 69 and 60 	Grade: D
	Below 60		Grade: FAIL
*/
#include <iostream>
using namespace std;
int main ()
{
	float a,b,c,percent;    
	cout<<"\t***GRADING SYSTEM****";
	cout<<"\nEnter your English marks :";
	cin>>a;
    if(a>=100) cout<<"you cant and marks less than 1 and greater than 100\ntry again or you get wrong answer";
	cout<<"\nEnter your Math marks :";
	cin>>b;
    if(b>=100) cout<<"you cant and marks less than 1 and greater than 100\ntry again or you get wrong answer";
	cout<<"\nEnter your Urdu marks :";
	cin>>c;
    if(c>=100) cout<<"you cant and marks less than 1 and greater than 100\ntry again or you get wrong answer";
    percent=100*(a+b+c)/300;
	if(percent>=90 && percent<101) cout<<"You are pass with garde of A by scoring :"<<percent<<"%";
	else if(percent>=80 && percent<90) cout<<"You are pass with garde of B by scoring :"<<percent<<"%";
	else if(percent>=70 && percent<80) cout<<"You are pass with garde of C by scoring :"<<percent<<"%";
	else if(percent>=60 && percent<70) cout<<"You are pass with garde of D by scoring :"<<percent<<"%";
	else cout<<"F grade and you are fail as you score :"<<percent<<"%";
}