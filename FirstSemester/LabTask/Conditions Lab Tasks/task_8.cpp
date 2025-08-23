/*Task # 8: In the following program, explain why the 
value "6" is printed twice in a row:*/
#include<iostream>
using namespace std;
int main()
{
      int i = 3;
      i++;
      cout << i<<endl;    // "4"
        ++i;                    
        cout<<i <<endl;   // "5"
        cout<<++i<<endl;  // "6"
        cout<<i++<<endl;  /* "6" because of post increament as 
        it was prior and increase by 1 
        after printed in console and than 7 
        when print i and in next line as i was
        save as 7 in memory*/
        cout<<i;    // "7"    
 } 
