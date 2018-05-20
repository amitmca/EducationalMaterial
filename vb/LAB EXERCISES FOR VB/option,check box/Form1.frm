VERSION 5.00
Begin VB.Form Form1 
   AutoRedraw      =   -1  'True
   BackColor       =   &H00FFC0FF&
   Caption         =   "Form1"
   ClientHeight    =   5190
   ClientLeft      =   60
   ClientTop       =   450
   ClientWidth     =   7395
   LinkTopic       =   "Form1"
   ScaleHeight     =   5190
   ScaleWidth      =   7395
   StartUpPosition =   3  'Windows Default
   Begin VB.CommandButton Command1 
      BackColor       =   &H00C0E0FF&
      Caption         =   "CLICK ME"
      BeginProperty Font 
         Name            =   "Times New Roman"
         Size            =   14.25
         Charset         =   0
         Weight          =   700
         Underline       =   0   'False
         Italic          =   0   'False
         Strikethrough   =   0   'False
      EndProperty
      Height          =   615
      Left            =   2400
      Style           =   1  'Graphical
      TabIndex        =   4
      Top             =   4320
      Width           =   2055
   End
   Begin VB.CheckBox Check4 
      BackColor       =   &H00C0FFC0&
      Caption         =   "TENNIS"
      BeginProperty Font 
         Name            =   "Times New Roman"
         Size            =   12
         Charset         =   0
         Weight          =   700
         Underline       =   0   'False
         Italic          =   0   'False
         Strikethrough   =   0   'False
      EndProperty
      ForeColor       =   &H00FF0000&
      Height          =   495
      Left            =   5760
      TabIndex        =   3
      Top             =   3480
      Width           =   1455
   End
   Begin VB.CheckBox Check3 
      BackColor       =   &H00C0FFC0&
      Caption         =   "FOOTBALL"
      BeginProperty Font 
         Name            =   "Times New Roman"
         Size            =   12
         Charset         =   0
         Weight          =   700
         Underline       =   0   'False
         Italic          =   0   'False
         Strikethrough   =   0   'False
      EndProperty
      ForeColor       =   &H00FF0000&
      Height          =   495
      Left            =   3720
      TabIndex        =   2
      Top             =   3480
      Width           =   1815
   End
   Begin VB.CheckBox Check2 
      BackColor       =   &H00C0FFC0&
      Caption         =   "CRICKET"
      BeginProperty Font 
         Name            =   "Times New Roman"
         Size            =   12
         Charset         =   0
         Weight          =   700
         Underline       =   0   'False
         Italic          =   0   'False
         Strikethrough   =   0   'False
      EndProperty
      ForeColor       =   &H00FF0000&
      Height          =   495
      Left            =   1920
      TabIndex        =   1
      Top             =   3480
      Width           =   1575
   End
   Begin VB.CheckBox Check1 
      BackColor       =   &H00C0FFC0&
      Caption         =   "MUSIC"
      BeginProperty Font 
         Name            =   "Times New Roman"
         Size            =   12
         Charset         =   0
         Weight          =   700
         Underline       =   0   'False
         Italic          =   0   'False
         Strikethrough   =   0   'False
      EndProperty
      ForeColor       =   &H00FF0000&
      Height          =   495
      Left            =   240
      TabIndex        =   0
      Top             =   3480
      Width           =   1455
   End
End
Attribute VB_Name = "Form1"
Attribute VB_GlobalNameSpace = False
Attribute VB_Creatable = False
Attribute VB_PredeclaredId = True
Attribute VB_Exposed = False
Private Sub Command1_Click()

If Check1.Value = Checked Then
Form1.Print Check1.Caption
End If

If Check2.Value = Checked Then
Form1.Print Check2.Caption
End If

If Check3.Value = Checked Then
Form1.Print Check3.Caption
End If

If Check4.Value = Checked Then
Form1.Print Check4.Caption
End If

End Sub

