<%@ Page Language="vb" AutoEventWireup="false" Codebehind="WebForm2.aspx.vb" Inherits="HyperLinks.WebForm2"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.0 Transitional//EN">
<HTML>
	<HEAD>
		<title>WebForm2</title>
		<meta name="GENERATOR" content="Microsoft Visual Studio .NET 7.1">
		<meta name="CODE_LANGUAGE" content="Visual Basic .NET 7.1">
		<meta name="vs_defaultClientScript" content="JavaScript">
		<meta name="vs_targetSchema" content="http://schemas.microsoft.com/intellisense/ie5">
	</HEAD>
	<body MS_POSITIONING="GridLayout">
		<form id="Form1" method="post" runat="server">
			<asp:Label id="Label1" style="Z-INDEX: 102; LEFT: 136px; POSITION: absolute; TOP: 40px" runat="server"
				Font-Names="Verdana" Font-Bold="True">Using Hyperlinks in Web Form</asp:Label>
			<asp:Label id="Label3" style="Z-INDEX: 101; LEFT: 72px; POSITION: absolute; TOP: 152px" runat="server"
				Font-Names="Verdana" Height="40px" Width="432px">You have clicked on Relative URL on previous page</asp:Label>
			<asp:HyperLink id="HyperLink1" style="Z-INDEX: 103; LEFT: 168px; POSITION: absolute; TOP: 224px"
				runat="server" Font-Names="Verdana" Height="32px" Width="240px" NavigateUrl="WebForm1.aspx">Click here to go back</asp:HyperLink>
		</form>
	</body>
</HTML>
