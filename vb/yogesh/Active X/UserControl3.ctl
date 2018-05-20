VERSION 5.00
Begin VB.UserControl UserControl1 
   BackColor       =   &H00C0FFC0&
   ClientHeight    =   7245
   ClientLeft      =   0
   ClientTop       =   0
   ClientWidth     =   9090
   ScaleHeight     =   7245
   ScaleWidth      =   9090
   Begin VB.TextBox Text2 
      BeginProperty Font 
         Name            =   "Times New Roman"
         Size            =   18
         Charset         =   0
         Weight          =   700
         Underline       =   0   'False
         Italic          =   0   'False
         Strikethrough   =   0   'False
      EndProperty
      ForeColor       =   &H00FF0000&
      Height          =   495
      Left            =   960
      TabIndex        =   3
      Top             =   2400
      Width           =   5775
   End
   Begin VB.CommandButton Command1 
      BackColor       =   &H00FFFFC0&
      Caption         =   "CHECK"
      Height          =   495
      Left            =   2880
      Style           =   1  'Graphical
      TabIndex        =   2
      Top             =   1440
      Width           =   1095
   End
   Begin VB.TextBox Text1 
      BeginProperty Font 
         Name            =   "Times New Roman"
         Size            =   18
         Charset         =   0
         Weight          =   700
         Underline       =   0   'False
         Italic          =   0   'False
         Strikethrough   =   0   'False
      EndProperty
      ForeColor       =   &H00FF0000&
      Height          =   375
      Left            =   3360
      TabIndex        =   1
      Text            =   " "
      Top             =   600
      Width           =   3975
   End
   Begin VB.Label Label1 
      AutoSize        =   -1  'True
      Caption         =   "ENTER E-MAIL ID "
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
      Left            =   360
      TabIndex        =   0
      Top             =   600
      Width           =   2580
   End
End
Attribute VB_Name = "UserControl1"
Attribute VB_GlobalNameSpace = False
Attribute VB_Creatable = True
Attribute VB_PredeclaredId = False
Attribute VB_Exposed = True
Option Explicit
Dim str As String
Private Sub Command1_Click()
str = Text1.Text
If str = "@" Then
Text2.Text = "yes"
Else
Text2.Text = "no"
End If
End Sub
