#ifndef COURSE_H
#define COURSE_H

#include <vector>
#include <string>
#include <iostream>
using namespace std;

class Course{
public:
    /*Course(string className,string classDetail,string forWho,
           int price,string attention,string note)
        : _className(className),_classDetail(classDetail),_forWho(forWho),
        _price(price),_attention(attention),_note(note){}*/

    Course(){}

    Course(vector<string> input){
        _courseData.push_back(input);
    }

//    Course(vector<vector<string>> courseData){}

    void createCourse(vector<string> input){
        _courseData.push_back(input);
    }

    void deleteCourse(int id){
        int index = id - 1;
        _courseData.erase(_courseData.begin()+index);
    }

    void editCourse(int id,int field,string editStr){
        int idIndex = id - 1;
        int fieldIndex = field - 1;
        _courseData[idIndex][fieldIndex] = editStr;
    }

    vector<string> showAllCourse(){
        vector<string> allCourseName;

        vector<vector<string>>::iterator itData;
        vector<string>::iterator it;
        for(itData = _courseData.begin();itData != _courseData.end();++itData){
//            for(it = (*itData).begin();it != (*itData).end();++it){
//                cout<<"it = "<<(*it)<<endl;
//            }
            allCourseName.push_back((*itData)[0]);
        }
        return allCourseName;
    }

    vector<vector<string>> getAllCourse(){
        return _courseData;
    }

    void setAllCourse(vector<vector<string>> vecData){
        _courseData.assign(vecData.begin(),vecData.end());
    }

    int numberOfCourse(){
        return _courseData.size();
    }

    void setClassName(int id,string str){
        _courseData[id-1][0] = str;
    }
    void setClassDetail(int id,string str){
        _courseData[id-1][1] = str;
    }
    void setForWho(int id,string str){
        _courseData[id-1][2] = str;
    }
    void setPrice(int id,int p){
        _courseData[id-1][3] = std::to_string(p);
    }
    void setAttention(int id,string str){
        _courseData[id-1][4] = str;
    }
    void setNote(int id,string str){
        _courseData[id-1][5] = str;
    }

    string getClassName(int id){
        return _courseData[id-1][0];
    }
    string getClassDetail(int id){
        return _courseData[id-1][1];
    }
    string getForWho(int id){
        return _courseData[id-1][2];
    }
    int getPrice(int id){
        std::string::size_type sz;
        return std::stoi(_courseData[id-1][3],&sz);
    }
    string getAttention(int id){
        return _courseData[id-1][4];
    }
    string getNote(int id){
        return _courseData[id-1][5];
    }



private:
    string _className = "";
    string _classDetail = "";
    string _forWho = "";
    int _price = 0;
    string _attention = "";
    string _note = "";
//    int _id = 0;

    vector<vector<string>> _courseData;
};

#endif // COURSE_H
