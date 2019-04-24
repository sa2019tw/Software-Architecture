#include "view.h"
#include <stdio.h>
#include <stdlib.h>
#include <iostream>
#include <string>
#include <windows.h>
#include "./function/search_class.h"
#include "./function/add_class.h"
#include "./function/delete_class.h"
#include "./function/modify_class.h"

using namespace std;

int view(){
    int input;
    char useless[50];
    while (1){
        cout << "++++++++++課程系統++++++++++" << endl << endl;
        SetTextToMagenta();
        cout << "1. 列出所有課程" << endl;
        cout << "2. 新增課程" << endl;
        cout << "3. 刪除課程" << endl;
        cout << "4. 編輯課程" << endl;
        cout << "5. 離開" << endl;
        SetTextToBlue();
        cout << "請輸入上面所對應的數字: ";
        cin >> input;
        gets(useless);
        system("cls");
        cout << "請輸入上面所對應的數字: " << input << endl << endl;
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
                cout << "Bye Bye~~" << endl;
                return 0;
            default:
                RedMessage("輸入錯誤，請重新輸入！");
                cout << endl;
        }
    }
}

void search_class(){
    cout << "----------課程查詢----------" << endl << endl;
    cout << "所有課程如下:";
    cout << endl << endl;
    cout << "[        課程名稱        ][        課程說明        ][        課程對象        ][        課程定價        ][        注意事項        ][        課程備註        ]";
    cout << endl;
    cout << " ------------------------  ------------------------  ------------------------  ------------------------  ------------------------  ------------------------ ";
    cout << endl;
    function_SelectClass();
    cout << endl;
}

void add_class(){
    int check_class_exist;
    char name[100], description[100], target[100], price[100], attention[100], note[100], newname[100], minus_one[5]="-1", empty_class[5]="";
    cout << "----------新增課程----------" << endl << endl;
    SetTextToBlue();
    cout << "輸入課程名稱: ";
    gets(name);
    SetTextToNormal();
    check_class_exist =  function_AddSelectCheckClassName(name);
    if (check_class_exist == 1)
    {
        RedMessage("已存在相同名稱之課程！");
        cout << endl;
    }
    else if (check_class_exist == 0 && strcmp (name, empty_class) == 0)
    {
        RedMessage("錯誤，課程不得留空！");
        cout << endl;
    }
    else
    {
        SetTextToBlue();
        cout << "輸入課程說明: ";
        gets(description);
        cout << "輸入課程適合的對象: ";
        gets(target);
        cout << "輸入課程定價: ";
        gets(price);
        cout << "輸入課程注意事項: ";
        gets(attention);
        cout << "輸入課程備註: ";
        gets(note);
        SetTextToNormal();
        cout << endl;
        cout << "[        課程名稱        ][        課程說明        ][        課程對象        ][        課程定價        ][        注意事項        ][        課程備註        ]";
        cout << endl;
        cout << " ------------------------  ------------------------  ------------------------  ------------------------  ------------------------  ------------------------ ";
        printf("%26s%26s%26s%26s%26s%26s\n", name, description, target, price, attention, note);
        SetTextToBlue();
        cout << endl;
        cout << "若確定要新增，請再輸入一次課名，否則輸入-1跳出: ";
        while(1)
        {
            gets(newname);
            if (strcmp (name, newname) == 0)
            {
                system("cls");
                function_AddClass(name, description, target, price, attention, note);
                SetTextToNormal();
                break;
            }
            else if (strcmp (minus_one, newname) == 0)
            {
                system("cls");
                SetTextToNormal();
                break;
            }
            else
            {
                RedMessage("輸入錯誤！");
                SetTextToBlue();
                cout << "若確定要新增，請再輸入一次課名，否則輸入-1跳出: ";
            }
        }
    }
}

