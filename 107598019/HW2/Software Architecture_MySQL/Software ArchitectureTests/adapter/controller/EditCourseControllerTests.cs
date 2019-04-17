using NUnit.Framework;
using Software_Architecture.adapter.controller;
using Software_Architecture.adapter.presenter;
using Software_Architecture.usecase;
using Software_Architecture.usecase.addCourse;
using Software_Architecture.usecase.deleteCourse;
using Software_Architecture.usecase.editCourse;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Software_Architecture.adapter.controller.Tests
{
    [TestFixture()]
    public class EditCourseControllerTests
    {
        [Test()]
        public void EditCourseControllerTest()
        {

            string oldTitle = "SA_3";
            string newTitle = "New SA";
            string description = "none";
            string suitable = "CS student";
            string price = "10000";
            string notice = "none";
            string other = "none";

            CourseRepository courseRepository = new CourseRepositoryImpl();
            AddCourse addCourse = new AddCourseImpl(courseRepository);

            AddCourseInput input = (AddCourseInput)addCourse;
            AddCourseOutput addCoursePresneter = new AddCoursePresenter();
            input.setTitle(oldTitle);
            input.setDescription(description);
            input.setSuitable(suitable);
            input.setPrice(price);
            input.setNotice(notice);
            input.setOther(other);

            AddCourseOutput output = addCoursePresneter;

            addCourse.execute(input, output);
            
            EditCourse editCourse = new EditCourseImpl(courseRepository);

            EditCourseInput _input = (EditCourseInput)editCourse;
            EditCourseOutput editCoursePresneter = new EditCoursePresenter();
            _input.setOldTitle(oldTitle);
            _input.setTitle(newTitle);
            _input.setDescription(description);
            _input.setSuitable(suitable);
            _input.setPrice(price);
            _input.setNotice(notice);
            _input.setOther(other);

            EditCourseOutput _output = editCoursePresneter;

            editCourse.execute(_input, _output);
            Assert.AreEqual(_output.getNewTitle(), "New SA");

            DeleteCourse deleteCourse = new DeleteCourseImpl(courseRepository);

            DeleteCourseInput __input = (DeleteCourseInput)deleteCourse;
            DeleteCourseOutput deleteCoursePresneter = new DeleteCoursePresenter();
            __input.setTitle(newTitle);

            DeleteCourseOutput __output = deleteCoursePresneter;

            deleteCourse.execute(__input, __output);
        }

    }
}