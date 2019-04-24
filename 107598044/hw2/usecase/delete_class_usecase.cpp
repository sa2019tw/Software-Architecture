#include "delete_class_usecase.h"
#include "../dao/class_dao.h"

using namespace std;

void DelSelectClassName(){
    SelectClassNameDao();
}

int DelSelectCheckClassName(const string& sName){
    return SelectCheckClassNameDao(sName);
}

void DeleteClass(const string& sName){
    DeleteClassDao(sName);
}

void DelSelectClassOne(const string& sName){
    SelectClassOneDao(sName);
}





