#include <iostream>
using namespace std;
int main(){
    int arr[3]={1,3,5},sum=0,product=1;
    for(int i=0;i<3;i++){
        sum+=arr[i];
    }
    for(int i=0;i<3;i++){
        product*=arr[i];
    }
    cout<<"sum of Array :"<<sum<<endl;
    cout<<"sum of Array by sizeof:"<<sizeof(arr)/4<<endl;
    cout<<"Product of Array :"<<product;
}