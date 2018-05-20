<%@ Page Language="vb" AutoEventWireup="false" Codebehind="WebForm1.aspx.vb" Inherits="CustomValidator.WebForm1"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.0 Transitional//EN">
<HTML>
	<HEAD>
		<title>WebForm1</title>
		<meta name="GENERATOR" content="Microsoft Visual Studio .NET 7.1">
		<meta name="CODE_LANGUAGE" content="Visual Basic .NET 7.1">
		<meta name="vs_defaultClientScript" content="JavaScript">
		<meta name="vs_targetSchema" content="http://schemas.microsoft.com/intellisense/ie5">
		<script language="vbscript"> 
			Sub Validate(source, arguments) 
				If (arguments.Value = "admin") Then 
					arguments.IsValid = True 
				Else 
					arguments.IsValid = False 
				End If 
			End Sub 
		</script>

	</HEAD>
	<body MS_POSITIONING="GridLayout">
		<form id="Form1" method="post" runat="server">
			<asp:Label id="Label1" style="Z-INDEX: 104; LEFT: 208px; POSITION: absolute; TOP: 72px" runat="server"
				Font-Bold="True" Font-Names="Verdana">Custom Validator Example</asp:Label>
			<asp:TextBox id="TextBox1" style="Z-INDEX: 101; LEFT: 256px; POSITION: absolute; TOP: 136px"
				runat="server"></asp:TextBox>
			<asp:Label id="Label2" style="Z-INDEX: 103; LEFT: 120px; POSITION: absolute; TOP: 136px" runat="server"
				Font-Bold="True" Font-Names="Verdana">User Name :</asp:Label>
			<asp:Button id="Button1" style="Z-INDEX: 102; LEFT: 200px; POSITION: absolute; TOP: 208px" runat="server"
				Text="Submit"></asp:Button>
			<asp:CustomValidator id="CustomValidator1" style="Z-INDEX: 105; LEFT: 432px; POSITION: absolute; TOP: 136px"
				runat="server" ErrorMessage='User Name must be "admin"' ControlToValidate="TextBox1" ClientValidationFunction="validate"></asp:CustomValidator>
		</form>
	</body>
</HTML>
