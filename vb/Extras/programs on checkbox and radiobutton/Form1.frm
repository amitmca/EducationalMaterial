VERSION 5.00
Begin VB.Form Form1 
   AutoRedraw      =   -1  'True
   Caption         =   "Form1"
   ClientHeight    =   6180
   ClientLeft      =   60
   ClientTop       =   450
   ClientWidth     =   6915
   LinkTopic       =   "Form1"
   ScaleHeight     =   6180
   ScaleWidth      =   6915
   StartUpPosition =   3  'Windows Default
   Begin VB.CommandButton Command1 
      Caption         =   "ADD"
      Height          =   735
      Left            =   3000
      TabIndex        =   10
      Top             =   1920
      Width           =   2655
   End
   Begin VB.CheckBox Check10 
      Caption         =   "10"
      Height          =   375
      Left            =   0
      TabIndex        =   9
      Top             =   5160
      Width           =   975
   End
   Begin VB.CheckBox Check9 
      Caption         =   "9"
      Height          =   495
      Left            =   0
      TabIndex        =   8
      Top             =   4560
      Width           =   975
   End
   Begin VB.CheckBox Check8 
      Caption         =   "8"
      Height          =   375
      Left            =   0
      TabIndex        =   7
      Top             =   4080
      Width           =   975
   End
   Begin VB.CheckBox Check7 
      Caption         =   "7"
      Height          =   375
      Left            =   0
      TabIndex        =   6
      Top             =   3600
      Width           =   975
   End
   Begin VB.CheckBox Check6 
      Caption         =   "6"
      Height          =   495
      Left            =   0
      TabIndex        =   5
      Top             =   3120
      Width           =   975
   End
   Begin VB.CheckBox Check5 
      Caption         =   "5"
      Height          =   495
      Left            =   0
      TabIndex        =   4
      Top             =   2640
      Width           =   975
   End
   Begin VB.CheckBox Check4 
      Caption         =   "4"
      Height          =   375
      Left            =   0
      TabIndex        =   3
      Top             =   2280
      Width           =   975
   End
   Begin VB.CheckBox Check3 
      Caption         =   "3"
      Height          =   375
      Left            =   0
      TabIndex        =   2
      Top             =   1800
      Width           =   975
   End
   Begin VB.CheckBox Check2 
      Caption         =   "2"
      Height          =   315
      Left            =   0
      TabIndex        =   1
      Top             =   1320
      Width           =   975
   End
   Begin VB.CheckBox Check1 
      Caption         =   "1"
      Height          =   315
      Left            =   0
      TabIndex        =   0
      Top             =   840
      Width           =   1095
   End
End
Attribute VB_Name = "Form1"
Attribute VB_GlobalNameSpace = False
Attribute VB_Creatable = False
Attribute VB_PredeclaredId = True
Attribute VB_Exposed = False
Option Explicit
Dim sum As Integer
Private Sub Command1_Click()
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

Form1.Print sum

End Sub

