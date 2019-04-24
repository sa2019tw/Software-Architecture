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
        //private DataSet dataSet;
        private ViewModel vm = new ViewModel();

        public DataTable getCourseDataTable()
        {
            return dataTable;
        }

        public void setCourseDataTable(DataTable dt)
        {
            this.dataTable = dt;
            vm.setDataTable(dt);
        }

        public ViewModel getViewModel()
        {
            return vm;
        }

        /*public DataSet getCourseDataSet()
        {
            return dataSet;
        }

        public void setCourseDataSet(DataSet ds)
        {
            this.dataSet = ds;
            vm.setDataSet(ds);
        }*/
    }
}
