#include <iostream>
#include <windows.h>
#include<conio.h>
using namespace std;
int main()
{   char a;
    string password;
    cout<<"\n\t***Welcome to ziodic calender matcher***"<<endl;
    cout<<"Enter password to accsess program"<<endl;
    a=getch();
    cout<<"*";
    password+=a;
    a=getch();
    cout<<"*";
    password+=a;
    a=getch();
    cout<<"*";
    password+=a;
    a=getch();
    cout<<"*";
    password+=a;
    if(password=="Syed"){
    system("cls");
    cout<<"loading"<<endl;
    for(int i=1;i<=12;i++){
        Sleep(500);
        cout<<"/";
    }
    system("cls");
    while (true)
    {
    string month;
    int date,year;
    cout<<"Enter your birth date :"; cin>>date;
    cin.ignore();
    cout<<"\nEnter your birth month :"; getline(cin,month);
    cout<<"\nEnter your birth year :"; cin>>year;
    system("cls");
    if((month =="jan" &&date>=20 &&date<=31)||(month =="feb" &&date>=1 &&date<=18))
    {
        cout<<"You are born in "<<date<<"-"<<month<<"-"<<year<<" So thats why"
        <<"\nYou are Aquarius\nAquarius is an air sign, not a water sign, \ndespite its symbol: the water bearer. \nThey are forward thinkers and tend to be clever, \ncreative and intelligent. \nThey can also be distant and struggle to express emotion.";
    }
    else if((month =="feb" &&date>=19 &&date<=29)||(month =="march" &&date>=1 &&date<=20))
    {
        cout<<"You are born in "<<date<<"-"<<month<<"-"<<year<<" So thats why"
        <<"\nYou are a Pisces\nPisces is symbolized by two fish and is the last of the water signs.\n Those born under the sign are considered empathetic and intuitive.\n They can easily read the emotions of others and are ruled by their own.\n Pisces are understanding and romantic,\n experiencing the world through heightened sensitivity.";
    }
    else if((month =="march" &&date>=21 &&date<=31)||(month =="apr" &&date>=1 &&date<=19))
    {
         cout<<"You are born in "<<date<<"-"<<month<<"-"<<year<<" So thats why"
        <<"\nYou are a Aries\nAries is a fire sign,\n and it is the first in the Zodiac.\n Known to be competitive,\n those born under Aries are courageous,\n strong-willed and carefree.\n Appropriately, the sign is symbolized by the ram.";
    }
    else if((month =="apr" &&date>=20 &&date<=31)||(month =="may" &&date>=1 &&date<=20))
    {
        cout<<"You are born in "<<date<<"-"<<month<<"-"<<year<<" So thats why"
        <<"\nYou are a Taurus\nTaurus is an earth sign and is \ncommonly associated with stubbornness.\n Fittingly, its symbol is the bull.\n Tauruses are also generous and dedicated,\n unafraid to take their time and resilient";
    }
    else if((month =="may" &&date>=21 &&date<=31)||(month =="june" &&date>=1 &&date<=21))
    {
        cout<<"You are born in "<<date<<"-"<<month<<"-"<<year<<" So thats why"
        <<"\nYou are a Gemini\nGemini is an air sign and is symbolized by a set of twins.\n Bearers of this sign are communicative, intellectual and curious,\n often filling their plates so that busyness abounds.";
    }
    else if((month =="june" &&date>=22 &&date<=31)||(month =="july" &&date>=1 &&date<=22))
    {
        cout<<"You are born in "<<date<<"-"<<month<<"-"<<year<<" So thats why"
        <<"\nYou are a Cancer\nCancer is a water sign, rounding out the four elements.\n It is represented by the crab. \nDespite their hard exteriors, Cancers are deeply emotional creatures. \nThey often experience high levels of sentimentality and compassion";
    }
     else if((month =="july" &&date>=23 &&date<=31)||(month =="aug" &&date>=1 &&date<=22))
    {
        cout<<"You are born in "<<date<<"-"<<month<<"-"<<year<<" So thats why"
        <<"\nYou are a Leo\nLeo is a fire sign and is symbolized by the lion.\n They are natural-born leaders and are driven by a courageous spirit.\n Leos are also considered to be hard-working, confident and loyal.";
    }
     else if((month =="aug" &&date>=23 &&date<=31)||(month =="sep" &&date>=1 &&date<=22))
    {
        cout<<"You are born in "<<date<<"-"<<month<<"-"<<year<<" So thats why"
        <<"\nYou are a Virgo\nVirgo is an earth sign, symbolized by a maiden\n (who is occasionally seen holding wheat). \nVirgos are said to be analytical, detail-oriented and highly practical.\n This occasionally leads to perfectionism. \nThey love to help but are fierce self-critics.";
    }
    else if((month =="sep" &&date>=23 &&date<=31)||(month =="oct" &&date>=1 &&date<=23))
    {
        cout<<"You are born in "<<date<<"-"<<month<<"-"<<year<<" So thats why"
        <<"\nYou are a Libra\nLibra is an air sign. Represented by scales,\n it's no surprise that this sign loves harmony.\n Libras are said to be creative and idealistic. \nThose born under the sign can also be indecisive \nand often weigh their options, struggling to commit.";
    }
    else if((month =="oct" &&date>=24 &&date<=31)||(month =="nov" &&date>=1 &&date<=21))
    {
        cout<<"You are born in "<<date<<"-"<<month<<"-"<<year<<" So thats why"
        <<"\nYou are a Shocker\nShocker: Scorpio is represented by a scorpion. \nThe water sign is known to be determined, passionate and competitive. \nThose born under Scorpio are also considered mysterious and intense";
    }
     else if((month =="nov" &&date>=22 &&date<=31)||(month =="dec" &&date>=1 &&date<=21))
    {
        cout<<"You are born in "<<date<<"-"<<month<<"-"<<year<<" So thats why"
        <<"\nYou are a Sagittarius \nSagittarius is a fire sign, symbolized the archer.\n The sign is quite adventurous and\n free-spirited, constantly seeking travel and change.\n However, this carefree nature can lead to inconsistency";
    }
     else if((month =="dec" &&date>=22 &&date<=31)||(month =="jan" &&date>=1 &&date<=19))
    {
        cout<<"You are born in "<<date<<"-"<<month<<"-"<<year<<" So thats why"
        <<"\nYou are a Capricorn \nCapricorn is represented by the sea goat.\n Those born under the sign are seen as ambitious, practical and focused.\n They can be a shoulder to lean on but also can become pessimistic or cold";
    }
    cout<<"\n\n\tPress any key to check again\n\tOR Press Q to stop the program"<<endl;
    char input; input=getche(); if(input=='Q') break;
    }}
    else cout<<"\nTry Again";
    return 0;
}