package CoureseManagerSystemUnitTest;

import static org.junit.Assert.*;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Map;
import java.util.TreeMap;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import CourseManagerSystemUseCase.CourseManagerSystem;
import entities.Courses;

public class TestCourseManagerSystem {
	
	private CourseManagerSystem courseManager = new CourseManagerSystem();
	Map<String, Courses> courseList = new TreeMap<String, Courses>();
	
	@Before
	public void setUp() throws Exception {
		FileReader fr = new FileReader("src/courseList");
		BufferedReader br = new BufferedReader(fr);
		String reanLine = br.readLine();
		courseList = courseManager.loadJsonFileToCourseMap(reanLine);
		courseManager.saveCourseToFile();
		br.close();
	}
	
	@After
	public void tearDown() throws Exception {
		PrintWriter pw = new PrintWriter("src/courseList");
		pw.print("");
		pw.close();
		Courses c1 = new Courses("Software Architecture", 
				"1.Software architecture-overview 2.Client-Server 3.Model-view-controller 4.n-Tier design 5.Peer-to-peer 6.Pattern-oriented software architecture 7.Special Topics:pipes and filter"
				, "ntut csie student", 
				1234, 
				"do not use smart phone", 
				"don't later");
		Courses c2 = new Courses("Algorithm", 
				"1.Time complex 2.Sort 3.Dynamic programming", 
				"ntut csie student", 
				1234, 
				"", 
				""
				);
		
		courseManager.addNewCourse(c1);
		courseManager.saveCourseToFile();
		courseManager.addNewCourse(c2);
		courseManager.saveCourseToFile();
	}
	
	@Test
	public void Load_Courses_By_LoadCourse_CourseSize_Should_Be_Match_Count() throws IOException {
		assertEquals(3, courseManager.size());
	}

	@Test
	public void Add_New_Course_By_AddNewCourse_CourseSize_Should_be_CountPlus() {
		Courses c = new Courses("sa", "" , "", 0, "" , "");
		courseManager.addNewCourse(c);
		try {
			courseManager.saveCourseToFile();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		assertEquals(3, courseManager.size());
	}
	
	@Test
	public void Delete_Course_By_DeleteCourse_CourseSize_Should_Be_Sub_One() {
		courseManager.deleteCourse("sa");
		try {
			courseManager.saveCourseToFile();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		assertEquals(2, courseManager.size());
	}
	
	@Test
	public void Edit_Course_By_EditCourse_Should_Be_Return_Course() {
		courseList.get("Software Architecture").setNote("Don't Sleep");
		courseManager.editCourse(courseList.get("Software Architecture"));
		try {
			courseManager.saveCourseToFile();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		assertEquals("Don't Sleep", courseList.get("Software Architecture").getNote());
	}

}
