Public Class Form1

    Private Sub EmpBindingNavigatorSaveItem_Click(ByVal sender As System.Object, ByVal e As System.EventArgs) Handles EmpBindingNavigatorSaveItem.Click
        Me.Validate()
        Me.EmpBindingSource.EndEdit()
        Me.EmpTableAdapter.Update(Me.DataSet1.emp)

    End Sub

    Private Sub Form1_Load(ByVal sender As System.Object, ByVal e As System.EventArgs) Handles MyBase.Load
        'TODO: This line of code loads data into the 'DataSet1.emp' table. You can move, or remove it, as needed.
        Me.EmpTableAdapter.Fill(Me.DataSet1.emp)

    End Sub
End Class
