#include "mainwindow.h"
#include "ui_mainwindow.h"
#include "createdialog.h"

#include <QCloseEvent>
#include <QMessageBox>
#include <QInputDialog>
#include <iostream>
#include <fstream>
#include <string>
#include <stdlib.h>
#include <string.h>
#include <vector>
using namespace std;

MainWindow::MainWindow(QWidget *parent) :
    QMainWindow(parent),
    ui(new Ui::MainWindow)
{
    ui->setupUi(this);
    iniSignalSlots();

    iniTable();
}

MainWindow::~MainWindow()
{
    delete ui;
}

void MainWindow::closeEvent(QCloseEvent *event)
{
    QMessageBox::StandardButton button;
    button = QMessageBox::question(this, tr("關閉程式"),
        QString(tr("確定要離開?")),
        QMessageBox::Yes | QMessageBox::No);

    if (button == QMessageBox::No)
        event->ignore();
    if (button == QMessageBox::Yes)
        closeYesEvent();
}

void MainWindow::iniSignalSlots()
{
    connect(ui->btnShow,SIGNAL(clicked()),this,SLOT(on_btnShow()));
    connect(ui->btnCreate,SIGNAL(clicked()),this,SLOT(on_btnCreate()));
    connect(ui->btnDelete,SIGNAL(clicked()),this,SLOT(on_btnDelete()));
    connect(ui->btnEdit,SIGNAL(clicked()),this,SLOT(on_btnEdit()));
}


void MainWindow::on_btnShow()
{
    QString dlgTitle = "列出所有課程";
    QString qStrClassName = "";
    qStrClassName = controller.showAllCourse();
    QMessageBox::about(this,dlgTitle,qStrClassName);
}

void MainWindow::on_btnCreate()
{
    CreateDialog * createDialog = new CreateDialog(this);
    int resultValue = createDialog->exec();
    //resultValue==0 is create
    //resultValue==1 is cancel
    if(resultValue==0){
        QString strArray[6];
        for(int i=0;i<6;i++){
            strArray[i] = createDialog->readLabel(i);
        }
        int rows = ui->tableClass->rowCount();
        ui->tableClass->insertRow(rows);
        createItemsARow(rows,strArray[0],strArray[1],
                        strArray[2],strArray[3],strArray[4],strArray[5]);
        controller.createCourse(strArray);

    }
    delete createDialog;
}

void MainWindow::on_btnDelete()
{
    int curRow = ui->tableClass->currentRow();
    if(curRow < 0){
        QString dlgTitle = "錯誤";
        QString strInfo = "請選點選要刪除行";
        QMessageBox::warning(this,dlgTitle,strInfo);
    }
    else{
        QMessageBox::StandardButton button;
        button = QMessageBox::warning(this, tr("刪除提醒"),
            QString(tr("確認要刪除?")),
            QMessageBox::Yes | QMessageBox::No);
        if (button == QMessageBox::Yes) {
            ui->tableClass->removeRow(curRow);
            controller.deleteCoures(curRow+1);
        }
    }

}

void MainWindow::on_btnEdit()
{
    QString dlgTitle = "編輯";
    QString txtLabel = "選擇想要編輯的行號";
    int defaultValue = ui->tableClass->currentRow()+1;
    int minValue = 1;
    int maxValue = ui->tableClass->rowCount();
    int stepValue = 1;
    bool ok = false;
    int inputValue = QInputDialog::getInt(this,dlgTitle,txtLabel,
                                          defaultValue,minValue,maxValue,
                                          stepValue,&ok);
    QString originalArray[6];
    int setRow = inputValue - 1;
    if(ok){
        CreateDialog * createDialog = new CreateDialog(this);
        for(int i=0;i<6;i++){
            createDialog->setLabel(i,ui->tableClass->item(setRow,i)->text());
            originalArray[i] = ui->tableClass->item(setRow,i)->text();
        }
        int resultValue = createDialog->exec();
        if(resultValue==0){
            QString strArray[6];
            for(int i=0;i<6;i++){
                strArray[i] = createDialog->readLabel(i);
            }
            ui->tableClass->removeRow(setRow);
            ui->tableClass->insertRow(setRow);
            createItemsARow(setRow,strArray[0],strArray[1],
                            strArray[2],strArray[3],strArray[4],strArray[5]);
            controller.editCourse(inputValue,originalArray,strArray);
        }
        delete createDialog;
    }
}

void MainWindow::createItemsARow(int rowNo, QString className,
                                 QString classDetail, QString forWho,
                                 QString price, QString attention, QString note){

    QString qstrArr[6] = {className,classDetail,forWho,price,attention,note};
    QTableWidgetItem * item;
    for(int i=0;i<6;i++){
        item = new QTableWidgetItem(qstrArr[i],i);
        ui->tableClass->setItem(rowNo,i,item);
    }

}

void MainWindow::createARowByItem(int rowNo, map<int, QTableWidgetItem *> mapItem){
    map<int, QTableWidgetItem *>::iterator it = mapItem.begin();
    for(it;it != mapItem.end();++it){
        ui->tableClass->setItem(rowNo,it->first,it->second);
    }
}

void MainWindow::iniTable(){
    vector<map<int,QTableWidgetItem *>> vectorOfMap = controller.getMapItem();
    QTableWidgetItem * headerItem;
    QStringList headerText = controller.iniTable_headerText();
    ui->tableClass->setColumnCount(headerText.count());
    ui->tableClass->setRowCount(vectorOfMap.size());
    for(int i=0;i<ui->tableClass->columnCount();i++){
        headerItem = new QTableWidgetItem(headerText.at(i));
        ui->tableClass->setHorizontalHeaderItem(i,headerItem);
    }

    vector<map<int,QTableWidgetItem *>>::iterator it;
    int rowCount=0;
    for(it = vectorOfMap.begin();it != vectorOfMap.end();++it){
        createARowByItem(rowCount,(*it));
        rowCount++;
    }
}

void MainWindow::closeYesEvent(){
    vector<vector<QString>> vecData;
    QTableWidgetItem * cellItem;
    for(int i=0;i<ui->tableClass->rowCount();i++){
        vector<QString> vecDataLine;
        for(int j=0;j<ui->tableClass->columnCount();j++){
            cellItem = ui->tableClass->item(i,j);
            vecDataLine.push_back(cellItem->text());
        }
        vecData.push_back(vecDataLine);
    }
    controller.closeEvent(vecData);
}


