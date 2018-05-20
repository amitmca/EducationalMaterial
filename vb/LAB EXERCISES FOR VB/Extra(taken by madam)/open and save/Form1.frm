VERSION 5.00
Object = "{F9043C88-F6F2-101A-A3C9-08002B2F49FB}#1.2#0"; "COMDLG32.OCX"
Begin VB.Form Form1 
   AutoRedraw      =   -1  'True
   Caption         =   "Form1"
   ClientHeight    =   4710
   ClientLeft      =   60
   ClientTop       =   450
   ClientWidth     =   6105
   LinkTopic       =   "Form1"
   ScaleHeight     =   4710
   ScaleWidth      =   6105
   StartUpPosition =   3  'Windows Default
   Begin VB.TextBox Text1 
      Height          =   375
      Left            =   1320
      TabIndex        =   3
      Text            =   " "
      Top             =   960
      Width           =   3135
   End
   Begin VB.CommandButton Command3 
      Caption         =   "FONT"
      Height          =   435
      Left            =   4440
      TabIndex        =   2
      Top             =   1920
      Width           =   1455
   End
   Begin VB.CommandButton Command2 
      Caption         =   "SAVE"
      Height          =   375
      Left            =   2400
      TabIndex        =   1
      Top             =   1920
      Width           =   1335
   End
   Begin VB.CommandButton Command1 
      Caption         =   "OPEN"
      Height          =   375
      Left            =   240
      TabIndex        =   0
      Top             =   1920
      Width           =   1455
   End
   Begin MSComDlg.CommonDialog cd1 
      Left            =   1440
      Top             =   3360
      _ExtentX        =   847
      _ExtentY        =   847
      _Version        =   393216
      Flags           =   1
   End
End
Attribute VB_Name = "Form1"
Attribute VB_GlobalNameSpace = False
Attribute VB_Creatable = False
Attribute VB_PredeclaredId = True
Attribute VB_Exposed = False
Private Sub Command1_Click()
'cd1.ShowOpen
'cd1.ShowSave
cd1.ShowFont
Text1.Font = cd1.FontName
Text1.Font = cd1.FontSize
End Sub

