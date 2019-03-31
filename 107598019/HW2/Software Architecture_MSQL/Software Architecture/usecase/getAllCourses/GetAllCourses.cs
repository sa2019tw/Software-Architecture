using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Software_Architecture.usecase.getAllCourses
{
    public interface GetAllCourses
    {
        void execute(GetAllCoursesInput input, GetAllCoursesOutput output);
    }
}
