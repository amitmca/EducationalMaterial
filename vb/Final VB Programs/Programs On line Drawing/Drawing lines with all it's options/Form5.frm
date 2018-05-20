VERSION 5.00
Begin VB.Form Form5 
   AutoRedraw      =   -1  'True
   Caption         =   "Form5"
   ClientHeight    =   3090
   ClientLeft      =   60
   ClientTop       =   450
   ClientWidth     =   4680
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
'Program to draw lines with all it's options
Option Explicit
Dim x1, y1, x2, y2


Private Sub Form_MouseDown(Button As Integer, Shift As Integer, X As Single, Y As Single)
x1 = X
y1 = Y

End Sub

Private Sub Form_MouseUp(Button As Integer, Shift As Integer, X As Single, Y As Single)
x2 = X
y2 = Y
Line (x1, y1)-(x2, y2), RGB(0, 0, 255), BF
End Sub
