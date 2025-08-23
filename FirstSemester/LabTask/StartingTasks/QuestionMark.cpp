#include <iostream>
using namespace std;
int main() {
    int x, y, z;

    // Prompt the user for input
    cout << "Enter three numbers separated by ??" <<endl;
    cin >> x;
    cin.ignore(2, '?'); // Ignore "??"
    cin >> y;
    cin.ignore(2, '?'); // Ignore "??"
    cin >> z;

    // Print the integers without "??"
    cout << x << y << z << endl;

    return 0;
}
