<%@ Page Language="vb" AutoEventWireup="false" 
Codebehind="WebForm1.aspx.vb" Inherits="Controls.WebForm1"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.0 Transitional//EN">
<HTML>
	<HEAD>
		<title></title>
		<meta content="Microsoft Visual Studio.NET 7.1" name="GENERATOR">
		<meta content="Visual Basic 7.0" name="CODE_LANGUAGE">
		<meta content="JavaScript" name="vs_defaultClientScript">
		<meta content="http://schemas.microsoft.com/intellisense/ie5" name="vs_targetSchema">
	</HEAD>
	<body MS_POSITIONING="GridLayout">
		<form id="Form1" method="post" runat="server">
			<asp:button id="Button1" style="Z-INDEX: 101; LEFT: 170px; POSITION: absolute; TOP: 47px" runat="server"
				Text="Enable/disable text box" Width="164px" Height="24px" ToolTip="This is a button"></asp:button>
			<asp:Button id="Button4" style="Z-INDEX: 105; LEFT: 190px; POSITION: absolute; TOP: 165px" runat="server"
				Text="Move text box"></asp:Button>
			<asp:button id="Button3" style="Z-INDEX: 104; LEFT: 152px; POSITION: absolute; TOP: 128px" runat="server"
				Text="Change text box's style"></asp:button>
			<asp:button id="Button2" style="Z-INDEX: 103; LEFT: 162px; POSITION: absolute; TOP: 88px" tabIndex="1"
				runat="server" Text="Make text box visible/invisible" Width="184px" Height="24px"></asp:button><asp:textbox id="TextBox1" style="Z-INDEX: 102; LEFT: 181px; POSITION: absolute; TOP: 206px"
				tabIndex="2" runat="server" accessKey="T">
This is a text box.</asp:textbox></form>
	</body>
</HTML>
