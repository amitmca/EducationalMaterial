VERSION 5.00
Begin VB.Form Form2 
   BackColor       =   &H00C0FFFF&
   Caption         =   "Form2"
   ClientHeight    =   4680
   ClientLeft      =   60
   ClientTop       =   450
   ClientWidth     =   6990
   LinkTopic       =   "Form2"
   ScaleHeight     =   4680
   ScaleWidth      =   6990
   StartUpPosition =   3  'Windows Default
   Begin VB.Timer Timer1 
      Interval        =   150
      Left            =   240
      Top             =   3720
   End
   Begin VB.TextBox Text1 
      BackColor       =   &H00FFFFFF&
      Height          =   375
      Left            =   3240
      TabIndex        =   5
      Text            =   " "
      Top             =   2040
      Width           =   2415
   End
   Begin VB.CommandButton Command3 
      Caption         =   "EXIT"
      Height          =   495
      Left            =   4560
      TabIndex        =   3
      Top             =   3360
      Width           =   1095
   End
   Begin VB.CommandButton Command2 
      Caption         =   "STOP"
      Height          =   495
      Left            =   3120
      TabIndex        =   2
      Top             =   3360
      Width           =   1095
   End
   Begin VB.CommandButton Command1 
      Caption         =   "START"
      Height          =   495
      Left            =   1680
      TabIndex        =   1
      Top             =   3360
      Width           =   1095
   End
   Begin VB.HScrollBar HScroll1 
      Height          =   375
      Left            =   1080
      Max             =   120
      TabIndex        =   0
      Top             =   2760
      Width           =   5175
   End
   Begin VB.Label Label4 
      BackColor       =   &H00C0FFFF&
      Caption         =   "MAX"
      ForeColor       =   &H00FF00FF&
      Height          =   255
      Left            =   6000
      TabIndex        =   8
      Top             =   3240
      Width           =   375
   End
   Begin VB.Label Label3 
      BackColor       =   &H00C0FFFF&
      Caption         =   "MIN"
      ForeColor       =   &H00FF00FF&
      Height          =   255
      Left            =   960
      TabIndex        =   7
      Top             =   3240
      Width           =   495
   End
   Begin VB.Label Label2 
      AutoSize        =   -1  'True
      BackColor       =   &H00C0FFFF&
      Caption         =   "FACTOR"
      BeginProperty Font 
         Name            =   "Times New Roman"
         Size            =   14.25
         Charset         =   0
         Weight          =   700
         Underline       =   0   'False
         Italic          =   0   'False
         Strikethrough   =   0   'False
      EndProperty
      ForeColor       =   &H00FF0000&
      Height          =   330
      Left            =   1320
      TabIndex        =   6
      Top             =   2040
      Width           =   1215
   End
   Begin VB.Label Label1 
      AutoSize        =   -1  'True
      BackColor       =   &H00C0FFFF&
      Caption         =   "VIIT BARAMATI"
      BeginProperty Font 
         Name            =   "Times New Roman"
         Size            =   20.25
         Charset         =   0
         Weight          =   700
         Underline       =   0   'False
         Italic          =   0   'False
         Strikethrough   =   0   'False
      EndProperty
      ForeColor       =   &H000000FF&
      Height          =   465
      Left            =   360
      TabIndex        =   4
      Top             =   1200
      Width           =   3180
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
Command1.Enabled = False
Command2.Enabled = True
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
Command1.Enabled = False
Command2.Enabled = True
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
