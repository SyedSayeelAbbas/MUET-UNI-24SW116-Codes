#include <iostream>
using namespace std;
int main(){
    string str="Syed Sayeel Abbas"; int sum=0;
    for(int i=0;i<str.length();i++){
        if(str[i]%2==0){
            str[i]='a';
        }
    }
    cout<<"The sentence "<<str;
    return 0;
}
//Wrong program