VERSION 5.00
Begin VB.Form Form1 
   BackColor       =   &H00FFFFC0&
   Caption         =   "Form1"
   ClientHeight    =   7260
   ClientLeft      =   60
   ClientTop       =   345
   ClientWidth     =   8640
   LinkTopic       =   "Form1"
   ScaleHeight     =   7260
   ScaleWidth      =   8640
   StartUpPosition =   3  'Windows Default
   Begin VB.TextBox Text5 
      Height          =   495
      Left            =   3840
      TabIndex        =   18
      Text            =   " "
      Top             =   5760
      Width           =   2055
   End
   Begin VB.TextBox Text4 
      ForeColor       =   &H00000000&
      Height          =   495
      Left            =   720
      TabIndex        =   17
      Text            =   " "
      Top             =   5760
      Width           =   2175
   End
   Begin VB.CommandButton Command9 
      BackColor       =   &H00C0FFFF&
      Caption         =   "SEARCH"
      BeginProperty Font 
         Name            =   "Times New Roman"
         Size            =   14.25
         Charset         =   0
         Weight          =   700
         Underline       =   0   'False
         Italic          =   0   'False
         Strikethrough   =   0   'False
      EndProperty
      Height          =   615
      Left            =   2520
      Style           =   1  'Graphical
      TabIndex        =   14
      Top             =   4320
      Width           =   1335
   End
   Begin VB.TextBox Text3 
      Height          =   375
      Left            =   5520
      TabIndex        =   13
      Text            =   " "
      Top             =   3720
      Width           =   855
   End
   Begin VB.Data Data1 
      Caption         =   "Data1"
      Connect         =   "Access"
      DatabaseName    =   "D:\My  Programs\VB\LAB EXERCISES FOR VB\Database Prog\mydb.mdb"
      DefaultCursorType=   0  'DefaultCursor
      DefaultType     =   2  'UseODBC
      Exclusive       =   0   'False
      Height          =   375
      Left            =   6480
      Options         =   0
      ReadOnly        =   0   'False
      RecordsetType   =   1  'Dynaset
      RecordSource    =   "emp"
      Top             =   600
      Visible         =   0   'False
      Width           =   1215
   End
   Begin VB.CommandButton Command8 
      BackColor       =   &H00FFC0FF&
      Caption         =   "VIEW"
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
      Left            =   4800
      Style           =   1  'Graphical
      TabIndex        =   11
      Top             =   2880
      Width           =   1215
   End
   Begin VB.CommandButton Command7 
      BackColor       =   &H00FFC0FF&
      Caption         =   "DELETE"
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
      Left            =   3360
      Style           =   1  'Graphical
      TabIndex        =   10
      Top             =   2880
      Width           =   1215
   End
   Begin VB.CommandButton Command6 
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
      Left            =   1920
      Style           =   1  'Graphical
      TabIndex        =   9
      Top             =   2880
      Width           =   1215
   End
   Begin VB.CommandButton Command5 
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
      Left            =   480
      Style           =   1  'Graphical
      TabIndex        =   8
      Top             =   2880
      Width           =   1215
   End
   Begin VB.CommandButton Command4 
      BackColor       =   &H00FFC0C0&
      Caption         =   "LAST"
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
      Left            =   4800
      Style           =   1  'Graphical
      TabIndex        =   7
      Top             =   1920
      Width           =   1215
   End
   Begin VB.CommandButton Command3 
      BackColor       =   &H00FFC0C0&
      Caption         =   "PREV"
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
      Left            =   3360
      Style           =   1  'Graphical
      TabIndex        =   6
      Top             =   1920
      Width           =   1215
   End
   Begin VB.CommandButton Command2 
      BackColor       =   &H00FFC0C0&
      Caption         =   "NEXT"
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
      Top             =   1920
      Width           =   1215
   End
   Begin VB.CommandButton Command1 
      BackColor       =   &H00FFC0C0&
      Caption         =   "FIRST"
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
      TabIndex        =   4
      Top             =   1920
      Width           =   1215
   End
   Begin VB.TextBox Text2 
      DataField       =   "ename"
      DataSource      =   "Data1"
      Height          =   375
      Left            =   3480
      TabIndex        =   3
      Text            =   " "
      Top             =   1200
      Width           =   2175
   End
   Begin VB.TextBox Text1 
      BackColor       =   &H00FFFFFF&
      DataField       =   "eno"
      DataSource      =   "Data1"
      Height          =   375
      Left            =   3480
      TabIndex        =   2
      Text            =   " "
      Top             =   600
      Width           =   2175
   End
   Begin VB.Label Label5 
      BackColor       =   &H00FFFFC0&
      Caption         =   "EMP NAME"
      BeginProperty Font 
         Name            =   "Times New Roman"
         Size            =   14.25
         Charset         =   0
         Weight          =   700
         Underline       =   0   'False
         Italic          =   0   'False
         Strikethrough   =   0   'False
      EndProperty
      ForeColor       =   &H00FF00FF&
      Height          =   375
      Left            =   3960
      TabIndex        =   16
      Top             =   5280
      Width           =   1935
   End
   Begin VB.Label Label4 
      BackColor       =   &H00FFFFC0&
      Caption         =   "EMP NUMBER"
      BeginProperty Font 
         Name            =   "Times New Roman"
         Size            =   14.25
         Charset         =   0
         Weight          =   700
         Underline       =   0   'False
         Italic          =   0   'False
         Strikethrough   =   0   'False
      EndProperty
      ForeColor       =   &H00FF00FF&
      Height          =   375
      Left            =   720
      TabIndex        =   15
      Top             =   5280
      Width           =   2175
   End
   Begin VB.Label Label3 
      BackColor       =   &H00FFFFC0&
      Caption         =   "ENTER EMPLOYEE  NUMBER TO SEARCH"
      BeginProperty Font 
         Name            =   "Times New Roman"
         Size            =   12
         Charset         =   0
         Weight          =   700
         Underline       =   0   'False
         Italic          =   0   'False
         Strikethrough   =   0   'False
      EndProperty
      ForeColor       =   &H000000FF&
      Height          =   375
      Left            =   600
      TabIndex        =   12
      Top             =   3720
      Width           =   5415
   End
   Begin VB.Label Label2 
      BackColor       =   &H00FFFFC0&
      Caption         =   "EMPLOYEE NAME"
      BeginProperty Font 
         Name            =   "Times New Roman"
         Size            =   12
         Charset         =   0
         Weight          =   700
         Underline       =   0   'False
         Italic          =   0   'False
         Strikethrough   =   0   'False
      EndProperty
      ForeColor       =   &H00FF00FF&
      Height          =   375
      Left            =   480
      TabIndex        =   1
      Top             =   1200
      Width           =   2655
   End
   Begin VB.Label Label1 
      BackColor       =   &H00FFFFC0&
      Caption         =   "EMPLOYEE NUMBER"
      BeginProperty Font 
         Name            =   "Times New Roman"
         Size            =   12
         Charset         =   0
         Weight          =   700
         Underline       =   0   'False
         Italic          =   0   'False
         Strikethrough   =   0   'False
      EndProperty
      ForeColor       =   &H00FF00FF&
      Height          =   495
      Left            =   480
      TabIndex        =   0
      Top             =   600
      Width           =   2655
   End
