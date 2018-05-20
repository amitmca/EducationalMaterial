VERSION 5.00
Begin VB.Form Form7 
   AutoRedraw      =   -1  'True
   Caption         =   "Form7"
   ClientHeight    =   3090
   ClientLeft      =   60
   ClientTop       =   450
   ClientWidth     =   4680
   LinkTopic       =   "Form7"
   ScaleHeight     =   3090
   ScaleWidth      =   4680
   StartUpPosition =   3  'Windows Default
End
Attribute VB_Name = "Form7"
Attribute VB_GlobalNameSpace = False
Attribute VB_Creatable = False
Attribute VB_PredeclaredId = True
Attribute VB_Exposed = False
Option Explicit
Dim n As Integer
Dim i As Integer
Dim a(10) As Integer
Dim b(10) As Integer
Dim j As Integer
Dim str As String
Private Sub Form_Load()
n = InputBox("How many elements:")
For i = 0 To n Step 1
str = InputBox("Enter array element:")
a(i) = CStr(str)
Next i

j = 0
For i = 0 To n Step 1
If a(i) Mod 2 = 1 Then
b(j) = a(i)
j = j + 1
End If
Next i

Form7.Print "The Odd elements are:"
For j = 0 To n Step 1
Form7.Print b(j)
Next j
End Sub
