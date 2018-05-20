VERSION 5.00
Begin VB.Form Form3 
   AutoRedraw      =   -1  'True
   Caption         =   "Form3"
   ClientHeight    =   6090
   ClientLeft      =   60
   ClientTop       =   450
   ClientWidth     =   7365
   LinkTopic       =   "Form3"
   ScaleHeight     =   6090
   ScaleWidth      =   7365
   StartUpPosition =   3  'Windows Default
End
Attribute VB_Name = "Form3"
Attribute VB_GlobalNameSpace = False
Attribute VB_Creatable = False
Attribute VB_PredeclaredId = True
Attribute VB_Exposed = False
Dim str As String
Dim a(10) As Integer
Dim i As Integer
Dim n As Integer
Dim b(10) As Integer
Dim j As Integer
Private Sub Form_Load()
n = InputBox("How many numbers do you want to check")
For i = 1 To n Step 1
str = InputBox("Enter the number")
a(i) = CStr(str)
Next i
j = 0
For i = 1 To n Step 1
If a(i) Mod 2 = 1 Then
b(j) = a(i)
j = j + 1
End If
Next i
For j = 1 To n Step 1
Form3.Print b(j)
Next j
End Sub
