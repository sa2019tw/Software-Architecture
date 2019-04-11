using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.Data;

namespace Software_Architecture.adapter
{
    public class DataHelper
    {
        private static DataHelper instance = null;
        public static DataTable courseTable = new DataTable("course");

        DataHelper() {
            createCourseTable();
        }

        DataHelper(DataSet ds) {
            courseTable = ds.Tables[0];
        }

        public static DataHelper getInstance() {
            string path = System.Environment.CurrentDirectory + "\\" + "course.xml";
            DataSet ds = new DataSet("course");
            ds.ReadXml(@path);

            int coursesInXml = ds.Tables.Count;
            if (coursesInXml == 0)
                instance = new DataHelper();
            else {
                instance = new DataHelper(ds);
            }
            return instance;
        }

        private DataTable createCourseTable()
        {
            courseTable.Columns.Add("課程名稱", typeof(System.String));
            courseTable.PrimaryKey = new DataColumn[] { courseTable.Columns["課程名稱"] };
            courseTable.Columns.Add("課程說明", typeof(System.String));
            courseTable.Columns.Add("適合對象", typeof(System.String));
            courseTable.Columns.Add("定價", typeof(System.String));
            courseTable.Columns.Add("注意事項", typeof(System.String));
            courseTable.Columns.Add("備註", typeof(System.String));

            return courseTable;
        }
    }
}
