<%@ Page Language="vb" AutoEventWireup="false" Codebehind="WebForm1.aspx.vb" Inherits="Tables.WebForm1"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.0 Transitional//EN">
<HTML>
	<HEAD>
		<title>WebForm2</title>
		<meta name="GENERATOR" content="Microsoft Visual Studio .NET 7.1">
		<meta name="CODE_LANGUAGE" content="Visual Basic .NET 7.1">
		<meta name="vs_defaultClientScript" content="JavaScript">
		<meta name="vs_targetSchema" content="http://schemas.microsoft.com/intellisense/ie5">
	</HEAD>
	<body MS_POSITIONING="GridLayout">
		<form id="Form1" method="post" runat="server">
			<asp:Table id="Table1" style="Z-INDEX: 101; LEFT: 96px; POSITION: absolute; TOP: 63px" runat="server"
				BorderStyle="Solid" Height="163px" Width="313px" BorderColor="Black" BorderWidth="2px">
				<asp:TableRow HorizontalAlign="Center">
					<asp:TableCell BorderStyle="Solid" BorderWidth="1px" Font-Bold="True" Text="Name"></asp:TableCell>
					<asp:TableCell BorderStyle="Solid" BorderWidth="1px" Font-Bold="True" Text="Day"></asp:TableCell>
					<asp:TableCell BorderStyle="Solid" BorderWidth="1px" Font-Bold="True" Text="Radius (miles)"></asp:TableCell>
					<asp:TableCell BorderStyle="Solid" BorderWidth="1px" Font-Bold="True" Text="Perihelion (million miles)"></asp:TableCell>
				</asp:TableRow>
				<asp:TableRow HorizontalAlign="Center">
					<asp:TableCell BorderStyle="Solid" BorderWidth="1px" Text="Mercury"></asp:TableCell>
					<asp:TableCell BorderStyle="Solid" BorderWidth="1px" Text="58.65"></asp:TableCell>
					<asp:TableCell BorderStyle="Solid" BorderWidth="1px" Text="1516"></asp:TableCell>
					<asp:TableCell BorderStyle="Solid" BorderWidth="1px" Text="43.4"></asp:TableCell>
				</asp:TableRow>
				<asp:TableRow HorizontalAlign="Center">
					<asp:TableCell BorderStyle="Solid" BorderWidth="1px" Text="Venus"></asp:TableCell>
					<asp:TableCell BorderStyle="Solid" BorderWidth="1px" Text="116.75"></asp:TableCell>
					<asp:TableCell BorderStyle="Solid" BorderWidth="1px" Text="3716"></asp:TableCell>
					<asp:TableCell BorderStyle="Solid" BorderWidth="1px" Text="66.8"></asp:TableCell>
				</asp:TableRow>
				<asp:TableRow HorizontalAlign="Center">
					<asp:TableCell BorderStyle="Solid" BorderWidth="1px" Text="Earth"></asp:TableCell>
					<asp:TableCell BorderStyle="Solid" BorderWidth="1px" Text="1"></asp:TableCell>
					<asp:TableCell BorderStyle="Solid" BorderWidth="1px" Text="2107"></asp:TableCell>
					<asp:TableCell BorderStyle="Solid" BorderWidth="1px" Text="128.4"></asp:TableCell>
				</asp:TableRow>
			</asp:Table>
		</form>
	</body>
</HTML>
