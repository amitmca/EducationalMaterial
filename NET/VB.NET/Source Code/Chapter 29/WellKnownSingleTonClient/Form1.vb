Imports System.Runtime.Remoting
Imports System.Runtime.Remoting.Channels
Imports System.Runtime.Remoting.Channels.Tcp
Imports System.Runtime.Remoting.Activation
Imports SharedObject
Imports System.Runtime.Serialization
Imports System.Runtime.Remoting.Channels.Http
Imports System.Runtime.Serialization.Formatters
Imports Microsoft.DirectX.Direct3D

Public Class Form1
    Inherits System.Windows.Forms.Form

    Dim MyPen As Pen
    Dim last, down As Point
    Dim g As Graphics
    Dim Points() As Point
    Dim NumberPoints As Integer = 0

    Dim bConnected As Boolean = False
    Dim chan As IChannel
    Dim SProvider As IServerChannelSinkProvider
    Dim CProvider As IClientChannelSinkProvider
    Dim props As IDictionary

    Dim Obj As SharedObject.SharedObject

    Public sink As EventSink


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
    Friend WithEvents txtStatusBar As System.Windows.Forms.TextBox
    Friend WithEvents Button5 As System.Windows.Forms.Button
    Friend WithEvents GroupBox1 As System.Windows.Forms.GroupBox
    Friend WithEvents Panel1 As System.Windows.Forms.Panel
    Friend WithEvents Button4 As System.Windows.Forms.Button
    Friend WithEvents GroupBox2 As System.Windows.Forms.GroupBox
    Friend WithEvents rbtnHttpChannel As System.Windows.Forms.RadioButton
    Friend WithEvents rbtnTcpChannel As System.Windows.Forms.RadioButton
    Friend WithEvents GroupBox4 As System.Windows.Forms.GroupBox
    Friend WithEvents rbtnSoap As System.Windows.Forms.RadioButton
    Friend WithEvents rbtnBinary As System.Windows.Forms.RadioButton
    Friend WithEvents GroupBox5 As System.Windows.Forms.GroupBox
    Friend WithEvents TextBox2 As System.Windows.Forms.TextBox
    Friend WithEvents Button6 As System.Windows.Forms.Button
    Friend WithEvents ColorDialog1 As System.Windows.Forms.ColorDialog
    Friend WithEvents cbtnFullTrust As System.Windows.Forms.CheckBox
    Friend WithEvents GroupBox3 As System.Windows.Forms.GroupBox
    Friend WithEvents TextBox1 As System.Windows.Forms.TextBox
    <System.Diagnostics.DebuggerStepThrough()> Private Sub InitializeComponent()
        Me.Button1 = New System.Windows.Forms.Button
        Me.Button2 = New System.Windows.Forms.Button
        Me.Button3 = New System.Windows.Forms.Button
        Me.txtStatusBar = New System.Windows.Forms.TextBox
        Me.Button5 = New System.Windows.Forms.Button
        Me.GroupBox1 = New System.Windows.Forms.GroupBox
        Me.Button6 = New System.Windows.Forms.Button
        Me.Button4 = New System.Windows.Forms.Button
        Me.Panel1 = New System.Windows.Forms.Panel
        Me.GroupBox2 = New System.Windows.Forms.GroupBox
        Me.rbtnHttpChannel = New System.Windows.Forms.RadioButton
        Me.rbtnTcpChannel = New System.Windows.Forms.RadioButton
        Me.GroupBox4 = New System.Windows.Forms.GroupBox
        Me.rbtnSoap = New System.Windows.Forms.RadioButton
        Me.rbtnBinary = New System.Windows.Forms.RadioButton
        Me.GroupBox5 = New System.Windows.Forms.GroupBox
        Me.TextBox2 = New System.Windows.Forms.TextBox
        Me.ColorDialog1 = New System.Windows.Forms.ColorDialog
        Me.cbtnFullTrust = New System.Windows.Forms.CheckBox
        Me.GroupBox3 = New System.Windows.Forms.GroupBox
        Me.TextBox1 = New System.Windows.Forms.TextBox
        Me.GroupBox1.SuspendLayout()
        Me.GroupBox2.SuspendLayout()
        Me.GroupBox4.SuspendLayout()
        Me.GroupBox5.SuspendLayout()
        Me.GroupBox3.SuspendLayout()
        Me.SuspendLayout()
        '
        'Button1
        '
        Me.Button1.Location = New System.Drawing.Point(16, 64)
        Me.Button1.Name = "Button1"
        Me.Button1.Size = New System.Drawing.Size(72, 25)
        Me.Button1.TabIndex = 0
        Me.Button1.Text = "Connect"
        '
        'Button2
        '
        Me.Button2.Location = New System.Drawing.Point(96, 65)
        Me.Button2.Name = "Button2"
        Me.Button2.Size = New System.Drawing.Size(72, 25)
        Me.Button2.TabIndex = 1
        Me.Button2.Text = "Greeting"
        '
        'Button3
        '
        Me.Button3.Location = New System.Drawing.Point(96, 97)
        Me.Button3.Name = "Button3"
        Me.Button3.Size = New System.Drawing.Size(72, 25)
        Me.Button3.TabIndex = 2
        Me.Button3.Text = "Get Count"
        '
        'txtStatusBar
        '
        Me.txtStatusBar.Anchor = CType(((System.Windows.Forms.AnchorStyles.Bottom Or System.Windows.Forms.AnchorStyles.Left) _
                    Or System.Windows.Forms.AnchorStyles.Right), System.Windows.Forms.AnchorStyles)
        Me.txtStatusBar.BorderStyle = System.Windows.Forms.BorderStyle.None
        Me.txtStatusBar.Enabled = False
        Me.txtStatusBar.Font = New System.Drawing.Font("Microsoft Sans Serif", 8.25!, System.Drawing.FontStyle.Bold, System.Drawing.GraphicsUnit.Point, CType(0, Byte))
        Me.txtStatusBar.Location = New System.Drawing.Point(0, 224)
        Me.txtStatusBar.Multiline = True
        Me.txtStatusBar.Name = "txtStatusBar"
        Me.txtStatusBar.ReadOnly = True
        Me.txtStatusBar.Size = New System.Drawing.Size(560, 64)
        Me.txtStatusBar.TabIndex = 20
        Me.txtStatusBar.Text = ""
        Me.txtStatusBar.TextAlign = System.Windows.Forms.HorizontalAlignment.Center
        '
        'Button5
        '
        Me.Button5.Location = New System.Drawing.Point(16, 97)
        Me.Button5.Name = "Button5"
        Me.Button5.Size = New System.Drawing.Size(72, 25)
        Me.Button5.TabIndex = 21
        Me.Button5.Text = "Disconnect"
        '
        'GroupBox1
        '
        Me.GroupBox1.Controls.Add(Me.Button6)
        Me.GroupBox1.Controls.Add(Me.Button4)
        Me.GroupBox1.Controls.Add(Me.Panel1)
        Me.GroupBox1.Location = New System.Drawing.Point(260, 11)
        Me.GroupBox1.Name = "GroupBox1"
        Me.GroupBox1.Size = New System.Drawing.Size(296, 209)
        Me.GroupBox1.TabIndex = 24
        Me.GroupBox1.TabStop = False
        Me.GroupBox1.Text = "Paint Here"
        '
        'Button6
        '
        Me.Button6.Font = New System.Drawing.Font("Verdana", 9.0!, System.Drawing.FontStyle.Bold, System.Drawing.GraphicsUnit.Point, CType(0, Byte))
        Me.Button6.Location = New System.Drawing.Point(80, 179)
        Me.Button6.Name = "Button6"
        Me.Button6.Size = New System.Drawing.Size(128, 23)
        Me.Button6.TabIndex = 32
        Me.Button6.Text = "Choose Color"
        '
        'Button4
        '
        Me.Button4.Location = New System.Drawing.Point(216, 179)
        Me.Button4.Name = "Button4"
        Me.Button4.Size = New System.Drawing.Size(72, 23)
        Me.Button4.TabIndex = 6
        Me.Button4.Text = "Clear"
        '
        'Panel1
        '
        Me.Panel1.BackColor = System.Drawing.Color.White
        Me.Panel1.BorderStyle = System.Windows.Forms.BorderStyle.Fixed3D
        Me.Panel1.Cursor = System.Windows.Forms.Cursors.Arrow
        Me.Panel1.Location = New System.Drawing.Point(8, 16)
        Me.Panel1.Name = "Panel1"
        Me.Panel1.Size = New System.Drawing.Size(280, 157)
        Me.Panel1.TabIndex = 5
        '
        'GroupBox2
        '
        Me.GroupBox2.Controls.Add(Me.rbtnHttpChannel)
        Me.GroupBox2.Controls.Add(Me.rbtnTcpChannel)
        Me.GroupBox2.Location = New System.Drawing.Point(16, 130)
        Me.GroupBox2.Name = "GroupBox2"
        Me.GroupBox2.Size = New System.Drawing.Size(239, 42)
        Me.GroupBox2.TabIndex = 27
        Me.GroupBox2.TabStop = False
        Me.GroupBox2.Text = "Channel"
        '
        'rbtnHttpChannel
        '
        Me.rbtnHttpChannel.Location = New System.Drawing.Point(128, 16)
        Me.rbtnHttpChannel.Name = "rbtnHttpChannel"
        Me.rbtnHttpChannel.Size = New System.Drawing.Size(88, 20)
        Me.rbtnHttpChannel.TabIndex = 9
        Me.rbtnHttpChannel.Text = "HttpChannel"
        '
        'rbtnTcpChannel
        '
        Me.rbtnTcpChannel.Checked = True
        Me.rbtnTcpChannel.Location = New System.Drawing.Point(24, 16)
        Me.rbtnTcpChannel.Name = "rbtnTcpChannel"
        Me.rbtnTcpChannel.Size = New System.Drawing.Size(88, 20)
        Me.rbtnTcpChannel.TabIndex = 8
        Me.rbtnTcpChannel.TabStop = True
        Me.rbtnTcpChannel.Text = "TcpChannel"
        '
        'GroupBox4
        '
        Me.GroupBox4.Controls.Add(Me.rbtnSoap)
        Me.GroupBox4.Controls.Add(Me.rbtnBinary)
        Me.GroupBox4.Location = New System.Drawing.Point(16, 175)
        Me.GroupBox4.Name = "GroupBox4"
        Me.GroupBox4.Size = New System.Drawing.Size(158, 46)
        Me.GroupBox4.TabIndex = 26
        Me.GroupBox4.TabStop = False
        Me.GroupBox4.Text = "Formatter Sink Provider"
        '
        'rbtnSoap
        '
        Me.rbtnSoap.Location = New System.Drawing.Point(88, 21)
        Me.rbtnSoap.Name = "rbtnSoap"
        Me.rbtnSoap.Size = New System.Drawing.Size(56, 16)
        Me.rbtnSoap.TabIndex = 11
        Me.rbtnSoap.Text = "Soap"
        '
        'rbtnBinary
        '
        Me.rbtnBinary.Checked = True
        Me.rbtnBinary.Location = New System.Drawing.Point(16, 21)
        Me.rbtnBinary.Name = "rbtnBinary"
        Me.rbtnBinary.Size = New System.Drawing.Size(56, 16)
        Me.rbtnBinary.TabIndex = 10
        Me.rbtnBinary.TabStop = True
        Me.rbtnBinary.Text = "Binary"
        '
        'GroupBox5
        '
        Me.GroupBox5.Controls.Add(Me.TextBox2)
        Me.GroupBox5.Location = New System.Drawing.Point(176, 64)
        Me.GroupBox5.Name = "GroupBox5"
        Me.GroupBox5.Size = New System.Drawing.Size(80, 58)
        Me.GroupBox5.TabIndex = 28
        Me.GroupBox5.TabStop = False
        Me.GroupBox5.Text = "Port No"
        '
        'TextBox2
        '
        Me.TextBox2.Location = New System.Drawing.Point(8, 20)
        Me.TextBox2.Name = "TextBox2"
        Me.TextBox2.Size = New System.Drawing.Size(64, 20)
        Me.TextBox2.TabIndex = 18
        Me.TextBox2.Text = "8086"
        '
        'cbtnFullTrust
        '
        Me.cbtnFullTrust.Location = New System.Drawing.Point(183, 189)
        Me.cbtnFullTrust.Name = "cbtnFullTrust"
        Me.cbtnFullTrust.Size = New System.Drawing.Size(72, 26)
        Me.cbtnFullTrust.TabIndex = 29
        Me.cbtnFullTrust.Text = "Full Trust"
        '
        'GroupBox3
        '
        Me.GroupBox3.Controls.Add(Me.TextBox1)
        Me.GroupBox3.Location = New System.Drawing.Point(16, 11)
        Me.GroupBox3.Name = "GroupBox3"
        Me.GroupBox3.Size = New System.Drawing.Size(240, 45)
        Me.GroupBox3.TabIndex = 30
        Me.GroupBox3.TabStop = False
        Me.GroupBox3.Text = "Enter the machine name to connect to :"
        '
        'TextBox1
        '
        Me.TextBox1.Location = New System.Drawing.Point(8, 16)
        Me.TextBox1.Name = "TextBox1"
        Me.TextBox1.Size = New System.Drawing.Size(224, 20)
        Me.TextBox1.TabIndex = 23
        Me.TextBox1.Text = ""
        '
        'Form1
        '
        Me.AutoScaleBaseSize = New System.Drawing.Size(5, 13)
        Me.ClientSize = New System.Drawing.Size(560, 238)
        Me.Controls.Add(Me.cbtnFullTrust)
        Me.Controls.Add(Me.GroupBox5)
        Me.Controls.Add(Me.GroupBox2)
        Me.Controls.Add(Me.GroupBox4)
        Me.Controls.Add(Me.GroupBox1)
        Me.Controls.Add(Me.txtStatusBar)
        Me.Controls.Add(Me.Button5)
        Me.Controls.Add(Me.Button3)
        Me.Controls.Add(Me.Button2)
        Me.Controls.Add(Me.Button1)
        Me.Controls.Add(Me.GroupBox3)
        Me.Name = "Form1"
        Me.Text = "Form1"
        Me.GroupBox1.ResumeLayout(False)
        Me.GroupBox2.ResumeLayout(False)
        Me.GroupBox4.ResumeLayout(False)
        Me.GroupBox5.ResumeLayout(False)
        Me.GroupBox3.ResumeLayout(False)
        Me.ResumeLayout(False)

    End Sub

