#include <iostream>
using namespace std;
int main(){
    int arr[2][3];
    for(int i=0;i<2;i++){
        for(int j=0;j<3;j++){
            cout<<"Enter value of "<<i<<"th row \nand "<<j<<"th column :";
            cin>>arr[i][j]; cout<<endl;
        }
    }
    system("cls");
    for(int i=0;i<2;i++){
        for(int j=0;j<3;j++){
            cout<<arr[i][j]<<" ";
        }
        cout<<endl;
    }
    return 0;
}
