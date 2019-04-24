using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace CourseManageSystem.Dao
{
    interface DaoInterface
    {
        void AddCourse(CourseDTO course);
        List<CourseDTO> ListAllCourse();
        void UpdataCourse(int index, CourseDTO course);
        void DeleteCourse(int index);
    }
}
