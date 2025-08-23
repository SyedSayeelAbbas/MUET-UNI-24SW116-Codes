/*Task # 4: Consider Task=#1 and separate vowels and consonants.
Expected Output 
Vowels		Consonants
A			      B
E			      C
			      D      
*/
#include <iostream>
using namespace std;
int main()
{
    cout<<"Vowels\tConsonants"<<endl;
    for(int i=65;i<=90;i++)
    {
        if(i==65 || i==69|| i==73||i==79||i==85){
            cout<<char(i);
        }
        else if(!(i==65 || i==69|| i==73||i==79||i==85)){
            cout<<"\t"<<char(i)<<endl;
        }
    }
}