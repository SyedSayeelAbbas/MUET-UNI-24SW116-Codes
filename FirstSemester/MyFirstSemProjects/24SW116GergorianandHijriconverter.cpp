#include <iostream>
#include <conio.h>
#include <windows.h>
#include <cmath>
#include <string>
#include <set> 
using namespace std;
//Iam using Class monthnumber to get number in return
//For verification purpose
class monthnumber {
public:
        int getMonthNumber(string monthName) {
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
        string getIslamicMonthName(int islMonth) {
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
//here we first calculate JDN value
    double jd = day 
            + floor((153 * (month + 12 * ((14 - month) / 12) - 3) + 2) / 5) 
            + 365 * (year + 4800 - ((14 - month) / 12)) 
            + floor((year + 4800 - ((14 - month) / 12)) / 4) 
            - floor((year + 4800 - ((14 - month) / 12)) / 100) 
            + floor((year + 4800 - ((14 - month) / 12)) / 400) 
            - 32045;

//Here it Calculate Hijri Year
    double daysSinceHijriEpoch = jd - 1948439.5;
    int islYear = floor(daysSinceHijriEpoch / 354.36667);
    double remainingDays = daysSinceHijriEpoch - (islYear * 354.36667);

//Here it Calculate Hijri Month and Day
    int islMonth = 1;
    while (remainingDays > 29.5) {
        remainingDays -= 29.5;
        islMonth++;
    }
    int islDay = ceil(remainingDays);

//Here is the layout to Print Result
    monthnumber I1;
    cout << "Islamic Date: " << islDay << " " 
    << I1.getIslamicMonthName(islMonth) << " " 
    << islYear + 1 << endl;
}
/*converting  islamic date to Gergorain by formula and function build above
Function to check if a given Hijri year is a leap year*/
bool isHijriLeapYear(int year) {
    // Set of leap years in the Hijri calendar cycle (30 years)
    static const set<int> leapYears = {1, 2, 4, 5, 7, 9, 10, 12, 13, 15, 16,
    18, 20, 21, 23, 24, 26, 28, 29};
    return leapYears.find(year % 30) != leapYears.end();
}

// Function to calculate the total days from the start of the Hijri calendar
double hijriToJDN(int hijriDay, int hijriMonth, int hijriYear) {
    const double hijriEpochJDN = 1948439.5; // JDN for July 16, 622 CE (start of Hijri calendar)

    // Calculate the number of full years and their equivalent days
    int fullYears = hijriYear - 1;
    int daysInYears = fullYears * 354 + fullYears / 30 * 11; // Basic day count (non-leap years)

    // Add days for leap years in the current cycle
    for (int i = 1; i <= fullYears % 30; i++) {
        if (isHijriLeapYear(i)) daysInYears++;
    }

    // Days in completed months of the current year
    int daysInMonths = 0;
    for (int i = 1; i < hijriMonth; i++) {
        // Odd months (1, 3, 5, 7, 9, 11) have 30 days, even months (except Dhu al-Hijjah) have 29 days
        daysInMonths += (i == 12 && isHijriLeapYear(hijriYear)) ? 30 : (i % 2 == 1 ? 30 : 29);
    }

    // Total days from the Hijri epoch (JDN)
    double totalDays = daysInYears + daysInMonths + hijriDay;

    // Convert to Julian Day Number
    return hijriEpochJDN + totalDays;
}

// Function to convert JDN to Gregorian date
void jdnToGregorian(double jd) {
    double L = jd + 68569;
    int N = static_cast<int>(4 * L / 146097);
    L = L - static_cast<int>((146097 * N + 3) / 4);
    int I = static_cast<int>((4000 * (L + 1)) / 1461001);
    L = L - static_cast<int>((1461 * I) / 4) + 31;
    int J = static_cast<int>((80 * L) / 2447);
    int day = static_cast<int>(L - (2447 * J) / 80);
    L = static_cast<int>(J / 11);
    int month = static_cast<int>(J + 2 - 12 * L);
    int year = static_cast<int>(100 * (N - 49) + I + L);

    // Output the Gregorian date
    cout << "Gregorian Date: " << (day-3) << "/" << month << "/" << year << endl;
}

// Main function to convert Hijri to Gregorian
void convertToGregorian(int hijriDay, int hijriMonth, int hijriYear) {
    double jd = hijriToJDN(hijriDay, hijriMonth, hijriYear);
    jdnToGregorian(jd);
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
    char ger_year,ger_Event_choose;
    bool authenticate() {
        char a;
        cout<<"\t\t**TO ACCESS YOUR PROGREAM**\n\t\t\t|\n\t\t\tV\n\t"
        <<"====================================\n\t\t*Enter Password Here*:";
        for (int i = 0; i < 4; i++) {
            a = getch();
            cout<<"*";
            password += a;
        }
        cout << endl;
        system("cls");
            cout<<"Loading Plz wait";
            for(int i=0;i<=4;i++){
                Sleep(500);
                cout<<"(^_^) ";
            }
        system("cls");
        return password == "Syed";
    }

    void displayMenu() {
        cout<<"******Choose an option******\n===========================================================\n";
        cout<<"||1.Convert Gregorian to Hijri\t\t\t\t||\n";
        cout<<"||2.Convert Hijri to Gregorian\t\t\t\t||\n";
        cout<<"||3.Islamic Events date in (Gregorian) by islamic year  ||\n";
        cout<<"||4.World Events date in (Islamic) by Gregorian year    ||\n";
        cout<<"||5. Quit\t\t\t\t\t\t||\n===========================================================\n";
        cout<<"->\tEnter your choice here:- ";
    }

public:
    void run() {
        cout<<"\tProgram is Starting"<<endl;
        for(int i=0;i<=6;i++){
                Sleep(500);
                cout<<"////////";
        }
        system("cls");
        cout<<"\t========================================\n\t"
        <<"*Welcome To Gregorian And Hijri Converter*\n\t========================================="<<endl;
        if (!authenticate()){
            cout<<"Incorrect password![*o*]" << endl;
            return;
        }

        while (true) {
            int choice, day, month, year;
            string monthName;
            displayMenu();
            cin >> choice;
            system("cls");
            cout<<"Thanks;Plz wait"<<endl;
            for(int i=0;i<5;i++){
                Sleep(500);
                cout<<"-_- ";
            }
            system("cls");
        if (choice == 1)
        {
                // Gregorian to Hijri
                cout<<"Enter Gregorian day (1-31): ";
                cin>>day;
                cin.ignore();
                system("cls");
                cout<<"Enter month (jan, feb, mar, etc.): ";
                getline(cin, monthName);
                system("cls");
                cout<<"Enter year: ";
                cin>>year;
                system("cls");
                cout<<"Processing; wait moment"<<endl;
                for(int i=0;i<5;i++){
                    Sleep(500);
                    cout<<"????";
                }
                system("cls");
                monthnumber I1;
                month = I1.getMonthNumber(monthName);
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
        }
        else if (choice == 2) 
        {
                // Hijri to Gregorian
                cout<<"Enter Hijri day (1-30): ";
                cin>>day;
                system("cls");
                cout<<"Choose Hijri month"<<"\n1:Muharram\t\t2:Safar\n3:Rabi' al-Awwal\t4:Rabi' al-Thani\n5:Jumada al-Awwal"
                <<"\t6:Jumada al-Thani\n7:Rajab\t\t\t8:Sha'ban\n9:Ramadan\t\t10:Shawwal\n11:Dhu al-Qa'dah\t12:Dhu al-Hijjah\nEnter :";
                cin>>month;
                system("cls");
                cout<<"Enter Hijri year: ";
                cin>>year;
                system("cls");
                system("cls");
                cout<<"Processing; wait moment"<<endl;
                for(int i=0;i<5;i++){
                    Sleep(500);
                    cout<<"????";
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
                cout<<"Choose the Event list:\na:Events Related to Prophet Muhammad (S.A.W)"
                <<"\tb:Islamic Festivals and Nights"
                <<"\nc:Key Historical Events in Islamic History\td:Quit";
                IslamicEvent=getch();
                system("cls");
            if(IslamicEvent=='a')
            {
                cout<<"Events Related to Prophet Muhammad (S.A.W):"
                <<"\n1:Eid Mawlid an-Nabi.\t\t2:First Revelation "
                <<"\n3:The Hijrah (Migration)"
                <<"\t4:The Battle of Badr\n5:The Battle of Uhud"
                <<"\t\t6:The Treaty of Hudaybiyyah\n7:The Conquest of Mecca"
                <<"\t8:The Farewell Pilgrimage"
                <<"\n9:Death of Prophet Muhammad (S.A.W)\nEnter :";
                cin>>IslamicEventchoice;
                system("cls");
                cout<<"Enter the Hijri year for Gregorian date \nmonth and year  for respected event:";
                cin>>hijri_year;
                system("cls");
                cout<<"Processing; wait moment"<<endl;
                for(int i=0;i<5;i++){
                    Sleep(500);
                    cout<<"????";
                }
                system("cls");
                if(IslamicEventchoice=='1')
                {
                    cout<<"Eid Mawlid an-Nabi by ";
                    converter.convertToGregorian(12,3,hijri_year);
                    cout<<"Press any key to continue..."; getch();
                    system("cls");
                }
                else if(IslamicEventchoice=='2')
                {
                    cout<<"First Revelation by ";
                    converter.convertToGregorian(27,9,hijri_year);
                    cout<<"Press any key to continue..."; getch();
                    system("cls");
                }
                else if(IslamicEventchoice=='3')
                {
                    cout<<"The Hijrah (Migration) by ";
                    converter.convertToGregorian(12,5,hijri_year);
                    cout<<"Press any key to continue..."; getch();
                    system("cls");
                }
                else if(IslamicEventchoice=='4')
                {
                    cout<<"The Battle of Badr by ";
                    converter.convertToGregorian(17,9,hijri_year);
                    cout<<"Press any key to continue..."; getch();
                    system("cls");
                }
                else if(IslamicEventchoice=='5')
                {
                    cout<<"The Battle of Uhud by ";
                    converter.convertToGregorian(7,10,hijri_year);
                    cout<<"Press any key to continue..."; getch();
                    system("cls");
                }
                else if(IslamicEventchoice=='6')
                {
                    cout<<"The Treaty of Hudaybiyyah by ";
                    converter.convertToGregorian(6,11,hijri_year);
                    cout<<"Press any key to continue..."; getch();
                    system("cls");
                }
                else if(IslamicEventchoice=='7')
                {
                    cout<<"The Conquest of Mecca by ";
                    converter.convertToGregorian(20,9,hijri_year);
                    cout<<"Press any key to continue..."; getch();
                    system("cls");
                }
                else if(IslamicEventchoice=='8')
                {
                    cout<<"The Farewell Pilgrimage ";
                    converter.convertToGregorian(9,12,hijri_year);
                    cout<<"Press any key to continue..."; getch();
                    system("cls");
                }
                else if(IslamicEventchoice=='9')
                {
                    cout<<"Death of Prophet Muhammad (S.A.W) by ";
                    converter.convertToGregorian(12,3,hijri_year);
                    cout<<"Press any key to continue..."; getch();
                    system("cls");
                }
                        
                else
                { cout<<"error! Check  code plz";}
                
            }
            else if(IslamicEvent=='b')
            {
                cout<<"Events Related to Islamic Festivals and Nights:"
                <<"\n1:Eid al-Fitr"
                <<"\t2:Eid al-Adha"<<"\n3:Ashura"
                <<"\nEnter :";
                cin>>IslamicEventchoice;
                system("cls");
                cout<<"Enter the Hijri year for Gregorian day \nmonth and year for respected event:";
                cin>>hijri_year;
                system("cls");
                cout<<"Processing; wait moment"<<endl;
                for(int i=0;i<5;i++){
                    Sleep(500);
                    cout<<"????";
                }
                system("cls");
                if(IslamicEventchoice=='1')
                {
                    cout<<"Eid al-Fitr by";
                    converter.convertToGregorian(1,10,hijri_year);
                    cout<<"Press any key to continue..."; getch();
                    system("cls");
                }
                else if(IslamicEventchoice=='2')
                {
                    cout<<"Eid al-Adha by";
                    converter.convertToGregorian(10,12,hijri_year);
                    cout<<"Press any key to continue..."; getch();
                    system("cls");
                }
                else if(IslamicEventchoice=='3')
                {
                    cout<<"Ashura by";
                    converter.convertToGregorian(10,1,hijri_year);
                    cout<<"Press any key to continue..."; getch();
                    system("cls");
                }
                
            }
            else if(IslamicEvent=='c')
            {
                cout<<"List for Key Historical Events in Islamic History:"
                <<"\n1:Isra and Mi'raj "
                <<"\t2:The Battle of Karbala"
                <<"\n3:Establishment of the Hijri Calendar\n(!Results of Option 3 are not accurate as they  )\n";
                cout<<"(are not based on lunar calender as it is based  )\n";
                cout<<"(mathametical calculations!                      )"
                <<"\nEnter :";
                cin>>IslamicEventchoice;
                system("cls");
                cout<<"Enter the Hijri year for Gregorian date \nmonth and year  for respected event:";
                cin>>hijri_year;
                system("cls");
                cout<<"Processing; wait moment"<<endl;
                for(int i=0;i<5;i++){
                    Sleep(500);
                    cout<<"????";
                }
                system("cls");
                if(IslamicEventchoice=='1')
                {
                    cout<<"Isra and Mi'raj by";
                    converter.convertToGregorian(27,7,hijri_year);
                    cout<<"Press any key to continue..."; getch();
                    system("cls");
                }
                if(IslamicEventchoice=='2')
                {
                    cout<<"The Battle of Karbala";
                    converter.convertToGregorian(10,1,hijri_year);
                    cout<<"Press any key to continue..."; getch();
                    system("cls");
                }
                if(IslamicEventchoice=='3')
                {
                    cout<<"Establishment of the Hijri Calendar";
                    converter.convertToGregorian(17,12,hijri_year);
                    cout<<"Press any key to continue..."; getch();
                    system("cls");
                }
            }
            else if(IslamicEvent=='d')
            {
                cout<<"Thanks for using The program Bye..(^_^)";
                break;
            }
        }
        else if(choice == 4)
        {
            cout<<"Choose the Event on the given list:\n1:New year\t\t2:Christmas Day\n3:Human Rights Day\t4:Halloween\n(!Results of Option 4 are not accurate as they  )\n";
        cout<<"(are not based on lunar calender as it is based  )\n";
        cout<<"(mathametical calculations!                      )\nEnter:";
            cin>>ger_Event_choose;
            cout<<"Enter the Gregoric year for Islamic date \nand month  for respected event:";
            cin>>ger_year;
            system("cls");
                cout<<"Processing; wait moment"<<endl;
                for(int i=0;i<5;i++){
                    Sleep(500);
                    cout<<"????";
                }
            system("cls");
            if(ger_Event_choose=='1')
            {
                cout<<"New year by :";
                converter.convertToHijri(1,1,ger_year);
                cout<<"Press any key to continue..."; getch();
                system("cls");
            }
            else if(ger_Event_choose=='2')
            {
                cout<<"Christmas Day by :";
                converter.convertToHijri(25,12,ger_year);
                cout<<"Press any key to continue..."; getch();
                system("cls");
            }
            else if(ger_Event_choose=='3')
            {
                cout<<"Human Rights Day by :";
                converter.convertToHijri(10,12,ger_year);
                cout<<"Press any key to continue..."; getch();
                system("cls");
            }
            else if(ger_Event_choose=='4')
            {
                cout<<"Halloween by :";
                converter.convertToHijri(31,10,ger_year);
                cout<<"Press any key to continue..."; getch();
                system("cls");
            }
        }
        else if(choice == 5)
        {
            cout<<"Thanks for using The program Bye..(^_^)";
            break;
        }
        // else
        // {
        //     cout<<"Invalid choice! Please select 1, 2, or 3.\n";
        // }
        }
    }
};
//main usage of code
int main() {
    Program program;
    program.run();
    return 0;
}
//As Islamic calender depends upon lunar movement so the values are aproximate
