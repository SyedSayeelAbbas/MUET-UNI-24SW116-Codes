#include <iostream>
#include <string>
#include <fstream>
#include <direct.h> // For _mkdir() (Windows)
#include <sys/stat.h> // For mkdir() (Unix-like systems)
#include <dirent.h> // For directory operations
#include <cstring> // for strerror()
using namespace std;

int main() {
    string directoryName, filename, write, viewFileName,viewDirectoryName;

    // Get directory name from user
    cout << "Enter directory name: ";
    getline(cin, directoryName);

    // Create the directory
#ifdef _WIN32
    if (_mkdir(directoryName.c_str()) == 0) {
        cout << "Directory '" << directoryName << "' created successfully!\n";
    } else {
        cerr << "Error creating directory: " << directoryName << endl;
    }
#else
    if (mkdir(directoryName.c_str(), 0777) == 0) {
        cout << "Directory '" << directoryName << "' created successfully!\n";
    } else {
        cerr << "Error creating directory: " << directoryName << endl;
    }
#endif

    // Get file name from user
    cout << "Enter file name with extension .txt: ";
    getline(cin, filename);

    // Construct the full file path
    string filePath = directoryName + "/" + filename; 

    ofstream outfile(filePath);

    if (outfile.is_open()) {
        outfile << "Welcome to the file " << filename << "\n";
        cout << "Enter the content for this file:\n";
        getline(cin, write);
        outfile << write << "\n";
        outfile.close();
        cout << "File '" << filename << "' created and written to successfully!\n";
    } else {
        cerr << "Error creating/opening file: " << filePath << endl;
    }

    // View directory contents
    cout << "Enter the directory name to view: ";
    getline(cin, viewDirectoryName);

    DIR* dir = opendir(viewDirectoryName.c_str());

    if (dir == nullptr) {
        cerr << "Error: Could not open directory: " << viewDirectoryName << endl;
        return 1; 
    }

    cout << "Contents of directory '" << viewDirectoryName << "':" << endl;

    struct dirent* entry;
    while ((entry = readdir(dir)) != nullptr) {
        cout << entry->d_name << endl; 
    }

    closedir(dir);

    // View file content
    cout << "Enter file name to view: ";
    getline(cin, viewFileName);

    ifstream infile(viewFileName);
    if (infile.is_open()) {
        string line;
        cout << "Content of file " << viewFileName << ":\n";
        while (getline(infile, line)) {
            cout << line << endl;
        }
        infile.close();
    } else {
        cerr << "Unable to open file: " << viewFileName << endl;
    }
    string sourceFile, destinationFile;
    char choice;

    cout << "Enter the source file path: ";
    getline(cin, sourceFile);

    cout << "Enter the destination file path: ";
    getline(cin, destinationFile);

    cout << "Do you want to copy (c) or move (m) the file? ";
    cin >> choice;
    cin.ignore(); // Clear the newline character from the input buffer

    if (tolower(choice) == 'c') {
        // Copy file
        ifstream src(sourceFile, ios::binary);
        ofstream dest(destinationFile, ios::binary);

        if (!src) {
            cerr << "Error: Could not open source file: " << sourceFile << endl;
            return 1;
        }

        if (!dest) {
            cerr << "Error: Could not open destination file: " << destinationFile << endl;
            src.close();
            return 1;
        }

        dest << src.rdbuf(); 

        src.close();
        dest.close();

        cout << "File copied successfully!" << endl;
    } else if (tolower(choice) == 'm') {
        // Move file (using rename)
        if (rename(sourceFile.c_str(), destinationFile.c_str()) != 0) {
            cerr << "Error: Could not move file: " << strerror(errno) << endl; 
            return 1;
        }
        cout << "File moved successfully!" << endl;
    } else {
        cerr << "Invalid choice. Please enter 'c' for copy or 'm' for move." << endl;
        return 1;
    }
    return 0;
}