VERSION 5.00
Begin VB.Form Form1 
   Caption         =   "Form1"
   ClientHeight    =   5970
   ClientLeft      =   60
   ClientTop       =   450
   ClientWidth     =   7500
   LinkTopic       =   "Form1"
   ScaleHeight     =   5970
   ScaleWidth      =   7500
   StartUpPosition =   3  'Windows Default
   Begin VB.CommandButton Command1 
      BackColor       =   &H00C0FFFF&
      Caption         =   "DISPLAY"
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
      Left            =   2040
      MaskColor       =   &H000000FF&
      Style           =   1  'Graphical
      TabIndex        =   10
      Top             =   4560
      Width           =   3375
   End
   Begin VB.OptionButton Option2 
      BackColor       =   &H00C0E0FF&
      Caption         =   "PPMOB"
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
      Left            =   4560
      TabIndex        =   9
      Top             =   2400
      Width           =   1335
   End
   Begin VB.OptionButton Option1 
      BackColor       =   &H00C0E0FF&
      Caption         =   "VB"
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
      Left            =   4560
      TabIndex        =   8
      Top             =   1680
      Width           =   1215
   End
   Begin VB.CheckBox Check4 
      BackColor       =   &H00C0E0FF&
      Caption         =   "A/C"
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
      Left            =   840
      TabIndex        =   7
      Top             =   3480
      Width           =   1215
   End
   Begin VB.CheckBox Check3 
      BackColor       =   &H00C0E0FF&
      Caption         =   "ITPM"
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
      Left            =   840
      TabIndex        =   6
      Top             =   2880
      Width           =   1215
   End
   Begin VB.CheckBox Check2 
      BackColor       =   &H00C0E0FF&
      Caption         =   "CA"
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
      Left            =   840
      TabIndex        =   5
      Top             =   2280
      Width           =   1215
   End
   Begin VB.CheckBox Check1 
      BackColor       =   &H00C0E0FF&
      Caption         =   "MATHS"
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
      Left            =   840
      TabIndex        =   4
      Top             =   1680
      Width           =   1215
   End
   Begin VB.TextBox Text1 
      Height          =   405
      Left            =   3000
      TabIndex        =   1
      Text            =   " "
      Top             =   240
      Width           =   3855
   End
   Begin VB.Label Label2 
      AutoSize        =   -1  'True
      BackColor       =   &H0000FFFF&
      Caption         =   "OPTINAL SUBJECTS"
      BeginProperty Font 
         Name            =   "Times New Roman"
         Size            =   14.25
         Charset         =   0
         Weight          =   700
         Underline       =   0   'False
         Italic          =   0   'False
         Strikethrough   =   0   'False
      EndProperty
      ForeColor       =   &H00FF00FF&
      Height          =   330
      Index           =   1
      Left            =   3960
      TabIndex        =   3
      Top             =   1080
      Width           =   2835
   End
   Begin VB.Label Label2 
      AutoSize        =   -1  'True
      BackColor       =   &H0000FFFF&
      Caption         =   "COMPULSORY SUBJECTS"
      BeginProperty Font 
         Name            =   "Times New Roman"
         Size            =   14.25
         Charset         =   0
         Weight          =   700
         Underline       =   0   'False
         Italic          =   0   'False
         Strikethrough   =   0   'False
      EndProperty
      ForeColor       =   &H00FF00FF&
      Height          =   330
      Index           =   0
      Left            =   120
      TabIndex        =   2
      Top             =   1080
      Width           =   3600
   End
   Begin VB.Label Label1 
      AutoSize        =   -1  'True
      BackColor       =   &H00C0FFC0&
      Caption         =   "NAME"
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
      TabIndex        =   0
      Top             =   240
      Width           =   945
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
Form2.Visible = True
Form1.Visible = False
Form2.Text1 = str
Form2.List1.AddItem (Check1.Caption)
Form2.List1.AddItem (Check2.Caption)
Form2.List1.AddItem (Check3.Caption)
Form2.List1.AddItem (Check4.Caption)
If Option1.Value = True Then
Form2.List1.AddItem (Option1.Caption)
ElseIf Option2.Value = True Then
Form2.List1.AddItem (Option2.Caption)
End If
End Sub

