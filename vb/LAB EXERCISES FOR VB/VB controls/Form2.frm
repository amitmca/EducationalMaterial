VERSION 5.00
Begin VB.Form Form2 
   Caption         =   "Form2"
   ClientHeight    =   5805
   ClientLeft      =   60
   ClientTop       =   450
   ClientWidth     =   8370
   LinkTopic       =   "Form2"
   ScaleHeight     =   5805
   ScaleWidth      =   8370
   StartUpPosition =   3  'Windows Default
   Begin VB.CommandButton Command1 
      Caption         =   "Command1"
      Height          =   495
      Left            =   2640
      TabIndex        =   2
      Top             =   3120
      Width           =   1815
   End
   Begin VB.TextBox Text1 
      Height          =   615
      Left            =   3840
      TabIndex        =   0
      Text            =   " "
      Top             =   1800
      Width           =   3975
   End
   Begin VB.Label Label1 
      AutoSize        =   -1  'True
      BackColor       =   &H00C0E0FF&
      Caption         =   "Label1"
      BeginProperty Font 
         Name            =   "Times New Roman"
         Size            =   15.75
         Charset         =   0
         Weight          =   700
         Underline       =   0   'False
         Italic          =   0   'False
         Strikethrough   =   0   'False
      EndProperty
      ForeColor       =   &H00FF00FF&
      Height          =   360
      Left            =   240
      TabIndex        =   1
      Top             =   1920
      Width           =   930
   End
End
Attribute VB_Name = "Form2"
Attribute VB_GlobalNameSpace = False
Attribute VB_Creatable = False
Attribute VB_PredeclaredId = True
Attribute VB_Exposed = False
Option Explicit

Private Sub Command1_Click()
Label1.Caption = Text1.SelText
End Sub

