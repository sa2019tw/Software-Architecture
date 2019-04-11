using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace CourseManageSystem.Dao
{
    interface DaoInterface
    {
        void AddCourse(Course course);
        List<Course> ListAllCourse();
        void UpdataCourse(int index, Course course);
        void DeleteCourse(int index);
    }
}
