VERSION 5.00
Begin VB.Form Form2 
   Caption         =   "Form2"
   ClientHeight    =   5775
   ClientLeft      =   60
   ClientTop       =   450
   ClientWidth     =   8115
   LinkTopic       =   "Form2"
   ScaleHeight     =   5775
   ScaleWidth      =   8115
   StartUpPosition =   3  'Windows Default
   Begin VB.CommandButton Command1 
      BackColor       =   &H00000000&
      Height          =   735
      Left            =   3360
      Style           =   1  'Graphical
      TabIndex        =   0
      Top             =   2280
      Width           =   615
   End
   Begin VB.Label Label1 
      AutoSize        =   -1  'True
      BackColor       =   &H00C0FFC0&
      Caption         =   "SAVE"
      BeginProperty Font 
         Name            =   "Times New Roman"
         Size            =   12
         Charset         =   0
         Weight          =   700
         Underline       =   0   'False
         Italic          =   0   'False
         Strikethrough   =   0   'False
      EndProperty
      ForeColor       =   &H00FF0000&
      Height          =   285
      Left            =   3360
      TabIndex        =   1
      Top             =   3000
      Width           =   615
   End
End
Attribute VB_Name = "Form2"
Attribute VB_GlobalNameSpace = False
Attribute VB_Creatable = False
Attribute VB_PredeclaredId = True
Attribute VB_Exposed = False
Private Sub Command1_Click()
Command1.Picture = LoadPicture("D:\My  Programs\VB\LAB EXERCISES FOR VB\command box\save.jpg")

End Sub
