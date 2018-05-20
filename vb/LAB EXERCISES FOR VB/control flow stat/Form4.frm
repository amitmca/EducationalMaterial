VERSION 5.00
Begin VB.Form Form4 
   Caption         =   "Form4"
   ClientHeight    =   3090
   ClientLeft      =   60
   ClientTop       =   450
   ClientWidth     =   4680
   LinkTopic       =   "Form4"
   ScaleHeight     =   3090
   ScaleWidth      =   4680
   StartUpPosition =   3  'Windows Default
End
Attribute VB_Name = "Form4"
Attribute VB_GlobalNameSpace = False
Attribute VB_Creatable = False
Attribute VB_PredeclaredId = True
Attribute VB_Exposed = False
Option Explicit
Dim n As Integer
Dim r As Integer
Dim t As Integer
Dim sum As Integer


Private Sub Form_Load()
n = InputBox("NUMBER:")
t = n
While n > 0
r = n Mod 10
sum = sum + r * r * r
n = (n - r) / 10
Wend
If sum = t Then
MsgBox "ARMSTRONG"
Else
MsgBox "NOT ARMSTRONG"
End If
End
End Sub
