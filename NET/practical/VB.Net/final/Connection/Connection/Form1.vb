Public Class Form1

    Private Sub StudentBindingNavigatorSaveItem_Click(ByVal sender As System.Object, ByVal e As System.EventArgs) Handles StudentBindingNavigatorSaveItem.Click
        Me.Validate()
        Me.StudentBindingSource.EndEdit()
        Me.StudentTableAdapter.Update(Me.FinalDataSet.student)

    End Sub

    Private Sub Form1_Load(ByVal sender As System.Object, ByVal e As System.EventArgs) Handles MyBase.Load
        'TODO: This line of code loads data into the 'FinalDataSet.student' table. You can move, or remove it, as needed.
        Me.StudentTableAdapter.Fill(Me.FinalDataSet.student)

    End Sub
End Class
