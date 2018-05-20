VERSION 5.00
Begin VB.Form Form1 
   Caption         =   "Sample 1"
   ClientHeight    =   7425
   ClientLeft      =   60
   ClientTop       =   345
   ClientWidth     =   8730
   LinkTopic       =   "Form1"
   ScaleHeight     =   7425
   ScaleWidth      =   8730
   StartUpPosition =   3  'Windows Default
   Begin VB.CommandButton CmdUpdate 
      BackColor       =   &H0080FFFF&
      Caption         =   "Update"
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
      Left            =   4920
      Style           =   1  'Graphical
      TabIndex        =   18
      Top             =   6000
      Visible         =   0   'False
      Width           =   1215
   End
   Begin VB.CommandButton CmdAdd 
      BackColor       =   &H0080FFFF&
      Caption         =   "Add"
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
      Left            =   2040
      Style           =   1  'Graphical
      TabIndex        =   17
      Top             =   6000
      Width           =   1215
   End
   Begin VB.TextBox Text8 
      Height          =   375
      Left            =   2400
      TabIndex        =   16
      Text            =   " "
      Top             =   4200
      Width           =   4215
   End
   Begin VB.TextBox Text7 
      Height          =   375
      Left            =   2400
      TabIndex        =   15
      Text            =   " "
      Top             =   3720
      Width           =   4215
   End
   Begin VB.TextBox Text6 
      Height          =   375
      Left            =   2400
      TabIndex        =   14
      Text            =   " "
      Top             =   3240
      Width           =   4215
   End
   Begin VB.TextBox Text5 
      Height          =   375
      Left            =   2400
      TabIndex        =   13
      Text            =   " "
      Top             =   2760
      Width           =   4215
   End
   Begin VB.TextBox Text4 
      Height          =   375
      Left            =   2400
      TabIndex        =   12
      Text            =   " "
      Top             =   2280
      Width           =   4215
   End
   Begin VB.TextBox Text3 
      Height          =   375
      Left            =   2400
      TabIndex        =   11
      Text            =   " "
      Top             =   1800
      Width           =   4215
   End
   Begin VB.TextBox Text2 
      Height          =   375
      Left            =   2400
      TabIndex        =   10
      Text            =   " "
      Top             =   1320
      Width           =   4215
   End
   Begin VB.TextBox Text1 
      Height          =   375
      Left            =   2400
      TabIndex        =   9
      Top             =   840
      Width           =   4215
   End
   Begin VB.Data Data1 
      Caption         =   "Data1"
      Connect         =   "Access"
      DatabaseName    =   "D:\My  Programs\VB\LAB EXERCISES FOR VB\Database Prog\test\test.mdb"
      DefaultCursorType=   0  'DefaultCursor
      DefaultType     =   1  'UseODBC
      Exclusive       =   0   'False
      Height          =   420
      Left            =   1920
      Options         =   0
      ReadOnly        =   0   'False
      RecordsetType   =   1  'Dynaset
      RecordSource    =   ""
      Top             =   4920
      Width           =   4215
   End
   Begin VB.Label Label9 
      BackColor       =   &H00C0FFFF&
      Caption         =   "Fax             :"
      BeginProperty Font 
         Name            =   "Times New Roman"
         Size            =   14.25
         Charset         =   0
         Weight          =   700
         Underline       =   0   'False
         Italic          =   0   'False
         Strikethrough   =   0   'False
      EndProperty
      ForeColor       =   &H000000FF&
      Height          =   375
      Left            =   240
      TabIndex        =   8
      Top             =   4200
      Width           =   1575
   End
   Begin VB.Label Label8 
      BackColor       =   &H00C0FFFF&
      Caption         =   "Phone         :"
      BeginProperty Font 
         Name            =   "Times New Roman"
         Size            =   14.25
         Charset         =   0
         Weight          =   700
         Underline       =   0   'False
         Italic          =   0   'False
         Strikethrough   =   0   'False
      EndProperty
      ForeColor       =   &H000000FF&
      Height          =   375
      Left            =   240
      TabIndex        =   7
      Top             =   3720
      Width           =   1575
   End
   Begin VB.Label Label7 
      BackColor       =   &H00C0FFFF&
      Caption         =   "Zip Code    :"
      BeginProperty Font 
         Name            =   "Times New Roman"
         Size            =   14.25
         Charset         =   0
         Weight          =   700
         Underline       =   0   'False
         Italic          =   0   'False
         Strikethrough   =   0   'False
      EndProperty
      ForeColor       =   &H000000FF&
      Height          =   375
      Left            =   240
      TabIndex        =   6
      Top             =   3240
      Width           =   1575
   End
   Begin VB.Label Label6 
      BackColor       =   &H00C0FFFF&
      Caption         =   "State          :"
      BeginProperty Font 
         Name            =   "Times New Roman"
         Size            =   14.25
         Charset         =   0
         Weight          =   700
         Underline       =   0   'False
         Italic          =   0   'False
         Strikethrough   =   0   'False
      EndProperty
      ForeColor       =   &H000000FF&
      Height          =   375
      Left            =   240
      TabIndex        =   5
      Top             =   2760
      Width           =   1575
   End
   Begin VB.Label Label5 
      BackColor       =   &H00C0FFFF&
      Caption         =   "City            :"
      BeginProperty Font 
         Name            =   "Times New Roman"
         Size            =   14.25
         Charset         =   0
         Weight          =   700
         Underline       =   0   'False
         Italic          =   0   'False
         Strikethrough   =   0   'False
      EndProperty
      ForeColor       =   &H000000FF&
      Height          =   375
      Left            =   240
      TabIndex        =   4
      Top             =   2280
      Width           =   1575
   End
   Begin VB.Label Label4 
      BackColor       =   &H00C0FFFF&
      Caption         =   "Address      :"
      BeginProperty Font 
         Name            =   "Times New Roman"
         Size            =   14.25
         Charset         =   0
         Weight          =   700
         Underline       =   0   'False
         Italic          =   0   'False
         Strikethrough   =   0   'False
      EndProperty
      ForeColor       =   &H000000FF&
      Height          =   375
      Left            =   240
      TabIndex        =   3
      Top             =   1800
      Width           =   1575
   End
   Begin VB.Label Label3 
      BackColor       =   &H00C0FFFF&
      Caption         =   "Last Name  :"
      BeginProperty Font 
         Name            =   "Times New Roman"
         Size            =   14.25
         Charset         =   0
         Weight          =   700
         Underline       =   0   'False
         Italic          =   0   'False
         Strikethrough   =   0   'False
      EndProperty
      ForeColor       =   &H000000FF&
      Height          =   375
      Left            =   240
      TabIndex        =   2
      Top             =   1320
      Width           =   1575
   End
   Begin VB.Label Label2 
      BackColor       =   &H00C0FFFF&
      Caption         =   "First Name :"
      BeginProperty Font 
         Name            =   "Times New Roman"
         Size            =   14.25
         Charset         =   0
         Weight          =   700
         Underline       =   0   'False
         Italic          =   0   'False
         Strikethrough   =   0   'False
      EndProperty
      ForeColor       =   &H000000FF&
      Height          =   375
      Left            =   240
      TabIndex        =   1
      Top             =   840
      Width           =   1575
   End
   Begin VB.Label Label1 
      AutoSize        =   -1  'True
      BackColor       =   &H00C0FFFF&
      Caption         =   "Record ID  : "
      BeginProperty Font 
         Name            =   "Times New Roman"
         Size            =   14.25
         Charset         =   0
         Weight          =   700
         Underline       =   0   'False
         Italic          =   0   'False
         Strikethrough   =   0   'False
      EndProperty
      ForeColor       =   &H000000FF&
      Height          =   450
      Left            =   240
      TabIndex        =   0
      Top             =   240
      Width           =   1590
   End
End
Attribute VB_Name = "Form1"
Attribute VB_GlobalNameSpace = False
Attribute VB_Creatable = False
Attribute VB_PredeclaredId = True
Attribute VB_Exposed = False
Private Sub CmdAdd_Click()
Data1.Recordset.AddNew
CmdAdd.Visible = False
CmdUpdate.Visible = True
End Sub

Private Sub CmdUpdate_Click()
Data1.Recordset.Update
CmdAdd.Visible = True
CmdUpdate.Visible = False
End Sub
