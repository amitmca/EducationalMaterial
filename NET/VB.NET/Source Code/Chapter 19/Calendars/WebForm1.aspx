<%@ Page Language="vb" AutoEventWireup="false" Codebehind="WebForm1.aspx.vb" Inherits="Calendars.WebForm1"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.0 Transitional//EN">
<HTML>
	<HEAD>
		<title>Calendar Example</title>
		<meta name="GENERATOR" content="Microsoft Visual Studio .NET 7.1">
		<meta name="CODE_LANGUAGE" content="Visual Basic .NET 7.1">
		<meta name="vs_defaultClientScript" content="JavaScript">
		<meta name="vs_targetSchema" content="http://schemas.microsoft.com/intellisense/ie5">
	</HEAD>
	<body MS_POSITIONING="GridLayout">
		<form id="Form1" method="post" runat="server">
			<asp:Label id="Label1" style="Z-INDEX: 101; LEFT: 200px; POSITION: absolute; TOP: 72px" runat="server"
				Font-Bold="True" Font-Names="Verdana">Calendar Example</asp:Label>
			<asp:Calendar id="Calendar1" style="Z-INDEX: 102; LEFT: 184px; POSITION: absolute; TOP: 104px"
				runat="server"></asp:Calendar>
			<asp:TextBox id="TextBox1" style="Z-INDEX: 103; LEFT: 240px; POSITION: absolute; TOP: 320px"
				runat="server"></asp:TextBox>
		</form>
	</body>
</HTML>
