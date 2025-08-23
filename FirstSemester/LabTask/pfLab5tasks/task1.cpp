/*Task # 1: Generate alphabets from A to Z.  (ASCII code for A=65 and Z=90)*/
#include <iostream>
using namespace std;
int main()
{
    int i;
    for(i=64;i<90;i++){
        cout<<char(i+1)<<" ";
    }
    return 0; 
}
