using Software_Architecture.adapter;
using Software_Architecture.adapter.controller;
using Software_Architecture.adapter.presenter;
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
    public partial class editCourse : Form
    {
        private string title;
        public editCourse(string title)
        {
            InitializeComponent();
            GetCourseByTitleController getCourseByTitleController = new GetCourseByTitleController(title);
            ViewModel vw = getCourseByTitleController.getCourseByTitlePresenter.getViewModel();
            
            textBox1.Text = title;
            textBox2.Text = vw.getDescription();
            textBox3.Text = vw.getSuitable();
            textBox4.Text = vw.getPrice();
            textBox5.Text = vw.getNotice();
            textBox6.Text = vw.getOther();
            this.title = title;
        }

        private void button2_Click(object sender, EventArgs e)
        {
            this.Close();
        }

        private void button1_Click(object sender, EventArgs e)
        {
            Form1 form1 = (Form1)this.Owner;

            String space = textBox1.Text;
            String deleteSpaceString = space.Trim();
            if (deleteSpaceString.Length == 0)
            {
                MessageBox.Show("       *** 你沒有輸入課程名稱 ***");
            }

            else {
                if (textBox1.Text != title)
                {
                    DataRow[] course = form1.getDataTable().Select("課程名稱 ='" + textBox1.Text + "'");

                    foreach (DataRow row in course)
                    {
                        MessageBox.Show("       *** 課程名稱重複 ***");
                        textBox1.Text = title;
                        return;
                    }
                }
                
                EditCourseController editCourseController = new EditCourseController(title ,textBox1.Text,
                                                                textBox2.Text,
                                                                textBox3.Text,
                                                                textBox4.Text, 
                                                                textBox5.Text,
                                                                textBox6.Text);
                form1.refresh();
                this.Close();
            }


        }
    }
}
