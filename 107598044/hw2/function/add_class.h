#ifndef ADD_CLASS_H
#define ADD_CLASS_H

extern int check_class_exist;

void RedMessage(std::string message);
void SetTextToGreen();
void SetTextToRed();
void SetTextToBlue();
void SetTextToNormal();

void search_class();
void SelectClass();
void SelectClassOne(const std::string& sName);
void SelectClassName();
void SelectCheckClassName(const std::string& sName);
void AddClass(const std::string& sName, const std::string& sDescription, const std::string& sTarget, const std::string& sPrice, const std::string& sAttention, const std::string& sNote);

#endif
