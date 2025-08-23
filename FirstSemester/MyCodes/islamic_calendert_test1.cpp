#include<iostream>
#include<conio.h>
using namespace std;
int main()
{
float d,y,j;
string m;
cout<<"Enter the date on global calender :"; cin>>d;
cin.ignore();
cout<<"Enter the month on global calender :"; getline(cin,m);
cout<<"Enter the year on global calender :"; cin>>y;
y= ((y - 622) * 33) / 32;
//d = y - 622 + (y - 622 / 33);
if((m=="oct"&&d>=12 && d<=31) ||(m=="nov"&& d>=1 && d<=12))
{
cout<<"Today is the islamic year of :"<<y<<" Haijri \nAnd the islamic month Rabi' al-Awwal: \nAnd The islamic date is :"<<d-11;
}
//     Muharram:

// August 10 - September 8
// Safar:

// September 9 - October 8
// Rabi' al-Awwal:

// October 9 - November 7
// Rabi' al-Thani:

// November 8 - December 7
// Jumada al-Awwal:

// December 8 - January 6
// Jumada al-Thani:

// January 7 - February 5
// Rajab:

// February 6 - March 7
// Sha'ban:

// March 8 - April 6
// Ramadan:

// April 7 - May 6
// Shawwal:

// May 7 - June 5
// Dhu al-Qi'dah:

// June 6 - July 5
// Dhu al-Hijjah:

// July 6 - August 4

}