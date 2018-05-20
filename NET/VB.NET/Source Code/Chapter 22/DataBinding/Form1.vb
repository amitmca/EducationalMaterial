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
    Friend WithEvents TextBox1 As System.Windows.Forms.TextBox
    Friend WithEvents CheckBox1 As System.Windows.Forms.CheckBox
    Friend WithEvents CheckedListBox1 As System.Windows.Forms.CheckedListBox
    Friend WithEvents Panel1 As System.Windows.Forms.Panel
    Friend WithEvents DataGrid1 As System.Windows.Forms.DataGrid
    Friend WithEvents ListBox1 As System.Windows.Forms.ListBox
    Friend WithEvents ComboBox1 As System.Windows.Forms.ComboBox
    Friend WithEvents SqlDataAdapter1 As System.Data.SqlClient.SqlDataAdapter
    Friend WithEvents SqlSelectCommand1 As System.Data.SqlClient.SqlCommand
    Friend WithEvents SqlInsertCommand1 As System.Data.SqlClient.SqlCommand
    Friend WithEvents SqlUpdateCommand1 As System.Data.SqlClient.SqlCommand
    Friend WithEvents SqlDeleteCommand1 As System.Data.SqlClient.SqlCommand
    Friend WithEvents SqlConnection1 As System.Data.SqlClient.SqlConnection
    Friend WithEvents DataSet11 As DataBinding.DataSet1
    Friend WithEvents Label1 As System.Windows.Forms.Label
    Friend WithEvents Label2 As System.Windows.Forms.Label
    Friend WithEvents Label3 As System.Windows.Forms.Label
    Friend WithEvents Label4 As System.Windows.Forms.Label
    Friend WithEvents Label5 As System.Windows.Forms.Label
    Friend WithEvents Label6 As System.Windows.Forms.Label
    Friend WithEvents Button1 As System.Windows.Forms.Button
    Friend WithEvents Button2 As System.Windows.Forms.Button
    Friend WithEvents Button3 As System.Windows.Forms.Button
    Friend WithEvents Button4 As System.Windows.Forms.Button
    Friend WithEvents Label7 As System.Windows.Forms.Label
    Friend WithEvents TextBox2 As System.Windows.Forms.TextBox
    Friend WithEvents Label8 As System.Windows.Forms.Label
    Friend WithEvents StatusBar1 As System.Windows.Forms.StatusBar
    <System.Diagnostics.DebuggerStepThrough()> Private Sub InitializeComponent()
        Me.TextBox1 = New System.Windows.Forms.TextBox
        Me.CheckBox1 = New System.Windows.Forms.CheckBox
        Me.DataSet11 = New DataBinding.DataSet1
        Me.CheckedListBox1 = New System.Windows.Forms.CheckedListBox
        Me.Panel1 = New System.Windows.Forms.Panel
        Me.DataGrid1 = New System.Windows.Forms.DataGrid
        Me.ListBox1 = New System.Windows.Forms.ListBox
        Me.ComboBox1 = New System.Windows.Forms.ComboBox
        Me.SqlDataAdapter1 = New System.Data.SqlClient.SqlDataAdapter
        Me.SqlDeleteCommand1 = New System.Data.SqlClient.SqlCommand
        Me.SqlConnection1 = New System.Data.SqlClient.SqlConnection
        Me.SqlInsertCommand1 = New System.Data.SqlClient.SqlCommand
        Me.SqlSelectCommand1 = New System.Data.SqlClient.SqlCommand
        Me.SqlUpdateCommand1 = New System.Data.SqlClient.SqlCommand
        Me.Label1 = New System.Windows.Forms.Label
        Me.Label2 = New System.Windows.Forms.Label
        Me.Label3 = New System.Windows.Forms.Label
        Me.Label4 = New System.Windows.Forms.Label
        Me.Label5 = New System.Windows.Forms.Label
        Me.Label6 = New System.Windows.Forms.Label
        Me.Button1 = New System.Windows.Forms.Button
        Me.Button2 = New System.Windows.Forms.Button
        Me.Button3 = New System.Windows.Forms.Button
        Me.Button4 = New System.Windows.Forms.Button
        Me.Label7 = New System.Windows.Forms.Label
        Me.TextBox2 = New System.Windows.Forms.TextBox
        Me.Label8 = New System.Windows.Forms.Label
        Me.StatusBar1 = New System.Windows.Forms.StatusBar
        CType(Me.DataSet11, System.ComponentModel.ISupportInitialize).BeginInit()
        Me.Panel1.SuspendLayout()
        CType(Me.DataGrid1, System.ComponentModel.ISupportInitialize).BeginInit()
        Me.SuspendLayout()
        '
        'TextBox1
        '
        Me.TextBox1.Location = New System.Drawing.Point(104, 24)
        Me.TextBox1.Name = "TextBox1"
        Me.TextBox1.Size = New System.Drawing.Size(160, 20)
        Me.TextBox1.TabIndex = 0
        Me.TextBox1.Text = "TextBox1"
        '
        'CheckBox1
        '
        Me.CheckBox1.DataBindings.Add(New System.Windows.Forms.Binding("Checked", Me.DataSet11, "authors.contract"))
        Me.CheckBox1.Location = New System.Drawing.Point(110, 73)
        Me.CheckBox1.Name = "CheckBox1"
        Me.CheckBox1.TabIndex = 1
        '
        'DataSet11
        '
        Me.DataSet11.DataSetName = "DataSet1"
        Me.DataSet11.Locale = New System.Globalization.CultureInfo("en-US")
        '
        'CheckedListBox1
        '
        Me.CheckedListBox1.Location = New System.Drawing.Point(16, 144)
        Me.CheckedListBox1.Name = "CheckedListBox1"
        Me.CheckedListBox1.Size = New System.Drawing.Size(152, 79)
        Me.CheckedListBox1.TabIndex = 3
        '
        'Panel1
        '
        Me.Panel1.Controls.Add(Me.DataGrid1)
        Me.Panel1.Location = New System.Drawing.Point(8, 248)
        Me.Panel1.Name = "Panel1"
        Me.Panel1.Size = New System.Drawing.Size(624, 160)
        Me.Panel1.TabIndex = 5
        '
        'DataGrid1
        '
        Me.DataGrid1.DataMember = "authors"
        Me.DataGrid1.DataSource = Me.DataSet11
        Me.DataGrid1.Dock = System.Windows.Forms.DockStyle.Fill
        Me.DataGrid1.HeaderForeColor = System.Drawing.SystemColors.ControlText
        Me.DataGrid1.Location = New System.Drawing.Point(0, 0)
        Me.DataGrid1.Name = "DataGrid1"
        Me.DataGrid1.Size = New System.Drawing.Size(624, 160)
        Me.DataGrid1.TabIndex = 0
        '
        'ListBox1
        '
        Me.ListBox1.Location = New System.Drawing.Point(216, 144)
        Me.ListBox1.Name = "ListBox1"
        Me.ListBox1.Size = New System.Drawing.Size(152, 82)
        Me.ListBox1.TabIndex = 6
        '
        'ComboBox1
        '
        Me.ComboBox1.Location = New System.Drawing.Point(392, 144)
        Me.ComboBox1.Name = "ComboBox1"
        Me.ComboBox1.Size = New System.Drawing.Size(121, 21)
        Me.ComboBox1.TabIndex = 7
        Me.ComboBox1.Text = "ComboBox1"
        '
        'SqlDataAdapter1
        '
        Me.SqlDataAdapter1.DeleteCommand = Me.SqlDeleteCommand1
        Me.SqlDataAdapter1.InsertCommand = Me.SqlInsertCommand1
        Me.SqlDataAdapter1.SelectCommand = Me.SqlSelectCommand1
        Me.SqlDataAdapter1.TableMappings.AddRange(New System.Data.Common.DataTableMapping() {New System.Data.Common.DataTableMapping("Table", "authors", New System.Data.Common.DataColumnMapping() {New System.Data.Common.DataColumnMapping("au_id", "au_id"), New System.Data.Common.DataColumnMapping("au_lname", "au_lname"), New System.Data.Common.DataColumnMapping("au_fname", "au_fname"), New System.Data.Common.DataColumnMapping("phone", "phone"), New System.Data.Common.DataColumnMapping("city", "city"), New System.Data.Common.DataColumnMapping("state", "state"), New System.Data.Common.DataColumnMapping("address", "address"), New System.Data.Common.DataColumnMapping("zip", "zip"), New System.Data.Common.DataColumnMapping("contract", "contract")})})
        Me.SqlDataAdapter1.UpdateCommand = Me.SqlUpdateCommand1
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
        'SqlConnection1
        '
        Me.SqlConnection1.ConnectionString = "workstation id=CHARUL;packet size=4096;user id=sa;integrated security=SSPI;data s" & _
        "ource=""CHARUL\NetSDK"";persist security info=False;initial catalog=pubs"
        '
        'SqlInsertCommand1
        '
        Me.SqlInsertCommand1.CommandText = "INSERT INTO authors(au_id, au_lname, au_fname, phone, city, state, address, zip, " & _
        "contract) VALUES (@au_id, @au_lname, @au_fname, @phone, @city, @state, @address," & _
        " @zip, @contract); SELECT au_id, au_lname, au_fname, phone, city, state, address" & _
        ", zip, contract FROM authors WHERE (au_id = @au_id)"
        Me.SqlInsertCommand1.Connection = Me.SqlConnection1
        Me.SqlInsertCommand1.Parameters.Add(New System.Data.SqlClient.SqlParameter("@au_id", System.Data.SqlDbType.NVarChar, 11, "au_id"))
        Me.SqlInsertCommand1.Parameters.Add(New System.Data.SqlClient.SqlParameter("@au_lname", System.Data.SqlDbType.NVarChar, 40, "au_lname"))
        Me.SqlInsertCommand1.Parameters.Add(New System.Data.SqlClient.SqlParameter("@au_fname", System.Data.SqlDbType.NVarChar, 20, "au_fname"))
        Me.SqlInsertCommand1.Parameters.Add(New System.Data.SqlClient.SqlParameter("@phone", System.Data.SqlDbType.NVarChar, 12, "phone"))
        Me.SqlInsertCommand1.Parameters.Add(New System.Data.SqlClient.SqlParameter("@city", System.Data.SqlDbType.NVarChar, 20, "city"))
        Me.SqlInsertCommand1.Parameters.Add(New System.Data.SqlClient.SqlParameter("@state", System.Data.SqlDbType.NVarChar, 2, "state"))
        Me.SqlInsertCommand1.Parameters.Add(New System.Data.SqlClient.SqlParameter("@address", System.Data.SqlDbType.NVarChar, 40, "address"))
        Me.SqlInsertCommand1.Parameters.Add(New System.Data.SqlClient.SqlParameter("@zip", System.Data.SqlDbType.NVarChar, 5, "zip"))
        Me.SqlInsertCommand1.Parameters.Add(New System.Data.SqlClient.SqlParameter("@contract", System.Data.SqlDbType.Bit, 1, "contract"))
        '
        'SqlSelectCommand1
        '
        Me.SqlSelectCommand1.CommandText = "SELECT au_id, au_lname, au_fname, phone, city, state, address, zip, contract FROM" & _
        " authors"
        Me.SqlSelectCommand1.Connection = Me.SqlConnection1
        '
        'SqlUpdateCommand1
        '
        Me.SqlUpdateCommand1.CommandText = "UPDATE authors SET au_id = @au_id, au_lname = @au_lname, au_fname = @au_fname, ph" & _
        "one = @phone, city = @city, state = @state, address = @address, zip = @zip, cont" & _
        "ract = @contract WHERE (au_id = @Original_au_id) AND (address = @Original_addres" & _
        "s OR @Original_address IS NULL AND address IS NULL) AND (au_fname = @Original_au" & _
        "_fname) AND (au_lname = @Original_au_lname) AND (city = @Original_city OR @Origi" & _
        "nal_city IS NULL AND city IS NULL) AND (contract = @Original_contract) AND (phon" & _
        "e = @Original_phone) AND (state = @Original_state OR @Original_state IS NULL AND" & _
        " state IS NULL) AND (zip = @Original_zip OR @Original_zip IS NULL AND zip IS NUL" & _
        "L); SELECT au_id, au_lname, au_fname, phone, city, state, address, zip, contract" & _
        " FROM authors WHERE (au_id = @au_id)"
        Me.SqlUpdateCommand1.Connection = Me.SqlConnection1
        Me.SqlUpdateCommand1.Parameters.Add(New System.Data.SqlClient.SqlParameter("@au_id", System.Data.SqlDbType.NVarChar, 11, "au_id"))
        Me.SqlUpdateCommand1.Parameters.Add(New System.Data.SqlClient.SqlParameter("@au_lname", System.Data.SqlDbType.NVarChar, 40, "au_lname"))
        Me.SqlUpdateCommand1.Parameters.Add(New System.Data.SqlClient.SqlParameter("@au_fname", System.Data.SqlDbType.NVarChar, 20, "au_fname"))
        Me.SqlUpdateCommand1.Parameters.Add(New System.Data.SqlClient.SqlParameter("@phone", System.Data.SqlDbType.NVarChar, 12, "phone"))
        Me.SqlUpdateCommand1.Parameters.Add(New System.Data.SqlClient.SqlParameter("@city", System.Data.SqlDbType.NVarChar, 20, "city"))
        Me.SqlUpdateCommand1.Parameters.Add(New System.Data.SqlClient.SqlParameter("@state", System.Data.SqlDbType.NVarChar, 2, "state"))
        Me.SqlUpdateCommand1.Parameters.Add(New System.Data.SqlClient.SqlParameter("@address", System.Data.SqlDbType.NVarChar, 40, "address"))
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
        'Label1
        '
        Me.Label1.Location = New System.Drawing.Point(32, 32)
        Me.Label1.Name = "Label1"
        Me.Label1.Size = New System.Drawing.Size(64, 23)
        Me.Label1.TabIndex = 8
        Me.Label1.Text = "Author ID"
        '
        'Label2
        '
        Me.Label2.Location = New System.Drawing.Point(32, 80)
        Me.Label2.Name = "Label2"
        Me.Label2.Size = New System.Drawing.Size(56, 23)
        Me.Label2.TabIndex = 9
        Me.Label2.Text = "Contract"
        '
        'Label3
        '
        Me.Label3.Location = New System.Drawing.Point(24, 120)
        Me.Label3.Name = "Label3"
        Me.Label3.Size = New System.Drawing.Size(64, 16)
        Me.Label3.TabIndex = 10
        Me.Label3.Text = "Last Name"
        '
        'Label4
        '
        Me.Label4.Location = New System.Drawing.Point(224, 120)
        Me.Label4.Name = "Label4"
        Me.Label4.Size = New System.Drawing.Size(64, 16)
        Me.Label4.TabIndex = 11
        Me.Label4.Text = "First Name"
        '
        'Label5
        '
        Me.Label5.Location = New System.Drawing.Point(392, 120)
        Me.Label5.Name = "Label5"
        Me.Label5.Size = New System.Drawing.Size(64, 16)
        Me.Label5.TabIndex = 12
        Me.Label5.Text = "City"
        '
        'Label6
        '
        Me.Label6.Location = New System.Drawing.Point(16, 232)
        Me.Label6.Name = "Label6"
        Me.Label6.Size = New System.Drawing.Size(96, 16)
        Me.Label6.TabIndex = 13
        Me.Label6.Text = "Complete Data"
        '
        'Button1
        '
        Me.Button1.FlatStyle = System.Windows.Forms.FlatStyle.System
        Me.Button1.Location = New System.Drawing.Point(384, 48)
        Me.Button1.Name = "Button1"
        Me.Button1.TabIndex = 14
        Me.Button1.Text = "<"
        '
        'Button2
        '
        Me.Button2.FlatStyle = System.Windows.Forms.FlatStyle.System
        Me.Button2.Location = New System.Drawing.Point(472, 48)
        Me.Button2.Name = "Button2"
        Me.Button2.TabIndex = 15
        Me.Button2.Text = ">"
        '
        'Button3
        '
        Me.Button3.FlatStyle = System.Windows.Forms.FlatStyle.System
        Me.Button3.Location = New System.Drawing.Point(296, 48)
        Me.Button3.Name = "Button3"
        Me.Button3.TabIndex = 16
        Me.Button3.Text = "<<"
        '
        'Button4
        '
        Me.Button4.FlatStyle = System.Windows.Forms.FlatStyle.System
        Me.Button4.Location = New System.Drawing.Point(552, 48)
        Me.Button4.Name = "Button4"
        Me.Button4.TabIndex = 17
        Me.Button4.Text = ">>"
        '
        'Label7
        '
        Me.Label7.Location = New System.Drawing.Point(400, 24)
        Me.Label7.Name = "Label7"
        Me.Label7.Size = New System.Drawing.Size(120, 16)
        Me.Label7.TabIndex = 18
        Me.Label7.Text = "Navigation Panel"
        '
        'TextBox2
        '
        Me.TextBox2.DataBindings.Add(New System.Windows.Forms.Binding("Text", Me.DataSet11, "authors.phone"))
        Me.TextBox2.Location = New System.Drawing.Point(392, 207)
        Me.TextBox2.Name = "TextBox2"
        Me.TextBox2.Size = New System.Drawing.Size(128, 20)
        Me.TextBox2.TabIndex = 19
        Me.TextBox2.Text = "TextBox2"
        '
        'Label8
        '
        Me.Label8.Location = New System.Drawing.Point(392, 181)
        Me.Label8.Name = "Label8"
        Me.Label8.Size = New System.Drawing.Size(40, 16)
        Me.Label8.TabIndex = 20
        Me.Label8.Text = "Phone"
        '
        'StatusBar1
        '
        Me.StatusBar1.Location = New System.Drawing.Point(0, 420)
        Me.StatusBar1.Name = "StatusBar1"
        Me.StatusBar1.Size = New System.Drawing.Size(640, 22)
        Me.StatusBar1.TabIndex = 21
        Me.StatusBar1.Text = "StatusBar1"
        '
        'Form1
        '
        Me.AutoScaleBaseSize = New System.Drawing.Size(5, 13)
        Me.ClientSize = New System.Drawing.Size(640, 442)
        Me.Controls.Add(Me.StatusBar1)
        Me.Controls.Add(Me.Label8)
        Me.Controls.Add(Me.TextBox2)
        Me.Controls.Add(Me.Label7)
        Me.Controls.Add(Me.Button4)
        Me.Controls.Add(Me.Button3)
        Me.Controls.Add(Me.Button2)
        Me.Controls.Add(Me.Button1)
        Me.Controls.Add(Me.Label6)
        Me.Controls.Add(Me.Label5)
        Me.Controls.Add(Me.Label4)
        Me.Controls.Add(Me.Label3)
        Me.Controls.Add(Me.Label2)
        Me.Controls.Add(Me.Label1)
        Me.Controls.Add(Me.ComboBox1)
        Me.Controls.Add(Me.ListBox1)
        Me.Controls.Add(Me.Panel1)
        Me.Controls.Add(Me.CheckedListBox1)
        Me.Controls.Add(Me.CheckBox1)
        Me.Controls.Add(Me.TextBox1)
        Me.Name = "Form1"
        Me.Text = "Data Binding Example"
        CType(Me.DataSet11, System.ComponentModel.ISupportInitialize).EndInit()
        Me.Panel1.ResumeLayout(False)
        CType(Me.DataGrid1, System.ComponentModel.ISupportInitialize).EndInit()
        Me.ResumeLayout(False)

    End Sub

