/*Task # 5  Write a program to print the table of characters that are equivalent to the Ascii codes from 97 to 122.
The program will print 10 characters per line.
*/
#include <iostream>
using namespace std;
int main()
{
    int i;
    for(i=97;i<=106;i++){
        cout<<char(i)<<" ";
    }
    cout<<endl;
    for(i=107;i<=116;i++){
        cout<<char(i)<<" ";
    }
    cout<<endl;
    for(i=117;i<=122;i++){
        cout<<char(i)<<" ";
    }
    return 0;
//by gpt
//     #include <iostream>
// using namespace std;
// int main()
// {
//     int i;
//     for(i = 97; i <= 122; i++) {
//         cout << char(i) << " ";
        
//         // Print a new line after every 10 characters
//         if ((i - 96) % 10 == 0) {
//             cout << endl;
//         }
//     }
//     return 0;
//}

}