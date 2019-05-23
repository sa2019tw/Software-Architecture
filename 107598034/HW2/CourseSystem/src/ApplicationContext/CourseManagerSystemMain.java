package ApplicationContext;

import java.io.IOException;

import CourseManagerSystemUI.CourseManagerSystemFrame;

public class CourseManagerSystemMain {

	public static void main(String[] args) throws IOException {
		CourseManagerSystemFrame courseManagerSystemFrame = new CourseManagerSystemFrame();
		courseManagerSystemFrame.setSize(1000,600);
		courseManagerSystemFrame.setVisible(true);
	}
}
