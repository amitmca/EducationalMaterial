<%@ Page Language="vb" AutoEventWireup="false" Codebehind="WebForm1.aspx.vb" Inherits="WebApplication1.WebForm1"%>
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
		<div align="center"><h1 style="FONT-SIZE: 36pt; FONT-FAMILY: 'Times New Roman'">
				Web Forms</h1>
	

		</div>
		<form id="Form1" method="post" runat="server">
			&nbsp;
			<asp:Button id="Button1" style="Z-INDEX: 101; LEFT: 40px; POSITION: absolute; TOP: 88px" runat="server"
				Text="Click Me"></asp:Button>
			<asp:TextBox id="TextBox1" style="Z-INDEX: 103; LEFT: 176px; POSITION: absolute; TOP: 96px" runat="server"></asp:TextBox>
			<asp:TextBox id="TextBox2" style="Z-INDEX: 104; LEFT: 176px; POSITION: absolute; TOP: 168px"
				runat="server"></asp:TextBox>
			<asp:ListBox id="ListBox1" style="Z-INDEX: 102; LEFT: 48px; POSITION: absolute; TOP: 144px" runat="server"
				AutoPostBack="True">
				<asp:ListItem Value="Item 0">Item 0</asp:ListItem>
				<asp:ListItem Value="Item 1">Item 1</asp:ListItem>
				<asp:ListItem Value="Item 2">Item 2</asp:ListItem>
				<asp:ListItem Value="Item 3">Item 3</asp:ListItem>
				<asp:ListItem Value="Item 4">Item 4</asp:ListItem>
				<asp:ListItem Value="Item 5">Item 5</asp:ListItem>
			</asp:ListBox>
		</form>
		</H1>
	</body>
</HTML>
