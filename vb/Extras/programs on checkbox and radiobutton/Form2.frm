VERSION 5.00
Begin VB.Form Form2 
   AutoRedraw      =   -1  'True
   Caption         =   "Form2"
   ClientHeight    =   3090
   ClientLeft      =   60
   ClientTop       =   450
   ClientWidth     =   4680
   LinkTopic       =   "Form2"
   ScaleHeight     =   3090
   ScaleWidth      =   4680
   StartUpPosition =   3  'Windows Default
   Begin VB.OptionButton Option3 
      Caption         =   "Option3"
      Height          =   495
      Left            =   2640
      TabIndex        =   2
      Top             =   360
      Width           =   1215
   End
   Begin VB.OptionButton Option2 
      Caption         =   "Option2"
      Height          =   495
      Left            =   1440
      TabIndex        =   1
      Top             =   360
      Width           =   1095
   End
   Begin VB.OptionButton Option1 
      Caption         =   "Option1"
      Height          =   495
      Left            =   120
      TabIndex        =   0
      Top             =   360
      Width           =   1215
   End
End
Attribute VB_Name = "Form2"
Attribute VB_GlobalNameSpace = False
Attribute VB_Creatable = False
Attribute VB_PredeclaredId = True
Attribute VB_Exposed = False
Private Sub Option1_Click()
If Option1.Value = True Then
Form2.BackColor = RGB(0, 0, 255)
End If

End Sub

Private Sub Option2_Click()
If Option2.Value = True Then
Form2.BackColor = RGB(0, 255, 0)
End If
End Sub

Private Sub Option3_Click()
If Option3.Value = True Then
Form2.BackColor = RGB(255, 0, 0)
End If
End Sub
