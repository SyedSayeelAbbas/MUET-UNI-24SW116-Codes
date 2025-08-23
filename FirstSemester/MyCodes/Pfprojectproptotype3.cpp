#include <iostream>
#include <conio.h>
#include <windows.h>
#include <cmath>
#include <string>
using namespace std;
//Iam using Class monthnumber to get number in return
//For verification purpose
class monthnumber {
public:
    static int getMonthNumber(string monthName) {
        if (monthName == "jan") return 1;
        else if (monthName == "feb") return 2;
        else if (monthName == "mar") return 3;
        else if (monthName == "apr") return 4;
        else if (monthName == "may") return 5;
        else if (monthName == "jun") return 6;
        else if (monthName == "jul") return 7;
        else if (monthName == "aug") return 8;
        else if (monthName == "sep") return 9;
        else if (monthName == "oct") return 10;
        else if (monthName == "nov") return 11;
        else if (monthName == "dec") return 12;
        return -1;
    }
//iam using string function to get name of islamic month form islamic month
//number result of convertion
    static string getIslamicMonthName(int islMonth) {
        string islamicMonths[] = {
        "Muharram","Safar","Rabi' al-Awwal","Rabi' al-Thani","Jumada al-Awwal",
        "Jumada al-Thani","Rajab","Sha'ban", "Ramadan","Shawwal","Dhu al-Qa'dah","Dhu al-Hijjah"
        };
        return islamicMonths[islMonth - 1];
    }
};
// Class To converte between Gregorian and Hijri calendars
class CalendarConverter {
public:
//converting Gergorain date to islamic by formula and function build above
    void convertToHijri(int day, int month, int year) {
        double jd, islYear, islMonth, islDay;

        jd = 367 * year - floor((7 * (year + floor((month + 9) / 12))) / 4) + 
             floor((275 * month) / 9) + day + 1721013.5;

        islYear = floor((30 * (jd - 1948439.5)) / 10631.0);
        islMonth = ceil(((jd - 1948439.5) - (10631.0 * islYear / 30.0)) / 29.5);
        islDay = ceil(jd - (1948439.5 + 10631.0 * islYear / 30.0) - (islMonth - 1) * 29.5);

        cout<<"Islamic Date: "<< islDay<<" "<<monthnumber::getIslamicMonthName(islMonth)<<" "<<islYear + 1<<endl;
    }
//converting  islamic date to Gergorain by formula and function build above
    void convertToGregorian(int islDay, int islMonth, int islYear) {
        double jd, gYear, gMonth, gDay;

        jd = 1948439.5 + (10631.0 * islYear / 30.0) + (islMonth - 1) * 29.5 + islDay; 

        gYear = floor((4 * (jd - 1721040.5) + 3) / 1461);
        gMonth = floor((5 * (jd - 1721058.5 - floor((1461 * gYear) / 4)) + 2) / 153);
        gDay = jd - 1721058.5 - floor((1461 * gYear) / 4) - floor((153 * gMonth + 2) / 5) + 1;

        gYear = gYear + (gMonth + 2) / 12;
        gMonth = ((int)gMonth + 2) % 12 + 1;
        
        cout<<"Gregorian Date: "<<(int)gDay<<"/"<<(int)gMonth<<"/"<<(int)gYear<<endl;
    }
};

//User interface and functions Arrangment
class Program {
private:
    CalendarConverter converter;
    string password;
    char IslamicEvent;
    char IslamicEventchoice;
    char Eventyear;
    float hijri_year;
    bool authenticate() {
        char a;
        cout<<"Enter password to access your program: ";
        for (int i = 0; i < 4; i++) {
            a = getch();
            cout<<"*";
            password += a;
        }
        cout << endl;
        system("cls");
            cout<<"Loading Plz wait";
            for(int i=0;i<5;i++){
                Sleep(500);
                cout<<".";
            }
        system("cls");
        return password == "Syed";
    }

