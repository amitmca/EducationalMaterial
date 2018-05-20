<%@ Page language="c#" Codebehind="InvalidSession.aspx.cs" AutoEventWireup="false" Inherits="Advertisement.InvalidSession" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.0 Transitional//EN" >
<HTML>
	<HEAD>
		<title>InvalidSession</title>
		<meta name="GENERATOR" Content="Microsoft Visual Studio .NET 7.1">
		<meta name="CODE_LANGUAGE" Content="C#">
		<meta name="vs_defaultClientScript" content="JavaScript">
		<meta name="vs_targetSchema" content="http://schemas.microsoft.com/intellisense/ie5">
	</HEAD>
	<body MS_POSITIONING="GridLayout">
		<form id="Form1" method="post" runat="server">
			<asp:Label id="lblSession" style="Z-INDEX: 101; LEFT: 192px; POSITION: absolute; TOP: 160px"
				runat="server" Width="401px" Font-Bold="True" ForeColor="Red" Font-Size="Large">Your Session Has Been Expired</asp:Label>
			<asp:LinkButton id="LinkButton1" style="Z-INDEX: 102; LEFT: 336px; POSITION: absolute; TOP: 216px"
				runat="server" Font-Bold="True">Login</asp:LinkButton>
		</form>
	</body>
</HTML>
