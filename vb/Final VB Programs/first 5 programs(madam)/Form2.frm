VERSION 5.00
Begin VB.Form Form3 
   Caption         =   "Form3"
   ClientHeight    =   7785
   ClientLeft      =   60
   ClientTop       =   450
   ClientWidth     =   9510
   LinkTopic       =   "Form3"
   ScaleHeight     =   7785
   ScaleWidth      =   9510
   StartUpPosition =   3  'Windows Default
   Begin VB.CommandButton Command1 
      Caption         =   "ADD"
      Height          =   855
      Left            =   4200
      TabIndex        =   10
      Top             =   3240
      Width           =   2775
   End
   Begin VB.CheckBox Check10 
      Caption         =   "9"
      Height          =   495
      Left            =   0
      TabIndex        =   9
      Top             =   7200
      Width           =   1215
   End
   Begin VB.CheckBox Check9 
      Caption         =   "8"
      Height          =   495
      Left            =   0
      TabIndex        =   8
      Top             =   6600
      Width           =   1215
   End
   Begin VB.CheckBox Check8 
      Caption         =   "7"
      Height          =   495
      Left            =   0
      TabIndex        =   7
      Top             =   6000
      Width           =   1215
   End
   Begin VB.CheckBox Check7 
      Caption         =   "6"
      Height          =   495
      Left            =   0
      TabIndex        =   6
      Top             =   5400
      Width           =   1215
   End
   Begin VB.CheckBox Check6 
      Caption         =   "5"
      Height          =   495
      Left            =   0
      TabIndex        =   5
      Top             =   4800
      Width           =   1215
   End
   Begin VB.CheckBox Check5 
      Caption         =   "4"
      Height          =   495
      Left            =   0
      TabIndex        =   4
      Top             =   4200
      Width           =   1215
   End
   Begin VB.CheckBox Check4 
      Caption         =   "3"
      Height          =   495
      Left            =   0
      TabIndex        =   3
      Top             =   3600
      Width           =   1215
   End
   Begin VB.CheckBox Check3 
      Caption         =   "2"
      Height          =   495
      Left            =   0
      TabIndex        =   2
      Top             =   3000
      Width           =   1215
   End
   Begin VB.CheckBox Check2 
      Caption         =   "1"
      Height          =   495
      Left            =   0
      TabIndex        =   1
      Top             =   2400
      Width           =   1215
   End
   Begin VB.CheckBox Check1 
      Caption         =   "0"
      Height          =   495
      Left            =   0
      TabIndex        =   0
      Top             =   1800
      Width           =   1215
   End
End
Attribute VB_Name = "Form3"
Attribute VB_GlobalNameSpace = False
Attribute VB_Creatable = False
Attribute VB_PredeclaredId = True
Attribute VB_Exposed = False
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

Form3.Print sum
End Sub

Private Sub Form_Load()
sum = 0
End Sub
