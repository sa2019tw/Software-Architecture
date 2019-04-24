#ifndef MODIFY_CLASS_USECASE_H
#define MODIFY_CLASS_USECASE_H

#include <string>

void SelectClassNameDao();

int SelectCheckClassNameDao(const std::string& sName);

void SelectClassOneDao(const std::string& sName);

void ModifyClassNameDao(const std::string& sName, const std::string& sNewName);

void ModifyClassDescriptionDao(const std::string& sName, const std::string& sNewDescription);

void ModifyClassTargetDao(const std::string& sName, const std::string& sNewTarget);

void ModifyClassPriceDao(const std::string& sName, const std::string& sNewPrice);

void ModifyClassAttentionDao(const std::string& sName, const std::string& sNewAttention);

void ModifyClassNoteDao(const std::string& sName, const std::string& sNewNote);


#endif
