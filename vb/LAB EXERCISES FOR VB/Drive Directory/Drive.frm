VERSION 5.00
Begin VB.Form Form1 
   Caption         =   "Form1"
   ClientHeight    =   6225
   ClientLeft      =   60
   ClientTop       =   450
   ClientWidth     =   7440
   LinkTopic       =   "Form1"
   ScaleHeight     =   6225
   ScaleWidth      =   7440
   StartUpPosition =   3  'Windows Default
   Begin VB.FileListBox File1 
      Height          =   1845
      Left            =   2760
      TabIndex        =   2
      Top             =   3480
      Width           =   3135
   End
   Begin VB.DirListBox Dir1 
      Height          =   2115
      Left            =   1920
      TabIndex        =   1
      Top             =   1080
      Width           =   2415
   End
   Begin VB.DriveListBox Drive1 
      Height          =   315
      Left            =   360
      TabIndex        =   0
      Top             =   480
      Width           =   2415
   End
End
Attribute VB_Name = "Form1"
Attribute VB_GlobalNameSpace = False
Attribute VB_Creatable = False
Attribute VB_PredeclaredId = True
Attribute VB_Exposed = False
Private Sub Dir1_Change()
File1.Path = Dir1.Path
End Sub

Private Sub Drive1_Change()
Dir1.Path = Drive1.Drive
End Sub
