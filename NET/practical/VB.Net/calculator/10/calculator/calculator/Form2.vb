Public Class Form2
    Dim con As New SqlClient.SqlConnection("Data Source=.;Initial Catalog=master;Integrated Security=True")
    Dim adapter As New SqlClient.SqlDataAdapter
    Dim str As String

    Private Sub Button1_Click(ByVal sender As System.Object, ByVal e As System.EventArgs) Handles Button1.Click
        con.Open()
        If _TextBox1.Text = "" Then
            MessageBox.Show("Please Enter policy no")
            Me.TextBox1.Focus()
        ElseIf Me.TextBox1.Text.Length > 5 Then
            MessageBox.Show("Please Enter Length Less Than 5")
            Me.TextBox1.Focus()
        End If
        str = "insert into table2 values('" & TextBox1.Text & "','" & TextBox2.Text & "','" & TextBox3.Text & "','" & TextBox4.Text & "')"
        Dim cmd As New SqlClient.SqlCommand(str, con)
        cmd.ExecuteNonQuery()
        MsgBox("record saved")
        con.Close()

    End Sub

    Private Sub Button3_Click(ByVal sender As System.Object, ByVal e As System.EventArgs) Handles Button3.Click

        TextBox1.Text = " "
        TextBox2.Text = " "
        TextBox3.Text = " "
        TextBox4.Text = " "
    End Sub

    Private Sub Button4_Click(ByVal sender As System.Object, ByVal e As System.EventArgs) Handles Button4.Click
        Dim c As Integer
        c = MsgBox("are you sure you want to exit", MsgBoxStyle.OkCancel, "Exit")
        If c = 1 Then
            Me.Close()
        End If
    End Sub



    Private Sub Button5_Click(ByVal sender As System.Object, ByVal e As System.EventArgs) Handles Button5.Click
        If TextBox1.Text <> "" Then
            If MsgBox("Are you sure to delete data with pno  : " & TextBox1.Text & " ?", MsgBoxStyle.OkCancel, "Delete confirm") = MsgBoxResult.Cancel Then

            End If
        End If
        str = "DELETE FROM table2 WHERE pno ='" & Trim(TextBox1.Text) & "'"
        Try
            con.Open()
            adapter.DeleteCommand = con.CreateCommand
            adapter.DeleteCommand.CommandText = str
            adapter.DeleteCommand.ExecuteNonQuery()
            MsgBox("Row(s) deleted  !! ")
            con.Close()
        Catch ex As Exception
            MsgBox(ex.ToString)

        End Try
    End Sub

    Private Sub textbox4_KeyPress(ByVal sender As Object, ByVal e As System.Windows.Forms.KeyPressEventArgs) Handles TextBox4.KeyPress
        If (e.KeyChar >= Chr(32) And e.KeyChar <= Chr(63)) Or (e.KeyChar >= Chr(91) And e.KeyChar <= Chr(94)) Or (e.KeyChar = Chr(96)) Or (e.KeyChar >= Chr(123) And e.KeyChar <= Chr(126)) Then
            e.Handled = True
        End If
    End Sub


    Private Sub textbox2_KeyPress(ByVal sender As Object, ByVal e As System.Windows.Forms.KeyPressEventArgs) Handles TextBox2.KeyPress
        If (e.KeyChar >= Chr(32) And e.KeyChar <= Chr(63)) Or (e.KeyChar >= Chr(91) And e.KeyChar <= Chr(94)) Or (e.KeyChar = Chr(96)) Or (e.KeyChar >= Chr(123) And e.KeyChar <= Chr(126)) Then
            e.Handled = True
        End If
    End Sub

    Private Sub TextBox1_KeyPress(ByVal sender As Object, ByVal e As System.Windows.Forms.KeyPressEventArgs) Handles TextBox1.KeyPress

        ' textbox1 just accept numeric data

        If Char.IsNumber(e.KeyChar) Then

            e.Handled = False

        Else

            MessageBox.Show("plz click numbers only")

            e.Handled = True

        End If
    End Sub



    Private Sub Button2_Click(ByVal sender As System.Object, ByVal e As System.EventArgs) Handles Button2.Click
        Dim check As Integer
        Dim cmdtable2 As New SqlClient.SqlCommand
        Dim datable2 As New SqlClient.SqlDataAdapter
        Dim dstable2 As New DataSet
        If TextBox1.Text = "" Then
            MessageBox.Show("Please fill all data!!", "Error", MessageBoxButtons.OK, MessageBoxIcon.Exclamation)

        Else
        End If

        If TextBox1.Text = "" Or TextBox2.Text = "" Or TextBox3.Text = "" Or TextBox4.Text = "" Then

            MsgBox("form2 Data is not completed", MsgBoxStyle.OkOnly)
        Else
            If MsgBox("Are you sure to edit form2 data with pno : " & TextBox1.Text & " ?", MsgBoxStyle.OkCancel, "Edit confirm") = MsgBoxResult.Cancel Then
                ' do nothing               
            Else
                Try

                    ' con = geconnect()
                    'con.Open()
                    'cmdtable2 = con.CreateCommand
                    'cmdtable2.CommandText = "UPDATE table2 SET cname= '" & Trim(TextBox2.Text) & "' , Address='" & Trim(TextBox3.Text) & "' WHERE pno ='" & Trim(TextBox1.Text) & "'"
                    'check = cmdtable2.ExecuteReader.RecordsAffected
                    If check > 0 Then


                        MsgBox("table2 With policy no " & Trim(TextBox1.Text) & " Succesfully To Edit", MsgBoxStyle.OkOnly, "Info Update Data company ")
                    Else
                        MsgBox("table2 With policy no " & Trim(TextBox1.Text) & " Failure To Edit", MsgBoxStyle.OkOnly, "Info Update Data table2 ")
                    End If
                    'Form2()
                    con.Close()
                Catch ex As Exception
                    MsgBox("Error: " & ex.Source & ": " & ex.Message, MsgBoxStyle.OkOnly, "Connection Error !!")
                End Try
            End If
        End If

    End Sub

    
End Class

