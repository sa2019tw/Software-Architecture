package Presenter;

import UI.AddCourseWindow;
import UI.EditCourseWindow;

public class WindowViewLoader implements ViewLoader {

    private AddCourseWindow addCourseWindow;
    private EditCourseWindow editCourseWindow;

    @Override
    public void createAddCourseWindow(Presenter presenter) {
        addCourseWindow = new AddCourseWindow(presenter);
    }

    @Override
    public void createEditCourseWindow(Presenter presenter) {
        editCourseWindow = new EditCourseWindow(presenter);
    }

    public AddCourseWindow getAddCourseWindow() {
        return addCourseWindow;
    }

    public void setAddCourseWindow(AddCourseWindow addCourseWindow) {
        this.addCourseWindow = addCourseWindow;
    }

    public EditCourseWindow getEditCourseWindow() {
        return editCourseWindow;
    }

    public void setEditCourseWindow(EditCourseWindow editCourseWindow) {
        this.editCourseWindow = editCourseWindow;
    }
}
