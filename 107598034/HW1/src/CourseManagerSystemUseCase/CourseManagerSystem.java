package CourseManagerSystemUseCase;

import java.io.FileWriter;
import java.io.IOException;
import java.util.Map;
import java.util.TreeMap;

import org.json.JSONArray;
import org.json.JSONObject;

import entities.Courses;

public class CourseManagerSystem {

	private Map<String, Courses> courseMap = new TreeMap<String, Courses>();

	public CourseManagerSystem() {}

	public Map<String, Courses> addNewCourse(Courses c) {
		if(!courseMap.containsKey(c.getCourseName())) {
			courseMap.put(c.getCourseName(), c);
		}	
		return courseMap;
	}

	public Map<String, Courses> loadJsonFileToCourseMap(String input) throws IOException {
		JSONArray courseJson;
		if (input == "[]") return null;
		courseJson = new JSONArray(input);
		jsonDataTransferToCourseData(courseJson);
		return courseMap;
	}
	
 	public Map<String, Courses> deleteCourse(String courseName) {
		if (courseMap.isEmpty())
			return null;
		if (courseMap.containsKey(courseName)) {
			courseMap.remove(courseName);
			if (courseMap.isEmpty()) {
				return null;
			} else {
				return courseMap;
			}
		}
		return null;
	}

	public void saveCourseToFile() throws IOException {
		JSONArray courseJson = new JSONArray();
		courseJson = mapTransferToJsonData(courseMap);
		try (FileWriter file = new FileWriter("src/courseList")) {
			file.write(courseJson.toString());
			System.out.println("Successfully Copied JSON Object to File...");
		}
	}
	
	public Map<String, Courses> editCourse(Courses c) {
		if(courseMap.containsKey(c.getCourseName())) {
			courseMap.put(c.getCourseName(), c);
			return courseMap;
		}else return null;
	}
	
	private void jsonDataTransferToCourseData(JSONArray courseJson) {
		for (int i = 0; i < courseJson.length(); i++) {
			JSONObject jsonOb = courseJson.getJSONObject(i);
			String _courseName = jsonOb.getString("courseName");
			String _courseDiscription = jsonOb.getString("courseDescription");
			String _suitable = jsonOb.getString("suitable");
			int _price = jsonOb.getInt("price");
			String _precautions = jsonOb.getString("precautions");
			String _note = jsonOb.getString("note");
			Courses c = new Courses(_courseName, _courseDiscription, _suitable, _price, _precautions, _note);
			courseMap.put(c.getCourseName(), c);
		}
	}
	
	private JSONArray mapTransferToJsonData(Map<String, Courses> courseMap) {
		JSONArray courseJson = new JSONArray();
		for(Map.Entry<String, Courses> entry : courseMap.entrySet()) {
			JSONObject courseObj = new JSONObject();
		    Courses c = entry.getValue();
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
	
	public int size() {
		return courseMap.size();
	}
}
