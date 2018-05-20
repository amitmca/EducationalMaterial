VERSION 5.00
Begin VB.Form Form1 
   BackColor       =   &H00C0E0FF&
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
      Left            =   2760
      TabIndex        =   1
      Top             =   720
      Width           =   1815
   End
   Begin VB.CommandButton Command1 
      BackColor       =   &H00C0C0FF&
      Caption         =   "Show"
      Height          =   855
      Left            =   360
      MaskColor       =   &H00FFFFFF&
      Style           =   1  'Graphical
      TabIndex        =   0
      Top             =   480
      Width           =   1695
   End
End
Attribute VB_Name = "Form1"
Attribute VB_GlobalNameSpace = False
Attribute VB_Creatable = False
Attribute VB_PredeclaredId = True
Attribute VB_Exposed = False
Option Explicit
Dim s As String
Dim a As Integer

Private Sub Command1_Click()
's = Text1.Text
'MsgBox s
'a = CInt(s)
If Val(Text1.Text) Mod 2 = 0 Then
MsgBox "number is even"
Else
MsgBox "number is odd"
End If


End Sub
