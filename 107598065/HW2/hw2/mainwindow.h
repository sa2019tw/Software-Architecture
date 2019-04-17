#ifndef MAINWINDOW_H
#define MAINWINDOW_H

#include "./usecases/manage_course.h"
#include "./data_access/data_access_interface.h"
#include "./data_access/data_access_inmemory.h"
#include "./data_access/data_access_txt.h"

#include <QMainWindow>
#include <QLabel>

#include <string>
#include <vector>
#include <iostream>
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

    vector<vector<string>> fileInput(string fileName);
    void fileOutPut(string fileName,string saveData);

private:
    Ui::MainWindow *ui;
    void iniSignalSlots();
    void closeEvent(QCloseEvent *event);

    DataAccessInterface *dao = new DataAccessTxt();
    //DataAccessInterface *dao = new DataAccessInMemory();
    ManageCourse *mc = new ManageCourse(dao);

private slots:
    void on_btnShow();
    void on_btnCreate();
    void on_btnDelete();
    void on_btnEdit();

private:
    enum CellType{ctClassName,ctClassDetail,ctForWho,
                  ctPrice,ctAttention,ctNote};
    enum FieldColNum{colClassName,colClassDetail,colForWho,
                     colPrice,colAttention,colNote};

    void createItemsARow(int rowNo,QString className,QString classDetail,
                         QString forWho,QString price,
                         QString attention,QString note);

};

#endif // MAINWINDOW_H
