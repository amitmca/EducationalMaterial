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
        Me.GroupBox1 = New System.Windows.Forms.GroupBox
        Me.radmale = New System.Windows.Forms.RadioButton
        Me.radfemale = New System.Windows.Forms.RadioButton
        Me.lblgender = New System.Windows.Forms.Label
        Me.GroupBox1.SuspendLayout()
        Me.SuspendLayout()
        '
        'GroupBox1
        '
        Me.GroupBox1.Controls.Add(Me.radfemale)
        Me.GroupBox1.Controls.Add(Me.radmale)
        Me.GroupBox1.Location = New System.Drawing.Point(12, 12)
        Me.GroupBox1.Name = "GroupBox1"
        Me.GroupBox1.Size = New System.Drawing.Size(200, 100)
        Me.GroupBox1.TabIndex = 0
        Me.GroupBox1.TabStop = False
        Me.GroupBox1.Text = "Gender"
        '
        'radmale
        '
        Me.radmale.AutoSize = True
        Me.radmale.Location = New System.Drawing.Point(45, 19)
        Me.radmale.Name = "radmale"
        Me.radmale.Size = New System.Drawing.Size(48, 17)
        Me.radmale.TabIndex = 0
        Me.radmale.TabStop = True
        Me.radmale.Text = "Male"
        Me.radmale.UseVisualStyleBackColor = True
        '
        'radfemale
        '
        Me.radfemale.AutoSize = True
        Me.radfemale.Location = New System.Drawing.Point(45, 61)
        Me.radfemale.Name = "radfemale"
        Me.radfemale.Size = New System.Drawing.Size(59, 17)
        Me.radfemale.TabIndex = 1
        Me.radfemale.TabStop = True
        Me.radfemale.Text = "Female"
        Me.radfemale.UseVisualStyleBackColor = True
        '
        'lblgender
        '
        Me.lblgender.AutoSize = True
        Me.lblgender.Location = New System.Drawing.Point(66, 159)
        Me.lblgender.Name = "lblgender"
        Me.lblgender.Size = New System.Drawing.Size(0, 13)
        Me.lblgender.TabIndex = 1
        '
        'Form2
        '
        Me.AutoScaleDimensions = New System.Drawing.SizeF(6.0!, 13.0!)
        Me.AutoScaleMode = System.Windows.Forms.AutoScaleMode.Font
        Me.ClientSize = New System.Drawing.Size(292, 266)
        Me.Controls.Add(Me.lblgender)
        Me.Controls.Add(Me.GroupBox1)
        Me.Name = "Form2"
        Me.Text = "Form2"
        Me.GroupBox1.ResumeLayout(False)
        Me.GroupBox1.PerformLayout()
        Me.ResumeLayout(False)
        Me.PerformLayout()

    End Sub
    Friend WithEvents GroupBox1 As System.Windows.Forms.GroupBox
    Friend WithEvents radfemale As System.Windows.Forms.RadioButton
    Friend WithEvents radmale As System.Windows.Forms.RadioButton
    Friend WithEvents lblgender As System.Windows.Forms.Label
End Class
