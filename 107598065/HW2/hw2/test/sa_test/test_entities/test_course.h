#ifndef TEST_COURSE_H
#define TEST_COURSE_H

#include <gtest/gtest.h>
#include <gmock/gmock-matchers.h>

#include "../../../entities/course.h"
#include <vector>
#include <string>
using namespace std;

class TestCourse: public ::testing::Test
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

      course.createCourse(input);
      course.createCourse(input2);
  }

  void TearDown() override{}

  vector<string> input;
  vector<string> input2;
  Course course;
};

TEST_F(TestCourse, createCourse)
{
    Course * coursePointer = new Course(input);
    ASSERT_EQ(1000,coursePointer->getPrice(1));
    coursePointer->setPrice(1,2000);
    ASSERT_EQ(2000,coursePointer->getPrice(1));
    coursePointer->createCourse(input2);
    ASSERT_EQ("OOAD",coursePointer->getClassName(2));
}

TEST_F(TestCourse, deleteCourse)
{
    ASSERT_EQ(2,course.numberOfCourse());
    course.deleteCourse(1);
    ASSERT_EQ(1,course.numberOfCourse());
}

TEST_F(TestCourse, eidtCourse)
{
    course.editCourse(1,4,"2000");
    ASSERT_EQ(2000,course.getPrice(1));
}

TEST_F(TestCourse, showAllCourse)
{
    vector<string> allCourseName;
    allCourseName.push_back("POSD");
    allCourseName.push_back("OOAD");
    ASSERT_EQ(allCourseName,course.showAllCourse());
}

TEST_F(TestCourse, setAllCourse)
{
    vector<vector<string>> vecData;
    vecData.push_back(input);
    vecData.push_back(input2);
    course.setAllCourse(vecData);
    ASSERT_EQ(2,course.numberOfCourse());
}

#endif // TEST_COURSE_H
