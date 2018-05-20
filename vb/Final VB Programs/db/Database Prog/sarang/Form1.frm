VERSION 5.00
Begin VB.Form Form1 
   BackColor       =   &H00FFC0FF&
   Caption         =   "Form1"
   ClientHeight    =   5580
   ClientLeft      =   60
   ClientTop       =   450
   ClientWidth     =   8535
   LinkTopic       =   "Form1"
   ScaleHeight     =   5580
   ScaleWidth      =   8535
   StartUpPosition =   3  'Windows Default
   Begin VB.Data Data1 
      Caption         =   "Data1"
      Connect         =   "Access"
      DatabaseName    =   "D:\My  Programs\VB\LAB EXERCISES FOR VB\Database Prog\mydb.mdb"
      DefaultCursorType=   0  'DefaultCursor
      DefaultType     =   2  'UseODBC
      Exclusive       =   0   'False
      Height          =   375
      Left            =   2280
      Options         =   0
      ReadOnly        =   0   'False
      RecordsetType   =   1  'Dynaset
      RecordSource    =   "emp1"
      Top             =   3600
      Width           =   3255
   End
   Begin VB.CommandButton Command3 
      BackColor       =   &H00C0FFC0&
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
      Left            =   6360
      Style           =   1  'Graphical
      TabIndex        =   8
      Top             =   2400
      Width           =   1215
   End
   Begin VB.CommandButton Command2 
      BackColor       =   &H00C0FFC0&
      Caption         =   "REMOVE"
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
      Left            =   3480
      Style           =   1  'Graphical
      TabIndex        =   7
      Top             =   2400
      Width           =   1335
   End
   Begin VB.CommandButton Command1 
      BackColor       =   &H00C0FFC0&
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
      Left            =   840
      Style           =   1  'Graphical
      TabIndex        =   6
      Top             =   2400
      Width           =   1215
   End
   Begin VB.TextBox Text3 
      DataField       =   "per"
      DataSource      =   "Data1"
      Height          =   495
      Left            =   3960
      TabIndex        =   5
      Top             =   1440
      Width           =   3375
   End
   Begin VB.TextBox Text2 
      DataField       =   "ename"
      DataSource      =   "Data1"
      Height          =   495
      Left            =   3960
      TabIndex        =   4
      Top             =   840
      Width           =   3375
   End
   Begin VB.TextBox Text1 
      DataField       =   "eno"
      DataSource      =   "Data1"
      Height          =   495
      Left            =   3960
      TabIndex        =   3
      Top             =   240
      Width           =   3375
   End
   Begin VB.Label Label3 
      BackColor       =   &H00FFC0FF&
      Caption         =   "PERCENTAGE"
      BeginProperty Font 
         Name            =   "Times New Roman"
         Size            =   14.25
         Charset         =   0
         Weight          =   700
         Underline       =   0   'False
         Italic          =   0   'False
         Strikethrough   =   0   'False
      EndProperty
      ForeColor       =   &H00FF0000&
      Height          =   375
      Left            =   240
      TabIndex        =   2
      Top             =   1560
      Width           =   3135
   End
   Begin VB.Label Label2 
      BackColor       =   &H00FFC0FF&
      Caption         =   "EMPLOYEE NAME"
      BeginProperty Font 
         Name            =   "Times New Roman"
         Size            =   14.25
         Charset         =   0
         Weight          =   700
         Underline       =   0   'False
         Italic          =   0   'False
         Strikethrough   =   0   'False
      EndProperty
      ForeColor       =   &H00FF0000&
      Height          =   375
      Left            =   240
      TabIndex        =   1
      Top             =   960
      Width           =   3135
   End
   Begin VB.Label Label1 
      BackColor       =   &H00FFC0FF&
      Caption         =   "EMPLOYEE NUMBER"
      BeginProperty Font 
         Name            =   "Times New Roman"
         Size            =   14.25
         Charset         =   0
         Weight          =   700
         Underline       =   0   'False
         Italic          =   0   'False
         Strikethrough   =   0   'False
      EndProperty
      ForeColor       =   &H00FF0000&
      Height          =   375
      Left            =   240
      TabIndex        =   0
      Top             =   360
      Width           =   3135
   End
End
Attribute VB_Name = "Form1"
Attribute VB_GlobalNameSpace = False
Attribute VB_Creatable = False
Attribute VB_PredeclaredId = True
Attribute VB_Exposed = False
Private Sub Command1_Click()
Data1.Recordset.AddNew
Text1.Text = " "
Text2.Text = " "
Text3.Text = " "
End Sub

Private Sub Command2_Click()
Data1.Recordset.Delete
MsgBox "Record is deleted"
End Sub

Private Sub Command3_Click()
Data1.Recordset.Update
MsgBox "Record is inserted"
End Sub
