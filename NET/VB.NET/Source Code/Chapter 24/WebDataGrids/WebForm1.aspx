<%@ Page Language="vb" AutoEventWireup="false" Codebehind="WebForm1.aspx.vb" Inherits="WebDataGrids.WebForm1"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.0 Transitional//EN">
<HTML>
	<HEAD>
		<title>WebDataGrids Example</title>
		<meta name="GENERATOR" content="Microsoft Visual Studio .NET 7.1">
		<meta name="CODE_LANGUAGE" content="Visual Basic .NET 7.1">
		<meta name="vs_defaultClientScript" content="JavaScript">
		<meta name="vs_targetSchema" content="http://schemas.microsoft.com/intellisense/ie5">
	</HEAD>
	<body MS_POSITIONING="GridLayout">
		<form id="Form1" method="post" runat="server">
			<asp:DataGrid id=DataGrid1 style="Z-INDEX: 101; LEFT: 16px; POSITION: absolute; TOP: 88px" runat="server" Height="128px" Width="504px" DataSource="<%# DataSet11 %>" DataMember="authors" PageSize="5">
				<PagerStyle Mode="NumericPages"></PagerStyle>
			</asp:DataGrid>
			<asp:Label id="Label1" style="Z-INDEX: 102; LEFT: 16px; POSITION: absolute; TOP: 32px" runat="server"
				Font-Bold="True" Font-Names="Verdana" Font-Size="Large">Simple DataGrid Example</asp:Label>
		</form>
	</body>
</HTML>
