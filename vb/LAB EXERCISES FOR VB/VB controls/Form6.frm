VERSION 5.00
Begin VB.Form Form5 
   BackColor       =   &H00FFC0FF&
   Caption         =   "Form5"
   ClientHeight    =   4740
   ClientLeft      =   60
   ClientTop       =   450
   ClientWidth     =   6510
   BeginProperty Font 
      Name            =   "Times New Roman"
      Size            =   14.25
      Charset         =   0
      Weight          =   400
      Underline       =   0   'False
      Italic          =   0   'False
      Strikethrough   =   0   'False
   EndProperty
   ForeColor       =   &H00FF0000&
   LinkTopic       =   "Form5"
   ScaleHeight     =   4740
   ScaleWidth      =   6510
   StartUpPosition =   3  'Windows Default
   Begin VB.CommandButton cmdSym 
      BackColor       =   &H00FFFFC0&
      Caption         =   "SYMBOLS"
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
      TabIndex        =   4
      Top             =   3000
      Width           =   1695
   End
   Begin VB.CommandButton cmdNo 
      BackColor       =   &H00FFFFC0&
      Caption         =   "NUMBERS"
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
      Left            =   2400
      MaskColor       =   &H00FFC0FF&
      Style           =   1  'Graphical
      TabIndex        =   3
      Top             =   3000
      Width           =   1575
   End
   Begin VB.CommandButton cmdL 
      BackColor       =   &H00FFFFC0&
      Caption         =   "LETTERS"
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
      Left            =   720
      Style           =   1  'Graphical
      TabIndex        =   2
      Top             =   3000
      Width           =   1455
   End
   Begin VB.TextBox Text1 
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
      ForeColor       =   &H000080FF&
      Height          =   495
      Left            =   3360
      TabIndex        =   1
      Text            =   " "
      Top             =   2040
      Width           =   2655
   End
   Begin VB.Label Label1 
      AutoSize        =   -1  'True
      BackColor       =   &H00FFC0FF&
      Caption         =   "ENTER THE STRING"
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
      Left            =   240
      TabIndex        =   0
      Top             =   2160
      Width           =   2985
   End
End
Attribute VB_Name = "Form5"
Attribute VB_GlobalNameSpace = False
Attribute VB_Creatable = False
Attribute VB_PredeclaredId = True
Attribute VB_Exposed = False
Option Explicit
Dim l, n, s, c, i, len1 As Integer
Dim str As String


Private Sub cmdL_Click()
l = 0
str = Text1.Text
len1 = Len(str)
For i = 1 To len1 - 1 Step 1
c = Asc(str)
If c >= 65 And c <= 123 Then
l = l + 1
End If
Next i
Form5.Print "  Letters = " + CStr(l)
End Sub

Private Sub cmdNo_Click()
str = Text1.Text
len1 = Len(str)
n = 0
For i = 1 To len1 - 1 Step 1
c = Asc(str)
If c >= 48 And c <= 57 Then
n = n + 1
End If
Next i
Form5.Print "  Numbers = " + CStr(n)
End Sub

Private Sub cmdSym_Click()
s = 0
str = Text1.Text
len1 = Len(str)
For i = 1 To len1 - 1 Step 1
c = Asc(str)
If c >= 34 And c <= 47 Then
s = s + 1
End If
Next i
Form5.Print "  Special Symbols = " + CStr(s)
End Sub
