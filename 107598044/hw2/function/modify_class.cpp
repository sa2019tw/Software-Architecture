#include "modify_class.h"
#include "../usecase/modify_class_usecase.h"

using namespace std;

void function_ModifySelectClassName(){
    ModifySelectClassName();
}

int function_ModifySelectCheckClassName(const string& sName){
    return ModifySelectCheckClassName(sName);
}

void function_ModifySelectClassOne(const string& sName){
    ModifySelectClassOne(sName);
}

void function_ModifyClassName(const string& sName, const string& sNewName){
    ModifyClassName(sName, sNewName);
}

void function_ModifyClassDescription(const string& sName, const string& sNewDescription){
    ModifyClassDescription(sName, sNewDescription);
}

void function_ModifyClassTarget(const string& sName, const string& sNewTarget){
    ModifyClassTarget(sName, sNewTarget);
}

void function_ModifyClassPrice(const string& sName, const string& sNewPrice){
    ModifyClassPrice(sName, sNewPrice);
}

void function_ModifyClassAttention(const string& sName, const string& sNewAttention){
    ModifyClassAttention(sName, sNewAttention);
}

void function_ModifyClassNote(const string& sName, const string& sNewNote){
    ModifyClassNote(sName, sNewNote);
}
