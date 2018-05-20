VERSION 5.00
Begin VB.Form Form2 
   BackColor       =   &H00FFFFC0&
   Caption         =   "Form2"
   ClientHeight    =   7935
   ClientLeft      =   60
   ClientTop       =   450
   ClientWidth     =   10515
   LinkTopic       =   "Form2"
   ScaleHeight     =   7935
   ScaleWidth      =   10515
   StartUpPosition =   3  'Windows Default
   Begin VB.Frame Frame2 
      Caption         =   "Frame2"
      Height          =   975
      Left            =   1440
      TabIndex        =   13
      Top             =   4080
      Width           =   6855
      Begin VB.CommandButton Command2 
         BackColor       =   &H00FFC0FF&
         Caption         =   "SAVE"
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
         Left            =   3840
         Style           =   1  'Graphical
         TabIndex        =   15
         Top             =   240
         Width           =   1455
      End
      Begin VB.CommandButton Command1 
         BackColor       =   &H00FFC0FF&
         Caption         =   "ADD"
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
         Left            =   1680
         Style           =   1  'Graphical
         TabIndex        =   14
         Top             =   240
         Width           =   1575
      End
   End
   Begin VB.Data Data1 
      Caption         =   "Data1"
      Connect         =   "Access"
      DatabaseName    =   "D:\My  Programs\VB\LAB EXERCISES FOR VB\Database Program\book1.mdb"
      DefaultCursorType=   0  'DefaultCursor
      DefaultType     =   2  'UseODBC
      Exclusive       =   0   'False
      Height          =   300
      Left            =   2160
      Options         =   0
      ReadOnly        =   0   'False
      RecordsetType   =   1  'Dynaset
      RecordSource    =   "book"
      Top             =   7440
      Width           =   5535
   End
   Begin VB.Frame Frame1 
      Caption         =   "Frame1"
      Height          =   4095
      Left            =   1440
      TabIndex        =   0
      Top             =   0
      Width           =   6855
      Begin VB.TextBox Text6 
         DataField       =   "price"
         DataSource      =   "Data1"
         Height          =   375
         Left            =   3480
         TabIndex        =   12
         Text            =   " "
         Top             =   3480
         Width           =   3135
      End
      Begin VB.TextBox Text5 
         DataField       =   "edition"
         DataSource      =   "Data1"
         Height          =   375
         Left            =   3480
         TabIndex        =   11
         Text            =   " "
         Top             =   2880
         Width           =   3135
      End
      Begin VB.TextBox Text4 
         DataField       =   "pub"
         DataSource      =   "Data1"
         Height          =   375
         Left            =   3480
         TabIndex        =   10
         Text            =   " "
         Top             =   2280
         Width           =   3135
      End
      Begin VB.TextBox Text3 
         DataField       =   "aname"
         DataSource      =   "Data1"
         Height          =   375
         Left            =   3480
         TabIndex        =   9
         Text            =   " "
         Top             =   1680
         Width           =   3135
      End
      Begin VB.TextBox Text2 
         DataField       =   "bname"
         DataSource      =   "Data1"
         Height          =   375
         Left            =   3480
         TabIndex        =   8
         Text            =   " "
         Top             =   1080
         Width           =   3135
      End
      Begin VB.TextBox Text1 
         DataField       =   "bno"
         DataSource      =   "Data1"
         Height          =   375
         Left            =   3480
         TabIndex        =   7
         Text            =   " "
         Top             =   480
         Width           =   3135
      End
      Begin VB.Label Label6 
         AutoSize        =   -1  'True
         Caption         =   "PRICE"
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
         Height          =   330
         Left            =   360
         TabIndex        =   6
         Top             =   3600
         Width           =   1020
      End
      Begin VB.Label Label5 
         AutoSize        =   -1  'True
         Caption         =   "EDITION"
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
         Height          =   330
         Left            =   360
         TabIndex        =   5
         Top             =   3000
         Width           =   1365
      End
      Begin VB.Label Label4 
         AutoSize        =   -1  'True
         Caption         =   "PUBLICATION"
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
         Height          =   330
         Left            =   360
         TabIndex        =   4
         Top             =   2400
         Width           =   2115
      End
      Begin VB.Label Label3 
         AutoSize        =   -1  'True
         Caption         =   "AUTHOR NAME"
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
         Height          =   330
         Left            =   360
         TabIndex        =   3
         Top             =   1800
         Width           =   2295
      End
      Begin VB.Label Label2 
         AutoSize        =   -1  'True
         Caption         =   "BOOK NAME"
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
         Height          =   330
         Left            =   360
         TabIndex        =   2
         Top             =   1200
         Width           =   1920
      End
      Begin VB.Label Label1 
         AutoSize        =   -1  'True
         Caption         =   "BOOK ID"
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
         Height          =   330
         Left            =   360
         TabIndex        =   1
         Top             =   600
         Width           =   1365
      End
   End
End
Attribute VB_Name = "Form2"
Attribute VB_GlobalNameSpace = False
Attribute VB_Creatable = False
Attribute VB_PredeclaredId = True
Attribute VB_Exposed = False
Dim bno As Integer
Private Sub Command1_Click()
Text1.Text = bno + 1
Data1.Recordset.AddNew

Text1.Text = " "
Text2.Text = " "
Text3.Text = " "
Text4.Text = " "
Text5.Text = " "
Text6.Text = " "
End Sub

Private Sub Command2_Click()
Data1.Recordset.Update
MsgBox "Record is inserted Successfully"
Data1.Refresh
End Sub

