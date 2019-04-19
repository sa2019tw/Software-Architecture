package UI;

import Presenter.*;
import UseCase.CourseDTO;
import UseCase.UpdateCourse.UpdateCourseInput;
import UseCase.UseCaseFacade;

public class EditCourseWindow extends FormWindow {
    private UseCaseFacade useCaseFacade;


    public EditCourseWindow(CoursePresenter coursePresenter, UseCaseFacade useCaseFacade) {
        super(coursePresenter);
        this.useCaseFacade = useCaseFacade;
        settingTextFiled();
    }

    @Override
    String actionButtonName() {
        return "Upate";
    }

    @Override
    void invokeAction(CourseInputDTO courseInputDAO) {

        CourseDTO courseDTO = new CourseDTO(courseInputDAO.courseName,
                courseInputDAO.description,
                courseInputDAO.notes,
                courseInputDAO.remark,
                courseInputDAO.suitableObject,
                courseInputDAO.price);

        UpdateCourseInput updateCourseInput = new UpdateCourseInput(courseInputDAO.id, courseDTO);

        useCaseFacade.executeUpdateCourseUseCase(updateCourseInput, coursePresenter);
    }




    public void settingTextFiled() {
        CourseDTO courseDTO = this.coursePresenter.getSelectedCourseDTO();

        courseNameTextField.setText(courseDTO.courseName);
        descriptionArea.setText(courseDTO.description);
        notesTextField.setText(courseDTO.notes);
        remarkTextField.setText(courseDTO.remark);
        suitableObjectTextField.setText(courseDTO.suitableObject);
        priceField.setText(Integer.toString((int)courseDTO.price));
        selectedCourseIdentifier = courseDTO.id;
    }

}
