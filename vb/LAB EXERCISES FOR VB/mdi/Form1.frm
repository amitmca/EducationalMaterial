VERSION 5.00
Begin VB.Form Form1 
   Caption         =   "Form1"
   ClientHeight    =   3090
   ClientLeft      =   165
   ClientTop       =   855
   ClientWidth     =   4680
   LinkTopic       =   "Form1"
   ScaleHeight     =   3090
   ScaleWidth      =   4680
   StartUpPosition =   3  'Windows Default
   Begin VB.Menu file 
      Caption         =   "File"
      Begin VB.Menu new 
         Caption         =   "New"
      End
      Begin VB.Menu open 
         Caption         =   "Open"
      End
      Begin VB.Menu save 
         Caption         =   "Save"
      End
   End
   Begin VB.Menu color 
      Caption         =   "Colors"
      Begin VB.Menu red 
         Caption         =   "Red"
      End
      Begin VB.Menu green 
         Caption         =   "Green"
      End
      Begin VB.Menu blue 
         Caption         =   "Blue"
      End
      Begin VB.Menu more 
         Caption         =   "More Colors"
         Begin VB.Menu black 
            Caption         =   "Black"
         End
         Begin VB.Menu yellow 
            Caption         =   "Yellow"
         End
      End
   End
End
Attribute VB_Name = "Form1"
Attribute VB_GlobalNameSpace = False
Attribute VB_Creatable = False
Attribute VB_PredeclaredId = True
Attribute VB_Exposed = False
Private Sub black_Click()
Form1.BackColor = RGB(255, 200, 200)
End Sub

Private Sub blue_Click()
Form1.BackColor = RGB(0, 0, 255)
End Sub

Private Sub green_Click()
Form1.BackColor = RGB(0, 255, 0)
End Sub

Private Sub red_Click()
Form1.BackColor = RGB(255, 0, 0)
End Sub
