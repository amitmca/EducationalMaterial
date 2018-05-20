<%@ Page Language="vb" AutoEventWireup="false" Codebehind="WebForm1.aspx.vb" Inherits="LinkButtons.WebForm1"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.0 Transitional//EN">
<HTML>
	<HEAD>
		<title>Link Button</title>
		<meta name="GENERATOR" content="Microsoft Visual Studio .NET 7.1">
		<meta name="CODE_LANGUAGE" content="Visual Basic .NET 7.1">
		<meta name="vs_defaultClientScript" content="JavaScript">
		<meta name="vs_targetSchema" content="http://schemas.microsoft.com/intellisense/ie5">
	</HEAD>
	<body MS_POSITIONING="GridLayout">
		<form id="Form1" method="post" runat="server">
			<asp:Label id="Label1" style="Z-INDEX: 101; LEFT: 152px; POSITION: absolute; TOP: 40px" runat="server"
				Font-Bold="True" Font-Names="Verdana">Using Link Buttons in Web Form</asp:Label>
			<asp:LinkButton id="LinkButton1" style="Z-INDEX: 102; LEFT: 160px; POSITION: absolute; TOP: 104px"
				runat="server" Width="48px" Height="32px" Font-Names="Verdana" Font-Size="Smaller" ToolTip="Click to perform Page Postback">here</asp:LinkButton>
			<asp:Label id="Label2" style="Z-INDEX: 103; LEFT: 112px; POSITION: absolute; TOP: 104px" runat="server"
				Font-Names="Verdana" Width="32px" Height="16px" Font-Size="Smaller">Click</asp:Label>
			<asp:Label id="Label3" style="Z-INDEX: 104; LEFT: 200px; POSITION: absolute; TOP: 104px" runat="server"
				Font-Names="Verdana" Width="320px" Font-Size="Smaller">to perform postback operation using Link Button</asp:Label>
			<asp:TextBox id="TextBox1" style="Z-INDEX: 105; LEFT: 120px; POSITION: absolute; TOP: 144px"
				runat="server" Width="296px"></asp:TextBox>
		</form>
	</body>
</HTML>
