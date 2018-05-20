VERSION 5.00
Object = "{6B7E6392-850A-101B-AFC0-4210102A8DA7}#1.3#0"; "comctl32.ocx"
Begin VB.Form Form1 
   Caption         =   "Form1"
   ClientHeight    =   7785
   ClientLeft      =   60
   ClientTop       =   450
   ClientWidth     =   10110
   LinkTopic       =   "Form1"
   ScaleHeight     =   7785
   ScaleWidth      =   10110
   StartUpPosition =   3  'Windows Default
   Begin ComctlLib.ProgressBar ProgressBar1 
      Height          =   255
      Left            =   240
      TabIndex        =   0
      Top             =   7200
      Width           =   9735
      _ExtentX        =   17171
      _ExtentY        =   450
      _Version        =   327682
      Appearance      =   1
   End
   Begin VB.Timer Timer1 
      Interval        =   100
      Left            =   3840
      Top             =   2160
   End
End
Attribute VB_Name = "Form1"
Attribute VB_GlobalNameSpace = False
Attribute VB_Creatable = False
Attribute VB_PredeclaredId = True
Attribute VB_Exposed = False
Private Sub Form_Load()
Timer1.Enabled = True
End Sub

Private Sub Timer1_Timer()
ProgressBar1.Value = ProgressBar1 + 5
If ProgressBar1.Value = 100 Then
Form2.Visible = True
Form1.Visible = False
Timer1.Enabled = False
End If
End Sub
