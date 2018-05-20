VERSION 5.00
Begin VB.Form Form2 
   AutoRedraw      =   -1  'True
   Caption         =   "Form2"
   ClientHeight    =   3090
   ClientLeft      =   60
   ClientTop       =   450
   ClientWidth     =   4680
   LinkTopic       =   "Form2"
   ScaleHeight     =   3090
   ScaleWidth      =   4680
   StartUpPosition =   3  'Windows Default
End
Attribute VB_Name = "Form2"
Attribute VB_GlobalNameSpace = False
Attribute VB_Creatable = False
Attribute VB_PredeclaredId = True
Attribute VB_Exposed = False
Option Explicit
Dim a As Integer
Dim b As Integer
Dim c As Integer



Private Sub Form_Load()
a = InputBox("FIRST NUMBER:")
b = InputBox("SECOND NUMBER:")
c = InputBox("THIRD NUMBER:")
If a > b And a > c Then
MsgBox "a is maximum"
ElseIf b > a And b > c Then
MsgBox "b is maximum"
Else
MsgBox "c is maximum"
End If
End Sub
