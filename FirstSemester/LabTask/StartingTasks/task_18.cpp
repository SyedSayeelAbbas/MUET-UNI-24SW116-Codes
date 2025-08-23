/*Task # 6 Create a .cpp file with name variables.cpp and 
write the programming statements for the following:
 
•	Create a variable without assigning the value,
 and assign it the value in later statement.

•	Assign a new value to an existing value 
(this will overwrite the previous value)

•	Create an unchangeable variable with 
    the const keyword

•	Demonstrate the use of # define directive 

•	Combine text and a variable on output  (console window)

•	Add a variable to another variable

•	Declare many variables of the same type 
    with a comma-separated list Identifiers 

•	Define and Initialize two string variables of your 
    own choice and concatenate both strings and display the final value. 

•	With suitable programming example explain the concept 
    of signed and unsigned variables. (Use comments for explanation)
*/
#include<iostream>
using namespace std;
int main() {
    float num=30.33;
    int in=num;//it  work for type casting
    cout<<in;
}