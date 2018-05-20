<%@ Page Language="vb" AutoEventWireup="false" Codebehind="WebForm1.aspx.vb" Inherits="RoundTrip.WebForm1"%>
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
			<asp:Button id="Button1" style="Z-INDEX: 101; LEFT: 168px; POSITION: absolute; TOP: 48px" runat="server"
				Text="Use Session"></asp:Button>
			<asp:Button id="Button2" style="Z-INDEX: 102; LEFT: 160px; POSITION: absolute; TOP: 96px" runat="server"
				Text="Use ViewState"></asp:Button>
			<asp:Button id="Button3" style="Z-INDEX: 103; LEFT: 144px; POSITION: absolute; TOP: 144px" runat="server"
				Text="Use Hidden controls"></asp:Button>
			<asp:TextBox id="TextBox1" style="Z-INDEX: 104; LEFT: 152px; POSITION: absolute; TOP: 192px"
				runat="server"></asp:TextBox><INPUT id="Hidden1" style="Z-INDEX: 105; LEFT: 24px; POSITION: absolute; TOP: 224px" type="hidden"
				name="Hidden1" runat="server" value="1">
		</form>
	</body>
</HTML>
