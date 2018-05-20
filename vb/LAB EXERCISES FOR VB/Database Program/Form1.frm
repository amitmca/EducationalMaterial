VERSION 5.00
Object = "{5E9E78A0-531B-11CF-91F6-C2863C385E30}#1.0#0"; "MSFLXGRD.OCX"
Begin VB.Form Form1 
   BackColor       =   &H00C0FFC0&
   Caption         =   "Form1"
   ClientHeight    =   8160
   ClientLeft      =   60
   ClientTop       =   450
   ClientWidth     =   10185
   LinkTopic       =   "Form1"
   ScaleHeight     =   8160
   ScaleWidth      =   10185
   StartUpPosition =   3  'Windows Default
   Begin MSFlexGridLib.MSFlexGrid MSFlexGrid1 
      Bindings        =   "Form1.frx":0000
      Height          =   2415
      Left            =   2040
      TabIndex        =   17
      Top             =   5280
      Width           =   6495
      _ExtentX        =   11456
      _ExtentY        =   4260
      _Version        =   393216
      Rows            =   10
      Cols            =   4
      FixedRows       =   0
      FixedCols       =   0
      BackColor       =   12648384
      ForeColor       =   255
      BeginProperty Font {0BE35203-8F91-11CE-9DE3-00AA004BB851} 
         Name            =   "Times New Roman"
         Size            =   14.25
         Charset         =   0
         Weight          =   700
         Underline       =   0   'False
         Italic          =   0   'False
         Strikethrough   =   0   'False
      EndProperty
   End
   Begin VB.Frame Frame2 
      Caption         =   "Frame2"
      Height          =   2295
      Left            =   720
      TabIndex        =   9
      Top             =   3000
      Width           =   8415
      Begin VB.CommandButton Command5 
         BackColor       =   &H00FFC0C0&
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
         Height          =   495
         Left            =   6000
         Style           =   1  'Graphical
         TabIndex        =   15
         Top             =   1080
         Width           =   1335
      End
      Begin VB.TextBox Text5 
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
         Height          =   420
         Left            =   5040
         TabIndex        =   14
         Text            =   " "
         Top             =   1080
         Width           =   735
      End
      Begin VB.CommandButton Command1 
         BackColor       =   &H00FFC0C0&
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
         TabIndex        =   13
         Top             =   360
         Width           =   1215
      End
      Begin VB.CommandButton Command2 
         BackColor       =   &H00FFC0C0&
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
         Left            =   3480
         Style           =   1  'Graphical
         TabIndex        =   12
         Top             =   360
         Width           =   1335
      End
      Begin VB.CommandButton Command3 
         BackColor       =   &H00FFC0C0&
         Caption         =   "MODIFY"
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
         Left            =   5040
         Style           =   1  'Graphical
         TabIndex        =   11
         Top             =   360
         Width           =   1335
      End
      Begin VB.CommandButton Command4 
         BackColor       =   &H00FFC0C0&
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
         Left            =   2040
         Style           =   1  'Graphical
         TabIndex        =   10
         Top             =   360
         Width           =   1215
      End
      Begin VB.Label Label5 
         AutoSize        =   -1  'True
         BackColor       =   &H00C0FFC0&
         Caption         =   "  DEPARTMENT NO TO SEARCH"
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
         Height          =   330
         Left            =   120
         TabIndex        =   16
         Top             =   1200
         Width           =   4470
      End
   End
   Begin VB.Frame Frame1 
      Caption         =   "Frame1"
      Height          =   2895
      Left            =   720
      TabIndex        =   0
      Top             =   120
      Width           =   8415
      Begin VB.TextBox Text1 
         DataField       =   "eno"
         DataSource      =   "Data1"
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
         Left            =   3600
         TabIndex        =   4
         Text            =   " "
         Top             =   360
         Width           =   2775
      End
      Begin VB.TextBox Text2 
         DataField       =   "ename"
         DataSource      =   "Data1"
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
         Left            =   3600
         TabIndex        =   3
         Text            =   "  "
         Top             =   960
         Width           =   2775
      End
      Begin VB.TextBox Text3 
         DataField       =   "add"
         DataSource      =   "Data1"
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
         Left            =   3600
         TabIndex        =   2
         Text            =   " "
         Top             =   1560
         Width           =   2775
      End
      Begin VB.TextBox Text4 
         DataField       =   "dno"
         DataSource      =   "Data1"
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
         Left            =   3600
         TabIndex        =   1
         Text            =   " "
         Top             =   2160
         Width           =   2775
      End
      Begin VB.Label Label1 
         AutoSize        =   -1  'True
         BackColor       =   &H00C0FFC0&
         Caption         =   "EMP NO"
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
         Height          =   330
         Left            =   960
         TabIndex        =   8
         Top             =   240
         Width           =   1155
      End
      Begin VB.Label Label2 
         AutoSize        =   -1  'True
         BackColor       =   &H00C0FFC0&
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
         ForeColor       =   &H00FF0000&
         Height          =   330
         Left            =   960
         TabIndex        =   7
         Top             =   840
         Width           =   1590
      End
      Begin VB.Label Label3 
         AutoSize        =   -1  'True
         BackColor       =   &H00C0FFC0&
         Caption         =   "ADDRESS"
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
         Height          =   330
         Left            =   960
         TabIndex        =   6
         Top             =   1440
         Width           =   1350
      End
      Begin VB.Label Label4 
         AutoSize        =   -1  'True
         BackColor       =   &H00C0FFC0&
         Caption         =   "DEPT NO"
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
         Height          =   330
         Left            =   960
         TabIndex        =   5
         Top             =   2040
         Width           =   1290
      End
   End
   Begin VB.Data Data1 
      Caption         =   "Data1"
      Connect         =   "Access"
      DatabaseName    =   "D:\My  Programs\VB\LAB EXERCISES FOR VB\Database Program\emp.mdb"
      DefaultCursorType=   0  'DefaultCursor
      DefaultType     =   2  'UseODBC
      Exclusive       =   0   'False
      Height          =   495
      Left            =   240
      Options         =   0
      ReadOnly        =   0   'False
      RecordsetType   =   1  'Dynaset
      RecordSource    =   "empd"
      Top             =   5760
      Width           =   1695
   End
End
Attribute VB_Name = "Form1"
Attribute VB_GlobalNameSpace = False
Attribute VB_Creatable = False
Attribute VB_PredeclaredId = True
Attribute VB_Exposed = False
Dim rs As Recordset
Dim dno1 As String
Private Sub Command1_Click()
Data1.Recordset.AddNew
Text1.Text = " "
Text2.Text = " "
Text3.Text = " "
Text4.Text = " "
End Sub

Private Sub Command2_Click()
Data1.Recordset.Delete
MsgBox " Record is deleted successfully"
Data1.Refresh
End Sub

Private Sub Command3_Click()
Data1.Recordset.Edit
MsgBox "Record Updated Successfully"
End Sub

Private Sub Command4_Click()
Data1.Recordset.Update
MsgBox " Record is inserted successfully"
Data1.Refresh
End Sub

Private Sub Command5_Click()
dno1 = Text5.Text
st = ("select * from empd where dno=bno1")
Text1.Text = Data1.Recordset.Fields(0)
Text2.Text = Data1.Recordset.Fields(1)
Text3.Text = Data1.Recordset.Fields(2)
Text4.Text = Data1.Recordset.Fields(3)

End Sub

