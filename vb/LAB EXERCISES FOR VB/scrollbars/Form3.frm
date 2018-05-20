VERSION 5.00
Begin VB.Form Form3 
   Caption         =   "Form3"
   ClientHeight    =   5910
   ClientLeft      =   60
   ClientTop       =   450
   ClientWidth     =   7995
   LinkTopic       =   "Form3"
   ScaleHeight     =   5910
   ScaleWidth      =   7995
   StartUpPosition =   3  'Windows Default
   Begin VB.VScrollBar VScroll3 
      Height          =   4215
      Left            =   7200
      Max             =   255
      TabIndex        =   2
      Top             =   1080
      Width           =   375
   End
   Begin VB.VScrollBar VScroll2 
      Height          =   4215
      Left            =   3960
      Max             =   255
      TabIndex        =   1
      Top             =   1080
      Width           =   375
   End
   Begin VB.VScrollBar VScroll1 
      Height          =   4095
      Left            =   720
      Max             =   255
      TabIndex        =   0
      Top             =   1200
      Width           =   375
   End
   Begin VB.Label Label1 
      AutoSize        =   -1  'True
      BackColor       =   &H00FFFFC0&
      Caption         =   "SARANG"
      BeginProperty Font 
         Name            =   "Times New Roman"
         Size            =   14.25
         Charset         =   0
         Weight          =   700
         Underline       =   0   'False
         Italic          =   0   'False
         Strikethrough   =   0   'False
      EndProperty
      Height          =   330
      Left            =   3480
      TabIndex        =   3
      Top             =   480
      Width           =   1200
   End
End
Attribute VB_Name = "Form3"
Attribute VB_GlobalNameSpace = False
Attribute VB_Creatable = False
Attribute VB_PredeclaredId = True
Attribute VB_Exposed = False

Dim r, g, b As Integer



Private Sub VScroll1_Change()
r = VScroll1.Value
'g = VScroll1.Value
'b = VScroll1.Value
Label1.BackColor = RGB(r, 0, 0)
End Sub

Private Sub VScroll2_Change()
'r = VScroll2.Value
g = VScroll2.Value
'b = VScroll2.Value
Label1.BackColor = RGB(0, g, 0)
End Sub

Private Sub VScroll3_Change()
'r = VScroll3.Value
'g = VScroll3.Value
b = VScroll3.Value
Label1.BackColor = RGB(0, 0, b)
End Sub
