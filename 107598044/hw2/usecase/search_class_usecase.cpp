#include <stdio.h>
#include <stdlib.h>
#include <iostream>
#include <string.h>
#include <windows.h>
#include "search_class_usecase.h"
#include "../db/db.h"

int check_class_exist = 0;
using namespace std;

static int UserResult(void *NotUsed, int argc, char **argv, char **azColName){ //list class (for delete_class and modify_class)
    for(int i = 1 ; i < argc ; i++){
        //cout<<azColName[i]<<" = "<<(argv[i] ? argv[i] : "NULL")<<", ";
        printf("%26s", (argv[i] ? argv[i] : "NULL"));
    }

    printf("\n");

    return 0;
}

void SelectClass(){ //search all class (for search_class)
    char* cErrMsg;

    printf("\n[        課程名稱        ][        課程說明        ][        課程對象        ][        課程定價        ][        注意事項        ][        課程備註        ]\n");
    printf(" ------------------------  ------------------------  ------------------------  ------------------------  ------------------------  ------------------------ \n");

    int res = sqlite3_exec(pDB, "select * from class;", UserResult , 0 , &cErrMsg);

    if (res != SQLITE_OK){
        cout<<"select fail: "<<cErrMsg<<endl;
        //return false;
    }
    printf("\n");
    //return true;
}

static int UserResultCheckName(void *data, int argc, char **argv, char **azColName){ //if class exists, "check_class_exist" return 1 (for add_class)
    check_class_exist = 1;
    return 0;
}

void SelectCheckClassName(const string& sName){ // check if the class name created before (for add_class)
    check_class_exist = 0;
    const char* data = "Callback function called";
    string strSql = "";

    strSql += "select name from class where name ='";
    strSql += sName;
    strSql += "';";

    char* cErrMsg;
    int res = sqlite3_exec(pDB, strSql.c_str(), UserResultCheckName , (void*)data, &cErrMsg);

    if (res != SQLITE_OK){
        cout<<"select fail: "<<cErrMsg<<endl;
        //return false;
    }
}

static int UserResultName(void *NotUsed, int argc, char **argv, char **azColName){ //list all class only name (for delete_class)
    for(int i = 0 ; i < argc ; i++){
        printf("《%s》", (argv[i] ? argv[i] : "NULL"));
    }
    return 0;
}

void SelectClassName(){ //search all class only name (for delete_class)
    char* cErrMsg;
    printf("目前的課程有: ");
    int res = sqlite3_exec(pDB, "select name from class;", UserResultName , 0 , &cErrMsg);

    if (res != SQLITE_OK){
        cout<<"select fail: "<<cErrMsg<<endl;
        //return false;
    }
    printf("\n");
    //return true;
}

void SelectClassOne(const string& sName){ //search one class (for delete_class and modify_class)
    char* cErrMsg;
    string strSql = "";
    printf("\n[        課程名稱        ][        課程說明        ][        課程對象        ][        課程定價        ][        注意事項        ][        課程備註        ]\n");
    printf(" ------------------------  ------------------------  ------------------------  ------------------------  ------------------------  ------------------------ \n");
    strSql += "select * from class where name ='";
    strSql += sName;
    strSql += "';";

    int res = sqlite3_exec(pDB, strSql.c_str(), UserResult , 0 , &cErrMsg);

    if (res != SQLITE_OK){
        cout<<"select fail: "<<cErrMsg<<endl;
        //return false;
    }
    printf("\n");
    //return true;
}
