<Global.Microsoft.VisualBasic.CompilerServices.DesignerGenerated()> _
Partial Class oprator
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
        Me.lstbox = New System.Windows.Forms.ListBox
        Me.SuspendLayout()
        '
        'lstbox
        '
        Me.lstbox.Font = New System.Drawing.Font("Microsoft Sans Serif", 9.75!, System.Drawing.FontStyle.Regular, System.Drawing.GraphicsUnit.Point, CType(0, Byte))
        Me.lstbox.ForeColor = System.Drawing.SystemColors.MenuHighlight
        Me.lstbox.FormattingEnabled = True
        Me.lstbox.ItemHeight = 16
        Me.lstbox.Location = New System.Drawing.Point(69, 78)
        Me.lstbox.Name = "lstbox"
        Me.lstbox.Size = New System.Drawing.Size(261, 148)
        Me.lstbox.TabIndex = 0
        '
        'oprator
        '
        Me.AutoScaleDimensions = New System.Drawing.SizeF(6.0!, 13.0!)
        Me.AutoScaleMode = System.Windows.Forms.AutoScaleMode.Font
        Me.ClientSize = New System.Drawing.Size(382, 319)
        Me.Controls.Add(Me.lstbox)
        Me.Name = "oprator"
        Me.Text = "oprator"
        Me.ResumeLayout(False)

    End Sub
    Friend WithEvents lstbox As System.Windows.Forms.ListBox
End Class
