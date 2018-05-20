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
    Friend WithEvents SqlSelectCommand1 As System.Data.SqlClient.SqlCommand
    Friend WithEvents SqlInsertCommand1 As System.Data.SqlClient.SqlCommand
    Friend WithEvents SqlUpdateCommand1 As System.Data.SqlClient.SqlCommand
    Friend WithEvents SqlDeleteCommand1 As System.Data.SqlClient.SqlCommand
    Friend WithEvents SqlConnection1 As System.Data.SqlClient.SqlConnection
    Friend WithEvents SqlDataAdapter1 As System.Data.SqlClient.SqlDataAdapter
    Friend WithEvents DataSet11 As EasyAccess.DataSet1
    Friend WithEvents DataGrid1 As System.Windows.Forms.DataGrid
    <System.Diagnostics.DebuggerStepThrough()> Private Sub InitializeComponent()
        Me.SqlSelectCommand1 = New System.Data.SqlClient.SqlCommand
        Me.SqlConnection1 = New System.Data.SqlClient.SqlConnection
        Me.SqlInsertCommand1 = New System.Data.SqlClient.SqlCommand
        Me.SqlUpdateCommand1 = New System.Data.SqlClient.SqlCommand
        Me.SqlDeleteCommand1 = New System.Data.SqlClient.SqlCommand
        Me.SqlDataAdapter1 = New System.Data.SqlClient.SqlDataAdapter
        Me.DataSet11 = New EasyAccess.DataSet1
        Me.DataGrid1 = New System.Windows.Forms.DataGrid
        CType(Me.DataSet11, System.ComponentModel.ISupportInitialize).BeginInit()
        CType(Me.DataGrid1, System.ComponentModel.ISupportInitialize).BeginInit()
        Me.SuspendLayout()
        '
        'SqlSelectCommand1
        '
        Me.SqlSelectCommand1.CommandText = "SELECT au_id, au_lname, au_fname, phone, address, city, state, zip, contract FROM" & _
        " authors"
        Me.SqlSelectCommand1.Connection = Me.SqlConnection1
        '
        'SqlConnection1
        '
        Me.SqlConnection1.ConnectionString = "workstation id=CHARUL;packet size=4096;user id=sa;integrated security=SSPI;data s" & _
        "ource=""CHARUL\NetSDK"";persist security info=False;initial catalog=pubs"
        '
        'SqlInsertCommand1
        '
        Me.SqlInsertCommand1.CommandText = "INSERT INTO authors(au_id, au_lname, au_fname, phone, address, city, state, zip, " & _
        "contract) VALUES (@au_id, @au_lname, @au_fname, @phone, @address, @city, @state," & _
        " @zip, @contract); SELECT au_id, au_lname, au_fname, phone, address, city, state" & _
        ", zip, contract FROM authors WHERE (au_id = @au_id)"
        Me.SqlInsertCommand1.Connection = Me.SqlConnection1
        Me.SqlInsertCommand1.Parameters.Add(New System.Data.SqlClient.SqlParameter("@au_id", System.Data.SqlDbType.NVarChar, 11, "au_id"))
        Me.SqlInsertCommand1.Parameters.Add(New System.Data.SqlClient.SqlParameter("@au_lname", System.Data.SqlDbType.NVarChar, 40, "au_lname"))
        Me.SqlInsertCommand1.Parameters.Add(New System.Data.SqlClient.SqlParameter("@au_fname", System.Data.SqlDbType.NVarChar, 20, "au_fname"))
        Me.SqlInsertCommand1.Parameters.Add(New System.Data.SqlClient.SqlParameter("@phone", System.Data.SqlDbType.NVarChar, 12, "phone"))
        Me.SqlInsertCommand1.Parameters.Add(New System.Data.SqlClient.SqlParameter("@address", System.Data.SqlDbType.NVarChar, 40, "address"))
        Me.SqlInsertCommand1.Parameters.Add(New System.Data.SqlClient.SqlParameter("@city", System.Data.SqlDbType.NVarChar, 20, "city"))
        Me.SqlInsertCommand1.Parameters.Add(New System.Data.SqlClient.SqlParameter("@state", System.Data.SqlDbType.NVarChar, 2, "state"))
        Me.SqlInsertCommand1.Parameters.Add(New System.Data.SqlClient.SqlParameter("@zip", System.Data.SqlDbType.NVarChar, 5, "zip"))
        Me.SqlInsertCommand1.Parameters.Add(New System.Data.SqlClient.SqlParameter("@contract", System.Data.SqlDbType.Bit, 1, "contract"))
        '
        'SqlUpdateCommand1
        '
        Me.SqlUpdateCommand1.CommandText = "UPDATE authors SET au_id = @au_id, au_lname = @au_lname, au_fname = @au_fname, ph" & _
        "one = @phone, address = @address, city = @city, state = @state, zip = @zip, cont" & _
        "ract = @contract WHERE (au_id = @Original_au_id) AND (address = @Original_addres" & _
        "s OR @Original_address IS NULL AND address IS NULL) AND (au_fname = @Original_au" & _
        "_fname) AND (au_lname = @Original_au_lname) AND (city = @Original_city OR @Origi" & _
        "nal_city IS NULL AND city IS NULL) AND (contract = @Original_contract) AND (phon" & _
        "e = @Original_phone) AND (state = @Original_state OR @Original_state IS NULL AND" & _
        " state IS NULL) AND (zip = @Original_zip OR @Original_zip IS NULL AND zip IS NUL" & _
        "L); SELECT au_id, au_lname, au_fname, phone, address, city, state, zip, contract" & _
        " FROM authors WHERE (au_id = @au_id)"
        Me.SqlUpdateCommand1.Connection = Me.SqlConnection1
        Me.SqlUpdateCommand1.Parameters.Add(New System.Data.SqlClient.SqlParameter("@au_id", System.Data.SqlDbType.NVarChar, 11, "au_id"))
        Me.SqlUpdateCommand1.Parameters.Add(New System.Data.SqlClient.SqlParameter("@au_lname", System.Data.SqlDbType.NVarChar, 40, "au_lname"))
        Me.SqlUpdateCommand1.Parameters.Add(New System.Data.SqlClient.SqlParameter("@au_fname", System.Data.SqlDbType.NVarChar, 20, "au_fname"))
        Me.SqlUpdateCommand1.Parameters.Add(New System.Data.SqlClient.SqlParameter("@phone", System.Data.SqlDbType.NVarChar, 12, "phone"))
        Me.SqlUpdateCommand1.Parameters.Add(New System.Data.SqlClient.SqlParameter("@address", System.Data.SqlDbType.NVarChar, 40, "address"))
        Me.SqlUpdateCommand1.Parameters.Add(New System.Data.SqlClient.SqlParameter("@city", System.Data.SqlDbType.NVarChar, 20, "city"))
        Me.SqlUpdateCommand1.Parameters.Add(New System.Data.SqlClient.SqlParameter("@state", System.Data.SqlDbType.NVarChar, 2, "state"))
        Me.SqlUpdateCommand1.Parameters.Add(New System.Data.SqlClient.SqlParameter("@zip", System.Data.SqlDbType.NVarChar, 5, "zip"))
        Me.SqlUpdateCommand1.Parameters.Add(New System.Data.SqlClient.SqlParameter("@contract", System.Data.SqlDbType.Bit, 1, "contract"))
        Me.SqlUpdateCommand1.Parameters.Add(New System.Data.SqlClient.SqlParameter("@Original_au_id", System.Data.SqlDbType.NVarChar, 11, System.Data.ParameterDirection.Input, False, CType(0, Byte), CType(0, Byte), "au_id", System.Data.DataRowVersion.Original, Nothing))
        Me.SqlUpdateCommand1.Parameters.Add(New System.Data.SqlClient.SqlParameter("@Original_address", System.Data.SqlDbType.NVarChar, 40, System.Data.ParameterDirection.Input, False, CType(0, Byte), CType(0, Byte), "address", System.Data.DataRowVersion.Original, Nothing))
        Me.SqlUpdateCommand1.Parameters.Add(New System.Data.SqlClient.SqlParameter("@Original_au_fname", System.Data.SqlDbType.NVarChar, 20, System.Data.ParameterDirection.Input, False, CType(0, Byte), CType(0, Byte), "au_fname", System.Data.DataRowVersion.Original, Nothing))
        Me.SqlUpdateCommand1.Parameters.Add(New System.Data.SqlClient.SqlParameter("@Original_au_lname", System.Data.SqlDbType.NVarChar, 40, System.Data.ParameterDirection.Input, False, CType(0, Byte), CType(0, Byte), "au_lname", System.Data.DataRowVersion.Original, Nothing))
        Me.SqlUpdateCommand1.Parameters.Add(New System.Data.SqlClient.SqlParameter("@Original_city", System.Data.SqlDbType.NVarChar, 20, System.Data.ParameterDirection.Input, False, CType(0, Byte), CType(0, Byte), "city", System.Data.DataRowVersion.Original, Nothing))
        Me.SqlUpdateCommand1.Parameters.Add(New System.Data.SqlClient.SqlParameter("@Original_contract", System.Data.SqlDbType.Bit, 1, System.Data.ParameterDirection.Input, False, CType(0, Byte), CType(0, Byte), "contract", System.Data.DataRowVersion.Original, Nothing))
        Me.SqlUpdateCommand1.Parameters.Add(New System.Data.SqlClient.SqlParameter("@Original_phone", System.Data.SqlDbType.NVarChar, 12, System.Data.ParameterDirection.Input, False, CType(0, Byte), CType(0, Byte), "phone", System.Data.DataRowVersion.Original, Nothing))
        Me.SqlUpdateCommand1.Parameters.Add(New System.Data.SqlClient.SqlParameter("@Original_state", System.Data.SqlDbType.NVarChar, 2, System.Data.ParameterDirection.Input, False, CType(0, Byte), CType(0, Byte), "state", System.Data.DataRowVersion.Original, Nothing))
        Me.SqlUpdateCommand1.Parameters.Add(New System.Data.SqlClient.SqlParameter("@Original_zip", System.Data.SqlDbType.NVarChar, 5, System.Data.ParameterDirection.Input, False, CType(0, Byte), CType(0, Byte), "zip", System.Data.DataRowVersion.Original, Nothing))
        '
        'SqlDeleteCommand1
        '
        Me.SqlDeleteCommand1.CommandText = "DELETE FROM authors WHERE (au_id = @Original_au_id) AND (address = @Original_addr" & _
        "ess OR @Original_address IS NULL AND address IS NULL) AND (au_fname = @Original_" & _
        "au_fname) AND (au_lname = @Original_au_lname) AND (city = @Original_city OR @Ori" & _
        "ginal_city IS NULL AND city IS NULL) AND (contract = @Original_contract) AND (ph" & _
        "one = @Original_phone) AND (state = @Original_state OR @Original_state IS NULL A" & _
        "ND state IS NULL) AND (zip = @Original_zip OR @Original_zip IS NULL AND zip IS N" & _
        "ULL)"
        Me.SqlDeleteCommand1.Connection = Me.SqlConnection1
        Me.SqlDeleteCommand1.Parameters.Add(New System.Data.SqlClient.SqlParameter("@Original_au_id", System.Data.SqlDbType.NVarChar, 11, System.Data.ParameterDirection.Input, False, CType(0, Byte), CType(0, Byte), "au_id", System.Data.DataRowVersion.Original, Nothing))
        Me.SqlDeleteCommand1.Parameters.Add(New System.Data.SqlClient.SqlParameter("@Original_address", System.Data.SqlDbType.NVarChar, 40, System.Data.ParameterDirection.Input, False, CType(0, Byte), CType(0, Byte), "address", System.Data.DataRowVersion.Original, Nothing))
        Me.SqlDeleteCommand1.Parameters.Add(New System.Data.SqlClient.SqlParameter("@Original_au_fname", System.Data.SqlDbType.NVarChar, 20, System.Data.ParameterDirection.Input, False, CType(0, Byte), CType(0, Byte), "au_fname", System.Data.DataRowVersion.Original, Nothing))
        Me.SqlDeleteCommand1.Parameters.Add(New System.Data.SqlClient.SqlParameter("@Original_au_lname", System.Data.SqlDbType.NVarChar, 40, System.Data.ParameterDirection.Input, False, CType(0, Byte), CType(0, Byte), "au_lname", System.Data.DataRowVersion.Original, Nothing))
        Me.SqlDeleteCommand1.Parameters.Add(New System.Data.SqlClient.SqlParameter("@Original_city", System.Data.SqlDbType.NVarChar, 20, System.Data.ParameterDirection.Input, False, CType(0, Byte), CType(0, Byte), "city", System.Data.DataRowVersion.Original, Nothing))
        Me.SqlDeleteCommand1.Parameters.Add(New System.Data.SqlClient.SqlParameter("@Original_contract", System.Data.SqlDbType.Bit, 1, System.Data.ParameterDirection.Input, False, CType(0, Byte), CType(0, Byte), "contract", System.Data.DataRowVersion.Original, Nothing))
        Me.SqlDeleteCommand1.Parameters.Add(New System.Data.SqlClient.SqlParameter("@Original_phone", System.Data.SqlDbType.NVarChar, 12, System.Data.ParameterDirection.Input, False, CType(0, Byte), CType(0, Byte), "phone", System.Data.DataRowVersion.Original, Nothing))
        Me.SqlDeleteCommand1.Parameters.Add(New System.Data.SqlClient.SqlParameter("@Original_state", System.Data.SqlDbType.NVarChar, 2, System.Data.ParameterDirection.Input, False, CType(0, Byte), CType(0, Byte), "state", System.Data.DataRowVersion.Original, Nothing))
        Me.SqlDeleteCommand1.Parameters.Add(New System.Data.SqlClient.SqlParameter("@Original_zip", System.Data.SqlDbType.NVarChar, 5, System.Data.ParameterDirection.Input, False, CType(0, Byte), CType(0, Byte), "zip", System.Data.DataRowVersion.Original, Nothing))
        '
        'SqlDataAdapter1
        '
        Me.SqlDataAdapter1.DeleteCommand = Me.SqlDeleteCommand1
        Me.SqlDataAdapter1.InsertCommand = Me.SqlInsertCommand1
        Me.SqlDataAdapter1.SelectCommand = Me.SqlSelectCommand1
        Me.SqlDataAdapter1.TableMappings.AddRange(New System.Data.Common.DataTableMapping() {New System.Data.Common.DataTableMapping("Table", "authors", New System.Data.Common.DataColumnMapping() {New System.Data.Common.DataColumnMapping("au_id", "au_id"), New System.Data.Common.DataColumnMapping("au_lname", "au_lname"), New System.Data.Common.DataColumnMapping("au_fname", "au_fname"), New System.Data.Common.DataColumnMapping("phone", "phone"), New System.Data.Common.DataColumnMapping("address", "address"), New System.Data.Common.DataColumnMapping("city", "city"), New System.Data.Common.DataColumnMapping("state", "state"), New System.Data.Common.DataColumnMapping("zip", "zip"), New System.Data.Common.DataColumnMapping("contract", "contract")})})
        Me.SqlDataAdapter1.UpdateCommand = Me.SqlUpdateCommand1
        '
        'DataSet11
        '
        Me.DataSet11.DataSetName = "DataSet1"
        Me.DataSet11.Locale = New System.Globalization.CultureInfo("en-US")
        '
        'DataGrid1
        '
        Me.DataGrid1.DataMember = "authors"
        Me.DataGrid1.DataSource = Me.DataSet11
        Me.DataGrid1.Dock = System.Windows.Forms.DockStyle.Fill
        Me.DataGrid1.HeaderForeColor = System.Drawing.SystemColors.ControlText
        Me.DataGrid1.Location = New System.Drawing.Point(0, 0)
        Me.DataGrid1.Name = "DataGrid1"
        Me.DataGrid1.Size = New System.Drawing.Size(400, 266)
        Me.DataGrid1.TabIndex = 0
        '
        'Form1
        '
        Me.AutoScaleBaseSize = New System.Drawing.Size(5, 13)
        Me.ClientSize = New System.Drawing.Size(400, 266)
        Me.Controls.Add(Me.DataGrid1)
        Me.Name = "Form1"
        Me.StartPosition = System.Windows.Forms.FormStartPosition.CenterScreen
        Me.Text = "Form1"
        CType(Me.DataSet11, System.ComponentModel.ISupportInitialize).EndInit()
        CType(Me.DataGrid1, System.ComponentModel.ISupportInitialize).EndInit()
        Me.ResumeLayout(False)

    End Sub

#End Region

    Private Sub Form1_Load(ByVal sender As System.Object, ByVal e As System.EventArgs) Handles MyBase.Load
        DataSet11.Clear()
        SqlDataAdapter1.Fill(DataSet11)
    End Sub
End Class
