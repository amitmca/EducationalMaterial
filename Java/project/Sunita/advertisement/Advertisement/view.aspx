<%@ Page language="c#" Codebehind="view.aspx.cs" AutoEventWireup="false" Inherits="Advertisement.view" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.0 Transitional//EN" >
<HTML>
  <HEAD>
		<title>View Page</title>
		<meta name="GENERATOR" Content="Microsoft Visual Studio .NET 7.1">
		<meta name="CODE_LANGUAGE" Content="C#">
		<meta name="vs_defaultClientScript" content="JavaScript">
		<meta name="vs_targetSchema" content="http://schemas.microsoft.com/intellisense/ie5">
  </HEAD>
	<body MS_POSITIONING="GridLayout" bgColor="antiquewhite">
		<form id="Form1" method="post" runat="server">
			<asp:Label id="lblView" style="Z-INDEX: 101; LEFT: 184px; POSITION: absolute; TOP: 48px" runat="server"
				Width="360px" Font-Bold="True" Font-Size="Medium" ForeColor="#0000C0" Font-Underline="True">Viewing Ad Timing Details Within a Duration</asp:Label>
			<asp:Label id="lblEndDate" style="Z-INDEX: 103; LEFT: 216px; POSITION: absolute; TOP: 168px"
				runat="server" Font-Bold="True">EndDate</asp:Label>
			<asp:Label id="lblStartDate" style="Z-INDEX: 102; LEFT: 216px; POSITION: absolute; TOP: 128px"
				runat="server" Font-Bold="True">StartDate</asp:Label>
			<asp:TextBox id="txtStartDate" style="Z-INDEX: 104; LEFT: 328px; POSITION: absolute; TOP: 128px"
				runat="server" ReadOnly="True" BackColor="#FFFFC0" BorderStyle="Groove"></asp:TextBox>
			<asp:TextBox id="txtEndDate" style="Z-INDEX: 105; LEFT: 328px; POSITION: absolute; TOP: 168px"
				runat="server" ReadOnly="True" BackColor="#FFFFC0" BorderStyle="Groove"></asp:TextBox>
			<asp:Calendar id="calStartDate" style="Z-INDEX: 106; LEFT: 600px; POSITION: absolute; TOP: 128px"
				runat="server" ForeColor="#663399" Font-Size="8pt" Width="220px" Height="200px" Visible="False"
				BorderWidth="1px" BackColor="#FFFFCC" DayNameFormat="FirstLetter" Font-Names="Verdana" BorderColor="#FFCC66"
				ShowGridLines="True">
				<TodayDayStyle ForeColor="White" BackColor="#FFCC66"></TodayDayStyle>
				<SelectorStyle BackColor="#FFCC66"></SelectorStyle>
				<NextPrevStyle Font-Size="9pt" ForeColor="#FFFFCC"></NextPrevStyle>
				<DayHeaderStyle Height="1px" BackColor="#FFCC66"></DayHeaderStyle>
				<SelectedDayStyle Font-Bold="True" BackColor="#CCCCFF"></SelectedDayStyle>
				<TitleStyle Font-Size="9pt" Font-Bold="True" ForeColor="#FFFFCC" BackColor="#990000"></TitleStyle>
				<OtherMonthDayStyle ForeColor="#CC9966"></OtherMonthDayStyle>
			</asp:Calendar>
			<asp:Calendar id="calEndDate" style="Z-INDEX: 107; LEFT: 592px; POSITION: absolute; TOP: 168px"
				runat="server" ForeColor="#663399" Font-Size="8pt" Width="220px" Height="200px" Visible="False"
				BorderWidth="1px" BackColor="#FFFFCC" DayNameFormat="FirstLetter" Font-Names="Verdana" BorderColor="#FFCC66"
				ShowGridLines="True">
				<TodayDayStyle ForeColor="White" BackColor="#FFCC66"></TodayDayStyle>
				<SelectorStyle BackColor="#FFCC66"></SelectorStyle>
				<NextPrevStyle Font-Size="9pt" ForeColor="#FFFFCC"></NextPrevStyle>
				<DayHeaderStyle Height="1px" BackColor="#FFCC66"></DayHeaderStyle>
				<SelectedDayStyle Font-Bold="True" BackColor="#CCCCFF"></SelectedDayStyle>
				<TitleStyle Font-Size="9pt" Font-Bold="True" ForeColor="#FFFFCC" BackColor="#990000"></TitleStyle>
				<OtherMonthDayStyle ForeColor="#CC9966"></OtherMonthDayStyle>
			</asp:Calendar>
			<asp:ImageButton id="cmdStartDate" style="Z-INDEX: 108; LEFT: 504px; POSITION: absolute; TOP: 136px"
				runat="server" Width="30px" ImageUrl="file:///E:\mahesh\imageButton.bmp" Height="8px"></asp:ImageButton>
			<asp:ImageButton id="cmdEndDate" style="Z-INDEX: 109; LEFT: 504px; POSITION: absolute; TOP: 176px"
				runat="server" Width="30px" ImageUrl="file:///E:\mahesh\imageButton2.bmp" Height="8px"></asp:ImageButton>
			<asp:Button id="cmdView" style="Z-INDEX: 110; LEFT: 384px; POSITION: absolute; TOP: 224px" runat="server"
				Font-Bold="True" BackColor="#C0C0FF" Text="View" Width="64px"></asp:Button>
			<asp:DataGrid id="dgView" style="Z-INDEX: 111; LEFT: 32px; POSITION: absolute; TOP: 200px" runat="server"
				BorderColor="White" BackColor="White" BorderWidth="2px" BorderStyle="Ridge" CellSpacing="1"
				CellPadding="3" GridLines="None" AutoGenerateColumns="False" Width="720px">
