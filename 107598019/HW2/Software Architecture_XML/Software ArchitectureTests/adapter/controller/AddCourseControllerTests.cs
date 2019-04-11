using NUnit.Framework;
using Software_Architecture.adapter.controller;
using Software_Architecture.adapter.presenter;
using Software_Architecture.usecase;
using Software_Architecture.usecase.addCourse;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Software_Architecture.adapter.controller.Tests
{
    [TestFixture()]
    public class AddCourseControllerTests
    {
        [Test()]
        public void AddCourseControllerTest()
        {
            string title = "SA";
            string description = "none";
            string suitable = "CS student";
            string price = "10000";
            string notice = "none";
            string other = "none";

            CourseRepository courseRepository = new CourseRepositoryImpl();
            AddCourse addCourse = new AddCourseImpl(courseRepository);

            AddCourseInput input = (AddCourseInput)addCourse;
            AddCourseOutput addCoursePresneter = new AddCoursePresenter();
            input.setTitle(title);
            input.setDescription(description);
            input.setSuitable(suitable);
            input.setPrice(price);
            input.setNotice(notice);
            input.setOther(other);

            AddCourseOutput output = addCoursePresneter;

            addCourse.execute(input, output);
            Assert.AreEqual(output.getTitle(), "SA");
        }
        
    }
}