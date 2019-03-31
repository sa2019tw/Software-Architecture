using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Software_Architecture.usecase.editCourse
{
    public interface EditCourse
    {
        void execute(EditCourseInput input, EditCourseOutput output);
    }
}
