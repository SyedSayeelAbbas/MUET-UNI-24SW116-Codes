#include <iostream>
using namespace std;
int main(){
    int arrA[2][2]={{2,3},{4,5}},arrB[2][2]={{2,5},{5,7}},arrC[2][2];
    for(int i=0;i<2;i++){
        for(int j=0;j<2;j++){
            arrC[i][j]=(arrA[i][j]+arrB[i][j]);
        }
    }
    for(int k=0;k<2;k++){
        for(int z=0;z<2;z++){
            cout<<arrC[k][z]<<"  ";
        }
        cout<<endl;
    }
    return 0;
}