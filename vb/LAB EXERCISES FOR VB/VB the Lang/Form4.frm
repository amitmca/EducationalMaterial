VERSION 5.00
Begin VB.Form Form4 
   AutoRedraw      =   -1  'True
   BackColor       =   &H00C0FFC0&
   Caption         =   "Form4"
   ClientHeight    =   3090
   ClientLeft      =   60
   ClientTop       =   450
   ClientWidth     =   4680
   BeginProperty Font 
      Name            =   "MS Sans Serif"
      Size            =   13.5
      Charset         =   0
      Weight          =   700
      Underline       =   0   'False
      Italic          =   0   'False
      Strikethrough   =   0   'False
   EndProperty
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
Dim a(10) As Integer
Dim str As String
Dim i As Integer
Dim n As Integer
Dim s As Integer
Dim c As Integer
Private Sub Form_Load()
n = InputBox("How many numbers")
For i = 1 To n Step 1
str = InputBox("Enter the number")
a(i) = CStr(str)
Next i

c = 0
s = InputBox("Enter number to search")
For i = 1 To n Step 1
If s = a(i) Then
c = c + 1
End If
Next i

For i = 1 To n Step 1
Form4.Print a(i)
Next i
Form4.Print "Occured: " + CStr(c)
End Sub


