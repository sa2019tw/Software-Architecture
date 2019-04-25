package delivery;

import java.util.List;

public class GetAllCourseResponseModel extends AbstractResponseModel {
    private List<ObservableCourse> courses;

    private GetAllCourseResponseModel(List<ObservableCourse> courses, boolean isError, String message) {
        super(isError, message);
        this.courses = courses;
    }

    public static GetAllCourseResponseModel getResultModel(List<ObservableCourse> courses) {
        return new GetAllCourseResponseModel(courses, false, "");
    }

    public static GetAllCourseResponseModel getErrorModel(String message) {
        return new GetAllCourseResponseModel(null, true, message);
    }

    public List<ObservableCourse> getCourseList() {
        return courses;
    }
}
