using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.Data;

namespace Software_Architecture.usecase.getAllCourses
{
    public interface GetAllCoursesOutput
    {
        DataTable getCourseDataTable();
        void setCourseDataTable(DataTable dt);
    }
}
