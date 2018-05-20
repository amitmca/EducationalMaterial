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
        Me.lstcon = New System.Windows.Forms.ListBox
        Me.lblcon = New System.Windows.Forms.Label
        Me.txtcon = New System.Windows.Forms.TextBox
        Me.btnAdd = New System.Windows.Forms.Button
        Me.btnDel = New System.Windows.Forms.Button
        Me.btnClr = New System.Windows.Forms.Button
        Me.SuspendLayout()
        '
        'lstcon
        '
        Me.lstcon.FormattingEnabled = True
        Me.lstcon.Items.AddRange(New Object() {"Amit", "Ajit", "Rohit"})
        Me.lstcon.Location = New System.Drawing.Point(160, 111)
        Me.lstcon.Name = "lstcon"
        Me.lstcon.Size = New System.Drawing.Size(120, 108)
        Me.lstcon.TabIndex = 0
        '
        'lblcon
        '
        Me.lblcon.AutoSize = True
        Me.lblcon.Location = New System.Drawing.Point(9, 32)
        Me.lblcon.Name = "lblcon"
        Me.lblcon.Size = New System.Drawing.Size(81, 13)
        Me.lblcon.TabIndex = 1
        Me.lblcon.Text = "Enter the Name"
        '
        'txtcon
        '
        Me.txtcon.Location = New System.Drawing.Point(160, 29)
        Me.txtcon.Name = "txtcon"
        Me.txtcon.Size = New System.Drawing.Size(120, 20)
        Me.txtcon.TabIndex = 2
        '
        'btnAdd
        '
        Me.btnAdd.Location = New System.Drawing.Point(15, 111)
        Me.btnAdd.Name = "btnAdd"
        Me.btnAdd.Size = New System.Drawing.Size(75, 23)
        Me.btnAdd.TabIndex = 3
        Me.btnAdd.Text = "Add"
        Me.btnAdd.UseVisualStyleBackColor = True
        '
        'btnDel
        '
        Me.btnDel.Location = New System.Drawing.Point(15, 152)
        Me.btnDel.Name = "btnDel"
        Me.btnDel.Size = New System.Drawing.Size(75, 23)
        Me.btnDel.TabIndex = 4
        Me.btnDel.Text = "Delete"
        Me.btnDel.UseVisualStyleBackColor = True
        '
        'btnClr
        '
        Me.btnClr.Location = New System.Drawing.Point(15, 192)
        Me.btnClr.Name = "btnClr"
        Me.btnClr.Size = New System.Drawing.Size(75, 23)
        Me.btnClr.TabIndex = 5
        Me.btnClr.Text = "Clear"
        Me.btnClr.UseVisualStyleBackColor = True
        '
        'Form1
        '
        Me.AutoScaleDimensions = New System.Drawing.SizeF(6.0!, 13.0!)
        Me.AutoScaleMode = System.Windows.Forms.AutoScaleMode.Font
        Me.ClientSize = New System.Drawing.Size(292, 266)
        Me.Controls.Add(Me.btnClr)
        Me.Controls.Add(Me.btnDel)
        Me.Controls.Add(Me.btnAdd)
        Me.Controls.Add(Me.txtcon)
        Me.Controls.Add(Me.lblcon)
        Me.Controls.Add(Me.lstcon)
        Me.Name = "Form1"
        Me.Text = "Form1"
        Me.ResumeLayout(False)
        Me.PerformLayout()

    End Sub
    Friend WithEvents lstcon As System.Windows.Forms.ListBox
    Friend WithEvents lblcon As System.Windows.Forms.Label
    Friend WithEvents txtcon As System.Windows.Forms.TextBox
    Friend WithEvents btnAdd As System.Windows.Forms.Button
    Friend WithEvents btnDel As System.Windows.Forms.Button
    Friend WithEvents btnClr As System.Windows.Forms.Button

End Class
