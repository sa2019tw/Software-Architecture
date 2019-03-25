namespace CourseManageSystem
{
    partial class ManageSystem
    {
        /// <summary>
        /// 設計工具所需的變數。
        /// </summary>
        private System.ComponentModel.IContainer components = null;

        /// <summary>
        /// 清除任何使用中的資源。
        /// </summary>
        /// <param name="disposing">如果應該處置受控資源則為 true，否則為 false。</param>
        protected override void Dispose(bool disposing)
        {
            if (disposing && (components != null))
            {
                components.Dispose();
            }
            base.Dispose(disposing);
        }

        #region Windows Form 設計工具產生的程式碼

        /// <summary>
        /// 此為設計工具支援所需的方法 - 請勿使用程式碼編輯器修改
        /// 這個方法的內容。
        /// </summary>
        private void InitializeComponent()
        {
            this.courseList = new System.Windows.Forms.ListBox();
            this.label1 = new System.Windows.Forms.Label();
            this.addButton = new System.Windows.Forms.Button();
            this.label2 = new System.Windows.Forms.Label();
            this.label3 = new System.Windows.Forms.Label();
            this.label4 = new System.Windows.Forms.Label();
            this.label5 = new System.Windows.Forms.Label();
            this.label6 = new System.Windows.Forms.Label();
            this.label7 = new System.Windows.Forms.Label();
            this.descriptionBox = new System.Windows.Forms.TextBox();
            this.objectiveBox = new System.Windows.Forms.TextBox();
            this.priceBox = new System.Windows.Forms.TextBox();
            this.cautionBox = new System.Windows.Forms.TextBox();
            this.remarksBox = new System.Windows.Forms.TextBox();
            this.editButton = new System.Windows.Forms.Button();
            this.deleteButton = new System.Windows.Forms.Button();
            this.saveButton = new System.Windows.Forms.Button();
            this.cancelButton = new System.Windows.Forms.Button();
            this.nameBox = new System.Windows.Forms.TextBox();
            this.SuspendLayout();
            // 
            // courseList
            // 
            this.courseList.Font = new System.Drawing.Font("新細明體", 12F);
            this.courseList.FormattingEnabled = true;
            this.courseList.HorizontalScrollbar = true;
            this.courseList.ItemHeight = 20;
            this.courseList.Location = new System.Drawing.Point(1, 27);
            this.courseList.Name = "courseList";
            this.courseList.ScrollAlwaysVisible = true;
            this.courseList.Size = new System.Drawing.Size(273, 664);
            this.courseList.TabIndex = 0;
            this.courseList.SelectedIndexChanged += new System.EventHandler(this.courseList_SelectedIndexChanged);
            // 
            // label1
            // 
            this.label1.AutoSize = true;
            this.label1.Font = new System.Drawing.Font("新細明體", 12F);
            this.label1.Location = new System.Drawing.Point(-3, 4);
            this.label1.Name = "label1";
            this.label1.Size = new System.Drawing.Size(89, 20);
            this.label1.TabIndex = 1;
            this.label1.Text = "課程列表";
            // 
            // addButton
            // 
            this.addButton.Font = new System.Drawing.Font("新細明體", 12F);
            this.addButton.Location = new System.Drawing.Point(12, 710);
            this.addButton.Name = "addButton";
            this.addButton.Size = new System.Drawing.Size(119, 31);
            this.addButton.TabIndex = 2;
            this.addButton.Text = "新增課程";
            this.addButton.UseVisualStyleBackColor = true;
            this.addButton.Click += new System.EventHandler(this.addButton_Click);
            // 
            // label2
            // 
            this.label2.AutoSize = true;
            this.label2.Font = new System.Drawing.Font("新細明體", 12F);
            this.label2.Location = new System.Drawing.Point(294, 27);
            this.label2.Name = "label2";
            this.label2.Size = new System.Drawing.Size(89, 20);
            this.label2.TabIndex = 3;
            this.label2.Text = "課程名稱";
            // 
            // label3
            // 
            this.label3.AutoSize = true;
            this.label3.Font = new System.Drawing.Font("新細明體", 12F);
            this.label3.Location = new System.Drawing.Point(294, 63);
            this.label3.Name = "label3";
            this.label3.Size = new System.Drawing.Size(89, 20);
            this.label3.TabIndex = 4;
            this.label3.Text = "課程說明";
            // 
            // label4
            // 
            this.label4.AutoSize = true;
            this.label4.Font = new System.Drawing.Font("新細明體", 12F);
            this.label4.Location = new System.Drawing.Point(294, 244);
            this.label4.Name = "label4";
            this.label4.Size = new System.Drawing.Size(89, 20);
            this.label4.TabIndex = 5;
            this.label4.Text = "適合對象";
            // 
            // label5
            // 
            this.label5.AutoSize = true;
            this.label5.Font = new System.Drawing.Font("新細明體", 12F);
            this.label5.Location = new System.Drawing.Point(294, 367);
            this.label5.Name = "label5";
            this.label5.Size = new System.Drawing.Size(49, 20);
            this.label5.TabIndex = 6;
            this.label5.Text = "定價";
            // 
            // label6
            // 
            this.label6.AutoSize = true;
            this.label6.Font = new System.Drawing.Font("新細明體", 12F);
            this.label6.Location = new System.Drawing.Point(294, 404);
            this.label6.Name = "label6";
            this.label6.Size = new System.Drawing.Size(89, 20);
            this.label6.TabIndex = 7;
            this.label6.Text = "注意事項";
            // 
            // label7
            // 
            this.label7.AutoSize = true;
            this.label7.Font = new System.Drawing.Font("新細明體", 12F);
            this.label7.Location = new System.Drawing.Point(294, 589);
            this.label7.Name = "label7";
            this.label7.Size = new System.Drawing.Size(49, 20);
            this.label7.TabIndex = 8;
            this.label7.Text = "備註";
            // 
            // descriptionBox
            // 
            this.descriptionBox.Font = new System.Drawing.Font("新細明體", 12F);
            this.descriptionBox.Location = new System.Drawing.Point(389, 63);
            this.descriptionBox.Multiline = true;
            this.descriptionBox.Name = "descriptionBox";
            this.descriptionBox.ReadOnly = true;
            this.descriptionBox.ScrollBars = System.Windows.Forms.ScrollBars.Vertical;
            this.descriptionBox.Size = new System.Drawing.Size(946, 175);
            this.descriptionBox.TabIndex = 10;
            // 
            // objectiveBox
            // 
            this.objectiveBox.Font = new System.Drawing.Font("新細明體", 12F);
            this.objectiveBox.Location = new System.Drawing.Point(389, 244);
            this.objectiveBox.Multiline = true;
            this.objectiveBox.Name = "objectiveBox";
            this.objectiveBox.ReadOnly = true;
            this.objectiveBox.ScrollBars = System.Windows.Forms.ScrollBars.Vertical;
            this.objectiveBox.Size = new System.Drawing.Size(946, 117);
            this.objectiveBox.TabIndex = 11;
            // 
            // priceBox
            // 
            this.priceBox.Font = new System.Drawing.Font("新細明體", 12F);
            this.priceBox.Location = new System.Drawing.Point(389, 367);
            this.priceBox.Name = "priceBox";
            this.priceBox.ReadOnly = true;
            this.priceBox.Size = new System.Drawing.Size(946, 31);
            this.priceBox.TabIndex = 12;
            // 
            // cautionBox
            // 
            this.cautionBox.Font = new System.Drawing.Font("新細明體", 12F);
            this.cautionBox.Location = new System.Drawing.Point(389, 404);
            this.cautionBox.Multiline = true;
            this.cautionBox.Name = "cautionBox";
            this.cautionBox.ReadOnly = true;
            this.cautionBox.ScrollBars = System.Windows.Forms.ScrollBars.Vertical;
            this.cautionBox.Size = new System.Drawing.Size(946, 170);
            this.cautionBox.TabIndex = 13;
            // 
            // remarksBox
            // 
            this.remarksBox.Font = new System.Drawing.Font("新細明體", 12F);
            this.remarksBox.Location = new System.Drawing.Point(389, 589);
            this.remarksBox.Multiline = true;
            this.remarksBox.Name = "remarksBox";
            this.remarksBox.ReadOnly = true;
            this.remarksBox.ScrollBars = System.Windows.Forms.ScrollBars.Vertical;
            this.remarksBox.Size = new System.Drawing.Size(946, 135);
            this.remarksBox.TabIndex = 14;
            // 
            // editButton
            // 
            this.editButton.Font = new System.Drawing.Font("新細明體", 12F);
            this.editButton.Location = new System.Drawing.Point(12, 745);
            this.editButton.Name = "editButton";
            this.editButton.Size = new System.Drawing.Size(119, 31);
            this.editButton.TabIndex = 15;
            this.editButton.Text = "編輯課程";
            this.editButton.UseVisualStyleBackColor = true;
            this.editButton.Click += new System.EventHandler(this.editButton_Click);
            // 
            // deleteButton
            // 
            this.deleteButton.Font = new System.Drawing.Font("新細明體", 12F);
            this.deleteButton.Location = new System.Drawing.Point(12, 782);
            this.deleteButton.Name = "deleteButton";
            this.deleteButton.Size = new System.Drawing.Size(119, 31);
            this.deleteButton.TabIndex = 16;
            this.deleteButton.Text = "刪除課程";
            this.deleteButton.UseVisualStyleBackColor = true;
            this.deleteButton.Click += new System.EventHandler(this.deleteButton_Click);
            // 
            // saveButton
            // 
            this.saveButton.Font = new System.Drawing.Font("新細明體", 12F);
            this.saveButton.Location = new System.Drawing.Point(1146, 745);
            this.saveButton.Name = "saveButton";
            this.saveButton.Size = new System.Drawing.Size(75, 43);
            this.saveButton.TabIndex = 17;
            this.saveButton.Text = "儲存";
            this.saveButton.UseVisualStyleBackColor = true;
            this.saveButton.Visible = false;
            this.saveButton.Click += new System.EventHandler(this.saveButton_Click);
            // 
            // cancelButton
            // 
            this.cancelButton.Font = new System.Drawing.Font("新細明體", 12F);
            this.cancelButton.Location = new System.Drawing.Point(1227, 745);
            this.cancelButton.Name = "cancelButton";
            this.cancelButton.Size = new System.Drawing.Size(75, 43);
            this.cancelButton.TabIndex = 18;
            this.cancelButton.Text = "取消";
            this.cancelButton.UseVisualStyleBackColor = true;
            this.cancelButton.Visible = false;
            this.cancelButton.Click += new System.EventHandler(this.cancelButton_Click);
            // 
            // nameBox
            // 
            this.nameBox.Font = new System.Drawing.Font("新細明體", 12F);
            this.nameBox.Location = new System.Drawing.Point(389, 27);
            this.nameBox.Name = "nameBox";
            this.nameBox.ReadOnly = true;
            this.nameBox.Size = new System.Drawing.Size(946, 31);
            this.nameBox.TabIndex = 19;
            // 
            // ManageSystem
            // 
            this.AutoScaleDimensions = new System.Drawing.SizeF(8F, 15F);
            this.AutoScaleMode = System.Windows.Forms.AutoScaleMode.Font;
            this.ClientSize = new System.Drawing.Size(1364, 832);
            this.Controls.Add(this.nameBox);
            this.Controls.Add(this.cancelButton);
            this.Controls.Add(this.saveButton);
            this.Controls.Add(this.deleteButton);
            this.Controls.Add(this.editButton);
            this.Controls.Add(this.remarksBox);
            this.Controls.Add(this.cautionBox);
            this.Controls.Add(this.priceBox);
            this.Controls.Add(this.objectiveBox);
            this.Controls.Add(this.descriptionBox);
            this.Controls.Add(this.label7);
            this.Controls.Add(this.label6);
            this.Controls.Add(this.label5);
            this.Controls.Add(this.label4);
            this.Controls.Add(this.label3);
            this.Controls.Add(this.label2);
            this.Controls.Add(this.addButton);
            this.Controls.Add(this.label1);
            this.Controls.Add(this.courseList);
            this.Name = "ManageSystem";
            this.Text = "課程管理系統";
            this.Load += new System.EventHandler(this.ManageSystem_Load);
            this.ResumeLayout(false);
            this.PerformLayout();

        }

        #endregion

        private System.Windows.Forms.ListBox courseList;
        private System.Windows.Forms.Label label1;
        private System.Windows.Forms.Button addButton;
        private System.Windows.Forms.Label label2;
        private System.Windows.Forms.Label label3;
        private System.Windows.Forms.Label label4;
        private System.Windows.Forms.Label label5;
        private System.Windows.Forms.Label label6;
        private System.Windows.Forms.Label label7;
        private System.Windows.Forms.TextBox descriptionBox;
        private System.Windows.Forms.TextBox objectiveBox;
        private System.Windows.Forms.TextBox priceBox;
        private System.Windows.Forms.TextBox cautionBox;
        private System.Windows.Forms.TextBox remarksBox;
        private System.Windows.Forms.Button editButton;
        private System.Windows.Forms.Button deleteButton;
        private System.Windows.Forms.Button saveButton;
        private System.Windows.Forms.Button cancelButton;
        private System.Windows.Forms.TextBox nameBox;
    }
}

