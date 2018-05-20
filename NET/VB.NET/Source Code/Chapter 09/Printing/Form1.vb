Public Class Form1
    Inherits System.Windows.Forms.Form
    Dim PageNumber As Integer
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
    Friend WithEvents MainMenu1 As System.Windows.Forms.MainMenu
    Friend WithEvents MenuItem1 As System.Windows.Forms.MenuItem
    Friend WithEvents MenuItem2 As System.Windows.Forms.MenuItem
    Friend WithEvents MenuItem3 As System.Windows.Forms.MenuItem
    Friend WithEvents MenuItem4 As System.Windows.Forms.MenuItem
    Friend WithEvents MenuItem5 As System.Windows.Forms.MenuItem
    Friend WithEvents PrintDialog1 As System.Windows.Forms.PrintDialog
    Friend WithEvents PrintDocument1 As System.Drawing.Printing.PrintDocument
    Friend WithEvents PrintPreviewDialog1 As System.Windows.Forms.PrintPreviewDialog
    Friend WithEvents PageSetupDialog1 As System.Windows.Forms.PageSetupDialog
    <System.Diagnostics.DebuggerStepThrough()> Private Sub InitializeComponent()
        Dim resources As System.Resources.ResourceManager = New System.Resources.ResourceManager(GetType(Form1))
        Me.MainMenu1 = New System.Windows.Forms.MainMenu
        Me.MenuItem1 = New System.Windows.Forms.MenuItem
        Me.MenuItem2 = New System.Windows.Forms.MenuItem
        Me.MenuItem3 = New System.Windows.Forms.MenuItem
        Me.MenuItem4 = New System.Windows.Forms.MenuItem
        Me.MenuItem5 = New System.Windows.Forms.MenuItem
        Me.PrintDialog1 = New System.Windows.Forms.PrintDialog
        Me.PrintDocument1 = New System.Drawing.Printing.PrintDocument
        Me.PrintPreviewDialog1 = New System.Windows.Forms.PrintPreviewDialog
        Me.PageSetupDialog1 = New System.Windows.Forms.PageSetupDialog
        '
        'MainMenu1
        '
        Me.MainMenu1.MenuItems.AddRange(New System.Windows.Forms.MenuItem() {Me.MenuItem1})
        '
        'MenuItem1
        '
        Me.MenuItem1.Index = 0
        Me.MenuItem1.MenuItems.AddRange(New System.Windows.Forms.MenuItem() {Me.MenuItem2, Me.MenuItem3, Me.MenuItem4, Me.MenuItem5})
        Me.MenuItem1.Text = "File"
        '
        'MenuItem2
        '
        Me.MenuItem2.Index = 0
        Me.MenuItem2.Text = "Page Setup..."
        '
        'MenuItem3
        '
        Me.MenuItem3.Index = 1
        Me.MenuItem3.Text = "Print Preview..."
        '
        'MenuItem4
        '
        Me.MenuItem4.Index = 2
        Me.MenuItem4.Text = "Custom Print Preview..."
        '
        'MenuItem5
        '
        Me.MenuItem5.Index = 3
        Me.MenuItem5.Text = "Print..."
        '
        'PrintDocument1
        '
        '
        'PrintPreviewDialog1
        '
        Me.PrintPreviewDialog1.AutoScrollMargin = New System.Drawing.Size(0, 0)
        Me.PrintPreviewDialog1.AutoScrollMinSize = New System.Drawing.Size(0, 0)
        Me.PrintPreviewDialog1.ClientSize = New System.Drawing.Size(400, 300)
        Me.PrintPreviewDialog1.Enabled = True
        Me.PrintPreviewDialog1.Icon = CType(resources.GetObject("PrintPreviewDialog1.Icon"), System.Drawing.Icon)
        Me.PrintPreviewDialog1.Location = New System.Drawing.Point(396, 20)
        Me.PrintPreviewDialog1.MinimumSize = New System.Drawing.Size(375, 250)
        Me.PrintPreviewDialog1.Name = "PrintPreviewDialog1"
        Me.PrintPreviewDialog1.TransparencyKey = System.Drawing.Color.Empty
        Me.PrintPreviewDialog1.Visible = False
        '
        'Form1
        '
        Me.AutoScaleBaseSize = New System.Drawing.Size(5, 13)
        Me.ClientSize = New System.Drawing.Size(292, 266)
        Me.Menu = Me.MainMenu1
        Me.Name = "Form1"
        Me.Text = "Form1"

    End Sub

#End Region

    Private Sub MenuItem2_Click(ByVal sender As System.Object, _
        ByVal e As System.EventArgs) Handles MenuItem2.Click
        PageSetupDialog1.Document = PrintDocument1
        PageSetupDialog1.PrinterSettings = PrintDocument1.PrinterSettings
        PageSetupDialog1.PageSettings = PrintDocument1.DefaultPageSettings
        If PageSetupDialog1.ShowDialog = DialogResult.OK Then
            PrintDocument1.PrinterSettings = PageSetupDialog1.PrinterSettings
            PrintDocument1.DefaultPageSettings = PageSetupDialog1.PageSettings
        End If
    End Sub


    Private Sub MenuItem3_Click(ByVal sender As System.Object, _
        ByVal e As System.EventArgs) Handles MenuItem3.Click
        PrintPreviewDialog1.Document = PrintDocument1
        PrintPreviewDialog1.ShowDialog()
    End Sub

    Private Sub MenuItem4_Click(ByVal sender As System.Object, _
        ByVal e As System.EventArgs) Handles MenuItem4.Click
        Dim preview As New Form2
        preview.PrintPreviewControl1.Document = PrintDocument1
        preview.Show()
    End Sub


    Private Sub MenuItem5_Click(ByVal sender As System.Object, _
     ByVal e As System.EventArgs) Handles MenuItem5.Click
        PrintDialog1.Document = PrintDocument1
        PrintDialog1.PrinterSettings = PrintDocument1.PrinterSettings
        PrintDialog1.AllowSomePages = True
        If PrintDialog1.ShowDialog = DialogResult.OK Then
            PrintDocument1.PrinterSettings = PrintDialog1.PrinterSettings
            PrintDocument1.Print()
        End If
    End Sub

    Private Sub PrintDocument1_BeginPrint(ByVal sender As Object, _
        ByVal e As System.Drawing.Printing.PrintEventArgs) Handles _
        PrintDocument1.BeginPrint
        PageNumber = 0
    End Sub

    Private Sub PrintDocument1_PrintPage(ByVal sender As _
        System.Object, ByVal e As _
        System.Drawing.Printing.PrintPageEventArgs) _
        Handles PrintDocument1.PrintPage
        PageNumber += 1
        Select Case PageNumber
            Case 1
                e.Graphics.FillRectangle(Brushes.Red, _
                    New Rectangle(200, 200, 500, 500))
                e.HasMorePages = True
            Case 2
                e.Graphics.FillRectangle(Brushes.Blue, _
                    New Rectangle(200, 200, 500, 500))
                e.HasMorePages = False
        End Select
    End Sub

End Class
