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
        Me.Label2 = New System.Windows.Forms.Label
        Me.Label3 = New System.Windows.Forms.Label
        Me.Label4 = New System.Windows.Forms.Label
        Me.txtname = New System.Windows.Forms.TextBox
        Me.txtcontact = New System.Windows.Forms.TextBox
        Me.btnshw = New System.Windows.Forms.Button
        Me.Label5 = New System.Windows.Forms.Label
        Me.txtaddr = New System.Windows.Forms.RichTextBox
        Me.radm = New System.Windows.Forms.RadioButton
        Me.radf = New System.Windows.Forms.RadioButton
        Me.country = New System.Windows.Forms.ComboBox
        Me.showbox = New System.Windows.Forms.RichTextBox
        Me.SuspendLayout()
        '
        'Label1
        '
        Me.Label1.AutoSize = True
        Me.Label1.Location = New System.Drawing.Point(48, 32)
        Me.Label1.Margin = New System.Windows.Forms.Padding(6, 0, 6, 0)
        Me.Label1.Name = "Label1"
        Me.Label1.Size = New System.Drawing.Size(59, 18)
        Me.Label1.TabIndex = 0
        Me.Label1.Text = "Name"
        '
        'Label2
        '
        Me.Label2.AutoSize = True
        Me.Label2.Location = New System.Drawing.Point(48, 80)
        Me.Label2.Margin = New System.Windows.Forms.Padding(6, 0, 6, 0)
        Me.Label2.Name = "Label2"
        Me.Label2.Size = New System.Drawing.Size(79, 18)
        Me.Label2.TabIndex = 1
        Me.Label2.Text = "Address"
        '
        'Label3
        '
        Me.Label3.AutoSize = True
        Me.Label3.Location = New System.Drawing.Point(48, 136)
        Me.Label3.Margin = New System.Windows.Forms.Padding(6, 0, 6, 0)
        Me.Label3.Name = "Label3"
        Me.Label3.Size = New System.Drawing.Size(76, 18)
        Me.Label3.TabIndex = 2
        Me.Label3.Text = "Contact"
        '
        'Label4
        '
        Me.Label4.AutoSize = True
        Me.Label4.Location = New System.Drawing.Point(48, 181)
        Me.Label4.Margin = New System.Windows.Forms.Padding(6, 0, 6, 0)
        Me.Label4.Name = "Label4"
        Me.Label4.Size = New System.Drawing.Size(73, 18)
        Me.Label4.TabIndex = 3
        Me.Label4.Text = "Gender"
        '
        'txtname
        '
        Me.txtname.Location = New System.Drawing.Point(189, 23)
        Me.txtname.Margin = New System.Windows.Forms.Padding(6, 4, 6, 4)
        Me.txtname.Name = "txtname"
        Me.txtname.Size = New System.Drawing.Size(239, 27)
        Me.txtname.TabIndex = 4
        '
        'txtcontact
        '
        Me.txtcontact.Location = New System.Drawing.Point(189, 127)
        Me.txtcontact.Margin = New System.Windows.Forms.Padding(6, 4, 6, 4)
        Me.txtcontact.Name = "txtcontact"
        Me.txtcontact.Size = New System.Drawing.Size(246, 27)
        Me.txtcontact.TabIndex = 6
        '
        'btnshw
        '
        Me.btnshw.Location = New System.Drawing.Point(304, 272)
        Me.btnshw.Margin = New System.Windows.Forms.Padding(6, 4, 6, 4)
        Me.btnshw.Name = "btnshw"
        Me.btnshw.Size = New System.Drawing.Size(131, 32)
        Me.btnshw.TabIndex = 9
        Me.btnshw.Text = "SHOW"
        Me.btnshw.UseVisualStyleBackColor = True
        '
        'Label5
        '
        Me.Label5.AutoSize = True
        Me.Label5.Location = New System.Drawing.Point(48, 233)
        Me.Label5.Margin = New System.Windows.Forms.Padding(6, 0, 6, 0)
        Me.Label5.Name = "Label5"
        Me.Label5.Size = New System.Drawing.Size(78, 18)
        Me.Label5.TabIndex = 11
        Me.Label5.Text = "Country"
        '
        'txtaddr
        '
        Me.txtaddr.Location = New System.Drawing.Point(189, 60)
        Me.txtaddr.Margin = New System.Windows.Forms.Padding(6, 4, 6, 4)
        Me.txtaddr.Name = "txtaddr"
        Me.txtaddr.Size = New System.Drawing.Size(239, 58)
        Me.txtaddr.TabIndex = 12
        Me.txtaddr.Text = ""
        '
        'radm
        '
        Me.radm.AutoSize = True
        Me.radm.Location = New System.Drawing.Point(189, 181)
        Me.radm.Margin = New System.Windows.Forms.Padding(6, 4, 6, 4)
        Me.radm.Name = "radm"
        Me.radm.Size = New System.Drawing.Size(67, 22)
        Me.radm.TabIndex = 13
        Me.radm.TabStop = True
        Me.radm.Text = "Male"
        Me.radm.UseVisualStyleBackColor = True
        '
        'radf
        '
        Me.radf.AutoSize = True
        Me.radf.Location = New System.Drawing.Point(315, 181)
        Me.radf.Margin = New System.Windows.Forms.Padding(6, 4, 6, 4)
        Me.radf.Name = "radf"
        Me.radf.Size = New System.Drawing.Size(89, 22)
        Me.radf.TabIndex = 14
        Me.radf.TabStop = True
        Me.radf.Text = "Female"
        Me.radf.UseVisualStyleBackColor = True
        '
        'country
        '
        Me.country.FormattingEnabled = True
        Me.country.Items.AddRange(New Object() {"India", "America", "London", "Africa", "West Indies", "Australia", "Pakistan"})
        Me.country.Location = New System.Drawing.Point(189, 225)
        Me.country.Margin = New System.Windows.Forms.Padding(6, 4, 6, 4)
        Me.country.Name = "country"
        Me.country.Size = New System.Drawing.Size(246, 26)
        Me.country.TabIndex = 15
        '
        'showbox
        '
        Me.showbox.Location = New System.Drawing.Point(440, 13)
        Me.showbox.Margin = New System.Windows.Forms.Padding(6, 4, 6, 4)
        Me.showbox.Name = "showbox"
        Me.showbox.Size = New System.Drawing.Size(312, 238)
        Me.showbox.TabIndex = 16
        Me.showbox.Text = ""
        '
        'Form1
        '
        Me.AutoScaleDimensions = New System.Drawing.SizeF(11.0!, 18.0!)
        Me.AutoScaleMode = System.Windows.Forms.AutoScaleMode.Font
        Me.BackColor = System.Drawing.Color.FromArgb(CType(CType(192, Byte), Integer), CType(CType(255, Byte), Integer), CType(CType(255, Byte), Integer))
        Me.ClientSize = New System.Drawing.Size(757, 307)
        Me.Controls.Add(Me.showbox)
        Me.Controls.Add(Me.country)
        Me.Controls.Add(Me.radf)
        Me.Controls.Add(Me.radm)
        Me.Controls.Add(Me.txtaddr)
        Me.Controls.Add(Me.Label5)
        Me.Controls.Add(Me.btnshw)
        Me.Controls.Add(Me.txtcontact)
        Me.Controls.Add(Me.txtname)
        Me.Controls.Add(Me.Label4)
        Me.Controls.Add(Me.Label3)
        Me.Controls.Add(Me.Label2)
        Me.Controls.Add(Me.Label1)
        Me.Font = New System.Drawing.Font("Verdana", 12.0!, System.Drawing.FontStyle.Bold, System.Drawing.GraphicsUnit.Point, CType(0, Byte))
        Me.ForeColor = System.Drawing.Color.Red
        Me.Margin = New System.Windows.Forms.Padding(6, 4, 6, 4)
        Me.Name = "Form1"
        Me.Text = "Form1"
        Me.ResumeLayout(False)
        Me.PerformLayout()

    End Sub
    Friend WithEvents Label1 As System.Windows.Forms.Label
    Friend WithEvents Label2 As System.Windows.Forms.Label
    Friend WithEvents Label3 As System.Windows.Forms.Label
    Friend WithEvents Label4 As System.Windows.Forms.Label
    Friend WithEvents txtname As System.Windows.Forms.TextBox
    Friend WithEvents txtcontact As System.Windows.Forms.TextBox
    Friend WithEvents btnshw As System.Windows.Forms.Button
    Friend WithEvents Label5 As System.Windows.Forms.Label
    Friend WithEvents txtaddr As System.Windows.Forms.RichTextBox
    Friend WithEvents radm As System.Windows.Forms.RadioButton
    Friend WithEvents radf As System.Windows.Forms.RadioButton
    Friend WithEvents country As System.Windows.Forms.ComboBox
    Friend WithEvents showbox As System.Windows.Forms.RichTextBox

End Class
