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
    Friend WithEvents Panel1 As System.Windows.Forms.Panel
    Friend WithEvents TextBox1 As System.Windows.Forms.TextBox
    Friend WithEvents OleDbDataAdapter1 As System.Data.OleDb.OleDbDataAdapter
    Friend WithEvents OleDbSelectCommand1 As System.Data.OleDb.OleDbCommand
    Friend WithEvents OleDbConnection1 As System.Data.OleDb.OleDbConnection
    Friend WithEvents DataSet11 As ReadData.DataSet1
    <System.Diagnostics.DebuggerStepThrough()> Private Sub InitializeComponent()
        Me.Panel1 = New System.Windows.Forms.Panel
        Me.TextBox1 = New System.Windows.Forms.TextBox
        Me.OleDbDataAdapter1 = New System.Data.OleDb.OleDbDataAdapter
        Me.OleDbSelectCommand1 = New System.Data.OleDb.OleDbCommand
        Me.OleDbConnection1 = New System.Data.OleDb.OleDbConnection
        Me.DataSet11 = New ReadData.DataSet1
        Me.Panel1.SuspendLayout()
        CType(Me.DataSet11, System.ComponentModel.ISupportInitialize).BeginInit()
        Me.SuspendLayout()
        '
        'Panel1
        '
        Me.Panel1.Controls.Add(Me.TextBox1)
        Me.Panel1.Location = New System.Drawing.Point(8, 40)
        Me.Panel1.Name = "Panel1"
        Me.Panel1.Size = New System.Drawing.Size(504, 208)
        Me.Panel1.TabIndex = 0
        '
        'TextBox1
        '
        Me.TextBox1.Dock = System.Windows.Forms.DockStyle.Fill
        Me.TextBox1.Location = New System.Drawing.Point(0, 0)
        Me.TextBox1.Multiline = True
        Me.TextBox1.Name = "TextBox1"
        Me.TextBox1.Size = New System.Drawing.Size(504, 208)
        Me.TextBox1.TabIndex = 0
        Me.TextBox1.Text = ""
        Me.TextBox1.WordWrap = False
        '
        'OleDbDataAdapter1
        '
        Me.OleDbDataAdapter1.SelectCommand = Me.OleDbSelectCommand1
        Me.OleDbDataAdapter1.TableMappings.AddRange(New System.Data.Common.DataTableMapping() {New System.Data.Common.DataTableMapping("Table", "authors", New System.Data.Common.DataColumnMapping() {New System.Data.Common.DataColumnMapping("au_id", "au_id"), New System.Data.Common.DataColumnMapping("au_lname", "au_lname"), New System.Data.Common.DataColumnMapping("au_fname", "au_fname"), New System.Data.Common.DataColumnMapping("phone", "phone")})})
        '
        'OleDbSelectCommand1
        '
        Me.OleDbSelectCommand1.CommandText = "SELECT au_id, au_lname, au_fname, phone FROM authors"
        Me.OleDbSelectCommand1.Connection = Me.OleDbConnection1
        '
        'OleDbConnection1
        '
        Me.OleDbConnection1.ConnectionString = "Integrated Security=SSPI;User ID=sa;Data Source=""CHARUL\NetSDK"";Tag with column c" & _
        "ollation when possible=False;Initial Catalog=pubs;Use Procedure for Prepare=1;Au" & _
        "to Translate=True;Persist Security Info=False;Provider=""SQLOLEDB.1"";Workstation " & _
        "ID=CHARUL;Use Encryption for Data=False;Packet Size=4096"
        '
        'DataSet11
        '
        Me.DataSet11.DataSetName = "DataSet1"
        Me.DataSet11.Locale = New System.Globalization.CultureInfo("en-US")
        '
        'Form1
        '
        Me.AutoScaleBaseSize = New System.Drawing.Size(5, 13)
        Me.ClientSize = New System.Drawing.Size(520, 282)
        Me.Controls.Add(Me.Panel1)
        Me.Name = "Form1"
        Me.Text = "Read Data Example"
        Me.Panel1.ResumeLayout(False)
        CType(Me.DataSet11, System.ComponentModel.ISupportInitialize).EndInit()
        Me.ResumeLayout(False)

    End Sub

#End Region

    Private Sub Form1_Load(ByVal sender As System.Object, ByVal e As System.EventArgs) Handles MyBase.Load
        Dim RowLoopIndex, ColLoopIndex As Integer
        DataSet11.Clear()
        OleDbDataAdapter1.Fill(DataSet11)
        For ColLoopIndex = 0 To (DataSet11.Tables("authors").Columns.Count - 1)
            TextBox1.Text &= _
            DataSet11.Tables( _
            "authors").Columns(ColLoopIndex).ColumnName & _
            ControlChars.Tab & ControlChars.Tab
            If ColLoopIndex = 0 Then 'Handle wide au_id field 
                TextBox1.Text &= ControlChars.Tab
            End If
        Next ColLoopIndex
        TextBox1.Text &= ControlChars.CrLf
        For ColLoopIndex = 0 To (DataSet11.Tables("authors").Columns.Count - 1)
            TextBox1.Text &= "———————" _
            & ControlChars.Tab & ControlChars.Tab
            If ColLoopIndex = 0 Then 'Handle wide au_id field 
                TextBox1.Text &= ControlChars.Tab
            End If
        Next ColLoopIndex
        TextBox1.Text &= ControlChars.CrLf
        For RowLoopIndex = 0 To (DataSet11.Tables("authors").Rows.Count - 1)
            For ColLoopIndex = 0 To _
            (DataSet11.Tables("authors").Columns.Count - 1)
                TextBox1.Text &= _
                DataSet11.Tables("authors").Rows(RowLoopIndex).Item(ColLoopIndex) _
                & ControlChars.Tab & ControlChars.Tab
            Next ColLoopIndex
            TextBox1.Text &= ControlChars.CrLf
        Next RowLoopIndex

    End Sub
End Class
