<%@ Page language="c#" Codebehind="updateForm.aspx.cs" AutoEventWireup="false" Inherits="Advertisement.updateForm" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.0 Transitional//EN" >
<HTML>
	<HEAD>
		<title>Update Form</title>
		<meta name="GENERATOR" Content="Microsoft Visual Studio .NET 7.1">
		<meta name="CODE_LANGUAGE" Content="C#">
		<meta name="vs_defaultClientScript" content="JavaScript">
		<meta name="vs_targetSchema" content="http://schemas.microsoft.com/intellisense/ie5">
	</HEAD>
	<body MS_POSITIONING="GridLayout" bgColor="antiquewhite">
		<form id="Form1" method="post" runat="server">
			<asp:Label id="lblUpdate" style="Z-INDEX: 101; LEFT: 208px; POSITION: absolute; TOP: 24px"
				runat="server" Width="384px" Font-Bold="True" Font-Size="Larger" ForeColor="Blue" Font-Underline="True"
				Height="8px">Updating Details Of Accepted Advertisement</asp:Label>
			<asp:Label id="lblAdId" style="Z-INDEX: 102; LEFT: 216px; POSITION: absolute; TOP: 88px" runat="server"
				Font-Bold="True" Visible="False">Ad Id</asp:Label>
			<asp:Label id="lblAdName" style="Z-INDEX: 103; LEFT: 216px; POSITION: absolute; TOP: 136px"
				runat="server" Font-Bold="True" Visible="False">Ad Name</asp:Label>
			<asp:TextBox id="txtAdId" style="Z-INDEX: 104; LEFT: 352px; POSITION: absolute; TOP: 88px" runat="server"
				Visible="False" ReadOnly="True" BackColor="#FFFFC0" BorderStyle="Groove"></asp:TextBox>
			<asp:TextBox id="txtAdName" style="Z-INDEX: 105; LEFT: 352px; POSITION: absolute; TOP: 136px"
				runat="server" Visible="False" BackColor="#FFFFC0" BorderStyle="Groove" MaxLength="10"></asp:TextBox>
			<asp:TextBox id="txtAdvName" style="Z-INDEX: 106; LEFT: 352px; POSITION: absolute; TOP: 184px"
				runat="server" Visible="False" BackColor="#FFFFC0" BorderStyle="Groove" MaxLength="15"></asp:TextBox>
			<asp:Label id="lblAdvName" style="Z-INDEX: 107; LEFT: 216px; POSITION: absolute; TOP: 184px"
				runat="server" Font-Bold="True" Visible="False">Advertiser Name</asp:Label>
			<asp:Label id="lblStartDate" style="Z-INDEX: 108; LEFT: 216px; POSITION: absolute; TOP: 232px"
				runat="server" Font-Bold="True" Visible="False">Start Date</asp:Label>
			<asp:TextBox id="txtStartDate" style="Z-INDEX: 109; LEFT: 352px; POSITION: absolute; TOP: 232px"
				runat="server" Visible="False" ReadOnly="True" BackColor="#FFFFC0" BorderStyle="Groove"></asp:TextBox>
			<asp:Label id="lblEndDate" style="Z-INDEX: 110; LEFT: 216px; POSITION: absolute; TOP: 280px"
				runat="server" Font-Bold="True" Visible="False">End Date</asp:Label>
			<asp:TextBox id="txtEndDate" style="Z-INDEX: 111; LEFT: 352px; POSITION: absolute; TOP: 280px"
				runat="server" Visible="False" ReadOnly="True" BackColor="#FFFFC0" BorderStyle="Groove"></asp:TextBox>
			<asp:Label id="lblDuration" style="Z-INDEX: 112; LEFT: 216px; POSITION: absolute; TOP: 328px"
				runat="server" Font-Bold="True" Visible="False">Ad Duration</asp:Label>
			<asp:Label id="lblRotations" style="Z-INDEX: 113; LEFT: 216px; POSITION: absolute; TOP: 376px"
				runat="server" Font-Bold="True" Visible="False">Rotations</asp:Label>
			<asp:Label id="lblTotAmt" style="Z-INDEX: 114; LEFT: 216px; POSITION: absolute; TOP: 424px"
				runat="server" Font-Bold="True" Visible="False">Total Amount</asp:Label>
			<asp:TextBox id="txtDuration" style="Z-INDEX: 115; LEFT: 352px; POSITION: absolute; TOP: 328px"
				runat="server" Visible="False" BackColor="#FFFFC0" BorderStyle="Groove" MaxLength="2"></asp:TextBox>
			<asp:TextBox id="txtRotations" style="Z-INDEX: 116; LEFT: 352px; POSITION: absolute; TOP: 376px"
				runat="server" Visible="False" BackColor="#FFFFC0" BorderStyle="Groove" MaxLength="2"></asp:TextBox>
			<asp:TextBox id="txtTotAmt" style="Z-INDEX: 117; LEFT: 352px; POSITION: absolute; TOP: 424px"
				runat="server" Visible="False" BackColor="#FFFFC0" BorderStyle="Groove"></asp:TextBox>
			<asp:Label id="lblAmtPaid" style="Z-INDEX: 118; LEFT: 216px; POSITION: absolute; TOP: 472px"
				runat="server" Font-Bold="True" Visible="False">Amount Paid</asp:Label>
			<asp:TextBox id="txtAmtPaid" style="Z-INDEX: 119; LEFT: 352px; POSITION: absolute; TOP: 472px"
				runat="server" Visible="False" BackColor="#FFFFC0" BorderStyle="Groove"></asp:TextBox>
			<asp:Calendar id="calStartDate" style="Z-INDEX: 120; LEFT: 592px; POSITION: absolute; TOP: 232px"
				runat="server" Width="220px" Font-Size="8pt" ForeColor="#663399" BorderWidth="1px" BackColor="#FFFFCC"
				DayNameFormat="FirstLetter" Height="200px" Font-Names="Verdana" BorderColor="#FFCC66" ShowGridLines="True"
				Visible="False">
				<TodayDayStyle ForeColor="White" BackColor="#FFCC66"></TodayDayStyle>
				<SelectorStyle BackColor="#FFCC66"></SelectorStyle>
				<NextPrevStyle Font-Size="9pt" ForeColor="#FFFFCC"></NextPrevStyle>
				<DayHeaderStyle Height="1px" BackColor="#FFCC66"></DayHeaderStyle>
				<SelectedDayStyle Font-Bold="True" BackColor="#CCCCFF"></SelectedDayStyle>
				<TitleStyle Font-Size="9pt" Font-Bold="True" ForeColor="#FFFFCC" BackColor="#990000"></TitleStyle>
				<OtherMonthDayStyle ForeColor="#CC9966"></OtherMonthDayStyle>
			</asp:Calendar>
			<asp:Calendar id="calEndDate" style="Z-INDEX: 121; LEFT: 592px; POSITION: absolute; TOP: 280px"
				runat="server" Width="220px" Font-Size="8pt" ForeColor="#663399" BorderWidth="1px" BackColor="#FFFFCC"
				DayNameFormat="FirstLetter" Height="200px" Font-Names="Verdana" BorderColor="#FFCC66" ShowGridLines="True"
				Visible="False">
				<TodayDayStyle ForeColor="White" BackColor="#FFCC66"></TodayDayStyle>
				<SelectorStyle BackColor="#FFCC66"></SelectorStyle>
				<NextPrevStyle Font-Size="9pt" ForeColor="#FFFFCC"></NextPrevStyle>
				<DayHeaderStyle Height="1px" BackColor="#FFCC66"></DayHeaderStyle>
				<SelectedDayStyle Font-Bold="True" BackColor="#CCCCFF"></SelectedDayStyle>
				<TitleStyle Font-Size="9pt" Font-Bold="True" ForeColor="#FFFFCC" BackColor="#990000"></TitleStyle>
				<OtherMonthDayStyle ForeColor="#CC9966"></OtherMonthDayStyle>
			</asp:Calendar>
			<asp:Button id="cmdUpdate" style="Z-INDEX: 122; LEFT: 392px; POSITION: absolute; TOP: 520px"
				runat="server" Font-Bold="True" BackColor="#C0C0FF" Text="Update" Visible="False"></asp:Button>
			<asp:RequiredFieldValidator id="fldvldAdName" style="Z-INDEX: 123; LEFT: 552px; POSITION: absolute; TOP: 136px"
				runat="server" Width="168px" ErrorMessage="Enter Advertisement Name" ControlToValidate="txtAdName"></asp:RequiredFieldValidator>
			<asp:RequiredFieldValidator id="fldvldAdvName" style="Z-INDEX: 124; LEFT: 552px; POSITION: absolute; TOP: 192px"
				runat="server" Width="136px" ErrorMessage="Enter advertser Name" ControlToValidate="txtadvName"></asp:RequiredFieldValidator>
			<asp:DropDownList id="cboAdName" style="Z-INDEX: 125; LEFT: 352px; POSITION: absolute; TOP: 160px"
				runat="server" AutoPostBack="True" BackColor="#FFFFC0"></asp:DropDownList>
			<asp:Label id="lblAdNameSlc" style="Z-INDEX: 126; LEFT: 216px; POSITION: absolute; TOP: 160px"
				runat="server" Font-Bold="True">Select Ad Name</asp:Label>
			<asp:ImageButton id="cmdStartDate" style="Z-INDEX: 127; LEFT: 536px; POSITION: absolute; TOP: 240px"
				runat="server" Visible="False" ImageUrl="/Advertisement/imageButton.bmp"></asp:ImageButton>
			<asp:ImageButton id="cmdEndDate" style="Z-INDEX: 128; LEFT: 536px; POSITION: absolute; TOP: 288px"
				runat="server" Visible="False" ImageUrl="/Advertisement/imageButton2.bmp"></asp:ImageButton>
			<asp:Label id="lblDispMsg" style="Z-INDEX: 129; LEFT: 352px; POSITION: absolute; TOP: 56px"
				runat="server" ForeColor="Red" Font-Bold="True"></asp:Label>
			<asp:RegularExpressionValidator id="expvldDuration" style="Z-INDEX: 130; LEFT: 552px; POSITION: absolute; TOP: 328px"
				runat="server" Width="136px" ControlToValidate="txtDuration" ErrorMessage="Enter Valid Duration" ValidationExpression="[0-9]*"></asp:RegularExpressionValidator>
			<asp:RegularExpressionValidator id="expvldRotations" style="Z-INDEX: 131; LEFT: 552px; POSITION: absolute; TOP: 376px"
				runat="server" Width="136px" ControlToValidate="txtRotations" ErrorMessage="Enter Valid Rotations" ValidationExpression="[0-9]*"></asp:RegularExpressionValidator>
			<asp:RegularExpressionValidator id="expvldTotAmt" style="Z-INDEX: 132; LEFT: 552px; POSITION: absolute; TOP: 424px"
				runat="server" Width="128px" ControlToValidate="txtTotAmt" ErrorMessage="Enter Valid Amount" ValidationExpression="[0-9 .]*"></asp:RegularExpressionValidator>
			<asp:RegularExpressionValidator id="expvldAmtPaid" style="Z-INDEX: 133; LEFT: 552px; POSITION: absolute; TOP: 472px"
				runat="server" Width="128px" ControlToValidate="txtAmtPaid" ErrorMessage="Enter Valid Amount" ValidationExpression="[0-9 .]*"></asp:RegularExpressionValidator>
			<asp:LinkButton id="lnkcmdEndContract" style="Z-INDEX: 134; LEFT: 552px; POSITION: absolute; TOP: 520px"
				runat="server" Visible="False" Width="90px">End Contract</asp:LinkButton>
			<asp:Label id="lblTemp" style="Z-INDEX: 135; LEFT: 352px; POSITION: absolute; TOP: 256px" runat="server"
				ForeColor="Red" Font-Bold="True" Width="232px"></asp:Label>
		</form>
	</body>
</HTML>
