/*Task # 17 Write three C++ statements using cout, <<, and endl: 

(a)	one that defines three variables length, width, and area on one line.

(b) another that takes values for length and width variables
 from the user at runtime 
(c) another that calculates and outputs the area. (Area=length * width)
*/
#include <iostream>
using namespace std;
int main()
{
    float x,y,z; cout<<"Enter length : "; cin>>x; cout<<"Enter width : "; cin>>y; z=x*y; 
    cout<<"The area which has "<<x<<" in length and "<<endl<<y<<" in width so area will be :" <<z<<" square feet";
    return 0;
}