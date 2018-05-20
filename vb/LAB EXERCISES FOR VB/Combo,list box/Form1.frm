VERSION 5.00
Begin VB.Form Form1 
   BackColor       =   &H00FFC0FF&
   Caption         =   "Form1"
   ClientHeight    =   7830
   ClientLeft      =   60
   ClientTop       =   450
   ClientWidth     =   9870
   LinkTopic       =   "Form1"
   ScaleHeight     =   7830
   ScaleWidth      =   9870
   StartUpPosition =   3  'Windows Default
   Begin VB.TextBox Text2 
      Alignment       =   2  'Center
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
      Left            =   3720
      TabIndex        =   4
      Text            =   " "
      Top             =   1440
      Width           =   615
   End
   Begin VB.CommandButton Command2 
      BackColor       =   &H00C0FFC0&
      Caption         =   "DELETE"
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
      Left            =   4920
      Style           =   1  'Graphical
      TabIndex        =   3
      Top             =   2160
      Width           =   1575
   End
   Begin VB.CommandButton Command1 
      BackColor       =   &H00C0FFC0&
      Caption         =   "ADD"
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
      Left            =   1320
      Style           =   1  'Graphical
      TabIndex        =   2
      Top             =   2160
      Width           =   1695
   End
   Begin VB.ComboBox Combo1 
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
      Height          =   450
      ItemData        =   "Form1.frx":0000
      Left            =   4320
      List            =   "Form1.frx":0002
      TabIndex        =   1
      Text            =   " "
      Top             =   840
      Width           =   3015
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
      Height          =   495
      Left            =   600
      TabIndex        =   0
      Text            =   " "
      Top             =   840
      Width           =   3015
   End
   Begin VB.Label Label1 
      AutoSize        =   -1  'True
      BackColor       =   &H00FFC0FF&
      Caption         =   "TOTAL ITEMS  NOW"
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
      Height          =   285
      Left            =   960
      TabIndex        =   5
      Top             =   1560
      Width           =   2325
   End
End
Attribute VB_Name = "Form1"
Attribute VB_GlobalNameSpace = False
Attribute VB_Creatable = False
Attribute VB_PredeclaredId = True
Attribute VB_Exposed = False
Dim c
Private Sub Command1_Click()
Combo1.AddItem (Text1.Text)
Text1.Text = " "
Text1.SetFocus
c = c + 1
Text2.Text = c
End Sub

Private Sub Command2_Click()
Combo1.RemoveItem (0)
c = c - 1
Text2.Text = c
End Sub

Private Sub Form_Load()
c = 0
End Sub