#End Region

    Public Sub DrawLine(ByVal From As Point, ByVal Till As Point)
        g.DrawLine(Pens.Red, From, Till)
    End Sub

    Private Sub Form1_Load(ByVal sender As System.Object, _
        ByVal e As System.EventArgs) Handles MyBase.Load
        g = Panel1.CreateGraphics()
        MyPen = New Pen(Color.Black, 5)
    End Sub

    Private Sub Form1_Paint(ByVal sender As Object, _
        ByVal e As System.Windows.Forms.PaintEventArgs) _
            Handles MyBase.Paint

        If NumberPoints >= 2 Then
            g.DrawLines(MyPen, Points)
        End If

    End Sub

    Private Sub Form1_MouseUp(ByVal sender As Object, _
        ByVal e As System.Windows.Forms.MouseEventArgs) Handles _
        MyBase.MouseUp

    End Sub

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
                URI = "tcp://" & TextBox1.Text & ":" & TextBox2.Text & "/HiServerApp/HiServer"
            ElseIf rbtnHttpChannel.Checked Then
                If Not cbtnFullTrust.Checked Then
                    chan = New HttpChannel
                Else
                    chan = New HttpChannel(props, CProvider, SProvider)
                End If
                URI = "http://" & TextBox1.Text & ":" & TextBox2.Text & "/HiServerApp/HiServer"
            End If


            ChannelServices.RegisterChannel(chan)
            Obj = CType(Activator.GetObject(GetType(SharedObject.SharedObject), URI), SharedObject.SharedObject)


            If cbtnFullTrust.Checked Then
                Dim DrLn As New StrokeEvent(AddressOf Me.DrawLine)
                sink = New EventSink(DrLn)
                AddHandler Obj.Stroke, New StrokeEvent(AddressOf sink.OnStroke)
            End If


            bConnected = True
            txtStatusBar.Text = "Connected"

        Catch ex As Exception
            txtStatusBar.Text = ex.Message
        End Try

    End Sub

    Private Sub Button2_Click(ByVal sender As System.Object, ByVal e As System.EventArgs) Handles Button2.Click
        If bConnected Then
            Obj.Greeting(TextBox1.Text)
        End If
    End Sub

    Delegate Sub GetCount()

    Private Sub Button3_Click(ByVal sender As System.Object, ByVal e As System.EventArgs) Handles Button3.Click
        If bConnected Then

            Dim GetC As GetCount
            Dim ar As IAsyncResult = GetC.BeginInvoke(Nothing, Nothing)

            ar.AsyncWaitHandle.WaitOne()
            If (ar.IsCompleted) Then
                GetC.EndInvoke(ar)
            End If

        End If
    End Sub

    Private Sub Button4_Click(ByVal sender As System.Object, ByVal e As System.EventArgs) Handles Button4.Click
        If NumberPoints > 0 Then
            Points.Clear(Points, 0, NumberPoints)
            NumberPoints = 0
        End If
        Panel1.Invalidate()

    End Sub

    Private Sub Button5_Click(ByVal sender As System.Object, ByVal e As System.EventArgs) Handles Button5.Click
        If Not chan Is Nothing Then
            ChannelServices.UnregisterChannel(chan)
            Obj = Nothing
            bConnected = False
            txtStatusBar.Text = "Disconnected"
        End If
    End Sub

    Private Sub Panel1_MouseDown(ByVal sender As System.Object, ByVal e As System.Windows.Forms.MouseEventArgs) Handles Panel1.MouseDown
        If NumberPoints > 0 Then
            Points.Clear(Points, 0, NumberPoints)
            NumberPoints = 0
        End If

    End Sub

    Private Sub Panel1_MouseMove(ByVal sender As System.Object, ByVal e As System.Windows.Forms.MouseEventArgs) Handles Panel1.MouseMove

        If e.Button = MouseButtons.Left Then
            last = New Point(e.X, e.Y)

            ReDim Preserve Points(NumberPoints)

            Points(NumberPoints) = last
            NumberPoints += 1

            If NumberPoints >= 2 Then
                Try
                    If (bConnected) Then
                        Obj.Confer(down, last)
                    End If
                Catch ex As Exception
                    txtStatusBar.Text = ex.Message
                End Try
                g.DrawLine(MyPen, down, last)
            End If

            down = last
        End If

    End Sub

    Private Sub rbtnHttpChannel_CheckedChanged(ByVal sender As System.Object, ByVal e As System.EventArgs) Handles rbtnHttpChannel.CheckedChanged
        If rbtnHttpChannel.Checked Then
            rbtnSoap.Checked = True
            GroupBox4.Enabled = False
        End If
    End Sub

    Private Sub rbtnTcpChannel_CheckedChanged(ByVal sender As System.Object, ByVal e As System.EventArgs) Handles rbtnTcpChannel.CheckedChanged
        GroupBox4.Enabled = True
    End Sub

    Private Sub Button6_Click(ByVal sender As System.Object, ByVal e As System.EventArgs) Handles Button6.Click
        If ColorDialog1.ShowDialog() = DialogResult.OK Then
            MyPen.Color = ColorDialog1.Color
            Button6.ForeColor = ColorDialog1.Color
            Button6.BackColor = Microsoft.DirectX.Direct3D.ColorOperator.Negative(ColorDialog1.Color)
        End If
    End Sub


End Class
