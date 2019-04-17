#include <stdio.h>
#include <stdlib.h>
#include <iostream>
#include <string.h>
#include <windows.h>
#include "add_class.h"
#include "../usecase/add_class_usecase.h"

using namespace std;

void add_class()
{
    char name[100], description[100], target[100], price[100], attention[100], note[100], newname[100], minus_one[5]="-1", empty_class[5]="";
    printf("-----新增課程-----\n\n");
    SetTextToBlue();
    printf("輸入課程名稱: ");
    gets(name);
    SetTextToNormal();
    SelectCheckClassName(name);
    if (check_class_exist == 1)
    {
        RedMessage("已存在相同名稱之課程！");
        printf("\n");
    }
    else if (check_class_exist == 0 && strcmp (name, empty_class) == 0)
    {
        RedMessage("課程不得留空！");
        printf("\n");
    }
    else
    {
        SetTextToBlue();
        printf("輸入課程說明: ");
        gets(description);
        printf("輸入課程適合的對象: ");
        gets(target);
        printf("輸入課程定價: ");
        gets(price);
        printf("輸入課程注意事項: ");
        gets(attention);
        printf("輸入課程備註: ");
        gets(note);
        SetTextToNormal();
        printf("\n[        課程名稱        ][        課程說明        ][        課程對象        ][        課程定價        ][        注意事項        ][        課程備註        ]\n");
        printf(" ------------------------  ------------------------  ------------------------  ------------------------  ------------------------  ------------------------ \n");
        printf("%26s%26s%26s%26s%26s%26s\n", name, description, target, price, attention, note);
        SetTextToBlue();
        printf("\n若確定要新增，請再輸入一次課名，否則輸入-1跳出: ");
        while(1)
        {
            gets(newname);
            if (strcmp (name, newname) == 0)
            {
                system("cls");
                AddClass(name, description, target, price, attention, note);
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
                printf("若確定要新增，請再輸入一次課名，否則輸入-1跳出: ");
            }
        }
    }

}
