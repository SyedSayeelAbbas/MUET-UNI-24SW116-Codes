#include <iostream>
using namespace std;
int main()
{
    int arr[5]={85687,34,5,5,3},n;
    cout<<"Enter the greater limit for array :";
    cin>>n;
    for(int i=0;i<5;i++){
        if(arr[i]>n){
            cout<<arr[i]<<" ";
        }
   }
   return 0;
}