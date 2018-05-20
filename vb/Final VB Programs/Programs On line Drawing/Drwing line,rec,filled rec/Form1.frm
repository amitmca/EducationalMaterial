VERSION 5.00
Begin VB.Form Form1 
   Caption         =   "Form1"
   ClientHeight    =   3090
   ClientLeft      =   60
   ClientTop       =   450
   ClientWidth     =   4680
   DrawWidth       =   4
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
Dim c As Integer

Private Sub Form_Load()
c = 0
End Sub

Private Sub Form_MouseDown(Button As Integer, Shift As Integer, X As Single, Y As Single)
c = c + 1
Form1.Cls
If c Mod 3 = 0 Then
Line (100, 100)-(400, 400), RGB(0, 0, 255), BF
ElseIf c Mod 3 = 2 Then
Line (100, 100)-(400, 400), RGB(0, 255, 0), B
ElseIf c Mod 3 = 1 Then
Line (100, 100)-(400, 400), RGB(255, 0, 0)
End If
End Sub
