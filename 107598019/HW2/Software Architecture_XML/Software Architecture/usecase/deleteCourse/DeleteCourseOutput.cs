using Software_Architecture.adapter;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Software_Architecture.usecase.deleteCourse
{
    public interface DeleteCourseOutput
    {
        void setMessage(string title);

        string getMessage();

        ViewModel getViewModel();
    }
}
