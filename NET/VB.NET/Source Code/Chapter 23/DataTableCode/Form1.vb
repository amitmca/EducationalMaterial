Public Class Form1
    Inherits System.Windows.Forms.Form

#Region " Windows Form Designer generated code "

    Public Sub New()
        MyBase.New()

        'This call is required by the Windows Form Designer.
        InitializeComponent()
        Application.EnableVisualStyles()


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
    Friend WithEvents DataGrid1 As System.Windows.Forms.DataGrid
    <System.Diagnostics.DebuggerStepThrough()> Private Sub InitializeComponent()
        Me.Button1 = New System.Windows.Forms.Button
        Me.DataGrid1 = New System.Windows.Forms.DataGrid
        CType(Me.DataGrid1, System.ComponentModel.ISupportInitialize).BeginInit()
        Me.SuspendLayout()
        '
        'Button1
        '
        Me.Button1.FlatStyle = System.Windows.Forms.FlatStyle.System
        Me.Button1.Location = New System.Drawing.Point(24, 40)
        Me.Button1.Name = "Button1"
        Me.Button1.Size = New System.Drawing.Size(200, 24)
        Me.Button1.TabIndex = 3
        Me.Button1.Text = "Create and Bind new data table"
        '
        'DataGrid1
        '
        Me.DataGrid1.AlternatingBackColor = System.Drawing.Color.GhostWhite
        Me.DataGrid1.BackColor = System.Drawing.Color.GhostWhite
        Me.DataGrid1.BackgroundColor = System.Drawing.Color.Lavender
        Me.DataGrid1.BorderStyle = System.Windows.Forms.BorderStyle.None
        Me.DataGrid1.CaptionBackColor = System.Drawing.Color.RoyalBlue
        Me.DataGrid1.CaptionForeColor = System.Drawing.Color.White
        Me.DataGrid1.DataMember = ""
        Me.DataGrid1.FlatMode = True
        Me.DataGrid1.Font = New System.Drawing.Font("Tahoma", 8.0!)
        Me.DataGrid1.ForeColor = System.Drawing.Color.MidnightBlue
        Me.DataGrid1.GridLineColor = System.Drawing.Color.RoyalBlue
        Me.DataGrid1.HeaderBackColor = System.Drawing.Color.MidnightBlue
        Me.DataGrid1.HeaderFont = New System.Drawing.Font("Tahoma", 8.0!, System.Drawing.FontStyle.Bold)
        Me.DataGrid1.HeaderForeColor = System.Drawing.Color.Lavender
        Me.DataGrid1.LinkColor = System.Drawing.Color.Teal
        Me.DataGrid1.Location = New System.Drawing.Point(0, 96)
        Me.DataGrid1.Name = "DataGrid1"
        Me.DataGrid1.ParentRowsBackColor = System.Drawing.Color.Lavender
        Me.DataGrid1.ParentRowsForeColor = System.Drawing.Color.MidnightBlue
        Me.DataGrid1.SelectionBackColor = System.Drawing.Color.Teal
        Me.DataGrid1.SelectionForeColor = System.Drawing.Color.PaleGreen
        Me.DataGrid1.Size = New System.Drawing.Size(488, 224)
        Me.DataGrid1.TabIndex = 4
        '
        'Form1
        '
        Me.AutoScaleBaseSize = New System.Drawing.Size(5, 13)
        Me.ClientSize = New System.Drawing.Size(336, 226)
        Me.Controls.Add(Me.DataGrid1)
        Me.Controls.Add(Me.Button1)
        Me.Name = "Form1"
        Me.Text = "Data Table Example"
        CType(Me.DataGrid1, System.ComponentModel.ISupportInitialize).EndInit()
        Me.ResumeLayout(False)

    End Sub

#End Region

    Private Sub Form1_Load(ByVal sender As System.Object, ByVal e As System.EventArgs) Handles MyBase.Load

    End Sub

    Private Sub Button1_Click(ByVal sender As System.Object, ByVal e As System.EventArgs) Handles Button1.Click
        Dim Table1 As DataTable
        Dim row1, row2, row3, row4 As DataRow
        Table1 = New DataTable("Employees")
        Dim FirstName As DataColumn = New DataColumn("First Name")
        FirstName.DataType = System.Type.GetType("System.String")
        Table1.Columns.Add(FirstName)
        Dim LastName As DataColumn = New DataColumn("Last Name")
        LastName.DataType = System.Type.GetType("System.String")
        Table1.Columns.Add(LastName)
        Dim ID As DataColumn = New DataColumn("ID")
        ID.DataType = System.Type.GetType("System.Int32")
        Table1.Columns.Add(ID)
        Dim Phone As DataColumn = New DataColumn("Phone")
        Phone.DataType = System.Type.GetType("System.String")
        Table1.Columns.Add(Phone)


        row1 = Table1.NewRow()
        row1("First Name") = "Amit"
        row1("Last Name") = "Sharma"
        Row1("ID") = 1
        row1("Phone") = "(91) 011-010101"
        Table1.Rows.Add(Row1)
        Row2 = Table1.NewRow()
        row2("First Name") = "Sudhir"
        row2("Last Name") = "Gupta"
        Row2("ID") = 2
        row2("Phone") = "(91) 011-010101"
        Table1.Rows.Add(Row2)
        Row3 = Table1.NewRow()
        row3("First Name") = "Sanya"
        row3("Last Name") = "Vats"
        Row3("ID") = 3
        row3("Phone") = "((91) 011-010101"
        Table1.Rows.Add(row3)
        row4 = Table1.NewRow()
        row4("First Name") = "Sonya"
        row4("Last Name") = "Kaur"
        row4("ID") = 4
        row4("Phone") = "(91) 011-010101"
        Table1.Rows.Add(row4)
        Dim ds As New DataSet
        ds = New DataSet
        ds.Tables.Add(Table1)
        DataGrid1.SetDataBinding(ds, "Employees")


    End Sub
End Class