#End Region

    Private Sub Form1_Load(ByVal sender As System.Object, ByVal e As System.EventArgs) Handles MyBase.Load


        DataSet11.Clear()
        SqlDataAdapter1.Fill(DataSet11)



        CheckedListBox1.DataSource = DataSet11
        CheckedListBox1.DisplayMember = "authors.au_lname"
        CheckedListBox1.ValueMember = "authors.au_id"

        ListBox1.DataSource = DataSet11
        ListBox1.DisplayMember = "authors.au_fname"
        ListBox1.ValueMember = "authors.au_id"


        ComboBox1.DataSource = DataSet11
        ComboBox1.DisplayMember = "authors.city"
        ComboBox1.ValueMember = "authors.au_id"

        TextBox1.Text = ""

        StatusBar1.Text = (Me.BindingContext(DataSet11, "authors").Position + 1).ToString & " of " & Me.BindingContext(DataSet11, "authors").Count.ToString

    End Sub

    Private Sub CheckedListBox1_SelectedIndexChanged(ByVal sender As System.Object, ByVal e As System.EventArgs) Handles CheckedListBox1.SelectedIndexChanged
        TextBox1.Text = CheckedListBox1.SelectedValue.ToString()
    End Sub

    Private Sub Button2_Click(ByVal sender As System.Object, ByVal e As System.EventArgs) Handles Button2.Click
        Me.BindingContext(DataSet11, "authors").Position = (Me.BindingContext(DataSet11, "authors").Position + 1)
        StatusBar1.Text = "You are currently at Record  " & (Me.BindingContext(DataSet11, "authors").Position + 1).ToString & " of " & Me.BindingContext(DataSet11, "authors").Count.ToString


    End Sub

    Private Sub Button1_Click(ByVal sender As System.Object, ByVal e As System.EventArgs) Handles Button1.Click
        Me.BindingContext(DataSet11, "authors").Position = (Me.BindingContext(DataSet11, "authors").Position - 1)
        StatusBar1.Text = "You are currently at Record  " & (Me.BindingContext(DataSet11, "authors").Position + 1).ToString & " of " & Me.BindingContext(DataSet11, "authors").Count.ToString
    End Sub

    Private Sub Button4_Click(ByVal sender As System.Object, ByVal e As System.EventArgs) Handles Button4.Click
        Me.BindingContext(DataSet11, "authors").Position = (Me.BindingContext(DataSet11, "authors").Count - 1)
        StatusBar1.Text = "You are currently at Record  " & (Me.BindingContext(DataSet11, "authors").Position + 1).ToString & " of " & Me.BindingContext(DataSet11, "authors").Count.ToString
    End Sub

    Private Sub Button3_Click(ByVal sender As System.Object, ByVal e As System.EventArgs) Handles Button3.Click
        Me.BindingContext(DataSet11, "authors").Position = 0
        StatusBar1.Text = "You are currently at Record  " & (Me.BindingContext(DataSet11, "authors").Position + 1).ToString & " of " & Me.BindingContext(DataSet11, "authors").Count.ToString

    End Sub
End Class
