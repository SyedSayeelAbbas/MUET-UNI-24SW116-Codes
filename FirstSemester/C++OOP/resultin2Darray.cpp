#include <iostream>
using namespace std;
int main(){
    int result[3][2]={116,98,119,96,101,89};
    cout<<"Name\tRoll No\tMarks\nSayeel\t"<<result[0][0]<<"\t"<<result[0][1]<<endl;
    cout<<"Salar\t"<<result[1][0]<<"\t"<<result[1][1]<<endl;
    cout<<"Haroon\t"<<result[2][0]<<"\t"<<result[2][1];
    return 0;
}