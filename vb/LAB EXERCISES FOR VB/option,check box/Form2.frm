VERSION 5.00
Begin VB.Form Form2 
   AutoRedraw      =   -1  'True
   BackColor       =   &H00C0FFFF&
   Caption         =   "Form2"
   ClientHeight    =   3090
   ClientLeft      =   60
   ClientTop       =   450
   ClientWidth     =   4680
   BeginProperty Font 
      Name            =   "Times New Roman"
      Size            =   24
      Charset         =   0
      Weight          =   700
      Underline       =   0   'False
      Italic          =   0   'False
      Strikethrough   =   0   'False
   EndProperty
   ForeColor       =   &H00FF00FF&
   LinkTopic       =   "Form2"
   ScaleHeight     =   3090
   ScaleWidth      =   4680
   StartUpPosition =   3  'Windows Default
   Begin VB.CommandButton Command1 
      BackColor       =   &H00C0FFC0&
      Caption         =   "GET THE SUM"
      BeginProperty Font 
         Name            =   "Times New Roman"
         Size            =   12
         Charset         =   0
         Weight          =   700
         Underline       =   0   'False
         Italic          =   0   'False
         Strikethrough   =   0   'False
      EndProperty
      Height          =   375
      Left            =   3000
      Style           =   1  'Graphical
      TabIndex        =   10
      Top             =   7920
      Width           =   2295
   End
   Begin VB.CheckBox Check10 
      BackColor       =   &H00C0FFFF&
      Caption         =   "9"
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
      Height          =   495
      Left            =   7200
      TabIndex        =   9
      Top             =   6840
      Width           =   1215
   End
   Begin VB.CheckBox Check9 
      BackColor       =   &H00C0FFFF&
      Caption         =   "8"
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
      Height          =   495
      Left            =   7200
      TabIndex        =   8
      Top             =   6240
      Width           =   1215
   End
   Begin VB.CheckBox Check8 
      BackColor       =   &H00C0FFFF&
      Caption         =   "7"
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
      Height          =   495
      Left            =   7200
      TabIndex        =   7
      Top             =   5640
      Width           =   1215
   End
   Begin VB.CheckBox Check7 
      BackColor       =   &H00C0FFFF&
      Caption         =   "6"
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
      Height          =   495
      Left            =   7200
      TabIndex        =   6
      Top             =   5040
      Width           =   1215
   End
   Begin VB.CheckBox Check6 
      BackColor       =   &H00C0FFFF&
      Caption         =   "5"
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
      Height          =   495
      Left            =   7200
      TabIndex        =   5
      Top             =   4440
      Width           =   1215
   End
   Begin VB.CheckBox Check5 
      BackColor       =   &H00C0FFFF&
      Caption         =   "4"
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
      Height          =   495
      Left            =   7200
      TabIndex        =   4
      Top             =   3840
      Width           =   1215
   End
   Begin VB.CheckBox Check4 
      BackColor       =   &H00C0FFFF&
      Caption         =   "3"
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
      Height          =   495
      Left            =   7200
      TabIndex        =   3
      Top             =   3240
      Width           =   1215
   End
   Begin VB.CheckBox Check3 
      BackColor       =   &H00C0FFFF&
      Caption         =   "2"
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
      Height          =   495
      Left            =   7200
      TabIndex        =   2
      Top             =   2640
      Width           =   1215
   End
   Begin VB.CheckBox Check2 
      BackColor       =   &H00C0FFFF&
      Caption         =   "1"
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
      Height          =   495
      Left            =   7200
      TabIndex        =   1
      Top             =   2040
      Width           =   1215
   End
   Begin VB.CheckBox Check1 
      BackColor       =   &H00C0FFFF&
      Caption         =   "0"
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
      Height          =   495
      Left            =   7200
      TabIndex        =   0
      Top             =   1440
      Width           =   1215
   End
End
Attribute VB_Name = "Form2"
Attribute VB_GlobalNameSpace = False
Attribute VB_Creatable = False
Attribute VB_PredeclaredId = True
Attribute VB_Exposed = False
Dim sum
Private Sub Command1_Click()
sum = 0
If Check1.Value = Checked Then
sum = sum + Val(Check1.Caption)
End If

If Check2.Value = Checked Then
sum = sum + Val(Check2.Caption)
End If

If Check3.Value = Checked Then
sum = sum + Val(Check3.Caption)
End If

If Check4.Value = Checked Then
sum = sum + Val(Check4.Caption)
End If

If Check5.Value = Checked Then
sum = sum + Val(Check5.Caption)
End If

If Check6.Value = Checked Then
sum = sum + Val(Check6.Caption)
End If

If Check7.Value = Checked Then
sum = sum + Val(Check7.Caption)
End If

If Check8.Value = Checked Then
sum = sum + Val(Check8.Caption)
End If

If Check9.Value = Checked Then
sum = sum + Val(Check9.Caption)
End If

If Check10.Value = Checked Then
sum = sum + Val(Check10.Caption)
End If

Form2.Print "SUM IS:" + CStr(sum)
End Sub

