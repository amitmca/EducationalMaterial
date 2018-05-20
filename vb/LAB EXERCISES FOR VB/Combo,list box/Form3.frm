VERSION 5.00
Begin VB.Form Form3 
   AutoRedraw      =   -1  'True
   BackColor       =   &H00FFFFC0&
   Caption         =   "Form3"
   ClientHeight    =   5850
   ClientLeft      =   60
   ClientTop       =   450
   ClientWidth     =   8790
   BeginProperty Font 
      Name            =   "Times New Roman"
      Size            =   18
      Charset         =   0
      Weight          =   700
      Underline       =   0   'False
      Italic          =   0   'False
      Strikethrough   =   0   'False
   EndProperty
   ForeColor       =   &H00FF00FF&
   LinkTopic       =   "Form3"
   ScaleHeight     =   5850
   ScaleWidth      =   8790
   StartUpPosition =   3  'Windows Default
   Begin VB.CommandButton Command2 
      BackColor       =   &H00FFC0C0&
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
      Left            =   3840
      Style           =   1  'Graphical
      TabIndex        =   2
      Top             =   1920
      Width           =   1335
   End
   Begin VB.CommandButton Command1 
      BackColor       =   &H00FFC0C0&
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
      Height          =   495
      Left            =   1920
      Style           =   1  'Graphical
      TabIndex        =   1
      Top             =   1920
      Width           =   1575
   End
   Begin VB.ListBox List1 
      BeginProperty Font 
         Name            =   "Times New Roman"
         Size            =   12
         Charset         =   0
         Weight          =   700
         Underline       =   0   'False
         Italic          =   0   'False
         Strikethrough   =   0   'False
      EndProperty
      ForeColor       =   &H000000FF&
      Height          =   630
      ItemData        =   "Form3.frx":0000
      Left            =   1920
      List            =   "Form3.frx":0013
      MultiSelect     =   2  'Extended
      TabIndex        =   0
      Top             =   1080
      Width           =   3855
   End
End
Attribute VB_Name = "Form3"
Attribute VB_GlobalNameSpace = False
Attribute VB_Creatable = False
Attribute VB_PredeclaredId = True
Attribute VB_Exposed = False
Dim str, i
Private Sub Command1_Click()

For i = 0 To List1.SelCount Step 1
If (List1.Selected(i)) Then
str = List1.List(i)
Form3.Print str
End If
Next i
End Sub

Private Sub Command2_Click()
For i = 0 To List1.SelCount Step 1
If (List1.Selected(i)) Then
List1.RemoveItem (i)
End If
Next i
End Sub
