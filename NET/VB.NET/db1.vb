Dim s as String
s = "select * from department"
 Dim adap As New Data.SqlClient.SqlDataAdapter(s, myconn)
 Dim dataset As Data.DataSet = New Data.DataSet()
 adap.Fill(dataset, "details")
 Dim tbl As DataTable = dataset.Tables("details")

Dim i As DataRow
 Dim j As DataColumn
 For Each i In tbl.Rows
   For Each j In tbl.Columns
     System.Console.Write((i(j).ToString()).PadRight(15,""))    
   Next
   System.Console.WriteLine("")
 Next