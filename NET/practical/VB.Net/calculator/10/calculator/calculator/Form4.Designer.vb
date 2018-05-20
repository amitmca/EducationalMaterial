<Global.Microsoft.VisualBasic.CompilerServices.DesignerGenerated()> _
Partial Class Form4
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
        Me.btnok = New System.Windows.Forms.Button
        Me.btnavg = New System.Windows.Forms.Button
        Me.btnquit = New System.Windows.Forms.Button
        Me.txtbox = New System.Windows.Forms.TextBox
        Me.avg = New System.Windows.Forms.Label
        Me.lbl = New System.Windows.Forms.Label
        Me.list = New System.Windows.Forms.ListBox
        Me.SuspendLayout()
        '
        'Label1
        '
        Me.Label1.AutoSize = True
        Me.Label1.Location = New System.Drawing.Point(22, 52)
        Me.Label1.Name = "Label1"
        Me.Label1.Size = New System.Drawing.Size(64, 13)
        Me.Label1.TabIndex = 0
        Me.Label1.Text = "Enter Marks"
        '
        'btnok
        '
        Me.btnok.Location = New System.Drawing.Point(216, 39)
        Me.btnok.Name = "btnok"
        Me.btnok.Size = New System.Drawing.Size(75, 38)
        Me.btnok.TabIndex = 1
        Me.btnok.Text = "OK"
        Me.btnok.UseVisualStyleBackColor = True
        '
        'btnavg
        '
        Me.btnavg.Location = New System.Drawing.Point(216, 96)
        Me.btnavg.Name = "btnavg"
        Me.btnavg.Size = New System.Drawing.Size(75, 37)
        Me.btnavg.TabIndex = 2
        Me.btnavg.Text = "Show Avg"
        Me.btnavg.UseVisualStyleBackColor = True
        '
        'btnquit
        '
        Me.btnquit.Location = New System.Drawing.Point(216, 149)
        Me.btnquit.Name = "btnquit"
        Me.btnquit.Size = New System.Drawing.Size(75, 35)
        Me.btnquit.TabIndex = 3
        Me.btnquit.Text = "Quit"
        Me.btnquit.UseVisualStyleBackColor = True
        '
        'txtbox
        '
        Me.txtbox.Location = New System.Drawing.Point(92, 49)
        Me.txtbox.Name = "txtbox"
        Me.txtbox.Size = New System.Drawing.Size(103, 20)
        Me.txtbox.TabIndex = 4
        '
        'avg
        '
        Me.avg.AutoSize = True
        Me.avg.Location = New System.Drawing.Point(22, 132)
        Me.avg.Name = "avg"
        Me.avg.Size = New System.Drawing.Size(58, 13)
        Me.avg.TabIndex = 5
        Me.avg.Text = "Average Is"
        Me.avg.Visible = False
        '
        'lbl
        '
        Me.lbl.AutoSize = True
        Me.lbl.Font = New System.Drawing.Font("Microsoft Sans Serif", 15.75!, System.Drawing.FontStyle.Bold, System.Drawing.GraphicsUnit.Point, CType(0, Byte))
        Me.lbl.Location = New System.Drawing.Point(105, 132)
        Me.lbl.Name = "lbl"
        Me.lbl.Size = New System.Drawing.Size(83, 25)
        Me.lbl.TabIndex = 6
        Me.lbl.Text = "Label3"
        Me.lbl.Visible = False
        '
        'list
        '
        Me.list.FormattingEnabled = True
        Me.list.Location = New System.Drawing.Point(329, 39)
        Me.list.Name = "list"
        Me.list.Size = New System.Drawing.Size(193, 147)
        Me.list.TabIndex = 7
        '
        'Form4
        '
        Me.AutoScaleDimensions = New System.Drawing.SizeF(6.0!, 13.0!)
        Me.AutoScaleMode = System.Windows.Forms.AutoScaleMode.Font
        Me.ClientSize = New System.Drawing.Size(546, 216)
        Me.Controls.Add(Me.list)
        Me.Controls.Add(Me.lbl)
        Me.Controls.Add(Me.avg)
        Me.Controls.Add(Me.txtbox)
        Me.Controls.Add(Me.btnquit)
        Me.Controls.Add(Me.btnavg)
        Me.Controls.Add(Me.btnok)
        Me.Controls.Add(Me.Label1)
        Me.Name = "Form4"
        Me.Text = "Form4"
        Me.ResumeLayout(False)
        Me.PerformLayout()

    End Sub
    Friend WithEvents Label1 As System.Windows.Forms.Label
    Friend WithEvents btnok As System.Windows.Forms.Button
    Friend WithEvents btnavg As System.Windows.Forms.Button
    Friend WithEvents btnquit As System.Windows.Forms.Button
    Friend WithEvents txtbox As System.Windows.Forms.TextBox
    Friend WithEvents avg As System.Windows.Forms.Label
    Friend WithEvents lbl As System.Windows.Forms.Label
    Friend WithEvents list As System.Windows.Forms.ListBox
End Class
