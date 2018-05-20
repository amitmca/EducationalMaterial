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
Dim n As Integer
Dim i As Integer
Dim p As Integer

Private Sub Form_Load()
n = InputBox("Enter the number")
p = 0
For i = 2 To n Step 1
If n Mod i = 0 Then
p = p + 1
End If
Next i
If p = 0 Then
Form2.Print "Not Prime"
Else
Form2.Print "Prime"
End If
End Sub
