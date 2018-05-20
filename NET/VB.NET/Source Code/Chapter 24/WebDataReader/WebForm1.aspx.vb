Public Class WebForm1
    Inherits System.Web.UI.Page

#Region " Web Form Designer Generated Code "

    'This call is required by the Web Form Designer.
    <System.Diagnostics.DebuggerStepThrough()> Private Sub InitializeComponent()
        Me.OleDbConnection1 = New System.Data.OleDb.OleDbConnection
        Me.OleDbCommand1 = New System.Data.OleDb.OleDbCommand
        '
        'OleDbConnection1
        '
        Me.OleDbConnection1.ConnectionString = "Auto Translate=True;Integrated Security=SSPI;User ID=sa;Data Source=""CHARUL\NetSD" & _
        "K"";Tag with column collation when possible=False;Initial Catalog=pubs;Use Proced" & _
        "ure for Prepare=1;Provider=""SQLOLEDB.1"";Persist Security Info=False;Workstation " & _
        "ID=CHARUL;Use Encryption for Data=False;Packet Size=4096"
        '
        'OleDbCommand1
        '
        Me.OleDbCommand1.CommandText = "SELECT au_id, au_lname, au_fname, phone FROM authors"
        Me.OleDbCommand1.Connection = Me.OleDbConnection1

    End Sub
    Protected WithEvents OleDbConnection1 As System.Data.OleDb.OleDbConnection
    Protected WithEvents DataGrid1 As System.Web.UI.WebControls.DataGrid
    Protected WithEvents Label1 As System.Web.UI.WebControls.Label
    Protected WithEvents OleDbCommand1 As System.Data.OleDb.OleDbCommand

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
        OleDbConnection1.Open()
        Dim Reader1 As System.Data.OleDb.OleDbDataReader
        Reader1 = OleDbCommand1.ExecuteReader()
        DataGrid1.DataSource = Reader1
        DataGrid1.DataBind()
        Reader1.Close()
    End Sub


End Class
