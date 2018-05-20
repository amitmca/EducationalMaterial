VERSION 5.00
Begin VB.Form Form2 
   Caption         =   "Form2"
   ClientHeight    =   4575
   ClientLeft      =   60
   ClientTop       =   450
   ClientWidth     =   6090
   LinkTopic       =   "Form2"
   ScaleHeight     =   4575
   ScaleWidth      =   6090
   StartUpPosition =   3  'Windows Default
   Begin VB.Timer Timer1 
      Interval        =   1000
      Left            =   4080
      Top             =   1920
   End
   Begin VB.Shape Shape1 
      BackColor       =   &H00C0FFFF&
      BorderColor     =   &H00FF00FF&
      Height          =   1575
      Left            =   600
      Top             =   1560
      Width           =   2295
   End
End
Attribute VB_Name = "Form2"
Attribute VB_GlobalNameSpace = False
Attribute VB_Creatable = False
Attribute VB_PredeclaredId = True
Attribute VB_Exposed = False
Dim c As Integer
Private Sub Form_Load()
c = 0
End Sub

Private Sub Timer1_Timer()
c = c + 1
If c < 5 Then
Shape1.FillStyle = c
Else
c = 0
End If
End Sub
