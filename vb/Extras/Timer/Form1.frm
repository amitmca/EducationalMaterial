VERSION 5.00
Begin VB.Form Form1 
   ClientHeight    =   4440
   ClientLeft      =   60
   ClientTop       =   450
   ClientWidth     =   5970
   FillColor       =   &H000000FF&
   ForeColor       =   &H000000FF&
   LinkTopic       =   "Form1"
   ScaleHeight     =   4440
   ScaleWidth      =   5970
   StartUpPosition =   3  'Windows Default
   Begin VB.Timer Timer1 
      Left            =   2880
      Top             =   1320
   End
   Begin VB.Label Label1 
      Alignment       =   2  'Center
      BackColor       =   &H00C0FFFF&
      Caption         =   "Label1"
      BeginProperty Font 
         Name            =   "Times New Roman"
         Size            =   20.25
         Charset         =   0
         Weight          =   700
         Underline       =   0   'False
         Italic          =   0   'False
         Strikethrough   =   0   'False
      EndProperty
      Height          =   495
      Left            =   105
      TabIndex        =   0
      Top             =   1320
      Width           =   1815
   End
End
Attribute VB_Name = "Form1"
Attribute VB_GlobalNameSpace = False
Attribute VB_Creatable = False
Attribute VB_PredeclaredId = True
Attribute VB_Exposed = False


Private Sub Form_Load()
Label1.Caption = Time$
End Sub

Private Sub Timer1_Timer()
Label1.Caption = Time$
If Label1.Left < Form1.ScaleWidth Then
Label1.Left = Label1.Left + 1000
Else
Label1.Left = 0
End If
End Sub


