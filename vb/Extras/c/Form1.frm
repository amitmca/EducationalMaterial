VERSION 5.00
Object = "{F9043C88-F6F2-101A-A3C9-08002B2F49FB}#1.2#0"; "COMDLG32.OCX"
Begin VB.Form Form1 
   AutoRedraw      =   -1  'True
   Caption         =   "Form1"
   ClientHeight    =   6810
   ClientLeft      =   60
   ClientTop       =   345
   ClientWidth     =   8715
   LinkTopic       =   "Form1"
   ScaleHeight     =   6810
   ScaleWidth      =   8715
   StartUpPosition =   3  'Windows Default
   Begin VB.CommandButton Command2 
      Caption         =   "Open"
      Height          =   495
      Left            =   3960
      TabIndex        =   1
      Top             =   720
      Width           =   3255
   End
   Begin VB.CommandButton Command1 
      Caption         =   "Color Dialog"
      Height          =   495
      Left            =   840
      TabIndex        =   0
      Top             =   720
      Width           =   2895
   End
   Begin MSComDlg.CommonDialog CommonDialog1 
      Left            =   1920
      Top             =   1920
      _ExtentX        =   847
      _ExtentY        =   847
      _Version        =   393216
   End
End
Attribute VB_Name = "Form1"
Attribute VB_GlobalNameSpace = False
Attribute VB_Creatable = False
Attribute VB_PredeclaredId = True
Attribute VB_Exposed = False
Dim str, str1
Private Sub Command1_Click()
CommonDialog1.ShowColor
Form1.BackColor = CommonDialog1.Color

End Sub

Private Sub Command2_Click()
CommonDialog1.ShowOpen
str = CommonDialog1.FileName
open input read as  str #1
Close #1

Form1.Print str
End Sub
