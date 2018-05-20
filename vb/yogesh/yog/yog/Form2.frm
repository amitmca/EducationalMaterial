VERSION 5.00
Begin VB.Form Form2 
   AutoRedraw      =   -1  'True
   Caption         =   "Form2"
   ClientHeight    =   4845
   ClientLeft      =   60
   ClientTop       =   450
   ClientWidth     =   8640
   LinkTopic       =   "Form2"
   ScaleHeight     =   4845
   ScaleWidth      =   8640
   StartUpPosition =   3  'Windows Default
   WindowState     =   2  'Maximized
   Begin VB.PictureBox Picture1 
      AutoRedraw      =   -1  'True
      BackColor       =   &H00FFFFFF&
      Height          =   1815
      Left            =   360
      Picture         =   "Form2.frx":0000
      ScaleHeight     =   1755
      ScaleWidth      =   2475
      TabIndex        =   9
      Top             =   480
      Width           =   2535
   End
   Begin VB.CommandButton Command3 
      Caption         =   "Exit"
      Height          =   495
      Left            =   3360
      TabIndex        =   8
      Top             =   3480
      Width           =   1095
   End
   Begin VB.CommandButton Command2 
      Caption         =   "Stop"
      Height          =   495
      Left            =   4680
      TabIndex        =   7
      Top             =   3480
      Width           =   1575
   End
   Begin VB.CommandButton Command1 
      Caption         =   "Start"
      Height          =   495
      Left            =   1560
      TabIndex        =   6
      Top             =   3480
      Width           =   1455
   End
   Begin VB.TextBox Text1 
      Height          =   375
      Left            =   6000
      TabIndex        =   2
      Top             =   360
      Width           =   1335
   End
   Begin VB.HScrollBar HScroll1 
      Height          =   615
      Left            =   1680
      Max             =   500
      TabIndex        =   1
      Top             =   2520
      Width           =   11175
   End
   Begin VB.Timer Timer1 
      Interval        =   100
      Left            =   3840
      Top             =   1080
   End
   Begin VB.Label Label4 
      Caption         =   "Label4"
      Height          =   255
      Left            =   12960
      TabIndex        =   5
      Top             =   2280
      Width           =   975
   End
   Begin VB.Label Label3 
      AutoSize        =   -1  'True
      Caption         =   "Label3"
      Height          =   195
      Left            =   960
      TabIndex        =   4
      Top             =   2760
      Width           =   480
   End
   Begin VB.Label Label2 
      AutoSize        =   -1  'True
      Caption         =   "factor"
      BeginProperty Font 
         Name            =   "MS Sans Serif"
         Size            =   12
         Charset         =   0
         Weight          =   400
         Underline       =   0   'False
         Italic          =   0   'False
         Strikethrough   =   0   'False
      EndProperty
      Height          =   300
      Left            =   5280
      TabIndex        =   3
      Top             =   360
      Width           =   615
   End
   Begin VB.Label Label1 
      AutoSize        =   -1  'True
      Caption         =   "YOGESH & AMIT"
      BeginProperty Font 
         Name            =   "MS Sans Serif"
         Size            =   18
         Charset         =   0
         Weight          =   400
         Underline       =   0   'False
         Italic          =   0   'False
         Strikethrough   =   0   'False
      EndProperty
      ForeColor       =   &H000000FF&
      Height          =   435
      Left            =   3360
      TabIndex        =   0
      Top             =   1680
      Width           =   2565
   End
End
Attribute VB_Name = "Form2"
Attribute VB_GlobalNameSpace = False
Attribute VB_Creatable = False
Attribute VB_PredeclaredId = True
Attribute VB_Exposed = False
Option Explicit
Dim factor As Integer

Private Sub Command1_Click()
Timer1.Enabled = True
Command2.Enabled = True
Command1.Enabled = False
End Sub

Private Sub Command2_Click()
Timer1.Enabled = False
Command1.Enabled = True
Command2.Enabled = False
End Sub

Private Sub Command3_Click()
End
End Sub

Private Sub Form_Load()
Command2.Enabled = True
Command1.Enabled = False
Label1.Left = 0
Label3.Caption = HScroll1.Min
Label4.Caption = HScroll1.Max

End Sub

Private Sub Timer1_Timer()
factor = HScroll1.Value
Text1.Text = factor
If Label1.Left < Form2.ScaleWidth Then
Label1.Left = Label1.Left + factor
Else
Label1.Left = 0
End If
End Sub

