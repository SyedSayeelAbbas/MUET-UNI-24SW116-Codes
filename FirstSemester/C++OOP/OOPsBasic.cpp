#include <iostream>
using namespace std;
class student
{
private:
    int marks;
public:
    string names;
    int roll;
    int age;
    void show(){
        cout<<names<<" "<<roll<<" "<<age<<" ";
    }
    void setter(int a){
        marks=a;
    }
    int getter(){
        return marks;
    }
};
int main(){
    student s1;
    s1.names="sayeel";
    s1.roll=12;
    s1.age=7;
    s1.show();
    s1.setter(5);
    cout<<s1.getter();
}
