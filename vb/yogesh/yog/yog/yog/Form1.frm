VERSION 5.00
Begin VB.Form Form1 
   Caption         =   "Form1"
   ClientHeight    =   4860
   ClientLeft      =   60
   ClientTop       =   450
   ClientWidth     =   7485
   LinkTopic       =   "Form1"
   ScaleHeight     =   4860
   ScaleWidth      =   7485
   StartUpPosition =   3  'Windows Default
   Begin VB.CommandButton Command2 
      Caption         =   "Save Picture"
      Height          =   735
      Left            =   2760
      TabIndex        =   2
      Top             =   3840
      Width           =   1815
   End
   Begin VB.PictureBox Picture1 
      AutoRedraw      =   -1  'True
      Height          =   1455
      Left            =   480
      ScaleHeight     =   1395
      ScaleWidth      =   2235
      TabIndex        =   1
      Top             =   240
      Width           =   2295
   End
   Begin VB.CommandButton Command1 
      Caption         =   "Load Pictures"
      Height          =   735
      Left            =   1320
      TabIndex        =   0
      Top             =   3840
      Width           =   1095
   End
   Begin VB.Timer Timer1 
      Interval        =   1000
      Left            =   6960
      Top             =   1320
   End
   Begin VB.Shape Shape1 
      BackColor       =   &H00FFFFFF&
      BackStyle       =   1  'Opaque
      BorderColor     =   &H00C0C0FF&
      BorderStyle     =   6  'Inside Solid
      BorderWidth     =   5
      FillColor       =   &H00FF8080&
      FillStyle       =   7  'Diagonal Cross
      Height          =   2415
      Left            =   3480
      Shape           =   2  'Oval
      Top             =   840
      Width           =   2895
   End
End
Attribute VB_Name = "Form1"
Attribute VB_GlobalNameSpace = False
Attribute VB_Creatable = False
Attribute VB_PredeclaredId = True
Attribute VB_Exposed = False
Option Explicit
Dim counter As Integer
Dim x1, x2 As Integer
Dim y1, y2 As Integer

Private Sub Command2_Click()
save.picture1(picture1,"C:\images\one.jpg")

End Sub

Private Sub Form_Load()
counter = 0
End Sub

Private Sub Picture1_MouseDown(Button As Integer, Shift As Integer, x As Single, Y As Single)
x1 = x
y1 = Y

End Sub


Private Sub Picture1_MouseUp(Button As Integer, Shift As Integer, x As Single, Y As Single)
x2 = x
y2 = Y
Picture1.Line (x1, y1)-(x2, y2)

End Sub

Private Sub Timer1_Timer()
counter = counter + 1
If counter < 7 Then
Shape1.FillStyle = counter
Else
counter = 0
End If

End Sub
