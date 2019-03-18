using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Data;
using System.Threading.Tasks;

namespace CourseManageSystem.usecases
{
    class ControllerUseCases
    {
        public ControllerUseCases()
        {
            _courseData = new CourseData("../../coursedata.xml");
        }

        public DataTable ListAll()
        {
            return _courseData.getDataTable();
        }

        public void Update(DataTable _dataTable)
        {
            _courseData.saveDataTable(_dataTable);
        }

        private CourseData _courseData;
    }
}
