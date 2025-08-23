#include <iostream>
using namespace std;
int main(){
    int n;
    cout<<"Enter limit of array :"; cin>>n; int arr[n];
    for(int i=0;i<n;i++){
        arr[i]=i;
        cout<<(arr[i])*i<<" ";
    }
    return 0;
}