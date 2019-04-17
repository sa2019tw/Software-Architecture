package com.example.sa_hw.HW2UseCase.CreateCourse;

public interface CreateCourseInput {
    String getCourseName();

    void setCourseName(String courseName);

    String getCourseIntroduction();

    void setCourseIntroduction(String courseIntroduction);

    String getCourseSuitable();

    void setCourseSuitable(String courseSuitable);

    int getCoursePrice();

    void setCoursePrice(int coursePrice);

    String getCourseNotice();

    void setCourseNotice(String courseNotice);

    String getCourseRemark();

    void setCourseRemark(String courseRemark);
}
