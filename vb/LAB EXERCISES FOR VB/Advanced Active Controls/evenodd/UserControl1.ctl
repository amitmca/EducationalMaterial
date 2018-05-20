VERSION 5.00
Begin VB.UserControl UserControl1 
   BackColor       =   &H00FFC0FF&
   ClientHeight    =   3600
   ClientLeft      =   0
   ClientTop       =   0
   ClientWidth     =   4800
   ScaleHeight     =   3600
   ScaleWidth      =   4800
   Begin VB.CommandButton Command1 
      BackColor       =   &H0080FF80&
      Caption         =   "CLICK HERE"
      BeginProperty Font 
         Name            =   "Times New Roman"
         Size            =   12
         Charset         =   0
         Weight          =   700
         Underline       =   0   'False
         Italic          =   0   'False
         Strikethrough   =   0   'False
      EndProperty
      Height          =   495
      Left            =   1320
      Style           =   1  'Graphical
      TabIndex        =   4
      Top             =   1920
      Width           =   1695
   End
   Begin VB.TextBox Text2 
      BackColor       =   &H00FFC0FF&
      ForeColor       =   &H00FF0000&
      Height          =   375
      Left            =   1680
      TabIndex        =   3
      Text            =   " "
      Top             =   1080
      Width           =   2535
   End
   Begin VB.TextBox Text1 
      BackColor       =   &H00FFC0FF&
      Height          =   375
      Left            =   2640
      TabIndex        =   1
      Top             =   360
      Width           =   975
   End
   Begin VB.Label Label2 
      AutoSize        =   -1  'True
      BackColor       =   &H00C0FFFF&
      Caption         =   "RESULT"
      BeginProperty Font 
         Name            =   "Times New Roman"
         Size            =   14.25
         Charset         =   0
         Weight          =   700
         Underline       =   0   'False
         Italic          =   0   'False
         Strikethrough   =   0   'False
      EndProperty
      ForeColor       =   &H000000FF&
      Height          =   330
      Left            =   120
      TabIndex        =   2
      Top             =   1080
      Width           =   1140
   End
   Begin VB.Label Label1 
      AutoSize        =   -1  'True
      BackColor       =   &H00C0FFFF&
      Caption         =   "ENTER NUMBER="
      BeginProperty Font 
         Name            =   "Times New Roman"
         Size            =   14.25
         Charset         =   0
         Weight          =   700
         Underline       =   0   'False
         Italic          =   0   'False
         Strikethrough   =   0   'False
      EndProperty
      ForeColor       =   &H000000FF&
      Height          =   330
      Left            =   0
      TabIndex        =   0
      Top             =   360
      Width           =   2520
   End
End
Attribute VB_Name = "UserControl1"
Attribute VB_GlobalNameSpace = False
Attribute VB_Creatable = True
Attribute VB_PredeclaredId = False
Attribute VB_Exposed = True
Option Explicit
Dim n
Private Sub Command1_Click()
n = Text1.Text
If n Mod 2 = 0 Then
Text2.Text = "NUMBER IS EVEN"
Else
Text2.Text = "NUMBER IS ODD"
End If
End Sub

