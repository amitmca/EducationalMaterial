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
    Friend WithEvents TreeView1 As System.Windows.Forms.TreeView
    Friend WithEvents Button1 As System.Windows.Forms.Button
    <System.Diagnostics.DebuggerStepThrough()> Private Sub InitializeComponent()
        Me.TreeView1 = New System.Windows.Forms.TreeView
        Me.Button1 = New System.Windows.Forms.Button
        Me.SuspendLayout()
        '
        'TreeView1
        '
        Me.TreeView1.ImageIndex = -1
        Me.TreeView1.Location = New System.Drawing.Point(16, 16)
        Me.TreeView1.Name = "TreeView1"
        Me.TreeView1.SelectedImageIndex = -1
        Me.TreeView1.Size = New System.Drawing.Size(256, 200)
        Me.TreeView1.TabIndex = 0
        '
        'Button1
        '
        Me.Button1.Location = New System.Drawing.Point(80, 232)
        Me.Button1.Name = "Button1"
        Me.Button1.Size = New System.Drawing.Size(120, 23)
        Me.Button1.TabIndex = 1
        Me.Button1.Text = "Create tree view"
        '
        'Form1
        '
        Me.AutoScaleBaseSize = New System.Drawing.Size(5, 13)
        Me.ClientSize = New System.Drawing.Size(292, 266)
        Me.Controls.Add(Me.Button1)
        Me.Controls.Add(Me.TreeView1)
        Me.Name = "Form1"
        Me.Text = "Form1"
        Me.ResumeLayout(False)

    End Sub

#End Region
    Private EmployeeArray As New ArrayList
    Private Sub Button1_Click(ByVal sender As System.Object, _
    ByVal e As System.EventArgs) Handles Button1.Click
        Dim intLoopIndex As Integer
        For intLoopIndex = 0 To 9
            EmployeeArray.Add(New Employee("Employee " & _
            intLoopIndex.ToString()))
        Next intLoopIndex
        Dim EmployeeObject As Employee
        For Each EmployeeObject In EmployeeArray
            For intLoopIndex = 0 To 3
                EmployeeObject.EmployeeAccounts.Add(New _
                Account("Account " & intLoopIndex.ToString()))
            Next intLoopIndex
        Next EmployeeObject
        TreeView1.BeginUpdate()
        TreeView1.Nodes.Clear()
        Dim RootNode = New TreeNode("Employees")
        TreeView1.Nodes.Add(RootNode)
        For Each EmployeeObject In EmployeeArray
            TreeView1.Nodes(0).Nodes.Add(New _
            TreeNode(EmployeeObject.EmployeeName))
            Dim AccountObject As Account
            For Each AccountObject In EmployeeObject.EmployeeAccounts
                TreeView1.Nodes(0).Nodes( _
                    EmployeeArray.IndexOf(EmployeeObject)).Nodes.Add( _
                New TreeNode(AccountObject.AccountID))
            Next AccountObject
        Next EmployeeObject
        TreeView1.EndUpdate()
    End Sub
End Class
Public Class Employee
    Private Index = 0
    Public EmployeeName As String
    Public EmployeeAccounts As New ArrayList
    Public Sub New(ByVal Name As String)
        EmployeeName = Name
    End Sub
End Class
Public Class Account
    Public AccountID As String
    Public Sub New(ByVal ID As String)
        AccountID = ID
    End Sub

End Class
