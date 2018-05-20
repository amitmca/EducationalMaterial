Public Class WebForm1
    Inherits System.Web.UI.Page

#Region " Web Form Designer Generated Code "

    'This call is required by the Web Form Designer.
    <System.Diagnostics.DebuggerStepThrough()> Private Sub InitializeComponent()
        Me.OleDbDataAdapter1 = New System.Data.OleDb.OleDbDataAdapter
        Me.OleDbSelectCommand1 = New System.Data.OleDb.OleDbCommand
        Me.OleDbInsertCommand1 = New System.Data.OleDb.OleDbCommand
        Me.OleDbUpdateCommand1 = New System.Data.OleDb.OleDbCommand
        Me.OleDbDeleteCommand1 = New System.Data.OleDb.OleDbCommand
        Me.OleDbConnection1 = New System.Data.OleDb.OleDbConnection
        Me.DataView1 = New System.Data.DataView
        Me.DataSet11 = New WebDataNavigation.DataSet1
        CType(Me.DataView1, System.ComponentModel.ISupportInitialize).BeginInit()
        CType(Me.DataSet11, System.ComponentModel.ISupportInitialize).BeginInit()
        '
        'OleDbDataAdapter1
        '
        Me.OleDbDataAdapter1.DeleteCommand = Me.OleDbDeleteCommand1
        Me.OleDbDataAdapter1.InsertCommand = Me.OleDbInsertCommand1
        Me.OleDbDataAdapter1.SelectCommand = Me.OleDbSelectCommand1
        Me.OleDbDataAdapter1.TableMappings.AddRange(New System.Data.Common.DataTableMapping() {New System.Data.Common.DataTableMapping("Table", "authors", New System.Data.Common.DataColumnMapping() {New System.Data.Common.DataColumnMapping("au_id", "au_id"), New System.Data.Common.DataColumnMapping("au_lname", "au_lname"), New System.Data.Common.DataColumnMapping("au_fname", "au_fname"), New System.Data.Common.DataColumnMapping("phone", "phone"), New System.Data.Common.DataColumnMapping("address", "address"), New System.Data.Common.DataColumnMapping("city", "city"), New System.Data.Common.DataColumnMapping("state", "state"), New System.Data.Common.DataColumnMapping("zip", "zip"), New System.Data.Common.DataColumnMapping("contract", "contract")})})
        Me.OleDbDataAdapter1.UpdateCommand = Me.OleDbUpdateCommand1
        '
        'OleDbSelectCommand1
        '
        Me.OleDbSelectCommand1.CommandText = "SELECT au_id, au_lname, au_fname, phone, address, city, state, zip, contract FROM" & _
        " authors"
        Me.OleDbSelectCommand1.Connection = Me.OleDbConnection1
        '
        'OleDbInsertCommand1
        '
        Me.OleDbInsertCommand1.CommandText = "INSERT INTO authors(au_id, au_lname, au_fname, phone, address, city, state, zip, " & _
        "contract) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?); SELECT au_id, au_lname, au_fname, " & _
        "phone, address, city, state, zip, contract FROM authors WHERE (au_id = ?)"
        Me.OleDbInsertCommand1.Connection = Me.OleDbConnection1
        Me.OleDbInsertCommand1.Parameters.Add(New System.Data.OleDb.OleDbParameter("au_id", System.Data.OleDb.OleDbType.VarWChar, 11, "au_id"))
        Me.OleDbInsertCommand1.Parameters.Add(New System.Data.OleDb.OleDbParameter("au_lname", System.Data.OleDb.OleDbType.VarWChar, 40, "au_lname"))
        Me.OleDbInsertCommand1.Parameters.Add(New System.Data.OleDb.OleDbParameter("au_fname", System.Data.OleDb.OleDbType.VarWChar, 20, "au_fname"))
        Me.OleDbInsertCommand1.Parameters.Add(New System.Data.OleDb.OleDbParameter("phone", System.Data.OleDb.OleDbType.VarWChar, 12, "phone"))
        Me.OleDbInsertCommand1.Parameters.Add(New System.Data.OleDb.OleDbParameter("address", System.Data.OleDb.OleDbType.VarWChar, 40, "address"))
        Me.OleDbInsertCommand1.Parameters.Add(New System.Data.OleDb.OleDbParameter("city", System.Data.OleDb.OleDbType.VarWChar, 20, "city"))
        Me.OleDbInsertCommand1.Parameters.Add(New System.Data.OleDb.OleDbParameter("state", System.Data.OleDb.OleDbType.VarWChar, 2, "state"))
        Me.OleDbInsertCommand1.Parameters.Add(New System.Data.OleDb.OleDbParameter("zip", System.Data.OleDb.OleDbType.VarWChar, 5, "zip"))
        Me.OleDbInsertCommand1.Parameters.Add(New System.Data.OleDb.OleDbParameter("contract", System.Data.OleDb.OleDbType.Boolean, 1, "contract"))
        Me.OleDbInsertCommand1.Parameters.Add(New System.Data.OleDb.OleDbParameter("Select_au_id", System.Data.OleDb.OleDbType.VarWChar, 11, "au_id"))
        '
        'OleDbUpdateCommand1
        '
        Me.OleDbUpdateCommand1.CommandText = "UPDATE authors SET au_id = ?, au_lname = ?, au_fname = ?, phone = ?, address = ?," & _
        " city = ?, state = ?, zip = ?, contract = ? WHERE (au_id = ?) AND (address = ? O" & _
        "R ? IS NULL AND address IS NULL) AND (au_fname = ?) AND (au_lname = ?) AND (city" & _
        " = ? OR ? IS NULL AND city IS NULL) AND (contract = ?) AND (phone = ?) AND (stat" & _
        "e = ? OR ? IS NULL AND state IS NULL) AND (zip = ? OR ? IS NULL AND zip IS NULL)" & _
        "; SELECT au_id, au_lname, au_fname, phone, address, city, state, zip, contract F" & _
        "ROM authors WHERE (au_id = ?)"
        Me.OleDbUpdateCommand1.Connection = Me.OleDbConnection1
        Me.OleDbUpdateCommand1.Parameters.Add(New System.Data.OleDb.OleDbParameter("au_id", System.Data.OleDb.OleDbType.VarWChar, 11, "au_id"))
        Me.OleDbUpdateCommand1.Parameters.Add(New System.Data.OleDb.OleDbParameter("au_lname", System.Data.OleDb.OleDbType.VarWChar, 40, "au_lname"))
        Me.OleDbUpdateCommand1.Parameters.Add(New System.Data.OleDb.OleDbParameter("au_fname", System.Data.OleDb.OleDbType.VarWChar, 20, "au_fname"))
        Me.OleDbUpdateCommand1.Parameters.Add(New System.Data.OleDb.OleDbParameter("phone", System.Data.OleDb.OleDbType.VarWChar, 12, "phone"))
        Me.OleDbUpdateCommand1.Parameters.Add(New System.Data.OleDb.OleDbParameter("address", System.Data.OleDb.OleDbType.VarWChar, 40, "address"))
        Me.OleDbUpdateCommand1.Parameters.Add(New System.Data.OleDb.OleDbParameter("city", System.Data.OleDb.OleDbType.VarWChar, 20, "city"))
        Me.OleDbUpdateCommand1.Parameters.Add(New System.Data.OleDb.OleDbParameter("state", System.Data.OleDb.OleDbType.VarWChar, 2, "state"))
        Me.OleDbUpdateCommand1.Parameters.Add(New System.Data.OleDb.OleDbParameter("zip", System.Data.OleDb.OleDbType.VarWChar, 5, "zip"))
        Me.OleDbUpdateCommand1.Parameters.Add(New System.Data.OleDb.OleDbParameter("contract", System.Data.OleDb.OleDbType.Boolean, 1, "contract"))
        Me.OleDbUpdateCommand1.Parameters.Add(New System.Data.OleDb.OleDbParameter("Original_au_id", System.Data.OleDb.OleDbType.VarWChar, 11, System.Data.ParameterDirection.Input, False, CType(0, Byte), CType(0, Byte), "au_id", System.Data.DataRowVersion.Original, Nothing))
        Me.OleDbUpdateCommand1.Parameters.Add(New System.Data.OleDb.OleDbParameter("Original_address", System.Data.OleDb.OleDbType.VarWChar, 40, System.Data.ParameterDirection.Input, False, CType(0, Byte), CType(0, Byte), "address", System.Data.DataRowVersion.Original, Nothing))
        Me.OleDbUpdateCommand1.Parameters.Add(New System.Data.OleDb.OleDbParameter("Original_address1", System.Data.OleDb.OleDbType.VarWChar, 40, System.Data.ParameterDirection.Input, False, CType(0, Byte), CType(0, Byte), "address", System.Data.DataRowVersion.Original, Nothing))
        Me.OleDbUpdateCommand1.Parameters.Add(New System.Data.OleDb.OleDbParameter("Original_au_fname", System.Data.OleDb.OleDbType.VarWChar, 20, System.Data.ParameterDirection.Input, False, CType(0, Byte), CType(0, Byte), "au_fname", System.Data.DataRowVersion.Original, Nothing))
        Me.OleDbUpdateCommand1.Parameters.Add(New System.Data.OleDb.OleDbParameter("Original_au_lname", System.Data.OleDb.OleDbType.VarWChar, 40, System.Data.ParameterDirection.Input, False, CType(0, Byte), CType(0, Byte), "au_lname", System.Data.DataRowVersion.Original, Nothing))
        Me.OleDbUpdateCommand1.Parameters.Add(New System.Data.OleDb.OleDbParameter("Original_city", System.Data.OleDb.OleDbType.VarWChar, 20, System.Data.ParameterDirection.Input, False, CType(0, Byte), CType(0, Byte), "city", System.Data.DataRowVersion.Original, Nothing))
        Me.OleDbUpdateCommand1.Parameters.Add(New System.Data.OleDb.OleDbParameter("Original_city1", System.Data.OleDb.OleDbType.VarWChar, 20, System.Data.ParameterDirection.Input, False, CType(0, Byte), CType(0, Byte), "city", System.Data.DataRowVersion.Original, Nothing))
        Me.OleDbUpdateCommand1.Parameters.Add(New System.Data.OleDb.OleDbParameter("Original_contract", System.Data.OleDb.OleDbType.Boolean, 1, System.Data.ParameterDirection.Input, False, CType(0, Byte), CType(0, Byte), "contract", System.Data.DataRowVersion.Original, Nothing))
        Me.OleDbUpdateCommand1.Parameters.Add(New System.Data.OleDb.OleDbParameter("Original_phone", System.Data.OleDb.OleDbType.VarWChar, 12, System.Data.ParameterDirection.Input, False, CType(0, Byte), CType(0, Byte), "phone", System.Data.DataRowVersion.Original, Nothing))
        Me.OleDbUpdateCommand1.Parameters.Add(New System.Data.OleDb.OleDbParameter("Original_state", System.Data.OleDb.OleDbType.VarWChar, 2, System.Data.ParameterDirection.Input, False, CType(0, Byte), CType(0, Byte), "state", System.Data.DataRowVersion.Original, Nothing))
        Me.OleDbUpdateCommand1.Parameters.Add(New System.Data.OleDb.OleDbParameter("Original_state1", System.Data.OleDb.OleDbType.VarWChar, 2, System.Data.ParameterDirection.Input, False, CType(0, Byte), CType(0, Byte), "state", System.Data.DataRowVersion.Original, Nothing))
        Me.OleDbUpdateCommand1.Parameters.Add(New System.Data.OleDb.OleDbParameter("Original_zip", System.Data.OleDb.OleDbType.VarWChar, 5, System.Data.ParameterDirection.Input, False, CType(0, Byte), CType(0, Byte), "zip", System.Data.DataRowVersion.Original, Nothing))
        Me.OleDbUpdateCommand1.Parameters.Add(New System.Data.OleDb.OleDbParameter("Original_zip1", System.Data.OleDb.OleDbType.VarWChar, 5, System.Data.ParameterDirection.Input, False, CType(0, Byte), CType(0, Byte), "zip", System.Data.DataRowVersion.Original, Nothing))
        Me.OleDbUpdateCommand1.Parameters.Add(New System.Data.OleDb.OleDbParameter("Select_au_id", System.Data.OleDb.OleDbType.VarWChar, 11, "au_id"))
        '
        'OleDbDeleteCommand1
        '
        Me.OleDbDeleteCommand1.CommandText = "DELETE FROM authors WHERE (au_id = ?) AND (address = ? OR ? IS NULL AND address I" & _
        "S NULL) AND (au_fname = ?) AND (au_lname = ?) AND (city = ? OR ? IS NULL AND cit" & _
        "y IS NULL) AND (contract = ?) AND (phone = ?) AND (state = ? OR ? IS NULL AND st" & _
        "ate IS NULL) AND (zip = ? OR ? IS NULL AND zip IS NULL)"
        Me.OleDbDeleteCommand1.Connection = Me.OleDbConnection1
        Me.OleDbDeleteCommand1.Parameters.Add(New System.Data.OleDb.OleDbParameter("Original_au_id", System.Data.OleDb.OleDbType.VarWChar, 11, System.Data.ParameterDirection.Input, False, CType(0, Byte), CType(0, Byte), "au_id", System.Data.DataRowVersion.Original, Nothing))
        Me.OleDbDeleteCommand1.Parameters.Add(New System.Data.OleDb.OleDbParameter("Original_address", System.Data.OleDb.OleDbType.VarWChar, 40, System.Data.ParameterDirection.Input, False, CType(0, Byte), CType(0, Byte), "address", System.Data.DataRowVersion.Original, Nothing))
        Me.OleDbDeleteCommand1.Parameters.Add(New System.Data.OleDb.OleDbParameter("Original_address1", System.Data.OleDb.OleDbType.VarWChar, 40, System.Data.ParameterDirection.Input, False, CType(0, Byte), CType(0, Byte), "address", System.Data.DataRowVersion.Original, Nothing))
        Me.OleDbDeleteCommand1.Parameters.Add(New System.Data.OleDb.OleDbParameter("Original_au_fname", System.Data.OleDb.OleDbType.VarWChar, 20, System.Data.ParameterDirection.Input, False, CType(0, Byte), CType(0, Byte), "au_fname", System.Data.DataRowVersion.Original, Nothing))
        Me.OleDbDeleteCommand1.Parameters.Add(New System.Data.OleDb.OleDbParameter("Original_au_lname", System.Data.OleDb.OleDbType.VarWChar, 40, System.Data.ParameterDirection.Input, False, CType(0, Byte), CType(0, Byte), "au_lname", System.Data.DataRowVersion.Original, Nothing))
        Me.OleDbDeleteCommand1.Parameters.Add(New System.Data.OleDb.OleDbParameter("Original_city", System.Data.OleDb.OleDbType.VarWChar, 20, System.Data.ParameterDirection.Input, False, CType(0, Byte), CType(0, Byte), "city", System.Data.DataRowVersion.Original, Nothing))
        Me.OleDbDeleteCommand1.Parameters.Add(New System.Data.OleDb.OleDbParameter("Original_city1", System.Data.OleDb.OleDbType.VarWChar, 20, System.Data.ParameterDirection.Input, False, CType(0, Byte), CType(0, Byte), "city", System.Data.DataRowVersion.Original, Nothing))
        Me.OleDbDeleteCommand1.Parameters.Add(New System.Data.OleDb.OleDbParameter("Original_contract", System.Data.OleDb.OleDbType.Boolean, 1, System.Data.ParameterDirection.Input, False, CType(0, Byte), CType(0, Byte), "contract", System.Data.DataRowVersion.Original, Nothing))
        Me.OleDbDeleteCommand1.Parameters.Add(New System.Data.OleDb.OleDbParameter("Original_phone", System.Data.OleDb.OleDbType.VarWChar, 12, System.Data.ParameterDirection.Input, False, CType(0, Byte), CType(0, Byte), "phone", System.Data.DataRowVersion.Original, Nothing))
        Me.OleDbDeleteCommand1.Parameters.Add(New System.Data.OleDb.OleDbParameter("Original_state", System.Data.OleDb.OleDbType.VarWChar, 2, System.Data.ParameterDirection.Input, False, CType(0, Byte), CType(0, Byte), "state", System.Data.DataRowVersion.Original, Nothing))
        Me.OleDbDeleteCommand1.Parameters.Add(New System.Data.OleDb.OleDbParameter("Original_state1", System.Data.OleDb.OleDbType.VarWChar, 2, System.Data.ParameterDirection.Input, False, CType(0, Byte), CType(0, Byte), "state", System.Data.DataRowVersion.Original, Nothing))
        Me.OleDbDeleteCommand1.Parameters.Add(New System.Data.OleDb.OleDbParameter("Original_zip", System.Data.OleDb.OleDbType.VarWChar, 5, System.Data.ParameterDirection.Input, False, CType(0, Byte), CType(0, Byte), "zip", System.Data.DataRowVersion.Original, Nothing))
        Me.OleDbDeleteCommand1.Parameters.Add(New System.Data.OleDb.OleDbParameter("Original_zip1", System.Data.OleDb.OleDbType.VarWChar, 5, System.Data.ParameterDirection.Input, False, CType(0, Byte), CType(0, Byte), "zip", System.Data.DataRowVersion.Original, Nothing))
        '
        'OleDbConnection1
        '
        Me.OleDbConnection1.ConnectionString = "Integrated Security=SSPI;User ID=sa;Data Source=""CHARUL\NetSDK"";Tag with column c" & _
        "ollation when possible=False;Initial Catalog=pubs;Use Procedure for Prepare=1;Au" & _
        "to Translate=True;Persist Security Info=False;Provider=""SQLOLEDB.1"";Workstation " & _
        "ID=CHARUL;Use Encryption for Data=False;Packet Size=4096"
        '
        'DataView1
        '
        Me.DataView1.Table = Me.DataSet11.authors
        '
        'DataSet11
        '
        Me.DataSet11.DataSetName = "DataSet1"
        Me.DataSet11.Locale = New System.Globalization.CultureInfo("en-US")
        CType(Me.DataView1, System.ComponentModel.ISupportInitialize).EndInit()
        CType(Me.DataSet11, System.ComponentModel.ISupportInitialize).EndInit()

    End Sub
    Protected WithEvents OleDbDataAdapter1 As System.Data.OleDb.OleDbDataAdapter
    Protected WithEvents OleDbSelectCommand1 As System.Data.OleDb.OleDbCommand
    Protected WithEvents OleDbInsertCommand1 As System.Data.OleDb.OleDbCommand
    Protected WithEvents OleDbUpdateCommand1 As System.Data.OleDb.OleDbCommand
    Protected WithEvents OleDbDeleteCommand1 As System.Data.OleDb.OleDbCommand
    Protected WithEvents OleDbConnection1 As System.Data.OleDb.OleDbConnection
    Protected WithEvents DataView1 As System.Data.DataView
    Protected WithEvents DataSet11 As WebDataNavigation.DataSet1
    Protected WithEvents TextBox1 As System.Web.UI.WebControls.TextBox
    Protected WithEvents TextBox2 As System.Web.UI.WebControls.TextBox
    Protected WithEvents Label1 As System.Web.UI.WebControls.Label
    Protected WithEvents Label2 As System.Web.UI.WebControls.Label
    Protected WithEvents Button1 As System.Web.UI.WebControls.Button
    Protected WithEvents Button2 As System.Web.UI.WebControls.Button
    Protected WithEvents Button3 As System.Web.UI.WebControls.Button
    Protected WithEvents Button4 As System.Web.UI.WebControls.Button
    Protected WithEvents Label3 As System.Web.UI.WebControls.Label

    'NOTE: The following placeholder declaration is required by the Web Form Designer.
    'Do not delete or move it.
    Private designerPlaceholderDeclaration As System.Object

    Private Sub Page_Init(ByVal sender As System.Object, ByVal e As System.EventArgs) Handles MyBase.Init
        'CODEGEN: This method call is required by the Web Form Designer
        'Do not modify it using the code editor.
        InitializeComponent()
    End Sub

