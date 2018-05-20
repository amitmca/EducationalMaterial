VERSION 5.00
Begin VB.Form Form2 
   Caption         =   "Form2"
   ClientHeight    =   5685
   ClientLeft      =   60
   ClientTop       =   450
   ClientWidth     =   8235
   LinkTopic       =   "Form2"
   ScaleHeight     =   5685
   ScaleWidth      =   8235
   StartUpPosition =   3  'Windows Default
   Begin VB.FileListBox File1 
      Height          =   2235
      Left            =   4320
      TabIndex        =   2
      Top             =   3120
      Width           =   3855
   End
   Begin VB.DirListBox Dir1 
      Height          =   1890
      Left            =   1440
      TabIndex        =   1
      Top             =   960
      Width           =   2895
   End
   Begin VB.DriveListBox Drive1 
      Height          =   315
      Left            =   1080
      TabIndex        =   0
      Top             =   480
      Width           =   1815
   End
End
Attribute VB_Name = "Form2"
Attribute VB_GlobalNameSpace = False
Attribute VB_Creatable = False
Attribute VB_PredeclaredId = True
Attribute VB_Exposed = False
Private Sub Drive1_Change()
Dir1.Path = Drive1.Drive
End Sub

Private Sub File1_Click()
File1.Path = Dir1.Path
If File1.Path =


End Sub
