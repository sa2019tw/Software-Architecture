using Software_Architecture.usecase.editCourse;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Software_Architecture.adapter.presenter
{
    public class EditCoursePresenter : EditCourseOutput
    {
        public EditCoursePresenter() { }

        private string newTitle;

        public string getNewTitle()
        {
            return newTitle;
        }

        public void setNewTitle(string newTitle)
        {
            this.newTitle = newTitle;
        }
    }
}
