VERSION 5.00
Begin VB.Form Form1 
   Caption         =   "Form1"
   ClientHeight    =   5775
   ClientLeft      =   60
   ClientTop       =   450
   ClientWidth     =   7710
   LinkTopic       =   "Form1"
   ScaleHeight     =   5775
   ScaleWidth      =   7710
   StartUpPosition =   3  'Windows Default
   Begin VB.ListBox List1 
      Height          =   2595
      Left            =   3000
      TabIndex        =   5
      Top             =   1440
      Width           =   4215
   End
   Begin VB.CommandButton Command3 
      BackColor       =   &H00800080&
      Caption         =   ">>"
      BeginProperty Font 
         Name            =   "Times New Roman"
         Size            =   24
         Charset         =   0
         Weight          =   700
         Underline       =   0   'False
         Italic          =   0   'False
         Strikethrough   =   0   'False
      EndProperty
      Height          =   615
      Left            =   120
      Style           =   1  'Graphical
      TabIndex        =   4
      Top             =   3600
      Width           =   1215
   End
   Begin VB.CommandButton Command2 
      BackColor       =   &H00800080&
      Caption         =   ">"
      BeginProperty Font 
         Name            =   "Times New Roman"
         Size            =   24
         Charset         =   0
         Weight          =   700
         Underline       =   0   'False
         Italic          =   0   'False
         Strikethrough   =   0   'False
      EndProperty
      Height          =   735
      Left            =   120
      Style           =   1  'Graphical
      TabIndex        =   3
      Top             =   2520
      Width           =   1215
   End
   Begin VB.CommandButton Command1 
      BackColor       =   &H00800080&
      Caption         =   "<"
      BeginProperty Font 
         Name            =   "Times New Roman"
         Size            =   24
         Charset         =   0
         Weight          =   700
         Underline       =   0   'False
         Italic          =   0   'False
         Strikethrough   =   0   'False
      EndProperty
      Height          =   735
      Left            =   120
      Style           =   1  'Graphical
      TabIndex        =   2
      Top             =   1440
      Width           =   1215
   End
   Begin VB.TextBox Text1 
      ForeColor       =   &H00000000&
      Height          =   375
      Left            =   4440
      TabIndex        =   1
      Text            =   " "
      Top             =   600
      Width           =   3255
   End
   Begin VB.Label Label1 
      AutoSize        =   -1  'True
      BackColor       =   &H00C0FFC0&
      Caption         =   "ENTER THE TEXT HERE"
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
      Height          =   390
      Left            =   120
      TabIndex        =   0
      Top             =   600
      Width           =   4185
   End
End
Attribute VB_Name = "Form1"
Attribute VB_GlobalNameSpace = False
Attribute VB_Creatable = False
Attribute VB_PredeclaredId = True
Attribute VB_Exposed = False
Dim str As String

Private Sub Command1_Click()
str = Text1.Text
List1.AddItem (Text1.Text)
Text1.Text = " "
Text1.SetFocus
End Sub

Private Sub Command2_Click()
List1.RemoveItem (0)
End Sub

Private Sub Command3_Click()
List1.Clear
End Sub

Private Sub Form_Load()

End Sub
