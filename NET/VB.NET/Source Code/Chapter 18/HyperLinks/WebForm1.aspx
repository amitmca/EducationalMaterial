<%@ Page Language="vb" AutoEventWireup="false" Codebehind="WebForm1.aspx.vb" Inherits="HyperLinks.WebForm1"%>
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
			<asp:Label id="Label1" style="Z-INDEX: 101; LEFT: 120px; POSITION: absolute; TOP: 40px" runat="server"
				Font-Bold="True" Font-Names="Verdana">Using Hyperlinks in Web Form</asp:Label>
			<asp:Label id="Label2" style="Z-INDEX: 102; LEFT: 32px; POSITION: absolute; TOP: 160px" runat="server"
				Font-Bold="True" Font-Names="Verdana" Width="192px" Height="32px">Using Absolute URL</asp:Label>
			<asp:Label id="Label3" style="Z-INDEX: 103; LEFT: 32px; POSITION: absolute; TOP: 248px" runat="server"
				Font-Bold="True" Font-Names="Verdana" Width="224px" Height="40px">Using Root Relative URL</asp:Label>
			<asp:HyperLink id="HyperLink1" style="Z-INDEX: 104; LEFT: 296px; POSITION: absolute; TOP: 160px"
				runat="server" Font-Names="Verdana" Width="145px" Height="24px" NavigateUrl="http://www.google.com">Visit Google</asp:HyperLink>
			<asp:HyperLink id="HyperLink2" style="Z-INDEX: 105; LEFT: 296px; POSITION: absolute; TOP: 248px"
				runat="server" Font-Names="Verdana" Width="224px" Height="24" NavigateUrl="/HyperLinks/WebForm2.aspx">Click to open WebForm 2</asp:HyperLink>
		</form>
	</body>
</HTML>
