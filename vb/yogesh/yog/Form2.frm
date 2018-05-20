VERSION 5.00
Begin VB.Form Form2 
   Caption         =   "Form2"
   ClientHeight    =   3090
   ClientLeft      =   60
   ClientTop       =   450
   ClientWidth     =   4680
   LinkTopic       =   "Form2"
   ScaleHeight     =   3090
   ScaleWidth      =   4680
   StartUpPosition =   3  'Windows Default
End
Attribute VB_Name = "Form2"
Attribute VB_GlobalNameSpace = False
Attribute VB_Creatable = False
Attribute VB_PredeclaredId = True
Attribute VB_Exposed = False
Option Explicit
Dim xval, yval
Dim counter As Integer


Private Sub Form2_Load()
counter = 0
Form2.AutoRedraw = True
Form2.DrawWidth = 1


End Sub

Private Sub Form_MouseDown(Button As Integer, Shift As Integer, X As Single, Y As Single)
For counter = 0 To 6
yval = yval + 500
Form2.DrawStyle = counter
Line (100, yval)-(2000, yval), RGB(0, 0, 255)

Next
End Sub
