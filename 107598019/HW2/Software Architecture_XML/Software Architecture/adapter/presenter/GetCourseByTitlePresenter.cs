using Software_Architecture.usecase.getCourseByTitle;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Software_Architecture.adapter.presenter
{
    public class GetCourseByTitlePresenter : GetCourseByTitleOutput
    {
        private string title;
        private string description;
        private string suitable;
        private string price;
        private string notice;
        private string other;
        private ViewModel vm = new ViewModel();

        public GetCourseByTitlePresenter() { }

        public string getTitle()
        {
            return title;
        }

        public void setTitle(string title)
        {
            this.title = title;
            vm.setTitle(title);
        }

        public string getDescription()
        {
            return description;
        }

        public void setDescription(string description)
        {
            this.description = description;
            vm.setDescription(description);
        }

        public string getSuitable()
        {
            return suitable;
        }

        public void setSuitable(string suitable)
        {
            this.suitable = suitable;
            vm.setSuitable(suitable);
        }

        public string getPrice()
        {
            return price;
        }

        public void setPrice(string price)
        {
            this.price = price;
            vm.setPrice(price);
        }

        public string getNotice()
        {
            return notice;
        }

        public void setNotice(string notice)
        {
            this.notice = notice;
            vm.setNotice(notice);
        }

        public string getOther()
        {
            return other;
        }

        public void setOther(string other)
        {
            this.other = other;
            vm.setOther(other);
        }

        public ViewModel getViewModel()
        {
            return vm;
        }
    }
}
