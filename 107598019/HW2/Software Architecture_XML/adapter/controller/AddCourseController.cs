using Software_Architecture.adapter.presenter;
using Software_Architecture.usecase;
using Software_Architecture.usecase.addCourse;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Software_Architecture.adapter.controller
{
    public class AddCourseController
    {
        static CourseRepository courseRepository = new CourseRepositoryImpl();
        public AddCourse addCourse = new AddCourseImpl(courseRepository);
        public AddCourseOutput addCoursePresneter = new AddCoursePresenter();

        public AddCourseController() {}
        public AddCourseController(string title, string description, string suitable, string price, string notice, string other) {
            addCourseExecute(title, description, suitable, price, notice, other);
        }

        public void addCourseExecute(string title, string description, string suitable, string price, string notice, string other) {
            AddCourseInput input = (AddCourseInput) addCourse;
            input.setTitle(title);
            input.setDescription(description);
            input.setSuitable(suitable);
            input.setPrice(price);
            input.setNotice(notice);
            input.setOther(other);

            AddCourseOutput output = addCoursePresneter;

            addCourse.execute(input, output);
        }
    }
}
