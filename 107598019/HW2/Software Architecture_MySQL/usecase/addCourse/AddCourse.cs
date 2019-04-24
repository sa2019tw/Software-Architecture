using Software_Architecture.usecase.addCourse;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Software_Architecture.usecase
{
    public interface AddCourse
    {
        void execute(AddCourseInput input, AddCourseOutput output);
    }
}
