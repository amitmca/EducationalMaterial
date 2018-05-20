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
End
Attribute VB_Name = "Form1"
Attribute VB_GlobalNameSpace = False
Attribute VB_Creatable = False
Attribute VB_PredeclaredId = True
Attribute VB_Exposed = False
Dim n As Integer
Dim r As Integer
Dim t As Integer
Dim sum As Integer

Private Sub Form_Load()
sum = 0
n = InputBox("Enter the number:")
t = n
While n > 0
r = n Mod 10
Form1.Print r
sum = sum + r * r * r
n = (n - r) / 10
Wend
If sum = t Then
Form1.Print "Armstrong"
Else
Form1.Print "Not Armstrong"
End If
End Sub
