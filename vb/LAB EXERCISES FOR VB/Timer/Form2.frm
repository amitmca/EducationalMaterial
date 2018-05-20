VERSION 5.00
Begin VB.Form Form1 
   Caption         =   "Form1"
   ClientHeight    =   5460
   ClientLeft      =   60
   ClientTop       =   450
   ClientWidth     =   8085
   LinkTopic       =   "Form1"
   ScaleHeight     =   5460
   ScaleWidth      =   8085
   StartUpPosition =   3  'Windows Default
   Begin VB.Timer Timer1 
      Interval        =   500
      Left            =   4440
      Top             =   1800
   End
   Begin VB.Shape Shape6 
      Height          =   4095
      Left            =   2280
      Top             =   240
      Width           =   1455
   End
   Begin VB.Shape Shape5 
      BackColor       =   &H008080FF&
      Height          =   4575
      Left            =   2880
      Top             =   4320
      Width           =   255
   End
   Begin VB.Shape Shape4 
      BackColor       =   &H0080FFFF&
      BackStyle       =   1  'Opaque
      Height          =   855
      Left            =   2520
      Shape           =   3  'Circle
      Top             =   3000
      Width           =   855
   End
   Begin VB.Shape Shape3 
      BackColor       =   &H0000FF00&
      BackStyle       =   1  'Opaque
      Height          =   855
      Left            =   2400
      Shape           =   3  'Circle
      Top             =   1920
      Width           =   1095
   End
   Begin VB.Shape Shape2 
      BackColor       =   &H000000FF&
      BackStyle       =   1  'Opaque
      Height          =   855
      Left            =   2520
      Shape           =   3  'Circle
      Top             =   600
      Width           =   855
   End
   Begin VB.Shape Shape1 
      Height          =   3855
      Left            =   2400
      Top             =   360
      Width           =   1215
   End
End
Attribute VB_Name = "Form1"
Attribute VB_GlobalNameSpace = False
Attribute VB_Creatable = False
Attribute VB_PredeclaredId = True
Attribute VB_Exposed = False

Dim c As Integer

Private Sub Timer1_Timer()
c = 0
While c <= 15
If c >= 0 And c <= 5 Then
Shape2.Visible = True
Shape3.Visible = False
Shape4.Visible = False
Else
If c >= 5 And c <= 10 Then
Shape2.Visible = False
Shape3.Visible = True
Shape4.Visible = False
Else
If c >= 10 And c <= 15 Then
Shape2.Visible = False
Shape3.Visible = False
Shape4.Visible = True
End If
End If
c = c + 1
Wend
If c > 15 Then
c = 0
End If
End Sub

