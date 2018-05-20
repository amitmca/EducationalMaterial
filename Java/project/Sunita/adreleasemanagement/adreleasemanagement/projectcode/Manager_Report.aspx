<%@ Page language="c#" Codebehind="Manager_Report.aspx.cs" AutoEventWireup="false" Inherits="Group_17.WebForm2" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.0 Transitional//EN" >
<HTML>
	<HEAD>
		<title>WebForm2</title>
		<meta content="Microsoft Visual Studio .NET 7.1" name="GENERATOR">
		<meta content="C#" name="CODE_LANGUAGE">
		<meta content="JavaScript" name="vs_defaultClientScript">
		<meta content="http://schemas.microsoft.com/intellisense/ie5" name="vs_targetSchema">
	</HEAD>
	<body bgColor="aliceblue" onload="javascript:history.go(1)" MS_POSITIONING="GridLayout">
		<form id="Form1" style="BACKGROUND-IMAGE: none; VERTICAL-ALIGN: baseline; BORDER-TOP-STYLE: solid; BORDER-RIGHT-STYLE: solid; BORDER-LEFT-STYLE: solid; BACKGROUND-COLOR: #ccccff; TEXT-ALIGN: center; BORDER-BOTTOM-STYLE: solid"
			method="post" runat="server">
			<asp:Label id="lblMessage" style="Z-INDEX: 109; LEFT: 376px; POSITION: absolute; TOP: 480px"
				runat="server" ForeColor="Navy" BackColor="AliceBlue" Width="224px" Height="27px"></asp:Label>
			<asp:Button id="btnLogout" style="Z-INDEX: 108; LEFT: 568px; POSITION: absolute; TOP: 544px"
				runat="server" Text="Logout" Width="120px" BackColor="Silver" ForeColor="Navy"></asp:Button>
			<asp:button id="btnStrategy" style="Z-INDEX: 107; LEFT: 216px; POSITION: absolute; TOP: 544px"
				runat="server" Text="Strategy Report" Width="120px" BackColor="Silver" ForeColor="Navy"></asp:button>
			<asp:button id="btnBudget" style="Z-INDEX: 106; LEFT: 384px; POSITION: absolute; TOP: 544px"
				runat="server" Text=" Budget Report" Width="120px" BackColor="Silver" ForeColor="Navy" BorderColor="DarkGray"></asp:button><asp:label id="lblHeader" style="Z-INDEX: 101; LEFT: 280px; POSITION: absolute; TOP: 32px"
				runat="server" ForeColor="DarkGreen" BackColor="AliceBlue" Width="393px" Height="32px" Font-Italic="True" Font-Size="Large" Font-Bold="True">Management  Reports</asp:label>
			<DIV id="grdInsert" style="Z-INDEX: 103; LEFT: 232px; WIDTH: 638px; POSITION: absolute; TOP: 104px; HEIGHT: 356px; BACKGROUND-COLOR: aliceblue"
				runat="server" ms_positioning="GridLayout">
				<asp:Button id="btnAddRec" style="Z-INDEX: 101; LEFT: 56px; POSITION: absolute; TOP: 280px"
					runat="server" Text="Add Record" Width="120px" BackColor="Silver" ForeColor="Navy" BorderColor="Silver"></asp:Button>
				<asp:Button id="btnReset" style="Z-INDEX: 102; LEFT: 224px; POSITION: absolute; TOP: 280px"
					runat="server" Text="Reset" Width="120px" BackColor="Silver" ForeColor="Navy" BorderColor="LightGray"></asp:Button>
				<asp:Label id="lblEndDate" style="Z-INDEX: 103; LEFT: 48px; POSITION: absolute; TOP: 216px"
					runat="server" Width="120px" BackColor="Transparent" ForeColor="Navy" Height="10px">End Date</asp:Label>
				<asp:Label id="lblStartDate" style="Z-INDEX: 104; LEFT: 48px; POSITION: absolute; TOP: 160px"
					runat="server" Width="120px" BackColor="Transparent" ForeColor="Navy" Height="10px">Start Date</asp:Label>
				<asp:Label id="lblBudget" style="Z-INDEX: 105; LEFT: 48px; POSITION: absolute; TOP: 104px"
					runat="server" Width="120px" BackColor="Transparent" ForeColor="Navy" Height="10px">Budget Amount</asp:Label>
				<asp:TextBox id="txtBudget" style="Z-INDEX: 106; LEFT: 200px; POSITION: absolute; TOP: 104px"
					runat="server" BackColor="Gainsboro"></asp:TextBox>
				<asp:TextBox id="txtStartDate" style="Z-INDEX: 107; LEFT: 200px; POSITION: absolute; TOP: 160px"
					runat="server" BackColor="#E0E0E0">select date from calendar</asp:TextBox>
				<asp:TextBox id="txtEndDate" style="Z-INDEX: 108; LEFT: 200px; POSITION: absolute; TOP: 216px"
					runat="server" BackColor="#E0E0E0">select date from calendar</asp:TextBox>
				<asp:Label id="lblInsert" style="Z-INDEX: 109; LEFT: 136px; POSITION: absolute; TOP: 40px"
					runat="server" Width="145px" BackColor="AliceBlue" ForeColor="Navy" Height="24px" Font-Bold="True">Add New Record</asp:Label>
				<asp:RegularExpressionValidator id="rfvBudget" style="Z-INDEX: 110; LEFT: 384px; POSITION: absolute; TOP: 104px"
					runat="server" ForeColor="Maroon" ErrorMessage="Please enter valid amount" ControlToValidate="txtBudget" ValidationExpression="\d{3,6}"></asp:RegularExpressionValidator>
				<asp:Calendar id="clnStartDate" style="Z-INDEX: 111; LEFT: 368px; POSITION: absolute; TOP: 136px"
					runat="server" Height="202px" Width="232px" BackColor="AliceBlue" BorderColor="Gainsboro"
					SelectMonthText="Next;Previous;" PrevMonthText="Previous" NextMonthText="Next" SelectWeekText="Next"></asp:Calendar>
				<asp:Calendar id="clnEndDate" style="Z-INDEX: 110; LEFT: 368px; POSITION: absolute; TOP: 136px"
					runat="server" Height="174px" Width="232px" SelectMonthText="Next;Previous" PrevMonthText="Previous"
					NextMonthText="Next" SelectWeekText="Next"></asp:Calendar></DIV>
			<asp:datagrid id="dgView" style="Z-INDEX: 104; LEFT: 80px; POSITION: absolute; TOP: 144px" runat="server"
				Height="258px" Width="864px" BorderColor="White" HorizontalAlign="Center" AllowPaging="True"
				PageSize="5" BorderStyle="Ridge" CellSpacing="1" BorderWidth="2px" CellPadding="3" GridLines="None">
				<SelectedItemStyle Font-Bold="True" HorizontalAlign="Center" ForeColor="White" VerticalAlign="Middle"
					BackColor="#9471DE"></SelectedItemStyle>
				<EditItemStyle HorizontalAlign="Center" VerticalAlign="Middle"></EditItemStyle>
				<ItemStyle HorizontalAlign="Center" ForeColor="Black" VerticalAlign="Middle" BackColor="#DEDFDE"></ItemStyle>
				<HeaderStyle Font-Underline="True" Font-Bold="True" HorizontalAlign="Center" ForeColor="Linen"
					VerticalAlign="Middle" BackColor="#4A3C8C"></HeaderStyle>
				<FooterStyle ForeColor="Black" BackColor="White"></FooterStyle>
				<PagerStyle NextPageText="Next" Font-Size="Smaller" Font-Names="Verdana" Font-Italic="True"
					PrevPageText="Previous" HorizontalAlign="Right" ForeColor="Navy" BackColor="Silver" PageButtonCount="5"></PagerStyle>
			</asp:datagrid><asp:label id="lblGridHead" style="Z-INDEX: 105; LEFT: 352px; POSITION: absolute; TOP: 80px"
				runat="server" ForeColor="Navy" BackColor="AliceBlue" Width="241px" Height="32px" Font-Italic="True" Font-Size="Larger"
				Font-Bold="True"></asp:label>
			<asp:Button id="btnInsertRec" style="Z-INDEX: 102; LEFT: 432px; POSITION: absolute; TOP: 432px"
				runat="server" Text="Insert New Record" Width="120px" BackColor="Silver" ForeColor="Navy"></asp:Button></form>
	</body>
</HTML>
