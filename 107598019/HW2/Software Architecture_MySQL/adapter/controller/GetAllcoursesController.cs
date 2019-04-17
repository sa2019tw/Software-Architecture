using Software_Architecture.usecase.getAllCourses;
using Software_Architecture.usecase;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.Data;
using Software_Architecture.adapter.presenter;

namespace Software_Architecture.adapter.controller
{
    public class GetAllcoursesController
    {
        static CourseRepository courseRepository = new CourseRepositoryImpl();
        public GetAllCourses getAllCourses = new GetAllCoursesImpl(courseRepository);
        public GetAllCoursesOutput getAllCoursesPresenter = new GetAllCoursesPresenter();
        
        public GetAllcoursesController() {
            getAllCoursesExecute();
        }

        public void getAllCoursesExecute() {
            GetAllCoursesInput input = (GetAllCoursesInput)getAllCourses;
            GetAllCoursesOutput output = getAllCoursesPresenter;
            getAllCourses.execute(input, output); 
        }
        
    }


}
