using Software_Architecture.entity;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Software_Architecture.usecase.addCourse
{
    public class AddCourseImpl : AddCourse, AddCourseInput
    {
        private CourseRepository courseRepository;

        private string title;
        private string description;
        private string suitable;
        private string price;
        private string notice;
        private string other;

        public AddCourseImpl(CourseRepository courseRepository) {
            this.courseRepository = courseRepository;
        }

        public void execute(AddCourseInput input, AddCourseOutput output) {
            Course course = new Course(input.getTitle(),
                                       input.getDescription(),
                                       input.getSuitable(),
                                       input.getPrice(),
                                       input.getNotice(),
                                       input.getOther());
            output.setTitle(title);
            courseRepository.create(course);
        }

        public string getTitle()
        {
            return title;
        }

        public void setTitle(string title)
        {
            this.title = title;
        }

        public string getDescription()
        {
            return description;
        }

        public void setDescription(string description)
        {
            this.description = description;
        }

        public string getSuitable()
        {
            return suitable;
        }

        public void setSuitable(string suitable)
        {
            this.suitable = suitable;
        }

        public string getPrice()
        {
            return price;
        }

        public void setPrice(string price)
        {
            this.price = price;
        }

        public string getNotice()
        {
            return notice;
        }

        public void setNotice(string notice)
        {
            this.notice = notice;
        }

        public string getOther()
        {
            return other;
        }

        public void setOther(string other)
        {
            this.other = other;
        }

    }
}
