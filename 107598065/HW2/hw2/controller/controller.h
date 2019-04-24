#ifndef CONTROLLER_H
#define CONTROLLER_H

#include "./usecases/manage_course.h"
#include "./data_access/data_access_interface.h"
#include "./data_access/data_access_inmemory.h"
#include "./data_access/data_access_txt.h"

#include <QTableWidgetItem>
#include <QStringList>
#include <QString>
#include <vector>
#include <map>
#include <string>
#include <iostream>
using namespace std;

class Controller{
public:

    QStringList iniTable_headerText(){
        QStringList headerText;
        headerText<<"課程名稱"<<"課程說明"<<"適合對象"<<"定價"<<"注意事項"<<"備註";
        return headerText;
    }

    vector<map<int,QTableWidgetItem *>> getMapItem(){
        vector<vector<string>> vecData = manageCourse->getAllCourse();
        bool setAllCourseResult;
        manageCourse->setAllCourse(vecData,setAllCourseResult);
        vector<map<int,QTableWidgetItem *>> vectorOfMap;

        vector<vector<string>>::iterator itData;
        vector<string>::iterator it;
        int rowCount=0;
        for(itData = vecData.begin();itData != vecData.end();++itData){
            for(int i=0;i<6;i++){
                if((*itData)[i].compare(" ") == 0)
                    (*itData)[i] = "";
            }
            QString strClassName = QString(QString::fromLocal8Bit((*itData)[0].c_str()));
            QString strClassDetail = QString(QString::fromLocal8Bit((*itData)[1].c_str()));
            QString strForWho = QString(QString::fromLocal8Bit((*itData)[2].c_str()));
            QString strPrice = QString(QString::fromLocal8Bit((*itData)[3].c_str()));
            QString strAttention = QString(QString::fromLocal8Bit((*itData)[4].c_str()));
            QString strNote = QString(QString::fromLocal8Bit((*itData)[5].c_str()));

            map<int,QTableWidgetItem *> mapItem;
            QString qstrArr[6] = {strClassName,strClassDetail,strForWho,strPrice,strAttention,strNote};
            QTableWidgetItem * item;
            for(int i=0;i<6;i++){
                item = new QTableWidgetItem(qstrArr[i],i);
                mapItem[i] = item;
            }
            vectorOfMap.push_back(mapItem);
            rowCount++;
        }
        return vectorOfMap;
    }

    void closeEvent(vector<vector<QString>> vecDataQStr){
        vector<vector<string>> vecData;

        vector<vector<QString>>::iterator itData;
        vector<QString>::iterator it;
        for(itData = vecDataQStr.begin();itData != vecDataQStr.end();++itData){
            vector<string> vecDataLine;
            for(it = (*itData).begin();it != (*itData).end();++it){
                if((*it).length() == 0)
                    vecDataLine.push_back(" ");
                else
                    vecDataLine.push_back( string((const char *)(*it).toLocal8Bit()) );
            }
            vecData.push_back(vecDataLine);
        }

        bool outputResult = false;
        manageCourse->setAllCourse(vecData,outputResult);
    }

    QString showAllCourse(){
        QString allCourse;
        vector<string> vecAllCourse;
        vecAllCourse = manageCourse->showAllCourse();
        vector<string>::iterator it;
        for(it = vecAllCourse.begin();it != vecAllCourse.end();it++){
            allCourse += QString(QString::fromLocal8Bit((*it).c_str())) + "\n";
        }
        return allCourse;
    }

    void editCourse(int id,QString originalArray[],QString qstrArray[]){
        bool editResult;
        for(int i=0;i<6;i++){
            if(qstrArray[i].compare(originalArray[i]) != 0){
                string str = string((const char *)qstrArray[i].toLocal8Bit());
                manageCourse->editCourse(id,i+1,str,editResult);
            }

        }
    }

    void createCourse(QString qstrArray[]){
        bool createResult;
        vector<string> vecOneCourse;
        for(int i=0;i<6;i++){
            vecOneCourse.push_back(string((const char *)qstrArray[i].toLocal8Bit()));
        }
        manageCourse->createCourse(vecOneCourse,createResult);
    }

    void deleteCoures(int id){
        bool deleteResult;
        manageCourse->deleteCourse(id,deleteResult);
    }

private:
    DataAccessInterface *dao = new DataAccessTxt();
    //DataAccessInterface *dao = new DataAccessInMemory();
    ManageCourse *manageCourse = new ManageCourse(dao);

};

#endif // CONTROLLER_H
