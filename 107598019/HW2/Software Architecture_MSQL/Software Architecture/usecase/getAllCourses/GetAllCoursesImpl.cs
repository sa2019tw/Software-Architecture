using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Software_Architecture.usecase.getAllCourses
{
    public class GetAllCoursesImpl : GetAllCourses, GetAllCoursesInput
    {
        private CourseRepository courseRepository;

        public GetAllCoursesImpl(CourseRepository courseRepository)
        {
            this.courseRepository = courseRepository;
        }

        public void execute(GetAllCoursesInput input, GetAllCoursesOutput output) {
             output.setCourseDataTable(courseRepository.getAllCourses());

        }
    }
}
