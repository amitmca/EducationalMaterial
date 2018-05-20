VERSION 5.00
Begin VB.Form Form1 
   Caption         =   "Form1"
   ClientHeight    =   6345
   ClientLeft      =   60
   ClientTop       =   450
   ClientWidth     =   8160
   LinkTopic       =   "Form1"
   ScaleHeight     =   6345
   ScaleWidth      =   8160
   StartUpPosition =   3  'Windows Default
   Begin VB.CommandButton Command1 
      Caption         =   "OK"
      Height          =   735
      Left            =   2760
      TabIndex        =   0
      Top             =   2400
      Width           =   3375
   End
End
Attribute VB_Name = "Form1"
Attribute VB_GlobalNameSpace = False
Attribute VB_Creatable = False
Attribute VB_PredeclaredId = True
Attribute VB_Exposed = False
Private Sub Command1_Click()
If Command1.Caption = "OK" Then
Command1.Caption = "KO"
ElseIf Command1.Caption = "KO" Then
Command1.Caption = "OK"
End If
End Sub

