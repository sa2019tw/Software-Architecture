using Software_Architecture.adapter;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Software_Architecture.usecase.addCourse
{
    public interface AddCourseOutput
    {
        void setTitle(string title);

        string getTitle();

        ViewModel getViewModel();
    }
}
