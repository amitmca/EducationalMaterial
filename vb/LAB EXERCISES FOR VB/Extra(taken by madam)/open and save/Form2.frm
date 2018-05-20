VERSION 5.00
Object = "{5E9E78A0-531B-11CF-91F6-C2863C385E30}#1.0#0"; "MSFLXGRD.OCX"
Begin VB.Form Form2 
   Caption         =   "Form2"
   ClientHeight    =   4230
   ClientLeft      =   60
   ClientTop       =   450
   ClientWidth     =   6045
   LinkTopic       =   "Form2"
   ScaleHeight     =   4230
   ScaleWidth      =   6045
   StartUpPosition =   3  'Windows Default
   Begin MSFlexGridLib.MSFlexGrid fg1 
      Height          =   3255
      Left            =   960
      TabIndex        =   0
      Top             =   240
      Width           =   3015
      _ExtentX        =   5318
      _ExtentY        =   5741
      _Version        =   393216
      Rows            =   13
   End
End
Attribute VB_Name = "Form2"
Attribute VB_GlobalNameSpace = False
Attribute VB_Creatable = False
Attribute VB_PredeclaredId = True
Attribute VB_Exposed = False
Private Sub Form_Load()
fg1.TextMatrix(0, 0) = "Month"
fg1.TextMatrix(0, 1) = "Days"

fg1.TextMatrix(1, 0) = "Jan"
fg1.TextMatrix(1, 1) = "31"

fg1.TextMatrix(2, 0) = "Feb"
fg1.TextMatrix(2, 1) = "28"

fg1.TextMatrix(3, 0) = "Mar"
fg1.TextMatrix(3, 1) = "30"

fg1.TextMatrix(4, 0) = "April"
fg1.TextMatrix(4, 1) = "30"

fg1.TextMatrix(5, 0) = "May"
fg1.TextMatrix(5, 1) = "30"

fg1.TextMatrix(6, 0) = "June"
fg1.TextMatrix(6, 1) = "31"

fg1.TextMatrix(7, 0) = "July"
fg1.TextMatrix(7, 1) = "30"

fg1.TextMatrix(8, 0) = "Aug"
fg1.TextMatrix(8, 1) = "31"

fg1.TextMatrix(9, 0) = "Sep"
fg1.TextMatrix(9, 1) = "30"

fg1.TextMatrix(10, 0) = "Oct"
fg1.TextMatrix(10, 1) = "31"

fg1.TextMatrix(11, 0) = "Nov"
fg1.TextMatrix(11, 1) = "31"

fg1.TextMatrix(12, 0) = "Dec"
fg1.TextMatrix(12, 1) = "30"
End Sub
