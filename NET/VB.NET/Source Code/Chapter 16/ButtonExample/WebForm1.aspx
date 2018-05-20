<%@ Page Language="vb" AutoEventWireup="false" Codebehind="WebForm1.aspx.vb" Inherits="ButtonExample.WebForm1"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.0 Transitional//EN">
<HTML>
	<HEAD>
		<title>WebForm1</title>
		<meta content="Microsoft Visual Studio .NET 7.1" name="GENERATOR">
		<meta content="Visual Basic .NET 7.1" name="CODE_LANGUAGE">
		<meta content="JavaScript" name="vs_defaultClientScript">
		<meta content="http://schemas.microsoft.com/intellisense/ie5" name="vs_targetSchema">
	</HEAD>
	<body MS_POSITIONING="GridLayout">
		<form id="Form1" method="post" runat="server">
			<asp:Button id="Button1" style="Z-INDEX: 101; LEFT: 95px; POSITION: absolute; TOP: 75px" runat="server"
				Text="Click me" Width="125px" Height="24px"></asp:Button>
			<asp:TextBox id="TextBox2" style="Z-INDEX: 104; LEFT: 239px; POSITION: absolute; TOP: 127px"
				runat="server"></asp:TextBox>
			<asp:Button id="Button2" style="Z-INDEX: 103; LEFT: 95px; POSITION: absolute; TOP: 125px" runat="server"
				Text="Click me too" Width="125px" Height="24px" CommandArgument="You clicked Button2" CommandName="Button2"></asp:Button>
			<asp:TextBox id="TextBox1" style="Z-INDEX: 102; LEFT: 239px; POSITION: absolute; TOP: 76px" runat="server"></asp:TextBox>
		</form>
	</body>
</HTML>
