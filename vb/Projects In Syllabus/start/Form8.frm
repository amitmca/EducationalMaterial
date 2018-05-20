VERSION 5.00
Begin VB.Form Form8 
   AutoRedraw      =   -1  'True
   Caption         =   "Form8"
   ClientHeight    =   3090
   ClientLeft      =   60
   ClientTop       =   450
   ClientWidth     =   4680
   LinkTopic       =   "Form8"
   ScaleHeight     =   3090
   ScaleWidth      =   4680
   StartUpPosition =   3  'Windows Default
End
Attribute VB_Name = "Form8"
Attribute VB_GlobalNameSpace = False
Attribute VB_Creatable = False
Attribute VB_PredeclaredId = True
Attribute VB_Exposed = False
Option Explicit
Dim user As String
Dim pass As String
Private Sub Form_Load()
user = InputBox("ENTER USER NAME:")
pass = InputBox("ENTER THE PASSWORD")

If user = "scott" And pass = "tiger" Then
Form8.Print "SQL>"
Else
MsgBox "Access Denied,check user name and password"
End If
End Sub
