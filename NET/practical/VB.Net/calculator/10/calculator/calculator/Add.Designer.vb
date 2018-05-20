<Global.Microsoft.VisualBasic.CompilerServices.DesignerGenerated()> _
Partial Class Add
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
        Me.lstoutput = New System.Windows.Forms.ListBox
        Me.btnok = New System.Windows.Forms.Button
        Me.SuspendLayout()
        '
        'lstoutput
        '
        Me.lstoutput.FormattingEnabled = True
        Me.lstoutput.Location = New System.Drawing.Point(44, 55)
        Me.lstoutput.Name = "lstoutput"
        Me.lstoutput.Size = New System.Drawing.Size(229, 95)
        Me.lstoutput.TabIndex = 0
        '
        'btnok
        '
        Me.btnok.Location = New System.Drawing.Point(118, 171)
        Me.btnok.Name = "btnok"
        Me.btnok.Size = New System.Drawing.Size(70, 37)
        Me.btnok.TabIndex = 1
        Me.btnok.Text = "OK"
        Me.btnok.UseVisualStyleBackColor = True
        '
        'Add
        '
        Me.AutoScaleDimensions = New System.Drawing.SizeF(6.0!, 13.0!)
        Me.AutoScaleMode = System.Windows.Forms.AutoScaleMode.Font
        Me.ClientSize = New System.Drawing.Size(292, 266)
        Me.Controls.Add(Me.btnok)
        Me.Controls.Add(Me.lstoutput)
        Me.Name = "Add"
        Me.Text = "Add"
        Me.ResumeLayout(False)

    End Sub
    Friend WithEvents lstoutput As System.Windows.Forms.ListBox
    Friend WithEvents btnok As System.Windows.Forms.Button
End Class
