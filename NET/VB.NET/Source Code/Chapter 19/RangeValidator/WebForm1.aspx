<%@ Page Language="vb" AutoEventWireup="false" Codebehind="WebForm1.aspx.vb" Inherits="RangeValidator.WebForm1"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.0 Transitional//EN">
<HTML>
	<HEAD>
		<title>Range Validator Example</title>
		<meta name="GENERATOR" content="Microsoft Visual Studio .NET 7.1">
		<meta name="CODE_LANGUAGE" content="Visual Basic .NET 7.1">
		<meta name="vs_defaultClientScript" content="JavaScript">
		<meta name="vs_targetSchema" content="http://schemas.microsoft.com/intellisense/ie5">
	</HEAD>
	<body MS_POSITIONING="GridLayout">
		<form id="Form1" method="post" runat="server">
			<asp:Label id="Label1" style="Z-INDEX: 104; LEFT: 160px; POSITION: absolute; TOP: 64px" runat="server"
				Font-Names="Verdana" Font-Bold="True">Range Validator Example</asp:Label>
			<asp:Label id="Label2" style="Z-INDEX: 103; LEFT: 48px; POSITION: absolute; TOP: 136px" runat="server"
				Font-Names="Verdana" Font-Bold="True">User Name</asp:Label>
			<asp:TextBox id="TextBox1" style="Z-INDEX: 101; LEFT: 184px; POSITION: absolute; TOP: 136px"
				runat="server"></asp:TextBox>
			<asp:Button id="Button1" style="Z-INDEX: 102; LEFT: 144px; POSITION: absolute; TOP: 208px" runat="server"
				Text="Submit"></asp:Button>
			<asp:RangeValidator id="RangeValidator1" style="Z-INDEX: 105; LEFT: 360px; POSITION: absolute; TOP: 136px"
				runat="server" ErrorMessage="The First letter of usename should fall in range of A-T" ControlToValidate="TextBox1"
				MaximumValue="t" MinimumValue="a"></asp:RangeValidator>
		</form>
	</body>
</HTML>
