using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.Data;
using System.Windows.Forms;

namespace CourseManageSystem.Controller
{
    class Controller
    {
        public Controller()
        {
            _usecases = new UseCases.ControllerUseCases();
        }

        public DataTable GetDataTable()
        {
            return _usecases.ListAll();
        }

        public void AddCourse(String name, String description, String objective, String price, String caution, String remarks)
        {
            UseCases.CourseInput courseInput = new UseCases.CourseInput(name, description, objective, price, caution, remarks);
            _usecases.AddCourse(courseInput);
        }

        public void DeleteCourse(int index)
        {
            _usecases.DeleteCourse(index);
        }

        public void UpdateCourse(int index , String name, String description, String objective, String price, String caution, String remarks)
        {
            UseCases.CourseInput courseInput = new UseCases.CourseInput(name, description, objective, price, caution, remarks);
            _usecases.UpdateCourse(index, courseInput);
        }

        private UseCases.ControllerUseCases _usecases;
    }
}
