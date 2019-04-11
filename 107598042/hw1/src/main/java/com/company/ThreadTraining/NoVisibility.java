package com.company;

import Gateway.PersistenceCourseBase;
import Presenter.Presenter;
import Presenter.ViewModel;
import Presenter.WindowViewLoader;
import UI.CourseTableWindow;
import UseCase.CourseManageUseCase;

import javax.swing.*;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.OutputStream;
import java.util.Properties;

public class NoVisibility {





    public static void main(String[] args) throws Exception {
        Properties properties = new Properties();

        properties.load(new FileInputStream("config.properties"));

        System.out.println(properties.getProperty("AAA"));
    }


}

