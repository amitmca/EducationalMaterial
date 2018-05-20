VERSION 5.00
Begin VB.Form Form4 
   AutoRedraw      =   -1  'True
   Caption         =   "Form4"
   ClientHeight    =   5985
   ClientLeft      =   60
   ClientTop       =   450
   ClientWidth     =   8580
   LinkTopic       =   "Form4"
   ScaleHeight     =   5985
   ScaleWidth      =   8580
   StartUpPosition =   3  'Windows Default
   Begin VB.CommandButton cmdCancel 
      Caption         =   "Cancel"
      Height          =   375
      Left            =   3840
      TabIndex        =   2
      Top             =   2520
      Width           =   735
   End
   Begin VB.CommandButton cmdOk 
      Caption         =   "OK"
      Height          =   375
      Left            =   2520
      TabIndex        =   1
      Top             =   2520
      Width           =   855
   End
   Begin VB.TextBox Text1 
      ForeColor       =   &H00000000&
      Height          =   495
      Left            =   2160
      TabIndex        =   0
      Tag             =   " "
      Text            =   " "
      Top             =   1680
      Width           =   2895
   End
   Begin VB.Label Label1 
      AutoSize        =   -1  'True
      Caption         =   "AMIT"
      BeginProperty Font 
         Name            =   "Times New Roman"
         Size            =   14.25
         Charset         =   0
         Weight          =   700
         Underline       =   0   'False
         Italic          =   0   'False
         Strikethrough   =   0   'False
      EndProperty
      Height          =   330
      Left            =   720
      TabIndex        =   3
      Top             =   960
      Width           =   765
   End
End
Attribute VB_Name = "Form4"
Attribute VB_GlobalNameSpace = False
Attribute VB_Creatable = False
Attribute VB_PredeclaredId = True
Attribute VB_Exposed = False
Option Explicit
Dim str As String

Private Sub cmdCancel_Click()
End
End Sub

Private Sub cmdOk_Click()

str = Text1.Text

If str = red Then
Label1.BackColor = RGB(255, 0, 0)
'Form4.BackColor = RGB(255, 0, 0)

End If
End Sub

