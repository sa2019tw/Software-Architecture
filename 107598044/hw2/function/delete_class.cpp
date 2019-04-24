#include "delete_class.h"
#include "../usecase/delete_class_usecase.h"

using namespace std;

void function_DelSelectClassName(){
    DelSelectClassName();
}

int function_DelSelectCheckClassName(const string& sName){
    return DelSelectCheckClassName(sName);
}

void function_DeleteClass(const string& sName){
    DeleteClass(sName);
}

void function_DelSelectClassOne(const string& sName){
    DelSelectClassOne(sName);
}
