using Software_Architecture.entity;
using Software_Architecture.usecase;
using MySql.Data.MySqlClient;
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
        //public static DataTable dt = new DataTable();

        private MySqlConnection connection(){
            string dbHost = "localhost";
            string dbUser = "root";
            string dbPass = "root";
            string dbName = "Software Architecture";

            string connStr = "server=" + dbHost + ";uid=" + dbUser + ";pwd=" + dbPass + ";database=" + dbName+";charset=utf8;";
            MySqlConnection conn = new MySqlConnection(connStr);
            conn.Open();
            return conn;
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
            
            MySqlCommand command = connection().CreateCommand();
            command.CommandText = "Insert into course(title,description,suitable,price,notice,other) " +"values('" 
                                                                                    + data.getTitle() + "','" 
                                                                                    + data.getDescription() + "','" 
                                                                                    + data.getSuitable() + "','" 
                                                                                    + data.getPrice() + "'" +",'" 
                                                                                    + data.getNotice() + "','" 
                                                                                    + data.getOther() + "')";
            command.ExecuteNonQuery();
            connection().Close();

        }


        public DataTable getAllCourses()
        {
            DataTable dt = new DataTable();
            MySqlCommand command = connection().CreateCommand();
            command.CommandText = "Select * From course";
            MySqlDataAdapter da = new MySqlDataAdapter(command);
            da.Fill(dt);
            return dt;
        }

        public void delete(string title)
        {
            MySqlCommand command = connection().CreateCommand();
            command.CommandText = "Delete From course Where  `title`= '"+ title +"' ";
            command.ExecuteNonQuery();

            connection().Close();
        }


        public Course getCourseByTitle(string title)
        {
            MySqlCommand command = connection().CreateCommand();
            command.CommandText = "select * FROM course WHERE title = '"+ title +"' ";
            
            MySqlDataReader dr = command.ExecuteReader();
            Course course = null;
            CourseData data = new CourseData();
            while (dr.Read()){
                data.setTitle(title);
                data.setDescription(dr["description"].ToString());
                data.setSuitable(dr["suitable"].ToString());
                data.setPrice(dr["price"].ToString());
                data.setNotice(dr["notice"].ToString());
                data.setOther(dr["other"].ToString());
            }
            
            course = courseMapper.CourseDataTransformToCourse(data);

            connection().Close();
            return course;
        }

        public void update(string oldTitle, Course course)
        {
            MySqlCommand command = connection().CreateCommand();
            command.CommandText = "Update course Set title = '"+ course.getTitle()+"', " +
                                        "description = '"+ course.getDescription()+"', " +
                                        "suitable = '"+ course.getSuitable()+"', " +
                                        "price = '"+ course.getPrice() +"', " +
                                        "notice = '"+ course.getNotice() +"', " +
                                        "other = '"+ course.getOther() +"' Where title = '"+ oldTitle +"' ";
            command.ExecuteNonQuery();

            connection().Close();
        }
        
    }
}
