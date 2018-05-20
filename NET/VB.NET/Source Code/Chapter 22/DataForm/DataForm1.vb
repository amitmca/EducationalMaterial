Public Class DataForm1
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
    Friend WithEvents OleDbSelectCommand1 As System.Data.OleDb.OleDbCommand
    Friend WithEvents OleDbInsertCommand1 As System.Data.OleDb.OleDbCommand
    Friend WithEvents OleDbUpdateCommand1 As System.Data.OleDb.OleDbCommand
    Friend WithEvents OleDbDeleteCommand1 As System.Data.OleDb.OleDbCommand
    Friend WithEvents OleDbConnection1 As System.Data.OleDb.OleDbConnection
    Friend WithEvents OleDbDataAdapter1 As System.Data.OleDb.OleDbDataAdapter
    Friend WithEvents objdsDataset As DataForm.dsDataset
    Friend WithEvents btnLoad As System.Windows.Forms.Button
    Friend WithEvents btnUpdate As System.Windows.Forms.Button
    Friend WithEvents btnCancelAll As System.Windows.Forms.Button
    Friend WithEvents lblau_id As System.Windows.Forms.Label
    Friend WithEvents lblau_lname As System.Windows.Forms.Label
    Friend WithEvents lblau_fname As System.Windows.Forms.Label
    Friend WithEvents lblphone As System.Windows.Forms.Label
    Friend WithEvents lbladdress As System.Windows.Forms.Label
    Friend WithEvents editau_id As System.Windows.Forms.TextBox
    Friend WithEvents editau_lname As System.Windows.Forms.TextBox
    Friend WithEvents editau_fname As System.Windows.Forms.TextBox
    Friend WithEvents editphone As System.Windows.Forms.TextBox
    Friend WithEvents editaddress As System.Windows.Forms.TextBox
    Friend WithEvents lblcity As System.Windows.Forms.Label
    Friend WithEvents lblstate As System.Windows.Forms.Label
    Friend WithEvents lblzip As System.Windows.Forms.Label
    Friend WithEvents lblcontract As System.Windows.Forms.Label
    Friend WithEvents editcity As System.Windows.Forms.TextBox
    Friend WithEvents editstate As System.Windows.Forms.TextBox
    Friend WithEvents editzip As System.Windows.Forms.TextBox
    Friend WithEvents editcontract As System.Windows.Forms.CheckBox
    Friend WithEvents btnNavFirst As System.Windows.Forms.Button
    Friend WithEvents btnNavPrev As System.Windows.Forms.Button
    Friend WithEvents lblNavLocation As System.Windows.Forms.Label
    Friend WithEvents btnNavNext As System.Windows.Forms.Button
    Friend WithEvents btnLast As System.Windows.Forms.Button
    Friend WithEvents btnAdd As System.Windows.Forms.Button
    Friend WithEvents btnDelete As System.Windows.Forms.Button
    Friend WithEvents btnCancel As System.Windows.Forms.Button
    <System.Diagnostics.DebuggerStepThrough()> Private Sub InitializeComponent()
        Me.OleDbSelectCommand1 = New System.Data.OleDb.OleDbCommand
        Me.OleDbConnection1 = New System.Data.OleDb.OleDbConnection
        Me.OleDbInsertCommand1 = New System.Data.OleDb.OleDbCommand
        Me.OleDbUpdateCommand1 = New System.Data.OleDb.OleDbCommand
        Me.OleDbDeleteCommand1 = New System.Data.OleDb.OleDbCommand
        Me.OleDbDataAdapter1 = New System.Data.OleDb.OleDbDataAdapter
        Me.objdsDataset = New DataForm.dsDataset
        Me.btnLoad = New System.Windows.Forms.Button
        Me.btnUpdate = New System.Windows.Forms.Button
        Me.btnCancelAll = New System.Windows.Forms.Button
        Me.lblau_id = New System.Windows.Forms.Label
        Me.lblau_lname = New System.Windows.Forms.Label
        Me.lblau_fname = New System.Windows.Forms.Label
        Me.lblphone = New System.Windows.Forms.Label
        Me.lbladdress = New System.Windows.Forms.Label
        Me.editau_id = New System.Windows.Forms.TextBox
        Me.editau_lname = New System.Windows.Forms.TextBox
        Me.editau_fname = New System.Windows.Forms.TextBox
        Me.editphone = New System.Windows.Forms.TextBox
        Me.editaddress = New System.Windows.Forms.TextBox
        Me.lblcity = New System.Windows.Forms.Label
        Me.lblstate = New System.Windows.Forms.Label
        Me.lblzip = New System.Windows.Forms.Label
        Me.lblcontract = New System.Windows.Forms.Label
        Me.editcity = New System.Windows.Forms.TextBox
        Me.editstate = New System.Windows.Forms.TextBox
        Me.editzip = New System.Windows.Forms.TextBox
        Me.editcontract = New System.Windows.Forms.CheckBox
        Me.btnNavFirst = New System.Windows.Forms.Button
        Me.btnNavPrev = New System.Windows.Forms.Button
        Me.lblNavLocation = New System.Windows.Forms.Label
        Me.btnNavNext = New System.Windows.Forms.Button
        Me.btnLast = New System.Windows.Forms.Button
        Me.btnAdd = New System.Windows.Forms.Button
        Me.btnDelete = New System.Windows.Forms.Button
        Me.btnCancel = New System.Windows.Forms.Button
        CType(Me.objdsDataset, System.ComponentModel.ISupportInitialize).BeginInit()
        Me.SuspendLayout()
        '
        'OleDbSelectCommand1
        '
        Me.OleDbSelectCommand1.CommandText = "SELECT au_id, au_lname, au_fname, phone, address, city, state, zip, contract FROM" & _
        " authors"
        Me.OleDbSelectCommand1.Connection = Me.OleDbConnection1
        '
        'OleDbConnection1
        '
        Me.OleDbConnection1.ConnectionString = "Auto Translate=True;Integrated Security=SSPI;User ID=sa;Data Source=""CHARUL\NetSD" & _
        "K"";Tag with column collation when possible=False;Initial Catalog=pubs;Use Proced" & _
        "ure for Prepare=1;Provider=""SQLOLEDB.1"";Persist Security Info=False;Workstation " & _
        "ID=CHARUL;Use Encryption for Data=False;Packet Size=4096"
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
        'OleDbDataAdapter1
        '
        Me.OleDbDataAdapter1.DeleteCommand = Me.OleDbDeleteCommand1
        Me.OleDbDataAdapter1.InsertCommand = Me.OleDbInsertCommand1
        Me.OleDbDataAdapter1.SelectCommand = Me.OleDbSelectCommand1
        Me.OleDbDataAdapter1.TableMappings.AddRange(New System.Data.Common.DataTableMapping() {New System.Data.Common.DataTableMapping("Table", "authors", New System.Data.Common.DataColumnMapping() {New System.Data.Common.DataColumnMapping("au_id", "au_id"), New System.Data.Common.DataColumnMapping("au_lname", "au_lname"), New System.Data.Common.DataColumnMapping("au_fname", "au_fname"), New System.Data.Common.DataColumnMapping("phone", "phone"), New System.Data.Common.DataColumnMapping("address", "address"), New System.Data.Common.DataColumnMapping("city", "city"), New System.Data.Common.DataColumnMapping("state", "state"), New System.Data.Common.DataColumnMapping("zip", "zip"), New System.Data.Common.DataColumnMapping("contract", "contract")})})
        Me.OleDbDataAdapter1.UpdateCommand = Me.OleDbUpdateCommand1
        '
        'objdsDataset
        '
        Me.objdsDataset.DataSetName = "dsDataset"
        Me.objdsDataset.Locale = New System.Globalization.CultureInfo("en-US")
        '
        'btnLoad
        '
        Me.btnLoad.FlatStyle = System.Windows.Forms.FlatStyle.System
        Me.btnLoad.Location = New System.Drawing.Point(10, 10)
        Me.btnLoad.Name = "btnLoad"
        Me.btnLoad.TabIndex = 0
        Me.btnLoad.Text = "&Load"
        '
        'btnUpdate
        '
        Me.btnUpdate.FlatStyle = System.Windows.Forms.FlatStyle.System
        Me.btnUpdate.Location = New System.Drawing.Point(365, 10)
        Me.btnUpdate.Name = "btnUpdate"
        Me.btnUpdate.TabIndex = 1
        Me.btnUpdate.Text = "&Update"
        '
        'btnCancelAll
        '
        Me.btnCancelAll.FlatStyle = System.Windows.Forms.FlatStyle.System
        Me.btnCancelAll.Location = New System.Drawing.Point(365, 43)
        Me.btnCancelAll.Name = "btnCancelAll"
        Me.btnCancelAll.TabIndex = 2
        Me.btnCancelAll.Text = "Ca&ncel All"
        '
        'lblau_id
        '
        Me.lblau_id.FlatStyle = System.Windows.Forms.FlatStyle.System
        Me.lblau_id.Location = New System.Drawing.Point(10, 76)
        Me.lblau_id.Name = "lblau_id"
        Me.lblau_id.TabIndex = 3
        Me.lblau_id.Text = "au_id"
        '
        'lblau_lname
        '
        Me.lblau_lname.FlatStyle = System.Windows.Forms.FlatStyle.System
        Me.lblau_lname.Location = New System.Drawing.Point(10, 109)
        Me.lblau_lname.Name = "lblau_lname"
        Me.lblau_lname.TabIndex = 4
        Me.lblau_lname.Text = "au_lname"
        '
        'lblau_fname
        '
        Me.lblau_fname.FlatStyle = System.Windows.Forms.FlatStyle.System
        Me.lblau_fname.Location = New System.Drawing.Point(10, 142)
        Me.lblau_fname.Name = "lblau_fname"
        Me.lblau_fname.TabIndex = 5
        Me.lblau_fname.Text = "au_fname"
        '
        'lblphone
        '
        Me.lblphone.FlatStyle = System.Windows.Forms.FlatStyle.System
        Me.lblphone.Location = New System.Drawing.Point(10, 175)
        Me.lblphone.Name = "lblphone"
        Me.lblphone.TabIndex = 6
        Me.lblphone.Text = "phone"
        '
        'lbladdress
        '
        Me.lbladdress.FlatStyle = System.Windows.Forms.FlatStyle.System
        Me.lbladdress.Location = New System.Drawing.Point(10, 208)
        Me.lbladdress.Name = "lbladdress"
        Me.lbladdress.TabIndex = 7
        Me.lbladdress.Text = "address"
        '
        'editau_id
        '
        Me.editau_id.DataBindings.Add(New System.Windows.Forms.Binding("Text", Me.objdsDataset, "authors.au_id"))
        Me.editau_id.Location = New System.Drawing.Point(120, 76)
        Me.editau_id.Name = "editau_id"
        Me.editau_id.TabIndex = 8
        Me.editau_id.Text = ""
        '
        'editau_lname
        '
        Me.editau_lname.DataBindings.Add(New System.Windows.Forms.Binding("Text", Me.objdsDataset, "authors.au_lname"))
        Me.editau_lname.Location = New System.Drawing.Point(120, 109)
        Me.editau_lname.Name = "editau_lname"
        Me.editau_lname.TabIndex = 9
        Me.editau_lname.Text = ""
        '
        'editau_fname
        '
        Me.editau_fname.DataBindings.Add(New System.Windows.Forms.Binding("Text", Me.objdsDataset, "authors.au_fname"))
        Me.editau_fname.Location = New System.Drawing.Point(120, 142)
        Me.editau_fname.Name = "editau_fname"
        Me.editau_fname.TabIndex = 10
        Me.editau_fname.Text = ""
        '
        'editphone
        '
        Me.editphone.DataBindings.Add(New System.Windows.Forms.Binding("Text", Me.objdsDataset, "authors.phone"))
        Me.editphone.Location = New System.Drawing.Point(120, 175)
        Me.editphone.Name = "editphone"
        Me.editphone.TabIndex = 11
        Me.editphone.Text = ""
        '
        'editaddress
        '
        Me.editaddress.DataBindings.Add(New System.Windows.Forms.Binding("Text", Me.objdsDataset, "authors.address"))
        Me.editaddress.Location = New System.Drawing.Point(120, 208)
        Me.editaddress.Name = "editaddress"
        Me.editaddress.TabIndex = 12
        Me.editaddress.Text = ""
        '
        'lblcity
        '
        Me.lblcity.FlatStyle = System.Windows.Forms.FlatStyle.System
        Me.lblcity.Location = New System.Drawing.Point(230, 76)
        Me.lblcity.Name = "lblcity"
        Me.lblcity.TabIndex = 13
        Me.lblcity.Text = "city"
        '
        'lblstate
        '
        Me.lblstate.FlatStyle = System.Windows.Forms.FlatStyle.System
        Me.lblstate.Location = New System.Drawing.Point(230, 109)
        Me.lblstate.Name = "lblstate"
        Me.lblstate.TabIndex = 14
        Me.lblstate.Text = "state"
        '
        'lblzip
        '
        Me.lblzip.FlatStyle = System.Windows.Forms.FlatStyle.System
        Me.lblzip.Location = New System.Drawing.Point(230, 142)
        Me.lblzip.Name = "lblzip"
        Me.lblzip.TabIndex = 15
        Me.lblzip.Text = "zip"
        '
        'lblcontract
        '
        Me.lblcontract.FlatStyle = System.Windows.Forms.FlatStyle.System
        Me.lblcontract.Location = New System.Drawing.Point(230, 175)
        Me.lblcontract.Name = "lblcontract"
        Me.lblcontract.TabIndex = 16
        Me.lblcontract.Text = "contract"
        '
        'editcity
        '
        Me.editcity.DataBindings.Add(New System.Windows.Forms.Binding("Text", Me.objdsDataset, "authors.city"))
        Me.editcity.Location = New System.Drawing.Point(340, 76)
        Me.editcity.Name = "editcity"
        Me.editcity.TabIndex = 17
        Me.editcity.Text = ""
        '
        'editstate
        '
        Me.editstate.DataBindings.Add(New System.Windows.Forms.Binding("Text", Me.objdsDataset, "authors.state"))
        Me.editstate.Location = New System.Drawing.Point(340, 109)
        Me.editstate.Name = "editstate"
        Me.editstate.TabIndex = 18
        Me.editstate.Text = ""
        '
        'editzip
        '
        Me.editzip.DataBindings.Add(New System.Windows.Forms.Binding("Text", Me.objdsDataset, "authors.zip"))
        Me.editzip.Location = New System.Drawing.Point(340, 142)
        Me.editzip.Name = "editzip"
        Me.editzip.TabIndex = 19
        Me.editzip.Text = ""
        '
        'editcontract
        '
        Me.editcontract.DataBindings.Add(New System.Windows.Forms.Binding("Checked", Me.objdsDataset, "authors.contract"))
        Me.editcontract.FlatStyle = System.Windows.Forms.FlatStyle.System
        Me.editcontract.Location = New System.Drawing.Point(340, 175)
        Me.editcontract.Name = "editcontract"
        Me.editcontract.Size = New System.Drawing.Size(100, 24)
        Me.editcontract.TabIndex = 20
        '
        'btnNavFirst
        '
        Me.btnNavFirst.FlatStyle = System.Windows.Forms.FlatStyle.System
        Me.btnNavFirst.Location = New System.Drawing.Point(195, 241)
        Me.btnNavFirst.Name = "btnNavFirst"
        Me.btnNavFirst.Size = New System.Drawing.Size(40, 23)
        Me.btnNavFirst.TabIndex = 21
        Me.btnNavFirst.Text = "<<"
        '
        'btnNavPrev
        '
        Me.btnNavPrev.FlatStyle = System.Windows.Forms.FlatStyle.System
        Me.btnNavPrev.Location = New System.Drawing.Point(235, 241)
        Me.btnNavPrev.Name = "btnNavPrev"
        Me.btnNavPrev.Size = New System.Drawing.Size(35, 23)
        Me.btnNavPrev.TabIndex = 22
        Me.btnNavPrev.Text = "<"
        '
        'lblNavLocation
        '
        Me.lblNavLocation.BackColor = System.Drawing.Color.White
        Me.lblNavLocation.FlatStyle = System.Windows.Forms.FlatStyle.System
        Me.lblNavLocation.Location = New System.Drawing.Point(270, 241)
        Me.lblNavLocation.Name = "lblNavLocation"
        Me.lblNavLocation.Size = New System.Drawing.Size(95, 23)
        Me.lblNavLocation.TabIndex = 23
        Me.lblNavLocation.Text = "No Records"
        Me.lblNavLocation.TextAlign = System.Drawing.ContentAlignment.MiddleCenter
        '
        'btnNavNext
        '
        Me.btnNavNext.FlatStyle = System.Windows.Forms.FlatStyle.System
        Me.btnNavNext.Location = New System.Drawing.Point(365, 241)
        Me.btnNavNext.Name = "btnNavNext"
        Me.btnNavNext.Size = New System.Drawing.Size(35, 23)
        Me.btnNavNext.TabIndex = 24
        Me.btnNavNext.Text = ">"
        '
        'btnLast
        '
        Me.btnLast.FlatStyle = System.Windows.Forms.FlatStyle.System
        Me.btnLast.Location = New System.Drawing.Point(400, 241)
        Me.btnLast.Name = "btnLast"
        Me.btnLast.Size = New System.Drawing.Size(40, 23)
        Me.btnLast.TabIndex = 25
        Me.btnLast.Text = ">>"
        '
        'btnAdd
        '
        Me.btnAdd.FlatStyle = System.Windows.Forms.FlatStyle.System
        Me.btnAdd.Location = New System.Drawing.Point(195, 274)
        Me.btnAdd.Name = "btnAdd"
        Me.btnAdd.TabIndex = 26
        Me.btnAdd.Text = "&Add"
        '
        'btnDelete
        '
        Me.btnDelete.FlatStyle = System.Windows.Forms.FlatStyle.System
        Me.btnDelete.Location = New System.Drawing.Point(280, 274)
        Me.btnDelete.Name = "btnDelete"
        Me.btnDelete.TabIndex = 27
        Me.btnDelete.Text = "&Delete"
        '
        'btnCancel
        '
        Me.btnCancel.FlatStyle = System.Windows.Forms.FlatStyle.System
        Me.btnCancel.Location = New System.Drawing.Point(365, 274)
        Me.btnCancel.Name = "btnCancel"
        Me.btnCancel.TabIndex = 28
        Me.btnCancel.Text = "&Cancel"
        '
        'DataForm1
        '
        Me.AutoScaleBaseSize = New System.Drawing.Size(5, 13)
        Me.ClientSize = New System.Drawing.Size(442, 311)
        Me.Controls.Add(Me.btnLoad)
        Me.Controls.Add(Me.btnUpdate)
        Me.Controls.Add(Me.btnCancelAll)
        Me.Controls.Add(Me.lblau_id)
        Me.Controls.Add(Me.lblau_lname)
        Me.Controls.Add(Me.lblau_fname)
        Me.Controls.Add(Me.lblphone)
        Me.Controls.Add(Me.lbladdress)
        Me.Controls.Add(Me.editau_id)
        Me.Controls.Add(Me.editau_lname)
        Me.Controls.Add(Me.editau_fname)
        Me.Controls.Add(Me.editphone)
        Me.Controls.Add(Me.editaddress)
        Me.Controls.Add(Me.lblcity)
        Me.Controls.Add(Me.lblstate)
        Me.Controls.Add(Me.lblzip)
        Me.Controls.Add(Me.lblcontract)
        Me.Controls.Add(Me.editcity)
        Me.Controls.Add(Me.editstate)
        Me.Controls.Add(Me.editzip)
        Me.Controls.Add(Me.editcontract)
        Me.Controls.Add(Me.btnNavFirst)
        Me.Controls.Add(Me.btnNavPrev)
        Me.Controls.Add(Me.lblNavLocation)
        Me.Controls.Add(Me.btnNavNext)
        Me.Controls.Add(Me.btnLast)
        Me.Controls.Add(Me.btnAdd)
        Me.Controls.Add(Me.btnDelete)
        Me.Controls.Add(Me.btnCancel)
        Me.Name = "DataForm1"
        Me.Text = "DataForm1"
        CType(Me.objdsDataset, System.ComponentModel.ISupportInitialize).EndInit()
        Me.ResumeLayout(False)

    End Sub

