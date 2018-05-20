<%@ Page Language="vb" AutoEventWireup="false" Codebehind="WebForm1.aspx.vb" Inherits="AddControls.WebForm1"%>
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
			<asp:Button id="Button1" style="Z-INDEX: 101; LEFT: 16px; POSITION: absolute; TOP: 160px" runat="server"
				Text="Click me" Width="88px" Height="32px"></asp:Button>
			<asp:Panel id="Panel1" style="Z-INDEX: 102; LEFT: 160px; POSITION: absolute; TOP: 160px" runat="server"
				Width="208px" Height="80px">Panel</asp:Panel>
			<asp:PlaceHolder id="PlaceHolder1" runat="server"></asp:PlaceHolder>
		</form>
	</body>
</HTML>
