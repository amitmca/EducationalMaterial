VERSION 5.00
Begin VB.Form Form1 
   Caption         =   "Form1"
   ClientHeight    =   4560
   ClientLeft      =   60
   ClientTop       =   450
   ClientWidth     =   6690
   LinkTopic       =   "Form1"
   ScaleHeight     =   4560
   ScaleWidth      =   6690
   StartUpPosition =   3  'Windows Default
   Begin VB.Timer Timer1 
      Interval        =   1000
      Left            =   1560
      Top             =   1200
   End
End
Attribute VB_Name = "Form1"
Attribute VB_GlobalNameSpace = False
Attribute VB_Creatable = False
Attribute VB_PredeclaredId = True
Attribute VB_Exposed = False
Option Explicit
Dim c As Integer

Private Sub Form_Load()
c = 0
End Sub

Private Sub Timer1_Timer()
c = c + 1
If c Mod 3 = 0 Then
Form1.BackColor = RGB(0, 0, 255)
ElseIf c Mod 3 = 1 Then
Form1.BackColor = RGB(0, 255, 0)
ElseIf c Mod 3 = 2 Then
Form1.BackColor = RGB(255, 0, 0)
End If
End Sub
