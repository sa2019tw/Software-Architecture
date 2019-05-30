package Adapter.Controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import Entity.Course;

public class ClassDataMapper {
	String[] tableDataItems = {"課程編號", "課程名稱", "課程說明", "適合對象", "定價", "注意事項", "備註"};
	
	public List<CourseData> transfromCourseData(Object[] courseData) {
		List<CourseData> courseMap = new ArrayList<>();
			courseMap.add(new CourseData(courseData[0].toString(), 
									      courseData[1].toString(), 
													   courseData[2].toString(), 
													   courseData[3].toString(), 
													   parseWithDefault(courseData[4].toString(), 0), 
													   courseData[5].toString(), 
													   courseData[6].toString()));
		return courseMap;
	}
	
	public Object[][] showCourseTable(Map<String, Course> courseMap) {
		Object[][] tableData = new Object[courseMap.keySet().size()][tableDataItems.length];
	int index = 0;
	for (String key : courseMap.keySet()) {
	    Course course = courseMap.get(key);
	    tableData[index][0] = course.getCourseId();
	    tableData[index][1] = course.getCourseName();
	    tableData[index][2] = course.getCourseDescription();
	    tableData[index][3] = course.getSuitable();
	    tableData[index][4] = course.getPrice();
	    tableData[index][5] = course.getPrecautions();
	    tableData[index][6] = course.getNote();
	    index++;
		}
	return tableData;
	}
	
	private int parseWithDefault(String s, int def) {
	    try {
	        return Integer.parseInt(s);
	    }
	    catch (NumberFormatException e) {
	        // It's OK to ignore "e" here because returning a default value is the documented behaviour on invalid input.
	        return def;
	    }
	}

}
