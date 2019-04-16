using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace CourseManageSystem.Dao
{
    public class InMemoryDao : DaoInterface
    {
        public InMemoryDao()
        {
            courseDTOList = new List<CourseDTO>();
        }

        public void AddCourse(CourseDTO course)
        {
            courseDTOList.Add(course);
        }
        public List<CourseDTO> ListAllCourse()
        {
            return courseDTOList;
        }
        public void UpdataCourse(int index, CourseDTO course)
        {
            courseDTOList[index].Name = course.Name;
            courseDTOList[index].Description = course.Description;
            courseDTOList[index].Objective = course.Objective;
            courseDTOList[index].Price = course.Price;
            courseDTOList[index].Caution = course.Caution;
            courseDTOList[index].Remarks = course.Remarks;
        }
        public void DeleteCourse(int index)
        {
            courseDTOList.RemoveAt(index);
        }

        private List<CourseDTO> courseDTOList;
    }
}
