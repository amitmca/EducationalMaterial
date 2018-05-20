<%@ Page language="c#" Codebehind="dailydetails.aspx.cs" AutoEventWireup="false" Inherits="Advertisement.dailydetails" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.0 Transitional//EN" >
<HTML>
	<HEAD>
		<title>Daily Details</title>
		<meta content="Microsoft Visual Studio .NET 7.1" name="GENERATOR">
		<meta content="C#" name="CODE_LANGUAGE">
		<meta content="JavaScript" name="vs_defaultClientScript">
		<meta content="http://schemas.microsoft.com/intellisense/ie5" name="vs_targetSchema">
	</HEAD>
	<body bgColor="antiquewhite" MS_POSITIONING="GridLayout">
		<form id="Form1" method="post" runat="server">
			<asp:label id="lblDailyDetails" style="Z-INDEX: 101; LEFT: 248px; POSITION: absolute; TOP: 40px"
				runat="server" Font-Underline="True" Font-Size="Larger" ForeColor="#0000C0" Font-Bold="True"
				Width="304px">Entering Daily Details Of the Ad</asp:label><asp:dropdownlist id="cboAdName" style="Z-INDEX: 102; LEFT: 328px; POSITION: absolute; TOP: 112px"
				runat="server" Width="160px" AutoPostBack="True" BackColor="#FFFFC0"></asp:dropdownlist><asp:label id="lblAdName" style="Z-INDEX: 103; LEFT: 224px; POSITION: absolute; TOP: 112px"
				runat="server" Font-Bold="True">AdName</asp:label><asp:label id="lblTimeSlot" style="Z-INDEX: 104; LEFT: 224px; POSITION: absolute; TOP: 152px"
				runat="server" Font-Bold="True">TimeSlot</asp:label><asp:dropdownlist id="cboTimeSlot" style="Z-INDEX: 105; LEFT: 328px; POSITION: absolute; TOP: 152px"
				runat="server" Width="88px" BackColor="#FFFFC0">
				<asp:ListItem Value=" Slot Time"> Slot Time</asp:ListItem>
				<asp:ListItem Value="1-2">1-2</asp:ListItem>
				<asp:ListItem Value="2-3">2-3</asp:ListItem>
				<asp:ListItem Value="3-4">3-4</asp:ListItem>
				<asp:ListItem Value="4-5">4-5</asp:ListItem>
				<asp:ListItem Value="5-6">5-6</asp:ListItem>
				<asp:ListItem Value="6-7">6-7</asp:ListItem>
				<asp:ListItem Value="7-8">7-8</asp:ListItem>
				<asp:ListItem Value="8-9">8-9</asp:ListItem>
				<asp:ListItem Value="9-10">9-10</asp:ListItem>
				<asp:ListItem Value="10-11">10-11</asp:ListItem>
				<asp:ListItem Value="11-12">11-12</asp:ListItem>
				<asp:ListItem Value="12-1">12-1</asp:ListItem>
			</asp:dropdownlist><asp:label id="lblRotations" style="Z-INDEX: 106; LEFT: 224px; POSITION: absolute; TOP: 208px"
				runat="server" Font-Bold="True">Rotations</asp:label><asp:textbox id="txtRotations" style="Z-INDEX: 107; LEFT: 328px; POSITION: absolute; TOP: 208px"
				runat="server" Width="160px" BackColor="#FFFFC0" BorderStyle="Groove" ReadOnly="True"></asp:textbox><asp:label id="lblduration" style="Z-INDEX: 108; LEFT: 224px; POSITION: absolute; TOP: 256px"
				runat="server" Font-Bold="True">Duration</asp:label><asp:textbox id="txtDuration" style="Z-INDEX: 109; LEFT: 328px; POSITION: absolute; TOP: 256px"
				runat="server" Width="160px" BackColor="#FFFFC0" BorderStyle="Groove" ReadOnly="True"></asp:textbox><asp:label id="lblAmt" style="Z-INDEX: 110; LEFT: 224px; POSITION: absolute; TOP: 304px" runat="server"
				Font-Bold="True">Amount</asp:label><asp:textbox id="txtAmt" style="Z-INDEX: 111; LEFT: 328px; POSITION: absolute; TOP: 304px" runat="server"
				Width="160px" BackColor="#FFFFC0" BorderStyle="Groove" ReadOnly="True"></asp:textbox><asp:button id="cmdSubmit" style="Z-INDEX: 112; LEFT: 328px; POSITION: absolute; TOP: 352px"
				runat="server" Font-Bold="True" BackColor="#C0C0FF" Enabled="False" Text="Submit"></asp:button><asp:dropdownlist id="cboTime" style="Z-INDEX: 113; LEFT: 424px; POSITION: absolute; TOP: 152px" runat="server"
				Width="64px" BackColor="#FFFFC0">
				<asp:ListItem Value="Select">Select</asp:ListItem>
				<asp:ListItem Value="A.M">A.M</asp:ListItem>
				<asp:ListItem Value="P.M">P.M</asp:ListItem>
			</asp:dropdownlist><asp:label id="lblErrMsg" style="Z-INDEX: 114; LEFT: 544px; POSITION: absolute; TOP: 112px"
				runat="server" ForeColor="Red"></asp:label><asp:label id="lblErrSlot" style="Z-INDEX: 115; LEFT: 544px; POSITION: absolute; TOP: 168px"
				runat="server" ForeColor="Red"></asp:label><asp:label id="lblErrTime" style="Z-INDEX: 116; LEFT: 544px; POSITION: absolute; TOP: 144px"
				runat="server" ForeColor="Red"></asp:label><asp:label id="lblMsg" style="Z-INDEX: 117; LEFT: 328px; POSITION: absolute; TOP: 80px" runat="server"
				ForeColor="Red" Font-Bold="True" Width="256px" Font-Italic="True"></asp:label><asp:linkbutton id="lkcmdAvlb" style="Z-INDEX: 118; LEFT: 336px; POSITION: absolute; TOP: 176px"
				runat="server" Visible="False">Check For Availability</asp:linkbutton><asp:label id="lblAvail" style="Z-INDEX: 119; LEFT: 544px; POSITION: absolute; TOP: 152px"
				runat="server" ForeColor="Red" Font-Bold="True" Width="236px"></asp:label>
			<asp:Button id="cmdClear" style="Z-INDEX: 120; LEFT: 416px; POSITION: absolute; TOP: 352px"
				runat="server" Font-Bold="True" Width="64px" BackColor="#C0C0FF" Text="Clear"></asp:Button>
			<asp:DataGrid id="dgDailyDetails" style="Z-INDEX: 121; LEFT: 192px; POSITION: absolute; TOP: 448px"
				runat="server" Width="432px" ForeColor="Black" BackColor="White" BorderStyle="Solid" AutoGenerateColumns="False"
				BorderColor="#999999" BorderWidth="1px" CellPadding="3" GridLines="Vertical">
				<SelectedItemStyle Font-Bold="True" ForeColor="White" BackColor="#000099"></SelectedItemStyle>
				<AlternatingItemStyle BackColor="#CCCCCC"></AlternatingItemStyle>
				<HeaderStyle Font-Bold="True" ForeColor="White" BackColor="Black"></HeaderStyle>
				<FooterStyle BackColor="#CCCCCC"></FooterStyle>
				<Columns>
					<asp:BoundColumn DataField="Ad_Name" HeaderText="AD Name"></asp:BoundColumn>
					<asp:BoundColumn DataField="Time_Slot" HeaderText="Time Slot"></asp:BoundColumn>
					<asp:BoundColumn DataField="Tot_Time" HeaderText="Total Time"></asp:BoundColumn>
				</Columns>
				<PagerStyle HorizontalAlign="Center" ForeColor="Black" BackColor="#999999"></PagerStyle>
			</asp:DataGrid>
			<asp:Label id="lblGrid" style="Z-INDEX: 122; LEFT: 368px; POSITION: absolute; TOP: 416px" runat="server"
				Font-Bold="True" Font-Underline="True">Filled Slots</asp:Label>
			<asp:Label id="lblDate" style="Z-INDEX: 123; LEFT: 648px; POSITION: absolute; TOP: 40px" runat="server"
				Font-Bold="True" ForeColor="Green"></asp:Label></form>
	</body>
</HTML>