    void displayMenu() {
        cout<<"Choose an option:\n";
        cout<<"1. Convert Gregorian to Hijri\n";
        cout<<"2. Convert Hijri to Gregorian\n";
        cout<<"3. Islamic event date by year\n";
        cout<<"4. World event date by year\n";
        cout<<"5. Quit\n";
        cout<<"Enter your choice: ";
    }

public:
    void run() {
        cout<<"****Welcome To Gregorian And Hijri Converter****"<<endl;
        if (!authenticate()) {
            cout<<"Incorrect password!" << endl;
            return;
        }

        while (true) {
            int choice, day, month, year;
            string monthName;
            displayMenu();
            cin >> choice;
            system("cls");
            cout<<"Loading Plz wait";
            for(int i=0;i<5;i++){
                Sleep(500);
                cout<<".";
            }
            system("cls");
            if (choice == 1) {
                // Gregorian to Hijri
                cout<<"Enter Gregorian day (1-31): ";
                cin>>day;
                cin.ignore();
                cout<<"Enter month (jan, feb, mar, etc.): ";
                getline(cin, monthName);
                cout<<"Enter year: ";
                cin>>year;
                system("cls");
                cout<<"Loading Plz wait";
                for(int i=0;i<5;i++){
                    Sleep(500);
                    cout<<".";
                }
                system("cls");
                month = monthnumber::getMonthNumber(monthName);
                if (day < 1 || day > 31 || month == -1 || year < 1) {
                    cout<<"Invalid input! Please try again.\n";
                    continue;
                }
                converter.convertToHijri(day, month, year);
                char Press;
                cout<<"Press Q to quit or Press any key to continue...";
                Press=getch();
                if(Press=='Q'||Press=='q'){system("cls"); cout<<"Thanks for using The program Bye..(^_^)"; break;}
                system("cls");
            }else if (choice == 2) {
                // Hijri to Gregorian
                cout<<"Enter Hijri day (1-30): ";
                cin>>day;
                cout<<"Choose Hijri month"<<"\n1:Muharram\t\t2:Safar\n3:Rabi' al-Awwal\t4:Rabi' al-Thani\n5:Jumada al-Awwal"
                <<"\t6:Jumada al-Thani\n7:Rajab\t\t\t8:Sha'ban\n9:Ramadan\t\t10:Shawwal\n11:Dhu al-Qa'dah\t12:Dhu al-Hijjah\nEnter :";
                cin>>month;
                cout<<"Enter Hijri year: ";
                cin>>year;
                system("cls");
                cout<<"Loading Plz wait";
                for(int i=0;i<5;i++){
                    Sleep(500);
                    cout<<".";
                }
                system("cls");
                if (day < 1 || day > 30 || month < 1 || month > 12 || year < 1) {
                    cout<<"Invalid input! Please try again.\n";
                    continue;
                }
                converter.convertToGregorian(day, month, year);
                char Press;
                cout<<"Press Q to quit or Press any key to continue...";
                Press=getch();
                if(Press=='Q'||Press=='q'){system("cls"); cout<<"Thanks for using The program Bye..(^_^)"; break;}
                system("cls");
            }
            else if (choice == 3) 
            {
                    cout<<"Choose the Event list:\na:Events Related to Prophet Muhammad (S.A.W)\tb:Islamic Festivals and Nights"
                    <<"\nc:Key Historical Events in Islamic History\td:Quit";
                    IslamicEvent=getch();
                    system("cls");
                    if(IslamicEvent=='a')
                    {   cout<<"Events Related to Prophet Muhammad (S.A.W):\n1:Eid Mawlid an-Nabi.\t\t2:First Revelation \n3:The Hijrah (Migration)"
                        <<"\t4:The Battle of Badr\n5:The Conquest of Mecca"<<"\t\t6:The Farewell Pilgrimage"
                        <<"\n7:Death of Prophet Muhammad (S.A.W)\t\t8:Quit\nEnter :";
                        cin>>IslamicEventchoice;
                        cin.ignore();
                        system("cls");
                        if(IslamicEventchoice=='1'){
                        {cout<<"Enter the gregorian year for the gregorian day \nand month for Eid Mawlid an-Nabi :";
                        cin>>Eventyear;
                        cin.ignore();
                        system("cls");
                        hijri_year=(Eventyear-622)/1.030684;
                        cout<<"Eid Mawlid an-Nabi by ";
                        converter.convertToGregorian(12,3,hijri_year);}
                        
                        {cout<<"Enter the gregorian year for the gregorian day \nand month for 2:First Revelation :";
                        cin>>Eventyear;
                        system("cls");
                        hijri_year=(Eventyear-622)/1.030684;
                        cout<<"2:First Revelation by ";
                        converter.convertToGregorian(12,3,hijri_year);}
                        
                        {cout<<"Enter the gregorian year for the gregorian day \nand month for The Hijrah (Migration):";
                        cin>>Eventyear;
                        system("cls");
                        hijri_year=(Eventyear-622)/1.030684;
                        cout<<"The Hijrah (Migration) by ";
                        converter.convertToGregorian(12,3,hijri_year);}
                        
                        {cout<<"Enter the gregorian year for the gregorian day \nand month for The Battle of Badr:";
                        cin>>Eventyear;
                        system("cls");
                        hijri_year=(Eventyear-622)/1.030684;
                        cout<<"The Battle of Badr by ";
                        converter.convertToGregorian(12,3,hijri_year);}
                    
                        {cout<<"Enter the gregorian year for the gregorian day \nand month for The Conquest of Mecca:";
                        cin>>Eventyear;
                        system("cls");
                        hijri_year=(Eventyear-622)/1.030684;
                        cout<<"The Conquest of Mecca by ";
                        converter.convertToGregorian(12,3,hijri_year);}
                        
                        {cout<<"Enter the gregorian year for the gregorian day \nand month for  The Farewell Pilgrimage:";
                        cin>>Eventyear;
                        system("cls");
                        hijri_year=(Eventyear-622)/1.030684;
                        cout<<"The Farewell Pilgrimage by ";
                        converter.convertToGregorian(12,3,hijri_year);}
                        
                        {cout<<"Enter the gregorian year for the gregorian day \nand month for Death of Prophet Muhammad (S.A.W):";
                        cin>>Eventyear;
                        system("cls");
                        hijri_year=(Eventyear-622)/1.030684;
                        cout<<"Death of Prophet Muhammad (S.A.W) by ";
                        converter.convertToGregorian(12,3,hijri_year);}

                        cout<<"Thanks for using The program Bye..(^_^)";
 
                        cout<<"error! Check  code plz";
                }
                    }
            }
            else if(choice == 4){
                
            }
            else if(choice == 5) {
                cout<<"Thanks for using The program Bye..(^_^)";
                break;
            }
            else {
                cout<<"Invalid choice! Please select 1, 2, or 3.\n";
            }
        }
    }
};
//main usage of code
int main() {
    Program program;
    program.run();
    return 0;
}
