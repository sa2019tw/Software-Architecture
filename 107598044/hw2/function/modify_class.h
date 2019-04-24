#ifndef MODIFY_CLASS_H
#define MODIFY_CLASS_H

#include <string>

void ModifySelectClassName();

int ModifySelectCheckClassName(const std::string& sName);

void ModifySelectClassOne(const std::string& sName);

void ModifyClassName(const std::string& sName, const std::string& sNewName);

void ModifyClassDescription(const std::string& sName, const std::string& sNewDescription);

void ModifyClassTarget(const std::string& sName, const std::string& sNewTarget);

void ModifyClassPrice(const std::string& sName, const std::string& sNewPrice);

void ModifyClassAttention(const std::string& sName, const std::string& sNewAttention);

void ModifyClassNote(const std::string& sName, const std::string& sNewNote);

#endif
