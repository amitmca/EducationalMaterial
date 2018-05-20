VERSION 5.00
Begin VB.Form Form3 
   BackColor       =   &H00FFC0C0&
   Caption         =   "Form3"
   ClientHeight    =   5910
   ClientLeft      =   60
   ClientTop       =   450
   ClientWidth     =   7380
   LinkTopic       =   "Form3"
   ScaleHeight     =   5910
   ScaleWidth      =   7380
   StartUpPosition =   3  'Windows Default
   Begin VB.Timer Timer1 
      Interval        =   1000
      Left            =   3000
      Top             =   2280
   End
   Begin VB.TextBox Text1 
      BackColor       =   &H00FFFFFF&
      Height          =   495
      Left            =   1920
      Locked          =   -1  'True
      TabIndex        =   0
      Text            =   " "
      Top             =   960
      Width           =   2775
   End
End
Attribute VB_Name = "Form3"
Attribute VB_GlobalNameSpace = False
Attribute VB_Creatable = False
Attribute VB_PredeclaredId = True
Attribute VB_Exposed = False
Private Sub Timer1_Timer()
Text1.Text = Time$
Text1.Text = Format$(Now, "hh:mm:ss AM/PM")

End Sub
