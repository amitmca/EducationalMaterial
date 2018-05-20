VERSION 5.00
Begin VB.Form Form4 
   Caption         =   "Form4"
   ClientHeight    =   5400
   ClientLeft      =   60
   ClientTop       =   450
   ClientWidth     =   8100
   LinkTopic       =   "Form4"
   ScaleHeight     =   5400
   ScaleWidth      =   8100
   StartUpPosition =   3  'Windows Default
   Begin VB.TextBox Text2 
      Height          =   495
      Left            =   4920
      TabIndex        =   1
      Text            =   " "
      Top             =   1080
      Width           =   2415
   End
   Begin VB.TextBox Text1 
      Height          =   495
      Left            =   4920
      TabIndex        =   0
      Text            =   " "
      Top             =   240
      Width           =   2415
   End
   Begin VB.Label Label2 
      Alignment       =   2  'Center
      BackColor       =   &H00C0FFC0&
      Caption         =   " NUMBER OF RIGHT CLICKS"
      BeginProperty Font 
         Name            =   "Times New Roman"
         Size            =   15.75
         Charset         =   0
         Weight          =   700
         Underline       =   0   'False
         Italic          =   0   'False
         Strikethrough   =   0   'False
      EndProperty
      ForeColor       =   &H000000FF&
      Height          =   735
      Left            =   240
      TabIndex        =   3
      Top             =   840
      Width           =   4335
   End
   Begin VB.Label Label1 
      Alignment       =   2  'Center
      BackColor       =   &H00C0FFC0&
      Caption         =   " NUMBER OF LEFT CLICKS"
      BeginProperty Font 
         Name            =   "Times New Roman"
         Size            =   15.75
         Charset         =   0
         Weight          =   700
         Underline       =   0   'False
         Italic          =   0   'False
         Strikethrough   =   0   'False
      EndProperty
      ForeColor       =   &H000000FF&
      Height          =   495
      Index           =   0
      Left            =   240
      TabIndex        =   2
      Top             =   240
      Width           =   4335
   End
End
Attribute VB_Name = "Form4"
Attribute VB_GlobalNameSpace = False
Attribute VB_Creatable = False
Attribute VB_PredeclaredId = True
Attribute VB_Exposed = False
'Program to count right and left clicks
Option Explicit
Dim lc As Integer
Dim rc As Integer


Private Sub Form_Load()
lc = 0
rc = 0
End Sub

Private Sub Form_MouseDown(Button As Integer, Shift As Integer, X As Single, Y As Single)
If Button = 1 Then
lc = lc + 1
Text1.Text = lc
ElseIf Button = 2 Then
rc = rc + 1
Text2.Text = rc
End If
End Sub
