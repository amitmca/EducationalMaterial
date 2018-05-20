<%@ Page Language="vb" AutoEventWireup="false"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.0 Transitional//EN">
<HTML>
  <HEAD><meta name=vs_targetSchema content="http://schemas.microsoft.com/ _ 
      intellisense/ie5">
<TITLE>EmbeddedVB example</TITLE>
   <script language="VB" runat="server">
    Private Sub Button1_Click(ByVal sender As System.Object, _
        ByVal e As System.EventArgs) 
        TextBox1.Text = "Hello from Visual Basic!"
    End Sub 
    </script>
</HEAD>
<body>
   <form runat="server" ID="Form1">

<asp:Button id="Button1" Text="Click Me" OnClick="Button1_Click" 
    runat="server"/>
<P>
<asp:TextBox id=TextBox1 runat="server"></asp:TextBox></P>
    </form>
</body>
</HTML>
