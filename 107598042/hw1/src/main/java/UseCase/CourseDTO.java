package UseCase;

import Domain.Course;

public class CourseDTO {
    public String courseName = "";
    public String description = "";
    public String notes = "";
    public String remark = "";
    public String suitableObject = "";
    public double price = 0;
    public int id;

    public CourseDTO() {

    }

//
//    public CourseDTO(Course course) {
//        if (course == null)
//            return;
//
//
//        courseName = course.getCourseName();
//        description = course.getDescription();
//        notes = course.getNotes();
//        remark = course.getRemark();
//        suitableObject = course.getSuitableObject();
//        price = course.getPrice();
//        id = course.getId();
//    }


    @Override
    public String toString() {
        String courseInfo = "Course Name: " + this.courseName;
        courseInfo += "\nDescription: " + this.description;
        courseInfo += "\nPrice: " + this.price;
        courseInfo += "\nNotes: " + this.notes;
        courseInfo += "\nRemark: " + this.remark;
        courseInfo += "\nSuitableObject: " + this.suitableObject;
        courseInfo += "\nId: " + this.id;
        return courseInfo;
    }


    @Override
    public boolean equals(Object obj) {
        if (this.getClass() != obj.getClass()) return false;
        CourseDTO course = (CourseDTO) obj;

        return  this.courseName.equals(course.courseName) &&
                this.description.equals(course.description) &&
                this.notes.equals(course.notes) &&
                this.remark.equals(course.remark) &&
                this.suitableObject.equals(course.suitableObject) &&
                this.price == (course.price);
    }



}
