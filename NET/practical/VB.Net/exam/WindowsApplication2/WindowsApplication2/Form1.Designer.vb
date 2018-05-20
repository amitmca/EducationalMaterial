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
        Me.txt = New System.Windows.Forms.TextBox
        Me.btnadd = New System.Windows.Forms.Button
        Me.btndel = New System.Windows.Forms.Button
        Me.btnclr = New System.Windows.Forms.Button
        Me.list = New System.Windows.Forms.ListBox
        Me.StatusStrip1 = New System.Windows.Forms.StatusStrip
        Me.ToolStripProgressBar1 = New System.Windows.Forms.ToolStripProgressBar
        Me.StatusStrip1.SuspendLayout()
        Me.SuspendLayout()
        '
        'Label1
        '
        Me.Label1.AutoSize = True
        Me.Label1.Location = New System.Drawing.Point(31, 40)
        Me.Label1.Name = "Label1"
        Me.Label1.Size = New System.Drawing.Size(73, 13)
        Me.Label1.TabIndex = 0
        Me.Label1.Text = "Enter A Name"
        '
        'txt
        '
        Me.txt.Location = New System.Drawing.Point(174, 40)
        Me.txt.Name = "txt"
        Me.txt.Size = New System.Drawing.Size(120, 20)
        Me.txt.TabIndex = 1
        '
        'btnadd
        '
        Me.btnadd.Location = New System.Drawing.Point(29, 122)
        Me.btnadd.Name = "btnadd"
        Me.btnadd.Size = New System.Drawing.Size(75, 23)
        Me.btnadd.TabIndex = 2
        Me.btnadd.Text = "ADD"
        Me.btnadd.UseVisualStyleBackColor = True
        '
        'btndel
        '
        Me.btndel.Location = New System.Drawing.Point(29, 171)
        Me.btndel.Name = "btndel"
        Me.btndel.Size = New System.Drawing.Size(75, 23)
        Me.btndel.TabIndex = 3
        Me.btndel.Text = "DELETE"
        Me.btndel.UseVisualStyleBackColor = True
        '
        'btnclr
        '
        Me.btnclr.Location = New System.Drawing.Point(29, 222)
        Me.btnclr.Name = "btnclr"
        Me.btnclr.Size = New System.Drawing.Size(75, 23)
        Me.btnclr.TabIndex = 4
        Me.btnclr.Text = "CLEAR"
        Me.btnclr.UseVisualStyleBackColor = True
        '
        'list
        '
        Me.list.FormattingEnabled = True
        Me.list.Items.AddRange(New Object() {"Ajay", "Ajit", "Amit"})
        Me.list.Location = New System.Drawing.Point(174, 122)
        Me.list.Name = "list"
        Me.list.Size = New System.Drawing.Size(120, 121)
        Me.list.Sorted = True
        Me.list.TabIndex = 5
        '
        'StatusStrip1
        '
        Me.StatusStrip1.Items.AddRange(New System.Windows.Forms.ToolStripItem() {Me.ToolStripProgressBar1})
        Me.StatusStrip1.Location = New System.Drawing.Point(0, 284)
        Me.StatusStrip1.Name = "StatusStrip1"
        Me.StatusStrip1.Size = New System.Drawing.Size(325, 22)
        Me.StatusStrip1.TabIndex = 6
        Me.StatusStrip1.Text = "StatusStrip1"
        '
        'ToolStripProgressBar1
        '
        Me.ToolStripProgressBar1.Name = "ToolStripProgressBar1"
        Me.ToolStripProgressBar1.Size = New System.Drawing.Size(100, 16)
        '
        'Form1
        '
        Me.AutoScaleDimensions = New System.Drawing.SizeF(6.0!, 13.0!)
        Me.AutoScaleMode = System.Windows.Forms.AutoScaleMode.Font
        Me.ClientSize = New System.Drawing.Size(325, 306)
        Me.Controls.Add(Me.StatusStrip1)
        Me.Controls.Add(Me.list)
        Me.Controls.Add(Me.btnclr)
        Me.Controls.Add(Me.btndel)
        Me.Controls.Add(Me.btnadd)
        Me.Controls.Add(Me.txt)
        Me.Controls.Add(Me.Label1)
        Me.Name = "Form1"
        Me.Text = "Form1"
        Me.StatusStrip1.ResumeLayout(False)
        Me.StatusStrip1.PerformLayout()
        Me.ResumeLayout(False)
        Me.PerformLayout()

    End Sub
    Friend WithEvents Label1 As System.Windows.Forms.Label
    Friend WithEvents txt As System.Windows.Forms.TextBox
    Friend WithEvents btnadd As System.Windows.Forms.Button
    Friend WithEvents btndel As System.Windows.Forms.Button
    Friend WithEvents btnclr As System.Windows.Forms.Button
    Friend WithEvents list As System.Windows.Forms.ListBox
    Friend WithEvents StatusStrip1 As System.Windows.Forms.StatusStrip
    Friend WithEvents ToolStripProgressBar1 As System.Windows.Forms.ToolStripProgressBar

End Class
