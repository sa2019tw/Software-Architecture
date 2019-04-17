#include <stdio.h>
#include <stdlib.h>
#include <iostream>
#include <string.h>
#include <windows.h>
#include "modify_class.h"
#include "../usecase/modify_class_usecase.h"
#include "../usecase/search_class_usecase.h"

using namespace std;

void modify_class()
{
    int modify;
    char name[100], aa[50], description[100], target[100], price[100], attention[100], note[100], newname[100], empty_class[5]="";
    printf("-----課程編輯-----\n\n");
    SelectClassName();
    SetTextToBlue();
    printf("請輸入欲修改之課程: ");
    gets(name);
    SetTextToNormal();
    SelectCheckClassName(name);
    if (check_class_exist == 0)
    {
        RedMessage("課程不存在！");
        printf("\n");
    }
    else
    {
        modify = 0;
        while(modify!=7)
        {
            SelectClassOne(name);
            printf("1. 修改《%s》課程名稱\n", name);
            printf("2. 修改《%s》課程說明\n", name);
            printf("3. 修改《%s》課程適合的對象\n", name);
            printf("4. 修改《%s》課程定價\n", name);
            printf("5. 修改《%s》課程注意事項\n", name);
            printf("6. 修改《%s》課程備註\n", name);
            printf("7. 離開編輯模式\n");
            SetTextToBlue();
            printf("請輸入上面所對應的數字: ");
            scanf("%d", &modify);
            gets(aa);
            switch (modify)
            {
            case 1:
                printf("請輸入欲修改之課程新名稱: ");
                gets(newname);
                if(strcmp (newname, empty_class) == 0)
                {
                    system("cls");
                    RedMessage("錯誤，課程不得留空！");
                    break;
                }
                system("cls");
                ModifyClassName(name, newname);
                strcpy(name, newname);
                break;
            case 2:
                printf("請輸入欲修改之課程新說明: ");
                gets(description);
                system("cls");
                ModifyClassDescription(name, description);
                break;
            case 3:
                printf("請輸入欲修改之課程新適合的對象: ");
                gets(target);
                system("cls");
                ModifyClassTarget(name, target);
                break;
            case 4:
                printf("請輸入欲修改之課程新定價: ");
                gets(price);
                system("cls");
                ModifyClassPrice(name, price);
                break;
            case 5:
                printf("請輸入欲修改之課程新注意事項: ");
                gets(attention);
                system("cls");
                ModifyClassAttention(name, attention);
                break;
            case 6:
                printf("請輸入欲修改之課程新備註: ");
                gets(note);
                system("cls");
                ModifyClassNote(name, note);
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
