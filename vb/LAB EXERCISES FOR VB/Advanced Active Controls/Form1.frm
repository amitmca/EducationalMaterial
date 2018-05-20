VERSION 5.00
Object = "{F9043C88-F6F2-101A-A3C9-08002B2F49FB}#1.2#0"; "COMDLG32.OCX"
Begin VB.Form Form1 
   Caption         =   "Form1"
   ClientHeight    =   6750
   ClientLeft      =   60
   ClientTop       =   345
   ClientWidth     =   7080
   LinkTopic       =   "Form1"
   ScaleHeight     =   6750
   ScaleWidth      =   7080
   StartUpPosition =   3  'Windows Default
   Begin VB.TextBox Text1 
      Height          =   1575
      Left            =   600
      TabIndex        =   2
      Text            =   " "
      Top             =   3360
      Width           =   5775
   End
   Begin MSComDlg.CommonDialog CommonDialog1 
      Left            =   5280
      Top             =   2160
      _ExtentX        =   847
      _ExtentY        =   847
      _Version        =   393216
   End
   Begin VB.CommandButton Command2 
      BackColor       =   &H00FFFFC0&
      Caption         =   "SHOW SAVE"
      BeginProperty Font 
         Name            =   "Times New Roman"
         Size            =   14.25
         Charset         =   0
         Weight          =   700
         Underline       =   0   'False
         Italic          =   0   'False
         Strikethrough   =   0   'False
      EndProperty
      Height          =   735
      Left            =   1680
      Style           =   1  'Graphical
      TabIndex        =   1
      Top             =   2280
      Width           =   2775
   End
   Begin VB.CommandButton Command1 
      BackColor       =   &H00FFFFC0&
      Caption         =   "SHOW OPEN"
      BeginProperty Font 
         Name            =   "Times New Roman"
         Size            =   14.25
         Charset         =   0
         Weight          =   700
         Underline       =   0   'False
         Italic          =   0   'False
         Strikethrough   =   0   'False
      EndProperty
      Height          =   735
      Left            =   1680
      Style           =   1  'Graphical
      TabIndex        =   0
      Top             =   1080
      Width           =   2775
   End
End
Attribute VB_Name = "Form1"
Attribute VB_GlobalNameSpace = False
Attribute VB_Creatable = False
Attribute VB_PredeclaredId = True
Attribute VB_Exposed = False
Private Sub Command1_Click()
CommonDialog1.ShowOpen
Text1.Text = "File Name=" & CommonDialog1.FileName

End Sub

Private Sub Command2_Click()
CommonDialog1.ShowSave
Text1.Text = "File Name=" & CommonDialog1.FileName
End Sub
