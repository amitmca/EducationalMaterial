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
    Friend WithEvents Button1 As System.Windows.Forms.Button
    Friend WithEvents DataGrid1 As System.Windows.Forms.DataGrid
    <System.Diagnostics.DebuggerStepThrough()> Private Sub InitializeComponent()
        Me.Panel1 = New System.Windows.Forms.Panel
        Me.DataGrid1 = New System.Windows.Forms.DataGrid
        Me.Button1 = New System.Windows.Forms.Button
        Me.Panel1.SuspendLayout()
        CType(Me.DataGrid1, System.ComponentModel.ISupportInitialize).BeginInit()
        Me.SuspendLayout()
        '
        'Panel1
        '
        Me.Panel1.Controls.Add(Me.DataGrid1)
        Me.Panel1.Location = New System.Drawing.Point(0, 80)
        Me.Panel1.Name = "Panel1"
        Me.Panel1.Size = New System.Drawing.Size(936, 264)
        Me.Panel1.TabIndex = 0
        '
        'DataGrid1
        '
        Me.DataGrid1.AlternatingBackColor = System.Drawing.Color.OldLace
        Me.DataGrid1.BackColor = System.Drawing.Color.OldLace
        Me.DataGrid1.BackgroundColor = System.Drawing.Color.Tan
        Me.DataGrid1.BorderStyle = System.Windows.Forms.BorderStyle.None
        Me.DataGrid1.CaptionBackColor = System.Drawing.Color.SaddleBrown
        Me.DataGrid1.CaptionForeColor = System.Drawing.Color.OldLace
        Me.DataGrid1.DataMember = ""
        Me.DataGrid1.Dock = System.Windows.Forms.DockStyle.Fill
        Me.DataGrid1.FlatMode = True
        Me.DataGrid1.Font = New System.Drawing.Font("Tahoma", 8.0!)
        Me.DataGrid1.ForeColor = System.Drawing.Color.DarkSlateGray
        Me.DataGrid1.GridLineColor = System.Drawing.Color.Tan
        Me.DataGrid1.HeaderBackColor = System.Drawing.Color.Wheat
        Me.DataGrid1.HeaderFont = New System.Drawing.Font("Tahoma", 8.0!, System.Drawing.FontStyle.Bold)
        Me.DataGrid1.HeaderForeColor = System.Drawing.Color.SaddleBrown
        Me.DataGrid1.LinkColor = System.Drawing.Color.DarkSlateBlue
        Me.DataGrid1.Location = New System.Drawing.Point(0, 0)
        Me.DataGrid1.Name = "DataGrid1"
        Me.DataGrid1.ParentRowsBackColor = System.Drawing.Color.OldLace
        Me.DataGrid1.ParentRowsForeColor = System.Drawing.Color.DarkSlateGray
        Me.DataGrid1.SelectionBackColor = System.Drawing.Color.SlateGray
        Me.DataGrid1.SelectionForeColor = System.Drawing.Color.White
        Me.DataGrid1.Size = New System.Drawing.Size(936, 264)
        Me.DataGrid1.TabIndex = 0
        '
        'Button1
        '
        Me.Button1.FlatStyle = System.Windows.Forms.FlatStyle.System
        Me.Button1.Location = New System.Drawing.Point(24, 40)
        Me.Button1.Name = "Button1"
        Me.Button1.TabIndex = 1
        Me.Button1.Text = "Load Data"
        '
        'Form1
        '
        Me.AutoScaleBaseSize = New System.Drawing.Size(5, 13)
        Me.ClientSize = New System.Drawing.Size(720, 346)
        Me.Controls.Add(Me.Button1)
        Me.Controls.Add(Me.Panel1)
        Me.Name = "Form1"
        Me.Text = "DataSetCode Example"
        Me.Panel1.ResumeLayout(False)
        CType(Me.DataGrid1, System.ComponentModel.ISupportInitialize).EndInit()
        Me.ResumeLayout(False)

    End Sub

#End Region

    Private Sub Button1_Click(ByVal sender As System.Object, ByVal e As System.EventArgs) Handles Button1.Click


        Dim ds As New DataSet
        ds = New DataSet("authors")

        Dim ConnectionString As String = "Integrated Security=SSPI;User ID=sa;Data Source=""CHARUL\NetSDK"";Tag with column c" & _
        "ollation when possible=False;Initial Catalog=pubs;Use Procedure for Prepare=1;Au" & _
        "to Translate=True;Persist Security Info=False;Provider=""SQLOLEDB.1"";Workstation " & _
        "ID=CHARUL;Use Encryption for Data=False;Packet Size=4096"

        Dim Connection1 As OleDb.OleDbConnection = New OleDb.OleDbConnection(ConnectionString)
        Dim Command1 As OleDb.OleDbCommand = New OleDb.OleDbCommand("SELECT * FROM authors")

        Command1.CommandType = CommandType.Text

        Connection1.Open()
        Command1.Connection = Connection1


        Dim OleDbDataAdapter1 As OleDb.OleDbDataAdapter = New OleDb.OleDbDataAdapter

        OleDbDataAdapter1.SelectCommand = Command1
        OleDbDataAdapter1.TableMappings.Add("table", "authors")

        OleDbDataAdapter1.Fill(ds)

        DataGrid1.SetDataBinding(ds, "table")


    End Sub

    
    Private Sub Form1_Load(ByVal sender As System.Object, ByVal e As System.EventArgs) Handles MyBase.Load

    End Sub
End Class
