Imports System.Web.Services

<System.Web.Services.WebService(Namespace := "http://tempuri.org/MyWebService/Service1")> _
Public Class Service1
    Inherits System.Web.Services.WebService

#Region " Web Services Designer Generated Code "

    Public Sub New()
        MyBase.New()

        'This call is required by the Web Services Designer.
        InitializeComponent()

        'Add your own initialization code after the InitializeComponent() call

    End Sub

    'Required by the Web Services Designer
    Private components As System.ComponentModel.IContainer

    'NOTE: The following procedure is required by the Web Services Designer
    'It can be modified using the Web Services Designer.  
    'Do not modify it using the code editor.
    Friend WithEvents OleDbDataAdapter2 As System.Data.OleDb.OleDbDataAdapter
    Friend WithEvents DataSet11 As MyWebService.DataSet1
    Friend WithEvents OleDbSelectCommand1 As System.Data.OleDb.OleDbCommand
    Friend WithEvents OleDbInsertCommand1 As System.Data.OleDb.OleDbCommand
    Friend WithEvents OleDbUpdateCommand1 As System.Data.OleDb.OleDbCommand
    Friend WithEvents OleDbDeleteCommand1 As System.Data.OleDb.OleDbCommand
    Friend WithEvents OleDbConnection1 As System.Data.OleDb.OleDbConnection
    <System.Diagnostics.DebuggerStepThrough()> Private Sub InitializeComponent()
        Me.OleDbDataAdapter2 = New System.Data.OleDb.OleDbDataAdapter
        Me.OleDbDeleteCommand1 = New System.Data.OleDb.OleDbCommand
        Me.OleDbConnection1 = New System.Data.OleDb.OleDbConnection
        Me.OleDbInsertCommand1 = New System.Data.OleDb.OleDbCommand
        Me.OleDbSelectCommand1 = New System.Data.OleDb.OleDbCommand
        Me.OleDbUpdateCommand1 = New System.Data.OleDb.OleDbCommand
        Me.DataSet11 = New MyWebService.DataSet1
        CType(Me.DataSet11, System.ComponentModel.ISupportInitialize).BeginInit()
        '
        'OleDbDataAdapter2
        '
        Me.OleDbDataAdapter2.DeleteCommand = Me.OleDbDeleteCommand1
        Me.OleDbDataAdapter2.InsertCommand = Me.OleDbInsertCommand1
        Me.OleDbDataAdapter2.SelectCommand = Me.OleDbSelectCommand1
        Me.OleDbDataAdapter2.TableMappings.AddRange(New System.Data.Common.DataTableMapping() {New System.Data.Common.DataTableMapping("Table", "authors", New System.Data.Common.DataColumnMapping() {New System.Data.Common.DataColumnMapping("au_id", "au_id"), New System.Data.Common.DataColumnMapping("au_lname", "au_lname"), New System.Data.Common.DataColumnMapping("au_fname", "au_fname"), New System.Data.Common.DataColumnMapping("phone", "phone"), New System.Data.Common.DataColumnMapping("address", "address"), New System.Data.Common.DataColumnMapping("state", "state"), New System.Data.Common.DataColumnMapping("city", "city"), New System.Data.Common.DataColumnMapping("zip", "zip"), New System.Data.Common.DataColumnMapping("contract", "contract")})})
        Me.OleDbDataAdapter2.UpdateCommand = Me.OleDbUpdateCommand1
        '
        'OleDbDeleteCommand1
        '
        Me.OleDbDeleteCommand1.CommandText = "DELETE FROM authors WHERE (au_id = ?) AND (address = ? OR ? IS NULL AND address I" & _
        "S NULL) AND (au_fname = ?) AND (au_lname = ?) AND (city = ? OR ? IS NULL AND cit" & _
        "y IS NULL) AND (contract = ?) AND (phone = ?) AND (state = ? OR ? IS NULL AND st" & _
        "ate IS NULL) AND (zip = ? OR ? IS NULL AND zip IS NULL)"
        Me.OleDbDeleteCommand1.Connection = Me.OleDbConnection1
        Me.OleDbDeleteCommand1.Parameters.Add(New System.Data.OleDb.OleDbParameter("Original_au_id", System.Data.OleDb.OleDbType.VarChar, 11, System.Data.ParameterDirection.Input, False, CType(0, Byte), CType(0, Byte), "au_id", System.Data.DataRowVersion.Original, Nothing))
        Me.OleDbDeleteCommand1.Parameters.Add(New System.Data.OleDb.OleDbParameter("Original_address", System.Data.OleDb.OleDbType.VarChar, 40, System.Data.ParameterDirection.Input, False, CType(0, Byte), CType(0, Byte), "address", System.Data.DataRowVersion.Original, Nothing))
        Me.OleDbDeleteCommand1.Parameters.Add(New System.Data.OleDb.OleDbParameter("Original_address1", System.Data.OleDb.OleDbType.VarChar, 40, System.Data.ParameterDirection.Input, False, CType(0, Byte), CType(0, Byte), "address", System.Data.DataRowVersion.Original, Nothing))
        Me.OleDbDeleteCommand1.Parameters.Add(New System.Data.OleDb.OleDbParameter("Original_au_fname", System.Data.OleDb.OleDbType.VarChar, 20, System.Data.ParameterDirection.Input, False, CType(0, Byte), CType(0, Byte), "au_fname", System.Data.DataRowVersion.Original, Nothing))
        Me.OleDbDeleteCommand1.Parameters.Add(New System.Data.OleDb.OleDbParameter("Original_au_lname", System.Data.OleDb.OleDbType.VarChar, 40, System.Data.ParameterDirection.Input, False, CType(0, Byte), CType(0, Byte), "au_lname", System.Data.DataRowVersion.Original, Nothing))
        Me.OleDbDeleteCommand1.Parameters.Add(New System.Data.OleDb.OleDbParameter("Original_city", System.Data.OleDb.OleDbType.VarChar, 20, System.Data.ParameterDirection.Input, False, CType(0, Byte), CType(0, Byte), "city", System.Data.DataRowVersion.Original, Nothing))
        Me.OleDbDeleteCommand1.Parameters.Add(New System.Data.OleDb.OleDbParameter("Original_city1", System.Data.OleDb.OleDbType.VarChar, 20, System.Data.ParameterDirection.Input, False, CType(0, Byte), CType(0, Byte), "city", System.Data.DataRowVersion.Original, Nothing))
        Me.OleDbDeleteCommand1.Parameters.Add(New System.Data.OleDb.OleDbParameter("Original_contract", System.Data.OleDb.OleDbType.Boolean, 1, System.Data.ParameterDirection.Input, False, CType(0, Byte), CType(0, Byte), "contract", System.Data.DataRowVersion.Original, Nothing))
        Me.OleDbDeleteCommand1.Parameters.Add(New System.Data.OleDb.OleDbParameter("Original_phone", System.Data.OleDb.OleDbType.VarChar, 12, System.Data.ParameterDirection.Input, False, CType(0, Byte), CType(0, Byte), "phone", System.Data.DataRowVersion.Original, Nothing))
        Me.OleDbDeleteCommand1.Parameters.Add(New System.Data.OleDb.OleDbParameter("Original_state", System.Data.OleDb.OleDbType.VarChar, 2, System.Data.ParameterDirection.Input, False, CType(0, Byte), CType(0, Byte), "state", System.Data.DataRowVersion.Original, Nothing))
        Me.OleDbDeleteCommand1.Parameters.Add(New System.Data.OleDb.OleDbParameter("Original_state1", System.Data.OleDb.OleDbType.VarChar, 2, System.Data.ParameterDirection.Input, False, CType(0, Byte), CType(0, Byte), "state", System.Data.DataRowVersion.Original, Nothing))
        Me.OleDbDeleteCommand1.Parameters.Add(New System.Data.OleDb.OleDbParameter("Original_zip", System.Data.OleDb.OleDbType.VarChar, 5, System.Data.ParameterDirection.Input, False, CType(0, Byte), CType(0, Byte), "zip", System.Data.DataRowVersion.Original, Nothing))
        Me.OleDbDeleteCommand1.Parameters.Add(New System.Data.OleDb.OleDbParameter("Original_zip1", System.Data.OleDb.OleDbType.VarChar, 5, System.Data.ParameterDirection.Input, False, CType(0, Byte), CType(0, Byte), "zip", System.Data.DataRowVersion.Original, Nothing))
        '
        'OleDbConnection1
        '
        Me.OleDbConnection1.ConnectionString = "User ID=sa;Data Source=DEVELOPERS;Tag with column collation when possible=False;I" & _
        "nitial Catalog=pubs;Use Procedure for Prepare=1;Auto Translate=True;Persist Secu" & _
        "rity Info=False;Provider=""SQLOLEDB.1"";Workstation ID=ANIL;Use Encryption for Dat" & _
        "a=False;Packet Size=4096"
        '
        'OleDbInsertCommand1
        '
        Me.OleDbInsertCommand1.CommandText = "INSERT INTO authors(au_id, au_lname, au_fname, phone, address, state, city, zip, " & _
        "contract) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?); SELECT au_id, au_lname, au_fname, " & _
        "phone, address, state, city, zip, contract FROM authors WHERE (au_id = ?)"
        Me.OleDbInsertCommand1.Connection = Me.OleDbConnection1
        Me.OleDbInsertCommand1.Parameters.Add(New System.Data.OleDb.OleDbParameter("au_id", System.Data.OleDb.OleDbType.VarChar, 11, "au_id"))
        Me.OleDbInsertCommand1.Parameters.Add(New System.Data.OleDb.OleDbParameter("au_lname", System.Data.OleDb.OleDbType.VarChar, 40, "au_lname"))
        Me.OleDbInsertCommand1.Parameters.Add(New System.Data.OleDb.OleDbParameter("au_fname", System.Data.OleDb.OleDbType.VarChar, 20, "au_fname"))
        Me.OleDbInsertCommand1.Parameters.Add(New System.Data.OleDb.OleDbParameter("phone", System.Data.OleDb.OleDbType.VarChar, 12, "phone"))
        Me.OleDbInsertCommand1.Parameters.Add(New System.Data.OleDb.OleDbParameter("address", System.Data.OleDb.OleDbType.VarChar, 40, "address"))
        Me.OleDbInsertCommand1.Parameters.Add(New System.Data.OleDb.OleDbParameter("state", System.Data.OleDb.OleDbType.VarChar, 2, "state"))
        Me.OleDbInsertCommand1.Parameters.Add(New System.Data.OleDb.OleDbParameter("city", System.Data.OleDb.OleDbType.VarChar, 20, "city"))
        Me.OleDbInsertCommand1.Parameters.Add(New System.Data.OleDb.OleDbParameter("zip", System.Data.OleDb.OleDbType.VarChar, 5, "zip"))
        Me.OleDbInsertCommand1.Parameters.Add(New System.Data.OleDb.OleDbParameter("contract", System.Data.OleDb.OleDbType.Boolean, 1, "contract"))
        Me.OleDbInsertCommand1.Parameters.Add(New System.Data.OleDb.OleDbParameter("Select_au_id", System.Data.OleDb.OleDbType.VarChar, 11, "au_id"))
        '
        'OleDbSelectCommand1
        '
        Me.OleDbSelectCommand1.CommandText = "SELECT au_id, au_lname, au_fname, phone, address, state, city, zip, contract FROM" & _
        " authors"
        Me.OleDbSelectCommand1.Connection = Me.OleDbConnection1
        '
        'OleDbUpdateCommand1
        '
        Me.OleDbUpdateCommand1.CommandText = "UPDATE authors SET au_id = ?, au_lname = ?, au_fname = ?, phone = ?, address = ?," & _
        " state = ?, city = ?, zip = ?, contract = ? WHERE (au_id = ?) AND (address = ? O" & _
        "R ? IS NULL AND address IS NULL) AND (au_fname = ?) AND (au_lname = ?) AND (city" & _
        " = ? OR ? IS NULL AND city IS NULL) AND (contract = ?) AND (phone = ?) AND (stat" & _
        "e = ? OR ? IS NULL AND state IS NULL) AND (zip = ? OR ? IS NULL AND zip IS NULL)" & _
        "; SELECT au_id, au_lname, au_fname, phone, address, state, city, zip, contract F" & _
        "ROM authors WHERE (au_id = ?)"
        Me.OleDbUpdateCommand1.Connection = Me.OleDbConnection1
        Me.OleDbUpdateCommand1.Parameters.Add(New System.Data.OleDb.OleDbParameter("au_id", System.Data.OleDb.OleDbType.VarChar, 11, "au_id"))
        Me.OleDbUpdateCommand1.Parameters.Add(New System.Data.OleDb.OleDbParameter("au_lname", System.Data.OleDb.OleDbType.VarChar, 40, "au_lname"))
        Me.OleDbUpdateCommand1.Parameters.Add(New System.Data.OleDb.OleDbParameter("au_fname", System.Data.OleDb.OleDbType.VarChar, 20, "au_fname"))
        Me.OleDbUpdateCommand1.Parameters.Add(New System.Data.OleDb.OleDbParameter("phone", System.Data.OleDb.OleDbType.VarChar, 12, "phone"))
        Me.OleDbUpdateCommand1.Parameters.Add(New System.Data.OleDb.OleDbParameter("address", System.Data.OleDb.OleDbType.VarChar, 40, "address"))
        Me.OleDbUpdateCommand1.Parameters.Add(New System.Data.OleDb.OleDbParameter("state", System.Data.OleDb.OleDbType.VarChar, 2, "state"))
        Me.OleDbUpdateCommand1.Parameters.Add(New System.Data.OleDb.OleDbParameter("city", System.Data.OleDb.OleDbType.VarChar, 20, "city"))
        Me.OleDbUpdateCommand1.Parameters.Add(New System.Data.OleDb.OleDbParameter("zip", System.Data.OleDb.OleDbType.VarChar, 5, "zip"))
        Me.OleDbUpdateCommand1.Parameters.Add(New System.Data.OleDb.OleDbParameter("contract", System.Data.OleDb.OleDbType.Boolean, 1, "contract"))
        Me.OleDbUpdateCommand1.Parameters.Add(New System.Data.OleDb.OleDbParameter("Original_au_id", System.Data.OleDb.OleDbType.VarChar, 11, System.Data.ParameterDirection.Input, False, CType(0, Byte), CType(0, Byte), "au_id", System.Data.DataRowVersion.Original, Nothing))
        Me.OleDbUpdateCommand1.Parameters.Add(New System.Data.OleDb.OleDbParameter("Original_address", System.Data.OleDb.OleDbType.VarChar, 40, System.Data.ParameterDirection.Input, False, CType(0, Byte), CType(0, Byte), "address", System.Data.DataRowVersion.Original, Nothing))
        Me.OleDbUpdateCommand1.Parameters.Add(New System.Data.OleDb.OleDbParameter("Original_address1", System.Data.OleDb.OleDbType.VarChar, 40, System.Data.ParameterDirection.Input, False, CType(0, Byte), CType(0, Byte), "address", System.Data.DataRowVersion.Original, Nothing))
        Me.OleDbUpdateCommand1.Parameters.Add(New System.Data.OleDb.OleDbParameter("Original_au_fname", System.Data.OleDb.OleDbType.VarChar, 20, System.Data.ParameterDirection.Input, False, CType(0, Byte), CType(0, Byte), "au_fname", System.Data.DataRowVersion.Original, Nothing))
        Me.OleDbUpdateCommand1.Parameters.Add(New System.Data.OleDb.OleDbParameter("Original_au_lname", System.Data.OleDb.OleDbType.VarChar, 40, System.Data.ParameterDirection.Input, False, CType(0, Byte), CType(0, Byte), "au_lname", System.Data.DataRowVersion.Original, Nothing))
        Me.OleDbUpdateCommand1.Parameters.Add(New System.Data.OleDb.OleDbParameter("Original_city", System.Data.OleDb.OleDbType.VarChar, 20, System.Data.ParameterDirection.Input, False, CType(0, Byte), CType(0, Byte), "city", System.Data.DataRowVersion.Original, Nothing))
        Me.OleDbUpdateCommand1.Parameters.Add(New System.Data.OleDb.OleDbParameter("Original_city1", System.Data.OleDb.OleDbType.VarChar, 20, System.Data.ParameterDirection.Input, False, CType(0, Byte), CType(0, Byte), "city", System.Data.DataRowVersion.Original, Nothing))
        Me.OleDbUpdateCommand1.Parameters.Add(New System.Data.OleDb.OleDbParameter("Original_contract", System.Data.OleDb.OleDbType.Boolean, 1, System.Data.ParameterDirection.Input, False, CType(0, Byte), CType(0, Byte), "contract", System.Data.DataRowVersion.Original, Nothing))
        Me.OleDbUpdateCommand1.Parameters.Add(New System.Data.OleDb.OleDbParameter("Original_phone", System.Data.OleDb.OleDbType.VarChar, 12, System.Data.ParameterDirection.Input, False, CType(0, Byte), CType(0, Byte), "phone", System.Data.DataRowVersion.Original, Nothing))
        Me.OleDbUpdateCommand1.Parameters.Add(New System.Data.OleDb.OleDbParameter("Original_state", System.Data.OleDb.OleDbType.VarChar, 2, System.Data.ParameterDirection.Input, False, CType(0, Byte), CType(0, Byte), "state", System.Data.DataRowVersion.Original, Nothing))
        Me.OleDbUpdateCommand1.Parameters.Add(New System.Data.OleDb.OleDbParameter("Original_state1", System.Data.OleDb.OleDbType.VarChar, 2, System.Data.ParameterDirection.Input, False, CType(0, Byte), CType(0, Byte), "state", System.Data.DataRowVersion.Original, Nothing))
        Me.OleDbUpdateCommand1.Parameters.Add(New System.Data.OleDb.OleDbParameter("Original_zip", System.Data.OleDb.OleDbType.VarChar, 5, System.Data.ParameterDirection.Input, False, CType(0, Byte), CType(0, Byte), "zip", System.Data.DataRowVersion.Original, Nothing))
        Me.OleDbUpdateCommand1.Parameters.Add(New System.Data.OleDb.OleDbParameter("Original_zip1", System.Data.OleDb.OleDbType.VarChar, 5, System.Data.ParameterDirection.Input, False, CType(0, Byte), CType(0, Byte), "zip", System.Data.DataRowVersion.Original, Nothing))
        Me.OleDbUpdateCommand1.Parameters.Add(New System.Data.OleDb.OleDbParameter("Select_au_id", System.Data.OleDb.OleDbType.VarChar, 11, "au_id"))
        '
        'DataSet11
        '
        Me.DataSet11.DataSetName = "DataSet1"
        Me.DataSet11.Locale = New System.Globalization.CultureInfo("en-US")
        CType(Me.DataSet11, System.ComponentModel.ISupportInitialize).EndInit()

    End Sub

    Protected Overloads Overrides Sub Dispose(ByVal disposing As Boolean)
        'CODEGEN: This procedure is required by the Web Services Designer
        'Do not modify it using the code editor.
        If disposing Then
            If Not (components Is Nothing) Then
                components.Dispose()
            End If
        End If
        MyBase.Dispose(disposing)
    End Sub

#End Region

    ' WEB SERVICE EXAMPLE
    ' The HelloWorld() example service returns the string Hello World.
    ' To build, uncomment the following lines then save and build the project.
    ' To test this web service, ensure that the .asmx file is the start page
    ' and press F5.
    '
    '<WebMethod()> _
    'Public Function HelloWorld() As String
    '   Return "Hello World"
    'End Function

    <WebMethod(Description:="Gets the authors")> _
    Public Function GetAuthors() As DataSet1
        Dim AuthorsTable As New DataSet1
        OleDbDataAdapter2.Fill(AuthorsTable)
        Return AuthorsTable
    End Function
    <WebMethod(Description:="Updates the authors")> _
    Public Function UpdateAuthors(ByVal Changes As DataSet1) As DataSet1
        If (Changes Is Nothing) Then
            Return Nothing
        Else
            OleDbDataAdapter2.Update(Changes)
            Return Changes
        End If
    End Function
End Class