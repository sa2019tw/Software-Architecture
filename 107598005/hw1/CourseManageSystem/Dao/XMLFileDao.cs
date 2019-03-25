using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.Xml;
using System.Xml.Linq;

namespace CourseManageSystem.Dao
{
    class XmlFileDao : DaoInterface
    {
        public XmlFileDao(String path)
        {
            _path = path;
        }
        
        public void AddCourse(Course course)
        {
            _courseList.Add(course);
            saveXml(_path);
        }

        public List<Course> ListAllCourse()
        {
            loadXml(_path);
            return _courseList;
        }

        public void UpdataCourse(int index, Course course)
        {
            _courseList[index].Name = course.Name;
            _courseList[index].Description = course.Description;
            _courseList[index].Objective = course.Objective;
            _courseList[index].Price = course.Price;
            _courseList[index].Caution = course.Caution;
            _courseList[index].Remarks = course.Remarks;
            saveXml(_path);
        }

        public void DeleteCourse(int index)
        {
            _courseList.RemoveAt(index);
            saveXml(_path);
        }

        private void loadXml(string path)
        {
            _courseList = new List<Course>();
            XmlDocument doc = new XmlDocument();
            doc.Load(path);
            XmlNodeList nodes = doc.DocumentElement.SelectNodes("/models/model");
            foreach (XmlNode node in nodes)
            {
                Course course = new Course();
                course.Name = node.SelectSingleNode("Name").InnerText;
                course.Description = node.SelectSingleNode("Description").InnerText;
                course.Objective = node.SelectSingleNode("Objective").InnerText;
                course.Price = node.SelectSingleNode("Price").InnerText;
                course.Caution = node.SelectSingleNode("Cautions").InnerText;
                course.Remarks = node.SelectSingleNode("Remarks").InnerText;
                _courseList.Add(course);
            }
            
            foreach (Course course in _courseList)
            {
                Console.WriteLine(course.Name);
            }
        }

        private void saveXml(String path)
        {
            XElement layer1 = new XElement("models");
            foreach (Course course in _courseList)
            {
                XElement layer2 = new XElement("model");
                layer2.Add(new XElement("Name", course.Name));
                layer2.Add(new XElement("Description", course.Description));
                layer2.Add(new XElement("Objective", course.Objective));
                layer2.Add(new XElement("Price", course.Price));
                layer2.Add(new XElement("Cautions", course.Caution));
                layer2.Add(new XElement("Remarks", course.Remarks));
                layer1.Add(layer2);
            }
            XDocument doc = new XDocument();
            doc.Add(layer1);
            doc.Save(path);
        }

        private String _path;
        private List<Course> _courseList;
    }
}
