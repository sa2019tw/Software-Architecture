using Software_Architecture.entity;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.Data;

namespace Software_Architecture.usecase
{
    public interface CourseRepository
    {
        void create(Course course);
        DataTable getAllCourses();
        void update(string oldTitle, Course course);
        void delete(string title);
        Course getCourseByTitle(string title);
    }
}
