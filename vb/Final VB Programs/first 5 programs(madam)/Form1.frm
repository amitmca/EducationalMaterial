VERSION 5.00
Begin VB.Form Form2 
   AutoRedraw      =   -1  'True
   Caption         =   "Form2"
   ClientHeight    =   5355
   ClientLeft      =   60
   ClientTop       =   450
   ClientWidth     =   7860
   LinkTopic       =   "Form2"
   ScaleHeight     =   5355
   ScaleWidth      =   7860
   StartUpPosition =   3  'Windows Default
   Begin VB.CommandButton Command1 
      Caption         =   "Click Here"
      Height          =   615
      Left            =   1800
      TabIndex        =   4
      Top             =   3360
      Width           =   4815
   End
   Begin VB.CheckBox Check4 
      Caption         =   "Football"
      Height          =   495
      Left            =   6240
      TabIndex        =   3
      Top             =   4440
      Width           =   1215
   End
   Begin VB.CheckBox Check3 
      Caption         =   "Chess"
      Height          =   495
      Left            =   4560
      TabIndex        =   2
      Top             =   4440
      Width           =   1215
   End
   Begin VB.CheckBox Check2 
      Caption         =   "Cricket"
      Height          =   495
      Left            =   2880
      TabIndex        =   1
      Top             =   4440
      Width           =   1215
   End
   Begin VB.CheckBox Check1 
      Caption         =   "Music"
      Height          =   495
      Left            =   1200
      TabIndex        =   0
      Top             =   4440
      Width           =   1215
   End
End
Attribute VB_Name = "Form2"
Attribute VB_GlobalNameSpace = False
Attribute VB_Creatable = False
Attribute VB_PredeclaredId = True
Attribute VB_Exposed = False


Private Sub Command1_Click()

If Check1.Value = Checked Then
Form2.Print Check1.Caption
End If

If Check2.Value = Checked Then
Form2.Print Check2.Caption
End If

If Check3.Value = Checked Then
Form2.Print Check3.Caption
End If

If Check4.Value = Checked Then
Form2.Print Check4.Caption
End If
End Sub

