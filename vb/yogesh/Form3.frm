VERSION 5.00
Begin VB.Form Form3 
   Caption         =   "Form3"
   ClientHeight    =   3090
   ClientLeft      =   60
   ClientTop       =   450
   ClientWidth     =   4680
   LinkTopic       =   "Form3"
   ScaleHeight     =   3090
   ScaleWidth      =   4680
   StartUpPosition =   3  'Windows Default
   Begin VB.VScrollBar VScroll3 
      Height          =   2295
      Left            =   2400
      TabIndex        =   2
      Top             =   360
      Width           =   975
   End
   Begin VB.VScrollBar VScroll2 
      Height          =   2055
      Left            =   1560
      TabIndex        =   1
      Top             =   600
      Width           =   735
   End
   Begin VB.VScrollBar VScroll1 
      Height          =   2175
      Left            =   720
      TabIndex        =   0
      Top             =   480
      Width           =   615
   End
End
Attribute VB_Name = "Form3"
Attribute VB_GlobalNameSpace = False
Attribute VB_Creatable = False
Attribute VB_PredeclaredId = True
Attribute VB_Exposed = False
Option Explicit
Dim r, g, b

Private Sub form3_load()
VScroll1 .Min = 0
VScroll2.Min = 0
VScroll3.Min = 0
VScroll1 .Max = 255
VScroll2.Max = 255
VScroll3.Max = 255
Form3.AutoRedraw = True

End Sub


Private Sub VScroll1_Scroll()
r = VScroll1.Value
g = VScroll2.Value
b = VScroll3.Value
Form3.BackColor = RGB(r, g, b)
End Sub

Private Sub VScroll2_Change()

r = VScroll1.Value
g = VScroll2.Value
b = VScroll3.Value
Form3.BackColor = RGB(r, g, b)

End Sub

Private Sub VScroll3_Change()
r = VScroll1.Value
g = VScroll2.Value
b = VScroll3.Value
Form3.BackColor = RGB(r, g, b)

End Sub

