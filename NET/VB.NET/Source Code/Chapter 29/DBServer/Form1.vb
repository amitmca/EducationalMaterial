Imports System.Runtime.Remoting
Imports System.Runtime.Remoting.Channels
Imports System.Runtime.Remoting.Channels.Tcp
Imports System.Runtime.Remoting.Channels.Http
Imports System.Runtime.Serialization.Formatters
Imports SharedObject

Public Class Form1
    Inherits System.Windows.Forms.Form
    Dim chan As IChannel
    Dim SProvider As IServerChannelSinkProvider
    Dim CProvider As IClientChannelSinkProvider
    Dim Thd As Threading.Thread

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
    Friend WithEvents GroupBox1 As System.Windows.Forms.GroupBox
    Friend WithEvents GroupBox2 As System.Windows.Forms.GroupBox
    Friend WithEvents GroupBox3 As System.Windows.Forms.GroupBox
    Friend WithEvents btnStartServer As System.Windows.Forms.Button
    Friend WithEvents cbtnFullTrust As System.Windows.Forms.CheckBox
    Friend WithEvents rbtnCActivated As System.Windows.Forms.RadioButton
    Friend WithEvents rbtnWSingleTon As System.Windows.Forms.RadioButton
    Friend WithEvents rbtnWSingleCall As System.Windows.Forms.RadioButton
    Friend WithEvents rbtnHttpChannel As System.Windows.Forms.RadioButton
    Friend WithEvents rbtnTcpChannel As System.Windows.Forms.RadioButton
    Friend WithEvents rbtnSoap As System.Windows.Forms.RadioButton
    Friend WithEvents rbtnBinary As System.Windows.Forms.RadioButton
    Friend WithEvents GroupBox4 As System.Windows.Forms.GroupBox
    Friend WithEvents lbServces As System.Windows.Forms.ListBox
    Friend WithEvents TextBox1 As System.Windows.Forms.TextBox
    Friend WithEvents btnStopSelected As System.Windows.Forms.Button
    Friend WithEvents btnRefresh As System.Windows.Forms.Button
    Friend WithEvents GroupBox5 As System.Windows.Forms.GroupBox
    Friend WithEvents TextBox2 As System.Windows.Forms.TextBox
    Friend WithEvents txtStatusBar As System.Windows.Forms.TextBox
    Friend WithEvents Button1 As System.Windows.Forms.Button
    Friend WithEvents Button2 As System.Windows.Forms.Button
    <System.Diagnostics.DebuggerStepThrough()> Private Sub InitializeComponent()
        Me.btnStartServer = New System.Windows.Forms.Button
        Me.cbtnFullTrust = New System.Windows.Forms.CheckBox
        Me.GroupBox1 = New System.Windows.Forms.GroupBox
        Me.rbtnSoap = New System.Windows.Forms.RadioButton
        Me.rbtnBinary = New System.Windows.Forms.RadioButton
        Me.GroupBox2 = New System.Windows.Forms.GroupBox
        Me.rbtnHttpChannel = New System.Windows.Forms.RadioButton
        Me.rbtnTcpChannel = New System.Windows.Forms.RadioButton
        Me.GroupBox3 = New System.Windows.Forms.GroupBox
        Me.rbtnCActivated = New System.Windows.Forms.RadioButton
        Me.rbtnWSingleTon = New System.Windows.Forms.RadioButton
        Me.rbtnWSingleCall = New System.Windows.Forms.RadioButton
        Me.GroupBox4 = New System.Windows.Forms.GroupBox
        Me.btnRefresh = New System.Windows.Forms.Button
        Me.btnStopSelected = New System.Windows.Forms.Button
        Me.TextBox1 = New System.Windows.Forms.TextBox
        Me.lbServces = New System.Windows.Forms.ListBox
        Me.GroupBox5 = New System.Windows.Forms.GroupBox
        Me.TextBox2 = New System.Windows.Forms.TextBox
        Me.txtStatusBar = New System.Windows.Forms.TextBox
        Me.Button1 = New System.Windows.Forms.Button
        Me.Button2 = New System.Windows.Forms.Button
        Me.GroupBox1.SuspendLayout()
        Me.GroupBox2.SuspendLayout()
        Me.GroupBox3.SuspendLayout()
        Me.GroupBox4.SuspendLayout()
        Me.GroupBox5.SuspendLayout()
        Me.SuspendLayout()
        '
        'btnStartServer
        '
        Me.btnStartServer.Location = New System.Drawing.Point(24, 16)
        Me.btnStartServer.Name = "btnStartServer"
        Me.btnStartServer.Size = New System.Drawing.Size(112, 48)
        Me.btnStartServer.TabIndex = 0
        Me.btnStartServer.Text = "Start Server"
        '
        'cbtnFullTrust
        '
        Me.cbtnFullTrust.Location = New System.Drawing.Point(168, 288)
        Me.cbtnFullTrust.Name = "cbtnFullTrust"
        Me.cbtnFullTrust.Size = New System.Drawing.Size(72, 24)
        Me.cbtnFullTrust.TabIndex = 5
        Me.cbtnFullTrust.Text = "Full Trust"
        '
        'GroupBox1
        '
        Me.GroupBox1.Controls.Add(Me.rbtnSoap)
        Me.GroupBox1.Controls.Add(Me.rbtnBinary)
        Me.GroupBox1.Location = New System.Drawing.Point(24, 136)
        Me.GroupBox1.Name = "GroupBox1"
        Me.GroupBox1.Size = New System.Drawing.Size(208, 48)
        Me.GroupBox1.TabIndex = 10
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
        'GroupBox2
        '
        Me.GroupBox2.Controls.Add(Me.rbtnHttpChannel)
        Me.GroupBox2.Controls.Add(Me.rbtnTcpChannel)
        Me.GroupBox2.Location = New System.Drawing.Point(24, 80)
        Me.GroupBox2.Name = "GroupBox2"
        Me.GroupBox2.Size = New System.Drawing.Size(208, 48)
        Me.GroupBox2.TabIndex = 11
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
        'GroupBox3
        '
        Me.GroupBox3.Controls.Add(Me.rbtnCActivated)
        Me.GroupBox3.Controls.Add(Me.rbtnWSingleTon)
        Me.GroupBox3.Controls.Add(Me.rbtnWSingleCall)
        Me.GroupBox3.Location = New System.Drawing.Point(24, 192)
        Me.GroupBox3.Name = "GroupBox3"
        Me.GroupBox3.Size = New System.Drawing.Size(208, 96)
        Me.GroupBox3.TabIndex = 12
        Me.GroupBox3.TabStop = False
        Me.GroupBox3.Text = "Service Type"
        '
        'rbtnCActivated
        '
        Me.rbtnCActivated.Location = New System.Drawing.Point(32, 72)
        Me.rbtnCActivated.Name = "rbtnCActivated"
        Me.rbtnCActivated.Size = New System.Drawing.Size(104, 16)
        Me.rbtnCActivated.TabIndex = 7
        Me.rbtnCActivated.Text = "Client Activated"
        '
        'rbtnWSingleTon
        '
        Me.rbtnWSingleTon.Location = New System.Drawing.Point(32, 48)
        Me.rbtnWSingleTon.Name = "rbtnWSingleTon"
        Me.rbtnWSingleTon.Size = New System.Drawing.Size(136, 16)
        Me.rbtnWSingleTon.TabIndex = 6
        Me.rbtnWSingleTon.Text = "WellKnown, SingleTon"
        '
        'rbtnWSingleCall
        '
        Me.rbtnWSingleCall.Checked = True
        Me.rbtnWSingleCall.Location = New System.Drawing.Point(32, 24)
        Me.rbtnWSingleCall.Name = "rbtnWSingleCall"
        Me.rbtnWSingleCall.Size = New System.Drawing.Size(136, 16)
        Me.rbtnWSingleCall.TabIndex = 5
        Me.rbtnWSingleCall.TabStop = True
        Me.rbtnWSingleCall.Text = "WellKnown, SingleCall"
        '
        'GroupBox4
        '
        Me.GroupBox4.Controls.Add(Me.btnRefresh)
        Me.GroupBox4.Controls.Add(Me.btnStopSelected)
        Me.GroupBox4.Controls.Add(Me.TextBox1)
        Me.GroupBox4.Controls.Add(Me.lbServces)
        Me.GroupBox4.Location = New System.Drawing.Point(24, 312)
        Me.GroupBox4.Name = "GroupBox4"
        Me.GroupBox4.Size = New System.Drawing.Size(208, 200)
        Me.GroupBox4.TabIndex = 16
        Me.GroupBox4.TabStop = False
        Me.GroupBox4.Text = "Control Panel"
        '
        'btnRefresh
        '
        Me.btnRefresh.Location = New System.Drawing.Point(16, 160)
        Me.btnRefresh.Name = "btnRefresh"
        Me.btnRefresh.Size = New System.Drawing.Size(75, 24)
        Me.btnRefresh.TabIndex = 18
        Me.btnRefresh.Text = "Refresh"
        '
        'btnStopSelected
        '
        Me.btnStopSelected.Location = New System.Drawing.Point(104, 160)
        Me.btnStopSelected.Name = "btnStopSelected"
        Me.btnStopSelected.Size = New System.Drawing.Size(88, 24)
        Me.btnStopSelected.TabIndex = 17
        Me.btnStopSelected.Text = "StopSelected"
        '
        'TextBox1
        '
        Me.TextBox1.Location = New System.Drawing.Point(16, 88)
        Me.TextBox1.Multiline = True
        Me.TextBox1.Name = "TextBox1"
        Me.TextBox1.ReadOnly = True
        Me.TextBox1.Size = New System.Drawing.Size(176, 64)
        Me.TextBox1.TabIndex = 16
        Me.TextBox1.Text = ""
        '
        'lbServces
        '
        Me.lbServces.Location = New System.Drawing.Point(16, 24)
        Me.lbServces.Name = "lbServces"
        Me.lbServces.Size = New System.Drawing.Size(176, 56)
        Me.lbServces.TabIndex = 14
        '
        'GroupBox5
        '
        Me.GroupBox5.Controls.Add(Me.TextBox2)
        Me.GroupBox5.Location = New System.Drawing.Point(152, 16)
        Me.GroupBox5.Name = "GroupBox5"
        Me.GroupBox5.Size = New System.Drawing.Size(80, 48)
        Me.GroupBox5.TabIndex = 18
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
        'txtStatusBar
        '
        Me.txtStatusBar.BorderStyle = System.Windows.Forms.BorderStyle.None
        Me.txtStatusBar.Enabled = False
        Me.txtStatusBar.Font = New System.Drawing.Font("Microsoft Sans Serif", 8.25!, System.Drawing.FontStyle.Bold, System.Drawing.GraphicsUnit.Point, CType(0, Byte))
        Me.txtStatusBar.Location = New System.Drawing.Point(8, 520)
        Me.txtStatusBar.Multiline = True
        Me.txtStatusBar.Name = "txtStatusBar"
        Me.txtStatusBar.ReadOnly = True
        Me.txtStatusBar.Size = New System.Drawing.Size(240, 40)
        Me.txtStatusBar.TabIndex = 19
        Me.txtStatusBar.Text = ""
        Me.txtStatusBar.TextAlign = System.Windows.Forms.HorizontalAlignment.Center
        '
        'Button1
        '
        Me.Button1.Location = New System.Drawing.Point(288, 152)
        Me.Button1.Name = "Button1"
        Me.Button1.Size = New System.Drawing.Size(88, 32)
        Me.Button1.TabIndex = 20
        Me.Button1.Text = "Button1"
        '
        'Button2
        '
        Me.Button2.Location = New System.Drawing.Point(288, 248)
        Me.Button2.Name = "Button2"
        Me.Button2.Size = New System.Drawing.Size(72, 40)
        Me.Button2.TabIndex = 21
        Me.Button2.Text = "Button2"
        '
        'Form1
        '
        Me.AutoScaleBaseSize = New System.Drawing.Size(5, 13)
        Me.ClientSize = New System.Drawing.Size(258, 568)
        Me.Controls.Add(Me.Button2)
        Me.Controls.Add(Me.Button1)
        Me.Controls.Add(Me.txtStatusBar)
        Me.Controls.Add(Me.GroupBox5)
        Me.Controls.Add(Me.GroupBox4)
        Me.Controls.Add(Me.GroupBox3)
        Me.Controls.Add(Me.GroupBox2)
        Me.Controls.Add(Me.GroupBox1)
        Me.Controls.Add(Me.cbtnFullTrust)
        Me.Controls.Add(Me.btnStartServer)
        Me.FormBorderStyle = System.Windows.Forms.FormBorderStyle.FixedDialog
        Me.MaximizeBox = False
        Me.Name = "Form1"
        Me.Text = "Remoting Server"
        Me.GroupBox1.ResumeLayout(False)
        Me.GroupBox2.ResumeLayout(False)
        Me.GroupBox3.ResumeLayout(False)
        Me.GroupBox4.ResumeLayout(False)
        Me.GroupBox5.ResumeLayout(False)
        Me.ResumeLayout(False)

    End Sub

