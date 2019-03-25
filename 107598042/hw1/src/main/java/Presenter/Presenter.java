package Presenter;

import Domain.OutputBoundary.OutputBoundary;
import UseCase.CourseDTO;
import UseCase.CourseManageUseCase;

import java.util.ArrayList;
import java.util.Collection;

public class Presenter implements OutputBoundary {
    private Collection<CourseDTO> courseDTOCollection = new ArrayList<CourseDTO>();
    CourseDTO selectedCourseDTO;

    // dependency
    private CourseManageUseCase useCase;

    private ViewModel viewModel;
    // notification
    private CourseTableView courseTableView;
    private ViewLoader viewLoader;

    public Presenter(CourseManageUseCase courseCRUDUseCase) {

        this.useCase = courseCRUDUseCase;
        this.useCase.setOutputBoundary(this);
    }

    public void setViewLoader(ViewLoader viewLoader) {
        this.viewLoader = viewLoader;
    }

    public void setView(CourseTableView courseTableView) {
        this.courseTableView = courseTableView;
    }

    public CourseDTO getSelectedCourseDTO() {
        return selectedCourseDTO;
    }


    public void updateCourseTableView() {
        if (this.courseTableView == null)
            return;

        this.courseTableView.updateTableView(this.viewModel);
    }

    public void createNewCourse(CourseInputDTO courseInputDAO) {
        this.useCase.createCourse(courseInputDAO);

        this.buildTableViewModel();

        this.updateCourseTableView();
    }

    public void modifyCourse(CourseInputDTO modifiyCourseInputDAO) {
        this.useCase.modifyCourse(modifiyCourseInputDAO);

        this.buildTableViewModel();

        this.updateCourseTableView();
    }

    public void fetchCourseById(int identifier) {
        CourseDTO courseDTO = this.useCase.fetchCourseById(identifier);
        setCourseDTO(courseDTO);

        this.buildTableViewModel();

        this.updateCourseTableView();
    }

    public void deleteCourse(int identifier) {
        this.useCase.deleteCourseById(identifier);

        this.buildTableViewModel();

        this.updateCourseTableView();
    }


    public void fetchAllCourse() {
        System.out.println("123");
        this.useCase.fetchAllCourses();

        this.buildTableViewModel();

        this.updateCourseTableView();
    }


    public void buildTableViewModel() {
        if (viewModel == null)
            return;

        this.viewModel.setCourseCollection(this.getCourseDTOCollection());
        this.viewModel.setSelectedCourseDTO(this.selectedCourseDTO);
    }

    @Override
    public void setCourseDTOCollection(Collection<CourseDTO> courseDTOCollection) {
        this.courseDTOCollection = courseDTOCollection;
    }

    @Override
    public void setCourseDTO(CourseDTO courseDTO) {
        this.selectedCourseDTO = courseDTO;
    }

    public void setViewModel(ViewModel viewModel) {
        this.viewModel = viewModel;
    }

    public void selectCourseDTOByRowIndex(int rowIndex) {
        if (this.getCourseDTOCollection().size() == 0 || rowIndex >= this.getCourseDTOCollection().size())
            return;

        this.selectedCourseDTO = ((ArrayList<CourseDTO>) this.getCourseDTOCollection()).get(rowIndex);
    }

    public void invokedOpenAddCourseWindow() {
        this.viewLoader.createAddCourseWindow(this);
    }

    public void invokedOpenEditCourseWindowGiven(int selectedRowIndex) {
        this.selectCourseDTOByRowIndex(selectedRowIndex);
        this.viewLoader.createEditCourseWindow(this);
    }

    public Collection<CourseDTO> getCourseDTOCollection() {
        return courseDTOCollection;
    }

}
