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

    public CourseDTO(String courseName, String description, String notes, String remark, String suitableObject, int price) {
        this.courseName = courseName;
        this.description = description;
        this.notes = notes;
        this.remark = remark;
        this.suitableObject = suitableObject;
        this.price = price;
    }

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
