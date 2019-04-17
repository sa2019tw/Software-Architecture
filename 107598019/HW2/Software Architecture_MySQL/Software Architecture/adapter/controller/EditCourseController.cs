using Software_Architecture.adapter.presenter;
using Software_Architecture.usecase;
using Software_Architecture.usecase.editCourse;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Software_Architecture.adapter.controller
{
    public class EditCourseController
    {
        static CourseRepository courseRepository = new CourseRepositoryImpl();
        public EditCourse editCourse = new EditCourseImpl(courseRepository);
        public EditCourseOutput editCoursePresenter = new EditCoursePresenter();

        public EditCourseController() { }
        public EditCourseController(string oldTitle, string title, string description, string suitable, string price, string notice, string other)
        {
            editCourseExecute(oldTitle, title, description, suitable, price, notice, other);
        }

        public void editCourseExecute(string oldTitle, string title, string description, string suitable, string price, string notice, string other)
        {

            EditCourseInput input = (EditCourseInput) editCourse;
            input.setOldTitle(oldTitle);
            input.setTitle(title);
            input.setDescription(description);
            input.setSuitable(suitable);
            input.setPrice(price);
            input.setNotice(notice);
            input.setOther(other);

            EditCourseOutput output = editCoursePresenter;

            editCourse.execute(input, output);
        }

    }
}