void delete_class(){
    int check_class_exist;
    char name[100], newname[100], minus_one[5]="-1";
    cout << "----------刪除課程----------" << endl << endl;
    cout << "目前的課程有: ";
    function_DelSelectClassName();
    SetTextToBlue();
    cout << "請輸入要刪除的課程: ";
    gets(name);
    SetTextToNormal();
    check_class_exist = function_DelSelectCheckClassName(name);
    if (check_class_exist == 0)
    {
        RedMessage("課程不存在！");
        cout << endl;
    }
    else if (check_class_exist == 1)
    {
        cout << endl;
        cout << "[        課程名稱        ][        課程說明        ][        課程對象        ][        課程定價        ][        注意事項        ][        課程備註        ]";
        cout << endl;
        cout << " ------------------------  ------------------------  ------------------------  ------------------------  ------------------------  ------------------------ ";
        cout << endl;
        function_DelSelectClassOne(name);
        SetTextToBlue();
        cout << "若確定要刪除，請再輸入一次課名，否則輸入-1跳出: ";
        while (1)
        {
            gets(newname);
            if (strcmp (name, newname) == 0)
            {
                system("cls");
                function_DeleteClass(name);
                SetTextToNormal();
                break;
            }
            else if (strcmp (minus_one, newname) == 0)
            {
                system("cls");
                SetTextToNormal();
                break;
            }
            else
            {
                RedMessage("輸入錯誤！");
                SetTextToBlue();
                cout << "若確定要刪除，請再輸入一次課名，否則輸入-1跳出: ";
            }
        }
    }
}

void modify_class(){
    int modify, check_class_exist;
    char name[100], aa[50], description[100], target[100], price[100], attention[100], note[100], newname[100], empty_class[5]="";
    cout << "----------課程編輯----------" << endl << endl;
    cout << "目前的課程有: ";
    function_ModifySelectClassName();
    SetTextToBlue();
    cout << "請輸入欲修改之課程: ";
    gets(name);
    SetTextToNormal();
    check_class_exist = function_ModifySelectCheckClassName(name);
    if (check_class_exist == 0)
    {
        RedMessage("課程不存在！");
        cout << endl;
    }
    else
    {
        modify = 0;
        while(modify!=7)
        {
            cout << endl;
            cout << "[        課程名稱        ][        課程說明        ][        課程對象        ][        課程定價        ][        注意事項        ][        課程備註        ]";
            cout << endl;
            cout << " ------------------------  ------------------------  ------------------------  ------------------------  ------------------------  ------------------------ ";
            cout << endl;
            function_ModifySelectClassOne(name);
            SetTextToMagenta();
            cout << "1. 修改《" << name << "》課程名稱" << endl;
            cout << "2. 修改《" << name << "》課程說明" << endl;
            cout << "3. 修改《" << name << "》課程適合的對象" << endl;
            cout << "4. 修改《" << name << "》課程定價" << endl;
            cout << "5. 修改《" << name << "》課程注意事項" << endl;
            cout << "6. 修改《" << name << "》課程備註" << endl;
            cout << "7. 離開編輯模式" << endl;
            SetTextToBlue();
            cout << "請輸入上面所對應的數字: ";
            cin >> modify;
            gets(aa);
            switch (modify)
            {
            case 1:
                cout << "請輸入欲修改之課程新名稱: ";
                gets(newname);
                if (strcmp (newname, empty_class) == 0)
                {
                    system("cls");
                    RedMessage("錯誤，課程不得留空！");
                    break;
                }
                function_ModifySelectCheckClassName(newname);
                if (check_class_exist == 1)
                {
                    system("cls");
                    RedMessage("已存在相同名稱之課程！");
                    cout << endl;
                    break;
                }
                system("cls");
                function_ModifyClassName(name, newname);
                strcpy(name, newname);
                break;
            case 2:
                cout << "請輸入欲修改之課程新說明: ";
                gets(description);
                system("cls");
                function_ModifyClassDescription(name, description);
                break;
            case 3:
                cout << "請輸入欲修改之課程新適合的對象: ";
                gets(target);
                system("cls");
                function_ModifyClassTarget(name, target);
                break;
            case 4:
                cout << "請輸入欲修改之課程新定價: ";
                gets(price);
                system("cls");
                function_ModifyClassPrice(name, price);
                break;
            case 5:
                cout << "請輸入欲修改之課程新注意事項: ";
                gets(attention);
                system("cls");
                function_ModifyClassAttention(name, attention);
                break;
            case 6:
                cout << "請輸入欲修改之課程新備註: ";
                gets(note);
                system("cls");
                function_ModifyClassNote(name, note);
                break;
            case 7:
                SetTextToNormal();
                break;
            default:
                RedMessage("輸入錯誤，請重新輸入！");
            }
        }
        system("cls");
    }

}

void RedMessage(string message)
{
    SetTextToRed();
    cout << message << endl;
    SetTextToNormal();
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

void SetTextToMagenta()
{
    SetConsoleTextAttribute(GetStdHandle(STD_OUTPUT_HANDLE), BACKGROUND_RED | BACKGROUND_GREEN | BACKGROUND_BLUE | BACKGROUND_INTENSITY | FOREGROUND_BLUE |
                            FOREGROUND_RED | FOREGROUND_INTENSITY);
}
