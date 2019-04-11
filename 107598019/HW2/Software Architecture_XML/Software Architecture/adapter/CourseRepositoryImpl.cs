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
        private DataHelper dataHelper = DataHelper.getInstance();
        private CourseMapper courseMapper = new CourseMapper();
        string path = System.Environment.CurrentDirectory + "\\" + "course.xml";

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
            DataHelper.courseTable.Rows.Add(_course);
            DataSet ds = new DataSet("course");
            ds.Tables.Add(DataHelper.courseTable.Copy());
            ds.WriteXml(@path);
        }
        
        public DataTable getAllCourses() {
            return DataHelper.courseTable;
        }

        public void update(string oldTitle, Course course) {
            CourseData data = courseMapper.CourseTransformToCourseData(course);

            DataRow[] _course = DataHelper.courseTable.Select("課程名稱 ='" + oldTitle + "'");
                
            foreach (DataRow row in _course)
            {
                row["課程名稱"] = data.getTitle(); 
                row["課程說明"] = data.getDescription();
                row["適合對象"] = data.getSuitable();
                row["定價"] = data.getPrice();
                row["注意事項"] = data.getNotice();
                row["備註"] = data.getOther();
            }

            DataSet ds = new DataSet("course");
            ds.Tables.Add(DataHelper.courseTable.Copy());
            ds.WriteXml(@path);
        }

        public void delete(string title) {
            DataRow[] _course = DataHelper.courseTable.Select("課程名稱 ='" + title + "'");

            foreach (DataRow row in _course)
            {
                row.Delete();
            }

            DataSet ds = new DataSet("course");
            ds.Tables.Add(DataHelper.courseTable.Copy());
            ds.WriteXml(@path);
        }

        public Course getCourseByTitle(string title) {
            DataRow[] selectedCourse = DataHelper.courseTable.Select("課程名稱 ='" + title + "'");
            Course course = null;
            CourseData data = new CourseData();
           
            foreach (DataRow row in selectedCourse)
            {
                data.setTitle(row["課程名稱"].ToString());
                data.setDescription(row["課程說明"].ToString());
                data.setSuitable(row["適合對象"].ToString());
                data.setPrice(row["定價"].ToString());
                data.setNotice(row["注意事項"].ToString());
                data.setOther(row["備註"].ToString());
            }

            course = courseMapper.CourseDataTransformToCourse(data);

            return course;
        }
    }
}
