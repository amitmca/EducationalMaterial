VERSION 5.00
Begin VB.Form Form1 
   Caption         =   "Form1"
   ClientHeight    =   6750
   ClientLeft      =   60
   ClientTop       =   450
   ClientWidth     =   8745
   LinkTopic       =   "Form1"
   ScaleHeight     =   6750
   ScaleWidth      =   8745
   StartUpPosition =   3  'Windows Default
End
Attribute VB_Name = "Form1"
Attribute VB_GlobalNameSpace = False
Attribute VB_Creatable = False
Attribute VB_PredeclaredId = True
Attribute VB_Exposed = False
Private Sub Form_Load()
MsgBox "WELCOME"
End Sub

Private Sub Form_Unload(Cancel As Integer)
MsgBox "THANK YOU"
End Sub
