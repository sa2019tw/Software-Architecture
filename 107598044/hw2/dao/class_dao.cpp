#include <stdio.h>
#include <stdlib.h>
#include <iostream>
#include <string.h>
#include <windows.h>
#include "class_dao.h"
#include "../db/db.h"

using namespace std;

static int UserResult(void *NotUsed, int argc, char **argv, char **azColName){ //search_class and delete_class(search one) and modify_class(search one)
    for(int i = 1 ; i < argc ; i++){
        printf("%26s", (argv[i] ? argv[i] : "NULL"));
    }
    cout << endl;
    return 0;
}

void SelectClassDao(){
    char* cErrMsg;
    int res = sqlite3_exec(pDB, "select * from class;", UserResult , 0 , &cErrMsg); //search_class
    if (res != SQLITE_OK){
        cout << "查詢失敗: " << cErrMsg << endl;
    }
    cout << endl;
}

static int UserResultCheckName(void *data, int argc, char **argv, char **azColName){ //add_class and delete_class and modify_class
    return 1;
}

int SelectCheckClassNameDao(const string& sName){ //check if class exists; add_class and delete_class and modify_class
    const char* data = "Callback function called";
    string strSql = "";

    strSql += "select name from class where name ='";
    strSql += sName;
    strSql += "';";

    char* cErrMsg;
    int res = sqlite3_exec(pDB, strSql.c_str(), UserResultCheckName , (void*)data, &cErrMsg);

    if (res != 0)
        return 1;
    else
        return 0;
}

void AddClassDao(const string& sName, const string& sDescription, const string& sTarget, const string& sPrice, const string& sAttention, const string& sNote){ //add_class
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
    int nRes = sqlite3_exec(pDB , strSql.c_str(), 0, 0, &cErrMsg);
    if (nRes != SQLITE_OK){
        SetTextToRed();
        cout << "新增課程《" << sName.c_str() << "》失敗: " << cErrMsg << endl << endl;
        SetTextToNormal();
    }
    else{
        SetTextToGreen();
        cout <<"新增課程《" << sName.c_str() << "》成功！" << endl << endl;
        SetTextToNormal();
    }
}

static int UserResultName(void *NotUsed, int argc, char **argv, char **azColName){ //delete_class and modify_class
    for(int i = 0 ; i < argc ; i++){
        printf("《%s》", (argv[i] ? argv[i] : "NULL"));
    }
    return 0;
}

void SelectClassNameDao(){ //delete_class and modify_class
    char* cErrMsg;
    int res = sqlite3_exec(pDB, "select name from class;", UserResultName , 0 , &cErrMsg);
    if (res != SQLITE_OK){
        cout<<"查詢失敗: "<<cErrMsg<<endl;
    }
    cout << endl;
}

void SelectClassOneDao(const string& sName){ //delete_class and modify_class
    char* cErrMsg;
    string strSql = "";
    strSql += "select * from class where name ='";
    strSql += sName;
    strSql += "';";

    int res = sqlite3_exec(pDB, strSql.c_str(), UserResult , 0 , &cErrMsg);

    if (res != SQLITE_OK){
        cout << "查詢失敗: " << cErrMsg << endl;
    }
    cout << endl;
}

void DeleteClassDao(const string& sName){ //delete_class
    string strSql = "";
    strSql += "delete from class where name='";
    strSql += sName;
    strSql += "';";

    char* cErrMsg;
    int nRes = sqlite3_exec(pDB , strSql.c_str(), 0, 0, &cErrMsg);
    if (nRes != SQLITE_OK){
        SetTextToRed();
        cout << "刪除課程《" << sName.c_str() << "》失敗: " << cErrMsg << endl << endl;
        SetTextToNormal();
    }
    else{
        SetTextToGreen();
        cout <<"刪除課程《" << sName.c_str() << "》成功！" << endl << endl;
        SetTextToNormal();
    }
}

void ModifyClassNameDao(const string& sName, const string& sNewName){ //modify_class
    string strSql = "";

    strSql += "update class set name ='";
    strSql += sNewName;
    strSql += "' where name='";
    strSql += sName;
    strSql += "';";

    char* cErrMsg;
    int nRes = sqlite3_exec(pDB , strSql.c_str(), 0, 0, &cErrMsg);
    if (nRes != SQLITE_OK){
        SetTextToRed();
        cout << "修改課程《" << sName.c_str() << "》名稱失敗: " << cErrMsg << endl << endl;
        SetTextToNormal();
    }
    else{
        SetTextToGreen();
        cout <<"修改成功！已將課程《" << sName.c_str() << "》名稱修改為: " << sNewName.c_str() << endl << endl;
        SetTextToNormal();
    }
}

