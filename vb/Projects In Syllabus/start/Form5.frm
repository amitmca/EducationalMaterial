VERSION 5.00
Begin VB.Form Form5 
   AutoRedraw      =   -1  'True
   Caption         =   "Form5"
   ClientHeight    =   3090
   ClientLeft      =   60
   ClientTop       =   450
   ClientWidth     =   4680
   LinkTopic       =   "Form5"
   ScaleHeight     =   3090
   ScaleWidth      =   4680
   StartUpPosition =   3  'Windows Default
End
Attribute VB_Name = "Form5"
Attribute VB_GlobalNameSpace = False
Attribute VB_Creatable = False
Attribute VB_PredeclaredId = True
Attribute VB_Exposed = False
Option Explicit
Dim i As Integer
Dim a(10) As Integer
Dim str As String
Dim n As Integer
Dim max As Integer
Dim min As Integer

Private Sub Form_Load()
n = InputBox("How many elements :")

For i = 0 To n Step 1
str = InputBox("Enter array element:")
a(i) = CStr(str)
Next i
Form5.Print "The Array elements are...."
For i = 0 To n Step 1
Form5.Print a(i)
Next i

max = a(0)
For i = 1 To n Step 1
If max < a(i) Then
max = a(i)
End If
Next i
Form5.Print "The Maximum element is:"
Form5.Print max

min = a(0)
For i = 1 To n Step 1
If min > a(i) Then
min = a(i)
End If
Next i
Form5.Print "The Minimum element is:"
Form5.Print min
End Sub
