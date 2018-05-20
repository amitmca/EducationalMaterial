VERSION 5.00
Begin VB.Form Form1 
   AutoRedraw      =   -1  'True
   Caption         =   "Form1"
   ClientHeight    =   4755
   ClientLeft      =   60
   ClientTop       =   450
   ClientWidth     =   7200
   DrawStyle       =   1  'Dash
   LinkTopic       =   "Form1"
   ScaleHeight     =   4755
   ScaleWidth      =   7200
   StartUpPosition =   3  'Windows Default
   Begin VB.HScrollBar HScroll3 
      Height          =   495
      Left            =   600
      TabIndex        =   2
      Top             =   3000
      Width           =   5415
   End
   Begin VB.HScrollBar HScroll2 
      Height          =   495
      Left            =   600
      TabIndex        =   1
      Top             =   1920
      Width           =   5415
   End
   Begin VB.HScrollBar HScroll1 
      Height          =   495
      Left            =   600
      TabIndex        =   0
      Top             =   720
      Width           =   5415
   End
   Begin VB.Label Label5 
      AutoSize        =   -1  'True
      Caption         =   "max"
      Height          =   195
      Left            =   5640
      TabIndex        =   7
      Top             =   1320
      Width           =   285
   End
   Begin VB.Label Label4 
      AutoSize        =   -1  'True
      Caption         =   "min"
      Height          =   195
      Left            =   600
      TabIndex        =   6
      Top             =   1320
      Width           =   240
   End
   Begin VB.Label Label3 
      AutoSize        =   -1  'True
      Caption         =   "THIRD"
      BeginProperty Font 
         Name            =   "Times New Roman"
         Size            =   15.75
         Charset         =   0
         Weight          =   700
         Underline       =   0   'False
         Italic          =   0   'False
         Strikethrough   =   0   'False
      EndProperty
      Height          =   360
      Left            =   2760
      TabIndex        =   5
      Top             =   2520
      Width           =   990
   End
   Begin VB.Label Label2 
      AutoSize        =   -1  'True
      Caption         =   "SECOND"
      BeginProperty Font 
         Name            =   "MS Sans Serif"
         Size            =   13.5
         Charset         =   0
         Weight          =   700
         Underline       =   0   'False
         Italic          =   0   'False
         Strikethrough   =   0   'False
      EndProperty
      Height          =   360
      Left            =   2760
      TabIndex        =   4
      Top             =   1440
      Width           =   1305
   End
   Begin VB.Label Label1 
      AutoSize        =   -1  'True
      Caption         =   "FIRST"
      BeginProperty Font 
         Name            =   "Times New Roman"
         Size            =   15.75
         Charset         =   0
         Weight          =   700
         Underline       =   0   'False
         Italic          =   0   'False
         Strikethrough   =   0   'False
      EndProperty
      Height          =   360
      Left            =   2880
      TabIndex        =   3
      Top             =   240
      Width           =   915
   End
End
Attribute VB_Name = "Form1"
Attribute VB_GlobalNameSpace = False
Attribute VB_Creatable = False
Attribute VB_PredeclaredId = True
Attribute VB_Exposed = False
Private Sub Form_Load()
HScroll1.Min = 0
HScroll2.Min = 0
HScroll3.Min = 0
HScroll1.Max = 255
HScroll2.Max = 255
HScroll3.Max = 255
End Sub

Private Sub HScroll1_Change()
r = HScroll1.Value
g = HScroll1.Value
b = HScroll1.Value
Label1.BackColor = RGB(r, g, b)
End Sub

Private Sub HScroll2_Change()
r = HScroll2.Value
g = HScroll2.Value
b = HScroll2.Value
Label2.BackColor = RGB(r, g, b)
End Sub

Private Sub HScroll3_Change()
r = HScroll3.Value
g = HScroll3.Value
b = HScroll3.Value
Label3.BackColor = RGB(r, g, b)
End Sub
