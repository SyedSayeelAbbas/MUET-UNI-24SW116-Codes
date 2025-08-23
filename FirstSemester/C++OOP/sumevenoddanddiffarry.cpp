#include <iostream>
using namespace std;
int main(){
    int arr[5]={1,2,3,4,5},sume=0,sumo=0;
    for(int i=0;i<5;i++){
        if(i%2!=0){
            sumo+=arr[i];
        }
        else if(i%2==0){
            sume+=arr[i];
        }
    }
    cout<<"The diff of "<<sume<<"-"<<sumo<<" is "<<sume-sumo;
}