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
    Friend WithEvents Panel1 As System.Windows.Forms.Panel
    Friend WithEvents Panel2 As System.Windows.Forms.Panel
    Friend WithEvents DataGrid1 As System.Windows.Forms.DataGrid
    Friend WithEvents DataGrid2 As System.Windows.Forms.DataGrid
    Friend WithEvents Label1 As System.Windows.Forms.Label
    Friend WithEvents Label2 As System.Windows.Forms.Label
    Friend WithEvents SqlDataAdapter1 As System.Data.SqlClient.SqlDataAdapter
    Friend WithEvents SqlSelectCommand1 As System.Data.SqlClient.SqlCommand
    Friend WithEvents SqlInsertCommand1 As System.Data.SqlClient.SqlCommand
    Friend WithEvents SqlUpdateCommand1 As System.Data.SqlClient.SqlCommand
    Friend WithEvents SqlDeleteCommand1 As System.Data.SqlClient.SqlCommand
    Friend WithEvents SqlConnection1 As System.Data.SqlClient.SqlConnection
    Friend WithEvents SqlDataAdapter2 As System.Data.SqlClient.SqlDataAdapter
    Friend WithEvents SqlSelectCommand2 As System.Data.SqlClient.SqlCommand
    Friend WithEvents SqlInsertCommand2 As System.Data.SqlClient.SqlCommand
    Friend WithEvents SqlUpdateCommand2 As System.Data.SqlClient.SqlCommand
    Friend WithEvents SqlDeleteCommand2 As System.Data.SqlClient.SqlCommand
    Friend WithEvents DataSet11 As Multitable.DataSet1
    <System.Diagnostics.DebuggerStepThrough()> Private Sub InitializeComponent()
        Me.Panel1 = New System.Windows.Forms.Panel
        Me.DataGrid1 = New System.Windows.Forms.DataGrid
        Me.Panel2 = New System.Windows.Forms.Panel
        Me.DataGrid2 = New System.Windows.Forms.DataGrid
        Me.Label1 = New System.Windows.Forms.Label
        Me.Label2 = New System.Windows.Forms.Label
        Me.SqlDataAdapter1 = New System.Data.SqlClient.SqlDataAdapter
        Me.SqlSelectCommand1 = New System.Data.SqlClient.SqlCommand
        Me.SqlInsertCommand1 = New System.Data.SqlClient.SqlCommand
        Me.SqlUpdateCommand1 = New System.Data.SqlClient.SqlCommand
        Me.SqlDeleteCommand1 = New System.Data.SqlClient.SqlCommand
        Me.SqlConnection1 = New System.Data.SqlClient.SqlConnection
        Me.SqlDataAdapter2 = New System.Data.SqlClient.SqlDataAdapter
        Me.SqlSelectCommand2 = New System.Data.SqlClient.SqlCommand
        Me.SqlInsertCommand2 = New System.Data.SqlClient.SqlCommand
        Me.SqlUpdateCommand2 = New System.Data.SqlClient.SqlCommand
        Me.SqlDeleteCommand2 = New System.Data.SqlClient.SqlCommand
        Me.DataSet11 = New Multitable.DataSet1
        Me.Panel1.SuspendLayout()
        CType(Me.DataGrid1, System.ComponentModel.ISupportInitialize).BeginInit()
        Me.Panel2.SuspendLayout()
        CType(Me.DataGrid2, System.ComponentModel.ISupportInitialize).BeginInit()
        CType(Me.DataSet11, System.ComponentModel.ISupportInitialize).BeginInit()
        Me.SuspendLayout()
        '
        'Panel1
        '
        Me.Panel1.Controls.Add(Me.DataGrid1)
        Me.Panel1.Location = New System.Drawing.Point(8, 32)
        Me.Panel1.Name = "Panel1"
        Me.Panel1.Size = New System.Drawing.Size(192, 240)
        Me.Panel1.TabIndex = 0
        '
        'DataGrid1
        '
        Me.DataGrid1.DataMember = "publishers"
        Me.DataGrid1.DataSource = Me.DataSet11
        Me.DataGrid1.Dock = System.Windows.Forms.DockStyle.Fill
        Me.DataGrid1.HeaderForeColor = System.Drawing.SystemColors.ControlText
        Me.DataGrid1.Location = New System.Drawing.Point(0, 0)
        Me.DataGrid1.Name = "DataGrid1"
        Me.DataGrid1.Size = New System.Drawing.Size(192, 240)
        Me.DataGrid1.TabIndex = 0
        '
        'Panel2
        '
        Me.Panel2.Controls.Add(Me.DataGrid2)
        Me.Panel2.Location = New System.Drawing.Point(320, 32)
        Me.Panel2.Name = "Panel2"
        Me.Panel2.Size = New System.Drawing.Size(216, 240)
        Me.Panel2.TabIndex = 1
        '
        'DataGrid2
        '
        Me.DataGrid2.DataMember = "authors"
        Me.DataGrid2.DataSource = Me.DataSet11
        Me.DataGrid2.Dock = System.Windows.Forms.DockStyle.Fill
        Me.DataGrid2.HeaderForeColor = System.Drawing.SystemColors.ControlText
        Me.DataGrid2.Location = New System.Drawing.Point(0, 0)
        Me.DataGrid2.Name = "DataGrid2"
        Me.DataGrid2.Size = New System.Drawing.Size(216, 240)
        Me.DataGrid2.TabIndex = 0
        '
        'Label1
        '
        Me.Label1.Location = New System.Drawing.Point(16, 8)
        Me.Label1.Name = "Label1"
        Me.Label1.Size = New System.Drawing.Size(100, 16)
        Me.Label1.TabIndex = 2
        Me.Label1.Text = "Data Grid 1"
        '
        'Label2
        '
        Me.Label2.Location = New System.Drawing.Point(328, 8)
        Me.Label2.Name = "Label2"
        Me.Label2.Size = New System.Drawing.Size(100, 16)
        Me.Label2.TabIndex = 3
        Me.Label2.Text = "Data Grid 2"
        '
        'SqlDataAdapter1
        '
        Me.SqlDataAdapter1.DeleteCommand = Me.SqlDeleteCommand1
        Me.SqlDataAdapter1.InsertCommand = Me.SqlInsertCommand1
        Me.SqlDataAdapter1.SelectCommand = Me.SqlSelectCommand1
        Me.SqlDataAdapter1.TableMappings.AddRange(New System.Data.Common.DataTableMapping() {New System.Data.Common.DataTableMapping("Table", "authors", New System.Data.Common.DataColumnMapping() {New System.Data.Common.DataColumnMapping("au_id", "au_id"), New System.Data.Common.DataColumnMapping("au_lname", "au_lname"), New System.Data.Common.DataColumnMapping("au_fname", "au_fname"), New System.Data.Common.DataColumnMapping("phone", "phone")})})
        Me.SqlDataAdapter1.UpdateCommand = Me.SqlUpdateCommand1
        '
        'SqlSelectCommand1
        '
        Me.SqlSelectCommand1.CommandText = "SELECT au_id, au_lname, au_fname, phone FROM authors"
        Me.SqlSelectCommand1.Connection = Me.SqlConnection1
        '
        'SqlInsertCommand1
        '
        Me.SqlInsertCommand1.CommandText = "INSERT INTO authors(au_id, au_lname, au_fname, phone) VALUES (@au_id, @au_lname, " & _
        "@au_fname, @phone); SELECT au_id, au_lname, au_fname, phone FROM authors WHERE (" & _
        "au_id = @au_id)"
        Me.SqlInsertCommand1.Connection = Me.SqlConnection1
        Me.SqlInsertCommand1.Parameters.Add(New System.Data.SqlClient.SqlParameter("@au_id", System.Data.SqlDbType.NVarChar, 11, "au_id"))
        Me.SqlInsertCommand1.Parameters.Add(New System.Data.SqlClient.SqlParameter("@au_lname", System.Data.SqlDbType.NVarChar, 40, "au_lname"))
        Me.SqlInsertCommand1.Parameters.Add(New System.Data.SqlClient.SqlParameter("@au_fname", System.Data.SqlDbType.NVarChar, 20, "au_fname"))
        Me.SqlInsertCommand1.Parameters.Add(New System.Data.SqlClient.SqlParameter("@phone", System.Data.SqlDbType.NVarChar, 12, "phone"))
        '
        'SqlUpdateCommand1
        '
        Me.SqlUpdateCommand1.CommandText = "UPDATE authors SET au_id = @au_id, au_lname = @au_lname, au_fname = @au_fname, ph" & _
        "one = @phone WHERE (au_id = @Original_au_id) AND (au_fname = @Original_au_fname)" & _
        " AND (au_lname = @Original_au_lname) AND (phone = @Original_phone); SELECT au_id" & _
        ", au_lname, au_fname, phone FROM authors WHERE (au_id = @au_id)"
        Me.SqlUpdateCommand1.Connection = Me.SqlConnection1
        Me.SqlUpdateCommand1.Parameters.Add(New System.Data.SqlClient.SqlParameter("@au_id", System.Data.SqlDbType.NVarChar, 11, "au_id"))
        Me.SqlUpdateCommand1.Parameters.Add(New System.Data.SqlClient.SqlParameter("@au_lname", System.Data.SqlDbType.NVarChar, 40, "au_lname"))
        Me.SqlUpdateCommand1.Parameters.Add(New System.Data.SqlClient.SqlParameter("@au_fname", System.Data.SqlDbType.NVarChar, 20, "au_fname"))
        Me.SqlUpdateCommand1.Parameters.Add(New System.Data.SqlClient.SqlParameter("@phone", System.Data.SqlDbType.NVarChar, 12, "phone"))
        Me.SqlUpdateCommand1.Parameters.Add(New System.Data.SqlClient.SqlParameter("@Original_au_id", System.Data.SqlDbType.NVarChar, 11, System.Data.ParameterDirection.Input, False, CType(0, Byte), CType(0, Byte), "au_id", System.Data.DataRowVersion.Original, Nothing))
        Me.SqlUpdateCommand1.Parameters.Add(New System.Data.SqlClient.SqlParameter("@Original_au_fname", System.Data.SqlDbType.NVarChar, 20, System.Data.ParameterDirection.Input, False, CType(0, Byte), CType(0, Byte), "au_fname", System.Data.DataRowVersion.Original, Nothing))
        Me.SqlUpdateCommand1.Parameters.Add(New System.Data.SqlClient.SqlParameter("@Original_au_lname", System.Data.SqlDbType.NVarChar, 40, System.Data.ParameterDirection.Input, False, CType(0, Byte), CType(0, Byte), "au_lname", System.Data.DataRowVersion.Original, Nothing))
        Me.SqlUpdateCommand1.Parameters.Add(New System.Data.SqlClient.SqlParameter("@Original_phone", System.Data.SqlDbType.NVarChar, 12, System.Data.ParameterDirection.Input, False, CType(0, Byte), CType(0, Byte), "phone", System.Data.DataRowVersion.Original, Nothing))
        '
        'SqlDeleteCommand1
        '
        Me.SqlDeleteCommand1.CommandText = "DELETE FROM authors WHERE (au_id = @Original_au_id) AND (au_fname = @Original_au_" & _
        "fname) AND (au_lname = @Original_au_lname) AND (phone = @Original_phone)"
        Me.SqlDeleteCommand1.Connection = Me.SqlConnection1
        Me.SqlDeleteCommand1.Parameters.Add(New System.Data.SqlClient.SqlParameter("@Original_au_id", System.Data.SqlDbType.NVarChar, 11, System.Data.ParameterDirection.Input, False, CType(0, Byte), CType(0, Byte), "au_id", System.Data.DataRowVersion.Original, Nothing))
        Me.SqlDeleteCommand1.Parameters.Add(New System.Data.SqlClient.SqlParameter("@Original_au_fname", System.Data.SqlDbType.NVarChar, 20, System.Data.ParameterDirection.Input, False, CType(0, Byte), CType(0, Byte), "au_fname", System.Data.DataRowVersion.Original, Nothing))
        Me.SqlDeleteCommand1.Parameters.Add(New System.Data.SqlClient.SqlParameter("@Original_au_lname", System.Data.SqlDbType.NVarChar, 40, System.Data.ParameterDirection.Input, False, CType(0, Byte), CType(0, Byte), "au_lname", System.Data.DataRowVersion.Original, Nothing))
        Me.SqlDeleteCommand1.Parameters.Add(New System.Data.SqlClient.SqlParameter("@Original_phone", System.Data.SqlDbType.NVarChar, 12, System.Data.ParameterDirection.Input, False, CType(0, Byte), CType(0, Byte), "phone", System.Data.DataRowVersion.Original, Nothing))
        '
        'SqlConnection1
        '
        Me.SqlConnection1.ConnectionString = "workstation id=CHARUL;packet size=4096;user id=sa;integrated security=SSPI;data s" & _
        "ource=""CHARUL\NetSDK"";persist security info=False;initial catalog=pubs"
        '
        'SqlDataAdapter2
        '
        Me.SqlDataAdapter2.DeleteCommand = Me.SqlDeleteCommand2
        Me.SqlDataAdapter2.InsertCommand = Me.SqlInsertCommand2
        Me.SqlDataAdapter2.SelectCommand = Me.SqlSelectCommand2
        Me.SqlDataAdapter2.TableMappings.AddRange(New System.Data.Common.DataTableMapping() {New System.Data.Common.DataTableMapping("Table", "publishers", New System.Data.Common.DataColumnMapping() {New System.Data.Common.DataColumnMapping("pub_id", "pub_id"), New System.Data.Common.DataColumnMapping("pub_name", "pub_name"), New System.Data.Common.DataColumnMapping("city", "city"), New System.Data.Common.DataColumnMapping("state", "state")})})
        Me.SqlDataAdapter2.UpdateCommand = Me.SqlUpdateCommand2
        '
        'SqlSelectCommand2
        '
        Me.SqlSelectCommand2.CommandText = "SELECT pub_id, pub_name, city, state FROM publishers"
        Me.SqlSelectCommand2.Connection = Me.SqlConnection1
        '
        'SqlInsertCommand2
        '
        Me.SqlInsertCommand2.CommandText = "INSERT INTO publishers(pub_id, pub_name, city, state) VALUES (@pub_id, @pub_name," & _
        " @city, @state); SELECT pub_id, pub_name, city, state FROM publishers WHERE (pub" & _
        "_id = @pub_id)"
        Me.SqlInsertCommand2.Connection = Me.SqlConnection1
        Me.SqlInsertCommand2.Parameters.Add(New System.Data.SqlClient.SqlParameter("@pub_id", System.Data.SqlDbType.NVarChar, 4, "pub_id"))
        Me.SqlInsertCommand2.Parameters.Add(New System.Data.SqlClient.SqlParameter("@pub_name", System.Data.SqlDbType.NVarChar, 40, "pub_name"))
        Me.SqlInsertCommand2.Parameters.Add(New System.Data.SqlClient.SqlParameter("@city", System.Data.SqlDbType.NVarChar, 20, "city"))
        Me.SqlInsertCommand2.Parameters.Add(New System.Data.SqlClient.SqlParameter("@state", System.Data.SqlDbType.NVarChar, 2, "state"))
        '
        'SqlUpdateCommand2
        '
        Me.SqlUpdateCommand2.CommandText = "UPDATE publishers SET pub_id = @pub_id, pub_name = @pub_name, city = @city, state" & _
        " = @state WHERE (pub_id = @Original_pub_id) AND (city = @Original_city OR @Origi" & _
        "nal_city IS NULL AND city IS NULL) AND (pub_name = @Original_pub_name OR @Origin" & _
        "al_pub_name IS NULL AND pub_name IS NULL) AND (state = @Original_state OR @Origi" & _
        "nal_state IS NULL AND state IS NULL); SELECT pub_id, pub_name, city, state FROM " & _
        "publishers WHERE (pub_id = @pub_id)"
        Me.SqlUpdateCommand2.Connection = Me.SqlConnection1
        Me.SqlUpdateCommand2.Parameters.Add(New System.Data.SqlClient.SqlParameter("@pub_id", System.Data.SqlDbType.NVarChar, 4, "pub_id"))
        Me.SqlUpdateCommand2.Parameters.Add(New System.Data.SqlClient.SqlParameter("@pub_name", System.Data.SqlDbType.NVarChar, 40, "pub_name"))
        Me.SqlUpdateCommand2.Parameters.Add(New System.Data.SqlClient.SqlParameter("@city", System.Data.SqlDbType.NVarChar, 20, "city"))
        Me.SqlUpdateCommand2.Parameters.Add(New System.Data.SqlClient.SqlParameter("@state", System.Data.SqlDbType.NVarChar, 2, "state"))
        Me.SqlUpdateCommand2.Parameters.Add(New System.Data.SqlClient.SqlParameter("@Original_pub_id", System.Data.SqlDbType.NVarChar, 4, System.Data.ParameterDirection.Input, False, CType(0, Byte), CType(0, Byte), "pub_id", System.Data.DataRowVersion.Original, Nothing))
        Me.SqlUpdateCommand2.Parameters.Add(New System.Data.SqlClient.SqlParameter("@Original_city", System.Data.SqlDbType.NVarChar, 20, System.Data.ParameterDirection.Input, False, CType(0, Byte), CType(0, Byte), "city", System.Data.DataRowVersion.Original, Nothing))
        Me.SqlUpdateCommand2.Parameters.Add(New System.Data.SqlClient.SqlParameter("@Original_pub_name", System.Data.SqlDbType.NVarChar, 40, System.Data.ParameterDirection.Input, False, CType(0, Byte), CType(0, Byte), "pub_name", System.Data.DataRowVersion.Original, Nothing))
        Me.SqlUpdateCommand2.Parameters.Add(New System.Data.SqlClient.SqlParameter("@Original_state", System.Data.SqlDbType.NVarChar, 2, System.Data.ParameterDirection.Input, False, CType(0, Byte), CType(0, Byte), "state", System.Data.DataRowVersion.Original, Nothing))
        '
        'SqlDeleteCommand2
        '
        Me.SqlDeleteCommand2.CommandText = "DELETE FROM publishers WHERE (pub_id = @Original_pub_id) AND (city = @Original_ci" & _
        "ty OR @Original_city IS NULL AND city IS NULL) AND (pub_name = @Original_pub_nam" & _
        "e OR @Original_pub_name IS NULL AND pub_name IS NULL) AND (state = @Original_sta" & _
        "te OR @Original_state IS NULL AND state IS NULL)"
        Me.SqlDeleteCommand2.Connection = Me.SqlConnection1
        Me.SqlDeleteCommand2.Parameters.Add(New System.Data.SqlClient.SqlParameter("@Original_pub_id", System.Data.SqlDbType.NVarChar, 4, System.Data.ParameterDirection.Input, False, CType(0, Byte), CType(0, Byte), "pub_id", System.Data.DataRowVersion.Original, Nothing))
        Me.SqlDeleteCommand2.Parameters.Add(New System.Data.SqlClient.SqlParameter("@Original_city", System.Data.SqlDbType.NVarChar, 20, System.Data.ParameterDirection.Input, False, CType(0, Byte), CType(0, Byte), "city", System.Data.DataRowVersion.Original, Nothing))
        Me.SqlDeleteCommand2.Parameters.Add(New System.Data.SqlClient.SqlParameter("@Original_pub_name", System.Data.SqlDbType.NVarChar, 40, System.Data.ParameterDirection.Input, False, CType(0, Byte), CType(0, Byte), "pub_name", System.Data.DataRowVersion.Original, Nothing))
        Me.SqlDeleteCommand2.Parameters.Add(New System.Data.SqlClient.SqlParameter("@Original_state", System.Data.SqlDbType.NVarChar, 2, System.Data.ParameterDirection.Input, False, CType(0, Byte), CType(0, Byte), "state", System.Data.DataRowVersion.Original, Nothing))
        '
        'DataSet11
        '
        Me.DataSet11.DataSetName = "DataSet1"
        Me.DataSet11.Locale = New System.Globalization.CultureInfo("en-US")
        '
        'Form1
        '
        Me.AutoScaleBaseSize = New System.Drawing.Size(5, 13)
        Me.ClientSize = New System.Drawing.Size(552, 290)
        Me.Controls.Add(Me.Label2)
        Me.Controls.Add(Me.Label1)
        Me.Controls.Add(Me.Panel2)
        Me.Controls.Add(Me.Panel1)
        Me.Name = "Form1"
        Me.Text = "MultiTable Example"
        Me.Panel1.ResumeLayout(False)
        CType(Me.DataGrid1, System.ComponentModel.ISupportInitialize).EndInit()
        Me.Panel2.ResumeLayout(False)
        CType(Me.DataGrid2, System.ComponentModel.ISupportInitialize).EndInit()
        CType(Me.DataSet11, System.ComponentModel.ISupportInitialize).EndInit()
        Me.ResumeLayout(False)

    End Sub

#End Region

    Private Sub Form1_Load(ByVal sender As System.Object, ByVal e As System.EventArgs) Handles MyBase.Load
        DataSet11.Clear()

        SqlDataAdapter1.Fill(DataSet11)
        SqlDataAdapter2.Fill(DataSet11)
    End Sub

    
End Class
