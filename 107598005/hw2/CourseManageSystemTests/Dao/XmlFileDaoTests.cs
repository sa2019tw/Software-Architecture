using Microsoft.VisualStudio.TestTools.UnitTesting;
using CourseManageSystem.Dao;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace CourseManageSystem.Dao.Tests
{
    [TestClass()]
    public class XmlFileDaoTests
    {
        [TestMethod()]
        public void XmlFileDaoTest()
        {
            XmlFileDao Dao = new XmlFileDao("../../coursedata.xml");
        }

        [TestMethod()]
        public void AddCourseTest()
        {
            XmlFileDao Dao = new XmlFileDao("../../coursedata.xml");
            List<CourseDTO> courseDTOs = Dao.ListAllCourse();
            Assert.AreEqual(2, courseDTOs.Count);
            Dao.AddCourse(new CourseDTO("name",
                                        "des",
                                        "obj",
                                        "price",
                                        "catyion",
                                        "remarks"));
            courseDTOs = Dao.ListAllCourse();
            Assert.AreEqual(3, courseDTOs.Count);
            Assert.AreEqual("name", courseDTOs[courseDTOs.Count-1].Name);
        }

        [TestMethod()]
        public void ListAllCourseTest()
        {
            XmlFileDao Dao = new XmlFileDao("../../coursedata.xml");
            List<CourseDTO> courseDTOs = Dao.ListAllCourse();
            Assert.AreEqual(3, courseDTOs.Count);
        }

        [TestMethod()]
        public void UpdataCourseTest()
        {
            XmlFileDao Dao = new XmlFileDao("../../coursedata.xml");
            Dao.AddCourse(new CourseDTO("123",
                                        "des",
                                        "obj",
                                        "price",
                                        "catyion",
                                        "remarks"));
            List<CourseDTO> courseDTOs = Dao.ListAllCourse();
            Assert.AreEqual("123", courseDTOs[courseDTOs.Count - 1].Name);
            Dao.UpdataCourse(courseDTOs.Count - 1, new CourseDTO("456",
                                        "des",
                                        "obj",
                                        "price",
                                        "catyion",
                                        "remarks"));
            courseDTOs = Dao.ListAllCourse();
            Assert.AreEqual("456", courseDTOs[courseDTOs.Count - 1].Name);
            Dao.DeleteCourse(courseDTOs.Count - 1);
            courseDTOs = Dao.ListAllCourse();
            Assert.AreEqual(3, courseDTOs.Count);
        }

        [TestMethod()]
        public void DeleteCourseTest()
        {
            XmlFileDao Dao = new XmlFileDao("../../coursedata.xml");
            List<CourseDTO> courseDTOs = Dao.ListAllCourse();
            Dao.DeleteCourse(courseDTOs.Count - 1);
            courseDTOs = Dao.ListAllCourse();
            Assert.AreEqual(2, courseDTOs.Count);
        }
    }
}