#End Region


    Private Sub Start()
        Try
            Dim props As IDictionary
            props = New Hashtable
            props("port") = TextBox2.Text


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
                chan = New TcpChannel(props, CProvider, SProvider)
            ElseIf rbtnHttpChannel.Checked Then
                chan = New HttpChannel(props, CProvider, SProvider)
            End If

            ChannelServices.RegisterChannel(chan)
            'ChannelServices.RegisterChannel(New HttpChannel(8086))

            ' RemotingConfiguration.ApplicationName = "HiServerApp"
            If rbtnWSingleCall.Checked Then

                RemotingConfiguration.RegisterWellKnownServiceType(GetType(SharedObject.SharedObject), "HiServerApp/HiServer", WellKnownObjectMode.SingleCall)
            ElseIf rbtnWSingleTon.Checked Then
                RemotingConfiguration.RegisterWellKnownServiceType(GetType(SharedObject.SharedObject), "HiServerApp/HiServer", WellKnownObjectMode.Singleton)
            ElseIf rbtnCActivated.Checked Then
                RemotingConfiguration.RegisterActivatedServiceType(GetType(SharedObject.SharedObject))
            End If
            Thd = Threading.Thread.CurrentThread()
            txtStatusBar.Text = "Connected"

        Catch ex As Exception
            txtStatusBar.Text = ex.Message
        End Try

    End Sub
    Private Sub btnStartServer_Click(ByVal sender As System.Object, ByVal e As System.EventArgs) Handles btnStartServer.Click
        'Thd = New Threading.Thread(AddressOf Start)
        'Thd.Start()
        Start()
    End Sub
    Private Sub Form1_Load(ByVal sender As System.Object, ByVal e As System.EventArgs) Handles MyBase.Load
        ListServices()
    End Sub

    Private Sub ListServices()
        lbServces.Items.Clear()
        For Each chan As IChannelReceiver In ChannelServices.RegisteredChannels
            lbServces.Items.Add(chan.ChannelName())
        Next
        UpdateDesc()
    End Sub

    Private Sub UpdateDesc()
        TextBox1.Text = ""
        If lbServces.Items.Count > 0 Then
            If lbServces.SelectedItems.Count > 0 Then
                Dim chan As IChannelReceiver = ChannelServices.GetChannel(CType(lbServces.SelectedItem, String))
                Dim strDesc As String
                For Each UriName As String In CType(chan.ChannelData, ChannelDataStore).ChannelUris
                    strDesc += UriName
                Next
                TextBox1.Text = strDesc & vbCrLf
                TextBox1.Text += "Priority : " + chan.ChannelPriority().ToString
            End If
        End If
    End Sub

    Private Sub btnStopServer_Click(ByVal sender As System.Object, ByVal e As System.EventArgs)
        On Error Resume Next
        CType(chan, IChannelReceiver).StopListening(Nothing)
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

    Private Sub lbServces_SelectedIndexChanged(ByVal sender As System.Object, ByVal e As System.EventArgs) Handles lbServces.SelectedIndexChanged
        UpdateDesc()
    End Sub

    Private Sub btnRefresh_Click(ByVal sender As System.Object, ByVal e As System.EventArgs) Handles btnRefresh.Click
        ListServices()
    End Sub

    Private Sub TextBox2_TextChanged(ByVal sender As System.Object, ByVal e As System.EventArgs) Handles TextBox2.TextChanged

    End Sub

    Private Sub btnStopSelected_Click(ByVal sender As System.Object, ByVal e As System.EventArgs) Handles btnStopSelected.Click
        If lbServces.Items.Count > 0 Then
            If lbServces.SelectedItems.Count > 0 Then
                Dim chan As IChannelReceiver = ChannelServices.GetChannel(CType(lbServces.SelectedItem, String))
                ChannelServices.UnregisterChannel(chan)
                chan.StopListening(Nothing)
                'RemotingConfiguration.GetRegisteredWellKnownServiceTypes()
                ListServices()

                txtStatusBar.Text = "Disconnected"
            End If
        End If
    End Sub

    Private Sub Button1_Click(ByVal sender As System.Object, ByVal e As System.EventArgs) Handles Button1.Click
        'ChannelServices.UnregisterChannel(chan)
        'CType(chan, IChannelReceiver).StopListening(Nothing)
    End Sub

    Private Sub Button2_Click(ByVal sender As System.Object, ByVal e As System.EventArgs) Handles Button2.Click
        'ChannelServices.RegisterChannel(chan)
        'CType(chan, IChannelReceiver).StartListening(Nothing)
    End Sub
End Class
