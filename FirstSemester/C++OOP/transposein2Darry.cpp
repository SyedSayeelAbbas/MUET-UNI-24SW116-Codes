#include <iostream>
using namespace std;
 int main(){
    int arr[2][3]={{2,3,6},{4,5,7}};
    cout<<"Before transpose \n\t\t|\n\t\tV"<<endl;
    for(int i=0;i<2;i++){
        for(int j=0;j<3;j++){
            cout<<"\t"<<arr[i][j]<<" ";
        }
        cout<<endl;
    }
    cout<<"After transpose \n\t\t|\n\t\tV"<<endl;
    for(int i=0;i<3;i++){
        for(int j=0;j<2;j++){
            cout<<"\t"<<arr[j][i]<<" ";
        }
        cout<<endl;
    }
    return 0;
 }