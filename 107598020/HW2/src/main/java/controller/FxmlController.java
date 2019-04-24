package controller;

import com.google.inject.Inject;
import javafx.scene.control.TextArea;
import usecase.CourseCommand;
import usecase.courseCommandFactory.CourseCommandFactory;
import usecase.output.OutputBoundary;

import java.util.List;

public class FxmlController {
    @Inject
    private CourseCommandFactory commandFactory;

    private OutputBoundary presenter = new Presenter();
    private CourseViewObjectMapper mapper = new CourseViewObjectMapper();
    private CourseViewObject target = null;
    private int mode = -1;

    public FxmlController() {
    }

    public List<CourseViewObject> getCourseList() throws Exception {
        CourseCommand command = commandFactory.createGetAllCourseCommand(presenter);
        command.execute();

        return mapper.mappingToCourseViewObject(presenter.getAllCourses());
    }

    public void setTargetCourse(CourseViewObject targetCourse) {
        this.target = targetCourse;
    }

    public boolean isNoTarget() {
        return target == null;
    }

    public CourseViewObject getTargetCourse() {
        return target;
    }

    public int getMode() {
        return mode;
    }

    public void setMode(int mode) {
        this.mode = mode;
    }

    public void updateCourse(List<TextArea> textAreas) throws Exception {
        CourseViewObject courseViewObject = generateNewCourseViewObject(textAreas);
        CourseCommand command = commandFactory.createModifyCourseCommand(mapper.mappingToCourseDTO(courseViewObject), presenter);
        command.execute();
    }

    private CourseViewObject generateNewCourseViewObject(List<TextArea> textAreas) {
        return new CourseViewObject(target.getId(),
                                    textAreas.get(0).getText(),
                                    textAreas.get(1).getText(),
                                    textAreas.get(2).getText(),
                                    transferToInteger(textAreas.get(3).getText()),
                                    textAreas.get(4).getText(),
                                    textAreas.get(5).getText()
                                    );
    }

    public void addCourse(List<TextArea> textAreas) throws Exception {
        CourseViewObject courseViewObject = generateNewCourseViewObject(textAreas);
        CourseCommand command = commandFactory.createCreateCourseCommand(mapper.mappingToCourseDTO(courseViewObject), presenter);
        command.execute();
    }

    public void deleteCourse() throws Exception {
        CourseCommand command = commandFactory.createDeleteCourseCommand(mapper.mappingToCourseDTO(target), presenter);
        command.execute();
    }

    public boolean isEmptyString(String text) {
        text.replaceAll("\\n|\\r|\\t", "");
        return text.equalsIgnoreCase("");
    }

    public boolean isNumberLegal(String text) {
        if (text.length() > 0)
            return isPositiveNumeric(text);
        return true;
    }

    private boolean isPositiveNumeric(String str) {
        try {
            double num = Double.parseDouble(str);
            return (num >= 0) ? true : false;
        } catch(NumberFormatException e){
            return false;
        }
    }

    private int transferToInteger(String text) {
        if (text.length() > 0)
            return Integer.valueOf(text);
        return 0;
    }
}
