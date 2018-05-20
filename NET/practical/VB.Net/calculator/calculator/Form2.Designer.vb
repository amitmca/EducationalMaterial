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
        Me.txt = New System.Windows.Forms.TextBox
        Me.btnadd = New System.Windows.Forms.Button
        Me.btnminus = New System.Windows.Forms.Button
        Me.btnmul = New System.Windows.Forms.Button
        Me.btndiv = New System.Windows.Forms.Button
        Me.btnequal = New System.Windows.Forms.Button
        Me.Panel1 = New System.Windows.Forms.Panel
        Me.clear = New System.Windows.Forms.Button
        Me.point = New System.Windows.Forms.Button
        Me.tzero = New System.Windows.Forms.Button
        Me.zero = New System.Windows.Forms.Button
        Me.one = New System.Windows.Forms.Button
        Me.four = New System.Windows.Forms.Button
        Me.seven = New System.Windows.Forms.Button
        Me.two = New System.Windows.Forms.Button
        Me.three = New System.Windows.Forms.Button
        Me.five = New System.Windows.Forms.Button
        Me.six = New System.Windows.Forms.Button
        Me.eight = New System.Windows.Forms.Button
        Me.nine = New System.Windows.Forms.Button
        Me.Panel1.SuspendLayout()
        Me.SuspendLayout()
        '
        'txt
        '
        Me.txt.Font = New System.Drawing.Font("Verdana", 14.25!, System.Drawing.FontStyle.Bold, System.Drawing.GraphicsUnit.Point, CType(0, Byte))
        Me.txt.Location = New System.Drawing.Point(38, 12)
        Me.txt.Name = "txt"
        Me.txt.Size = New System.Drawing.Size(243, 31)
        Me.txt.TabIndex = 0
        Me.txt.TextAlign = System.Windows.Forms.HorizontalAlignment.Right
        '
        'btnadd
        '
        Me.btnadd.Font = New System.Drawing.Font("Microsoft Sans Serif", 12.0!, System.Drawing.FontStyle.Bold, System.Drawing.GraphicsUnit.Point, CType(0, Byte))
        Me.btnadd.Location = New System.Drawing.Point(24, 190)
        Me.btnadd.Name = "btnadd"
        Me.btnadd.Size = New System.Drawing.Size(44, 32)
        Me.btnadd.TabIndex = 0
        Me.btnadd.Text = "+"
        Me.btnadd.UseVisualStyleBackColor = True
        '
        'btnminus
        '
        Me.btnminus.Font = New System.Drawing.Font("Microsoft Sans Serif", 14.25!, System.Drawing.FontStyle.Bold, System.Drawing.GraphicsUnit.Point, CType(0, Byte))
        Me.btnminus.Location = New System.Drawing.Point(93, 190)
        Me.btnminus.Name = "btnminus"
        Me.btnminus.Size = New System.Drawing.Size(41, 32)
        Me.btnminus.TabIndex = 1
        Me.btnminus.Text = "-"
        Me.btnminus.UseVisualStyleBackColor = True
        '
        'btnmul
        '
        Me.btnmul.Font = New System.Drawing.Font("Microsoft Sans Serif", 12.0!, System.Drawing.FontStyle.Bold, System.Drawing.GraphicsUnit.Point, CType(0, Byte))
        Me.btnmul.Location = New System.Drawing.Point(165, 190)
        Me.btnmul.Name = "btnmul"
        Me.btnmul.Size = New System.Drawing.Size(44, 32)
        Me.btnmul.TabIndex = 2
        Me.btnmul.Text = "*"
        Me.btnmul.UseVisualStyleBackColor = True
        '
        'btndiv
        '
        Me.btndiv.Font = New System.Drawing.Font("Microsoft Sans Serif", 12.0!, System.Drawing.FontStyle.Bold, System.Drawing.GraphicsUnit.Point, CType(0, Byte))
        Me.btndiv.Location = New System.Drawing.Point(24, 228)
        Me.btndiv.Name = "btndiv"
        Me.btndiv.Size = New System.Drawing.Size(44, 36)
        Me.btndiv.TabIndex = 3
        Me.btndiv.Text = "/"
        Me.btndiv.UseVisualStyleBackColor = True
        '
        'btnequal
        '
        Me.btnequal.Font = New System.Drawing.Font("Microsoft Sans Serif", 14.25!, System.Drawing.FontStyle.Bold, System.Drawing.GraphicsUnit.Point, CType(0, Byte))
        Me.btnequal.Location = New System.Drawing.Point(92, 227)
        Me.btnequal.Name = "btnequal"
        Me.btnequal.Size = New System.Drawing.Size(42, 37)
        Me.btnequal.TabIndex = 4
        Me.btnequal.Text = "="
        Me.btnequal.UseVisualStyleBackColor = True
        '
        'Panel1
        '
        Me.Panel1.BackColor = System.Drawing.Color.FromArgb(CType(CType(255, Byte), Integer), CType(CType(255, Byte), Integer), CType(CType(192, Byte), Integer))
        Me.Panel1.Controls.Add(Me.clear)
        Me.Panel1.Controls.Add(Me.btnequal)
        Me.Panel1.Controls.Add(Me.point)
        Me.Panel1.Controls.Add(Me.btndiv)
        Me.Panel1.Controls.Add(Me.tzero)
        Me.Panel1.Controls.Add(Me.btnmul)
        Me.Panel1.Controls.Add(Me.zero)
        Me.Panel1.Controls.Add(Me.btnminus)
        Me.Panel1.Controls.Add(Me.one)
        Me.Panel1.Controls.Add(Me.btnadd)
        Me.Panel1.Controls.Add(Me.four)
        Me.Panel1.Controls.Add(Me.seven)
        Me.Panel1.Controls.Add(Me.two)
        Me.Panel1.Controls.Add(Me.three)
        Me.Panel1.Controls.Add(Me.five)
        Me.Panel1.Controls.Add(Me.six)
        Me.Panel1.Controls.Add(Me.eight)
        Me.Panel1.Controls.Add(Me.nine)
        Me.Panel1.Font = New System.Drawing.Font("Microsoft Sans Serif", 12.0!, System.Drawing.FontStyle.Bold, System.Drawing.GraphicsUnit.Point, CType(0, Byte))
        Me.Panel1.Location = New System.Drawing.Point(38, 56)
        Me.Panel1.Name = "Panel1"
        Me.Panel1.Size = New System.Drawing.Size(243, 267)
        Me.Panel1.TabIndex = 2
        '
        'clear
        '
        Me.clear.Location = New System.Drawing.Point(165, 228)
        Me.clear.Name = "clear"
        Me.clear.Size = New System.Drawing.Size(44, 36)
        Me.clear.TabIndex = 12
        Me.clear.Text = "CE"
        Me.clear.UseVisualStyleBackColor = True
        '
        'point
        '
        Me.point.Font = New System.Drawing.Font("Microsoft Sans Serif", 12.0!, System.Drawing.FontStyle.Bold, System.Drawing.GraphicsUnit.Point, CType(0, Byte))
        Me.point.Location = New System.Drawing.Point(165, 148)
        Me.point.Name = "point"
        Me.point.Size = New System.Drawing.Size(44, 36)
        Me.point.TabIndex = 11
        Me.point.Text = "."
        Me.point.UseVisualStyleBackColor = True
        '
        'tzero
        '
        Me.tzero.Font = New System.Drawing.Font("Microsoft Sans Serif", 12.0!, System.Drawing.FontStyle.Bold, System.Drawing.GraphicsUnit.Point, CType(0, Byte))
        Me.tzero.Location = New System.Drawing.Point(93, 148)
        Me.tzero.Name = "tzero"
        Me.tzero.Size = New System.Drawing.Size(41, 36)
        Me.tzero.TabIndex = 10
        Me.tzero.Text = "00"
        Me.tzero.UseVisualStyleBackColor = True
        '
        'zero
        '
        Me.zero.Font = New System.Drawing.Font("Microsoft Sans Serif", 12.0!, System.Drawing.FontStyle.Bold, System.Drawing.GraphicsUnit.Point, CType(0, Byte))
        Me.zero.Location = New System.Drawing.Point(24, 148)
        Me.zero.Name = "zero"
        Me.zero.Size = New System.Drawing.Size(44, 36)
        Me.zero.TabIndex = 9
        Me.zero.Text = "0"
        Me.zero.UseVisualStyleBackColor = True
        '
        'one
        '
        Me.one.Font = New System.Drawing.Font("Microsoft Sans Serif", 12.0!, System.Drawing.FontStyle.Bold, System.Drawing.GraphicsUnit.Point, CType(0, Byte))
        Me.one.Location = New System.Drawing.Point(165, 110)
        Me.one.Name = "one"
        Me.one.Size = New System.Drawing.Size(44, 32)
        Me.one.TabIndex = 8
        Me.one.Text = "1"
        Me.one.UseVisualStyleBackColor = True
        '
        'four
        '
        Me.four.Font = New System.Drawing.Font("Microsoft Sans Serif", 12.0!, System.Drawing.FontStyle.Bold, System.Drawing.GraphicsUnit.Point, CType(0, Byte))
        Me.four.Location = New System.Drawing.Point(165, 71)
        Me.four.Name = "four"
        Me.four.Size = New System.Drawing.Size(44, 33)
        Me.four.TabIndex = 7
        Me.four.Text = "4"
        Me.four.UseVisualStyleBackColor = True
        '
        'seven
        '
        Me.seven.Font = New System.Drawing.Font("Microsoft Sans Serif", 12.0!, System.Drawing.FontStyle.Bold, System.Drawing.GraphicsUnit.Point, CType(0, Byte))
        Me.seven.Location = New System.Drawing.Point(165, 25)
        Me.seven.Name = "seven"
        Me.seven.Size = New System.Drawing.Size(44, 40)
        Me.seven.TabIndex = 6
        Me.seven.Text = "7"
        Me.seven.UseVisualStyleBackColor = True
        '
        'two
        '
        Me.two.Font = New System.Drawing.Font("Microsoft Sans Serif", 12.0!, System.Drawing.FontStyle.Bold, System.Drawing.GraphicsUnit.Point, CType(0, Byte))
        Me.two.Location = New System.Drawing.Point(93, 110)
        Me.two.Name = "two"
        Me.two.Size = New System.Drawing.Size(41, 32)
        Me.two.TabIndex = 5
        Me.two.Text = "2"
        Me.two.UseVisualStyleBackColor = True
        '
        'three
        '
        Me.three.Font = New System.Drawing.Font("Microsoft Sans Serif", 12.0!, System.Drawing.FontStyle.Bold, System.Drawing.GraphicsUnit.Point, CType(0, Byte))
        Me.three.Location = New System.Drawing.Point(24, 110)
        Me.three.Name = "three"
        Me.three.Size = New System.Drawing.Size(44, 32)
        Me.three.TabIndex = 4
        Me.three.Text = "3"
        Me.three.UseVisualStyleBackColor = True
        '
        'five
        '
        Me.five.Font = New System.Drawing.Font("Microsoft Sans Serif", 12.0!, System.Drawing.FontStyle.Bold, System.Drawing.GraphicsUnit.Point, CType(0, Byte))
        Me.five.Location = New System.Drawing.Point(92, 71)
        Me.five.Name = "five"
        Me.five.Size = New System.Drawing.Size(42, 33)
        Me.five.TabIndex = 3
        Me.five.Text = "5"
        Me.five.UseVisualStyleBackColor = True
        '
        'six
        '
        Me.six.Font = New System.Drawing.Font("Microsoft Sans Serif", 12.0!, System.Drawing.FontStyle.Bold, System.Drawing.GraphicsUnit.Point, CType(0, Byte))
        Me.six.Location = New System.Drawing.Point(24, 71)
        Me.six.Name = "six"
        Me.six.Size = New System.Drawing.Size(44, 33)
        Me.six.TabIndex = 2
        Me.six.Text = "6"
        Me.six.UseVisualStyleBackColor = True
        '
        'eight
        '
        Me.eight.Font = New System.Drawing.Font("Microsoft Sans Serif", 12.0!, System.Drawing.FontStyle.Bold, System.Drawing.GraphicsUnit.Point, CType(0, Byte))
        Me.eight.Location = New System.Drawing.Point(93, 25)
        Me.eight.Name = "eight"
        Me.eight.Size = New System.Drawing.Size(41, 40)
        Me.eight.TabIndex = 1
        Me.eight.Text = "8"
        Me.eight.UseVisualStyleBackColor = True
        '
        'nine
        '
        Me.nine.Font = New System.Drawing.Font("Microsoft Sans Serif", 12.0!, System.Drawing.FontStyle.Bold, System.Drawing.GraphicsUnit.Point, CType(0, Byte))
        Me.nine.Location = New System.Drawing.Point(24, 25)
        Me.nine.Name = "nine"
        Me.nine.Size = New System.Drawing.Size(44, 40)
        Me.nine.TabIndex = 0
        Me.nine.Text = "9"
        Me.nine.UseVisualStyleBackColor = True
        '
        'Form2
        '
        Me.AutoScaleDimensions = New System.Drawing.SizeF(6.0!, 13.0!)
        Me.AutoScaleMode = System.Windows.Forms.AutoScaleMode.Font
        Me.BackColor = System.Drawing.Color.FromArgb(CType(CType(224, Byte), Integer), CType(CType(224, Byte), Integer), CType(CType(224, Byte), Integer))
        Me.ClientSize = New System.Drawing.Size(311, 326)
        Me.Controls.Add(Me.Panel1)
        Me.Controls.Add(Me.txt)
        Me.Name = "Form2"
        Me.Text = "Form2"
        Me.Panel1.ResumeLayout(False)
        Me.ResumeLayout(False)
        Me.PerformLayout()

    End Sub
    Friend WithEvents txt As System.Windows.Forms.TextBox
    Friend WithEvents btnequal As System.Windows.Forms.Button
    Friend WithEvents btndiv As System.Windows.Forms.Button
    Friend WithEvents btnmul As System.Windows.Forms.Button
    Friend WithEvents btnminus As System.Windows.Forms.Button
    Friend WithEvents btnadd As System.Windows.Forms.Button
    Friend WithEvents Panel1 As System.Windows.Forms.Panel
    Friend WithEvents tzero As System.Windows.Forms.Button
    Friend WithEvents zero As System.Windows.Forms.Button
    Friend WithEvents one As System.Windows.Forms.Button
    Friend WithEvents four As System.Windows.Forms.Button
    Friend WithEvents seven As System.Windows.Forms.Button
    Friend WithEvents two As System.Windows.Forms.Button
    Friend WithEvents three As System.Windows.Forms.Button
    Friend WithEvents five As System.Windows.Forms.Button
    Friend WithEvents six As System.Windows.Forms.Button
    Friend WithEvents eight As System.Windows.Forms.Button
    Friend WithEvents nine As System.Windows.Forms.Button
    Friend WithEvents point As System.Windows.Forms.Button
    Friend WithEvents clear As System.Windows.Forms.Button
End Class
