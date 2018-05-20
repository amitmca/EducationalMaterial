Public Class Form1

    Private Sub CustomerBindingNavigatorSaveItem_Click(ByVal sender As System.Object, ByVal e As System.EventArgs) Handles CustomerBindingNavigatorSaveItem.Click
        Me.Validate()
        Me.CustomerBindingSource.EndEdit()
        Me.CustomerTableAdapter.Update(Me.TestDataSet.customer)

    End Sub

    Private Sub Form1_Load(ByVal sender As System.Object, ByVal e As System.EventArgs) Handles MyBase.Load
        'TODO: This line of code loads data into the 'TestDataSet.customer' table. You can move, or remove it, as needed.
        Me.CustomerTableAdapter.Fill(Me.TestDataSet.customer)

    End Sub
End Class
