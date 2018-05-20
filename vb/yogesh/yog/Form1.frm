VERSION 5.00
Begin VB.Form Form1 
   Caption         =   "Form1"
   ClientHeight    =   3090
   ClientLeft      =   60
   ClientTop       =   450
   ClientWidth     =   4680
   LinkTopic       =   "Form1"
   ScaleHeight     =   3090
   ScaleWidth      =   4680
   StartUpPosition =   3  'Windows Default
End
Attribute VB_Name = "Form1"
Attribute VB_GlobalNameSpace = False
Attribute VB_Creatable = False
Attribute VB_PredeclaredId = True
Attribute VB_Exposed = False
Option Explicit
Dim counter As Integer



Private Sub Form_MouseDown(Button As Integer, Shift As Integer, X As Single, Y As Single)
counter = counter + 1
If counter Mod 3 = 0 Then
Line (100, 100)-(400, 400), RGB(0, 255, 0), BF
ElseIf counter Mod 3 = 2 Then
Line (100, 100)-(400, 400), , B
ElseIf counter Mod 3 = 1 Then
Line (100, 100)-(400, 400)
End If




End Sub

Private Sub form1_load()
counter = 0
Form1.AutoRedraw = True
Form1.WindowState = 3
Form1 .DrawWidth = 1
Form1.DrawStyle = 2
End Sub
