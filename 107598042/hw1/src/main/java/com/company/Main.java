package com.company;

import Gateway.InMemoryCourseBase;
import Gateway.PersistenceCourseBase;
import Presenter.*;
import UI.CourseTableWindow;
import UseCase.CourseManageUseCase;
import javax.swing.*;

public class Main {
    Presenter presenter;
    CourseTableWindow ui;

    public static void main(String[] args) throws Exception {
        Main main = new Main();
    }

    Main() throws Exception {
        initializePresenter();
        startCourseApplication();
    }

    void initializePresenter() {
        presenter = new Presenter(new CourseManageUseCase(new PersistenceCourseBase()));
        presenter.setViewModel(new ViewModel());
        presenter.setViewLoader(new WindowViewLoader());
    }

    public void startCourseApplication() throws Exception {
        SwingUtilities.invokeAndWait(new Runnable() {
            public void run() {
                ui = new CourseTableWindow(presenter);
            }});
    }
}

