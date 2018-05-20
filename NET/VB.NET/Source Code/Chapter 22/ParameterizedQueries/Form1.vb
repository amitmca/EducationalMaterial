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
    Friend WithEvents ComboBox1 As System.Windows.Forms.ComboBox
    Friend WithEvents Label1 As System.Windows.Forms.Label
    Friend WithEvents SqlDataAdapter1 As System.Data.SqlClient.SqlDataAdapter
    Friend WithEvents SqlConnection1 As System.Data.SqlClient.SqlConnection
    Friend WithEvents DataSet11 As ParameterizedQueries.DataSet1
    Friend WithEvents SqlDataAdapter2 As System.Data.SqlClient.SqlDataAdapter
    Friend WithEvents Myset1 As ParameterizedQueries.MYSET
    Friend WithEvents DataGrid1 As System.Windows.Forms.DataGrid
    Friend WithEvents SqlSelectCommand1 As System.Data.SqlClient.SqlCommand
    Friend WithEvents SqlSelectCommand2 As System.Data.SqlClient.SqlCommand
    <System.Diagnostics.DebuggerStepThrough()> Private Sub InitializeComponent()
        Me.ComboBox1 = New System.Windows.Forms.ComboBox
        Me.DataSet11 = New ParameterizedQueries.DataSet1
        Me.Label1 = New System.Windows.Forms.Label
        Me.SqlDataAdapter1 = New System.Data.SqlClient.SqlDataAdapter
        Me.SqlSelectCommand1 = New System.Data.SqlClient.SqlCommand
        Me.SqlConnection1 = New System.Data.SqlClient.SqlConnection
        Me.SqlDataAdapter2 = New System.Data.SqlClient.SqlDataAdapter
        Me.SqlSelectCommand2 = New System.Data.SqlClient.SqlCommand
        Me.Myset1 = New ParameterizedQueries.MYSET
        Me.DataGrid1 = New System.Windows.Forms.DataGrid
        CType(Me.DataSet11, System.ComponentModel.ISupportInitialize).BeginInit()
        CType(Me.Myset1, System.ComponentModel.ISupportInitialize).BeginInit()
        CType(Me.DataGrid1, System.ComponentModel.ISupportInitialize).BeginInit()
        Me.SuspendLayout()
        '
        'ComboBox1
        '
        Me.ComboBox1.DataSource = Me.DataSet11
        Me.ComboBox1.DisplayMember = "authors.state"
        Me.ComboBox1.Location = New System.Drawing.Point(109, 22)
        Me.ComboBox1.Name = "ComboBox1"
        Me.ComboBox1.Size = New System.Drawing.Size(121, 21)
        Me.ComboBox1.TabIndex = 0
        '
        'DataSet11
        '
        Me.DataSet11.DataSetName = "DataSet1"
        Me.DataSet11.Locale = New System.Globalization.CultureInfo("en-US")
        '
        'Label1
        '
        Me.Label1.Location = New System.Drawing.Point(16, 24)
        Me.Label1.Name = "Label1"
        Me.Label1.Size = New System.Drawing.Size(88, 16)
        Me.Label1.TabIndex = 1
        Me.Label1.Text = "Select State"
        '
        'SqlDataAdapter1
        '
        Me.SqlDataAdapter1.SelectCommand = Me.SqlSelectCommand1
        Me.SqlDataAdapter1.TableMappings.AddRange(New System.Data.Common.DataTableMapping() {New System.Data.Common.DataTableMapping("Table", "authors", New System.Data.Common.DataColumnMapping() {New System.Data.Common.DataColumnMapping("state", "state")})})
        '
        'SqlSelectCommand1
        '
        Me.SqlSelectCommand1.CommandText = "SELECT DISTINCT state FROM authors"
        Me.SqlSelectCommand1.Connection = Me.SqlConnection1
        '
        'SqlConnection1
        '
        Me.SqlConnection1.ConnectionString = "workstation id=CHARUL;packet size=4096;user id=sa;integrated security=SSPI;data s" & _
        "ource=""CHARUL\NetSDK"";persist security info=False;initial catalog=pubs"
        '   
        'SqlDataAdapter2
        '
        Me.SqlDataAdapter2.SelectCommand = Me.SqlSelectCommand2
        Me.SqlDataAdapter2.TableMappings.AddRange(New System.Data.Common.DataTableMapping() {New System.Data.Common.DataTableMapping("Table", "authors", New System.Data.Common.DataColumnMapping() {New System.Data.Common.DataColumnMapping("au_id", "au_id"), New System.Data.Common.DataColumnMapping("au_lname", "au_lname"), New System.Data.Common.DataColumnMapping("au_fname", "au_fname"), New System.Data.Common.DataColumnMapping("phone", "phone"), New System.Data.Common.DataColumnMapping("address", "address"), New System.Data.Common.DataColumnMapping("city", "city"), New System.Data.Common.DataColumnMapping("state", "state"), New System.Data.Common.DataColumnMapping("zip", "zip"), New System.Data.Common.DataColumnMapping("contract", "contract")})})
        '
        'SqlSelectCommand2
        '
        Me.SqlSelectCommand2.CommandText = "SELECT au_id, au_lname, au_fname, phone, address, city, state, zip, contract FROM" & _
        " authors WHERE (state = @Param9)"
        Me.SqlSelectCommand2.Connection = Me.SqlConnection1
        Me.SqlSelectCommand2.Parameters.Add(New System.Data.SqlClient.SqlParameter("@Param9", System.Data.SqlDbType.NVarChar, 2, "state"))
        '
        'Myset1z
        '
        Me.Myset1.DataSetName = "MYSET"
        Me.Myset1.Locale = New System.Globalization.CultureInfo("en-US")
        '
        'DataGrid1
        '
        Me.DataGrid1.DataMember = "authors"
        Me.DataGrid1.DataSource = Me.Myset1
        Me.DataGrid1.Dock = System.Windows.Forms.DockStyle.Bottom
        Me.DataGrid1.HeaderForeColor = System.Drawing.SystemColors.ControlText
        Me.DataGrid1.Location = New System.Drawing.Point(0, 74)
        Me.DataGrid1.Name = "DataGrid1"
        Me.DataGrid1.Size = New System.Drawing.Size(720, 200)
        Me.DataGrid1.TabIndex = 3
        '
        'Form1
        '
        Me.AutoScaleBaseSize = New System.Drawing.Size(5, 13)
        Me.ClientSize = New System.Drawing.Size(720, 274)
        Me.Controls.Add(Me.DataGrid1)
        Me.Controls.Add(Me.Label1)
        Me.Controls.Add(Me.ComboBox1)
        Me.Name = "Form1"
        Me.StartPosition = System.Windows.Forms.FormStartPosition.CenterScreen
        Me.Text = "Parameterized Query Example"
        CType(Me.DataSet11, System.ComponentModel.ISupportInitialize).EndInit()
        CType(Me.Myset1, System.ComponentModel.ISupportInitialize).EndInit()
        CType(Me.DataGrid1, System.ComponentModel.ISupportInitialize).EndInit()
        Me.ResumeLayout(False)

    End Sub

#End Region

    
    Private Sub Form1_Load(ByVal sender As System.Object, ByVal e As System.EventArgs) Handles MyBase.Load
        DataSet11.Clear()
        SqlDataAdapter1.Fill(DataSet11)
    End Sub

    Private Sub ComboBox1_SelectedIndexChanged(ByVal sender As System.Object, ByVal e As System.EventArgs) Handles ComboBox1.SelectedIndexChanged
        SqlDataAdapter2.SelectCommand.Parameters("@param9").Value = ComboBox1.Text.ToString()
        Myset1.Clear()
        SqlDataAdapter2.Fill(Myset1)
    End Sub
End Class
