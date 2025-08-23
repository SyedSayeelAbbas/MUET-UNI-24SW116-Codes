#include <iostream>
using namespace std;
int main()
{
    int cost,profit,sell;
    cout<<"Enter your cost of the item : "; cin>>cost;
    cout<<"Enter your selling price from the item : "; cin>>sell;
    profit=sell-cost;
    if(sell>cost){ 
        cout<<"you made a profit "<<endl;
    }
    else if(sell<cost){ 
        cout<<"you made a loss "<<endl;
    }
    else if(sell==cost){ 
        cout<<"you did not made profit or loss "<<endl;
    }
    else cout<<"Something is wrong with the programe\ncheck your code";
    cout<<"Total profit you made is :"<<profit;
    cout<<"\n\tEND PROGRAM ";
}