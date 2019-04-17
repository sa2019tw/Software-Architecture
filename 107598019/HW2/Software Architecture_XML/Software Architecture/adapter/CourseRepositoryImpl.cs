using Software_Architecture.entity;
using Software_Architecture.usecase;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.Data;
using System.Windows.Forms;

namespace Software_Architecture.adapter
{
    public class CourseRepositoryImpl : CourseRepository
    {
        private CourseMapper courseMapper = new CourseMapper();
        string path = System.Environment.CurrentDirectory + "\\" + "course.xml";

        public DataTable readAllCourse()
        {
            DataTable courseTable = new DataTable();
            courseTable.Columns.Add("Title", typeof(System.String));
            courseTable.Columns.Add("Description", typeof(System.String));
            courseTable.Columns.Add("Suitable", typeof(System.String));
            courseTable.Columns.Add("Price", typeof(System.String));
            courseTable.Columns.Add("Notice", typeof(System.String));
            courseTable.Columns.Add("Other", typeof(System.String));

            DataSet ds = new DataSet("course");
            ds.ReadXml(@path);
            if(ds.Tables.Count!=0)
                courseTable = ds.Tables[0];

            return courseTable;
        }

        public void create(Course course) {
            CourseData data = courseMapper.CourseTransformToCourseData(course);

            string[] _course = {
                data.getTitle(),
                data.getDescription(),
                data.getSuitable(),
                data.getPrice(),
                data.getNotice(),
                data.getOther()
            };
            DataTable dt = readAllCourse();
            dt.Rows.Add(_course);
            DataSet ds = new DataSet("course");
            ds.Tables.Add(dt.Copy());
            ds.WriteXml(@path);
        }
        
        public DataTable getAllCourses() {
            DataTable dt = readAllCourse();
            return dt;
        }

        public void update(string oldTitle, Course course) {
            CourseData data = courseMapper.CourseTransformToCourseData(course);
            DataTable dt = readAllCourse();
            DataRow[] _course = dt.Select("Title ='" + oldTitle + "'");
                
            foreach (DataRow row in _course)
            {
                row["Title"] = data.getTitle(); 
                row["Description"] = data.getDescription();
                row["Suitable"] = data.getSuitable();
                row["Price"] = data.getPrice();
                row["Notice"] = data.getNotice();
                row["Other"] = data.getOther();
            }

            DataSet ds = new DataSet("course");
            ds.Tables.Add(dt.Copy());
            ds.WriteXml(@path);
        }

        public void delete(string title) {
            DataTable dt = readAllCourse();
            DataRow[] _course = dt.Select("Title ='" + title + "'");

            foreach (DataRow row in _course)
            {
                row.Delete();
            }

            DataSet ds = new DataSet("course");
            ds.Tables.Add(dt.Copy());
            ds.WriteXml(@path);
        }

        public Course getCourseByTitle(string title) {
            DataTable dt = readAllCourse();
            DataRow[] selectedCourse = dt.Select("Title ='" + title + "'");
            Course course = null;
            CourseData data = new CourseData();
           
            foreach (DataRow row in selectedCourse)
            {
                data.setTitle(row["Title"].ToString());
                data.setDescription(row["Description"].ToString());
                data.setSuitable(row["Suitable"].ToString());
                data.setPrice(row["Price"].ToString());
                data.setNotice(row["Notice"].ToString());
                data.setOther(row["Other"].ToString());
            }

            course = courseMapper.CourseDataTransformToCourse(data);

            return course;
        }
    }
}
