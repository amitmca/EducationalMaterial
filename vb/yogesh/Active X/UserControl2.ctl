VERSION 5.00
Begin VB.UserControl UserControl1 
   BackColor       =   &H00C0FFFF&
   ClientHeight    =   6270
   ClientLeft      =   0
   ClientTop       =   0
   ClientWidth     =   8730
   ScaleHeight     =   6270
   ScaleWidth      =   8730
   Begin VB.TextBox Text2 
      BackColor       =   &H00FFFFFF&
      BeginProperty Font 
         Name            =   "Times New Roman"
         Size            =   18
         Charset         =   0
         Weight          =   700
         Underline       =   0   'False
         Italic          =   0   'False
         Strikethrough   =   0   'False
      EndProperty
      ForeColor       =   &H000000FF&
      Height          =   615
      Left            =   1320
      TabIndex        =   3
      Text            =   " "
      Top             =   2160
      Width           =   4455
   End
   Begin VB.CommandButton Command1 
      BackColor       =   &H00C0E0FF&
      Caption         =   "GET FACTORIAL"
      BeginProperty Font 
         Name            =   "Times New Roman"
         Size            =   12
         Charset         =   0
         Weight          =   700
         Underline       =   0   'False
         Italic          =   0   'False
         Strikethrough   =   0   'False
      EndProperty
      Height          =   735
      Left            =   2160
      Style           =   1  'Graphical
      TabIndex        =   2
      Top             =   1200
      Width           =   1575
   End
   Begin VB.TextBox Text1 
      BackColor       =   &H00FFFFFF&
      BeginProperty Font 
         Name            =   "Times New Roman"
         Size            =   18
         Charset         =   0
         Weight          =   700
         Underline       =   0   'False
         Italic          =   0   'False
         Strikethrough   =   0   'False
      EndProperty
      ForeColor       =   &H000000FF&
      Height          =   375
      Left            =   3960
      TabIndex        =   1
      Top             =   480
      Width           =   855
   End
   Begin VB.Label Label1 
      AutoSize        =   -1  'True
      BackColor       =   &H00C0FFFF&
      Caption         =   "ENTER THE NUMBER"
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
      Top             =   480
      Width           =   3255
   End
End
Attribute VB_Name = "UserControl1"
Attribute VB_GlobalNameSpace = False
Attribute VB_Creatable = True
Attribute VB_PredeclaredId = False
Attribute VB_Exposed = True
Option Explicit
Dim n As Integer
Dim f As Integer
Dim i As Integer

Private Sub Command1_Click()
f = 1
n = Text1.Text
For i = 1 To n
f = f * i
Next i
Text2.Text = "Facorial is:" + CStr(f)
End Sub
