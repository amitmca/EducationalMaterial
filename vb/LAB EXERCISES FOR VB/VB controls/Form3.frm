VERSION 5.00
Begin VB.Form Form3 
   Caption         =   "Form3"
   ClientHeight    =   4365
   ClientLeft      =   60
   ClientTop       =   450
   ClientWidth     =   8460
   LinkTopic       =   "Form3"
   ScaleHeight     =   4365
   ScaleWidth      =   8460
   StartUpPosition =   3  'Windows Default
   Begin VB.TextBox Text1 
      Height          =   495
      Left            =   3960
      TabIndex        =   0
      Text            =   " "
      Top             =   1080
      Width           =   3975
   End
   Begin VB.Label Label1 
      AutoSize        =   -1  'True
      BackColor       =   &H0080FFFF&
      Caption         =   "Label1"
      BeginProperty Font 
         Name            =   "Times New Roman"
         Size            =   20.25
         Charset         =   0
         Weight          =   700
         Underline       =   0   'False
         Italic          =   0   'False
         Strikethrough   =   0   'False
      EndProperty
      ForeColor       =   &H00FF8080&
      Height          =   465
      Left            =   240
      TabIndex        =   1
      Top             =   1080
      Width           =   1215
   End
End
Attribute VB_Name = "Form3"
Attribute VB_GlobalNameSpace = False
Attribute VB_Creatable = False
Attribute VB_PredeclaredId = True
Attribute VB_Exposed = False
Option Explicit
Dim str

Private Sub Text1_Change()
str = Text1.Text
Label1.Caption = Asc(str)
End Sub
