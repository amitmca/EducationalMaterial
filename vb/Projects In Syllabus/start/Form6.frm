VERSION 5.00
Begin VB.Form Form6 
   AutoRedraw      =   -1  'True
   Caption         =   "Form6"
   ClientHeight    =   3090
   ClientLeft      =   60
   ClientTop       =   450
   ClientWidth     =   4680
   LinkTopic       =   "Form6"
   ScaleHeight     =   3090
   ScaleWidth      =   4680
   StartUpPosition =   3  'Windows Default
End
Attribute VB_Name = "Form6"
Attribute VB_GlobalNameSpace = False
Attribute VB_Creatable = False
Attribute VB_PredeclaredId = True
Attribute VB_Exposed = False
Dim str As String
Dim a(10) As Integer
Dim c As Integer
Dim i As Integer
Dim n As Integer
Dim ele As Integer
Private Sub Form_Load()

n = InputBox("How many elements:")
For i = 0 To n Step 1
str = InputBox("Enter array element:")
a(i) = CStr(str)
Next i

ele = InputBox("Enter the element to search:")
For i = 0 To n Step 1
If ele = a(i) Then
c = c + 1
End If
Next i
Form6.Print c
End Sub
