VERSION 5.00
Begin VB.Form Form2 
   Caption         =   "Form2"
   ClientHeight    =   3090
   ClientLeft      =   60
   ClientTop       =   450
   ClientWidth     =   4680
   LinkTopic       =   "Form2"
   ScaleHeight     =   3090
   ScaleWidth      =   4680
   StartUpPosition =   3  'Windows Default
   Begin VB.Timer Timer1 
      Left            =   3000
      Top             =   840
   End
   Begin VB.Label Label1 
      Caption         =   "Label1"
      Height          =   495
      Left            =   240
      TabIndex        =   0
      Top             =   840
      Width           =   2175
   End
End
Attribute VB_Name = "Form2"
Attribute VB_GlobalNameSpace = False
Attribute VB_Creatable = False
Attribute VB_PredeclaredId = True
Attribute VB_Exposed = False
Private Sub Form_Load()
Label1.Left = Time$
End Sub

Private Sub Timer1_Timer()
Label1.Caption = Time$
Label1.Left = Label1.Left - 100
If Label1.Left > 0 Then
Label1.Left = Label1.Left - 100
Else
Label1.Left = ScaleWidth
End If
End Sub
