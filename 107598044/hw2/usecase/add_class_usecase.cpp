#include <stdio.h>
#include <stdlib.h>
#include <iostream>
#include <string.h>
#include <windows.h>
#include "add_class_usecase.h"
#include "../db/db.h"

using namespace std;

void AddClass(const string& sName, const string& sDescription, const string& sTarget, const string& sPrice, const string& sAttention, const string& sNote){
    string strSql = "";

    strSql += "insert into class(name, description, target, price, attention, note)";
    strSql += "values('";
    strSql += sName;
    strSql += "','";
    strSql += sDescription;
    strSql += "','";
    strSql += sTarget;
    strSql += "',";
    strSql += sPrice;
    strSql += ",'";
    strSql += sAttention;
    strSql += "','";
    strSql += sNote;
    strSql += "');";

    char* cErrMsg;
    int nRes = sqlite3_exec(pDB , strSql.c_str() ,0 ,0, &cErrMsg);
    if (nRes != SQLITE_OK){
        SetTextToRed();
        printf("新增課程失敗\: %s\n", cErrMsg);
        SetTextToNormal();
        //return false;
    }
    else{
        SetTextToGreen();
        printf("新增《%s》課程成功\\n\n", sName.c_str());
        SetTextToNormal();
    }

    //return true;
}
