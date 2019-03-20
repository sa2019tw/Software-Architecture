using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.Data;
using System.Drawing;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.Windows.Forms;

namespace CourseManageSystem
{
    public partial class ManageSystem : Form
    {
        private TextBox txtEdit;
        private int newItem;
        private Controller.Controller _controller;
        private BindingManagerBase bindingManager;
        private DataTable courseData;

        public ManageSystem()
        {
            InitializeComponent();
        }

        private void ManageSystem_Load(object sender, EventArgs e)
        {
            _controller = new Controller.Controller();

            txtEdit = new TextBox();
            txtEdit.KeyDown += new KeyEventHandler(txtEdit_KeyDown);

            //binding
            courseData = _controller.GetDataTable();
            Binding databinding = new Binding("Text", courseData, "Name");
            nameBox.DataBindings.Add(databinding);
            descriptionBox.DataBindings.Add("Text", courseData, "Description");
            objectiveBox.DataBindings.Add("Text", courseData, "Objective");
            priceBox.DataBindings.Add("Text", courseData, "Price");
            cautionBox.DataBindings.Add("Text", courseData, "Cautions");
            remarksBox.DataBindings.Add("Text", courseData, "Remarks");
            bindingManager = databinding.BindingManagerBase;
            bindingManager.Position = 0;

            //init courseList
            for (int i=0; i < courseData.Rows.Count; i++)
            {
                courseList.Items.Add(courseData.Rows[i]["Name"]);
            }

            //init courseList position
            if(courseList.Items.Count!=0)
                courseList.SetSelected(0,true);
            else
            {
                courseNotSelectingButton();
            }
        }

        private void courseList_SelectedIndexChanged(object sender, EventArgs e)
        {
            bindingManager.Position=courseList.SelectedIndex;
            if(courseList.SelectedIndex == -1)
            {
                courseNotSelectingButton();
            }
            else
            {
                courseSelectingButton();
            }
        }

        private void txtEdit_KeyDown(object sender, KeyEventArgs e)
        {
            if (e.KeyCode == Keys.Enter)
            {
                courseData.Rows[newItem]["Name"] = txtEdit.Text;
                _controller.AddCourse(txtEdit.Text, "","","","","");

                courseList.Items[newItem] = txtEdit.Text;
                courseList.SelectionMode = SelectionMode.One;
                txtEdit.Visible = false;
                courseList.SetSelected(newItem, true);
                setEditMode();
            }
            if (e.KeyCode == Keys.Escape)
            {
                courseData.Rows.RemoveAt(newItem);

                courseList.Items.RemoveAt(newItem);
                courseList.SelectionMode = SelectionMode.One;
                txtEdit.Visible = false;
                if(courseList.Items.Count>0)
                    courseList.SetSelected(newItem-1, true);
                addButton.Enabled = true;
            }  
            
        }

        private void addButton_Click(object sender, EventArgs e)
        {
            newItem = courseList.Items.Add("");
            courseList.SelectionMode = SelectionMode.None;
            String itemText = courseList.Items[newItem].ToString();
            
            Rectangle rect = courseList.GetItemRectangle(newItem);
            txtEdit.Parent = courseList;
            txtEdit.Bounds = rect;
            txtEdit.Multiline = false;
            txtEdit.Visible = true;
            txtEdit.Text = itemText;
            txtEdit.Focus();
            txtEdit.SelectAll();

            addButton.Enabled = false;
            courseNotSelectingButton();

            courseData.Rows.Add("", "", "", "", "", "");
            bindingManager.Position = newItem;
        }

        private void editButton_Click(object sender, EventArgs e)
        {
            setEditMode();
        }

        private void deleteButton_Click(object sender, EventArgs e)
        {
            int index = courseList.SelectedIndex;

            courseData.Rows.RemoveAt(index);
            courseList.Items.RemoveAt(index);   
            
            if (index!=0 && courseList.Items.Count!=0)
                courseList.SetSelected(index - 1, true);
            if (index == 0 && courseList.Items.Count != 0)
                courseList.SetSelected(index, true);

            _controller.DeleteCourse(index);
        }

        private void cancelButton_Click(object sender, EventArgs e)
        {
            setViewMode();
        }

        private void saveButton_Click(object sender, EventArgs e)
        {
            setViewMode();
            courseList.Items[bindingManager.Position] = nameBox.Text;

            _controller.UpdateCourse(bindingManager.Position,
                                    nameBox.Text,
                                    descriptionBox.Text,
                                    objectiveBox.Text,
                                    priceBox.Text,
                                    cautionBox.Text,
                                    remarksBox.Text);
        }

        private void setEditMode()
        {
            courseList.Enabled = false;
            nameBox.ReadOnly = false;
            descriptionBox.ReadOnly = false;
            objectiveBox.ReadOnly = false;
            priceBox.ReadOnly = false;
            cautionBox.ReadOnly = false;
            remarksBox.ReadOnly = false;
            saveButton.Visible = true;
            nameBox.Focus();
            //left button
            addButton.Enabled = false;

            courseNotSelectingButton();
            //cancelButton.Visible = true;
        }

        private void setViewMode()
        {
            courseList.Enabled = true;
            nameBox.ReadOnly = true;
            descriptionBox.ReadOnly = true;
            objectiveBox.ReadOnly = true;
            priceBox.ReadOnly = true;
            cautionBox.ReadOnly = true;
            remarksBox.ReadOnly = true;
            saveButton.Visible = false;
            //left button
            addButton.Enabled = true;

            courseSelectingButton();
            //cancelButton.Visible = false;
        }

        private void courseSelectingButton()
        {
            deleteButton.Enabled = true;
            editButton.Enabled = true;
        }

        private void courseNotSelectingButton()
        {
            deleteButton.Enabled = false;
            editButton.Enabled = false;
        }
    }
}
