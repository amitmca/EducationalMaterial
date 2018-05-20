VERSION 5.00
Begin VB.Form Form2 
   Caption         =   "Form1"
   ClientHeight    =   3090
   ClientLeft      =   60
   ClientTop       =   450
   ClientWidth     =   4680
   LinkTopic       =   "Form1"
   ScaleHeight     =   3090
   ScaleWidth      =   4680
   StartUpPosition =   3  'Windows Default
   Begin VB.TextBox Text1 
      Height          =   615
      Left            =   2520
      TabIndex        =   1
      Top             =   840
      Width           =   1215
   End
   Begin VB.CommandButton Command1 
      Caption         =   "Show"
      Height          =   735
      Left            =   360
      TabIndex        =   0
      Top             =   600
      Width           =   1215
   End
End
Attribute VB_Name = "Form2"
Attribute VB_GlobalNameSpace = False
Attribute VB_Creatable = False
Attribute VB_PredeclaredId = True
Attribute VB_Exposed = False

Option Explicit
Dim a As Integer
Private Sub Command1_Click()
Debug.Print "output"
For a = 0 To Val(Text1.Text)
Debug.Print a
Next a
End Sub

