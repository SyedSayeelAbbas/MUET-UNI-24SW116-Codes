#include <iostream>
using namespace std;
class account{
public:
    account(){
        cout<<"Hello, there";
    }
    account(double a){
        balance=a;
    }
    double balance;
    void show(){
        cout<<"balance :"<<balance;
    }
};
int main(){
    //account a1;
    account a1(3.4);
    a1.show();
}