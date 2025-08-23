#include <iostream>
using namespace std;
int main(){
    int arr[11]={1,5,3,45,755,8766,434,675,446,12,34};
    for(int i=0;i<11;i++){
        for(int j=1;j<10;j++){
            if(arr[i]>arr[j]){
                arr[i]=arr[j];
            }
        }
    }
}