#End Region

    Private Sub btnCancel_Click(ByVal sender As System.Object, ByVal e As System.EventArgs) Handles btnCancel.Click
        Me.BindingContext(objdsDataset, "authors").CancelCurrentEdit()
        Me.objdsDataset_PositionChanged()

    End Sub
    Private Sub btnDelete_Click(ByVal sender As System.Object, ByVal e As System.EventArgs) Handles btnDelete.Click
        If (Me.BindingContext(objdsDataset, "authors").Count > 0) Then
            Me.BindingContext(objdsDataset, "authors").RemoveAt(Me.BindingContext(objdsDataset, "authors").Position)
            Me.objdsDataset_PositionChanged()
        End If

    End Sub
    Private Sub btnAdd_Click(ByVal sender As System.Object, ByVal e As System.EventArgs) Handles btnAdd.Click
        Try
            'Clear out the current edits
            Me.BindingContext(objdsDataset, "authors").EndCurrentEdit()
            Me.BindingContext(objdsDataset, "authors").AddNew()
        Catch eEndEdit As System.Exception
            System.Windows.Forms.MessageBox.Show(eEndEdit.Message)
        End Try
        Me.objdsDataset_PositionChanged()

    End Sub
    Private Sub btnUpdate_Click(ByVal sender As System.Object, ByVal e As System.EventArgs) Handles btnUpdate.Click
        Try
            'Attempt to update the datasource.
            Me.UpdateDataSet()
        Catch eUpdate As System.Exception
            'Add your error handling code here.
            'Display error message, if any.
            System.Windows.Forms.MessageBox.Show(eUpdate.Message)
        End Try
        Me.objdsDataset_PositionChanged()

    End Sub
    Private Sub btnLoad_Click(ByVal sender As System.Object, ByVal e As System.EventArgs) Handles btnLoad.Click
        Try
            'Attempt to load the dataset.
            Me.LoadDataSet()
        Catch eLoad As System.Exception
            'Add your error handling code here.
            'Display error message, if any.
            System.Windows.Forms.MessageBox.Show(eLoad.Message)
        End Try
        Me.objdsDataset_PositionChanged()

    End Sub
    Private Sub btnNavFirst_Click(ByVal sender As System.Object, ByVal e As System.EventArgs) Handles btnNavFirst.Click
        Me.BindingContext(objdsDataset, "authors").Position = 0
        Me.objdsDataset_PositionChanged()

    End Sub
    Private Sub btnLast_Click(ByVal sender As System.Object, ByVal e As System.EventArgs) Handles btnLast.Click
        Me.BindingContext(objdsDataset, "authors").Position = (Me.objdsDataset.Tables("authors").Rows.Count - 1)
        Me.objdsDataset_PositionChanged()

    End Sub
    Private Sub btnNavPrev_Click(ByVal sender As System.Object, ByVal e As System.EventArgs) Handles btnNavPrev.Click
        Me.BindingContext(objdsDataset, "authors").Position = (Me.BindingContext(objdsDataset, "authors").Position - 1)
        Me.objdsDataset_PositionChanged()

    End Sub
    Private Sub btnNavNext_Click(ByVal sender As System.Object, ByVal e As System.EventArgs) Handles btnNavNext.Click
        Me.BindingContext(objdsDataset, "authors").Position = (Me.BindingContext(objdsDataset, "authors").Position + 1)
        Me.objdsDataset_PositionChanged()

    End Sub
    Private Sub objdsDataset_PositionChanged()
        Me.lblNavLocation.Text = (((Me.BindingContext(objdsDataset, "authors").Position + 1).ToString + " of  ") _
                    + Me.BindingContext(objdsDataset, "authors").Count.ToString)

    End Sub
    Private Sub btnCancelAll_Click(ByVal sender As System.Object, ByVal e As System.EventArgs) Handles btnCancelAll.Click
        Me.objdsDataset.RejectChanges()

    End Sub
    Public Sub UpdateDataSet()
        'Create a new dataset to hold the changes that have been made to the main dataset.
        Dim objDataSetChanges As DataForm.dsDataset = New DataForm.dsDataset
        'Stop any current edits.
        Me.BindingContext(objdsDataset, "authors").EndCurrentEdit()
        'Get the changes that have been made to the main dataset.
        objDataSetChanges = CType(objdsDataset.GetChanges, DataForm.dsDataset)
        'Check to see if any changes have been made.
        If (Not (objDataSetChanges) Is Nothing) Then
            Try
                'There are changes that need to be made, so attempt to update the datasource by
                'calling the update method and passing the dataset and any parameters.
                Me.UpdateDataSource(objDataSetChanges)
                objdsDataset.Merge(objDataSetChanges)
                objdsDataset.AcceptChanges()
            Catch eUpdate As System.Exception
                'Add your error handling code here.
                Throw eUpdate
            End Try
            'Add your code to check the returned dataset for any errors that may have been
            'pushed into the row object's error.
        End If

    End Sub
    Public Sub LoadDataSet()
        'Create a new dataset to hold the records returned from the call to FillDataSet.
        'A temporary dataset is used because filling the existing dataset would
        'require the databindings to be rebound.
        Dim objDataSetTemp As DataForm.dsDataset
        objDataSetTemp = New DataForm.dsDataset
        Try
            'Attempt to fill the temporary dataset.
            Me.FillDataSet(objDataSetTemp)
        Catch eFillDataSet As System.Exception
            'Add your error handling code here.
            Throw eFillDataSet
        End Try
        Try
            'Empty the old records from the dataset.
            objdsDataset.Clear()
            'Merge the records into the main dataset.
            objdsDataset.Merge(objDataSetTemp)
        Catch eLoadMerge As System.Exception
            'Add your error handling code here.
            Throw eLoadMerge
        End Try

    End Sub
    Public Sub UpdateDataSource(ByVal ChangedRows As DataForm.dsDataset)
        Try
            'The data source only needs to be updated if there are changes pending.
            If (Not (ChangedRows) Is Nothing) Then
                'Open the connection.
                Me.OleDbConnection1.Open()
                'Attempt to update the data source.
                OleDbDataAdapter1.Update(ChangedRows)
            End If
        Catch updateException As System.Exception
            'Add your error handling code here.
            Throw updateException
        Finally
            'Close the connection whether or not the exception was thrown.
            Me.OleDbConnection1.Close()
        End Try

    End Sub
    Public Sub FillDataSet(ByVal dataSet As DataForm.dsDataset)
        'Turn off constraint checking before the dataset is filled.
        'This allows the adapters to fill the dataset without concern
        'for dependencies between the tables.
        dataSet.EnforceConstraints = False
        Try
            'Open the connection.
            Me.OleDbConnection1.Open()
            'Attempt to fill the dataset through the OleDbDataAdapter1.
            Me.OleDbDataAdapter1.Fill(dataSet)
        Catch fillException As System.Exception
            'Add your error handling code here.
            Throw fillException
        Finally
            'Turn constraint checking back on.
            dataSet.EnforceConstraints = True
            'Close the connection whether or not the exception was thrown.
            Me.OleDbConnection1.Close()
        End Try

    End Sub

    
    
End Class
