#include <iostream>
using namespace std;
int main(){
    string str="Syed Sayeel Abbas"; int sum=0;
    for(int i=0;i<str.length();i++){
        if(str[i]=='a'||str[i]=='i'||str[i]=='e'||str[i]=='o'||str[i]=='u'){
            sum+=1;
        }
    }
    cout<<" In sentence "<<str<<" there are total "<<sum<<" vowel in it";
    return 0;
}