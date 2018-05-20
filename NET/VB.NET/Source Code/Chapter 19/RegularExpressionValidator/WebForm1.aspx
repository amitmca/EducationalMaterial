<%@ Page Language="vb" AutoEventWireup="false" Codebehind="WebForm1.aspx.vb" Inherits="RegularExpressionValidator.WebForm1"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.0 Transitional//EN">
<HTML>
	<HEAD>
		<title>WebForm1</title>
		<meta name="GENERATOR" content="Microsoft Visual Studio .NET 7.1">
		<meta name="CODE_LANGUAGE" content="Visual Basic .NET 7.1">
		<meta name="vs_defaultClientScript" content="JavaScript">
		<meta name="vs_targetSchema" content="http://schemas.microsoft.com/intellisense/ie5">
	</HEAD>
	<body MS_POSITIONING="GridLayout">
		<form id="Form1" method="post" runat="server">
			<asp:Label id="Label1" style="Z-INDEX: 104; LEFT: 144px; POSITION: absolute; TOP: 72px" runat="server"
				Font-Names="Verdana" Font-Bold="True">Regular Expression  Validator Example</asp:Label>
			<asp:TextBox id="TextBox2" style="Z-INDEX: 106; LEFT: 256px; POSITION: absolute; TOP: 232px"
				runat="server"></asp:TextBox>
			<asp:Label id="Label3" style="Z-INDEX: 105; LEFT: 24px; POSITION: absolute; TOP: 232px" runat="server"
				Font-Names="Verdana" Font-Bold="True">Enter E-mail Address</asp:Label>
			<asp:TextBox id="TextBox1" style="Z-INDEX: 101; LEFT: 256px; POSITION: absolute; TOP: 136px"
				runat="server"></asp:TextBox>
			<asp:Label id="Label2" style="Z-INDEX: 103; LEFT: 24px; POSITION: absolute; TOP: 136px" runat="server"
				Font-Names="Verdana" Font-Bold="True">Enter URL</asp:Label>
			<asp:Button id="Button1" style="Z-INDEX: 102; LEFT: 192px; POSITION: absolute; TOP: 296px" runat="server"
				Text="Submit"></asp:Button>
			<asp:RegularExpressionValidator id="RegularExpressionValidator1" style="Z-INDEX: 107; LEFT: 432px; POSITION: absolute; TOP: 128px"
				runat="server" ErrorMessage="Enter Correct URL such as http://www.domain.com" ControlToValidate="TextBox1" ValidationExpression="http://([\w-]+\.)+[\w-]+(/[\w- ./?%&amp;=]*)?"
				Width="200px"></asp:RegularExpressionValidator>
			<asp:RegularExpressionValidator id="RegularExpressionValidator2" style="Z-INDEX: 108; LEFT: 440px; POSITION: absolute; TOP: 224px"
				runat="server" ErrorMessage="Enter correct email address such as someone@domain.com" ControlToValidate="TextBox2"
				ValidationExpression="\w+([-+.]\w+)*@\w+([-.]\w+)*\.\w+([-.]\w+)*" Width="216px" Height="46px"></asp:RegularExpressionValidator>
		</form>
	</body>
</HTML>
