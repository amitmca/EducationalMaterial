VERSION 5.00
Begin VB.Form frmChild1 
   Caption         =   "Form1"
   ClientHeight    =   3090
   ClientLeft      =   60
   ClientTop       =   750
   ClientWidth     =   4680
   LinkTopic       =   "Form1"
   MDIChild        =   -1  'True
   ScaleHeight     =   3090
   ScaleWidth      =   4680
   Begin VB.Menu edit 
      Caption         =   "Edit"
      Begin VB.Menu cut 
         Caption         =   "Cut"
         Shortcut        =   ^X
      End
      Begin VB.Menu copy 
         Caption         =   "Copy"
         Shortcut        =   ^C
      End
      Begin VB.Menu paste 
         Caption         =   "Paste"
         Shortcut        =   ^V
      End
   End
End
Attribute VB_Name = "frmChild1"
Attribute VB_GlobalNameSpace = False
Attribute VB_Creatable = False
Attribute VB_PredeclaredId = True
Attribute VB_Exposed = False
