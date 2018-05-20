VERSION 5.00
Begin VB.Form Form1 
   AutoRedraw      =   -1  'True
   Caption         =   "Form1"
   ClientHeight    =   5235
   ClientLeft      =   60
   ClientTop       =   450
   ClientWidth     =   6420
   BeginProperty Font 
      Name            =   "MS Sans Serif"
      Size            =   13.5
      Charset         =   0
      Weight          =   700
      Underline       =   0   'False
      Italic          =   0   'False
      Strikethrough   =   0   'False
   EndProperty
   LinkTopic       =   "Form1"
   ScaleHeight     =   5235
   ScaleWidth      =   6420
   StartUpPosition =   3  'Windows Default
End
Attribute VB_Name = "Form1"
Attribute VB_GlobalNameSpace = False
Attribute VB_Creatable = False
Attribute VB_PredeclaredId = True
Attribute VB_Exposed = False
Option Explicit
Dim a As Integer
Dim b As Integer
Private Sub Form_Load()
a = InputBox("Enter First Number:")
b = InputBox("Enter Second Number:")
Form1.Print a
Form1.Print b
End Sub
