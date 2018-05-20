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
        Me.Panel1 = New System.Windows.Forms.Panel
        Me.avg = New System.Windows.Forms.Label
        Me.txtbox = New System.Windows.Forms.TextBox
        Me.Label1 = New System.Windows.Forms.Label
        Me.Panel2 = New System.Windows.Forms.Panel
        Me.btnquit = New System.Windows.Forms.Button
        Me.btnavg = New System.Windows.Forms.Button
        Me.btnok = New System.Windows.Forms.Button
        Me.Panel3 = New System.Windows.Forms.Panel
        Me.list = New System.Windows.Forms.ListBox
        Me.lbl = New System.Windows.Forms.Label
        Me.Panel1.SuspendLayout()
        Me.Panel2.SuspendLayout()
        Me.Panel3.SuspendLayout()
        Me.SuspendLayout()
        '
        'Panel1
        '
        Me.Panel1.BackColor = System.Drawing.Color.FromArgb(CType(CType(255, Byte), Integer), CType(CType(255, Byte), Integer), CType(CType(192, Byte), Integer))
        Me.Panel1.Controls.Add(Me.lbl)
        Me.Panel1.Controls.Add(Me.avg)
        Me.Panel1.Controls.Add(Me.txtbox)
        Me.Panel1.Controls.Add(Me.Label1)
        Me.Panel1.Location = New System.Drawing.Point(12, 48)
        Me.Panel1.Name = "Panel1"
        Me.Panel1.Size = New System.Drawing.Size(241, 141)
        Me.Panel1.TabIndex = 0
        '
        'avg
        '
        Me.avg.AutoSize = True
        Me.avg.Font = New System.Drawing.Font("Verdana", 14.25!, System.Drawing.FontStyle.Bold, System.Drawing.GraphicsUnit.Point, CType(0, Byte))
        Me.avg.Location = New System.Drawing.Point(19, 104)
        Me.avg.Name = "avg"
        Me.avg.Size = New System.Drawing.Size(126, 23)
        Me.avg.TabIndex = 2
        Me.avg.Text = "Average Is"
        Me.avg.Visible = False
        '
        'txtbox
        '
        Me.txtbox.Font = New System.Drawing.Font("Verdana", 9.75!, System.Drawing.FontStyle.Bold, System.Drawing.GraphicsUnit.Point, CType(0, Byte))
        Me.txtbox.Location = New System.Drawing.Point(150, 35)
        Me.txtbox.Name = "txtbox"
        Me.txtbox.Size = New System.Drawing.Size(85, 23)
        Me.txtbox.TabIndex = 1
        '
        'Label1
        '
        Me.Label1.AutoSize = True
        Me.Label1.Font = New System.Drawing.Font("Verdana", 11.25!, System.Drawing.FontStyle.Bold, System.Drawing.GraphicsUnit.Point, CType(0, Byte))
        Me.Label1.Location = New System.Drawing.Point(3, 35)
        Me.Label1.Name = "Label1"
        Me.Label1.Size = New System.Drawing.Size(141, 18)
        Me.Label1.TabIndex = 0
        Me.Label1.Text = "Enter the marks"
        '
        'Panel2
        '
        Me.Panel2.BackColor = System.Drawing.Color.FromArgb(CType(CType(255, Byte), Integer), CType(CType(255, Byte), Integer), CType(CType(192, Byte), Integer))
        Me.Panel2.Controls.Add(Me.btnquit)
        Me.Panel2.Controls.Add(Me.btnavg)
        Me.Panel2.Controls.Add(Me.btnok)
        Me.Panel2.Location = New System.Drawing.Point(259, 48)
        Me.Panel2.Name = "Panel2"
        Me.Panel2.Size = New System.Drawing.Size(104, 141)
        Me.Panel2.TabIndex = 1
        '
        'btnquit
        '
        Me.btnquit.Font = New System.Drawing.Font("Verdana", 12.0!, System.Drawing.FontStyle.Bold, System.Drawing.GraphicsUnit.Point, CType(0, Byte))
        Me.btnquit.Location = New System.Drawing.Point(17, 100)
        Me.btnquit.Name = "btnquit"
        Me.btnquit.Size = New System.Drawing.Size(75, 34)
        Me.btnquit.TabIndex = 2
        Me.btnquit.Text = "QUIT"
        Me.btnquit.UseVisualStyleBackColor = True
        '
        'btnavg
        '
        Me.btnavg.Font = New System.Drawing.Font("Verdana", 8.25!, System.Drawing.FontStyle.Bold, System.Drawing.GraphicsUnit.Point, CType(0, Byte))
        Me.btnavg.Location = New System.Drawing.Point(17, 60)
        Me.btnavg.Name = "btnavg"
        Me.btnavg.Size = New System.Drawing.Size(75, 34)
        Me.btnavg.TabIndex = 1
        Me.btnavg.Text = "Show Avg"
        Me.btnavg.UseVisualStyleBackColor = True
        '
        'btnok
        '
        Me.btnok.Font = New System.Drawing.Font("Verdana", 12.0!, System.Drawing.FontStyle.Bold, System.Drawing.GraphicsUnit.Point, CType(0, Byte))
        Me.btnok.Location = New System.Drawing.Point(17, 15)
        Me.btnok.Name = "btnok"
        Me.btnok.Size = New System.Drawing.Size(75, 38)
        Me.btnok.TabIndex = 0
        Me.btnok.Text = "OK"
        Me.btnok.UseVisualStyleBackColor = True
        '
        'Panel3
        '
        Me.Panel3.BackColor = System.Drawing.Color.FromArgb(CType(CType(255, Byte), Integer), CType(CType(255, Byte), Integer), CType(CType(192, Byte), Integer))
        Me.Panel3.Controls.Add(Me.list)
        Me.Panel3.Font = New System.Drawing.Font("Verdana", 9.75!, System.Drawing.FontStyle.Bold, System.Drawing.GraphicsUnit.Point, CType(0, Byte))
        Me.Panel3.Location = New System.Drawing.Point(369, 48)
        Me.Panel3.Name = "Panel3"
        Me.Panel3.Size = New System.Drawing.Size(182, 141)
        Me.Panel3.TabIndex = 2
        '
        'list
        '
        Me.list.FormattingEnabled = True
        Me.list.ItemHeight = 16
        Me.list.Location = New System.Drawing.Point(3, 6)
        Me.list.Name = "list"
        Me.list.Size = New System.Drawing.Size(179, 132)
        Me.list.TabIndex = 0
        '
        'lbl
        '
        Me.lbl.AutoSize = True
        Me.lbl.Enabled = False
        Me.lbl.Font = New System.Drawing.Font("Verdana", 14.25!, System.Drawing.FontStyle.Bold, System.Drawing.GraphicsUnit.Point, CType(0, Byte))
        Me.lbl.ForeColor = System.Drawing.Color.Red
        Me.lbl.Location = New System.Drawing.Point(156, 104)
        Me.lbl.Name = "lbl"
        Me.lbl.Size = New System.Drawing.Size(82, 23)
        Me.lbl.TabIndex = 3
        Me.lbl.Text = "Label2"
        Me.lbl.Visible = False
        '
        'Form3
        '
        Me.AutoScaleDimensions = New System.Drawing.SizeF(6.0!, 13.0!)
        Me.AutoScaleMode = System.Windows.Forms.AutoScaleMode.Font
        Me.ClientSize = New System.Drawing.Size(554, 238)
        Me.Controls.Add(Me.Panel3)
        Me.Controls.Add(Me.Panel2)
        Me.Controls.Add(Me.Panel1)
        Me.Name = "Form3"
        Me.Text = "Form3"
        Me.Panel1.ResumeLayout(False)
        Me.Panel1.PerformLayout()
        Me.Panel2.ResumeLayout(False)
        Me.Panel3.ResumeLayout(False)
        Me.ResumeLayout(False)

    End Sub
    Friend WithEvents Panel1 As System.Windows.Forms.Panel
    Friend WithEvents txtbox As System.Windows.Forms.TextBox
    Friend WithEvents Label1 As System.Windows.Forms.Label
    Friend WithEvents avg As System.Windows.Forms.Label
    Friend WithEvents Panel2 As System.Windows.Forms.Panel
    Friend WithEvents btnok As System.Windows.Forms.Button
    Friend WithEvents btnquit As System.Windows.Forms.Button
    Friend WithEvents btnavg As System.Windows.Forms.Button
    Friend WithEvents Panel3 As System.Windows.Forms.Panel
    Friend WithEvents list As System.Windows.Forms.ListBox
    Friend WithEvents lbl As System.Windows.Forms.Label
End Class
