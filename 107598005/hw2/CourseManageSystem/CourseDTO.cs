using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace CourseManageSystem
{
    public class CourseDTO
    {
        public CourseDTO(String name, String description, String objective, String price, String caution, String remarks)
        {
            _name = name;
            _description = description;
            _objective = objective;
            _price = price;
            _caution = caution;
            _remarks = remarks;
        }

        public CourseDTO()
        {

        }

        public String Name
        {
            get { return _name; }
            set { _name = value; }
        }

        public String Description
        {
            get { return _description; }
            set { _description = value; }
        }

        public String Objective
        {
            get { return _objective; }
            set { _objective = value; }
        }

        public String Price
        {
            get { return _price; }
            set { _price = value; }
        }

        public String Caution
        {
            get { return _caution; }
            set { _caution = value; }
        }

        public String Remarks
        {
            get { return _remarks; }
            set { _remarks = value; }
        }

        private String _name;
        private String _description;
        private String _objective;
        private String _price;
        private String _caution;
        private String _remarks;
    }
}
