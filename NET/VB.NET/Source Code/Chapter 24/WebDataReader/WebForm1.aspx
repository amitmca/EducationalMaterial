<%@ Page Language="vb" AutoEventWireup="false" Codebehind="WebForm1.aspx.vb" Inherits="WebDataReader.WebForm1"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.0 Transitional//EN">
<HTML>
	<HEAD>
		<title>Data Reader Example</title>
		<meta name="GENERATOR" content="Microsoft Visual Studio .NET 7.1">
		<meta name="CODE_LANGUAGE" content="Visual Basic .NET 7.1">
		<meta name="vs_defaultClientScript" content="JavaScript">
		<meta name="vs_targetSchema" content="http://schemas.microsoft.com/intellisense/ie5">
	</HEAD>
	<body MS_POSITIONING="GridLayout">
		<form id="Form1" method="post" runat="server">
			<asp:DataGrid id="DataGrid1" style="Z-INDEX: 101; LEFT: 24px; POSITION: absolute; TOP: 88px" runat="server"
				Height="176px" Width="520px" BorderColor="Tan" BorderWidth="1px" BackColor="LightGoldenrodYellow"
				CellPadding="2" GridLines="None" ForeColor="Black">
				<FooterStyle BackColor="Tan"></FooterStyle>
				<SelectedItemStyle ForeColor="GhostWhite" BackColor="DarkSlateBlue"></SelectedItemStyle>
				<AlternatingItemStyle BackColor="PaleGoldenrod"></AlternatingItemStyle>
				<HeaderStyle Font-Bold="True" BackColor="Tan"></HeaderStyle>
				<PagerStyle HorizontalAlign="Center" ForeColor="DarkSlateBlue" BackColor="PaleGoldenrod"></PagerStyle>
			</asp:DataGrid>
			<asp:Label id="Label1" style="Z-INDEX: 102; LEFT: 16px; POSITION: absolute; TOP: 40px" runat="server"
				Height="16px" Font-Bold="True" Font-Names="Verdana" Font-Size="Large">Data Reader Example</asp:Label>
		</form>
	</body>
</HTML>
