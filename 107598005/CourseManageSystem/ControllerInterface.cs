using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.Data;
using System.Windows.Forms;

namespace CourseManageSystem
{
    interface ControllerInterface
    {
        DataTable getDataTable();
        void addCourse(int index);
        void deleteCourse(int index);
        void setCourseDataName(int index, String Name);
        void updateModel();
        void moveBindingData(int index);
        int bindingDataPosition();
    }
}
