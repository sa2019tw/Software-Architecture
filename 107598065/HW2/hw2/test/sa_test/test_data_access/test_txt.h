#ifndef TEST_TXT_H
#define TEST_TXT_H

#include <gtest/gtest.h>
#include <gmock/gmock-matchers.h>

#include "../../../data_access/data_access_interface.h"
#include "../../../data_access/data_access_inmemory.h"
#include "../../../data_access/data_access_txt.h"

#include <vector>
#include <string>
using namespace std;

class TestTxt: public ::testing::Test
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

      dao->createCourse(input);
      dao->createCourse(input2);
  }

  void TearDown() override{
      dao->clearDatabase();
  }

  vector<string> input;
  vector<string> input2;
  DataAccessInterface *dao = new DataAccessTxt();
};

TEST_F(TestTxt, createCourse)
{
    ASSERT_EQ(2,dao->getNumberOfCourse());
}

TEST_F(TestTxt, deleteCourse)
{
    ASSERT_EQ(2,dao->getNumberOfCourse());
    dao->deleteCourse(1);
    ASSERT_EQ(1,dao->getNumberOfCourse());
}

TEST_F(TestTxt, editCourse)
{
    bool editResult = false;
    editResult = dao->editCourse(1,4,"5000");
    ASSERT_EQ(true,editResult);
}

TEST_F(TestTxt, showAllCourse)
{
    vector<string> allCourseName;
    allCourseName.push_back("POSD");
    allCourseName.push_back("OOAD");
    ASSERT_EQ(allCourseName,dao->showAllCourse());
}

TEST_F(TestTxt, setAllCourse)
{
    vector<vector<string>> vecData;
    vecData.push_back(input);
    vecData.push_back(input2);
    dao->setAllCourse(vecData);
    ASSERT_EQ(2,dao->getNumberOfCourse());
}

TEST_F(TestTxt, getAllCourse)
{
    vector<vector<string>> vecData;
    vecData.push_back(input);
    vecData.push_back(input2);
    dao->setAllCourse(vecData);
    ASSERT_EQ(vecData,dao->getAllCourse());
}

#endif // TEST_TXT_H
