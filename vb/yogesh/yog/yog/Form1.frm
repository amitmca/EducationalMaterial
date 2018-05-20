VERSION 5.00
Begin VB.Form Form1 
   AutoRedraw      =   -1  'True
   Caption         =   "Form1"
   ClientHeight    =   3090
   ClientLeft      =   60
   ClientTop       =   450
   ClientWidth     =   4680
   LinkTopic       =   "Form1"
   ScaleHeight     =   3090
   ScaleWidth      =   4680
   StartUpPosition =   3  'Windows Default
   Begin VB.Timer Timer1 
      Interval        =   500
      Left            =   1800
      Top             =   1440
   End
End
Attribute VB_Name = "Form1"
Attribute VB_GlobalNameSpace = False
Attribute VB_Creatable = False
Attribute VB_PredeclaredId = True
Attribute VB_Exposed = False
Option Explicit
Dim counter As Integer

Private Sub Form_Load()
counter = 0
End Sub

Private Sub Timer1_Timer()
counter = counter + 1
If counter Mod 3 = 0 Then
Form1.ForeColor = RGB(0, 0, 255)
ElseIf counter Mod 3 = 2 Then
Form1.BackColor = RGB(0, 255, 0)
ElseIf counter Mod 3 = 1 Then
Form1.BackColor = RGB(255, 0, 0)
End If
End Sub
