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
    Friend WithEvents OleDbDataAdapter1 As System.Data.OleDb.OleDbDataAdapter
    Friend WithEvents OleDbConnection1 As System.Data.OleDb.OleDbConnection
    Friend WithEvents DataSet11 As DataAccess.DataSet1
    Friend WithEvents btn_loadData As System.Windows.Forms.Button
    Friend WithEvents btn_updateData As System.Windows.Forms.Button
    Friend WithEvents DataGrid1 As System.Windows.Forms.DataGrid
    Friend WithEvents OleDbSelectCommand1 As System.Data.OleDb.OleDbCommand
    Friend WithEvents OleDbInsertCommand1 As System.Data.OleDb.OleDbCommand
    Friend WithEvents OleDbUpdateCommand1 As System.Data.OleDb.OleDbCommand
    Friend WithEvents OleDbDeleteCommand1 As System.Data.OleDb.OleDbCommand
    <System.Diagnostics.DebuggerStepThrough()> Private Sub InitializeComponent()
        Me.OleDbDataAdapter1 = New System.Data.OleDb.OleDbDataAdapter
        Me.OleDbDeleteCommand1 = New System.Data.OleDb.OleDbCommand
        Me.OleDbConnection1 = New System.Data.OleDb.OleDbConnection
        Me.OleDbInsertCommand1 = New System.Data.OleDb.OleDbCommand
        Me.OleDbSelectCommand1 = New System.Data.OleDb.OleDbCommand
        Me.OleDbUpdateCommand1 = New System.Data.OleDb.OleDbCommand
        Me.DataSet11 = New DataAccess.DataSet1
        Me.btn_loadData = New System.Windows.Forms.Button
        Me.btn_updateData = New System.Windows.Forms.Button
        Me.DataGrid1 = New System.Windows.Forms.DataGrid
        CType(Me.DataSet11, System.ComponentModel.ISupportInitialize).BeginInit()
        CType(Me.DataGrid1, System.ComponentModel.ISupportInitialize).BeginInit()
        Me.SuspendLayout()
        '
        'OleDbDataAdapter1
        '
        Me.OleDbDataAdapter1.DeleteCommand = Me.OleDbDeleteCommand1
        Me.OleDbDataAdapter1.InsertCommand = Me.OleDbInsertCommand1
        Me.OleDbDataAdapter1.SelectCommand = Me.OleDbSelectCommand1
        Me.OleDbDataAdapter1.TableMappings.AddRange(New System.Data.Common.DataTableMapping() {New System.Data.Common.DataTableMapping("Table", "authors", New System.Data.Common.DataColumnMapping() {New System.Data.Common.DataColumnMapping("au_id", "au_id"), New System.Data.Common.DataColumnMapping("au_lname", "au_lname"), New System.Data.Common.DataColumnMapping("au_fname", "au_fname"), New System.Data.Common.DataColumnMapping("phone", "phone")})})
        Me.OleDbDataAdapter1.UpdateCommand = Me.OleDbUpdateCommand1
        '
        'OleDbDeleteCommand1
        '
        Me.OleDbDeleteCommand1.CommandText = "DELETE FROM authors WHERE (au_id = ?) AND (au_fname = ?) AND (au_lname = ?) AND (" & _
        "phone = ?)"
        Me.OleDbDeleteCommand1.Connection = Me.OleDbConnection1
        Me.OleDbDeleteCommand1.Parameters.Add(New System.Data.OleDb.OleDbParameter("Original_au_id", System.Data.OleDb.OleDbType.VarWChar, 11, System.Data.ParameterDirection.Input, False, CType(0, Byte), CType(0, Byte), "au_id", System.Data.DataRowVersion.Original, Nothing))
        Me.OleDbDeleteCommand1.Parameters.Add(New System.Data.OleDb.OleDbParameter("Original_au_fname", System.Data.OleDb.OleDbType.VarWChar, 20, System.Data.ParameterDirection.Input, False, CType(0, Byte), CType(0, Byte), "au_fname", System.Data.DataRowVersion.Original, Nothing))
        Me.OleDbDeleteCommand1.Parameters.Add(New System.Data.OleDb.OleDbParameter("Original_au_lname", System.Data.OleDb.OleDbType.VarWChar, 40, System.Data.ParameterDirection.Input, False, CType(0, Byte), CType(0, Byte), "au_lname", System.Data.DataRowVersion.Original, Nothing))
        Me.OleDbDeleteCommand1.Parameters.Add(New System.Data.OleDb.OleDbParameter("Original_phone", System.Data.OleDb.OleDbType.VarWChar, 12, System.Data.ParameterDirection.Input, False, CType(0, Byte), CType(0, Byte), "phone", System.Data.DataRowVersion.Original, Nothing))
        '
        'OleDbConnection1
        '
        Me.OleDbConnection1.ConnectionString = "Integrated Security=SSPI;User ID=sa;Data Source=""CHARUL\NetSDK"";Tag with column c" & _
        "ollation when possible=False;Initial Catalog=pubs;Use Procedure for Prepare=1;Au" & _
        "to Translate=True;Persist Security Info=False;Provider=""SQLOLEDB.1"";Workstation " & _
        "ID=CHARUL;Use Encryption for Data=False;Packet Size=4096"
        '
        'OleDbInsertCommand1
        '
        Me.OleDbInsertCommand1.CommandText = "INSERT INTO authors(au_id, au_lname, au_fname, phone) VALUES (?, ?, ?, ?); SELECT" & _
        " au_id, au_lname, au_fname, phone FROM authors WHERE (au_id = ?)"
        Me.OleDbInsertCommand1.Connection = Me.OleDbConnection1
        Me.OleDbInsertCommand1.Parameters.Add(New System.Data.OleDb.OleDbParameter("au_id", System.Data.OleDb.OleDbType.VarWChar, 11, "au_id"))
        Me.OleDbInsertCommand1.Parameters.Add(New System.Data.OleDb.OleDbParameter("au_lname", System.Data.OleDb.OleDbType.VarWChar, 40, "au_lname"))
        Me.OleDbInsertCommand1.Parameters.Add(New System.Data.OleDb.OleDbParameter("au_fname", System.Data.OleDb.OleDbType.VarWChar, 20, "au_fname"))
        Me.OleDbInsertCommand1.Parameters.Add(New System.Data.OleDb.OleDbParameter("phone", System.Data.OleDb.OleDbType.VarWChar, 12, "phone"))
        Me.OleDbInsertCommand1.Parameters.Add(New System.Data.OleDb.OleDbParameter("Select_au_id", System.Data.OleDb.OleDbType.VarWChar, 11, "au_id"))
        '
        'OleDbSelectCommand1
        '
        Me.OleDbSelectCommand1.CommandText = "SELECT au_id, au_lname, au_fname, phone FROM authors"
        Me.OleDbSelectCommand1.Connection = Me.OleDbConnection1
        '
        'OleDbUpdateCommand1
        '
        Me.OleDbUpdateCommand1.CommandText = "UPDATE authors SET au_id = ?, au_lname = ?, au_fname = ?, phone = ? WHERE (au_id " & _
        "= ?) AND (au_fname = ?) AND (au_lname = ?) AND (phone = ?); SELECT au_id, au_lna" & _
        "me, au_fname, phone FROM authors WHERE (au_id = ?)"
        Me.OleDbUpdateCommand1.Connection = Me.OleDbConnection1
        Me.OleDbUpdateCommand1.Parameters.Add(New System.Data.OleDb.OleDbParameter("au_id", System.Data.OleDb.OleDbType.VarWChar, 11, "au_id"))
        Me.OleDbUpdateCommand1.Parameters.Add(New System.Data.OleDb.OleDbParameter("au_lname", System.Data.OleDb.OleDbType.VarWChar, 40, "au_lname"))
        Me.OleDbUpdateCommand1.Parameters.Add(New System.Data.OleDb.OleDbParameter("au_fname", System.Data.OleDb.OleDbType.VarWChar, 20, "au_fname"))
        Me.OleDbUpdateCommand1.Parameters.Add(New System.Data.OleDb.OleDbParameter("phone", System.Data.OleDb.OleDbType.VarWChar, 12, "phone"))
        Me.OleDbUpdateCommand1.Parameters.Add(New System.Data.OleDb.OleDbParameter("Original_au_id", System.Data.OleDb.OleDbType.VarWChar, 11, System.Data.ParameterDirection.Input, False, CType(0, Byte), CType(0, Byte), "au_id", System.Data.DataRowVersion.Original, Nothing))
        Me.OleDbUpdateCommand1.Parameters.Add(New System.Data.OleDb.OleDbParameter("Original_au_fname", System.Data.OleDb.OleDbType.VarWChar, 20, System.Data.ParameterDirection.Input, False, CType(0, Byte), CType(0, Byte), "au_fname", System.Data.DataRowVersion.Original, Nothing))
        Me.OleDbUpdateCommand1.Parameters.Add(New System.Data.OleDb.OleDbParameter("Original_au_lname", System.Data.OleDb.OleDbType.VarWChar, 40, System.Data.ParameterDirection.Input, False, CType(0, Byte), CType(0, Byte), "au_lname", System.Data.DataRowVersion.Original, Nothing))
        Me.OleDbUpdateCommand1.Parameters.Add(New System.Data.OleDb.OleDbParameter("Original_phone", System.Data.OleDb.OleDbType.VarWChar, 12, System.Data.ParameterDirection.Input, False, CType(0, Byte), CType(0, Byte), "phone", System.Data.DataRowVersion.Original, Nothing))
        Me.OleDbUpdateCommand1.Parameters.Add(New System.Data.OleDb.OleDbParameter("Select_au_id", System.Data.OleDb.OleDbType.VarWChar, 11, "au_id"))
        '
        'DataSet11
        '
        Me.DataSet11.DataSetName = "DataSet1"
        Me.DataSet11.Locale = New System.Globalization.CultureInfo("en-US")
        '
        'btn_loadData
        '
        Me.btn_loadData.Location = New System.Drawing.Point(8, 256)
        Me.btn_loadData.Name = "btn_loadData"
        Me.btn_loadData.TabIndex = 1
        Me.btn_loadData.Text = "Load Data"
        '
        'btn_updateData
        '
        Me.btn_updateData.Location = New System.Drawing.Point(152, 256)
        Me.btn_updateData.Name = "btn_updateData"
        Me.btn_updateData.Size = New System.Drawing.Size(88, 23)
        Me.btn_updateData.TabIndex = 2
        Me.btn_updateData.Text = "Update Data"
        '
        'DataGrid1
        '
        Me.DataGrid1.DataMember = "authors"
        Me.DataGrid1.DataSource = Me.DataSet11
        Me.DataGrid1.Dock = System.Windows.Forms.DockStyle.Top
        Me.DataGrid1.HeaderForeColor = System.Drawing.SystemColors.ControlText
        Me.DataGrid1.Location = New System.Drawing.Point(0, 0)
        Me.DataGrid1.Name = "DataGrid1"
        Me.DataGrid1.Size = New System.Drawing.Size(528, 232)
        Me.DataGrid1.TabIndex = 0
        '
        'Form1
        '
        Me.AutoScaleBaseSize = New System.Drawing.Size(5, 13)
        Me.ClientSize = New System.Drawing.Size(528, 290)
        Me.Controls.Add(Me.btn_updateData)
        Me.Controls.Add(Me.btn_loadData)
        Me.Controls.Add(Me.DataGrid1)
        Me.Name = "Form1"
        Me.Text = "Form1"
        CType(Me.DataSet11, System.ComponentModel.ISupportInitialize).EndInit()
        CType(Me.DataGrid1, System.ComponentModel.ISupportInitialize).EndInit()
        Me.ResumeLayout(False)

    End Sub

#End Region

    Private Sub Form1_Load(ByVal sender As System.Object, ByVal e As System.EventArgs) Handles MyBase.Load
        
    End Sub

    Private Sub btn_loadData_Click(ByVal sender As System.Object, ByVal e As System.EventArgs) Handles btn_loadData.Click
        DataSet11.Clear()
        OleDbDataAdapter1.Fill(DataSet11)

    End Sub

    Private Sub btn_updateData_Click(ByVal sender As System.Object, ByVal e As System.EventArgs) Handles btn_updateData.Click
        OleDbDataAdapter1.Update(DataSet11)


    End Sub



End Class
