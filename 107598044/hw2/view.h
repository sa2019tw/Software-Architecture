#ifndef VIEW_H
#define VIEW_H

#include <string>

int view();

void RedMessage(std::string message);
void SetTextToGreen();
void SetTextToRed();
void SetTextToBlue();
void SetTextToNormal();
void SetTextToMagenta();

void add_class();
int function_AddSelectCheckClassName(const std::string& sName);
void function_AddClass(const std::string& sName, const std::string& sDescription, const std::string& sTarget, const std::string& sPrice, const std::string& sAttention, const std::string& sNote);


void delete_class();
void function_DelSelectClassName();
int function_DelSelectCheckClassName(const std::string& sName);
void function_DeleteClass(const std::string& sName);
void function_DelSelectClassOne(const std::string& sName);

void modify_class();
void function_ModifySelectClassName();
int function_ModifySelectCheckClassName(const std::string& sName);
void function_ModifySelectClassOne(const std::string& sName);
void function_ModifyClassName(const std::string& sName, const std::string& sNewName);
void function_ModifyClassDescription(const std::string& sName, const std::string& sNewDescription);
void function_ModifyClassTarget(const std::string& sName, const std::string& sNewTarget);
void function_ModifyClassPrice(const std::string& sName, const std::string& sNewPrice);
void function_ModifyClassAttention(const std::string& sName, const std::string& sNewAttention);
void function_ModifyClassNote(const std::string& sName, const std::string& sNewNote);

void search_class();
void function_SelectClass();

#endif
