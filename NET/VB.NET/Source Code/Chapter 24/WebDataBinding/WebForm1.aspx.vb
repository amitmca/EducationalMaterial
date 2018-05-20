Public Class WebForm1
    Inherits System.Web.UI.Page

#Region " Web Form Designer Generated Code "

    'This call is required by the Web Form Designer.
    <System.Diagnostics.DebuggerStepThrough()> Private Sub InitializeComponent()
        Me.OleDbDataAdapter1 = New System.Data.OleDb.OleDbDataAdapter
        Me.OleDbSelectCommand1 = New System.Data.OleDb.OleDbCommand
        Me.OleDbConnection1 = New System.Data.OleDb.OleDbConnection
        Me.DataSet11 = New WebDataBinding.DataSet1
        CType(Me.DataSet11, System.ComponentModel.ISupportInitialize).BeginInit()
        '
        'OleDbDataAdapter1
        '
        Me.OleDbDataAdapter1.SelectCommand = Me.OleDbSelectCommand1
        Me.OleDbDataAdapter1.TableMappings.AddRange(New System.Data.Common.DataTableMapping() {New System.Data.Common.DataTableMapping("Table", "authors", New System.Data.Common.DataColumnMapping() {New System.Data.Common.DataColumnMapping("au_id", "au_id"), New System.Data.Common.DataColumnMapping("au_lname", "au_lname"), New System.Data.Common.DataColumnMapping("au_fname", "au_fname"), New System.Data.Common.DataColumnMapping("phone", "phone"), New System.Data.Common.DataColumnMapping("address", "address"), New System.Data.Common.DataColumnMapping("city", "city"), New System.Data.Common.DataColumnMapping("state", "state"), New System.Data.Common.DataColumnMapping("zip", "zip"), New System.Data.Common.DataColumnMapping("contract", "contract")})})
        '
        'OleDbSelectCommand1
        '
        Me.OleDbSelectCommand1.CommandText = "SELECT au_id, au_lname, au_fname, phone, address, city, state, zip, contract FROM" & _
        " authors"
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
        CType(Me.DataSet11, System.ComponentModel.ISupportInitialize).EndInit()

    End Sub
    Protected WithEvents OleDbDataAdapter1 As System.Data.OleDb.OleDbDataAdapter
    Protected WithEvents OleDbSelectCommand1 As System.Data.OleDb.OleDbCommand
    Protected WithEvents OleDbConnection1 As System.Data.OleDb.OleDbConnection
    Protected WithEvents DataSet11 As WebDataBinding.DataSet1
    Protected WithEvents TextBox1 As System.Web.UI.WebControls.TextBox
    Protected WithEvents CheckBoxList1 As System.Web.UI.WebControls.CheckBoxList
    Protected WithEvents TextBox2 As System.Web.UI.WebControls.TextBox
    Protected WithEvents ListBox1 As System.Web.UI.WebControls.ListBox
    Protected WithEvents DropDownList1 As System.Web.UI.WebControls.DropDownList
    Protected WithEvents CheckBox1 As System.Web.UI.WebControls.CheckBox
    Protected WithEvents RadioButton1 As System.Web.UI.WebControls.RadioButton
    Protected WithEvents Label1 As System.Web.UI.WebControls.Label
    Protected WithEvents HyperLink1 As System.Web.UI.WebControls.HyperLink
    Protected WithEvents Label2 As System.Web.UI.WebControls.Label

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
        'Put user code to initialize the page here
        DataSet11.Clear()
        OleDbDataAdapter1.Fill(DataSet11)
        TextBox1.DataBind()
        TextBox2.DataBind()
        ListBox1.DataBind()
        DropDownList1.DataBind()
        CheckBox1.DataBind()
        RadioButton1.DataBind()
        CheckBoxList1.DataBind()
        Label1.DataBind()
        HyperLink1.DataBind()

    End Sub

End Class
