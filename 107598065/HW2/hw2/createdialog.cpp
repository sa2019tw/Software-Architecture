#include "createdialog.h"
#include "ui_createdialog.h"
#include <QCloseEvent>
#include <QMessageBox>
#include <QString>

#include <string>
#include <iostream>
using namespace std;

CreateDialog::CreateDialog(QWidget *parent) :
    QDialog(parent),
    ui(new Ui::CreateDialog)
{
    ui->setupUi(this);
}

CreateDialog::~CreateDialog()
{
    delete ui;
}

void CreateDialog::closeEvent(QCloseEvent *event)
{
    QString qstr = ui->leClassName->text();
    string str = string((const char *)qstr.toLocal8Bit());
    if(str.compare("") == 0){
        QMessageBox::StandardButton button;
        button = QMessageBox::warning(this, tr("新增失敗"),
            QString(tr("課程名稱為必填欄位!")),
            QMessageBox::Yes);
        if (button == QMessageBox::Yes) {
            event->ignore();
        }
    }
}

QString CreateDialog::readLeClassName()
{
    QString qstr = ui->leClassName->text();
    return qstr;
}
QString CreateDialog::readLeClassDetail()
{
    QString qstr = ui->leClassDetail->text();
    return qstr;
}
QString CreateDialog::readLeForWho()
{
    QString qstr = ui->leForWho->text();
    return qstr;
}
QString CreateDialog::readLePrice()
{
    QString qstr = ui->lePrice->text();
    return qstr;
}
QString CreateDialog::readLeAttention()
{
    QString qstr = ui->leAttention->text();
    return qstr;
}
QString CreateDialog::readLeNote()
{
    QString qstr = ui->leNote->text();
    return qstr;
}

void CreateDialog::setLeClassName(QString qstr)
{
    ui->leClassName->setText(qstr);
}
void CreateDialog::setLeClassDetail(QString qstr)
{
    ui->leClassDetail->setText(qstr);
}
void CreateDialog::setLeForWho(QString qstr)
{
    ui->leForWho->setText(qstr);
}
void CreateDialog::setLePrice(QString qstr)
{
    ui->lePrice->setText(qstr);
}
void CreateDialog::setLeAttention(QString qstr)
{
    ui->leAttention->setText(qstr);
}
void CreateDialog::setLeNote(QString qstr)
{
    ui->leNote->setText(qstr);
}

//string CreateDialog::readLeClassName()
//{
//    QString qstr = ui->leClassName->text();
//    string str = string((const char *)qstr.toLocal8Bit());
//    return str;
//}
//string CreateDialog::readLeClassDetail()
//{
//    QString qstr = ui->leClassDetail->text();
//    string str = string((const char *)qstr.toLocal8Bit());
//    return str;
//}
//string CreateDialog::readLeForWho()
//{
//    QString qstr = ui->leForWho->text();
//    string str = string((const char *)qstr.toLocal8Bit());
//    return str;
//}
//string CreateDialog::readLePrice()
//{
//    QString qstr = ui->lePrice->text();
//    string str = string((const char *)qstr.toLocal8Bit());
//    return str;
//}
//string CreateDialog::readLeAttention()
//{
//    QString qstr = ui->leAttention->text();
//    string str = string((const char *)qstr.toLocal8Bit());
//    return str;
//}
//string CreateDialog::readLeNote()
//{
//    QString qstr = ui->leNote->text();
//    string str = string((const char *)qstr.toLocal8Bit());
//    return str;
//}

