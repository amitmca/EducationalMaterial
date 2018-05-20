VERSION 5.00
Begin VB.Form Form2 
   Caption         =   "Form2"
   ClientHeight    =   5385
   ClientLeft      =   60
   ClientTop       =   450
   ClientWidth     =   6810
   LinkTopic       =   "Form2"
   ScaleHeight     =   5385
   ScaleWidth      =   6810
   StartUpPosition =   3  'Windows Default
   Begin VB.CommandButton Command1 
      BackColor       =   &H00C0FFFF&
      Caption         =   "BACK"
      BeginProperty Font 
         Name            =   "Times New Roman"
         Size            =   14.25
         Charset         =   0
         Weight          =   700
         Underline       =   0   'False
         Italic          =   0   'False
         Strikethrough   =   0   'False
      EndProperty
      Height          =   495
      Left            =   2040
      Style           =   1  'Graphical
      TabIndex        =   4
      Top             =   4560
      Width           =   2295
   End
   Begin VB.ListBox List1 
      BackColor       =   &H00C0FFFF&
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
      Height          =   2370
      Left            =   120
      TabIndex        =   3
      Top             =   1440
      Width           =   3615
   End
   Begin VB.TextBox Text1 
      BackColor       =   &H00C0FFFF&
      ForeColor       =   &H000000FF&
      Height          =   375
      Left            =   1440
      TabIndex        =   1
      Text            =   " "
      Top             =   120
      Width           =   2895
   End
   Begin VB.Label Label2 
      AutoSize        =   -1  'True
      BackColor       =   &H00C0FFFF&
      Caption         =   "SUBJECTS SELECTED"
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
      Left            =   120
      TabIndex        =   2
      Top             =   720
      Width           =   3345
   End
   Begin VB.Label Label1 
      AutoSize        =   -1  'True
      BackColor       =   &H00C0C0FF&
      Caption         =   "NAME"
      BeginProperty Font 
         Name            =   "Times New Roman"
         Size            =   14.25
         Charset         =   0
         Weight          =   700
         Underline       =   0   'False
         Italic          =   0   'False
         Strikethrough   =   0   'False
      EndProperty
      ForeColor       =   &H00FF0000&
      Height          =   330
      Left            =   120
      TabIndex        =   0
      Top             =   120
      Width           =   870
   End
End
Attribute VB_Name = "Form2"
Attribute VB_GlobalNameSpace = False
Attribute VB_Creatable = False
Attribute VB_PredeclaredId = True
Attribute VB_Exposed = False
Private Sub Command1_Click()
Form2.Visible = False
Form1.Visible = True
End Sub

