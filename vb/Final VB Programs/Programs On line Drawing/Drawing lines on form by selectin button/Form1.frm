VERSION 5.00
Begin VB.Form Form1 
   Caption         =   "Form1"
   ClientHeight    =   5025
   ClientLeft      =   60
   ClientTop       =   450
   ClientWidth     =   6435
   DrawWidth       =   4
   LinkTopic       =   "Form1"
   ScaleHeight     =   5025
   ScaleWidth      =   6435
   StartUpPosition =   3  'Windows Default
   Begin VB.CommandButton Command4 
      Caption         =   " EXIT"
      Height          =   495
      Left            =   240
      TabIndex        =   3
      Top             =   2520
      Width           =   2175
   End
   Begin VB.CommandButton Command3 
      Caption         =   " BLUE"
      Height          =   495
      Left            =   240
      TabIndex        =   2
      Top             =   1800
      Width           =   2175
   End
   Begin VB.CommandButton Command2 
      Caption         =   " GREEN"
      Height          =   495
      Left            =   240
      TabIndex        =   1
      Top             =   1080
      Width           =   2175
   End
   Begin VB.CommandButton Command1 
      Caption         =   " RED"
      Height          =   495
      Left            =   240
      TabIndex        =   0
      Top             =   360
      Width           =   2175
   End
End
Attribute VB_Name = "Form1"
Attribute VB_GlobalNameSpace = False
Attribute VB_Creatable = False
Attribute VB_PredeclaredId = True
Attribute VB_Exposed = False
'program to draw various lines on form by selecting appropriate button
'Using drawsytle property
Option Explicit
Dim rf As Boolean
Dim gf As Boolean
Dim bf As Boolean

Private Sub Command1_Click()
rf = True
gf = False
bf = False
End Sub

Private Sub Command2_Click()
rf = False
gf = True
bf = False
End Sub

Private Sub Command3_Click()
rf = False
gf = False
bf = True
End Sub

Private Sub Command4_Click()
End
End Sub


Private Sub Form_Load()
Form1.AutoRedraw = True
rf = gf = bf = False
End Sub

Private Sub Form_MouseMove(Button As Integer, Shift As Integer, X As Single, Y As Single)
If rf = True Then
Line (X, Y)-(X, Y), RGB(255, 0, 0)
ElseIf gf = True Then
Line (X, Y)-(X, Y), RGB(0, 255, 0)
ElseIf bf = True Then
Line (X, Y)-(X, Y), RGB(0, 0, 255)
End If
End Sub


