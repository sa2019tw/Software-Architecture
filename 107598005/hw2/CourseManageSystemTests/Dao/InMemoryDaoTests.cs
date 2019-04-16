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
    public class InMemoryDaoTests
    {
        [TestMethod()]
        public void InMemoryDaoTest()
        {
            InMemoryDao Dao = new InMemoryDao();
            List<CourseDTO> courseDTOs = Dao.ListAllCourse();
            Assert.AreEqual(0,courseDTOs.Count);
        }

        [TestMethod()]
        public void AddCourseTest()
        {
            InMemoryDao Dao = new InMemoryDao();
            Dao.AddCourse(new CourseDTO("name",
                                        "des",
                                        "obj",
                                        "price",
                                        "catyion",
                                        "remarks"));
            List<CourseDTO> courseDTOs = Dao.ListAllCourse();
            Assert.AreEqual("name", courseDTOs[0].Name);
        }

        [TestMethod()]
        public void ListAllCourseTest()
        {
            InMemoryDao Dao = new InMemoryDao();
            Dao.AddCourse(new CourseDTO("name",
                                        "des",
                                        "obj",
                                        "price",
                                        "catyion",
                                        "remarks"));
            List<CourseDTO> courseDTOs = Dao.ListAllCourse();
            Assert.AreEqual(1, courseDTOs.Count);
        }

        [TestMethod()]
        public void UpdataCourseTest()
        {
            InMemoryDao Dao = new InMemoryDao();
            Dao.AddCourse(new CourseDTO("name",
                                        "des",
                                        "obj",
                                        "price",
                                        "catyion",
                                        "remarks"));
            List<CourseDTO> courseDTOs = Dao.ListAllCourse();
            Assert.AreEqual("name", courseDTOs[0].Name);
            Dao.UpdataCourse(0, new CourseDTO("Name",
                                        "123",
                                        "456",
                                        "price",
                                        "catyion",
                                        "remarks"));
            courseDTOs = Dao.ListAllCourse();
            Assert.AreEqual("Name", courseDTOs[0].Name);
            Assert.AreEqual("123", courseDTOs[0].Description);
            Assert.AreEqual("456", courseDTOs[0].Objective);
        }

        [TestMethod()]
        public void DeleteCourseTest()
        {
            InMemoryDao Dao = new InMemoryDao();
            Dao.AddCourse(new CourseDTO("name",
                                        "des",
                                        "obj",
                                        "price",
                                        "catyion",
                                        "remarks"));
            List<CourseDTO> courseDTOs = Dao.ListAllCourse();
            Assert.AreEqual(1, courseDTOs.Count);
            Dao.DeleteCourse(0);
            courseDTOs = Dao.ListAllCourse();
            Assert.AreEqual(0, courseDTOs.Count);
        }
    }
}