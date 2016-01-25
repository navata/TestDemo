//============================================================================
// Name        : 123.cpp
// Author      : OK
// Version     :
// Copyright   : Your copyright notice
// Description : Hello World in C++, Ansi-style
//===========================================================================
#include<stdio.h>
#include <iostream>
#include <string>
#include <fstream>
#include <vector>
#include <string>

using namespace std;

//map<string, string> NUMBER_MAP;

	string readFile(string path) {
		string line;
		string data;
		fstream file;
		file.open(path, ios::in);
		if (file.is_open()) {
			while (!file.eof()) {
				getline(file, line);
				data += line + "\n";
			}
		}
		file.close();
		return data;
	}

	void writeFile(string data, string path) {
		fstream file;
		file.open(path + "/output.txt", ios::out);
		file << data;
		file.close();
	}

	void sortNumber() {

		string path;
		fstream file;
	//	cin.ignore();
		do {
			cout << "Please input path file:";
			getline(cin, path);
			file.open(path, ios::in);
		} while (!file.is_open());

		string data = readFile(path);
		path = path.substr(0, path.find_last_of("/\\"));
		cout << path << endl;
		writeFile(data, path);
	//	fflush(stdin);
	}

		string formatString(string input)
		{
			while(input[0] == ' '){
				input.erase(0,1);
			}
		//

			while(input[input.size()-1] == ' '){
				input.erase(input.size()-1,1);
			}

			for(int i = 0 ; i < input.size() - 1; i++){
				input[i] = tolower(input[i]);
				input[i+1] = tolower(input[i+1]);
				if(input[i] == ' ' && input[i+1] == ' '){
					input.erase(i,1);
					i--;
				}
			}

			return input;
		}

	//void defineNumberMap()
	//{
	//	NUMBER_MAP["zero"] = "0";
	//	NUMBER_MAP["one"] = "1";
	//	NUMBER_MAP["two"] = "2";
	//	NUMBER_MAP["three"] = "3";
	//	NUMBER_MAP["four"] = "4";
	//	NUMBER_MAP["five"] = "5";
	//	NUMBER_MAP["six"] = "6";
	//	NUMBER_MAP["seven"] = "7";
	//	NUMBER_MAP["eight"] = "8";
	//	NUMBER_MAP["nine"] = "9";
	//	NUMBER_MAP["ten"] = "10";
	//	NUMBER_MAP["eleven"] = "11";
	//	NUMBER_MAP["twelve"] = "12";
	//	NUMBER_MAP["thirteen"] = "13";
	//	NUMBER_MAP["fourteen"] = "14";
	//	NUMBER_MAP["fifteen"] = "15";
	//	NUMBER_MAP["sixteen"] = "16";
	//	NUMBER_MAP["seventeen"] = "17";
	//	NUMBER_MAP["eighteen"] = "18";
	//	NUMBER_MAP["nineteen"] = "19";
	//	NUMBER_MAP["twenty"] = "20";
	//	NUMBER_MAP["thirty"] = "30";
	//	NUMBER_MAP["forty"] = "40";
	//	NUMBER_MAP["fifty"] = "50";
	//	NUMBER_MAP["sixty"] = "60";
	//	NUMBER_MAP["seventy"] = "70";
	//	NUMBER_MAP["eighty"] = "80";
	//	NUMBER_MAP["ninety"] = "90";
	//	NUMBER_MAP["hundred"] = "100";
	//}

	int main()
	{
	//	sortNumber();
		cout << formatString("       -thAI-               -VAN-              -nguyen              ") + "-----";
		return 0;
	}
