#ifndef DATA_ACCESS_TXT_H
#define DATA_ACCESS_TXT_H

#include "data_access_interface.h"

#include <iostream>
#include <fstream>
#include <stdlib.h>
#include <string.h>
#include <vector>
#include <string>
using namespace std;

#define FILE_PATH "data.txt"

class DataAccessTxt : public DataAccessInterface{
public:
    DataAccessTxt(){}
    bool createCourse(vector<string> input){
        bool outputResult = false;
        int pre,post;
        pre = fileInput(FILE_PATH).size();

        //create
        fileOutput(FILE_PATH,input);

        post = fileInput(FILE_PATH).size();
        if(post>pre)
            outputResult = true;
        return outputResult;
    }

    int getNumberOfCourse(){
        return fileInput(FILE_PATH).size();
    }

    bool deleteCourse(int id){
        bool outputResult = false;
        int pre,post;
        pre = fileInput(FILE_PATH).size();

        //delete
        int index = id - 1;
        vector<vector<string>> vecData;
        vecData = fileInput(FILE_PATH);
        vecData.erase(vecData.begin()+index);
        fileOutput(FILE_PATH,vecData);

        post = fileInput(FILE_PATH).size();
        if(post<pre)
            outputResult = true;
        return outputResult;
    }

    bool editCourse(int id,int field,string editStr){
        bool editResult = false;
        int idIndex = id - 1;
        int fieldIndex = field - 1;
        string pre,post;

        vector<vector<string>> vecData;
        vecData = fileInput(FILE_PATH);
        pre = vecData[idIndex][fieldIndex];
        vecData[idIndex][fieldIndex] = editStr;
        post = vecData[idIndex][fieldIndex];
        fileOutput(FILE_PATH,vecData);

        if(pre.compare(post) != 0)
            editResult = true;
        return editResult;
    }

    vector<string> showAllCourse(){
        vector<string> allCourseName;
        vector<vector<string>> vecData;
        vecData = fileInput(FILE_PATH);

        vector<vector<string>>::iterator itData;
        vector<string>::iterator it;
        for(itData = vecData.begin();itData != vecData.end();++itData){
            allCourseName.push_back((*itData)[0]);
        }
        return allCourseName;
    }

    void setAllCourse(vector<vector<string>> vecData){
        fileOutput(FILE_PATH,vecData);
    }

    vector<vector<string>> getAllCourse(){
        return fileInput(FILE_PATH);
    }

    void clearDatabase(){
        clearFile(FILE_PATH);
    }

private:
    vector<vector<string>> _courseData;

    vector<vector<string>> fileInput(string fileName){
        fstream f_input;
        f_input.open(fileName.c_str());
        vector<vector<string>> vecData;
        if( !f_input )
            cerr<<"Fail to open file(ex:input.txt)."<<endl;
        else{
            char ch[10000];
            while( f_input.getline(ch,5000) ){
                string str = string(ch);
                search(str,vecData);
            }
        }
        f_input.close();
        return vecData;
    }

    void fileOutput(string fileName, string saveData){
        fstream f_output;
        f_output.open(fileName.c_str(),fstream::out | fstream::trunc);
        if(!f_output)
            cerr<<"Fail to open file(ex:output.txt)."<<endl;
        else{
            f_output<<saveData;
        }
        f_output.close();
    }

    void fileOutput(string fileName, vector<string> inputData){
        string saveData = "";
        for(int i=0;i<6;i++){
            saveData += inputData[i] + "|@$#|";
        }
        saveData += "\n";

        fstream f_output;
        f_output.open(fileName.c_str(),fstream::out | fstream::app);
        if(!f_output)
            cerr<<"Fail to open file(ex:output.txt)."<<endl;
        else{
            f_output<<saveData;
        }
        f_output.close();
    }

    void fileOutput(string fileName, vector<vector<string>> inputData){
        string saveData = "";
        vector<vector<string>>::iterator itData;
        vector<string>::iterator it;
        for(itData = inputData.begin();itData != inputData.end();++itData){
            for(it = (*itData).begin();it != (*itData).end();++it){
                saveData += (*it) + "|@$#|";
            }
            saveData += "\n";
        }

        fstream f_output;
        f_output.open(fileName.c_str(),fstream::out | fstream::trunc);
        if(!f_output)
            cerr<<"Fail to open file(ex:output.txt)."<<endl;
        else{
            f_output<<saveData;
        }
        f_output.close();
    }

    void search(string str,vector<vector<string>> &vecData){
        vector<int> position;
        position.push_back(0);
        size_t found = str.find("|@$#|");
        position.push_back(static_cast<int>(found-1));
        if (found!=string::npos){
            for(int i=0;i<5;i++){
                position.push_back( static_cast<int>(found+5) );
                found = str.find("|@$#|",found+5);
                if (found!=string::npos){
                    position.push_back( static_cast<int>(found-1) );
                }
                else{
                    break;
                }
            }
        }

        vector<string> vecContent;
        for(int i=0;i<12;i=i+2){
            vecContent.push_back( str.substr(position[i],position[i+1]-position[i]+1) );
        }
        vecData.push_back(vecContent);
    }

    void clearFile(string fileName){
        fstream f_output;
        f_output.open(fileName.c_str(),fstream::out | fstream::trunc);
        if(!f_output)
            cerr<<"Fail to open file(ex:output.txt)."<<endl;
        else{
            //f_output<<saveData;
        }
        f_output.close();
    }


};

#endif // DATA_ACCESS_TXT_H
