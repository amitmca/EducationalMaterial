VERSION 5.00
Begin VB.Form Form3 
   Caption         =   "Form3"
   ClientHeight    =   3090
   ClientLeft      =   60
   ClientTop       =   450
   ClientWidth     =   4680
   LinkTopic       =   "Form3"
   ScaleHeight     =   3090
   ScaleWidth      =   4680
   StartUpPosition =   3  'Windows Default
   Begin VB.TextBox Text2 
      Height          =   495
      Left            =   120
      TabIndex        =   2
      Text            =   " "
      Top             =   1080
      Width           =   1935
   End
   Begin VB.CommandButton Command1 
      Caption         =   "GET FACTORIAL"
      Height          =   495
      Left            =   2520
      TabIndex        =   1
      Top             =   720
      Width           =   1935
   End
   Begin VB.TextBox Text1 
      Height          =   495
      Left            =   120
      TabIndex        =   0
      Text            =   " "
      Top             =   240
      Width           =   1935
   End
End
Attribute VB_Name = "Form3"
Attribute VB_GlobalNameSpace = False
Attribute VB_Creatable = False
Attribute VB_PredeclaredId = True
Attribute VB_Exposed = False
Option Explicit
Dim n As Integer
Dim f As Integer
Dim i As Integer

Private Sub Command1_Click()
n = Val(Text1.Text)
f = 1
For i = 1 To n Step 1
f = f * i
Next i
Text2.Text = f




End Sub

