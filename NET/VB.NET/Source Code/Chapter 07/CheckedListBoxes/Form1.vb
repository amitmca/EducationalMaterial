Public Class Form1
    Inherits System.Windows.Forms.Form

#Region " Windows Form Designer generated code "

    Public Sub New()
        MyBase.New()

        'This call is required by the Windows Form Designer.
        InitializeComponent()

        'Add any initialization after the InitializeComponent() call

    End Sub

    'Form overrides dispose to clean up the component list.
    Protected Overloads Overrides Sub Dispose(ByVal disposing As Boolean)
        If disposing Then
            If Not (components Is Nothing) Then
                components.Dispose()
            End If
        End If
        MyBase.Dispose(disposing)
    End Sub

    'Required by the Windows Form Designer
    Private components As System.ComponentModel.IContainer

    'NOTE: The following procedure is required by the Windows Form Designer
    'It can be modified using the Windows Form Designer.  
    'Do not modify it using the code editor.
    Friend WithEvents Button1 As System.Windows.Forms.Button
    Friend WithEvents Button2 As System.Windows.Forms.Button
    Friend WithEvents Button3 As System.Windows.Forms.Button
    Friend WithEvents TextBox1 As System.Windows.Forms.TextBox
    Friend WithEvents CheckedListBox1 As System.Windows.Forms.CheckedListBox
    <System.Diagnostics.DebuggerStepThrough()> Private Sub InitializeComponent()
        Me.Button1 = New System.Windows.Forms.Button
        Me.Button2 = New System.Windows.Forms.Button
        Me.Button3 = New System.Windows.Forms.Button
        Me.TextBox1 = New System.Windows.Forms.TextBox
        Me.CheckedListBox1 = New System.Windows.Forms.CheckedListBox
        Me.SuspendLayout()
        '
        'Button1
        '
        Me.Button1.Location = New System.Drawing.Point(8, 192)
        Me.Button1.Name = "Button1"
        Me.Button1.TabIndex = 0
        Me.Button1.Text = "Fill list box"
        '
        'Button2
        '
        Me.Button2.Location = New System.Drawing.Point(90, 192)
        Me.Button2.Name = "Button2"
        Me.Button2.Size = New System.Drawing.Size(86, 23)
        Me.Button2.TabIndex = 1
        Me.Button2.Text = "Find checked"
        '
        'Button3
        '
        Me.Button3.Location = New System.Drawing.Point(192, 192)
        Me.Button3.Name = "Button3"
        Me.Button3.Size = New System.Drawing.Size(88, 23)
        Me.Button3.TabIndex = 2
        Me.Button3.Text = "Uncheck item"
        '
        'TextBox1
        '
        Me.TextBox1.Location = New System.Drawing.Point(56, 232)
        Me.TextBox1.Name = "TextBox1"
        Me.TextBox1.Size = New System.Drawing.Size(168, 20)
        Me.TextBox1.TabIndex = 4
        Me.TextBox1.Text = "TextBox1"
        '
        'CheckedListBox1
        '
        Me.CheckedListBox1.Location = New System.Drawing.Point(72, 24)
        Me.CheckedListBox1.Name = "CheckedListBox1"
        Me.CheckedListBox1.Size = New System.Drawing.Size(120, 94)
        Me.CheckedListBox1.TabIndex = 5
        '
        'Form1
        '
        Me.AutoScaleBaseSize = New System.Drawing.Size(5, 13)
        Me.ClientSize = New System.Drawing.Size(292, 266)
        Me.Controls.Add(Me.CheckedListBox1)
        Me.Controls.Add(Me.TextBox1)
        Me.Controls.Add(Me.Button3)
        Me.Controls.Add(Me.Button2)
        Me.Controls.Add(Me.Button1)
        Me.Name = "Form1"
        Me.Text = "Form1"
        Me.ResumeLayout(False)

    End Sub

#End Region
    Private Sub Button1_Click(ByVal sender As System.Object, _
        ByVal e As System.EventArgs) Handles Button1.Click
        CheckedListBox1.BeginUpdate()
        Dim intLoopIndex As Integer
        For intLoopIndex = 1 To 20
            CheckedListBox1.Items.Add("Item " & intLoopIndex.ToString(), True)
        Next intLoopIndex
        CheckedListBox1.EndUpdate()
    End Sub
    Private Sub Button2_Click(ByVal sender As System.Object, _
        ByVal e As System.EventArgs) Handles Button2.Click
        Dim intLoopIndex As Integer
        Dim strText, strData As String
        strText = "Checked Items: "

        For intLoopIndex = 0 To (CheckedListBox1.Items.Count - 1)
            If CheckedListBox1.GetItemChecked(intLoopIndex) = True Then
                strText &= CheckedListBox1.Items(intLoopIndex).ToString & ", "
            End If
        Next
        TextBox1.Text = strText
    End Sub
    Private Sub Button3_Click(ByVal sender As System.Object, _
    ByVal e As System.EventArgs) Handles Button3.Click
        CheckedListBox1.SetItemChecked(0, False)
    End Sub
    Private Sub CheckedListBox1_ItemCheck(ByVal sender As Object, _
        ByVal e As System.Windows.Forms.ItemCheckEventArgs) Handles _
        CheckedListBox1.ItemCheck
        Select Case e.NewValue
            Case CheckState.Checked
                TextBox1.Text = "Item " & e.Index + 1 & " is checked"
            Case CheckState.Unchecked
                TextBox1.Text = "Item " & e.Index + 1 & " is not checked"
        End Select
    End Sub
End Class
