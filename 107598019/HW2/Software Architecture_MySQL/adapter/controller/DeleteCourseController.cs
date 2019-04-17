using Software_Architecture.adapter.presenter;
using Software_Architecture.usecase;
using Software_Architecture.usecase.deleteCourse;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Software_Architecture.adapter.controller
{
    public class DeleteCourseController
    {
        static CourseRepository courseRepository = new CourseRepositoryImpl();
        public DeleteCourse deleteCourse = new DeleteCourseImpl(courseRepository);
        public DeleteCourseOutput deleteCoursePresenter = new DeleteCoursePresenter();

        public DeleteCourseController() { }
        public DeleteCourseController(string title)
        {
            deleteCourseExecute(title);
        }

        public void deleteCourseExecute(string title) {
            DeleteCourseInput input = (DeleteCourseInput) deleteCourse;
            input.setTitle(title);

            
            DeleteCourseOutput output = deleteCoursePresenter;
            
            deleteCourse.execute(input, output);
        }
    }
}