void ModifyClassDescriptionDao(const string& sName, const string& sNewDescription){ //modify_class
    string strSql = "";

    strSql += "update class set description ='";
    strSql += sNewDescription;
    strSql += "' where name='";
    strSql += sName;
    strSql += "';";

    char* cErrMsg;
    int nRes = sqlite3_exec(pDB , strSql.c_str() ,0 ,0, &cErrMsg);
    if (nRes != SQLITE_OK){
        SetTextToRed();
        cout << "修改課程《" << sName.c_str() << "》說明失敗: " << cErrMsg << endl << endl;
        SetTextToNormal();
    }
    else{
        SetTextToGreen();
        cout <<"修改成功！已將課程《" << sName.c_str() << "》說明修改為: " << sNewDescription.c_str() << endl << endl;
        SetTextToNormal();
    }
}

void ModifyClassTargetDao(const string& sName, const string& sNewTarget){ //modify_class
    string strSql = "";

    strSql += "update class set target ='";
    strSql += sNewTarget;
    strSql += "' where name='";
    strSql += sName;
    strSql += "';";

    char* cErrMsg;
    int nRes = sqlite3_exec(pDB , strSql.c_str() ,0 ,0, &cErrMsg);
    if (nRes != SQLITE_OK){
        SetTextToRed();
        cout << "修改課程《" << sName.c_str() << "》適用對象失敗: " << cErrMsg << endl << endl;
        SetTextToNormal();
    }
    else{
        SetTextToGreen();
        cout <<"修改成功！已將課程《" << sName.c_str() << "》適用對象修改為: " << sNewTarget.c_str() << endl << endl;
        SetTextToNormal();
    }
}

void ModifyClassPriceDao(const string& sName, const string& sNewPrice){ //modify_class
    string strSql = "";

    strSql += "update class set price =";
    strSql += sNewPrice;
    strSql += " where name='";
    strSql += sName;
    strSql += "';";

    char* cErrMsg;
    int nRes = sqlite3_exec(pDB , strSql.c_str() ,0 ,0, &cErrMsg);
    if (nRes != SQLITE_OK){
        SetTextToRed();
        cout << "修改課程《" << sName.c_str() << "》定價失敗: " << cErrMsg << endl << endl;
        SetTextToNormal();
    }
    else{
        SetTextToGreen();
        cout <<"修改成功！已將課程《" << sName.c_str() << "》定價修改為: " << sNewPrice.c_str() << endl << endl;
        SetTextToNormal();
    }
}

void ModifyClassAttentionDao(const string& sName, const string& sNewAttention){ //modify_class
    string strSql = "";

    strSql += "update class set attention ='";
    strSql += sNewAttention;
    strSql += "' where name='";
    strSql += sName;
    strSql += "';";

    char* cErrMsg;
    int nRes = sqlite3_exec(pDB , strSql.c_str() ,0 ,0, &cErrMsg);
    if (nRes != SQLITE_OK){
        SetTextToRed();
        cout << "修改課程《" << sName.c_str() << "》注意事項失敗: " << cErrMsg << endl << endl;
        SetTextToNormal();
    }
    else{
        SetTextToGreen();
        cout <<"修改成功！已將課程《" << sName.c_str() << "》注意事項修改為: " << sNewAttention.c_str() << endl << endl;
        SetTextToNormal();
    }
}

void ModifyClassNoteDao(const string& sName, const string& sNewNote){ //modify_class
    string strSql = "";

    strSql += "update class set note ='";
    strSql += sNewNote;
    strSql += "' where name='";
    strSql += sName;
    strSql += "';";

    char* cErrMsg;
    int nRes = sqlite3_exec(pDB , strSql.c_str() ,0 ,0, &cErrMsg);
    if (nRes != SQLITE_OK){
        SetTextToRed();
        cout << "修改課程《" << sName.c_str() << "》備註失敗: " << cErrMsg << endl << endl;
        SetTextToNormal();
    }
    else{
        SetTextToGreen();
        cout <<"修改成功！已將課程《" << sName.c_str() << "》備註修改為: " << sNewNote.c_str() << endl << endl;
        SetTextToNormal();
    }
}
