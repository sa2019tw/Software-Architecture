package com.company;

import Gateway.PersistenceCourseBase;
import Presenter.*;

import UI.CourseTableWindow;
import UseCase.UseCaseFacade;

import javax.swing.*;

public class Main {
    CoursePresenter presenter;
    CourseTableWindow ui;
    UseCaseFacade useCaseFacade;

    public static void main(String[] args) throws Exception {
        Main main = new Main();
    }

    Main() throws Exception {
        initializePresenter();
        initializeUseCaseFacade();
        startCourseApplication();
    }

    private void initializeUseCaseFacade() {
        this.useCaseFacade = new UseCaseFacade(new PersistenceCourseBase());
    }

    void initializePresenter() {
        presenter = new CoursePresenter(new WindowViewLoader());
    }

    public void startCourseApplication() throws Exception {
        SwingUtilities.invokeAndWait(new Runnable() {
            public void run() {
                ui = new CourseTableWindow(presenter, useCaseFacade);
            }});
    }
}

