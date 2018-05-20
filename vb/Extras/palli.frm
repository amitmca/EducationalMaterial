VERSION 5.00
Begin VB.Form Form1 
   AutoRedraw      =   -1  'True
   Caption         =   "Form1"
   ClientHeight    =   4560
   ClientLeft      =   60
   ClientTop       =   450
   ClientWidth     =   6090
   LinkTopic       =   "Form1"
   ScaleHeight     =   4560
   ScaleWidth      =   6090
   StartUpPosition =   3  'Windows Default
End
Attribute VB_Name = "Form1"
Attribute VB_GlobalNameSpace = False
Attribute VB_Creatable = False
Attribute VB_PredeclaredId = True
Attribute VB_Exposed = False
Option Explicit
Dim rev As Integer
Dim r As Integer
Dim n As Integer
Dim t As Integer

Private Sub Form_Load()
rev = 0
r = 0
n = InputBox("Enter The Number:")
t = n
While n > 0
rev = r * 10
r = rev + n Mod 10
n = n / 10
Wend
If r = t Then
Form1.Print "PALLINDROME"
Else
Form1.Print "NOT PALLINDROME"
End If
End Sub
