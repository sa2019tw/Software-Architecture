#ifndef DATA_ACCESS_INMEMORY_H
#define DATA_ACCESS_INMEMORY_H

#include "data_access_interface.h"

#include <vector>
#include <string>
using namespace std;

class DataAccessInMemory : public DataAccessInterface{
public:
    DataAccessInMemory(){}
    bool createCourse(vector<string> input){
        bool outputResult = false;
        int pre,post;
        pre = _courseData.size();

        //create
        _courseData.push_back(input);

        post = _courseData.size();
        if(post>pre)
            outputResult = true;
        return outputResult;
    }

    int getNumberOfCourse(){
        return _courseData.size();
    }

    bool deleteCourse(int id){
        bool outputResult = false;
        int pre,post;
        pre = _courseData.size();

        //delete
        int index = id - 1;
        _courseData.erase(_courseData.begin()+index);

        post = _courseData.size();
        if(post<pre)
            outputResult = true;
        return outputResult;
    }

    bool editCourse(int id,int field,string editStr){
        bool editResult = false;
        int idIndex = id - 1;
        int fieldIndex = field - 1;
        string pre,post;
        pre = _courseData[idIndex][fieldIndex];

        _courseData[idIndex][fieldIndex] = editStr;

        post = _courseData[idIndex][fieldIndex];

        if(pre.compare(post) != 0)
            editResult = true;
        return editResult;
    }

    vector<string> showAllCourse(){
        vector<string> allCourseName;

        vector<vector<string>>::iterator itData;
        vector<string>::iterator it;
        for(itData = _courseData.begin();itData != _courseData.end();++itData){
            allCourseName.push_back((*itData)[0]);
        }
        return allCourseName;
    }

    void setAllCourse(vector<vector<string>> vecData){
        _courseData.assign(vecData.begin(),vecData.end());
    }

    vector<vector<string>> getAllCourse(){
        return _courseData;
    }

    void clearDatabase(){
        _courseData.clear();
    }

private:
    vector<vector<string>> _courseData;
};

#endif // DATA_ACCESS_INMEMORY_H
