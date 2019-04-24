using Software_Architecture.adapter.presenter;
using Software_Architecture.usecase;
using Software_Architecture.usecase.getCourseByTitle;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Software_Architecture.adapter.controller
{
    public class GetCourseByTitleController
    {
        static CourseRepository courseRepository = new CourseRepositoryImpl();
        public GetCourseByTitle getCourseByTitle = new GetCourseByTitleImpl(courseRepository);
        public GetCourseByTitleOutput getCourseByTitlePresenter = new GetCourseByTitlePresenter();

        public GetCourseByTitleController(string title) {
            getCourseByTitleExecute(title);
        }

        public void getCourseByTitleExecute(string title) {
            GetCourseByTitleInput input = (GetCourseByTitleInput) getCourseByTitle;
            input.setTitle(title);

            GetCourseByTitleOutput output = getCourseByTitlePresenter;
            getCourseByTitle.execute(input, output);
   
        }

        
    }
}
