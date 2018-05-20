<%@ Page Language="vb" AutoEventWireup="false" Codebehind="WebForm1.aspx.vb" Inherits="OutputCache.WebForm1"%>
<%@ OutputCache Duration="10" VaryByParam="none" %>
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
			<asp:Label id="Label1" style="Z-INDEX: 101; LEFT: 296px; POSITION: absolute; TOP: 56px" runat="server"
				Font-Bold="True" Font-Names="Tahoma" Font-Size="Large">Output Cache Example</asp:Label>
			<asp:Label id="Label2" style="Z-INDEX: 102; LEFT: 392px; POSITION: absolute; TOP: 160px" runat="server">Label</asp:Label>
			<asp:Label id="Label3" style="Z-INDEX: 103; LEFT: 240px; POSITION: absolute; TOP: 232px" runat="server"
				Font-Bold="True" Font-Names="Tahoma" Width="440px">The above displayed time was cached for 10 seconds. Keep Refereshing the page to see the changes.</asp:Label>
		</form>
	</body>
</HTML>
