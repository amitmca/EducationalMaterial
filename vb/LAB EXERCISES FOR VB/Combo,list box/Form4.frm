VERSION 5.00
Begin VB.Form Form4 
   BackColor       =   &H00FFFFC0&
   Caption         =   "Form4"
   ClientHeight    =   6120
   ClientLeft      =   60
   ClientTop       =   450
   ClientWidth     =   8100
   LinkTopic       =   "Form4"
   ScaleHeight     =   6120
   ScaleWidth      =   8100
   StartUpPosition =   3  'Windows Default
   Begin VB.CommandButton Command2 
      BackColor       =   &H00C0FFC0&
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
      Height          =   495
      Left            =   4920
      Style           =   1  'Graphical
      TabIndex        =   3
      Top             =   2040
      Width           =   1215
   End
   Begin VB.CommandButton Command1 
      BackColor       =   &H00C0FFC0&
      Caption         =   "<<"
      BeginProperty Font 
         Name            =   "Times New Roman"
         Size            =   18
         Charset         =   0
         Weight          =   700
         Underline       =   0   'False
         Italic          =   0   'False
         Strikethrough   =   0   'False
      EndProperty
      Height          =   495
      Left            =   1080
      Style           =   1  'Graphical
      TabIndex        =   2
      Top             =   2040
      Width           =   1215
   End
   Begin VB.ListBox List2 
      BackColor       =   &H00FFC0FF&
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
      Height          =   390
      ItemData        =   "Form4.frx":0000
      Left            =   4440
      List            =   "Form4.frx":0010
      TabIndex        =   1
      Top             =   1080
      Width           =   2535
   End
   Begin VB.ListBox List1 
      BackColor       =   &H00FFC0FF&
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
      Height          =   390
      ItemData        =   "Form4.frx":0037
      Left            =   720
      List            =   "Form4.frx":0047
      TabIndex        =   0
      Top             =   1080
      Width           =   2535
   End
   Begin VB.Label Label4 
      AutoSize        =   -1  'True
      BackColor       =   &H00FFFFC0&
      Caption         =   "2 TO 1"
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
      Left            =   5040
      TabIndex        =   7
      Top             =   2760
      Width           =   1050
   End
   Begin VB.Label Label3 
      AutoSize        =   -1  'True
      BackColor       =   &H00FFFFC0&
      Caption         =   "1 TO 2"
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
      Left            =   1200
      TabIndex        =   6
      Top             =   2760
      Width           =   1050
   End
   Begin VB.Label Label2 
      AutoSize        =   -1  'True
      BackColor       =   &H00FFFFC0&
      Caption         =   "LIST2"
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
      Left            =   5280
      TabIndex        =   5
      Top             =   600
      Width           =   975
   End
   Begin VB.Label Label1 
      AutoSize        =   -1  'True
      BackColor       =   &H00FFFFC0&
      Caption         =   "LIST1"
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
      Left            =   1440
      TabIndex        =   4
      Top             =   600
      Width           =   975
   End
End
Attribute VB_Name = "Form4"
Attribute VB_GlobalNameSpace = False
Attribute VB_Creatable = False
Attribute VB_PredeclaredId = True
Attribute VB_Exposed = False
Dim i, str

Private Sub Command1_Click()
For i = 0 To List1.SelCount Step 1
If List1.Selected(i) Then
str = List1.List(i)
List1.RemoveItem (i)
List2.AddItem (str)
End If
Next i
End Sub

Private Sub Command2_Click()
For i = 0 To List2.SelCount Step 1
If List2.Selected(i) Then
str = List2.List(i)
List2.RemoveItem (i)
List1.AddItem (str)
End If
Next i
End Sub
