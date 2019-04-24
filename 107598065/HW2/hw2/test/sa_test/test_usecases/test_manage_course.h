#ifndef TEST_MANAGE_COURSE_H
#define TEST_MANAGE_COURSE_H

#include <gtest/gtest.h>
#include <gmock/gmock-matchers.h>

#include "../../../data_access/data_access_interface.h"
#include "../../../data_access/data_access_inmemory.h"
#include "../../../usecases/manage_course.h"

#include <iostream>
#include <vector>
#include <string>
using namespace std;

class TestManageCourse: public ::testing::Test
{
protected:
  void SetUp() override
  {
      input.push_back("POSD");
      input.push_back("must");
      input.push_back("first year");
      input.push_back(std::to_string(1000));
      input.push_back("hw");
      input.push_back("have midterm");

      input2.push_back("OOAD");
      input2.push_back("must");
      input2.push_back("first year");
      input2.push_back(std::to_string(3000));
      input2.push_back("hw");
      input2.push_back("have midterm");

      mc->createCourse(input,outputResult);
      mc->createCourse(input2,outputResult);
  }

  void TearDown() override{}

  vector<string> input;
  vector<string> input2;
  //DataAccessInterface *dao = new DataAccessTxt();
  DataAccessInterface *dao = new DataAccessInMemory();
  ManageCourse *mc = new ManageCourse(dao);
  bool outputResult = false;
};

TEST_F(TestManageCourse, createCourse)
{
    ASSERT_EQ(true,outputResult);
}

TEST_F(TestManageCourse, deleteCourse)
{
    bool  deleteResult = false;
    mc->deleteCourse(1,deleteResult);
    ASSERT_EQ(true,deleteResult);
}


TEST_F(TestManageCourse, editCourse)
{
    bool  editResult = false;
    mc->editCourse(1,4,"5000",editResult);
    ASSERT_EQ(true,editResult);
}

TEST_F(TestManageCourse, showAllCourse)
{
    vector<string> allCourseName;
    allCourseName.push_back("POSD");
    allCourseName.push_back("OOAD");
    ASSERT_EQ(allCourseName,mc->showAllCourse());
}

TEST_F(TestManageCourse, setAllCourse)
{
    vector<vector<string>> vecData;
    vecData.push_back(input);
    vecData.push_back(input2);
    mc->setAllCourse(vecData,outputResult);
    ASSERT_EQ(true,outputResult);
}

TEST_F(TestManageCourse, getAllCourse){

    vector<vector<string>> vecData;
    vecData.push_back(input);
    vecData.push_back(input2);

    vector<vector<string>> vecAns;
    vecAns = mc->getAllCourse();
    ASSERT_EQ(vecData,vecAns);
}

#endif // TEST_MANAGE_COURSE_H
