/*Task # 3: Write a program that prints all Roll numbers of your class using for loop. 
Output should be as :
20SW01     
20SW02
20SW03
…..
…
20SW10
20SW11 
and so on.
*/
#include <iostream>
#include <conio.h>
using namespace std;

int main()
{
    int n;
    char a;
    cout << "Total number of students in software bath 2024: ";
    cin >> n;
    cout << "Select the section number from 24 \n1: for section 1\n2: for section 2\n3: for section 3: ";
    a=getch();
    system("cls");
    cout << "Following are the list of students by Roll number in sections:" << endl;
    if(a=='1')
    {
     for (int i = 1; i <= n; i+=3)
     {
        if (i % 3 == 1) 
        {
        if (i < 10) {
        cout << "Section 1: 24SW";
        cout << "0";
        cout << i << endl;
        }
        else if(i>=10 && i<=88)
        {
        cout << "Section 1: 24SW";
        cout << i << endl;
        }
        else if ((i>=100 && i<=169)){
            cout << "Section 1: 24SW";
            cout<<i+1<<endl;
        }
        } 
     }
    }
    else if(a=='2')
    {
          for (int i = 2; i <= n; i+=3)
     {
        if (i % 3 == 2) 
        {
        if (i < 10) {
        cout << "Section 2: 24SW";
        cout << "0";
        cout << i << endl;
        }
        else if(i>=10 && i<=86)
        {
        cout << "Section 2: 24SW";
        cout << i << endl;
        }
        else if ((i>=101 && i<=168)){
            cout << "Section 2: 24SW";
            cout<<i+1<<endl;
        }
        } 
     }
    }
    else if(a=='3')
    {
          for (int i = 0; i <= n; i+=3)
     {
        if (i % 3 == 0) 
        {
        if (i < 10) {
        cout << "Section 3: 24SW";
        cout << "0";
        cout << i << endl;
        }
        else if(i>=10 && i<=84)
        {
        cout << "Section 3: 24SW";
        cout << i << endl;
        }
        else if ((i>=102 && i<=167)){
            cout << "Section 3: 24SW";
            cout<<i+1<<endl;
        }
        } 
     }
    }
    return 0;
}
