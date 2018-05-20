VERSION 5.00
Begin VB.Form Form5 
   AutoRedraw      =   -1  'True
   BackColor       =   &H00FFC0FF&
   Caption         =   "Form5"
   ClientHeight    =   3090
   ClientLeft      =   60
   ClientTop       =   450
   ClientWidth     =   4680
   BeginProperty Font 
      Name            =   "Times New Roman"
      Size            =   15.75
      Charset         =   0
      Weight          =   700
      Underline       =   0   'False
      Italic          =   0   'False
      Strikethrough   =   0   'False
   EndProperty
   ForeColor       =   &H00FF0000&
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
Dim a As Integer
Dim b As Integer
Dim c As Integer
Dim i As Integer
Dim n As Integer
Private Sub Form_load()
a = 0
b = 1
n = InputBox("HOW MANY TERMS:")
Form5.Print a
For i = 1 To n Step 1
c = a + b
Form5.Print b
a = b
b = c
Next i
End Sub
