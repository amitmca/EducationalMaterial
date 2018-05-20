<Global.Microsoft.VisualBasic.CompilerServices.DesignerGenerated()> _
Partial Class Marks
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
        Me.txtbox = New System.Windows.Forms.TextBox
        Me.Label2 = New System.Windows.Forms.Label
        Me.Label3 = New System.Windows.Forms.Label
        Me.btnok = New System.Windows.Forms.Button
        Me.btnavg = New System.Windows.Forms.Button
        Me.btnq = New System.Windows.Forms.Button
        Me.lstbox = New System.Windows.Forms.ListBox
        Me.Panel1 = New System.Windows.Forms.Panel
        Me.Panel2 = New System.Windows.Forms.Panel
        Me.Panel3 = New System.Windows.Forms.Panel
        Me.Panel1.SuspendLayout()
        Me.Panel2.SuspendLayout()
        Me.Panel3.SuspendLayout()
        Me.SuspendLayout()
        '
        'Label1
        '
        Me.Label1.AutoSize = True
        Me.Label1.Font = New System.Drawing.Font("Microsoft Sans Serif", 11.25!, System.Drawing.FontStyle.Regular, System.Drawing.GraphicsUnit.Point, CType(0, Byte))
        Me.Label1.ForeColor = System.Drawing.SystemColors.ActiveCaption
        Me.Label1.Location = New System.Drawing.Point(5, 11)
        Me.Label1.Name = "Label1"
        Me.Label1.Size = New System.Drawing.Size(89, 18)
        Me.Label1.TabIndex = 0
        Me.Label1.Text = "Enter Marks"
        '
        'txtbox
        '
        Me.txtbox.Location = New System.Drawing.Point(97, 12)
        Me.txtbox.Name = "txtbox"
        Me.txtbox.Size = New System.Drawing.Size(100, 20)
        Me.txtbox.TabIndex = 1
        '
        'Label2
        '
        Me.Label2.AutoSize = True
        Me.Label2.Font = New System.Drawing.Font("Microsoft Sans Serif", 11.25!, System.Drawing.FontStyle.Regular, System.Drawing.GraphicsUnit.Point, CType(0, Byte))
        Me.Label2.ForeColor = System.Drawing.Color.Red
        Me.Label2.Location = New System.Drawing.Point(5, 51)
        Me.Label2.Name = "Label2"
        Me.Label2.Size = New System.Drawing.Size(107, 18)
        Me.Label2.TabIndex = 2
        Me.Label2.Text = "Average Marks"
        '
        'Label3
        '
        Me.Label3.AutoSize = True
        Me.Label3.Location = New System.Drawing.Point(129, 55)
        Me.Label3.Name = "Label3"
        Me.Label3.Size = New System.Drawing.Size(151, 13)
        Me.Label3.TabIndex = 3
        Me.Label3.Text = "                                                "
        '
        'btnok
        '
        Me.btnok.Location = New System.Drawing.Point(42, 3)
        Me.btnok.Name = "btnok"
        Me.btnok.Size = New System.Drawing.Size(75, 23)
        Me.btnok.TabIndex = 4
        Me.btnok.Text = "OK"
        Me.btnok.UseVisualStyleBackColor = True
        '
        'btnavg
        '
        Me.btnavg.Location = New System.Drawing.Point(42, 32)
        Me.btnavg.Name = "btnavg"
        Me.btnavg.Size = New System.Drawing.Size(75, 23)
        Me.btnavg.TabIndex = 5
        Me.btnavg.Text = "Show AVG"
        Me.btnavg.UseVisualStyleBackColor = True
        '
        'btnq
        '
        Me.btnq.Location = New System.Drawing.Point(42, 61)
        Me.btnq.Name = "btnq"
        Me.btnq.Size = New System.Drawing.Size(75, 23)
        Me.btnq.TabIndex = 6
        Me.btnq.Text = "QUIT"
        Me.btnq.UseVisualStyleBackColor = True
        '
        'lstbox
        '
        Me.lstbox.FormattingEnabled = True
        Me.lstbox.Location = New System.Drawing.Point(3, 3)
        Me.lstbox.Name = "lstbox"
        Me.lstbox.Size = New System.Drawing.Size(157, 82)
        Me.lstbox.TabIndex = 7
        '
        'Panel1
        '
        Me.Panel1.Controls.Add(Me.Label1)
        Me.Panel1.Controls.Add(Me.txtbox)
        Me.Panel1.Controls.Add(Me.Label2)
        Me.Panel1.Controls.Add(Me.Label3)
        Me.Panel1.Location = New System.Drawing.Point(12, 33)
        Me.Panel1.Name = "Panel1"
        Me.Panel1.Size = New System.Drawing.Size(200, 100)
        Me.Panel1.TabIndex = 8
        '
        'Panel2
        '
        Me.Panel2.Controls.Add(Me.btnok)
        Me.Panel2.Controls.Add(Me.btnavg)
        Me.Panel2.Controls.Add(Me.btnq)
        Me.Panel2.Location = New System.Drawing.Point(218, 33)
        Me.Panel2.Name = "Panel2"
        Me.Panel2.Size = New System.Drawing.Size(200, 100)
        Me.Panel2.TabIndex = 9
        '
        'Panel3
        '
        Me.Panel3.Controls.Add(Me.lstbox)
        Me.Panel3.Location = New System.Drawing.Point(424, 33)
        Me.Panel3.Name = "Panel3"
        Me.Panel3.Size = New System.Drawing.Size(163, 100)
        Me.Panel3.TabIndex = 10
        '
        'Marks
        '
        Me.AutoScaleDimensions = New System.Drawing.SizeF(6.0!, 13.0!)
        Me.AutoScaleMode = System.Windows.Forms.AutoScaleMode.Font
        Me.ClientSize = New System.Drawing.Size(600, 143)
        Me.Controls.Add(Me.Panel3)
        Me.Controls.Add(Me.Panel2)
        Me.Controls.Add(Me.Panel1)
        Me.Name = "Marks"
        Me.Text = "Marks"
        Me.Panel1.ResumeLayout(False)
        Me.Panel1.PerformLayout()
        Me.Panel2.ResumeLayout(False)
        Me.Panel3.ResumeLayout(False)
        Me.ResumeLayout(False)

    End Sub
    Friend WithEvents Label1 As System.Windows.Forms.Label
    Friend WithEvents txtbox As System.Windows.Forms.TextBox
    Friend WithEvents Label2 As System.Windows.Forms.Label
    Friend WithEvents Label3 As System.Windows.Forms.Label
    Friend WithEvents btnok As System.Windows.Forms.Button
    Friend WithEvents btnavg As System.Windows.Forms.Button
    Friend WithEvents btnq As System.Windows.Forms.Button
    Friend WithEvents lstbox As System.Windows.Forms.ListBox
    Friend WithEvents Panel1 As System.Windows.Forms.Panel
    Friend WithEvents Panel2 As System.Windows.Forms.Panel
    Friend WithEvents Panel3 As System.Windows.Forms.Panel
End Class
