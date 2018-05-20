VERSION 5.00
Begin VB.Form Form9 
   AutoRedraw      =   -1  'True
   Caption         =   "Form9"
   ClientHeight    =   3090
   ClientLeft      =   60
   ClientTop       =   450
   ClientWidth     =   4680
   LinkTopic       =   "Form9"
   ScaleHeight     =   3090
   ScaleWidth      =   4680
   StartUpPosition =   3  'Windows Default
End
Attribute VB_Name = "Form9"
Attribute VB_GlobalNameSpace = False
Attribute VB_Creatable = False
Attribute VB_PredeclaredId = True
Attribute VB_Exposed = False
Dim n As Integer

Private Sub Form_Load()
n = InputBox("Enter the number to check:")
If n Mod 2 = 0 Then
Form9.Print "Number is even"
Else
Form9.Print "Number is odd"
End If
End Sub
