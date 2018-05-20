Public Class oprator
    Const a = 20
    Const b = 30
    Private Sub oprator_Load(ByVal sender As System.Object, ByVal e As System.EventArgs) Handles MyBase.Load
        lstbox.Items.Add("The First Number :" & a)
        lstbox.Items.Add("The Second Number is:" & b)
        lstbox.Items.Add("The Addition is:" & a + b)
        lstbox.Items.Add("The Substraction  is:" & a - b)
        lstbox.Items.Add("The Multiplication is:" & a * b)
        lstbox.Items.Add("The Division is:" & a / b)
        lstbox.Items.Add("The Integer division is:" & a \ b)
        lstbox.Items.Add("The Modulus  is:" & a Mod b)
        lstbox.Items.Add("The Exponational is:" & a ^ b)
        lstbox.Items.Add("The Negation of First is:" & -a)
        lstbox.Items.Add("The Negation of Second is:" & -b)
    End Sub

    Private Sub lstbox_SelectedIndexChanged(ByVal sender As System.Object, ByVal e As System.EventArgs) Handles lstbox.SelectedIndexChanged

    End Sub
End Class