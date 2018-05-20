VERSION 5.00
Begin VB.Form Form3 
   AutoRedraw      =   -1  'True
   Caption         =   "Form3"
   ClientHeight    =   5250
   ClientLeft      =   60
   ClientTop       =   450
   ClientWidth     =   7410
   LinkTopic       =   "Form3"
   ScaleHeight     =   5250
   ScaleWidth      =   7410
   StartUpPosition =   3  'Windows Default
   Begin VB.OptionButton Option3 
      BackColor       =   &H00C0FFFF&
      Caption         =   "GREEN"
      BeginProperty Font 
         Name            =   "Times New Roman"
         Size            =   14.25
         Charset         =   0
         Weight          =   700
         Underline       =   0   'False
         Italic          =   0   'False
         Strikethrough   =   0   'False
      EndProperty
      ForeColor       =   &H00FF0000&
      Height          =   495
      Left            =   5520
      TabIndex        =   2
      Top             =   1680
      Width           =   1455
   End
   Begin VB.OptionButton Option2 
      BackColor       =   &H00C0FFFF&
      Caption         =   "BLUE"
      BeginProperty Font 
         Name            =   "Times New Roman"
         Size            =   14.25
         Charset         =   0
         Weight          =   700
         Underline       =   0   'False
         Italic          =   0   'False
         Strikethrough   =   0   'False
      EndProperty
      ForeColor       =   &H00FF0000&
      Height          =   495
      Left            =   3000
      TabIndex        =   1
      Top             =   1680
      Width           =   1215
   End
   Begin VB.OptionButton Option1 
      BackColor       =   &H00C0FFFF&
      Caption         =   "RED"
      BeginProperty Font 
         Name            =   "Times New Roman"
         Size            =   14.25
         Charset         =   0
         Weight          =   700
         Underline       =   0   'False
         Italic          =   0   'False
         Strikethrough   =   0   'False
      EndProperty
      ForeColor       =   &H00FF0000&
      Height          =   495
      Left            =   360
      TabIndex        =   0
      Top             =   1680
      Width           =   1215
   End
End
Attribute VB_Name = "Form3"
Attribute VB_GlobalNameSpace = False
Attribute VB_Creatable = False
Attribute VB_PredeclaredId = True
Attribute VB_Exposed = False
Private Sub Option1_Click()
If Option1.Value = True Then
Form3.BackColor = RGB(255, 0, 0)
End If
End Sub

Private Sub Option2_Click()
If Option2.Value = True Then
Form3.BackColor = RGB(0, 255, 0)
End If
End Sub

Private Sub Option3_Click()
If Option3.Value = True Then
Form3.BackColor = RGB(0, 0, 255)
End If
End Sub
