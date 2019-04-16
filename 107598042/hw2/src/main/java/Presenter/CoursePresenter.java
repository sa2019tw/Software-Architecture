package Presenter;

import UseCase.CourseDTO;
import UseCase.*;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class CoursePresenter extends CourseOutput {
    // notification
    private CourseTableView courseTableView;
    private ViewModel viewModel = new ViewModel();
    private ViewLoader viewLoader;

    public CoursePresenter(CourseTableView view) {
        this.courseTableView = view;
    }

    public void registerView(CourseTableView courseTableView) {
        this.courseTableView = courseTableView;
    }

    public CoursePresenter(ViewLoader viewLoader) {
        this.viewLoader = viewLoader;
    }

    public void updateView() {
        if (this.courseTableView == null)
            return;

        this.courseTableView.updateTableView(viewModel);
    }

    public List<Object[]> convertCourseDTOToTableContents() {
        Iterator<CourseDTO> courseDTOIterator =  this.getCourseDTOList().iterator();

        List<Object[]> tableContents = new ArrayList<Object[]>();
        while (courseDTOIterator.hasNext()) {
            CourseDTO courseDTO = courseDTOIterator.next();
            Object[] content = new Object[] { courseDTO.id, courseDTO.courseName, courseDTO.description,
                    courseDTO.notes, courseDTO.remark, courseDTO.suitableObject,
                    courseDTO.price};
            tableContents.add(content);
        }
        return tableContents;
    }

    public void buildViewModel() {
        viewModel.setTableContent(convertCourseDTOToTableContents());
    }

    public ViewModel getViewModel() {
        return viewModel;
    }

    @Override
    public void setCourseDTOList(List<CourseDTO> courseDTOList) {
        super.setCourseDTOList(courseDTOList);

        buildViewModel();

        updateView();
    }


    @Override
    public void setCourseDTO(CourseDTO courseDTO) {
        super.setCourseDTO(courseDTO);

        buildViewModel();

        updateView();
    }

    public void invokedOpenAddCourseWindow(UseCaseFacade useCaseFacade) {
        this.viewLoader.createAddCourseWindow(this, useCaseFacade);
    }

    public void invokedOpenEditCourseWindowGiven(int selectedRowIndex, UseCaseFacade useCaseFacade) {
        this.viewLoader.createEditCourseWindow(this, useCaseFacade);
    }
}

