package com.example.sa_hw.HW2UseCase.UpdateCourse;

public interface UpdateCourseInput {
    String getCourseID();

    void setCourseID(String courseID);

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
