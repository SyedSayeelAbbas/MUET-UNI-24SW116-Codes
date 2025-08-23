#include <iostream>
using namespace std;
int main()
{   int p,e;
    cout<<"Enter the number for its table:"<<endl; cout<<"Enter:"; cin>>e;
    cout<<"Enter the range of your table:"<<endl; cout<<"Enter:"; cin>>p;
    for(int i=1;i<=p;i++){
        cout<<(e)<<"x"<<(i)<<"="<<e*i<<endl;
    }
    return 0;
}