using Software_Architecture.usecase.getAllCourses;
using System;
using System.Collections.Generic;
using System.Data;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Software_Architecture.adapter.presenter
{
    public class GetAllCoursesPresenter : GetAllCoursesOutput
    {
        private DataTable dataTable;

        public DataTable getCourseDataTable()
        {
            return dataTable;
        }

        public void setCourseDataTable(DataTable dt)
        {
            this.dataTable = dt;
        }
    }
}
