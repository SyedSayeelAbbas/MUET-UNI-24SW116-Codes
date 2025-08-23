#include <iostream>
using namespace std;
class person{
public:
    string name;
    int age;
    // person(string name,int age){
    //     this->name=name;
    //     this->age=age;
    // }
    person(){
        cout<<"This is a parent class";
    }
    ~person(){
        cout<<"This is a parent class destructor";
    }
};
class student :public person{
public:
    int rollno;
    student(){
        cout<<"This is a student class";
    }
    ~student(){
        cout<<"This is a student class destructor";
    }
    void show(){
        cout<<"name :"<<name<<endl;
        cout<<"age :"<<age<<endl;
        cout<<"rollno :"<<rollno<<endl;
    }
};
int main(){
    student s1;
    s1.name="silly";
    s1.age=18;
    s1.rollno=116;
    s1.show();
}