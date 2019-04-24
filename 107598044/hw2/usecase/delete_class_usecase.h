#ifndef DELETE_CLASS_USECASE_H
#define DELETE_CLASS_USECASE_H

#include <string>

void SelectClassNameDao();
int SelectCheckClassNameDao(const std::string& sName);
void DeleteClassDao(const std::string& sName);
void SelectClassOneDao(const std::string& sName);


#endif
