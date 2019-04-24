#ifndef DATA_ACCESS_INTERFACE_H
#define DATA_ACCESS_INTERFACE_H

#include <vector>
#include <string>
using namespace std;

class DataAccessInterface{
public:
    DataAccessInterface(){}
    virtual bool createCourse(vector<string> input) = 0;
    virtual int getNumberOfCourse() = 0;
    virtual bool deleteCourse(int id) = 0;
    virtual bool editCourse(int id,int field,string editStr) = 0;
    virtual vector<string> showAllCourse() = 0;
    virtual void setAllCourse(vector<vector<string>> vecData) = 0;
    virtual vector<vector<string>> getAllCourse() = 0;
    virtual void clearDatabase() = 0;
};

#endif // DATA_ACCESS_INTERFACE_H
