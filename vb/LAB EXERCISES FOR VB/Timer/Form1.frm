VERSION 5.00
Begin VB.Form Form2 
   BackColor       =   &H00FFC0C0&
   Caption         =   "Form2"
   ClientHeight    =   5340
   ClientLeft      =   60
   ClientTop       =   450
   ClientWidth     =   8010
   LinkTopic       =   "Form2"
   ScaleHeight     =   5340
   ScaleWidth      =   8010
   StartUpPosition =   3  'Windows Default
   Begin VB.Timer Timer1 
      Interval        =   900
      Left            =   5280
      Top             =   3240
   End
   Begin VB.Image Image2 
      Height          =   11520
      Left            =   720
      Picture         =   "Form1.frx":0000
      Top             =   -240
      Width           =   15360
   End
   Begin VB.Image Image1 
      Height          =   11520
      Left            =   360
      Picture         =   "Form1.frx":4BDDF
      Top             =   240
      Width           =   15360
   End
End
Attribute VB_Name = "Form2"
Attribute VB_GlobalNameSpace = False
Attribute VB_Creatable = False
Attribute VB_PredeclaredId = True
Attribute VB_Exposed = False

Dim c

Private Sub Form_Load()
c = 0
End Sub



Private Sub Timer1_Timer()
c = c + 1
If c Mod 2 = 0 Then
Image1.Visible = True
Image2.Visible = False
Else
Image1.Visible = False
Image2.Visible = True
End If
End Sub
