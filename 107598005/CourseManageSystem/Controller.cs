using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.Data;
using System.Windows.Forms;

namespace CourseManageSystem
{
    class Controller
    {
        public Controller()
        {
            _usecases = new usecases.ControllerUseCases();
            _dataTable = _usecases.ListAll();
        }

        public DataTable getDataTable()
        {
            return _dataTable;
        }

        public void addCourse(int index)
        {
            _dataTable.Rows.Add("", "", "", "", "", "");
        }

        public void setCourseDataName(int index, String Name)
        {
            _dataTable.Rows[index]["Name"] = Name;
        }

        public void deleteCourse(int index)
        {
            _dataTable.Rows.RemoveAt(index);
        }

        public void updateModel()
        {
            _usecases.Update(_dataTable);
        }

        private DataTable _dataTable;
        private usecases.ControllerUseCases _usecases;
    }
}