<SelectedItemStyle Font-Bold="True" ForeColor="White" BackColor="#9471DE">
</SelectedItemStyle>

<ItemStyle ForeColor="Black" BackColor="#DEDFDE">
</ItemStyle>

<HeaderStyle Font-Bold="True" ForeColor="#E7E7FF" BackColor="#4A3C8C">
</HeaderStyle>

<FooterStyle ForeColor="Black" BackColor="#C6C3C6">
</FooterStyle>

<Columns>
<asp:BoundColumn DataField="Ad_Name" HeaderText="AD Name"></asp:BoundColumn>
<asp:BoundColumn DataField="Advertiser_Name" HeaderText="Advertiser Name">
<HeaderStyle Width="8px">
</HeaderStyle>
</asp:BoundColumn>
<asp:BoundColumn DataField="Start_Date" HeaderText="Start Date"></asp:BoundColumn>
<asp:BoundColumn DataField="End_Date" HeaderText="End Date"></asp:BoundColumn>
<asp:BoundColumn DataField="Ad_Duration" HeaderText="AD Duration"></asp:BoundColumn>
<asp:BoundColumn DataField="No_Rotations" HeaderText="No Rotations"></asp:BoundColumn>
<asp:BoundColumn DataField="Tot_Amount" HeaderText="Total Amount"></asp:BoundColumn>
<asp:BoundColumn DataField="Amount_Paid" HeaderText="Amount Paid"></asp:BoundColumn>
</Columns>

<PagerStyle HorizontalAlign="Right" ForeColor="Black" BackColor="#C6C3C6">
</PagerStyle>
			</asp:DataGrid>
			<asp:LinkButton id="cmdGoBack" style="Z-INDEX: 112; LEFT: 672px; POSITION: absolute; TOP: 96px"
				runat="server" Visible="False" Width="64px">Go Back</asp:LinkButton>
			<asp:DataGrid id="dgBottom" style="Z-INDEX: 113; LEFT: 32px; POSITION: absolute; TOP: 96px" runat="server"
				BackColor="White" BorderColor="White" BorderWidth="2px" AutoGenerateColumns="False" GridLines="None"
				CellPadding="3" CellSpacing="1" BorderStyle="Ridge">
				<SelectedItemStyle Font-Bold="True" ForeColor="White" BackColor="#9471DE"></SelectedItemStyle>
				<ItemStyle ForeColor="Black" BackColor="#DEDFDE"></ItemStyle>
				<HeaderStyle Font-Bold="True" ForeColor="#E7E7FF" BackColor="#4A3C8C"></HeaderStyle>
				<FooterStyle ForeColor="Black" BackColor="#C6C3C6"></FooterStyle>
				<Columns>
					<asp:BoundColumn DataField="Tot_Amt" HeaderText="Total Amount"></asp:BoundColumn>
					<asp:BoundColumn DataField="Tot_Time" HeaderText="Total Time"></asp:BoundColumn>
				</Columns>
				<PagerStyle HorizontalAlign="Right" ForeColor="Black" BackColor="#C6C3C6"></PagerStyle>
			</asp:DataGrid>
			<asp:Label id="lblDates" style="Z-INDEX: 114; LEFT: 232px; POSITION: absolute; TOP: 168px"
				runat="server" ForeColor="Red" Font-Bold="True"></asp:Label>
		</form>
	</body>
</HTML>
