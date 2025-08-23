#include <iostream>
using namespace std;

int main() {
    int arr[] = {10, 20, 30, 88, 58};
    int n = sizeof(arr) /4;//as integers has 4 memory

    int maxElement = arr[0];
    for (int i = 1; i < n; i++) {
        if (arr[i] > maxElement) {
            maxElement = arr[i];
        }
    }

    cout << "Maximum element is: " << maxElement << endl;
    return 0;
}
