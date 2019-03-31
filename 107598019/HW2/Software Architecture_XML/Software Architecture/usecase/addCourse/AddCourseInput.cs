using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Software_Architecture.usecase.addCourse
{
    public interface AddCourseInput
    {
        string getTitle();

        void setTitle(string title);

        string getDescription();

        void setDescription(string description);

        string getSuitable();

        void setSuitable(string suitable);

        string getPrice();

        void setPrice(string price);

        string getNotice();

        void setNotice(string notice);

        string getOther();

        void setOther(string other);
    }
}
