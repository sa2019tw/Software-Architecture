#include "add_class.h"
#include "../usecase/add_class_usecase.h"

using namespace std;

int function_AddSelectCheckClassName(const string& sName){
    return AddSelectCheckClassName(sName);
}

void function_AddClass(const string& sName, const string& sDescription, const string& sTarget, const string& sPrice, const string& sAttention, const string& sNote){
    AddClass(sName, sDescription, sTarget, sPrice, sAttention, sNote);
}