End
Attribute VB_Name = "Form1"
Attribute VB_GlobalNameSpace = False
Attribute VB_Creatable = False
Attribute VB_PredeclaredId = True
Attribute VB_Exposed = False
Option Explicit
Dim eno As Integer

Private Sub Command1_Click()
Data1.Recordset.MoveFirst
End Sub

Private Sub Command2_Click()
If Data1.Recordset.EOF = True Then
MsgBox "Records Are Finished"
Else
Data1.Recordset.MoveNext
End If
End Sub

Private Sub Command3_Click()
If Data1.Recordset.BOF = True Then
MsgBox "No Record to show"
Else
Data1.Recordset.MovePrevious
End If
End Sub

Private Sub Command4_Click()
Data1.Recordset.MoveLast
End Sub

Private Sub Command5_Click()
Data1.Recordset.AddNew
Text1.Text = " "
Text2.Text = " "

End Sub

Private Sub Command6_Click()
Data1.Recordset.Update
MsgBox "1 Record is inserted successfully"
End Sub

Private Sub Command7_Click()
Data1.Recordset.Delete
MsgBox "1 Record is Deleted successfully"
End Sub

Private Sub Command9_Click()
If Text3.Text = Text1.DataField Then
Text4.Text = Text1.DataField.Recordset

End If

 
End Sub

