VERSION 5.00
Begin VB.Form Form3 
   Caption         =   "Form3"
   ClientHeight    =   3090
   ClientLeft      =   60
   ClientTop       =   450
   ClientWidth     =   4680
   LinkTopic       =   "Form3"
   ScaleHeight     =   3090
   ScaleWidth      =   4680
   StartUpPosition =   3  'Windows Default
End
Attribute VB_Name = "Form3"
Attribute VB_GlobalNameSpace = False
Attribute VB_Creatable = False
Attribute VB_PredeclaredId = True
Attribute VB_Exposed = False
Dim c
Dim a As Integer
Private Sub Form_Load()
c = InputBox("Character:")
a = Asc(c)
If a >= 65 And a <= 123 Then
MsgBox "ALPHABET"
ElseIf a >= 48 And a <= 57 Then
MsgBox "NUMBER"
Else
MsgBox "SPECIAL SYMBOL"
End If
End
End Sub
