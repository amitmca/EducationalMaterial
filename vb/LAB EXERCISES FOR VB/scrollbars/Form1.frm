VERSION 5.00
Begin VB.Form Form1 
   BackColor       =   &H00C0C0FF&
   Caption         =   "Form1"
   ClientHeight    =   5085
   ClientLeft      =   60
   ClientTop       =   450
   ClientWidth     =   7440
   LinkTopic       =   "Form1"
   ScaleHeight     =   5085
   ScaleWidth      =   7440
   StartUpPosition =   3  'Windows Default
   Begin VB.TextBox Text2 
      Height          =   495
      Left            =   4920
      TabIndex        =   4
      Text            =   " "
      Top             =   2520
      Width           =   1335
   End
   Begin VB.VScrollBar VScroll1 
      Height          =   4095
      Left            =   6840
      Max             =   500
      TabIndex        =   3
      Top             =   840
      Width           =   495
   End
   Begin VB.TextBox Text1 
      Height          =   495
      Left            =   4920
      TabIndex        =   1
      Text            =   " "
      Top             =   1560
      Width           =   1335
   End
   Begin VB.HScrollBar HScroll1 
      Height          =   375
      Left            =   360
      Max             =   300
      TabIndex        =   0
      Top             =   840
      Width           =   6255
   End
   Begin VB.Label Label2 
      AutoSize        =   -1  'True
      BackColor       =   &H00C0FFFF&
      Caption         =   "VERTICAL SCROLL VALUE "
      BeginProperty Font 
         Name            =   "Times New Roman"
         Size            =   15.75
         Charset         =   0
         Weight          =   700
         Underline       =   0   'False
         Italic          =   0   'False
         Strikethrough   =   0   'False
      EndProperty
      ForeColor       =   &H00FF0000&
      Height          =   360
      Left            =   360
      TabIndex        =   5
      Top             =   2640
      Width           =   4455
   End
   Begin VB.Label Label1 
      AutoSize        =   -1  'True
      BackColor       =   &H00C0FFFF&
      Caption         =   "HORIZOTAL SCROLL VALUE"
      BeginProperty Font 
         Name            =   "Times New Roman"
         Size            =   15.75
         Charset         =   0
         Weight          =   700
         Underline       =   0   'False
         Italic          =   0   'False
         Strikethrough   =   0   'False
      EndProperty
      ForeColor       =   &H00FF0000&
      Height          =   360
      Left            =   360
      TabIndex        =   2
      Top             =   1680
      Width           =   4410
   End
End
Attribute VB_Name = "Form1"
Attribute VB_GlobalNameSpace = False
Attribute VB_Creatable = False
Attribute VB_PredeclaredId = True
Attribute VB_Exposed = False
Dim f As Integer
Dim f1 As Integer

Private Sub HScroll1_Change()
f = HScroll1.Value
Text1.Text = f
End Sub

Private Sub VScroll1_Change()
f1 = VScroll1.Value
Text2.Text = f1
End Sub
