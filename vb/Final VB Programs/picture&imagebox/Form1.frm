VERSION 5.00
Begin VB.Form Form1 
   Caption         =   "Form1"
   ClientHeight    =   6750
   ClientLeft      =   60
   ClientTop       =   450
   ClientWidth     =   8145
   LinkTopic       =   "Form1"
   ScaleHeight     =   6750
   ScaleWidth      =   8145
   StartUpPosition =   3  'Windows Default
   Begin VB.PictureBox Picture1 
      AutoRedraw      =   -1  'True
      Height          =   495
      Left            =   480
      Picture         =   "Form1.frx":0000
      ScaleHeight     =   435
      ScaleWidth      =   435
      TabIndex        =   2
      Top             =   840
      Width           =   495
   End
   Begin VB.CommandButton Command1 
      Caption         =   "Command1"
      Height          =   495
      Left            =   600
      TabIndex        =   1
      Top             =   2280
      Width           =   3255
   End
   Begin VB.PictureBox Picture2 
      AutoRedraw      =   -1  'True
      AutoSize        =   -1  'True
      Height          =   210
      Left            =   1800
      Picture         =   "Form1.frx":0421
      ScaleHeight     =   150
      ScaleWidth      =   150
      TabIndex        =   0
      Top             =   1080
      Width           =   210
   End
End
Attribute VB_Name = "Form1"
Attribute VB_GlobalNameSpace = False
Attribute VB_Creatable = False
Attribute VB_PredeclaredId = True
Attribute VB_Exposed = False
Dim c As Integer

Private Sub Command1_Click()
Picture1.Picture = LoadPicture("C:\WINDOWS\Web\tips.gif")
End Sub

Private Sub Form_Load()
c = 0
End Sub

Private Sub Timer1_Timer()
c = c + 1
If c Mod 2 = 0 Then
Picture1.Visible = False
Picture2.Visible = True
Else
Picture1.Visible = True
Picture2.Visible = False
End If
End Sub
