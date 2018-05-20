<Global.Microsoft.VisualBasic.CompilerServices.DesignerGenerated()> _
Partial Class Form2
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
        Me.avg = New System.Windows.Forms.Label
        Me.lbl = New System.Windows.Forms.Label
        Me.btnok = New System.Windows.Forms.Button
        Me.btnavg = New System.Windows.Forms.Button
        Me.btnquit = New System.Windows.Forms.Button
        Me.list = New System.Windows.Forms.ListBox
        Me.SuspendLayout()
        '
        'Label1
        '
        Me.Label1.AutoSize = True
        Me.Label1.Location = New System.Drawing.Point(24, 35)
        Me.Label1.Name = "Label1"
        Me.Label1.Size = New System.Drawing.Size(64, 13)
        Me.Label1.TabIndex = 0
        Me.Label1.Text = "Enter Marks"
        '
        'txt
        '
        Me.txt.Location = New System.Drawing.Point(111, 35)
        Me.txt.Name = "txt"
        Me.txt.Size = New System.Drawing.Size(100, 20)
        Me.txt.TabIndex = 1
        '
        'avg
        '
        Me.avg.AutoSize = True
        Me.avg.Location = New System.Drawing.Point(24, 108)
        Me.avg.Name = "avg"
        Me.avg.Size = New System.Drawing.Size(58, 13)
        Me.avg.TabIndex = 2
        Me.avg.Text = "Average Is"
        Me.avg.Visible = False
        '
        'lbl
        '
        Me.lbl.AutoSize = True
        Me.lbl.Font = New System.Drawing.Font("Microsoft Sans Serif", 12.0!, System.Drawing.FontStyle.Bold, System.Drawing.GraphicsUnit.Point, CType(0, Byte))
        Me.lbl.ForeColor = System.Drawing.Color.Red
        Me.lbl.Location = New System.Drawing.Point(108, 108)
        Me.lbl.Name = "lbl"
        Me.lbl.Size = New System.Drawing.Size(63, 20)
        Me.lbl.TabIndex = 3
        Me.lbl.Text = "Label3"
        Me.lbl.Visible = False
        '
        'btnok
        '
        Me.btnok.Location = New System.Drawing.Point(243, 35)
        Me.btnok.Name = "btnok"
        Me.btnok.Size = New System.Drawing.Size(75, 23)
        Me.btnok.TabIndex = 4
        Me.btnok.Text = "OK"
        Me.btnok.UseVisualStyleBackColor = True
        '
        'btnavg
        '
        Me.btnavg.Location = New System.Drawing.Point(243, 79)
        Me.btnavg.Name = "btnavg"
        Me.btnavg.Size = New System.Drawing.Size(75, 23)
        Me.btnavg.TabIndex = 5
        Me.btnavg.Text = "Show Avg"
        Me.btnavg.UseVisualStyleBackColor = True
        '
        'btnquit
        '
        Me.btnquit.Location = New System.Drawing.Point(243, 123)
        Me.btnquit.Name = "btnquit"
        Me.btnquit.Size = New System.Drawing.Size(75, 23)
        Me.btnquit.TabIndex = 6
        Me.btnquit.Text = "Quit"
        Me.btnquit.UseVisualStyleBackColor = True
        '
        'list
        '
        Me.list.FormattingEnabled = True
        Me.list.Location = New System.Drawing.Point(360, 35)
        Me.list.Name = "list"
        Me.list.Size = New System.Drawing.Size(199, 134)
        Me.list.TabIndex = 7
        '
        'Form2
        '
        Me.AutoScaleDimensions = New System.Drawing.SizeF(6.0!, 13.0!)
        Me.AutoScaleMode = System.Windows.Forms.AutoScaleMode.Font
        Me.ClientSize = New System.Drawing.Size(581, 227)
        Me.Controls.Add(Me.list)
        Me.Controls.Add(Me.btnquit)
        Me.Controls.Add(Me.btnavg)
        Me.Controls.Add(Me.btnok)
        Me.Controls.Add(Me.lbl)
        Me.Controls.Add(Me.avg)
        Me.Controls.Add(Me.txt)
        Me.Controls.Add(Me.Label1)
        Me.Name = "Form2"
        Me.Text = "Form2"
        Me.ResumeLayout(False)
        Me.PerformLayout()

    End Sub
    Friend WithEvents Label1 As System.Windows.Forms.Label
    Friend WithEvents txt As System.Windows.Forms.TextBox
    Friend WithEvents avg As System.Windows.Forms.Label
    Friend WithEvents lbl As System.Windows.Forms.Label
    Friend WithEvents btnok As System.Windows.Forms.Button
    Friend WithEvents btnavg As System.Windows.Forms.Button
    Friend WithEvents btnquit As System.Windows.Forms.Button
    Friend WithEvents list As System.Windows.Forms.ListBox
End Class
