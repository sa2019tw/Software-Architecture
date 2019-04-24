#ifndef MAINWINDOW_H
#define MAINWINDOW_H

#include "./usecases/manage_course.h"
#include "./data_access/data_access_interface.h"
#include "./data_access/data_access_inmemory.h"
#include "./data_access/data_access_txt.h"
#include "./controller/controller.h"

#include <QMainWindow>
#include <QLabel>
#include <QTableWidgetItem>

#include <string>
#include <vector>
#include <iostream>
#include <map>
using namespace std;

namespace Ui {
class MainWindow;
}

class MainWindow : public QMainWindow
{
    Q_OBJECT

public:
    explicit MainWindow(QWidget *parent = nullptr);
    ~MainWindow();

private slots:
    void on_btnShow();
    void on_btnCreate();
    void on_btnDelete();
    void on_btnEdit();

private:
    Ui::MainWindow *ui;
    void iniSignalSlots();
    void closeEvent(QCloseEvent *event);

    DataAccessInterface *dao = new DataAccessTxt();
    //DataAccessInterface *dao = new DataAccessInMemory();
    ManageCourse *mc = new ManageCourse(dao);
    Controller controller;

    void createItemsARow(int rowNo,QString className,QString classDetail,
                         QString forWho,QString price,
                         QString attention,QString note);

    map<int,QTableWidgetItem *> _mapItem;
    void createARowByItem(int rowNo,map<int,QTableWidgetItem *> mapItem);
    void iniTable();
    void closeYesEvent();



};

#endif // MAINWINDOW_H
