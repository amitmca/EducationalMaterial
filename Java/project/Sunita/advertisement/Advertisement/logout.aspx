<%@ Page language="c#" Codebehind="logout.aspx.cs" AutoEventWireup="false" Inherits="Advertisement.logout" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.0 Transitional//EN" >
<HTML>
	<HEAD>
		<title>Logout Page</title>
		<meta name="GENERATOR" Content="Microsoft Visual Studio .NET 7.1">
		<meta name="CODE_LANGUAGE" Content="C#">
		<meta name="vs_defaultClientScript" content="JavaScript">
		<meta name="vs_targetSchema" content="http://schemas.microsoft.com/intellisense/ie5">
	</HEAD>
	<body MS_POSITIONING="GridLayout">
		<form id="Form1" method="post" runat="server">
			<asp:Label id="lbllogout" style="Z-INDEX: 101; LEFT: 376px; POSITION: absolute; TOP: 192px"
				runat="server" Width="264px" Font-Bold="True" Font-Italic="True" Font-Size="Medium" ForeColor="Olive">You Are Logged Out Succesfully</asp:Label>
			<asp:Button id="cmdExit" style="Z-INDEX: 102; LEFT: 448px; POSITION: absolute; TOP: 256px" runat="server"
				Width="112px" Font-Bold="True" ForeColor="Black" Text="Login Again" BackColor="#C0C0FF"></asp:Button>
			<HR style="Z-INDEX: 103; LEFT: 232px; WIDTH: 59.93%; POSITION: absolute; TOP: 152px; HEIGHT: 1px"
				width="59.93%" SIZE="1">
			<HR style="Z-INDEX: 104; LEFT: 232px; WIDTH: 61.29%; POSITION: absolute; TOP: 312px; HEIGHT: 1px"
				width="61.29%" SIZE="1">
		</form>
	</body>
</HTML>
