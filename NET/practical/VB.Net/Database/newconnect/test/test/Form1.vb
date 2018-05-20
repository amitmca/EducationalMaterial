Public Class Form1

    Private Sub CustomerBindingNavigatorSaveItem_Click(ByVal sender As System.Object, ByVal e As System.EventArgs) Handles CustomerBindingNavigatorSaveItem.Click
        Me.Validate()
        Me.CustomerBindingSource.EndEdit()
        Me.CustomerTableAdapter.Update(Me.CustomerDataSet.customer)

    End Sub

    Private Sub Form1_Load(ByVal sender As System.Object, ByVal e As System.EventArgs) Handles MyBase.Load
        'TODO: This line of code loads data into the 'CustomerDataSet.customer' table. You can move, or remove it, as needed.
        Me.CustomerTableAdapter.Fill(Me.CustomerDataSet.customer)

    End Sub

    Private Sub Button1_Click(ByVal sender As System.Object, ByVal e As System.EventArgs) Handles Button1.Click
        CustomerDataSet.Clear()
    End Sub

    Private Sub Button2_Click(ByVal sender As System.Object, ByVal e As System.EventArgs) Handles Button2.Click
        CustomerTableAdapter.Fill(Me.CustomerDataSet.customer)
    End Sub
End Class
