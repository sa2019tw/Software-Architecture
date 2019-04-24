#ifndef ADD_CLASS_USECASE_H
#define ADD_CLASS_USECASE_H

#include <string>

int SelectCheckClassNameDao(const std::string& sName);
void AddClassDao(const std::string& sName, const std::string& sDescription, const std::string& sTarget, const std::string& sPrice, const std::string& sAttention, const std::string& sNote);

#endif
