VERSION 5.00
Begin VB.Form Form4 
   AutoRedraw      =   -1  'True
   Caption         =   "Form4"
   ClientHeight    =   4935
   ClientLeft      =   60
   ClientTop       =   450
   ClientWidth     =   6330
   LinkTopic       =   "Form4"
   ScaleHeight     =   4935
   ScaleWidth      =   6330
   StartUpPosition =   3  'Windows Default
   Begin VB.OptionButton Option3 
      Caption         =   "Option3"
      Height          =   495
      Left            =   3720
      TabIndex        =   2
      Top             =   1320
      Width           =   1095
   End
   Begin VB.OptionButton Option2 
      Caption         =   "Option2"
      Height          =   495
      Left            =   2520
      TabIndex        =   1
      Top             =   1320
      Width           =   1095
   End
   Begin VB.OptionButton Option1 
      Caption         =   "Option1"
      Height          =   495
      Left            =   1200
      TabIndex        =   0
      Top             =   1320
      Width           =   1095
   End
End
Attribute VB_Name = "Form4"
Attribute VB_GlobalNameSpace = False
Attribute VB_Creatable = False
Attribute VB_PredeclaredId = True
Attribute VB_Exposed = False
Private Sub Option1_Click()
If Option1.Value = True Then
Form4.BackColor = RGB(0, 0, 255)
End If
End Sub

Private Sub Option2_Click()
If Option2.Value = True Then
Form4.BackColor = RGB(0, 255, 0)
End If

End Sub

Private Sub Option3_Click()
If Option3.Value = True Then
Form4.BackColor = RGB(255, 0, 0)
End If

End Sub
