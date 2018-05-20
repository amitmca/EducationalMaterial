<Global.Microsoft.VisualBasic.CompilerServices.DesignerGenerated()> _
Partial Class Form1
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
        Me.Label1 = New System.Windows.Forms.Label
        Me.txtcon = New System.Windows.Forms.TextBox
        Me.btnAdd = New System.Windows.Forms.Button
        Me.btnDel = New System.Windows.Forms.Button
        Me.btnClr = New System.Windows.Forms.Button
        Me.lstcon = New System.Windows.Forms.ListBox
        Me.SuspendLayout()
        '
        'Label1
        '
        Me.Label1.AutoSize = True
        Me.Label1.BackColor = System.Drawing.SystemColors.Desktop
        Me.Label1.Font = New System.Drawing.Font("Verdana", 12.0!, System.Drawing.FontStyle.Bold, System.Drawing.GraphicsUnit.Point, CType(0, Byte))
        Me.Label1.ForeColor = System.Drawing.Color.FromArgb(CType(CType(0, Byte), Integer), CType(CType(192, Byte), Integer), CType(CType(0, Byte), Integer))
        Me.Label1.Location = New System.Drawing.Point(12, 22)
        Me.Label1.Name = "Label1"
        Me.Label1.Size = New System.Drawing.Size(146, 18)
        Me.Label1.TabIndex = 0
        Me.Label1.Text = "Enter the Name"
        '
        'txtcon
        '
        Me.txtcon.Location = New System.Drawing.Point(164, 20)
        Me.txtcon.Name = "txtcon"
        Me.txtcon.Size = New System.Drawing.Size(100, 20)
        Me.txtcon.TabIndex = 1
        '
        'btnAdd
        '
        Me.btnAdd.BackColor = System.Drawing.Color.FromArgb(CType(CType(255, Byte), Integer), CType(CType(224, Byte), Integer), CType(CType(192, Byte), Integer))
        Me.btnAdd.Font = New System.Drawing.Font("Microsoft Sans Serif", 12.0!, System.Drawing.FontStyle.Bold, System.Drawing.GraphicsUnit.Point, CType(0, Byte))
        Me.btnAdd.ForeColor = System.Drawing.Color.Blue
        Me.btnAdd.Location = New System.Drawing.Point(15, 78)
        Me.btnAdd.Name = "btnAdd"
        Me.btnAdd.Size = New System.Drawing.Size(104, 26)
        Me.btnAdd.TabIndex = 2
        Me.btnAdd.Text = "ADD"
        Me.btnAdd.UseVisualStyleBackColor = False
        '
        'btnDel
        '
        Me.btnDel.BackColor = System.Drawing.Color.FromArgb(CType(CType(255, Byte), Integer), CType(CType(224, Byte), Integer), CType(CType(192, Byte), Integer))
        Me.btnDel.Font = New System.Drawing.Font("Microsoft Sans Serif", 12.0!, System.Drawing.FontStyle.Bold, System.Drawing.GraphicsUnit.Point, CType(0, Byte))
        Me.btnDel.ForeColor = System.Drawing.Color.Blue
        Me.btnDel.Location = New System.Drawing.Point(15, 122)
        Me.btnDel.Name = "btnDel"
        Me.btnDel.Size = New System.Drawing.Size(104, 32)
        Me.btnDel.TabIndex = 3
        Me.btnDel.Text = "DELETE"
        Me.btnDel.UseVisualStyleBackColor = False
        '
        'btnClr
        '
        Me.btnClr.BackColor = System.Drawing.Color.FromArgb(CType(CType(255, Byte), Integer), CType(CType(224, Byte), Integer), CType(CType(192, Byte), Integer))
        Me.btnClr.Font = New System.Drawing.Font("Microsoft Sans Serif", 12.0!, System.Drawing.FontStyle.Bold, System.Drawing.GraphicsUnit.Point, CType(0, Byte))
        Me.btnClr.ForeColor = System.Drawing.Color.Blue
        Me.btnClr.Location = New System.Drawing.Point(15, 171)
        Me.btnClr.Name = "btnClr"
        Me.btnClr.Size = New System.Drawing.Size(104, 30)
        Me.btnClr.TabIndex = 4
        Me.btnClr.Text = "CLEAR"
        Me.btnClr.UseVisualStyleBackColor = False
        '
        'lstcon
        '
        Me.lstcon.Font = New System.Drawing.Font("Microsoft Sans Serif", 12.0!, System.Drawing.FontStyle.Bold, System.Drawing.GraphicsUnit.Point, CType(0, Byte))
        Me.lstcon.ForeColor = System.Drawing.Color.FromArgb(CType(CType(192, Byte), Integer), CType(CType(0, Byte), Integer), CType(CType(0, Byte), Integer))
        Me.lstcon.FormattingEnabled = True
        Me.lstcon.ItemHeight = 20
        Me.lstcon.Items.AddRange(New Object() {"Ajay", "Ajit", "Amit"})
        Me.lstcon.Location = New System.Drawing.Point(139, 78)
        Me.lstcon.Name = "lstcon"
        Me.lstcon.Size = New System.Drawing.Size(125, 124)
        Me.lstcon.Sorted = True
        Me.lstcon.TabIndex = 5
        '
        'Form1
        '
        Me.AutoScaleDimensions = New System.Drawing.SizeF(6.0!, 13.0!)
        Me.AutoScaleMode = System.Windows.Forms.AutoScaleMode.Font
        Me.BackColor = System.Drawing.SystemColors.Desktop
        Me.ClientSize = New System.Drawing.Size(292, 266)
        Me.Controls.Add(Me.lstcon)
        Me.Controls.Add(Me.btnClr)
        Me.Controls.Add(Me.btnDel)
        Me.Controls.Add(Me.btnAdd)
        Me.Controls.Add(Me.txtcon)
        Me.Controls.Add(Me.Label1)
        Me.Name = "Form1"
        Me.Text = "Form1"
        Me.ResumeLayout(False)
        Me.PerformLayout()

    End Sub
    Friend WithEvents Label1 As System.Windows.Forms.Label
    Friend WithEvents txtcon As System.Windows.Forms.TextBox
    Friend WithEvents btnAdd As System.Windows.Forms.Button
    Friend WithEvents btnDel As System.Windows.Forms.Button
    Friend WithEvents btnClr As System.Windows.Forms.Button
    Friend WithEvents lstcon As System.Windows.Forms.ListBox

End Class
