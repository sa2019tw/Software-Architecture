using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Software_Architecture.usecase.deleteCourse
{
    public class DeleteCourseImpl : DeleteCourse, DeleteCourseInput
    {
        private CourseRepository courseRepository;

        private string title;

        public DeleteCourseImpl(CourseRepository courseRepository) {
            this.courseRepository = courseRepository;
        }

        public void execute(DeleteCourseInput input, DeleteCourseOutput output)
        {
            output.setMessage(title);
            courseRepository.delete(input.getTitle());
            
        }

        public string getTitle()
        {
            return title;
        }

        public void setTitle(string title)
        {
            this.title = title;
        }
    }
}
