VERSION 5.00
Begin VB.Form Form1 
   BackColor       =   &H00C0FFC0&
   Caption         =   "Form1"
   ClientHeight    =   6735
   ClientLeft      =   60
   ClientTop       =   450
   ClientWidth     =   10425
   LinkTopic       =   "Form1"
   ScaleHeight     =   6735
   ScaleWidth      =   10425
   StartUpPosition =   3  'Windows Default
   Begin VB.CommandButton cmdFuture 
      BackColor       =   &H00FFC0C0&
      Caption         =   "Future"
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
      Left            =   4200
      Style           =   1  'Graphical
      TabIndex        =   3
      Top             =   1200
      Width           =   975
   End
   Begin VB.CommandButton cmdCurrent 
      BackColor       =   &H00FFC0C0&
      Caption         =   "Current Date"
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
      Left            =   1920
      Style           =   1  'Graphical
      TabIndex        =   2
      Top             =   1200
      Width           =   2055
   End
   Begin VB.TextBox Text1 
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
      Height          =   615
      Left            =   600
      TabIndex        =   1
      Text            =   " "
      Top             =   360
      Width           =   3735
   End
   Begin VB.CommandButton cmdDate 
      BackColor       =   &H00FFC0C0&
      Caption         =   "DATE"
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
      Left            =   480
      Style           =   1  'Graphical
      TabIndex        =   0
      Top             =   1200
      Width           =   1095
   End
End
Attribute VB_Name = "Form1"
Attribute VB_GlobalNameSpace = False
Attribute VB_Creatable = False
Attribute VB_PredeclaredId = True
Attribute VB_Exposed = False

Private Sub cmdCurrent_Click()
mydate = Text1.Text
'mydate = Format$(, "dd ,mm,yy ")
d = Format$(Date, "dd, ,")
If d <= 0 And d > 31 Then
MsgBox "Enter Valid Date"
Else
MsgBox "Date is OK"
End If
End Sub

Private Sub cmdDate_Click()
mydate = Format$(Now, "ddd , mmmm d , yyyy ")
Text1.Text = mydate
End Sub

Private Sub cmdFuture_Click()
mydate = Text1.Text
mydate = Format$(Now, "dd ,mm,yy ")


End Sub
