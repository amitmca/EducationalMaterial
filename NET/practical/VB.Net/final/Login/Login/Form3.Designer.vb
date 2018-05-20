<Global.Microsoft.VisualBasic.CompilerServices.DesignerGenerated()> _
Partial Class Form3
    Inherits System.Windows.Forms.Form

    'Form overrides dispose to clean up the component list.
    <System.Diagnostics.DebuggerNonUserCode()> _
    Protected Overrides Sub Dispose(ByVal disposing As Boolean)
        If disposing AndAlso components IsNot Nothing Then
            components.Dispose()
        End If
        MyBase.Dispose(disposing)
    End Sub

    'Required by the Windows Form Designer
    Private components As System.ComponentModel.IContainer

    'NOTE: The following procedure is required by the Windows Form Designer
    'It can be modified using the Windows Form Designer.  
    'Do not modify it using the code editor.
    <System.Diagnostics.DebuggerStepThrough()> _
    Private Sub InitializeComponent()
        Me.components = New System.ComponentModel.Container
        Me.list = New System.Windows.Forms.ListBox
        Me.lblname = New System.Windows.Forms.Label
        Me.txtname = New System.Windows.Forms.TextBox
        Me.btnadd = New System.Windows.Forms.Button
        Me.btndel = New System.Windows.Forms.Button
        Me.btnclr = New System.Windows.Forms.Button
        Me.rmale = New System.Windows.Forms.RadioButton
        Me.rfemale = New System.Windows.Forms.RadioButton
        Me.chk = New System.Windows.Forms.Button
        Me.Panel1 = New System.Windows.Forms.Panel
        Me.vsbred = New System.Windows.Forms.VScrollBar
        Me.vsbgreen = New System.Windows.Forms.VScrollBar
        Me.vsbblue = New System.Windows.Forms.VScrollBar
        Me.tmr = New System.Windows.Forms.Timer(Me.components)
        Me.txt = New System.Windows.Forms.TextBox
        Me.Label1 = New System.Windows.Forms.Label
        Me.Panel1.SuspendLayout()
        Me.SuspendLayout()
        '
        'list
        '
        Me.list.FormattingEnabled = True
        Me.list.Items.AddRange(New Object() {"Ajay", "Ajit", "Amit"})
        Me.list.Location = New System.Drawing.Point(162, 75)
        Me.list.Name = "list"
        Me.list.Size = New System.Drawing.Size(120, 95)
        Me.list.Sorted = True
        Me.list.TabIndex = 0
        '
        'lblname
        '
        Me.lblname.AutoSize = True
        Me.lblname.Location = New System.Drawing.Point(23, 42)
        Me.lblname.Name = "lblname"
        Me.lblname.Size = New System.Drawing.Size(73, 13)
        Me.lblname.TabIndex = 1
        Me.lblname.Text = "Enter A Name"
        '
        'txtname
        '
        Me.txtname.Location = New System.Drawing.Point(162, 39)
        Me.txtname.Name = "txtname"
        Me.txtname.Size = New System.Drawing.Size(120, 20)
        Me.txtname.TabIndex = 2
        '
        'btnadd
        '
        Me.btnadd.BackColor = System.Drawing.Color.FromArgb(CType(CType(255, Byte), Integer), CType(CType(255, Byte), Integer), CType(CType(192, Byte), Integer))
        Me.btnadd.ForeColor = System.Drawing.Color.Red
        Me.btnadd.Location = New System.Drawing.Point(21, 87)
        Me.btnadd.Name = "btnadd"
        Me.btnadd.Size = New System.Drawing.Size(75, 23)
        Me.btnadd.TabIndex = 3
        Me.btnadd.Text = "ADD"
        Me.btnadd.UseVisualStyleBackColor = False
        '
        'btndel
        '
        Me.btndel.BackColor = System.Drawing.Color.FromArgb(CType(CType(255, Byte), Integer), CType(CType(255, Byte), Integer), CType(CType(192, Byte), Integer))
        Me.btndel.ForeColor = System.Drawing.Color.Red
        Me.btndel.Location = New System.Drawing.Point(21, 116)
        Me.btndel.Name = "btndel"
        Me.btndel.Size = New System.Drawing.Size(75, 23)
        Me.btndel.TabIndex = 4
        Me.btndel.Text = "DELETE"
        Me.btndel.UseVisualStyleBackColor = False
        '
        'btnclr
        '
        Me.btnclr.BackColor = System.Drawing.Color.FromArgb(CType(CType(255, Byte), Integer), CType(CType(255, Byte), Integer), CType(CType(192, Byte), Integer))
        Me.btnclr.ForeColor = System.Drawing.Color.Red
        Me.btnclr.Location = New System.Drawing.Point(21, 147)
        Me.btnclr.Name = "btnclr"
        Me.btnclr.Size = New System.Drawing.Size(75, 23)
        Me.btnclr.TabIndex = 5
        Me.btnclr.Text = "CLEAR"
        Me.btnclr.UseVisualStyleBackColor = False
        '
        'rmale
        '
        Me.rmale.AutoSize = True
        Me.rmale.Checked = True
        Me.rmale.Location = New System.Drawing.Point(26, 202)
        Me.rmale.Name = "rmale"
        Me.rmale.Size = New System.Drawing.Size(48, 17)
        Me.rmale.TabIndex = 6
        Me.rmale.TabStop = True
        Me.rmale.Text = "Male"
        Me.rmale.UseVisualStyleBackColor = True
        '
        'rfemale
        '
        Me.rfemale.AutoSize = True
        Me.rfemale.Location = New System.Drawing.Point(107, 202)
        Me.rfemale.Name = "rfemale"
        Me.rfemale.Size = New System.Drawing.Size(59, 17)
        Me.rfemale.TabIndex = 7
        Me.rfemale.TabStop = True
        Me.rfemale.Text = "Female"
        Me.rfemale.UseVisualStyleBackColor = True
        '
        'chk
        '
        Me.chk.Location = New System.Drawing.Point(207, 196)
        Me.chk.Name = "chk"
        Me.chk.Size = New System.Drawing.Size(75, 23)
        Me.chk.TabIndex = 8
        Me.chk.Text = "Check"
        Me.chk.UseVisualStyleBackColor = True
        '
        'Panel1
        '
        Me.Panel1.Controls.Add(Me.vsbblue)
        Me.Panel1.Controls.Add(Me.vsbgreen)
        Me.Panel1.Controls.Add(Me.vsbred)
        Me.Panel1.Location = New System.Drawing.Point(318, 23)
        Me.Panel1.Name = "Panel1"
        Me.Panel1.Size = New System.Drawing.Size(225, 147)
        Me.Panel1.TabIndex = 9
        '
        'vsbred
        '
        Me.vsbred.Location = New System.Drawing.Point(19, 0)
        Me.vsbred.Maximum = 255
        Me.vsbred.Name = "vsbred"
        Me.vsbred.Size = New System.Drawing.Size(29, 138)
        Me.vsbred.TabIndex = 0
        '
        'vsbgreen
        '
        Me.vsbgreen.Location = New System.Drawing.Point(101, 0)
        Me.vsbgreen.Maximum = 255
        Me.vsbgreen.Name = "vsbgreen"
        Me.vsbgreen.Size = New System.Drawing.Size(27, 138)
        Me.vsbgreen.TabIndex = 1
        '
        'vsbblue
        '
        Me.vsbblue.Location = New System.Drawing.Point(178, 0)
        Me.vsbblue.Maximum = 255
        Me.vsbblue.Name = "vsbblue"
        Me.vsbblue.Size = New System.Drawing.Size(29, 138)
        Me.vsbblue.TabIndex = 2
        '
        'tmr
        '
        Me.tmr.Enabled = True
        Me.tmr.Interval = 1000
        '
        'txt
        '
        Me.txt.Font = New System.Drawing.Font("Verdana", 12.0!, System.Drawing.FontStyle.Bold, System.Drawing.GraphicsUnit.Point, CType(0, Byte))
        Me.txt.Location = New System.Drawing.Point(452, 196)
        Me.txt.Name = "txt"
        Me.txt.Size = New System.Drawing.Size(100, 27)
        Me.txt.TabIndex = 10
        '
        'Label1
        '
        Me.Label1.AutoSize = True
        Me.Label1.Font = New System.Drawing.Font("Verdana", 12.0!, System.Drawing.FontStyle.Bold, System.Drawing.GraphicsUnit.Point, CType(0, Byte))
        Me.Label1.Location = New System.Drawing.Point(300, 198)
        Me.Label1.Name = "Label1"
        Me.Label1.Size = New System.Drawing.Size(146, 18)
        Me.Label1.TabIndex = 11
        Me.Label1.Text = "Current Time Is"
        '
        'Form1
        '
        Me.AutoScaleDimensions = New System.Drawing.SizeF(6.0!, 13.0!)
        Me.AutoScaleMode = System.Windows.Forms.AutoScaleMode.Font
        Me.ClientSize = New System.Drawing.Size(567, 232)
        Me.Controls.Add(Me.Label1)
        Me.Controls.Add(Me.txt)
        Me.Controls.Add(Me.Panel1)
        Me.Controls.Add(Me.chk)
        Me.Controls.Add(Me.rfemale)
        Me.Controls.Add(Me.rmale)
        Me.Controls.Add(Me.btnclr)
        Me.Controls.Add(Me.btndel)
        Me.Controls.Add(Me.btnadd)
        Me.Controls.Add(Me.txtname)
        Me.Controls.Add(Me.lblname)
        Me.Controls.Add(Me.list)
        Me.Name = "Form1"
        Me.Text = "Form1"
        Me.Panel1.ResumeLayout(False)
        Me.ResumeLayout(False)
        Me.PerformLayout()

    End Sub
    Friend WithEvents list As System.Windows.Forms.ListBox
    Friend WithEvents lblname As System.Windows.Forms.Label
    Friend WithEvents txtname As System.Windows.Forms.TextBox
    Friend WithEvents btnadd As System.Windows.Forms.Button
    Friend WithEvents btndel As System.Windows.Forms.Button
    Friend WithEvents btnclr As System.Windows.Forms.Button
    Friend WithEvents rmale As System.Windows.Forms.RadioButton
    Friend WithEvents rfemale As System.Windows.Forms.RadioButton
    Friend WithEvents chk As System.Windows.Forms.Button
    Friend WithEvents Panel1 As System.Windows.Forms.Panel
    Friend WithEvents vsbblue As System.Windows.Forms.VScrollBar
    Friend WithEvents vsbgreen As System.Windows.Forms.VScrollBar
    Friend WithEvents vsbred As System.Windows.Forms.VScrollBar
    Friend WithEvents tmr As System.Windows.Forms.Timer
    Friend WithEvents txt As System.Windows.Forms.TextBox
    Friend WithEvents Label1 As System.Windows.Forms.Label

End Class
