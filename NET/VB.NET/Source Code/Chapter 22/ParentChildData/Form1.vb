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
    Friend WithEvents Label1 As System.Windows.Forms.Label
    Friend WithEvents ComboBox1 As System.Windows.Forms.ComboBox
    Friend WithEvents DataGrid1 As System.Windows.Forms.DataGrid
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
    Friend WithEvents DataSet11 As ParentChildData.DataSet1
    <System.Diagnostics.DebuggerStepThrough()> Private Sub InitializeComponent()
        Me.Label1 = New System.Windows.Forms.Label
        Me.ComboBox1 = New System.Windows.Forms.ComboBox
        Me.DataSet11 = New ParentChildData.DataSet1
        Me.DataGrid1 = New System.Windows.Forms.DataGrid
        Me.SqlDataAdapter1 = New System.Data.SqlClient.SqlDataAdapter
        Me.SqlDeleteCommand1 = New System.Data.SqlClient.SqlCommand
        Me.SqlConnection1 = New System.Data.SqlClient.SqlConnection
        Me.SqlInsertCommand1 = New System.Data.SqlClient.SqlCommand
        Me.SqlSelectCommand1 = New System.Data.SqlClient.SqlCommand
        Me.SqlUpdateCommand1 = New System.Data.SqlClient.SqlCommand
        Me.SqlDataAdapter2 = New System.Data.SqlClient.SqlDataAdapter
        Me.SqlDeleteCommand2 = New System.Data.SqlClient.SqlCommand
        Me.SqlInsertCommand2 = New System.Data.SqlClient.SqlCommand
        Me.SqlSelectCommand2 = New System.Data.SqlClient.SqlCommand
        Me.SqlUpdateCommand2 = New System.Data.SqlClient.SqlCommand
        CType(Me.DataSet11, System.ComponentModel.ISupportInitialize).BeginInit()
        CType(Me.DataGrid1, System.ComponentModel.ISupportInitialize).BeginInit()
        Me.SuspendLayout()
        '
        'Label1
        '
        Me.Label1.Location = New System.Drawing.Point(64, 32)
        Me.Label1.Name = "Label1"
        Me.Label1.Size = New System.Drawing.Size(128, 23)
        Me.Label1.TabIndex = 0
        Me.Label1.Text = "Choose a publisher"
        '
        'ComboBox1
        '
        Me.ComboBox1.DataSource = Me.DataSet11
        Me.ComboBox1.DisplayMember = "publishers.pub_name"
        Me.ComboBox1.Location = New System.Drawing.Point(208, 28)
        Me.ComboBox1.Name = "ComboBox1"
        Me.ComboBox1.Size = New System.Drawing.Size(280, 21)
        Me.ComboBox1.TabIndex = 1
        '
        'DataSet11
        '
        Me.DataSet11.DataSetName = "DataSet1"
        Me.DataSet11.Locale = New System.Globalization.CultureInfo("en-US")
        '
        'DataGrid1
        '
        Me.DataGrid1.DataMember = "publishers.publisherstitles"
        Me.DataGrid1.DataSource = Me.DataSet11
        Me.DataGrid1.Dock = System.Windows.Forms.DockStyle.Bottom
        Me.DataGrid1.HeaderForeColor = System.Drawing.SystemColors.ControlText
        Me.DataGrid1.Location = New System.Drawing.Point(0, 106)
        Me.DataGrid1.Name = "DataGrid1"
        Me.DataGrid1.Size = New System.Drawing.Size(584, 176)
        Me.DataGrid1.TabIndex = 2
        '
        'SqlDataAdapter1
        '
        Me.SqlDataAdapter1.DeleteCommand = Me.SqlDeleteCommand1
        Me.SqlDataAdapter1.InsertCommand = Me.SqlInsertCommand1
        Me.SqlDataAdapter1.SelectCommand = Me.SqlSelectCommand1
        Me.SqlDataAdapter1.TableMappings.AddRange(New System.Data.Common.DataTableMapping() {New System.Data.Common.DataTableMapping("Table", "publishers", New System.Data.Common.DataColumnMapping() {New System.Data.Common.DataColumnMapping("pub_id", "pub_id"), New System.Data.Common.DataColumnMapping("pub_name", "pub_name"), New System.Data.Common.DataColumnMapping("city", "city"), New System.Data.Common.DataColumnMapping("state", "state"), New System.Data.Common.DataColumnMapping("country", "country")})})
        Me.SqlDataAdapter1.UpdateCommand = Me.SqlUpdateCommand1
        '
        'SqlDeleteCommand1
        '
        Me.SqlDeleteCommand1.CommandText = "DELETE FROM publishers WHERE (pub_id = @Original_pub_id) AND (city = @Original_ci" & _
        "ty OR @Original_city IS NULL AND city IS NULL) AND (country = @Original_country " & _
        "OR @Original_country IS NULL AND country IS NULL) AND (pub_name = @Original_pub_" & _
        "name OR @Original_pub_name IS NULL AND pub_name IS NULL) AND (state = @Original_" & _
        "state OR @Original_state IS NULL AND state IS NULL)"
        Me.SqlDeleteCommand1.Connection = Me.SqlConnection1
        Me.SqlDeleteCommand1.Parameters.Add(New System.Data.SqlClient.SqlParameter("@Original_pub_id", System.Data.SqlDbType.NVarChar, 4, System.Data.ParameterDirection.Input, False, CType(0, Byte), CType(0, Byte), "pub_id", System.Data.DataRowVersion.Original, Nothing))
        Me.SqlDeleteCommand1.Parameters.Add(New System.Data.SqlClient.SqlParameter("@Original_city", System.Data.SqlDbType.NVarChar, 20, System.Data.ParameterDirection.Input, False, CType(0, Byte), CType(0, Byte), "city", System.Data.DataRowVersion.Original, Nothing))
        Me.SqlDeleteCommand1.Parameters.Add(New System.Data.SqlClient.SqlParameter("@Original_country", System.Data.SqlDbType.NVarChar, 30, System.Data.ParameterDirection.Input, False, CType(0, Byte), CType(0, Byte), "country", System.Data.DataRowVersion.Original, Nothing))
        Me.SqlDeleteCommand1.Parameters.Add(New System.Data.SqlClient.SqlParameter("@Original_pub_name", System.Data.SqlDbType.NVarChar, 40, System.Data.ParameterDirection.Input, False, CType(0, Byte), CType(0, Byte), "pub_name", System.Data.DataRowVersion.Original, Nothing))
        Me.SqlDeleteCommand1.Parameters.Add(New System.Data.SqlClient.SqlParameter("@Original_state", System.Data.SqlDbType.NVarChar, 2, System.Data.ParameterDirection.Input, False, CType(0, Byte), CType(0, Byte), "state", System.Data.DataRowVersion.Original, Nothing))
        '
        'SqlConnection1
        '
        Me.SqlConnection1.ConnectionString = "workstation id=CHARUL;packet size=4096;user id=sa;integrated security=SSPI;data s" & _
        "ource=""CHARUL\NetSDK"";persist security info=False;initial catalog=pubs"
        '
        'SqlInsertCommand1
        '
        Me.SqlInsertCommand1.CommandText = "INSERT INTO publishers(pub_id, pub_name, city, state, country) VALUES (@pub_id, @" & _
        "pub_name, @city, @state, @country); SELECT pub_id, pub_name, city, state, countr" & _
        "y FROM publishers WHERE (pub_id = @pub_id)"
        Me.SqlInsertCommand1.Connection = Me.SqlConnection1
        Me.SqlInsertCommand1.Parameters.Add(New System.Data.SqlClient.SqlParameter("@pub_id", System.Data.SqlDbType.NVarChar, 4, "pub_id"))
        Me.SqlInsertCommand1.Parameters.Add(New System.Data.SqlClient.SqlParameter("@pub_name", System.Data.SqlDbType.NVarChar, 40, "pub_name"))
        Me.SqlInsertCommand1.Parameters.Add(New System.Data.SqlClient.SqlParameter("@city", System.Data.SqlDbType.NVarChar, 20, "city"))
        Me.SqlInsertCommand1.Parameters.Add(New System.Data.SqlClient.SqlParameter("@state", System.Data.SqlDbType.NVarChar, 2, "state"))
        Me.SqlInsertCommand1.Parameters.Add(New System.Data.SqlClient.SqlParameter("@country", System.Data.SqlDbType.NVarChar, 30, "country"))
        '
        'SqlSelectCommand1
        '
        Me.SqlSelectCommand1.CommandText = "SELECT pub_id, pub_name, city, state, country FROM publishers"
        Me.SqlSelectCommand1.Connection = Me.SqlConnection1
        '
        'SqlUpdateCommand1
        '
        Me.SqlUpdateCommand1.CommandText = "UPDATE publishers SET pub_id = @pub_id, pub_name = @pub_name, city = @city, state" & _
        " = @state, country = @country WHERE (pub_id = @Original_pub_id) AND (city = @Ori" & _
        "ginal_city OR @Original_city IS NULL AND city IS NULL) AND (country = @Original_" & _
        "country OR @Original_country IS NULL AND country IS NULL) AND (pub_name = @Origi" & _
        "nal_pub_name OR @Original_pub_name IS NULL AND pub_name IS NULL) AND (state = @O" & _
        "riginal_state OR @Original_state IS NULL AND state IS NULL); SELECT pub_id, pub_" & _
        "name, city, state, country FROM publishers WHERE (pub_id = @pub_id)"
        Me.SqlUpdateCommand1.Connection = Me.SqlConnection1
        Me.SqlUpdateCommand1.Parameters.Add(New System.Data.SqlClient.SqlParameter("@pub_id", System.Data.SqlDbType.NVarChar, 4, "pub_id"))
        Me.SqlUpdateCommand1.Parameters.Add(New System.Data.SqlClient.SqlParameter("@pub_name", System.Data.SqlDbType.NVarChar, 40, "pub_name"))
        Me.SqlUpdateCommand1.Parameters.Add(New System.Data.SqlClient.SqlParameter("@city", System.Data.SqlDbType.NVarChar, 20, "city"))
        Me.SqlUpdateCommand1.Parameters.Add(New System.Data.SqlClient.SqlParameter("@state", System.Data.SqlDbType.NVarChar, 2, "state"))
        Me.SqlUpdateCommand1.Parameters.Add(New System.Data.SqlClient.SqlParameter("@country", System.Data.SqlDbType.NVarChar, 30, "country"))
        Me.SqlUpdateCommand1.Parameters.Add(New System.Data.SqlClient.SqlParameter("@Original_pub_id", System.Data.SqlDbType.NVarChar, 4, System.Data.ParameterDirection.Input, False, CType(0, Byte), CType(0, Byte), "pub_id", System.Data.DataRowVersion.Original, Nothing))
        Me.SqlUpdateCommand1.Parameters.Add(New System.Data.SqlClient.SqlParameter("@Original_city", System.Data.SqlDbType.NVarChar, 20, System.Data.ParameterDirection.Input, False, CType(0, Byte), CType(0, Byte), "city", System.Data.DataRowVersion.Original, Nothing))
        Me.SqlUpdateCommand1.Parameters.Add(New System.Data.SqlClient.SqlParameter("@Original_country", System.Data.SqlDbType.NVarChar, 30, System.Data.ParameterDirection.Input, False, CType(0, Byte), CType(0, Byte), "country", System.Data.DataRowVersion.Original, Nothing))
        Me.SqlUpdateCommand1.Parameters.Add(New System.Data.SqlClient.SqlParameter("@Original_pub_name", System.Data.SqlDbType.NVarChar, 40, System.Data.ParameterDirection.Input, False, CType(0, Byte), CType(0, Byte), "pub_name", System.Data.DataRowVersion.Original, Nothing))
        Me.SqlUpdateCommand1.Parameters.Add(New System.Data.SqlClient.SqlParameter("@Original_state", System.Data.SqlDbType.NVarChar, 2, System.Data.ParameterDirection.Input, False, CType(0, Byte), CType(0, Byte), "state", System.Data.DataRowVersion.Original, Nothing))
        '
        'SqlDataAdapter2
        '
        Me.SqlDataAdapter2.DeleteCommand = Me.SqlDeleteCommand2
        Me.SqlDataAdapter2.InsertCommand = Me.SqlInsertCommand2
        Me.SqlDataAdapter2.SelectCommand = Me.SqlSelectCommand2
        Me.SqlDataAdapter2.TableMappings.AddRange(New System.Data.Common.DataTableMapping() {New System.Data.Common.DataTableMapping("Table", "titles", New System.Data.Common.DataColumnMapping() {New System.Data.Common.DataColumnMapping("title_id", "title_id"), New System.Data.Common.DataColumnMapping("title", "title"), New System.Data.Common.DataColumnMapping("type", "type"), New System.Data.Common.DataColumnMapping("pub_id", "pub_id"), New System.Data.Common.DataColumnMapping("price", "price"), New System.Data.Common.DataColumnMapping("advance", "advance"), New System.Data.Common.DataColumnMapping("royalty", "royalty"), New System.Data.Common.DataColumnMapping("ytd_sales", "ytd_sales"), New System.Data.Common.DataColumnMapping("notes", "notes"), New System.Data.Common.DataColumnMapping("pubdate", "pubdate")})})
        Me.SqlDataAdapter2.UpdateCommand = Me.SqlUpdateCommand2
        '
        'SqlDeleteCommand2
        '
        Me.SqlDeleteCommand2.CommandText = "DELETE FROM titles WHERE (title_id = @Original_title_id) AND (advance = @Original" & _
        "_advance OR @Original_advance IS NULL AND advance IS NULL) AND (notes = @Origina" & _
        "l_notes OR @Original_notes IS NULL AND notes IS NULL) AND (price = @Original_pri" & _
        "ce OR @Original_price IS NULL AND price IS NULL) AND (pub_id = @Original_pub_id " & _
        "OR @Original_pub_id IS NULL AND pub_id IS NULL) AND (pubdate = @Original_pubdate" & _
        ") AND (royalty = @Original_royalty OR @Original_royalty IS NULL AND royalty IS N" & _
        "ULL) AND (title = @Original_title) AND (type = @Original_type) AND (ytd_sales = " & _
        "@Original_ytd_sales OR @Original_ytd_sales IS NULL AND ytd_sales IS NULL)"
        Me.SqlDeleteCommand2.Connection = Me.SqlConnection1
        Me.SqlDeleteCommand2.Parameters.Add(New System.Data.SqlClient.SqlParameter("@Original_title_id", System.Data.SqlDbType.NVarChar, 6, System.Data.ParameterDirection.Input, False, CType(0, Byte), CType(0, Byte), "title_id", System.Data.DataRowVersion.Original, Nothing))
        Me.SqlDeleteCommand2.Parameters.Add(New System.Data.SqlClient.SqlParameter("@Original_advance", System.Data.SqlDbType.Money, 8, System.Data.ParameterDirection.Input, False, CType(0, Byte), CType(0, Byte), "advance", System.Data.DataRowVersion.Original, Nothing))
        Me.SqlDeleteCommand2.Parameters.Add(New System.Data.SqlClient.SqlParameter("@Original_notes", System.Data.SqlDbType.NVarChar, 200, System.Data.ParameterDirection.Input, False, CType(0, Byte), CType(0, Byte), "notes", System.Data.DataRowVersion.Original, Nothing))
        Me.SqlDeleteCommand2.Parameters.Add(New System.Data.SqlClient.SqlParameter("@Original_price", System.Data.SqlDbType.Money, 8, System.Data.ParameterDirection.Input, False, CType(0, Byte), CType(0, Byte), "price", System.Data.DataRowVersion.Original, Nothing))
        Me.SqlDeleteCommand2.Parameters.Add(New System.Data.SqlClient.SqlParameter("@Original_pub_id", System.Data.SqlDbType.NVarChar, 4, System.Data.ParameterDirection.Input, False, CType(0, Byte), CType(0, Byte), "pub_id", System.Data.DataRowVersion.Original, Nothing))
        Me.SqlDeleteCommand2.Parameters.Add(New System.Data.SqlClient.SqlParameter("@Original_pubdate", System.Data.SqlDbType.DateTime, 8, System.Data.ParameterDirection.Input, False, CType(0, Byte), CType(0, Byte), "pubdate", System.Data.DataRowVersion.Original, Nothing))
        Me.SqlDeleteCommand2.Parameters.Add(New System.Data.SqlClient.SqlParameter("@Original_royalty", System.Data.SqlDbType.Int, 4, System.Data.ParameterDirection.Input, False, CType(0, Byte), CType(0, Byte), "royalty", System.Data.DataRowVersion.Original, Nothing))
        Me.SqlDeleteCommand2.Parameters.Add(New System.Data.SqlClient.SqlParameter("@Original_title", System.Data.SqlDbType.NVarChar, 80, System.Data.ParameterDirection.Input, False, CType(0, Byte), CType(0, Byte), "title", System.Data.DataRowVersion.Original, Nothing))
        Me.SqlDeleteCommand2.Parameters.Add(New System.Data.SqlClient.SqlParameter("@Original_type", System.Data.SqlDbType.NVarChar, 12, System.Data.ParameterDirection.Input, False, CType(0, Byte), CType(0, Byte), "type", System.Data.DataRowVersion.Original, Nothing))
        Me.SqlDeleteCommand2.Parameters.Add(New System.Data.SqlClient.SqlParameter("@Original_ytd_sales", System.Data.SqlDbType.Int, 4, System.Data.ParameterDirection.Input, False, CType(0, Byte), CType(0, Byte), "ytd_sales", System.Data.DataRowVersion.Original, Nothing))
        '
        'SqlInsertCommand2
        '
        Me.SqlInsertCommand2.CommandText = "INSERT INTO titles(title_id, title, type, pub_id, price, advance, royalty, ytd_sa" & _
        "les, notes, pubdate) VALUES (@title_id, @title, @type, @pub_id, @price, @advance" & _
        ", @royalty, @ytd_sales, @notes, @pubdate); SELECT title_id, title, type, pub_id," & _
        " price, advance, royalty, ytd_sales, notes, pubdate FROM titles WHERE (title_id " & _
        "= @title_id)"
        Me.SqlInsertCommand2.Connection = Me.SqlConnection1
        Me.SqlInsertCommand2.Parameters.Add(New System.Data.SqlClient.SqlParameter("@title_id", System.Data.SqlDbType.NVarChar, 6, "title_id"))
        Me.SqlInsertCommand2.Parameters.Add(New System.Data.SqlClient.SqlParameter("@title", System.Data.SqlDbType.NVarChar, 80, "title"))
        Me.SqlInsertCommand2.Parameters.Add(New System.Data.SqlClient.SqlParameter("@type", System.Data.SqlDbType.NVarChar, 12, "type"))
        Me.SqlInsertCommand2.Parameters.Add(New System.Data.SqlClient.SqlParameter("@pub_id", System.Data.SqlDbType.NVarChar, 4, "pub_id"))
        Me.SqlInsertCommand2.Parameters.Add(New System.Data.SqlClient.SqlParameter("@price", System.Data.SqlDbType.Money, 8, "price"))
        Me.SqlInsertCommand2.Parameters.Add(New System.Data.SqlClient.SqlParameter("@advance", System.Data.SqlDbType.Money, 8, "advance"))
        Me.SqlInsertCommand2.Parameters.Add(New System.Data.SqlClient.SqlParameter("@royalty", System.Data.SqlDbType.Int, 4, "royalty"))
        Me.SqlInsertCommand2.Parameters.Add(New System.Data.SqlClient.SqlParameter("@ytd_sales", System.Data.SqlDbType.Int, 4, "ytd_sales"))
        Me.SqlInsertCommand2.Parameters.Add(New System.Data.SqlClient.SqlParameter("@notes", System.Data.SqlDbType.NVarChar, 200, "notes"))
        Me.SqlInsertCommand2.Parameters.Add(New System.Data.SqlClient.SqlParameter("@pubdate", System.Data.SqlDbType.DateTime, 8, "pubdate"))
        '
        'SqlSelectCommand2
        '
        Me.SqlSelectCommand2.CommandText = "SELECT title_id, title, type, pub_id, price, advance, royalty, ytd_sales, notes, " & _
        "pubdate FROM titles"
        Me.SqlSelectCommand2.Connection = Me.SqlConnection1
        '
        'SqlUpdateCommand2
        '
        Me.SqlUpdateCommand2.CommandText = "UPDATE titles SET title_id = @title_id, title = @title, type = @type, pub_id = @p" & _
        "ub_id, price = @price, advance = @advance, royalty = @royalty, ytd_sales = @ytd_" & _
        "sales, notes = @notes, pubdate = @pubdate WHERE (title_id = @Original_title_id) " & _
        "AND (advance = @Original_advance OR @Original_advance IS NULL AND advance IS NUL" & _
        "L) AND (notes = @Original_notes OR @Original_notes IS NULL AND notes IS NULL) AN" & _
        "D (price = @Original_price OR @Original_price IS NULL AND price IS NULL) AND (pu" & _
        "b_id = @Original_pub_id OR @Original_pub_id IS NULL AND pub_id IS NULL) AND (pub" & _
        "date = @Original_pubdate) AND (royalty = @Original_royalty OR @Original_royalty " & _
        "IS NULL AND royalty IS NULL) AND (title = @Original_title) AND (type = @Original" & _
        "_type) AND (ytd_sales = @Original_ytd_sales OR @Original_ytd_sales IS NULL AND y" & _
        "td_sales IS NULL); SELECT title_id, title, type, pub_id, price, advance, royalty" & _
        ", ytd_sales, notes, pubdate FROM titles WHERE (title_id = @title_id)"
        Me.SqlUpdateCommand2.Connection = Me.SqlConnection1
        Me.SqlUpdateCommand2.Parameters.Add(New System.Data.SqlClient.SqlParameter("@title_id", System.Data.SqlDbType.NVarChar, 6, "title_id"))
        Me.SqlUpdateCommand2.Parameters.Add(New System.Data.SqlClient.SqlParameter("@title", System.Data.SqlDbType.NVarChar, 80, "title"))
        Me.SqlUpdateCommand2.Parameters.Add(New System.Data.SqlClient.SqlParameter("@type", System.Data.SqlDbType.NVarChar, 12, "type"))
        Me.SqlUpdateCommand2.Parameters.Add(New System.Data.SqlClient.SqlParameter("@pub_id", System.Data.SqlDbType.NVarChar, 4, "pub_id"))
        Me.SqlUpdateCommand2.Parameters.Add(New System.Data.SqlClient.SqlParameter("@price", System.Data.SqlDbType.Money, 8, "price"))
        Me.SqlUpdateCommand2.Parameters.Add(New System.Data.SqlClient.SqlParameter("@advance", System.Data.SqlDbType.Money, 8, "advance"))
        Me.SqlUpdateCommand2.Parameters.Add(New System.Data.SqlClient.SqlParameter("@royalty", System.Data.SqlDbType.Int, 4, "royalty"))
        Me.SqlUpdateCommand2.Parameters.Add(New System.Data.SqlClient.SqlParameter("@ytd_sales", System.Data.SqlDbType.Int, 4, "ytd_sales"))
        Me.SqlUpdateCommand2.Parameters.Add(New System.Data.SqlClient.SqlParameter("@notes", System.Data.SqlDbType.NVarChar, 200, "notes"))
        Me.SqlUpdateCommand2.Parameters.Add(New System.Data.SqlClient.SqlParameter("@pubdate", System.Data.SqlDbType.DateTime, 8, "pubdate"))
        Me.SqlUpdateCommand2.Parameters.Add(New System.Data.SqlClient.SqlParameter("@Original_title_id", System.Data.SqlDbType.NVarChar, 6, System.Data.ParameterDirection.Input, False, CType(0, Byte), CType(0, Byte), "title_id", System.Data.DataRowVersion.Original, Nothing))
        Me.SqlUpdateCommand2.Parameters.Add(New System.Data.SqlClient.SqlParameter("@Original_advance", System.Data.SqlDbType.Money, 8, System.Data.ParameterDirection.Input, False, CType(0, Byte), CType(0, Byte), "advance", System.Data.DataRowVersion.Original, Nothing))
        Me.SqlUpdateCommand2.Parameters.Add(New System.Data.SqlClient.SqlParameter("@Original_notes", System.Data.SqlDbType.NVarChar, 200, System.Data.ParameterDirection.Input, False, CType(0, Byte), CType(0, Byte), "notes", System.Data.DataRowVersion.Original, Nothing))
        Me.SqlUpdateCommand2.Parameters.Add(New System.Data.SqlClient.SqlParameter("@Original_price", System.Data.SqlDbType.Money, 8, System.Data.ParameterDirection.Input, False, CType(0, Byte), CType(0, Byte), "price", System.Data.DataRowVersion.Original, Nothing))
        Me.SqlUpdateCommand2.Parameters.Add(New System.Data.SqlClient.SqlParameter("@Original_pub_id", System.Data.SqlDbType.NVarChar, 4, System.Data.ParameterDirection.Input, False, CType(0, Byte), CType(0, Byte), "pub_id", System.Data.DataRowVersion.Original, Nothing))
        Me.SqlUpdateCommand2.Parameters.Add(New System.Data.SqlClient.SqlParameter("@Original_pubdate", System.Data.SqlDbType.DateTime, 8, System.Data.ParameterDirection.Input, False, CType(0, Byte), CType(0, Byte), "pubdate", System.Data.DataRowVersion.Original, Nothing))
        Me.SqlUpdateCommand2.Parameters.Add(New System.Data.SqlClient.SqlParameter("@Original_royalty", System.Data.SqlDbType.Int, 4, System.Data.ParameterDirection.Input, False, CType(0, Byte), CType(0, Byte), "royalty", System.Data.DataRowVersion.Original, Nothing))
        Me.SqlUpdateCommand2.Parameters.Add(New System.Data.SqlClient.SqlParameter("@Original_title", System.Data.SqlDbType.NVarChar, 80, System.Data.ParameterDirection.Input, False, CType(0, Byte), CType(0, Byte), "title", System.Data.DataRowVersion.Original, Nothing))
        Me.SqlUpdateCommand2.Parameters.Add(New System.Data.SqlClient.SqlParameter("@Original_type", System.Data.SqlDbType.NVarChar, 12, System.Data.ParameterDirection.Input, False, CType(0, Byte), CType(0, Byte), "type", System.Data.DataRowVersion.Original, Nothing))
        Me.SqlUpdateCommand2.Parameters.Add(New System.Data.SqlClient.SqlParameter("@Original_ytd_sales", System.Data.SqlDbType.Int, 4, System.Data.ParameterDirection.Input, False, CType(0, Byte), CType(0, Byte), "ytd_sales", System.Data.DataRowVersion.Original, Nothing))
        '
        'Form1
        '
        Me.AutoScaleBaseSize = New System.Drawing.Size(5, 13)
        Me.ClientSize = New System.Drawing.Size(584, 282)
        Me.Controls.Add(Me.DataGrid1)
        Me.Controls.Add(Me.ComboBox1)
        Me.Controls.Add(Me.Label1)
        Me.Name = "Form1"
        Me.Text = "Form1"
        CType(Me.DataSet11, System.ComponentModel.ISupportInitialize).EndInit()
        CType(Me.DataGrid1, System.ComponentModel.ISupportInitialize).EndInit()
        Me.ResumeLayout(False)

    End Sub

#End Region

    Private Sub Form1_Load(ByVal sender As System.Object, ByVal e As System.EventArgs) Handles MyBase.Load
        SqlDataAdapter1.Fill(DataSet11)
        SqlDataAdapter2.Fill(DataSet11)
    End Sub
End Class
