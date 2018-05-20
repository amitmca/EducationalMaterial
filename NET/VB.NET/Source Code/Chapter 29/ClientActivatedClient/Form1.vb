Imports System.Runtime.Remoting
Imports System.Runtime.Remoting.Channels
Imports System.Runtime.Remoting.Channels.Tcp
Imports System.Runtime.Remoting.Activation
Imports SharedObject
Imports System.Runtime.Serialization
Imports System.Runtime.Remoting.Channels.Http
Imports System.Runtime.Serialization.Formatters

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
    Friend WithEvents Timer1 As System.Windows.Forms.Timer
    Friend WithEvents Button2 As System.Windows.Forms.Button
    Friend WithEvents Button3 As System.Windows.Forms.Button
    Friend WithEvents Button4 As System.Windows.Forms.Button
    Friend WithEvents txtStatusBar As System.Windows.Forms.TextBox
    Friend WithEvents Label1 As System.Windows.Forms.Label
    Friend WithEvents TextBox1 As System.Windows.Forms.TextBox
    Friend WithEvents Button5 As System.Windows.Forms.Button
    Friend WithEvents GroupBox2 As System.Windows.Forms.GroupBox
    Friend WithEvents rbtnHttpChannel As System.Windows.Forms.RadioButton
    Friend WithEvents rbtnTcpChannel As System.Windows.Forms.RadioButton
    Friend WithEvents GroupBox1 As System.Windows.Forms.GroupBox
    Friend WithEvents rbtnSoap As System.Windows.Forms.RadioButton
    Friend WithEvents rbtnBinary As System.Windows.Forms.RadioButton
    Friend WithEvents cbtnFullTrust As System.Windows.Forms.CheckBox
    Friend WithEvents GroupBox5 As System.Windows.Forms.GroupBox
    Friend WithEvents TextBox2 As System.Windows.Forms.TextBox
    <System.Diagnostics.DebuggerStepThrough()> Private Sub InitializeComponent()
        Me.components = New System.ComponentModel.Container
        Me.Button1 = New System.Windows.Forms.Button
        Me.Timer1 = New System.Windows.Forms.Timer(Me.components)
        Me.Button2 = New System.Windows.Forms.Button
        Me.Button3 = New System.Windows.Forms.Button
        Me.Button4 = New System.Windows.Forms.Button
        Me.txtStatusBar = New System.Windows.Forms.TextBox
        Me.Label1 = New System.Windows.Forms.Label
        Me.TextBox1 = New System.Windows.Forms.TextBox
        Me.Button5 = New System.Windows.Forms.Button
        Me.GroupBox2 = New System.Windows.Forms.GroupBox
        Me.rbtnHttpChannel = New System.Windows.Forms.RadioButton
        Me.rbtnTcpChannel = New System.Windows.Forms.RadioButton
        Me.GroupBox1 = New System.Windows.Forms.GroupBox
        Me.rbtnSoap = New System.Windows.Forms.RadioButton
        Me.rbtnBinary = New System.Windows.Forms.RadioButton
        Me.cbtnFullTrust = New System.Windows.Forms.CheckBox
        Me.GroupBox5 = New System.Windows.Forms.GroupBox
        Me.TextBox2 = New System.Windows.Forms.TextBox
        Me.GroupBox2.SuspendLayout()
        Me.GroupBox1.SuspendLayout()
        Me.GroupBox5.SuspendLayout()
        Me.SuspendLayout()
        '
        'Button1
        '
        Me.Button1.Location = New System.Drawing.Point(16, 64)
        Me.Button1.Name = "Button1"
        Me.Button1.Size = New System.Drawing.Size(112, 32)
        Me.Button1.TabIndex = 1
        Me.Button1.Text = "Connect"
        '
        'Timer1
        '
        Me.Timer1.Interval = 1000
        '
        'Button2
        '
        Me.Button2.Location = New System.Drawing.Point(144, 64)
        Me.Button2.Name = "Button2"
        Me.Button2.Size = New System.Drawing.Size(112, 32)
        Me.Button2.TabIndex = 4
        Me.Button2.Text = "Greeting"
        '
        'Button3
        '
        Me.Button3.Location = New System.Drawing.Point(144, 112)
        Me.Button3.Name = "Button3"
        Me.Button3.Size = New System.Drawing.Size(112, 32)
        Me.Button3.TabIndex = 5
        Me.Button3.Text = "Get Count"
        '
        'Button4
        '
        Me.Button4.Location = New System.Drawing.Point(16, 112)
        Me.Button4.Name = "Button4"
        Me.Button4.Size = New System.Drawing.Size(112, 32)
        Me.Button4.TabIndex = 6
        Me.Button4.Text = "Disconnect"
        '
        'txtStatusBar
        '
        Me.txtStatusBar.BorderStyle = System.Windows.Forms.BorderStyle.None
        Me.txtStatusBar.Enabled = False
        Me.txtStatusBar.Font = New System.Drawing.Font("Microsoft Sans Serif", 8.25!, System.Drawing.FontStyle.Bold, System.Drawing.GraphicsUnit.Point, CType(0, Byte))
        Me.txtStatusBar.Location = New System.Drawing.Point(8, 368)
        Me.txtStatusBar.Multiline = True
        Me.txtStatusBar.Name = "txtStatusBar"
        Me.txtStatusBar.ReadOnly = True
        Me.txtStatusBar.Size = New System.Drawing.Size(256, 40)
        Me.txtStatusBar.TabIndex = 20
        Me.txtStatusBar.Text = ""
        Me.txtStatusBar.TextAlign = System.Windows.Forms.HorizontalAlignment.Center
        '
        'Label1
        '
        Me.Label1.Location = New System.Drawing.Point(24, 24)
        Me.Label1.Name = "Label1"
        Me.Label1.Size = New System.Drawing.Size(96, 16)
        Me.Label1.TabIndex = 25
        Me.Label1.Text = "My Code Name :"
        '
        'TextBox1
        '
        Me.TextBox1.Location = New System.Drawing.Point(120, 24)
        Me.TextBox1.Name = "TextBox1"
        Me.TextBox1.Size = New System.Drawing.Size(120, 20)
        Me.TextBox1.TabIndex = 24
        Me.TextBox1.Text = ""
        '
        'Button5
        '
        Me.Button5.Location = New System.Drawing.Point(16, 160)
        Me.Button5.Name = "Button5"
        Me.Button5.Size = New System.Drawing.Size(112, 32)
        Me.Button5.TabIndex = 26
        Me.Button5.Text = "Climb the Cliff"
        '
        'GroupBox2
        '
        Me.GroupBox2.Controls.Add(Me.rbtnHttpChannel)
        Me.GroupBox2.Controls.Add(Me.rbtnTcpChannel)
        Me.GroupBox2.Location = New System.Drawing.Point(32, 224)
        Me.GroupBox2.Name = "GroupBox2"
        Me.GroupBox2.Size = New System.Drawing.Size(208, 48)
        Me.GroupBox2.TabIndex = 29
        Me.GroupBox2.TabStop = False
        Me.GroupBox2.Text = "Channel"
        '
        'rbtnHttpChannel
        '
        Me.rbtnHttpChannel.Location = New System.Drawing.Point(112, 16)
        Me.rbtnHttpChannel.Name = "rbtnHttpChannel"
        Me.rbtnHttpChannel.Size = New System.Drawing.Size(88, 24)
        Me.rbtnHttpChannel.TabIndex = 9
        Me.rbtnHttpChannel.Text = "HttpChannel"
        '
        'rbtnTcpChannel
        '
        Me.rbtnTcpChannel.Checked = True
        Me.rbtnTcpChannel.Location = New System.Drawing.Point(16, 16)
        Me.rbtnTcpChannel.Name = "rbtnTcpChannel"
        Me.rbtnTcpChannel.Size = New System.Drawing.Size(88, 24)
        Me.rbtnTcpChannel.TabIndex = 8
        Me.rbtnTcpChannel.TabStop = True
        Me.rbtnTcpChannel.Text = "TcpChannel"
        '
        'GroupBox1
        '
        Me.GroupBox1.Controls.Add(Me.rbtnSoap)
        Me.GroupBox1.Controls.Add(Me.rbtnBinary)
        Me.GroupBox1.Location = New System.Drawing.Point(32, 280)
        Me.GroupBox1.Name = "GroupBox1"
        Me.GroupBox1.Size = New System.Drawing.Size(208, 48)
        Me.GroupBox1.TabIndex = 28
        Me.GroupBox1.TabStop = False
        Me.GroupBox1.Text = "Formatter Sink Provider"
        '
        'rbtnSoap
        '
        Me.rbtnSoap.Location = New System.Drawing.Point(120, 24)
        Me.rbtnSoap.Name = "rbtnSoap"
        Me.rbtnSoap.Size = New System.Drawing.Size(56, 16)
        Me.rbtnSoap.TabIndex = 11
        Me.rbtnSoap.Text = "Soap"
        '
        'rbtnBinary
        '
        Me.rbtnBinary.Checked = True
        Me.rbtnBinary.Location = New System.Drawing.Point(40, 24)
        Me.rbtnBinary.Name = "rbtnBinary"
        Me.rbtnBinary.Size = New System.Drawing.Size(64, 16)
        Me.rbtnBinary.TabIndex = 10
        Me.rbtnBinary.TabStop = True
        Me.rbtnBinary.Text = "Binary"
        '
        'cbtnFullTrust
        '
        Me.cbtnFullTrust.Location = New System.Drawing.Point(160, 336)
        Me.cbtnFullTrust.Name = "cbtnFullTrust"
        Me.cbtnFullTrust.Size = New System.Drawing.Size(72, 24)
        Me.cbtnFullTrust.TabIndex = 27
        Me.cbtnFullTrust.Text = "Full Trust"
        '
        'GroupBox5
        '
        Me.GroupBox5.Controls.Add(Me.TextBox2)
        Me.GroupBox5.Location = New System.Drawing.Point(152, 152)
        Me.GroupBox5.Name = "GroupBox5"
        Me.GroupBox5.Size = New System.Drawing.Size(80, 48)
        Me.GroupBox5.TabIndex = 30
        Me.GroupBox5.TabStop = False
        Me.GroupBox5.Text = "Port No"
        '
        'TextBox2
        '
        Me.TextBox2.Location = New System.Drawing.Point(8, 16)
        Me.TextBox2.Name = "TextBox2"
        Me.TextBox2.Size = New System.Drawing.Size(64, 20)
        Me.TextBox2.TabIndex = 18
        Me.TextBox2.Text = "8086"
        '
        'Form1
        '
        Me.AutoScaleBaseSize = New System.Drawing.Size(5, 13)
        Me.ClientSize = New System.Drawing.Size(272, 414)
        Me.Controls.Add(Me.GroupBox5)
        Me.Controls.Add(Me.GroupBox2)
        Me.Controls.Add(Me.GroupBox1)
        Me.Controls.Add(Me.cbtnFullTrust)
        Me.Controls.Add(Me.Button5)
        Me.Controls.Add(Me.Label1)
        Me.Controls.Add(Me.TextBox1)
        Me.Controls.Add(Me.txtStatusBar)
        Me.Controls.Add(Me.Button4)
        Me.Controls.Add(Me.Button3)
        Me.Controls.Add(Me.Button2)
        Me.Controls.Add(Me.Button1)
        Me.Name = "Form1"
        Me.Text = "Form1"
        Me.GroupBox2.ResumeLayout(False)
        Me.GroupBox1.ResumeLayout(False)
        Me.GroupBox5.ResumeLayout(False)
        Me.ResumeLayout(False)

    End Sub

