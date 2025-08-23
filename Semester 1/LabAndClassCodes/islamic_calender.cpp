#include<iostream>
#include<conio.h>
#include<cmath>
using namespace std;
int main()
{
float d,y,j;
string m,password;
char a;
cout<<"Enter password to access your program :";
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
while(true){
cout<<"\nEnter date :"; cin>>d;
cin.ignore();
cout<<"\nEnter month :"; getline(cin,m);
cout<<"\nEnter Year :"; cin>>y;
y= ((y - 622) * 33) / 32;
j=round(y);
if(m=="jan"){
    if(d>=1&&d<=12){
        cout<<"The Islamic Date of your input is:"<<d+18<<"-"<<"Jumada al-Awwal-"<<j-1;
    }
    else cout<<"The Islamic Date of your input is:"<<d-12<<"-"<<"Jumada al-Thani-"<<j-1;
}   
else if(m=="feb"){
    if(d>=1&&d<=10){
        cout<<"The Islamic Date of your input is:"<<d+20<<"-"<<"Jumada al-Thani-"<<j-1;
    }
    else cout<<"The Islamic Date of your input is:"<<d-10<<"-"<<"Rajab-"<<j-1;
}   
else if(m=="mar"){
    if(d>=1&&d<=10){
        cout<<"The Islamic Date of your input is:"<<d+20<<"-"<<"Rajab-"<<j-1;
    }
    else cout<<"The Islamic Date of your input is:"<<d-10<<"-"<<"Shaban-"<<j-1;
} 
else if(m=="apr"){
    if(d>=1&&d<=9){
        cout<<"The Islamic Date of your input is:"<<d+21<<"-"<<"Shaban-"<<j-1;
    }
    else cout<<"The Islamic Date of your input is:"<<d-9<<"-"<<"Ramdan-"<<j-1;
} 
else if(m=="may"){
    if(d>=1&&d<=9){
        cout<<"The Islamic Date of your input is:"<<d+22<<"-"<<"Ramadan-"<<j-1;
    }
    else cout<<"The Islamic Date of your input is:"<<d-9<<"-"<<"Shawwal-"<<j-1;
} 
else if(m=="jun"){
    if(d>=1&&d<=7){
        cout<<"The Islamic Date of your input is:"<<d+23<<"-"<<"Shawwal-"<<j-1;
    }
    else cout<<"The Islamic Date of your input is:"<<d-8<<"-"<<"Dhu al-Qa'dah-"<<j-1;
} 
else if(m=="jul"){
    if(d>=1&&d<=7){
        cout<<"The Islamic Date of your input is:"<<d+24<<"-"<<"Dhu al-Qa'dah-"<<j-1;
    }
    else cout<<"The Islamic Date of your input is:"<<d-13<<"Dhu al-Hijjah-"<<"-"<<j-1;
} 
else if(m=="Aug"){
    if(d>=1&&d<=7){
        cout<<"The Islamic Date of your input is:"<<d+26<<"-"<<"Dhu al-Hijjah-"<<j-1;
    }
    else cout<<"The Islamic Date of your input is:"<<d-7<<"Muharram-"<<"-"<<j;
} 
else if(m=="sep"){
    if(d>=1&&d<=3){
        cout<<"The Islamic Date of your input is:"<<d+27<<"-"<<"Muharram-"<<j;
    }
    else cout<<"The Islamic Date of your input is:"<<d-3<<"Safar-"<<"-"<<j;
} 
else if(m=="oct"){
    if(d>=1&&d<=3){
        cout<<"The Islamic Date of your input is:"<<d+27<<"-"<<"Safar-"<<j;
    }
    else cout<<"The Islamic Date of your input is:"<<d-3<<"Rabi' al-Awwal-"<<"-"<<j;
} 
// else if(m=="nov"){
//     if(d>=1&&d<=2){
//         cout<<"The Islamic Date of your input is:"<<d+28<<"Rabi' al-Awwal-"<<"r-"<<j;
//     }
//     else if(d>=1 && d<=) cout<<"The Islamic Date of your input is:"<<d+18<<"Rabi' al-Awwal-"<<"-"<<j;
// } 
// else if(m=="dec"){
//     if(d>=1&&d<=3){
//         cout<<"The Islamic Date of your input is:"<<d+27<<"-"<<"Safar-"<<j;
//     }
//     else cout<<"The Islamic Date of your input is:"<<d-3<<"Rabi' al-Awwal-"<<"-"<<j;
// } 
char input;
cout<<"\nPress any key to use to again\nOR press Q to Quit";
input=getch();
if(input=='Q') break;
}
}
return 0;
}
