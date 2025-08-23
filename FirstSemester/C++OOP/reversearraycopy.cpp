#include<iostream>
using namespace std;
int main(){
    int arrA[5]={1,2,3,4,5},arrB[5];
        for(int j=0;j<5;j++){
        arrB[j]=arrA[5-1-j];
        cout<<arrB<<" ";}

}