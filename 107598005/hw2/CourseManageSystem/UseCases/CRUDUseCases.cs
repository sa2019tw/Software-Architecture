using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Data;
using System.Threading.Tasks;

namespace CourseManageSystem.UseCases
{
    public class CRUDUseCases
    {
        public CRUDUseCases()
        {
            _courseList = new List<Course>();   
            _courseDao = new Dao.XmlFileDao("../../coursedata.xml");
            List<CourseDTO> courseDTOList = _courseDao.ListAllCourse();
            foreach (CourseDTO courseDTO in courseDTOList)
            {
                Course course = new Course(courseDTO.Name,
                                            courseDTO.Description,
                                            courseDTO.Objective,
                                            courseDTO.Price,
                                            courseDTO.Caution,
                                            courseDTO.Remarks);
                _courseList.Add(course);
            }
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

            foreach (Course course in _courseList)
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
            CourseDTO course = new CourseDTO(courseInput.Name,
                                               courseInput.Description,
                                               courseInput.Objective,
                                               courseInput.Price,
                                               courseInput.Caution,
                                               courseInput.Remarks);
            _courseList[index].Name = courseInput.Name;
            _courseList[index].Description = courseInput.Description;
            _courseList[index].Objective = courseInput.Objective;
            _courseList[index].Price = courseInput.Price;
            _courseList[index].Caution = courseInput.Caution;
            _courseList[index].Remarks = courseInput.Remarks;
            _courseDao.UpdataCourse(index, course);
        }

        public void AddCourse(CourseInput courseInput)
        {
            CourseDTO course = new CourseDTO(courseInput.Name,
                                               courseInput.Description,
                                               courseInput.Objective,
                                               courseInput.Price,
                                               courseInput.Caution,
                                               courseInput.Remarks);
            _courseList.Add(new Course(courseInput.Name,
                                               courseInput.Description,
                                               courseInput.Objective,
                                               courseInput.Price,
                                               courseInput.Caution,
                                               courseInput.Remarks));
            _courseDao.AddCourse(course);
        }

        public void DeleteCourse(int index)
        {
            _courseList.RemoveAt(index);
            _courseDao.DeleteCourse(index);
        }

        private Dao.DaoInterface _courseDao;
        private List<Course> _courseList;
    }
}
