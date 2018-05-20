VERSION 5.00
Begin VB.Form Form4 
   Caption         =   "Form4"
   ClientHeight    =   3090
   ClientLeft      =   60
   ClientTop       =   450
   ClientWidth     =   4680
   LinkTopic       =   "Form4"
   ScaleHeight     =   3090
   ScaleWidth      =   4680
   StartUpPosition =   3  'Windows Default
   Begin VB.CommandButton Command1 
      Caption         =   " CLICK HERE"
      Height          =   375
      Left            =   2760
      TabIndex        =   1
      Top             =   480
      Width           =   1575
   End
   Begin VB.TextBox Text1 
      Height          =   615
      Left            =   120
      TabIndex        =   0
      Text            =   " "
      Top             =   360
      Width           =   2295
   End
End
Attribute VB_Name = "Form4"
Attribute VB_GlobalNameSpace = False
Attribute VB_Creatable = False
Attribute VB_PredeclaredId = True
Attribute VB_Exposed = False
Option Explicit
Dim n As Integer

Private Sub Command1_Click()
n = Val(Text1.Text)
If n Mod 2 = 0 Then
MsgBox "Number is Even"
Else
MsgBox "Number is odd"
End If

End Sub

Private Sub Form_Load()

End Sub
