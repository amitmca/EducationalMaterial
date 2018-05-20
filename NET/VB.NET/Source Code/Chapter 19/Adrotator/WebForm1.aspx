<%@ Page Language="vb" AutoEventWireup="false" Codebehind="WebForm1.aspx.vb" Inherits="Adrotator.WebForm1"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.0 Transitional//EN">
<HTML>
	<HEAD>
		<title>Ad Rotator example</title>
		<meta name="GENERATOR" content="Microsoft Visual Studio .NET 7.1">
		<meta name="CODE_LANGUAGE" content="Visual Basic .NET 7.1">
		<meta name="vs_defaultClientScript" content="JavaScript">
		<meta name="vs_targetSchema" content="http://schemas.microsoft.com/intellisense/ie5">
	</HEAD>
	<body MS_POSITIONING="GridLayout">
		<form id="Form1" method="post" runat="server">
			<asp:AdRotator id="AdRotator1" style="Z-INDEX: 101; LEFT: 80px; POSITION: absolute; TOP: 104px"
				runat="server" Width="624px" Height="90px" AdvertisementFile="ads.xml"></asp:AdRotator>
			<asp:Button id="Button1" style="Z-INDEX: 102; LEFT: 264px; POSITION: absolute; TOP: 224px" runat="server"
				Text="Re Load Page"></asp:Button>
			<asp:Label id="Label2" style="Z-INDEX: 104; LEFT: 248px; POSITION: absolute; TOP: 56px" runat="server"
				Font-Bold="True" Font-Names="Verdana">Ad Rotator Example</asp:Label>
		</form>
	</body>
</HTML>
