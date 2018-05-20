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
Dim c
Dim a As Integer
Private Sub Form_Load()
c = InputBox("Enter the Character:")
a = Asc(c)
If a >= 65 And a < 123 Then
Form2.Print "Alphabet"
ElseIf a >= 48 And a <= 57 Then
Form2.Print "Number"
Else
Form2.Print "Special Symbol"
End If
End Sub
