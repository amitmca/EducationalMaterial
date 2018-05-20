Imports System.Web.Caching
Public Class WebForm1
    Inherits System.Web.UI.Page

#Region " Web Form Designer Generated Code "

    'This call is required by the Web Form Designer.
    <System.Diagnostics.DebuggerStepThrough()> Private Sub InitializeComponent()
        Me.DataSet1 = New System.Data.DataSet
        CType(Me.DataSet1, System.ComponentModel.ISupportInitialize).BeginInit()
        '
        'DataSet1
        '
        Me.DataSet1.DataSetName = "NewDataSet"
        Me.DataSet1.Locale = New System.Globalization.CultureInfo("en-US")
        CType(Me.DataSet1, System.ComponentModel.ISupportInitialize).EndInit()

    End Sub
    Protected WithEvents DataSet1 As System.Data.DataSet
    Protected WithEvents DataGrid1 As System.Web.UI.WebControls.DataGrid
    Protected WithEvents Label1 As System.Web.UI.WebControls.Label
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
        If Cache("MyCacheDataset") Is Nothing Then
            DataSet1.ReadXml(Server.MapPath("Authors.xml"))
            Cache.Insert("MyCacheDataset", DataSet1, New CacheDependency(Server.MapPath("Authors.xml")))
            Label2.Text = "Cache Generated"
        Else
            Label2.Text = "Using pre-generated Cache"
        End If
        DataGrid1.DataSource = Cache("MyCacheDataset")
        DataGrid1.DataBind()
    End Sub
End Class
