<%@ Page Language="vb" AutoEventWireup="false" Codebehind="WebForm1.aspx.vb" Inherits="WebUserContols.WebForm1"%>
<%@ Register TagPrefix="uc1" TagName="WebUserControl1" Src="WebUserControl1.ascx" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.0 Transitional//EN">
<HTML>
	<HEAD>
		<title>Web User Control Example</title>
		<meta name="GENERATOR" content="Microsoft Visual Studio .NET 7.1">
		<meta name="CODE_LANGUAGE" content="Visual Basic .NET 7.1">
		<meta name="vs_defaultClientScript" content="JavaScript">
		<meta name="vs_targetSchema" content="http://schemas.microsoft.com/intellisense/ie5">
	</HEAD>
	<body MS_POSITIONING="GridLayout">
		<form id="Form1" method="post" runat="server">
			<asp:Button id="Button1" style="Z-INDEX: 101; LEFT: 32px; POSITION: absolute; TOP: 80px" runat="server"
				Text="Click Here"></asp:Button>
			<asp:TextBox id="TextBox1" style="Z-INDEX: 102; LEFT: 24px; POSITION: absolute; TOP: 136px" runat="server"
				Width="192px"></asp:TextBox>
			<uc1:WebUserControl1 id="WebUserControl11" runat="server"></uc1:WebUserControl1>
		</form>
	</body>
</HTML>
