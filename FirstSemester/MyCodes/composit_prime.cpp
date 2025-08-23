#include <iostream>
using namespace std;
int main()
{   int n; 
    cout<<"Enter the value :"; 
    cin>>n;
    if(n<2) cout<<n<<" is not a prime number"<<endl;
    else if(n==2) cout<<n<<" is a prime number"<<endl;
    else if(n%2==0) cout<<n<<" not a prime number"<<endl;
    else if(n%2!=0){
        if((n % 11 == 0 && n != 11) ||(n % 3 == 0 && n != 3) || (n % 5 == 0 && n != 5) || (n % 7 == 0 && n != 7)){
            cout<<n<<" not a prime number"<<endl;
        }
        else cout<<n<<" is a prime number"<<endl;
        
    }
    else cout<<"somethings wrong";
    return 0;
}
    // if(n==1) cout<<n<<" is neither Prime number \nand nor Composite number";
    // else if(x==true) cout<<n<<" is Prime number";
    // else cout<<n<<" is Composite number";
    // return 0;
