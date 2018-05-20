<%@ OutputCache Duration="30" VaryByParam="Name" %>
<%@ Page Language="vb" AutoEventWireup="false" Codebehind="WebForm1.aspx.vb" Inherits="OutputCachingVaryByParam.WebForm1"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.0 Transitional//EN">
<HTML>
	<HEAD>
		<title>Output Cache Example</title>
		<meta content="Microsoft Visual Studio .NET 7.1" name="GENERATOR">
		<meta content="Visual Basic .NET 7.1" name="CODE_LANGUAGE">
		<meta content="JavaScript" name="vs_defaultClientScript">
		<meta content="http://schemas.microsoft.com/intellisense/ie5" name="vs_targetSchema">
	</HEAD>
	<body MS_POSITIONING="GridLayout">
		<form id="Form1" method="post" runat="server">
			<asp:label id="Label1" style="Z-INDEX: 101; LEFT: 72px; POSITION: absolute; TOP: 88px" runat="server"
				Font-Names="Verdana">Please Enter your Name:</asp:label><asp:label id="Label2" style="Z-INDEX: 102; LEFT: 32px; POSITION: absolute; TOP: 184px" runat="server"></asp:label><asp:textbox id="Name" style="Z-INDEX: 103; LEFT: 320px; POSITION: absolute; TOP: 88px" runat="server"></asp:textbox><asp:label id="Label3" style="Z-INDEX: 104; LEFT: 136px; POSITION: absolute; TOP: 32px" runat="server"
				Font-Names="tahoma" Font-Bold="True">OutPut Cache VaryByParam Example</asp:label><asp:button id="Button1" style="Z-INDEX: 105; LEFT: 232px; POSITION: absolute; TOP: 144px" runat="server"
				Text="Submit"></asp:button>
		</form>
	</body>
</HTML>
