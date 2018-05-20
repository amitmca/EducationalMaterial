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
    Friend WithEvents ComboBox1 As System.Windows.Forms.ComboBox
    <System.Diagnostics.DebuggerStepThrough()> Private Sub InitializeComponent()
        Me.ComboBox1 = New System.Windows.Forms.ComboBox
        Me.SuspendLayout()
        '
        'ComboBox1
        '
        Me.ComboBox1.Location = New System.Drawing.Point(72, 104)
        Me.ComboBox1.Name = "ComboBox1"
        Me.ComboBox1.Size = New System.Drawing.Size(152, 21)
        Me.ComboBox1.TabIndex = 0
        Me.ComboBox1.Text = "ComboBox1"
        '
        'Form1
        '
        Me.AutoScaleBaseSize = New System.Drawing.Size(5, 13)
        Me.ClientSize = New System.Drawing.Size(292, 266)
        Me.Controls.Add(Me.ComboBox1)
        Me.Name = "Form1"
        Me.Text = "Form1"
        Me.ResumeLayout(False)

    End Sub

#End Region
    Private Sub Form1_Load(ByVal sender As System.Object, _
     ByVal e As System.EventArgs) Handles MyBase.Load
        Dim Objects(20) As DataItem
        ComboBox1.BeginUpdate()
        Dim intLoopIndex As Integer
        For intLoopIndex = 0 To 20
            Objects(intLoopIndex) = New DataItem("Item " & intLoopIndex, _
            CSng(intLoopIndex))
            ComboBox1.Items.Add(Objects(intLoopIndex))
        Next
        ComboBox1.Text = "Select one..."
        ComboBox1.EndUpdate()
    End Sub

    Private Sub ComboBox1_SelectedIndexChanged(ByVal sender As _
        System.Object, ByVal e As System.EventArgs) Handles _
        ComboBox1.SelectedIndexChanged
        MsgBox("The data for the item you selected is: " & _
            CType(ComboBox1.SelectedItem, DataItem).GetData())
    End Sub
End Class

Public Structure DataItem
    Private Data As Single
    Private Name As String
    Public Sub New(ByVal NameArgument As String, ByVal Value As Single)
        Name = NameArgument
        Data = Value
    End Sub

    Overrides Function ToString() As String
        Return CStr(Name)
    End Function

    Public Function GetData() As Single
        Return Data
    End Function
End Structure
