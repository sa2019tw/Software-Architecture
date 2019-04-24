using Software_Architecture.adapter;
using Software_Architecture.adapter.controller;
using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.Data;
using System.Drawing;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.Windows.Forms;

namespace Software_Architecture
{
    public partial class Form1 : Form
    {
        private string cellValue;
        public Form1()
        {
            InitializeComponent();
            //generateDefaultCourses();
            refresh();

        }
        
        private void button1_Click(object sender, EventArgs e)
        {
            addCourse addCourse = new addCourse();
            addCourse.Visible = true;
            addCourse.Owner = this;
        }

        private void button2_Click(object sender, EventArgs e)
        {
            editCourse editCourse = new editCourse(cellValue);
            editCourse.Visible = true;
            editCourse.Owner = this;
        }

        private void button3_Click(object sender, EventArgs e)
        {
            DeleteCourseController deleteCourseController = new DeleteCourseController(cellValue);
            refresh();
        }

        private void dataGridView1_CellContentClick(object sender, DataGridViewCellEventArgs e)
        {
            cellValue = dataGridView1.Rows[e.RowIndex].Cells[e.ColumnIndex].Value.ToString();
        }

        public void refresh() {
            GetAllcoursesController getAllcoursesController = new GetAllcoursesController();
            ViewModel vw = getAllcoursesController.getAllCoursesPresenter.getViewModel();
            dataGridView1.DataSource = vw.getDataTable();
        }

        public DataTable getDataTable() {
            GetAllcoursesController getAllcoursesController = new GetAllcoursesController();
            ViewModel vw = getAllcoursesController.getAllCoursesPresenter.getViewModel();
            return vw.getDataTable();
        }

        public void generateDefaultCourses() {
            AddCourseController addCourseController_1 = new AddCourseController("軟體架構",
                                                             "軟體架構總覽",
                                                             "資工所",
                                                             "100000",
                                                             "無",
                                                             "無");
            AddCourseController addCourseController_2 = new AddCourseController("物件導向分析與設計",
                                                             "探討應用物件導向方法從事軟體設計的過程與步驟",
                                                             "資工所",
                                                             "200000",
                                                             "無",
                                                             "無");
            AddCourseController addCourseController_3 = new AddCourseController("資訊檢索與應用",
                                                             "探討如何有效的在大量文字及多媒體文件中搜尋使用者想要的資訊",
                                                             "資工所",
                                                             "300000",
                                                             "無",
                                                             "無");
            refresh();
        }
        
    }
}
