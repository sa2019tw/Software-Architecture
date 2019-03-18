using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.Xml;
using System.Xml.Linq;
using System.Data;
using System.IO;

namespace CourseManageSystem
{ 
    public class CourseData : CourseDataInterface
    {
        public CourseData(string path)
        {
            _path = path;
        }

        public DataTable getDataTable()
        {
            DataTable _data = new DataTable();
            setTableColumns(_data);
            loadXml(_path, _data);
            return _data;
        }

        public void saveDataTable(DataTable _data)
        {
            XElement layer1 = new XElement("models");
            foreach (DataRow row in _data.Rows)
            {
                XElement layer2 = new XElement("model");
                layer2.Add(new XElement("Name", row["Name"].ToString()));
                layer2.Add(new XElement("Description", row["Description"].ToString()));
                layer2.Add(new XElement("Objective", row["Objective"].ToString()));
                layer2.Add(new XElement("Price", row["Price"].ToString()));
                layer2.Add(new XElement("Cautions", row["Cautions"].ToString()));
                layer2.Add(new XElement("Remarks", row["Remarks"].ToString()));
                layer1.Add(layer2);
            }
            XDocument doc = new XDocument();
            doc.Add(layer1);
            doc.Save(_path);
        }

        private void setTableColumns(DataTable _data)
        {
            _data.Columns.Add("Name");
            _data.Columns.Add("Description");
            _data.Columns.Add("Objective");
            _data.Columns.Add("Price");
            _data.Columns.Add("Cautions");
            _data.Columns.Add("Remarks");
        }

        private void loadXml(string path, DataTable _data)
        {
            XmlDocument doc = new XmlDocument();
            doc.Load(_path);
            XmlNodeList nodes = doc.DocumentElement.SelectNodes("/models/model");
            foreach(XmlNode node in nodes)
            {
                DataRow newRow = _data.NewRow();
                newRow["Name"] = node.SelectSingleNode("Name").InnerText;
                newRow["Description"] = node.SelectSingleNode("Description").InnerText;
                newRow["Objective"] = node.SelectSingleNode("Objective").InnerText;
                newRow["Price"] = node.SelectSingleNode("Price").InnerText;
                newRow["Cautions"] = node.SelectSingleNode("Cautions").InnerText;
                newRow["Remarks"] = node.SelectSingleNode("Remarks").InnerText;
                _data.Rows.Add(newRow);
            }
            for (int i = 0; i < _data.Rows.Count; i++)
            {
                foreach (DataColumn column in _data.Columns)
                {
                    Console.WriteLine(_data.Rows[i][column.ColumnName]);
                }
            }
        }

        private string _path;
    }
}
