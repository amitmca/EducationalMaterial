VERSION 5.00
Begin VB.Form Form4 
   BackColor       =   &H00FFFFC0&
   Caption         =   "Form4"
   ClientHeight    =   5535
   ClientLeft      =   60
   ClientTop       =   450
   ClientWidth     =   8460
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
   LinkTopic       =   "Form4"
   ScaleHeight     =   5535
   ScaleWidth      =   8460
   StartUpPosition =   3  'Windows Default
   Begin VB.OptionButton Option3 
      BackColor       =   &H00FFFFC0&
      Caption         =   "AVG"
      ForeColor       =   &H000000FF&
      Height          =   495
      Left            =   6480
      TabIndex        =   2
      Top             =   2280
      Width           =   1215
   End
   Begin VB.OptionButton Option2 
      BackColor       =   &H00FFFFC0&
      Caption         =   "MAX"
      ForeColor       =   &H000000FF&
      Height          =   495
      Left            =   3480
      TabIndex        =   1
      Top             =   2280
      Width           =   1215
   End
   Begin VB.OptionButton Option1 
      BackColor       =   &H00FFFFC0&
      Caption         =   "MIN"
      ForeColor       =   &H000000FF&
      Height          =   495
      Left            =   480
      TabIndex        =   0
      Top             =   2280
      Width           =   1215
   End
End
Attribute VB_Name = "Form4"
Attribute VB_GlobalNameSpace = False
Attribute VB_Creatable = False
Attribute VB_PredeclaredId = True
Attribute VB_Exposed = False
Dim a, b As Integer
Dim c As Long
Private Sub Option1_Click()
a = InputBox("Enter First Number:")
b = InputBox("Enter Second Number:")
If Option1.Value = True Then
If a < b Then
Form4.Print "MINIMUM =:" + a
Else
Form4.Print "MINIMUM =:" + CStr(b)
End If
End If
End Sub

Private Sub Option2_Click()
If Option2.Value = True Then
If a > b Then
Form4.Print "MAXIMUM =:" + CStr(a)
Else
Form4.Print "MAXIMUM =:" + CStr(b)
End If
End If


End Sub

Private Sub Option3_Click()
If Option3.Value = True Then
c = (a + b) / 2
Form4.Print "AVERAGE =:" + CStr(c)
End If
End Sub
