VERSION 5.00
Begin VB.UserControl UserControl1 
   ClientHeight    =   1365
   ClientLeft      =   0
   ClientTop       =   0
   ClientWidth     =   4695
   ScaleHeight     =   1365
   ScaleWidth      =   4695
   Begin VB.CommandButton Command2 
      BackColor       =   &H0000FFFF&
      Caption         =   "LINUX=>WIN "
      Height          =   495
      Left            =   1560
      MaskColor       =   &H00FFFF00&
      Style           =   1  'Graphical
      TabIndex        =   3
      Top             =   720
      Width           =   1215
   End
   Begin VB.CommandButton Command1 
      BackColor       =   &H0000FFFF&
      Caption         =   "WIN=>LINUX"
      Height          =   495
      Left            =   1560
      MaskColor       =   &H00FFFF00&
      Style           =   1  'Graphical
      TabIndex        =   2
      Top             =   120
      Width           =   1215
   End
   Begin VB.ListBox List2 
      BackColor       =   &H00C0FFC0&
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
      ItemData        =   "UserControl1.ctx":0000
      Left            =   3000
      List            =   "UserControl1.ctx":0010
      TabIndex        =   1
      Top             =   360
      Width           =   1695
   End
   Begin VB.ListBox List1 
      BackColor       =   &H00C0FFC0&
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
      ItemData        =   "UserControl1.ctx":0035
      Left            =   0
      List            =   "UserControl1.ctx":0045
      TabIndex        =   0
      Top             =   360
      Width           =   1455
   End
End
Attribute VB_Name = "UserControl1"
Attribute VB_GlobalNameSpace = False
Attribute VB_Creatable = True
Attribute VB_PredeclaredId = False
Attribute VB_Exposed = True
Option Explicit
Dim i, str
Private Sub Command1_Click()
For i = 0 To List1.SelCount
If (List1.Selected(i)) Then
str = List1.List(i)
List1.RemoveItem (i)
List2.AddItem (str)
End If
Next
End Sub

Private Sub Command2_Click()
For i = 0 To List2.SelCount
If (List2.Selected(i)) Then
str = List2.List(i)
List2.RemoveItem (i)
List1.AddItem (str)
End If
Next
End Sub
