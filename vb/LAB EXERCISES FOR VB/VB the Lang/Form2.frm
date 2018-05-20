VERSION 5.00
Begin VB.Form Form2 
   AutoRedraw      =   -1  'True
   Caption         =   "Form2"
   ClientHeight    =   4350
   ClientLeft      =   60
   ClientTop       =   450
   ClientWidth     =   6135
   BeginProperty Font 
      Name            =   "Times New Roman"
      Size            =   15.75
      Charset         =   0
      Weight          =   700
      Underline       =   0   'False
      Italic          =   0   'False
      Strikethrough   =   0   'False
   EndProperty
   LinkTopic       =   "Form2"
   ScaleHeight     =   4350
   ScaleWidth      =   6135
   StartUpPosition =   3  'Windows Default
End
Attribute VB_Name = "Form2"
Attribute VB_GlobalNameSpace = False
Attribute VB_Creatable = False
Attribute VB_PredeclaredId = True
Attribute VB_Exposed = False

Option Explicit
Dim str As String
Dim a(10) As Integer
Dim max As Integer
Dim min As Integer
Dim i As Integer
Private Sub Form_Load()
For i = 0 To 5 Step 1
str = InputBox("Enter Element:")
a(i) = CStr(str)
Next i

max = a(0)
For i = 1 To 5 Step 1
If max < a(i) Then
max = a(i)
End If
Next i

min = a(0)
For i = 1 To 5 Step 1
If min > a(i) Then
min = a(i)
End If
Next i

For i = 1 To 5 Step 1
Form2.Print a(i)
Next i

Form2.Print "Maximum Number Is:" + CStr(max)
Form2.Print "Minimum Number Is:" + CStr(min)
End Sub
