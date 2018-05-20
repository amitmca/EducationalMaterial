VERSION 5.00
Begin VB.Form Form5 
   Caption         =   "Form5"
   ClientHeight    =   4770
   ClientLeft      =   60
   ClientTop       =   450
   ClientWidth     =   7275
   LinkTopic       =   "Form5"
   ScaleHeight     =   4770
   ScaleWidth      =   7275
   StartUpPosition =   3  'Windows Default
   Begin VB.CommandButton Command2 
      Caption         =   "DELETE"
      Height          =   495
      Left            =   3960
      TabIndex        =   3
      Top             =   1320
      Width           =   1335
   End
   Begin VB.CommandButton Command1 
      Caption         =   "ADD"
      Height          =   495
      Left            =   1680
      TabIndex        =   2
      Top             =   1320
      Width           =   1455
   End
   Begin VB.ComboBox Combo1 
      Height          =   315
      Left            =   3840
      TabIndex        =   1
      Text            =   " "
      Top             =   480
      Width           =   2415
   End
   Begin VB.TextBox Text1 
      Height          =   375
      Left            =   840
      TabIndex        =   0
      Text            =   " "
      Top             =   480
      Width           =   2655
   End
End
Attribute VB_Name = "Form5"
Attribute VB_GlobalNameSpace = False
Attribute VB_Creatable = False
Attribute VB_PredeclaredId = True
Attribute VB_Exposed = False

Private Sub Command1_Click()
Combo1.AddItem (Text1.Text)
 Text1.Text = " "
 Text1.SetFocus

End Sub

Private Sub Command2_Click()
Combo1.RemoveItem (Selected)
End Sub
