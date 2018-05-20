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
    Friend WithEvents Panel1 As System.Windows.Forms.Panel
    Friend WithEvents TextBox1 As System.Windows.Forms.TextBox
    Friend WithEvents Button1 As System.Windows.Forms.Button
    <System.Diagnostics.DebuggerStepThrough()> Private Sub InitializeComponent()
        Me.Panel1 = New System.Windows.Forms.Panel
        Me.TextBox1 = New System.Windows.Forms.TextBox
        Me.Button1 = New System.Windows.Forms.Button
        Me.Panel1.SuspendLayout()
        Me.SuspendLayout()
        '
        'Panel1
        '
        Me.Panel1.Controls.Add(Me.TextBox1)
        Me.Panel1.Location = New System.Drawing.Point(8, 48)
        Me.Panel1.Name = "Panel1"
        Me.Panel1.Size = New System.Drawing.Size(416, 208)
        Me.Panel1.TabIndex = 0
        '
        'TextBox1
        '
        Me.TextBox1.Dock = System.Windows.Forms.DockStyle.Fill
        Me.TextBox1.Location = New System.Drawing.Point(0, 0)
        Me.TextBox1.Multiline = True
        Me.TextBox1.Name = "TextBox1"
        Me.TextBox1.Size = New System.Drawing.Size(416, 208)
        Me.TextBox1.TabIndex = 0
        Me.TextBox1.Text = ""
        '
        'Button1
        '
        Me.Button1.FlatStyle = System.Windows.Forms.FlatStyle.System
        Me.Button1.Location = New System.Drawing.Point(120, 16)
        Me.Button1.Name = "Button1"
        Me.Button1.Size = New System.Drawing.Size(160, 23)
        Me.Button1.TabIndex = 1
        Me.Button1.Text = "Read Data With Data Reader"
        '
        'Form1
        '
        Me.AutoScaleBaseSize = New System.Drawing.Size(5, 13)
        Me.ClientSize = New System.Drawing.Size(432, 266)
        Me.Controls.Add(Me.Button1)
        Me.Controls.Add(Me.Panel1)
        Me.Name = "Form1"
        Me.Text = "Data Reader Example"
        Me.Panel1.ResumeLayout(False)
        Me.ResumeLayout(False)

    End Sub

#End Region

    Private Sub Form1_Load(ByVal sender As System.Object, ByVal e As System.EventArgs) Handles MyBase.Load

    End Sub

    Private Sub Button1_Click(ByVal sender As System.Object, ByVal e As System.EventArgs) Handles Button1.Click
        Dim LoopIndex As Integer

        Dim Connection1String As New String("Integrated Security=SSPI;User ID=sa;Data Source=""CHARUL\NetSDK"";Tag with column c" & _
        "ollation when possible=False;Initial Catalog=pubs;Use Procedure for Prepare=1;Au" & _
        "to Translate=True;Persist Security Info=False;Provider=""SQLOLEDB.1"";Workstation " & _
        "ID=CHARUL;Use Encryption for Data=False;Packet Size=4096")

        Dim Connection1 As New OleDb.OleDbConnection(Connection1String)
        Dim Command1 As New OleDb.OleDbCommand("SELECT au_id, au_lname, au_fname,city FROM authors", Connection1)
        Connection1.Open()
        Dim Reader1 As OleDb.OleDbDataReader = _
        Command1.ExecuteReader(CommandBehavior.CloseConnection)



        Dim schemaTable As DataTable = Reader1.GetSchemaTable()
        For LoopIndex = 0 To schemaTable.Rows.Count - 1
            TextBox1.Text &= schemaTable.Rows(LoopIndex).Item(0).ToString() & _
            ControlChars.Tab & ControlChars.Tab
            If LoopIndex = 0 Then 'Handle wide au_id field 
                TextBox1.Text &= ControlChars.Tab
            End If
        Next
        TextBox1.Text &= ControlChars.CrLf
        For LoopIndex = 0 To (schemaTable.Rows.Count - 1)
            TextBox1.Text &= "———————" & ControlChars.Tab & _
            ControlChars.Tab
            If LoopIndex = 0 Then 'Handle wide au_id field 
                TextBox1.Text &= ControlChars.Tab
            End If
        Next LoopIndex
        TextBox1.Text &= ControlChars.CrLf


        While Reader1.Read()
            For LoopIndex = 0 To schemaTable.Rows.Count - 1
                If schemaTable.Rows(LoopIndex).Item(5).ToString() = _
                "System.String" Then
                    TextBox1.Text &= Reader1.GetString(LoopIndex) & _
                    ControlChars.Tab & ControlChars.Tab
                End If


                If schemaTable.Rows(LoopIndex).Item(5).ToString() = _
                "System.Boolean" Then

                    TextBox1.Text &= Reader1.GetBoolean(LoopIndex).ToString() _
& ControlChars.Tab & ControlChars.Tab
End If 
            Next LoopIndex
            TextBox1.Text &= ControlChars.CrLf
        End While
        Reader1.Close()
        Connection1.Close()



    End Sub
End Class
