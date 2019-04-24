using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.Xml;
using System.Xml.Linq;

namespace CourseManageSystem.Dao
{
    public class XmlFileDao : DaoInterface
    {
        public XmlFileDao(String path)
        {
            _path = path;
        }
        
        public void AddCourse(CourseDTO course)
        {
            List<CourseDTO> _courseList = loadXml(_path);
            _courseList.Add(course);
            saveXml(_path, _courseList);
        }

        public List<CourseDTO> ListAllCourse()
        {
            List<CourseDTO> _courseList = loadXml(_path);
            return _courseList;
        }

        public void UpdataCourse(int index, CourseDTO course)
        {
            List<CourseDTO> _courseList = loadXml(_path);
            _courseList[index].Name = course.Name;
            _courseList[index].Description = course.Description;
            _courseList[index].Objective = course.Objective;
            _courseList[index].Price = course.Price;
            _courseList[index].Caution = course.Caution;
            _courseList[index].Remarks = course.Remarks;
            saveXml(_path, _courseList);
        }

        public void DeleteCourse(int index)
        {
            List<CourseDTO> _courseList = loadXml(_path);
            _courseList.RemoveAt(index);
            saveXml(_path, _courseList);
        }

        private List<CourseDTO> loadXml(string path)
        {
            List<CourseDTO>  _courseList = new List<CourseDTO>();
            XmlDocument doc = new XmlDocument();
            doc.Load(path);
            XmlNodeList nodes = doc.DocumentElement.SelectNodes("/models/model");
            foreach (XmlNode node in nodes)
            {
                CourseDTO course = new CourseDTO();
                course.Name = node.SelectSingleNode("Name").InnerText;
                course.Description = node.SelectSingleNode("Description").InnerText;
                course.Objective = node.SelectSingleNode("Objective").InnerText;
                course.Price = node.SelectSingleNode("Price").InnerText;
                course.Caution = node.SelectSingleNode("Cautions").InnerText;
                course.Remarks = node.SelectSingleNode("Remarks").InnerText;
                _courseList.Add(course);
            }
            
            foreach (CourseDTO course in _courseList)
            {
                Console.WriteLine(course.Name);
            }
            return _courseList;
        }

        private void saveXml(String path, List<CourseDTO> _courseList)
        {
            XElement layer1 = new XElement("models");
            foreach (CourseDTO course in _courseList)
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
    }
}
