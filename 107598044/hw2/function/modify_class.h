#ifndef MODIFY_CLASS_H
#define MODIFY_CLASS_H

void RedMessage(std::string message);
void SetTextToGreen();
void SetTextToRed();
void SetTextToBlue();
void SetTextToNormal();

void SelectCheckClassName(const std::string& sName);
void SelectClassOne(const std::string& sName);
void SelectClassName();
void modify_class();
void ModifyClassName(const std::string& sName, const std::string& sNewName);
void ModifyClassDescription(const std::string& sName, const std::string& sNewDescription);
void ModifyClassTarget(const std::string& sName, const std::string& sNewTarget);
void ModifyClassPrice(const std::string& sName, const std::string& sNewPrice);
void ModifyClassAttention(const std::string& sName, const std::string& sNewAttention);
void ModifyClassNote(const std::string& sName, const std::string& sNewNote);

#endif