#End Region

    Dim TimeSp As New TimeSpan(0)

    Dim bConnected As Boolean = False
    Dim chan As IChannel
    Dim SProvider As IServerChannelSinkProvider
    Dim CProvider As IClientChannelSinkProvider
    Dim props As IDictionary

    Dim Obj As SharedObject.SharedObject
    '    Dim attrs() = {New UrlAttribute("tcp://localhost:8086/HelloServer")}
    Public sink As EventSink


    Private Sub Button1_Click(ByVal sender As System.Object, ByVal e As System.EventArgs) Handles Button1.Click
        Try

            Dim URI As String

            Dim props As IDictionary
            props = New Hashtable
            props("port") = "0"

            If rbtnBinary.Checked Then
                SProvider = New BinaryServerFormatterSinkProvider
                CProvider = New BinaryClientFormatterSinkProvider
                If cbtnFullTrust.Checked Then
                    CType(SProvider, BinaryServerFormatterSinkProvider).TypeFilterLevel = TypeFilterLevel.Full
                End If

            ElseIf rbtnSoap.Checked Then
                SProvider = New SoapServerFormatterSinkProvider
                CProvider = New SoapClientFormatterSinkProvider
                If cbtnFullTrust.Checked Then
                    CType(SProvider, SoapServerFormatterSinkProvider).TypeFilterLevel = TypeFilterLevel.Full
                End If
            End If

            If rbtnTcpChannel.Checked Then
                If Not cbtnFullTrust.Checked Then
                    chan = New TcpChannel
                Else
                    chan = New TcpChannel(props, CProvider, SProvider)
                End If
                URI = "tcp://localhost:" & TextBox2.Text ' & "/HiServerApp"
            ElseIf rbtnHttpChannel.Checked Then
                If Not cbtnFullTrust.Checked Then
                    chan = New HttpChannel
                Else
                    chan = New HttpChannel(props, CProvider, SProvider)
                End If
                URI = "http://localhost:" & TextBox2.Text ' & "/HiServerApp"
            End If

            ChannelServices.RegisterChannel(chan)

            RemotingConfiguration.RegisterActivatedClientType(GetType(SharedObject.SharedObject), URI) ' "tcp://localhost:8086")
            Obj = New SharedObject.SharedObject


            If cbtnFullTrust.Checked Then
                Dim StMtd As New StatusEvent(AddressOf Me.StausMethod)
                sink = New EventSink(StMtd)
                AddHandler Obj.Status, New StatusEvent(AddressOf sink.OnStatus)
            End If

            txtStatusBar.Text = "Connected"
            bConnected = True

        Catch ex As Exception
            txtStatusBar.Text = ex.Message
        End Try
    End Sub

    Private Sub Timer1_Tick(ByVal sender As System.Object, ByVal e As System.EventArgs) Handles Timer1.Tick
        TimeSp.Add(TimeSpan.FromSeconds(1))
    End Sub

    Private Sub Button4_Click(ByVal sender As System.Object, ByVal e As System.EventArgs) Handles Button4.Click
        If Not chan Is Nothing Then
            ChannelServices.UnregisterChannel(chan)
            Obj = Nothing
            bConnected = False
            txtStatusBar.Text = "Disconnected"
        End If

    End Sub

    Private Sub Button3_Click(ByVal sender As System.Object, ByVal e As System.EventArgs) Handles Button3.Click
        If bConnected Then
            MsgBox(Obj.GetCount)
        End If
    End Sub

    Public Sub StausMethod(ByVal msg As String)
        Diagnostics.Debug.WriteLine(msg)
    End Sub

    Private Sub Button2_Click(ByVal sender As System.Object, ByVal e As System.EventArgs) Handles Button2.Click
        If bConnected Then
            Obj.Greeting(TextBox1.Text)
        End If
    End Sub

    Private Sub Button5_Click(ByVal sender As System.Object, ByVal e As System.EventArgs) Handles Button5.Click
        If bConnected Then
            Obj.ClimbTheCliff()
            Diagnostics.Debug.WriteLine("Call Complete")
        End If
    End Sub


    Private Sub rbtnHttpChannel_CheckedChanged(ByVal sender As System.Object, ByVal e As System.EventArgs) Handles rbtnHttpChannel.CheckedChanged
        If rbtnHttpChannel.Checked Then
            rbtnSoap.Checked = True
            GroupBox1.Enabled = False
        End If
    End Sub

    Private Sub rbtnTcpChannel_CheckedChanged(ByVal sender As System.Object, ByVal e As System.EventArgs) Handles rbtnTcpChannel.CheckedChanged
        GroupBox1.Enabled = True
    End Sub
End Class
