#include "add_class_usecase.h"
#include "../dao/class_dao.h"

using namespace std;

int AddSelectCheckClassName(const string& sName){
    return SelectCheckClassNameDao(sName);
}

void AddClass(const string& sName, const string& sDescription, const string& sTarget, const string& sPrice, const string& sAttention, const string& sNote){
    AddClassDao(sName, sDescription, sTarget, sPrice, sAttention, sNote);
}
