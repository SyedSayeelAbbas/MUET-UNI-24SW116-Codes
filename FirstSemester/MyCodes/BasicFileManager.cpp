#include <iostream>
#include <string>
#include<conio.h>
#include <fstream>
#include <direct.h> // For _mkdir() (Windows) Ok
#include <sys/stat.h> // For mkdir() (Unix-like systems)Ok
#include <dirent.h> // For directory operations )Mid
#include <cstring> // for strerror()Nicely done

using namespace std;

void createDirectory(const string& directoryName) {
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
}

void createFile(const string& filePath, const string& content) {
    ofstream outfile(filePath);

    if (outfile.is_open()) {
        outfile << content << "\n";
        outfile.close();
        cout << "File created successfully!\n";
    } else {
        cerr << "Error creating/opening file: " << filePath << endl;
    }
}

void viewDirectoryContents(const string& directoryName) {
    DIR* dir = opendir(directoryName.c_str());

    if (dir == nullptr) {
        cerr << "Error: Could not open directory: " << directoryName << endl;
        return;
    }

    cout << "Contents of directory '" << directoryName << "':" << endl;

    struct dirent* entry;
    while ((entry = readdir(dir)) != nullptr) {
        cout << entry->d_name << endl; 
    }

    closedir(dir);
}

void viewFileContents(const string& filename) {
    ifstream infile(filename);
    if (infile.is_open()) {
        string line;
        cout << "Content of file " << filename << ":\n";
        while (getline(infile, line)) {
            cout << line << endl;
        }
        infile.close();
    } else {
        cerr << "Unable to open file: " << filename << endl;
    }
}

void copyFile(const string& sourceFile, const string& destinationFile) {
    ifstream src(sourceFile, ios::binary);
    ofstream dest(destinationFile, ios::binary);

    if (!src) {
        cerr << "Error: Could not open source file: " << sourceFile << endl;
        return;
    }

    if (!dest) {
        cerr << "Error: Could not open destination file: " << destinationFile << endl;
        src.close();
        return;
    }

    dest << src.rdbuf(); 

    src.close();
    dest.close();

    cout << "File copied successfully!" << endl;
}

void moveFile(const string& sourceFile, const string& destinationFile) {
    if (rename(sourceFile.c_str(), destinationFile.c_str()) != 0) {
        cerr << "Error: Could not move file: " << strerror(errno) << endl; 
        return;
    }

    cout << "File moved successfully!" << endl;
}

int main() {
    system("color 03");
    string command, argument1, argument2;

    while (true) {
        cout<<"\t\"Welcome--To--File--Manager\"\n\n";
        cout<<"1)Create_Directory\t\t2)Create_File\n\n3)View_Directory\t\t4)View_File\n\n5)Copy_file\t\t\t6)Move_file\n\n\t\t0)To-Exit\nChoose Here<-:";
        getline(cin, command);
        if (command == "0") {
            break;
        }

        if (command == "1") {
            cout << "Enter directory name: ";
            getline(cin, argument1);
            system("cls");
            createDirectory(argument1);
        } else if (command == "2") {
            cout << "Enter file path: ";
            getline(cin, argument1);
            cout << "Enter file content: ";
            getline(cin, argument2);
            system("cls");
            createFile(argument1, argument2);
        } else if (command == "3") {
            cout << "Enter directory name: ";
            getline(cin, argument1);
            system("cls");
            viewDirectoryContents(argument1);
        } else if (command == "4") {
            cout << "Enter file path: ";
            getline(cin, argument1);
            system("cls");
            viewFileContents(argument1);
        } else if (command == "5") {
            cout << "Enter source file path: ";
            getline(cin, argument1);
            cout << "Enter destination file path: ";
            getline(cin, argument2);
            system("cls");
            copyFile(argument1, argument2);
        } else if (command == "6") {
            cout << "Enter source file path: ";
            getline(cin, argument1);
            cout << "Enter destination file path: ";
            getline(cin, argument2);
            system("cls");
            moveFile(argument1, argument2);
        } else {
            cout << "Invalid command. Please enter a valid command." << endl;
        }
    }

    return 0;
}