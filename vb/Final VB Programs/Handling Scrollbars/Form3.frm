VERSION 5.00
Begin VB.Form Form3 
   Caption         =   "Form3"
   ClientHeight    =   5250
   ClientLeft      =   60
   ClientTop       =   450
   ClientWidth     =   8055
   LinkTopic       =   "Form3"
   ScaleHeight     =   5250
   ScaleWidth      =   8055
   StartUpPosition =   3  'Windows Default
   Begin VB.VScrollBar VScroll3 
      Height          =   4455
      Left            =   6840
      TabIndex        =   2
      Top             =   480
      Width           =   495
   End
   Begin VB.VScrollBar VScroll2 
      Height          =   4455
      Left            =   3480
      TabIndex        =   1
      Top             =   480
      Width           =   495
   End
   Begin VB.VScrollBar VScroll1 
      Height          =   4455
      Left            =   360
      TabIndex        =   0
      Top             =   480
      Width           =   495
   End
End
Attribute VB_Name = "Form3"
Attribute VB_GlobalNameSpace = False
Attribute VB_Creatable = False
Attribute VB_PredeclaredId = True
Attribute VB_Exposed = False
'Program for changing the background color as per the vertical scroll bar moves
Private Sub Form_Load()
Form3.AutoRedraw = True
Form3.DrawStyle = 1

VScroll1.Min = 0
VScroll2.Min = 0
VScroll3.Min = 0
VScroll1.Max = 255
VScroll2.Max = 255
VScroll3.Max = 255

End Sub

Private Sub VScroll1_Scroll()
r = VScroll1.Value
g = VScroll1.Value
b = VScroll1.Value
Form3.BackColor = RGB(r, g, b)
End Sub
Private Sub VScroll2_Scroll()

r = VScroll2.Value
g = VScroll2.Value
b = VScroll2.Value
Form3.BackColor = RGB(r, g, b)
End Sub

Private Sub VScroll3_Scroll()

r = VScroll3.Value
g = VScroll3.Value
b = VScroll3.Value
Form3.BackColor = RGB(r, g, b)
End Sub

