VERSION 5.00
Begin VB.Form frmChild2 
   Caption         =   "Form1"
   ClientHeight    =   3090
   ClientLeft      =   60
   ClientTop       =   750
   ClientWidth     =   4680
   LinkTopic       =   "Form1"
   MDIChild        =   -1  'True
   ScaleHeight     =   3090
   ScaleWidth      =   4680
   Begin VB.Menu file 
      Caption         =   "File"
      Begin VB.Menu new 
         Caption         =   "New"
      End
      Begin VB.Menu open 
         Caption         =   "Open"
         Shortcut        =   ^O
      End
      Begin VB.Menu save 
         Caption         =   "Save"
         Shortcut        =   ^S
      End
   End
   Begin VB.Menu color 
      Caption         =   "Color"
      Begin VB.Menu red 
         Caption         =   "Red"
      End
      Begin VB.Menu green 
         Caption         =   "Green"
      End
      Begin VB.Menu blue 
         Caption         =   "Blue"
         Begin VB.Menu more 
            Caption         =   "More Colors"
            Begin VB.Menu yellow 
               Caption         =   "Yellow"
            End
            Begin VB.Menu black 
               Caption         =   "Black"
            End
            Begin VB.Menu mag 
               Caption         =   "Magenta"
            End
         End
      End
   End
End
Attribute VB_Name = "frmChild2"
Attribute VB_GlobalNameSpace = False
Attribute VB_Creatable = False
Attribute VB_PredeclaredId = True
Attribute VB_Exposed = False
