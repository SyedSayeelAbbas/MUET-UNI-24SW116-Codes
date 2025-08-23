#include <iostream>
#include <conio.h>
using namespace std;
int main(){
	char character;
	cout<<"Enter Your Character :"; character=getch();
	system("cls");
	if(!(character>='a'&&character<='z'||character>='A'&&character<='Z')){
	cout<<"!!Plz Enter Alphabet only";}
	else {
	switch(character){
		case 'a':
			cout<<character<<" IS A VOWEL";
			break;
		case 'e':
			cout<<character<<" IS A VOWEL";
			break;
		case 'i':
			cout<<character<<" IS A VOWEL";
			break;
		case 'o':
			cout<<character<<" IS A VOWEL";
			break;
		case 'u':
			cout<<character<<" IS A VOWEL";
			break;	
		case 'A':
			cout<<character<<" IS A VOWEL";
			break;
		case 'E':
			cout<<character<<" IS A VOWEL";
			break;
		case 'I':
			cout<<character<<" IS A VOWEL";
			break;
		case 'O':
			cout<<character<<" IS A VOWEL";
			break;
		case 'U':
			cout<<character<<" IS A VOWEL";
			break;
		default :
		    cout<<character<<" is a consonant";																					
	}}
    return 0;
}