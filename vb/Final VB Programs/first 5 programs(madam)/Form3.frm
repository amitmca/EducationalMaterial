VERSION 5.00
Begin VB.Form Form1 
   AutoRedraw      =   -1  'True
   Caption         =   "Form1"
   ClientHeight    =   3195
   ClientLeft      =   60
   ClientTop       =   345
   ClientWidth     =   4680
   LinkTopic       =   "Form1"
   ScaleHeight     =   3195
   ScaleWidth      =   4680
   StartUpPosition =   3  'Windows Default
   Begin VB.OptionButton Option3 
      Caption         =   "Avg"
      Height          =   495
      Left            =   2760
      TabIndex        =   2
      Top             =   2040
      Width           =   1215
   End
   Begin VB.OptionButton Option2 
      Caption         =   "Min"
      Height          =   495
      Left            =   1440
      TabIndex        =   1
      Top             =   2040
      Width           =   1215
   End
   Begin VB.OptionButton Option1 
      Caption         =   "Max"
      Height          =   495
      Left            =   120
      TabIndex        =   0
      Top             =   2040
      Width           =   1455
   End
End
Attribute VB_Name = "Form1"
Attribute VB_GlobalNameSpace = False
Attribute VB_Creatable = False
Attribute VB_PredeclaredId = True
Attribute VB_Exposed = False
Private Sub Option1_Click()
a = InputBox("First Number:")
b = InputBox("Second Number:")
If Option1.Value = True Then
If a > b Then
Form1.Print "maximum is:" + CStr(a)
Else
Form1.Print "Maximum is:" + CStr(b)
End If
End If
End Sub

Private Sub Option2_Click()
x = InputBox("First Number:")
y = InputBox("Second Number:")
If Option2.Value = True Then
If x < y Then
Form1.Print "Minimum is:" + CStr(x)
Else
Form1.Print "Minimum is:" + CStr(y)
End If
End If
End Sub

Private Sub Option3_Click()
p = InputBox("First Number:")
q = InputBox("Second Number:")
r = (p + q) / 2
Form1.Print "Average is:" + CStr(r)
End Sub
