<%@ Page Language="vb" AutoEventWireup="false" Codebehind="WebForm1.aspx.vb" Inherits="ImageButton.WebForm1"%>
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
			<asp:ImageButton id="ImageButton1" style="Z-INDEX: 101; LEFT: 128px; POSITION: absolute; TOP: 136px"
				runat="server" ImageUrl="ImageButton.bmp"></asp:ImageButton>
			<asp:Label id="Label1" style="Z-INDEX: 102; LEFT: 56px; POSITION: absolute; TOP: 48px" runat="server"
				Font-Bold="True" Font-Size="Large" Font-Names="Verdana">Using Image Button in Web Form</asp:Label>
			<asp:TextBox id="TextBox1" style="Z-INDEX: 103; LEFT: 128px; POSITION: absolute; TOP: 256px"
				runat="server" Width="240px"></asp:TextBox>
		</form>
	</body>
</HTML>
