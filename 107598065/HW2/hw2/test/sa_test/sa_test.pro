include(gtest_dependency.pri)

TEMPLATE = app
CONFIG += console c++11
CONFIG -= app_bundle
CONFIG += thread
CONFIG -= qt

HEADERS += \
        tst_test01.h \
    test_entities/test_course.h \
    test_usecases/test_manage_course.h \
    test_data_access/test_inmemory.h \
    test_data_access/test_txt.h

SOURCES += \
        main.cpp
