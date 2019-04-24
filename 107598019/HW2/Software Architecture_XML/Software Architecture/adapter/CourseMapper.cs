using Software_Architecture.entity;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Software_Architecture.adapter
{
    public class CourseMapper
    {
        public CourseData CourseTransformToCourseData(Course course){
            CourseData data = new CourseData();
            data.setTitle(course.getTitle());
            data.setDescription(course.getDescription());
            data.setSuitable(course.getSuitable());
            data.setPrice(course.getPrice());
            data.setNotice(course.getNotice());
            data.setOther(course.getOther());
            return data;
        }

        public Course CourseDataTransformToCourse(CourseData courseData) {
            Course course = new Course();
            course.setTitle(courseData.getTitle());
            course.setDescription(courseData.getDescription());
            course.setSuitable(courseData.getSuitable());
            course.setPrice(courseData.getPrice());
            course.setNotice(courseData.getNotice());
            course.setOther(courseData.getOther());
            return course;
        }

    }
}
