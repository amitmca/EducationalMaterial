VERSION 5.00
Begin VB.Form Form2 
   BackColor       =   &H00C0FFC0&
   Caption         =   "Form2"
   ClientHeight    =   6870
   ClientLeft      =   60
   ClientTop       =   345
   ClientWidth     =   8415
   LinkTopic       =   "Form2"
   ScaleHeight     =   6870
   ScaleWidth      =   8415
   StartUpPosition =   3  'Windows Default
   Begin VB.Frame Frame3 
      Caption         =   "Frame3"
      Height          =   5175
      Left            =   480
      TabIndex        =   0
      Top             =   360
      Width           =   6975
      Begin VB.CommandButton cmdCancel 
         Caption         =   "Cancel"
         Height          =   615
         Left            =   5280
         TabIndex        =   10
         Top             =   3960
         Width           =   1095
      End
      Begin VB.Frame Frame2 
         Caption         =   "Frame2"
         Height          =   1695
         Left            =   840
         TabIndex        =   6
         Top             =   1680
         Width           =   5655
         Begin VB.CommandButton cmdOk 
            Caption         =   "ok"
            Height          =   495
            Left            =   2040
            TabIndex        =   9
            Top             =   960
            Width           =   975
         End
         Begin VB.ComboBox cmboSize 
            Height          =   315
            ItemData        =   "Form2.frx":0000
            Left            =   3000
            List            =   "Form2.frx":0022
            TabIndex        =   8
            Text            =   "Combo2"
            Top             =   360
            Width           =   1935
         End
         Begin VB.ComboBox cmboFont 
            Height          =   315
            ItemData        =   "Form2.frx":004D
            Left            =   120
            List            =   "Form2.frx":0057
            TabIndex        =   7
            Text            =   "Combo1"
            Top             =   360
            Width           =   1935
         End
      End
      Begin VB.Frame Frame1 
         Caption         =   "Font  Style"
         Height          =   1215
         Left            =   960
         TabIndex        =   2
         Top             =   3600
         Width           =   3975
         Begin VB.CommandButton cmdUnder 
            BackColor       =   &H00FFC0FF&
            Caption         =   "U"
            BeginProperty Font 
               Name            =   "Times New Roman"
               Size            =   14.25
               Charset         =   0
               Weight          =   700
               Underline       =   0   'False
               Italic          =   0   'False
               Strikethrough   =   0   'False
            EndProperty
            Height          =   495
            Left            =   1920
            Style           =   1  'Graphical
            TabIndex        =   5
            Top             =   360
            Width           =   615
         End
         Begin VB.CommandButton cmdItalic 
            BackColor       =   &H00FFC0FF&
            Caption         =   "I"
            BeginProperty Font 
               Name            =   "Times New Roman"
               Size            =   14.25
               Charset         =   0
               Weight          =   700
               Underline       =   0   'False
               Italic          =   0   'False
               Strikethrough   =   0   'False
            EndProperty
            Height          =   495
            Left            =   1200
            Style           =   1  'Graphical
            TabIndex        =   4
            Top             =   360
            Width           =   615
         End
         Begin VB.CommandButton cmdBold 
            BackColor       =   &H00FFC0FF&
            Caption         =   "B"
            BeginProperty Font 
               Name            =   "Times New Roman"
               Size            =   14.25
               Charset         =   0
               Weight          =   700
               Underline       =   0   'False
               Italic          =   0   'False
               Strikethrough   =   0   'False
            EndProperty
            Height          =   495
            Left            =   480
            Style           =   1  'Graphical
            TabIndex        =   3
            Top             =   360
            Width           =   615
         End
      End
      Begin VB.TextBox Text1 
         BeginProperty Font 
            Name            =   "Times New Roman"
            Size            =   11.25
            Charset         =   0
            Weight          =   400
            Underline       =   0   'False
            Italic          =   0   'False
            Strikethrough   =   0   'False
         EndProperty
         Height          =   735
         Left            =   840
         TabIndex        =   1
         Text            =   " "
         Top             =   480
         Width           =   5655
      End
   End
End
Attribute VB_Name = "Form2"
Attribute VB_GlobalNameSpace = False
Attribute VB_Creatable = False
Attribute VB_PredeclaredId = True
Attribute VB_Exposed = False



Private Sub cmdBold_Click()
Text1.FontBold = True
End Sub

Private Sub cmdCancel_Click()
End
End Sub

Private Sub cmdItalic_Click()
Text1.FontItalic = True
End Sub

Private Sub cmdOk_Click()
Text1.FontName = cmboFont.Text
Text1.FontSize = cmboSize.Text

End Sub

Private Sub cmdUnder_Click()
Text1.FontUnderline = True
End Sub

Private Sub Form_Load()
For i = 0 To Screen.FontCount - 1
cmboFont.AddItem (Screen.Fonts(i))
Next i

cmboFont.Text = cmboFont.List(1)
cmboSize.Text = 8
End Sub

