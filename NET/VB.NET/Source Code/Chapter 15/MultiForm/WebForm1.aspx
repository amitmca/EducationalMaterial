<%@ Page Language="vb" AutoEventWireup="false" Codebehind="WebForm1.aspx.vb" Inherits="MultiForm.WebForm1"%>
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
			<asp:Label id="Label1" style="Z-INDEX: 101; LEFT: 104px; POSITION: absolute; TOP: 24px" runat="server"
				Font-Size="XX-Large">Web Form 1 </asp:Label>
			<asp:HyperLink id="HyperLink1" style="Z-INDEX: 102; LEFT: 176px; POSITION: absolute; TOP: 112px"
				runat="server" NavigateUrl="WebForm2.aspx">See Web Form 2</asp:HyperLink>
			<asp:HyperLink id="HyperLink2" style="Z-INDEX: 103; LEFT: 176px; POSITION: absolute; TOP: 160px"
				runat="server" NavigateUrl="HTMLPage1.htm">See HTML Page 1</asp:HyperLink>
		</form>
	</body>
</HTML>
