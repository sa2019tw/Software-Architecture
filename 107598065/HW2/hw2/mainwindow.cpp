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

    //vector<vector<string>> vecData = fileInput("data.txt");
    vector<vector<string>> vecData = mc->getAllCourse();

    //Table
    QTableWidgetItem * headerItem;
    QStringList headerText;
    headerText<<"課程名稱"<<"課程說明"<<"適合對象"<<"定價"<<"注意事項"<<"備註";
    ui->tableClass->setColumnCount(headerText.count());
    ui->tableClass->setRowCount(vecData.size());
    for(int i=0;i<ui->tableClass->columnCount();i++){
        headerItem = new QTableWidgetItem(headerText.at(i));
        ui->tableClass->setHorizontalHeaderItem(i,headerItem);
    }
    vector<vector<string>>::iterator itData;
    vector<string>::iterator it;
    int rowCount=0;
    for(itData = vecData.begin();itData != vecData.end();++itData){
        for(int i=0;i<6;i++){
            if((*itData)[i].compare(" ") == 0)
                (*itData)[i] = "";
        }
        QString strClassName = QString(QString::fromLocal8Bit((*itData)[0].c_str()));
        QString strClassDetail = QString(QString::fromLocal8Bit((*itData)[1].c_str()));
        QString strForWho = QString(QString::fromLocal8Bit((*itData)[2].c_str()));
        QString strPrice = QString(QString::fromLocal8Bit((*itData)[3].c_str()));
        QString strAttention = QString(QString::fromLocal8Bit((*itData)[4].c_str()));
        QString strNote = QString(QString::fromLocal8Bit((*itData)[5].c_str()));
        createItemsARow(rowCount,strClassName,strClassDetail,
                        strForWho,strPrice,strAttention,strNote);
        rowCount++;
    }
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

    if (button == QMessageBox::No) {
        event->ignore();
    }
    if (button == QMessageBox::Yes) {
        vector<vector<string>> vecData;
        QTableWidgetItem * cellItem;
        for(int i=0;i<ui->tableClass->rowCount();i++){
            vector<string> vecDataLine;
            for(int j=0;j<ui->tableClass->columnCount();j++){
                cellItem = ui->tableClass->item(i,j);
                if(cellItem->text().length() == 0)
                    vecDataLine.push_back(" ");
                else
                    vecDataLine.push_back( string((const char *)cellItem->text().toLocal8Bit()) );
            }
            vecData.push_back(vecDataLine);
        }
        //fileOutPut("data.txt",strText);
        bool outputResult = false;
        mc->setAllCourse(vecData,outputResult);
    }
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
    for(int i=0;i<ui->tableClass->rowCount();i++){
        qStrClassName += ui->tableClass->item(i,0)->text() + "\n";
    }
    QMessageBox::about(this,dlgTitle,qStrClassName);
}

void MainWindow::on_btnCreate()
{
    CreateDialog * createDialog = new CreateDialog(this);
    int ret = createDialog->exec();
    //ret==0 is create
    //ret==1 is cancel
    if(ret==0){
        QString strClassName = createDialog->readLeClassName();
        QString strClassDetail = createDialog->readLeClassDetail();
        QString strForWho = createDialog->readLeForWho();
        QString strPrice = createDialog->readLePrice();
        QString strAttention = createDialog->readLeAttention();
        QString strNote = createDialog->readLeNote();
        int rows = ui->tableClass->rowCount();
        ui->tableClass->insertRow(rows);
        createItemsARow(rows,strClassName,strClassDetail,
                        strForWho,strPrice,strAttention,strNote);
    }
    delete createDialog;
}

void MainWindow::on_btnDelete()
{
    int curRow = ui->tableClass->currentRow();
    cout<<"curRow = "<<curRow<<endl;
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
        }
    }

}

void MainWindow::on_btnEdit()
{
    QString dlgTitle = "";
    QString txtLabel = "";
    int defaultValue = ui->tableClass->currentRow()+1;
    int minValue = 1;
    int maxValue = ui->tableClass->rowCount();
    int stepValue = 1;
    bool ok = false;
    int inputValue = QInputDialog::getInt(this,dlgTitle,txtLabel,
                                          defaultValue,minValue,maxValue,
                                          stepValue,&ok);
    int setRow = inputValue - 1;
    if(ok){
        CreateDialog * createDialog = new CreateDialog(this);

        createDialog->setLeClassName(ui->tableClass->item(setRow,0)->text());
        createDialog->setLeClassDetail(ui->tableClass->item(setRow,1)->text());
        createDialog->setLeForWho(ui->tableClass->item(setRow,2)->text());
        createDialog->setLePrice(ui->tableClass->item(setRow,3)->text());
        createDialog->setLeAttention(ui->tableClass->item(setRow,4)->text());
        createDialog->setLeNote(ui->tableClass->item(setRow,5)->text());

        int ret = createDialog->exec();
        //ret==0 is create
        //ret==1 is cancel
        if(ret==0){
            QString strClassName = createDialog->readLeClassName();
            QString strClassDetail = createDialog->readLeClassDetail();
            QString strForWho = createDialog->readLeForWho();
            QString strPrice = createDialog->readLePrice();
            QString strAttention = createDialog->readLeAttention();
            QString strNote = createDialog->readLeNote();
            ui->tableClass->removeRow(setRow);
            ui->tableClass->insertRow(setRow);
            createItemsARow(setRow,strClassName,strClassDetail,
                            strForWho,strPrice,strAttention,strNote);
        }
        delete createDialog;
    }
}

void MainWindow::createItemsARow(int rowNo, QString className,
                                 QString classDetail, QString forWho,
                                 QString price, QString attention, QString note){
    QTableWidgetItem * item;
    item = new QTableWidgetItem(className,MainWindow::ctClassName);
    ui->tableClass->setItem(rowNo,MainWindow::colClassName,item);
    item = new QTableWidgetItem(classDetail,MainWindow::ctClassDetail);
    ui->tableClass->setItem(rowNo,MainWindow::colClassDetail,item);
    item = new QTableWidgetItem(forWho,MainWindow::ctForWho);
    ui->tableClass->setItem(rowNo,MainWindow::colForWho,item);
    item = new QTableWidgetItem(price,MainWindow::ctPrice);
    ui->tableClass->setItem(rowNo,MainWindow::colPrice,item);
    item = new QTableWidgetItem(attention,MainWindow::ctAttention);
    ui->tableClass->setItem(rowNo,MainWindow::colAttention,item);
    item = new QTableWidgetItem(note,MainWindow::ctNote);
    ui->tableClass->setItem(rowNo,MainWindow::colNote,item);

}

vector<vector<string>> MainWindow::fileInput(string fileName)
{
    fstream f_input;
    f_input.open(fileName.c_str());
    vector<vector<string>> vecData;
    if( !f_input )
        cerr<<"Fail to open file(ex:input.txt)."<<endl;
    else{
        char ch[10000];
        const char *d = ",";
        char *p;
        while( f_input.getline(ch,5000) ){
            vector<string> vecContent;
            p=strtok(ch,d);
            while(p){
                string str = string(p);
                vecContent.push_back(str);
                p=strtok(NULL,d);
            }
            vecData.push_back(vecContent);
        }
    }
    f_input.close();
    return vecData;
}

void MainWindow::fileOutPut(string fileName, string saveData)
{
    fstream f_output;
    f_output.open(fileName.c_str(),fstream::out | fstream::trunc);
    if(!f_output)
        cerr<<"Fail to open file(ex:output.txt)."<<endl;
    else{
        f_output<<saveData;
    }
    f_output.close();
}
