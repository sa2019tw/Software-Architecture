#include <stdio.h>
#include <stdlib.h>
#include <iostream>
#include <string.h>
#include <windows.h>
#include "delete_class.h"
#include "../usecase/delete_class_usecase.h"
#include "../usecase/search_class_usecase.h"

using namespace std;

void delete_class()
{
    char name[100], newname[100], minus_one[5]="-1";
    printf("-----刪除課程-----\n\n");
    SelectClassName();
    SetTextToBlue();
    printf("請輸入要刪除的課程: ");
    gets(name);
    SetTextToNormal();
    SelectCheckClassName(name);
    if (check_class_exist == 0)
    {
        RedMessage("課程不存在！");
        printf("\n");
    }
    else if (check_class_exist == 1)
    {
        SelectClassOne(name);
        SetTextToBlue();
        printf("若確定要刪除，請再輸入一次課名，否則輸入-1跳出: ");
        while (1)
        {
            gets(newname);
            if (strcmp (name, newname) == 0)
            {
                system("cls");
                DeleteClass(name);
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
                printf("若確定要刪除，請再輸入一次課名，否則輸入-1跳出: ");
            }
        }
    }
}
