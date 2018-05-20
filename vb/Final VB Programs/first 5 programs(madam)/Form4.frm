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
      Caption         =   "ADD"
      Height          =   615
      Left            =   960
      TabIndex        =   2
      Top             =   1200
      Width           =   2415
   End
   Begin VB.ComboBox Combo1 
      Height          =   315
      Left            =   960
      TabIndex        =   1
      Text            =   " "
      Top             =   2040
      Width           =   2535
   End
   Begin VB.TextBox Text1 
      Height          =   495
      Left            =   960
      TabIndex        =   0
      Text            =   " "
      Top             =   480
      Width           =   2415
   End
End
Attribute VB_Name = "Form5"
Attribute VB_GlobalNameSpace = False
Attribute VB_Creatable = False
Attribute VB_PredeclaredId = True
Attribute VB_Exposed = False
Private Sub Command1_Click()
Combo1.Text = Text1.Text
Text1.Text = " "
Text1.SetFocus
End Sub

