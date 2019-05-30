package Adapter.Repository;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Map;
import java.util.TreeMap;

import org.json.JSONArray;
import org.json.JSONObject;

import CourseUseCase.CourseRepository;
import Entity.Course;

public class InJsonCourseRepository implements CourseRepository {
	
	private Map<String, Course> courseMap = new TreeMap<String, Course>();
	
	public InJsonCourseRepository() {
		courseMap = loadJsonFileToCourseMap();
	}
	
	private Map<String, Course> loadJsonFileToCourseMap() {
		FileReader fr = null;
		String readLine = null;
		BufferedReader br = null;
		JSONArray courseJson;
		try {
			fr = new FileReader("src/courseList");
			br = new BufferedReader(fr);
			readLine = br.readLine();
		}catch (IOException e) {
			e.printStackTrace();
		} 
		if (readLine == "[]") return null;
		courseJson = new JSONArray(readLine);
		jsonDataTransferToCourseData(courseJson);
		return courseMap;
	}
	
	private void saveCourseToFile() {
		JSONArray courseJson = new JSONArray();
		courseJson = mapTransferToJsonData(courseMap);
		try (FileWriter file = new FileWriter("src/courseList")) {
			file.write(courseJson.toString());
			System.out.println("Successfully Copied JSON Object to File...");
			file.close();
		} catch(Exception e) {
			System.out.println("發生了" + e + "例外");
		}
		
	}

	@Override
	public void addNewCourse(Course course) {
		courseMap.put(course.getCourseId(), course);
		saveCourseToFile();
	}

	@Override
	public void editCourse(Course course) {
		if(courseMap.containsKey(course.getCourseId())) {
			courseMap.put(course.getCourseId(), course);
		}
		saveCourseToFile();
	}

	@Override
	public void deleteCourse(String courseId) {
		if (courseMap.isEmpty())
			return;
		if(courseMap.containsKey(courseId)) {
			courseMap.remove(courseId);
		}
		saveCourseToFile();
	}

	@Override
	public Map<String, Course> getAllCourse() {
		return courseMap;
	}

	private void jsonDataTransferToCourseData(JSONArray courseJson) {
		for (int i = 0; i < courseJson.length(); i++) {
			JSONObject jsonOb = courseJson.getJSONObject(i);
			String _courseId = jsonOb.getString("courseId");
			String _courseName = jsonOb.getString("courseName");
			String _courseDiscription = jsonOb.getString("courseDescription");
			String _suitable = jsonOb.getString("suitable");
			int _price = jsonOb.getInt("price");
			String _precautions = jsonOb.getString("precautions");
			String _note = jsonOb.getString("note");
			Course c = new Course(_courseId, _courseName, _courseDiscription, _suitable, _price, _precautions, _note);
			courseMap.put(c.getCourseId(), c);
		}
	}

	private JSONArray mapTransferToJsonData(Map<String, Course> courseMap) {
		JSONArray courseJson = new JSONArray();
		for(Map.Entry<String, Course> entry : courseMap.entrySet()) {
			JSONObject courseObj = new JSONObject();
		    Course c = entry.getValue();
		    courseObj.put("courseId", c.getCourseId());
		    courseObj.put("courseName", c.getCourseName());
		    courseObj.put("courseDescription", c.getCourseDescription());
		    courseObj.put("suitable", c.getSuitable());
		    courseObj.put("price", c.getPrice());
		    courseObj.put("precautions", c.getPrecautions());
		    courseObj.put("note", c.getNote());
		    courseJson.put(courseObj);
		}
		return courseJson;
	}
}
