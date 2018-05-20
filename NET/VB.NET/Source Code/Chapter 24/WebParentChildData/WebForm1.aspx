<%@ Page Language="vb" AutoEventWireup="false" Codebehind="WebForm1.aspx.vb" Inherits="WebParentChildData.WebForm1"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.0 Transitional//EN">
<HTML>
	<HEAD>
		<title>Master Detail Web Form</title>
		<meta name="GENERATOR" content="Microsoft Visual Studio .NET 7.1">
		<meta name="CODE_LANGUAGE" content="Visual Basic .NET 7.1">
		<meta name="vs_defaultClientScript" content="JavaScript">
		<meta name="vs_targetSchema" content="http://schemas.microsoft.com/intellisense/ie5">
	</HEAD>
	<body MS_POSITIONING="GridLayout">
		<form id="Form1" method="post" runat="server">
			<asp:DataGrid id=DataGrid1 style="Z-INDEX: 101; LEFT: 16px; POSITION: absolute; TOP: 120px" runat="server" BorderColor="#CC9966" BorderStyle="None" BorderWidth="1px" BackColor="White" CellPadding="4" DataSource="<%# DataView1 %>" Width="224px" Height="192px" AutoGenerateColumns="False">
				<FooterStyle ForeColor="#330099" BackColor="#FFFFCC"></FooterStyle>
				<SelectedItemStyle Font-Bold="True" ForeColor="#663399" BackColor="#FFCC66"></SelectedItemStyle>
				<ItemStyle ForeColor="#330099" BackColor="White"></ItemStyle>
				<HeaderStyle Font-Bold="True" ForeColor="#FFFFCC" BackColor="#990000"></HeaderStyle>
				<Columns>
					<asp:BoundColumn DataField="au_id" SortExpression="au_id" HeaderText="ID"></asp:BoundColumn>
					<asp:BoundColumn DataField="au_fname" SortExpression="au_fname" HeaderText="First Name"></asp:BoundColumn>
					<asp:ButtonColumn Text="Select" DataTextField="au_lname" HeaderText="Last Name" CommandName="Select"></asp:ButtonColumn>
				</Columns>
				<PagerStyle HorizontalAlign="Center" ForeColor="#330099" BackColor="#FFFFCC"></PagerStyle>
			</asp:DataGrid>
			<asp:Label id="Label3" style="Z-INDEX: 107; LEFT: 280px; POSITION: absolute; TOP: 264px" runat="server"
				Font-Bold="True">State</asp:Label>
			<asp:Label id="Label2" style="Z-INDEX: 106; LEFT: 280px; POSITION: absolute; TOP: 184px" runat="server"
				Font-Bold="True">Last Name</asp:Label>
			<asp:TextBox id=TextBox4 style="Z-INDEX: 104; LEFT: 280px; POSITION: absolute; TOP: 296px" runat="server" Text='<%# DataBinder.Eval(DataView1, "[0].state") %>'>
			</asp:TextBox>
			<asp:TextBox id=TextBox3 style="Z-INDEX: 103; LEFT: 280px; POSITION: absolute; TOP: 216px" runat="server" Text='<%# DataBinder.Eval(DataView1, "[0].au_lname") %>'>
			</asp:TextBox>
			<asp:TextBox id=TextBox2 style="Z-INDEX: 102; LEFT: 280px; POSITION: absolute; TOP: 136px" runat="server" Text='<%# DataBinder.Eval(DataView1, "[0].au_fname") %>'>
			</asp:TextBox>
			<asp:Label id="Label1" style="Z-INDEX: 105; LEFT: 280px; POSITION: absolute; TOP: 112px" runat="server"
				Font-Bold="True">First Name</asp:Label>
			<asp:Label id="Label4" style="Z-INDEX: 108; LEFT: 16px; POSITION: absolute; TOP: 48px" runat="server"
				Font-Bold="True" Font-Names="Verdana" Font-Size="Large">Master Detail Web Form</asp:Label>
		</form>
	</body>
</HTML>
