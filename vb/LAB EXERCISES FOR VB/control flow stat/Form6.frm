VERSION 5.00
Begin VB.Form Form6 
   AutoRedraw      =   -1  'True
   BackColor       =   &H00C0FFC0&
   Caption         =   "Form6"
   ClientHeight    =   3090
   ClientLeft      =   60
   ClientTop       =   450
   ClientWidth     =   4680
   BeginProperty Font 
      Name            =   "Times New Roman"
      Size            =   24
      Charset         =   0
      Weight          =   400
      Underline       =   0   'False
      Italic          =   0   'False
      Strikethrough   =   0   'False
   EndProperty
   ForeColor       =   &H000000FF&
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
Option Explicit
Dim n As Integer
Dim i As Integer
Dim p As Integer

Private Sub Form_Load()
p = 0
n = InputBox("NUMBER:")
For i = 2 To n / 2 Step 1
If n Mod i = 0 Then
p = p + 1
End If
Next i
If p = 0 Then
Form6.Print "PRIME"
Else
Form6.Print "NOT PRIME"
End If

End Sub
