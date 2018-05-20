Imports System.Runtime.Remoting
Imports System.Reflection
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
    Friend WithEvents Button1 As System.Windows.Forms.Button
    Friend WithEvents Button2 As System.Windows.Forms.Button
    Friend WithEvents Button3 As System.Windows.Forms.Button
    <System.Diagnostics.DebuggerStepThrough()> Private Sub InitializeComponent()
        Me.Button1 = New System.Windows.Forms.Button
        Me.Button2 = New System.Windows.Forms.Button
        Me.Button3 = New System.Windows.Forms.Button
        Me.SuspendLayout()
        '
        'Button1
        '
        Me.Button1.Location = New System.Drawing.Point(24, 80)
        Me.Button1.Name = "Button1"
        Me.Button1.Size = New System.Drawing.Size(280, 24)
        Me.Button1.TabIndex = 0
        Me.Button1.Text = "Execute AppTwo"
        '
        'Button2
        '
        Me.Button2.Location = New System.Drawing.Point(24, 120)
        Me.Button2.Name = "Button2"
        Me.Button2.Size = New System.Drawing.Size(280, 24)
        Me.Button2.TabIndex = 1
        Me.Button2.Text = "Access object created in the Default AppDomain"
        '
        'Button3
        '
        Me.Button3.Location = New System.Drawing.Point(24, 160)
        Me.Button3.Name = "Button3"
        Me.Button3.Size = New System.Drawing.Size(280, 23)
        Me.Button3.TabIndex = 2
        Me.Button3.Text = "Access object created in the Secondary AppDomain"
        '
        'Form1
        '
        Me.AutoScaleBaseSize = New System.Drawing.Size(5, 13)
        Me.ClientSize = New System.Drawing.Size(320, 266)
        Me.Controls.Add(Me.Button3)
        Me.Controls.Add(Me.Button2)
        Me.Controls.Add(Me.Button1)
        Me.Name = "Form1"
        Me.Text = "Form1"
        Me.ResumeLayout(False)

    End Sub

#End Region

    Private Sub Button1_Click(ByVal sender As System.Object, ByVal e As System.EventArgs) Handles Button1.Click
        Dim SecondAppDomaing As AppDomain = AppDomain.CreateDomain("Second AppDomain")
        SecondAppDomaing.ExecuteAssembly("AppTwo.exe")
    End Sub

    Private Sub Button3_Click(ByVal sender As System.Object, ByVal e As System.EventArgs) Handles Button3.Click
        Dim SecondAppDomaing As AppDomain = AppDomain.CreateDomain("Second AppDomain")
        Dim ObjH As ObjectHandle = SecondAppDomaing.CreateInstance("AppTwo", "AppTwo.AClassInAppTwo", True, _
            BindingFlags.CreateInstance, _
            Nothing, New Object() {" - " & AppDomain.CurrentDomain.FriendlyName & " says Hi! - "}, Nothing, Nothing, Nothing)

        Dim Obj As Object = ObjH.Unwrap()
        Obj.ASimpleMethod()

    End Sub

    Private Sub Button2_Click(ByVal sender As System.Object, ByVal e As System.EventArgs) Handles Button2.Click
        Dim LocObj As New AClassInAppOne(" - " & AppDomain.CurrentDomain.FriendlyName & " says Hi! - ")
        LocObj.ASimpleMethod()
    End Sub
End Class