#End Region

    Private Sub Page_Load(ByVal sender As System.Object, ByVal e As System.EventArgs) Handles MyBase.Load


        DataSet11.Clear()
        OleDbDataAdapter1.Fill(DataSet11)
        TextBox1.DataBind()
        TextBox2.DataBind()

    End Sub

    Private Sub Button1_Click(ByVal sender As System.Object, ByVal e As System.EventArgs) Handles Button1.Click
        Dim ID As String
        Dim Index As Integer
        Index = 0
        Me.ViewState("Index") = Index
        ID = DataSet11.Tables(0).Rows(Index).Item("au_id")
        DataView1.RowFilter = "au_id = '" & ID & "'"

        TextBox1.DataBind()
        TextBox2.DataBind()

    End Sub

    Private Sub Button3_Click(ByVal sender As System.Object, ByVal e As System.EventArgs) Handles Button3.Click
        Dim ID As String
        Dim Index As Integer
        Index = Me.ViewState("Index")
        Index -= 1
        If Index < 0 Then
            Index = 0
        End If
        Me.ViewState("Index") = Index
        ID = DataSet11.Tables(0).Rows(Index).Item("au_id")
        DataView1.RowFilter = "au_id = '" & ID & "'"
        TextBox1.DataBind()
        TextBox2.DataBind()

    End Sub

    Private Sub Button4_Click(ByVal sender As System.Object, ByVal e As System.EventArgs) Handles Button4.Click
        Dim ID As String
        Dim Index As Integer
        Index = Me.ViewState("Index")
        Index += 1
        If Index > DataSet11.Tables(0).Rows.Count - 1 Then
            Index = DataSet11.Tables(0).Rows.Count - 1
        End If
        Me.ViewState("Index") = Index
        ID = DataSet11.Tables(0).Rows(Index).Item("au_id")
        DataView1.RowFilter = "au_id = '" & ID & "'"
        TextBox1.DataBind()
        TextBox2.DataBind()

    End Sub

    Private Sub Button2_Click(ByVal sender As System.Object, ByVal e As System.EventArgs) Handles Button2.Click
        Dim ID As String
        Dim Index As Integer
        Index = DataSet11.Tables(0).Rows.Count - 1
        Me.ViewState("Index") = Index
        ID = DataSet11.Tables(0).Rows(Index).Item("au_id")
        DataView1.RowFilter = "au_id = '" & ID & "'"
        TextBox1.DataBind()
        TextBox2.DataBind()

    End Sub
End Class
