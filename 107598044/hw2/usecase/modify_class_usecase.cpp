#include <stdio.h>
#include <stdlib.h>
#include <iostream>
#include <string.h>
#include <windows.h>
#include "modify_class_usecase.h"
#include "../dao/class_dao.h"

using namespace std;

void ModifySelectClassName(){
    SelectClassNameDao();
}

int ModifySelectCheckClassName(const string& sName){
    return SelectCheckClassNameDao(sName);
}

void ModifySelectClassOne(const string& sName){
    SelectClassOneDao(sName);
}

void ModifyClassName(const string& sName, const string& sNewName){
    ModifyClassNameDao(sName, sNewName);
}

void ModifyClassDescription(const string& sName, const string& sNewDescription){
    ModifyClassDescriptionDao(sName, sNewDescription);
}

void ModifyClassTarget(const string& sName, const string& sNewTarget){
    ModifyClassTargetDao(sName, sNewTarget);
}

void ModifyClassPrice(const string& sName, const string& sNewPrice){
    ModifyClassPriceDao(sName, sNewPrice);
}

void ModifyClassAttention(const string& sName, const string& sNewAttention){
    ModifyClassAttentionDao(sName, sNewAttention);
}

void ModifyClassNote(const string& sName, const string& sNewNote){
    ModifyClassNoteDao(sName, sNewNote);
}

