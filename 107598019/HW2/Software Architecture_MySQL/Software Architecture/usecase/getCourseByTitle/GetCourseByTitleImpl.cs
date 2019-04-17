using Software_Architecture.entity;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Software_Architecture.usecase.getCourseByTitle
{
    public class GetCourseByTitleImpl : GetCourseByTitle, GetCourseByTitleInput
    {
        private CourseRepository courseRepository;

        private string title;


        public GetCourseByTitleImpl(CourseRepository courseRepository) {
            this.courseRepository = courseRepository;
        }

        public void execute(GetCourseByTitleInput input, GetCourseByTitleOutput output){
            Course course = courseRepository.getCourseByTitle(input.getTitle());
            output.setDescription(course.getDescription());
            output.setSuitable(course.getSuitable());
            output.setPrice(course.getPrice());
            output.setNotice(course.getNotice());
            output.setOther(course.getOther());
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
