#ifndef MANAGE_COURSE_H
#define MANAGE_COURSE_H

#include "../data_access/data_access_interface.h"
#include "../entities/course.h"

#include <iostream>
#include <vector>
#include <string>
using namespace std;

class ManageCourse{
public:
    ManageCourse(DataAccessInterface *dao):_dao(dao){}

    void createCourse(vector<string> input,bool &outputResult){
        course.createCourse(input);
        outputResult = _dao->createCourse(input);
    }


    /*
    void createCourse(string className,string classDetail,string forWho,
                      int price,string attention,string note,bool &outputResult){

        vector<string> input;
        input.push_back(className);
        input.push_back(classDetail);
        input.push_back(forWho);
        input.push_back(std::to_string(price));
        input.push_back(attention);
        input.push_back(note);
        outputResult = _dao->createCourse(input);

    }*/

    void deleteCourse(int id,bool &deleteResult){
        course.deleteCourse(id);
        deleteResult = _dao->deleteCourse(id);
    }

    void editCourse(int id,int field,string editStr,bool &editResult){
        course.editCourse(id,field,editStr);
        editResult = _dao->editCourse(id,field,editStr);
    }

    vector<string> showAllCourse(){
        vector<string> allCourseName;
        allCourseName = course.showAllCourse();
        return allCourseName;
    }

    void setAllCourse(vector<vector<string>> vecData,bool &outputResult){
        course.setAllCourse(vecData);
        _dao->setAllCourse(vecData);
        if(_dao->getNumberOfCourse() == vecData.size())
            outputResult = true;
    }

    vector<vector<string>> getAllCourse(){
        vector<vector<string>> vecData;
        vecData = _dao->getAllCourse();
        return vecData;
    }

private:
    DataAccessInterface *_dao;
    Course course;
};

#endif // MANAGE_COURSE_H
