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
    public partial class addCourse : Form
    {
        public addCourse()
        {
            InitializeComponent();
        }

        private void button1_Click(object sender, EventArgs e)
        {
            Form1 form1 = (Form1)this.Owner;
            String space = textBox1.Text;
            String deleteSpaceString = space.Trim();
            if (deleteSpaceString.Length == 0)
            {
                MessageBox.Show("       *** 你沒有輸入課程名稱 ***");
                return;
            }

            else
            {
                
                DataRow[] course = form1.getDataTable().Select("Title ='" + textBox1.Text + "'");

                foreach (DataRow row in course)
                {
                    MessageBox.Show("       *** 課程名稱重複 ***");
                    textBox1.Text = "";
                    return;
                }
                
                
                AddCourseController addCourseController = new AddCourseController(textBox1.Text,
                                                             textBox2.Text,
                                                             textBox3.Text,
                                                             textBox4.Text,
                                                             textBox5.Text,
                                                             textBox6.Text);

            }
            
            form1.refresh();
            this.Close();
            
        }

        private void button2_Click(object sender, EventArgs e)
        {
            this.Close();
        }
       
    }
}
