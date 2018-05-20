VERSION 5.00
Begin VB.Form Form2 
   AutoRedraw      =   -1  'True
   BackColor       =   &H00C0FFC0&
   Caption         =   "Form2"
   ClientHeight    =   5310
   ClientLeft      =   60
   ClientTop       =   450
   ClientWidth     =   8355
   LinkTopic       =   "Form2"
   ScaleHeight     =   5310
   ScaleWidth      =   8355
   StartUpPosition =   3  'Windows Default
   Begin VB.TextBox Text2 
      ForeColor       =   &H00FF0000&
      Height          =   1575
      Left            =   2160
      TabIndex        =   3
      Text            =   " "
      Top             =   1680
      Width           =   4335
   End
   Begin VB.TextBox Text1 
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
      Height          =   495
      Left            =   4440
      TabIndex        =   1
      Top             =   4440
      Width           =   1095
   End
   Begin VB.HScrollBar HScroll1 
      Height          =   375
      Left            =   1080
      Max             =   72
      Min             =   10
      TabIndex        =   0
      Top             =   3840
      Value           =   10
      Width           =   5895
   End
   Begin VB.Label Label2 
      AutoSize        =   -1  'True
      BackColor       =   &H00C0FFC0&
      Caption         =   "CURRENT FONT SIZE"
      BeginProperty Font 
         Name            =   "Times New Roman"
         Size            =   14.25
         Charset         =   0
         Weight          =   700
         Underline       =   0   'False
         Italic          =   0   'False
         Strikethrough   =   0   'False
      EndProperty
      ForeColor       =   &H00800080&
      Height          =   330
      Left            =   1200
      TabIndex        =   2
      Top             =   4560
      Width           =   3030
   End
End
Attribute VB_Name = "Form2"
Attribute VB_GlobalNameSpace = False
Attribute VB_Creatable = False
Attribute VB_PredeclaredId = True
Attribute VB_Exposed = False
Dim v
Private Sub HScroll1_Change()
v = HScroll1.Value
Text2.FontSize = v
Text1.Text = v
End Sub

