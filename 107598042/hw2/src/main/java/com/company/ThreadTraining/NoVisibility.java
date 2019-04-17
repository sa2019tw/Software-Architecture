package com.company.ThreadTraining;

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
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

public class NoVisibility {

    public static void main(String[] args) throws Exception {
        final BlockingQueue<String> queue = new ArrayBlockingQueue<String>(1);

        final OuterLock outerLock = new OuterLock(queue);



            Thread producer = new Thread(new Runnable() {
                public void run() {
                    for (int i = 0; i < 10; i++) {
//                        try {
//                            System.out.println("Producing product");
//                            queue.put("product");
//                        } catch (InterruptedException e) {
//                            e.printStackTrace();
//                        }
                        outerLock.put("123");
//                            outerLock.blockingCurrentThread();
                    }

                }
            });




            Thread consumer = new Thread(new Runnable() {
                public void run() {
                    for (int i = 0; i < 10; i++) {
                        System.out.println(outerLock.take());
//                        outerLock.wakeUpWaitingThread();
//                        try {
//                            String aaa = queue.take();
//                            System.out.println(aaa + "is get");
//                        } catch (InterruptedException e) {
//                            e.printStackTrace();
//                        }
                    }

                }
            });

            consumer.start();
            producer.start();




        //        final Counter counter = new Counter();
//
//        Thread thread1 = new Thread(new Runnable() {
//            public void run() {
//                for (int i = 0; i < 1000; i++)
//                    counter.increment();
//            }
//        });
//
//        Thread thread2 = new Thread(new Runnable() {
//            public void run() {
//                for (int i = 0; i < 1000; i++)
//                    counter.increment();
//            }
//        });
//
//        thread1.start();
//        thread2.start();
//
//        thread1.join();
//        thread2.join();
//
//        System.out.println(counter.getValue());
    }
}

