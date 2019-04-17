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
        public int coursesInXml;
        public Form1()
        {
            InitializeComponent();
            if(anyCoursesInXML() > 0)
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
            PresenterToViewModel presenterToViewModel = new PresenterToViewModel();
            ViewModel vw = presenterToViewModel.getAllCoursesPresenterToViewModel(getAllcoursesController.getAllCoursesPresenter);
            dataGridView1.DataSource = vw.getDataTable();
        }

        public DataTable getDataTable() {
            GetAllcoursesController getAllcoursesController = new GetAllcoursesController();
            PresenterToViewModel presenterToViewModel = new PresenterToViewModel();
            ViewModel vw = presenterToViewModel.getAllCoursesPresenterToViewModel(getAllcoursesController.getAllCoursesPresenter);
            return vw.getDataTable();
        }

        public int anyCoursesInXML() {
            string path = System.Environment.CurrentDirectory + "\\" + "course.xml";
            DataSet ds = new DataSet("course");
            ds.ReadXml(@path);

            int coursesInXml = ds.Tables.Count;
            return coursesInXml;
        }
        
    }
}
