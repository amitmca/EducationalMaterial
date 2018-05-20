<%@ Page Language="vb" AutoEventWireup="false" Codebehind="WebForm1.aspx.vb" Inherits="CustomizedDataGrid.WebForm1" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.0 Transitional//EN">
<HTML>
	<HEAD>
		<title>WebForm1</title>
		<meta content="Microsoft Visual Studio .NET 7.1" name="GENERATOR">
		<meta content="Visual Basic .NET 7.1" name="CODE_LANGUAGE">
		<meta content="JavaScript" name="vs_defaultClientScript">
		<meta content="http://schemas.microsoft.com/intellisense/ie5" name="vs_targetSchema">
	</HEAD>
	<body MS_POSITIONING="GridLayout">
		<form id="Form1" method="post" runat="server">
			<asp:datagrid id="DataGrid1" style="Z-INDEX: 101; LEFT: 8px; POSITION: absolute; TOP: 88px" runat="server"
				BorderColor="#CC9966" BorderStyle="None" BorderWidth="2px" BackColor="White" CellPadding="8"
				AllowSorting="True" ShowFooter="True" AutoGenerateColumns="False" Width="653px" Height="224px"
				HorizontalAlign="Left" Font-Names="Verdana" PageSize="5" AllowPaging="True">
				<FooterStyle Font-Names="verdana" HorizontalAlign="Center" ForeColor="#330099" BackColor="#FFFFCC"></FooterStyle>
				<SelectedItemStyle Font-Bold="True" ForeColor="#663399" BackColor="#FFCC66"></SelectedItemStyle>
				<ItemStyle ForeColor="#330099" BackColor="White"></ItemStyle>
				<HeaderStyle Font-Names="verdana" Font-Bold="True" HorizontalAlign="Center" ForeColor="#FFFFCC"
					BackColor="#990000"></HeaderStyle>
				<Columns>
					<asp:BoundColumn DataField="au_id" SortExpression="au_id" HeaderText="Author ID"></asp:BoundColumn>
					<asp:BoundColumn DataField="au_lname" SortExpression="au_lname" HeaderText="Last Name"></asp:BoundColumn>
					<asp:BoundColumn DataField="au_fname" SortExpression="au_fname" HeaderText="First Name"></asp:BoundColumn>
					<asp:BoundColumn DataField="phone" SortExpression="phone" HeaderText="phone"></asp:BoundColumn>
					<asp:BoundColumn DataField="address" SortExpression="address" HeaderText="address"></asp:BoundColumn>
				</Columns>
				<PagerStyle HorizontalAlign="Center" ForeColor="#330099" BackColor="#FFFFCC" Mode="NumericPages"></PagerStyle>
			</asp:datagrid><asp:label id="Label1" style="Z-INDEX: 102; LEFT: 8px; POSITION: absolute; TOP: 32px" runat="server"
				Font-Bold="True" Font-Names="Verdana" Font-Size="Large">Customizing Data Grids</asp:label></form>
	</body>
</HTML>
