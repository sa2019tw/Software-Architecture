using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Data;
using System.Threading.Tasks;

namespace CourseManageSystem.UseCases
{
    class CRUDUseCases
    {
        public CRUDUseCases()
        {
            _courseDao = new Dao.XmlFileDao("../../coursedata.xml");
        }

        public DataTable ListAll()
        {
            DataTable dataTable = new DataTable();
            dataTable.Columns.Add("Name");
            dataTable.Columns.Add("Description");
            dataTable.Columns.Add("Objective");
            dataTable.Columns.Add("Price");
            dataTable.Columns.Add("Cautions");
            dataTable.Columns.Add("Remarks");

            foreach (Course course in _courseDao.ListAllCourse())
            {
                DataRow newRow = dataTable.NewRow();
                newRow["Name"] = course.Name;
                newRow["Description"] = course.Description;
                newRow["Objective"] = course.Objective;
                newRow["Price"] = course.Price;
                newRow["Cautions"] = course.Caution;
                newRow["Remarks"] = course.Remarks;
                dataTable.Rows.Add(newRow);
            }

            return dataTable;
        }

        public void UpdateCourse(int index, CourseInput courseInput)
        {
            Course course = new Course(courseInput.Name,
                                               courseInput.Description,
                                               courseInput.Objective,
                                               courseInput.Price,
                                               courseInput.Caution,
                                               courseInput.Remarks);
            _courseDao.UpdataCourse(index, course);
        }

        public void AddCourse(CourseInput courseInput)
        {
            Course course = new Course(courseInput.Name,
                                               courseInput.Description,
                                               courseInput.Objective,
                                               courseInput.Price,
                                               courseInput.Caution,
                                               courseInput.Remarks);
            _courseDao.AddCourse(course);
        }

        public void DeleteCourse(int index)
        {
            _courseDao.DeleteCourse(index);
        }

        private Dao.DaoInterface _courseDao;
    }
}
