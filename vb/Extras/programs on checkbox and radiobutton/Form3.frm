VERSION 5.00
Begin VB.Form Form3 
   AutoRedraw      =   -1  'True
   BackColor       =   &H00C0FFC0&
   Caption         =   "Form3"
   ClientHeight    =   4935
   ClientLeft      =   60
   ClientTop       =   450
   ClientWidth     =   7365
   LinkTopic       =   "Form3"
   ScaleHeight     =   4935
   ScaleWidth      =   7365
   StartUpPosition =   3  'Windows Default
   Begin VB.CommandButton Command1 
      Caption         =   "ADD"
      Height          =   495
      Left            =   1680
      TabIndex        =   5
      Top             =   2760
      Width           =   3615
   End
   Begin VB.CheckBox Check4 
      BackColor       =   &H00800000&
      Caption         =   "Football"
      ForeColor       =   &H00FF00FF&
      Height          =   495
      Left            =   4560
      MaskColor       =   &H00C0E0FF&
      TabIndex        =   3
      Top             =   3960
      Width           =   1695
   End
   Begin VB.CheckBox Check3 
      BackColor       =   &H00800000&
      Caption         =   "Chess"
      ForeColor       =   &H00FF00FF&
      Height          =   495
      Left            =   3120
      MaskColor       =   &H00C0E0FF&
      TabIndex        =   2
      Top             =   3960
      Width           =   1335
   End
   Begin VB.CheckBox Check2 
      BackColor       =   &H00800000&
      Caption         =   "Cricket"
      ForeColor       =   &H00FF00FF&
      Height          =   495
      Left            =   1680
      MaskColor       =   &H00C0E0FF&
      TabIndex        =   1
      Top             =   3960
      Width           =   1335
   End
   Begin VB.CheckBox Check1 
      BackColor       =   &H00800000&
      Caption         =   "Music"
      ForeColor       =   &H00FF00FF&
      Height          =   495
      Left            =   240
      MaskColor       =   &H00C0E0FF&
      TabIndex        =   0
      Top             =   3960
      Width           =   1335
   End
   Begin VB.Label Label1 
      AutoSize        =   -1  'True
      BackColor       =   &H00C0FFFF&
      Caption         =   "PLEASE SELECT YOUR HOBBIES"
      BeginProperty Font 
         Name            =   "Times New Roman"
         Size            =   15.75
         Charset         =   0
         Weight          =   700
         Underline       =   0   'False
         Italic          =   0   'False
         Strikethrough   =   0   'False
      EndProperty
      ForeColor       =   &H000000FF&
      Height          =   360
      Left            =   840
      TabIndex        =   4
      Top             =   3360
      Width           =   5040
   End
End
Attribute VB_Name = "Form3"
Attribute VB_GlobalNameSpace = False
Attribute VB_Creatable = False
Attribute VB_PredeclaredId = True
Attribute VB_Exposed = False
Private Sub Command1_Click()
If Check1.Value = Checked Then
Form3.Print Check1.Caption
End If

If Check2.Value = Checked Then
Form3.Print Check2.Caption
End If

If Check3.Value = Checked Then
Form3.Print Check3.Caption
End If

If Check4.Value = Checked Then
Form3.Print Check4.Caption
End If
End Sub

