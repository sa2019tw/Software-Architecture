using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.Data;
using Software_Architecture.adapter;

namespace Software_Architecture.usecase.getAllCourses
{
    public interface GetAllCoursesOutput
    {
        DataTable getCourseDataTable();
        void setCourseDataTable(DataTable dt);
        //DataSet getCourseDataSet();
        //void setCourseDataSet(DataSet ds);
        ViewModel getViewModel();
    }
}
