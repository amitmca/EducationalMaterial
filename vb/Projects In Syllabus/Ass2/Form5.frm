VERSION 5.00
Begin VB.Form Form5 
   Caption         =   "Form5"
   ClientHeight    =   3090
   ClientLeft      =   60
   ClientTop       =   450
   ClientWidth     =   4680
   LinkTopic       =   "Form5"
   ScaleHeight     =   3090
   ScaleWidth      =   4680
   StartUpPosition =   3  'Windows Default
   Begin VB.CommandButton Command1 
      Caption         =   " CLICK HERE"
      Height          =   495
      Left            =   840
      TabIndex        =   1
      Top             =   1560
      Width           =   2535
   End
   Begin VB.TextBox Text1 
      Height          =   495
      Left            =   120
      TabIndex        =   0
      Text            =   " "
      Top             =   600
      Width           =   4455
   End
End
Attribute VB_Name = "Form5"
Attribute VB_GlobalNameSpace = False
Attribute VB_Creatable = False
Attribute VB_PredeclaredId = True
Attribute VB_Exposed = False
Option Explicit
Dim n As Integer
Dim t As Integer
Dim r As Integer
Dim sum As Integer


Private Sub Command1_Click()

n = Val(Text1.Text)
t = n
While n > 0
r = n Mod 10
sum = sum + r * r * r
n = (n - r) / 10
Wend
If sum = t Then
MsgBox "Number is Armstrong"
Else
MsgBox "Number is not Armstrong"
End If
End Sub

Private Sub Form_Load()
r = 0
sum = 0

End Sub
