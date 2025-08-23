#include <iostream>
#include <conio.h>
using namespace std;
int main(){
	char p;
	cout<<"Enter any character "<<endl; p=getche();
	if(p>='a' && p<='z' || p>='A' && p<='Z')
	{
	(p=='a' || p=='e' || p=='i' || p=='o' || p=='u') ? cout<<"\nITS A Vowel":cout<<"\nITS a consunent";
	}
	else cout<<"\nEnter aplphabets plz";
	return 0;
}
