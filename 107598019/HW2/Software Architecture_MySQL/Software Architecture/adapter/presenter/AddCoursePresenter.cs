using Software_Architecture.usecase.addCourse;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Software_Architecture.adapter.presenter
{
    public class AddCoursePresenter : AddCourseOutput
    {
        public AddCoursePresenter() { }

        private string title;
        private ViewModel vm = new ViewModel();

        public string getTitle()
        {
            return title;
        }

        public void setTitle(string title)
        {
            this.title = title;
            vm.setTitle(title);
        }

        public ViewModel getViewModel()
        {
            return vm;
        }
    }
}
