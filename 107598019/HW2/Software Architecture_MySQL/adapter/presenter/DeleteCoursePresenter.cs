using Software_Architecture.usecase.deleteCourse;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Software_Architecture.adapter.presenter
{
    public class DeleteCoursePresenter : DeleteCourseOutput
    {
        public DeleteCoursePresenter() { }

        private string msg;

        public string getMessage()
        {
            return msg;
        }

        public void setMessage(string title)
        {
            this.msg = title + " is gone.";
        }
    }
}
