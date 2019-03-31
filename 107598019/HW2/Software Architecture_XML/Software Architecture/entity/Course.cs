using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Software_Architecture.entity
{
    public class Course
    {
        private string title;
        private string description;
        private string suitable;
        private string price;
        private string notice;
        private string other;

        public Course() { }

        public Course(string title, string description, string suitable, string price, string notice, string other) {
            this.title = title;
            this.description = description;
            this.suitable = suitable;
            this.price = price;
            this.notice = notice;
            this.other = other;
        }

        public string getTitle() {
            return title;
        }

        public void setTitle(string title) {
            this.title = title;
        }

        public string getDescription()
        {
            return description;
        }

        public void setDescription(string description)
        {
            this.description = description;
        }

        public string getSuitable()
        {
            return suitable;
        }

        public void setSuitable(string suitable)
        {
            this.suitable = suitable;
        }

        public string getPrice()
        {
            return price;
        }

        public void setPrice(string price)
        {
            this.price = price;
        }

        public string getNotice()
        {
            return notice;
        }

        public void setNotice(string notice)
        {
            this.notice = notice;
        }

        public string getOther()
        {
            return other;
        }

        public void setOther(string other)
        {
            this.other= other;
        }
    }
}
