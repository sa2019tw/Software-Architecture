using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Software_Architecture.usecase.deleteCourse
{
    public interface DeleteCourse
    {
        void execute(DeleteCourseInput input, DeleteCourseOutput output);
    }
}
