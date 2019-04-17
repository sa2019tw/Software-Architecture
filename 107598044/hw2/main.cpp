#include <stdio.h>
#include <stdlib.h>
#include <iostream>
#include <string.h>
#include <windows.h>
#include "./function/search_class.h"
#include "./function/add_class.h"
#include "./function/delete_class.h"
#include "./function/modify_class.h"

using namespace std;


//增加課程
void add_class();
void AddClass(const string& sName, const string& sDescription, const string& sTarget, const string& sPrice, const string& sAttention, const string& sNote);

//刪除課程��
void delete_class();
void DeleteClass(const string& sName);

//編輯課程
void modify_class();
void ModifyClassName(const string& sName, const string& sNewName);
void ModifyClassDescription(const string& sName, const string& sNewDescription);
void ModifyClassTarget(const string& sName, const string& sNewTarget);
void ModifyClassPrice(const string& sName, const string& sNewPrice);
void ModifyClassAttention(const string& sName, const string& sNewAttention);
void ModifyClassNote(const string& sName, const string& sNewNote);

//尋找課程
void search_class();
void SelectClass();
void SelectClassOne(const string& sName);
void SelectClassName();
void SelectCheckClassName(const string& sName);

//訊息顏色
void RedMessage(string message);
void SetTextToGreen();
void SetTextToRed();
void SetTextToBlue();
void SetTextToNormal();

int main()
{
    system("color F0");
    int input;
    char aa[50];
    while (1)
    {
        printf("1. 列出所有課程\n");
        printf("2. 新增課程\n");
        printf("3. 刪除課程\n");
        printf("4. 編輯課程\n");
        printf("5. 離開\n");
        SetTextToBlue();
        printf("請輸入上面所對應的數字: ");
        scanf("%d", &input);
        gets(aa);
        system("cls");
        printf("請輸入上面所對應的數字: %d\n\n", input);
        SetTextToNormal();
        switch (input)
        {
            case 1:
                search_class();
                break;
            case 2:
                add_class();
                break;
            case 3:
                delete_class();
                break;
            case 4:
                modify_class();
                break;
            case 5:
                return 0;
            default:
                RedMessage("輸入錯誤，請重新輸入！");
                printf("\n");
        }
    }
    return 0;
}

void RedMessage(string message)
{
    SetConsoleTextAttribute(GetStdHandle(STD_OUTPUT_HANDLE), BACKGROUND_RED | BACKGROUND_GREEN | BACKGROUND_BLUE | BACKGROUND_INTENSITY | FOREGROUND_RED);
    cout << message << endl;
    SetConsoleTextAttribute(GetStdHandle(STD_OUTPUT_HANDLE), BACKGROUND_RED | BACKGROUND_GREEN | BACKGROUND_BLUE | BACKGROUND_INTENSITY);
}

void SetTextToRed()
{
    SetConsoleTextAttribute(GetStdHandle(STD_OUTPUT_HANDLE), BACKGROUND_RED | BACKGROUND_GREEN | BACKGROUND_BLUE | BACKGROUND_INTENSITY | FOREGROUND_RED);
}

void SetTextToGreen()
{
    SetConsoleTextAttribute(GetStdHandle(STD_OUTPUT_HANDLE), BACKGROUND_RED | BACKGROUND_GREEN | BACKGROUND_BLUE | BACKGROUND_INTENSITY | FOREGROUND_GREEN);
}

void SetTextToNormal()
{
    SetConsoleTextAttribute(GetStdHandle(STD_OUTPUT_HANDLE), BACKGROUND_RED | BACKGROUND_GREEN | BACKGROUND_BLUE | BACKGROUND_INTENSITY);
}

void SetTextToBlue()
{
    SetConsoleTextAttribute(GetStdHandle(STD_OUTPUT_HANDLE), BACKGROUND_RED | BACKGROUND_GREEN | BACKGROUND_BLUE | BACKGROUND_INTENSITY | FOREGROUND_BLUE);
}
