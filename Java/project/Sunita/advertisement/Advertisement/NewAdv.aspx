<%@ Page language="c#" Codebehind="NewAdv.aspx.cs" AutoEventWireup="false" Inherits="Advertisement.NewAdv" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.0 Transitional//EN" >
<HTML>
	<HEAD>
		<title>New Advertisement</title>
		<meta name="GENERATOR" Content="Microsoft Visual Studio .NET 7.1">
		<meta name="CODE_LANGUAGE" Content="C#">
		<meta name="vs_defaultClientScript" content="JavaScript">
		<meta name="vs_targetSchema" content="http://schemas.microsoft.com/intellisense/ie5">
	</HEAD>
	<body MS_POSITIONING="GridLayout" bgColor="antiquewhite">
		<form id="Form1" method="post" runat="server">
			<asp:TextBox id="txtAdName" style="Z-INDEX: 101; LEFT: 352px; POSITION: absolute; TOP: 128px"
				runat="server" BackColor="#FFFFC0" BorderStyle="Groove" MaxLength="10"></asp:TextBox>
			<asp:TextBox id="txtAdvName" style="Z-INDEX: 102; LEFT: 352px; POSITION: absolute; TOP: 176px"
				tabIndex="1" runat="server" BackColor="#FFFFC0" BorderStyle="Groove" MaxLength="15"></asp:TextBox>
			<asp:TextBox id="txtAdDuration" style="Z-INDEX: 103; LEFT: 352px; POSITION: absolute; TOP: 320px"
				tabIndex="2" runat="server" BackColor="#FFFFC0" BorderStyle="Groove" MaxLength="2"></asp:TextBox>
			<asp:TextBox id="txtStartDate" style="Z-INDEX: 104; LEFT: 352px; POSITION: absolute; TOP: 224px"
				tabIndex="7" runat="server" ReadOnly="True" BackColor="#FFFFC0" BorderStyle="Groove"></asp:TextBox>
			<asp:TextBox id="txtEndDate" style="Z-INDEX: 105; LEFT: 352px; POSITION: absolute; TOP: 272px"
				tabIndex="8" runat="server" ReadOnly="True" BackColor="#FFFFC0" BorderStyle="Groove"></asp:TextBox>
			<asp:Label id="lblAdName" style="Z-INDEX: 106; LEFT: 224px; POSITION: absolute; TOP: 128px"
				runat="server" Width="73px" Font-Bold="True" tabIndex="99">Ad Name</asp:Label>
			<asp:Label id="lblAdvName" style="Z-INDEX: 107; LEFT: 224px; POSITION: absolute; TOP: 176px"
				runat="server" Font-Bold="True">Advertiser Name</asp:Label>
			<asp:Label id="lblStartDate" style="Z-INDEX: 108; LEFT: 224px; POSITION: absolute; TOP: 224px"
				runat="server" Font-Bold="True">Start Date</asp:Label>
			<asp:Label id="lblEndDate" style="Z-INDEX: 109; LEFT: 224px; POSITION: absolute; TOP: 272px"
				runat="server" Font-Bold="True">End Date</asp:Label>
			<asp:Label id="lblDuration" style="Z-INDEX: 110; LEFT: 224px; POSITION: absolute; TOP: 320px"
				runat="server" Font-Bold="True">Ad Duration</asp:Label>
			<asp:Label id="lblRotations" style="Z-INDEX: 111; LEFT: 224px; POSITION: absolute; TOP: 368px"
				runat="server" Font-Bold="True">Rotations</asp:Label>
			<asp:TextBox id="txtRotations" style="Z-INDEX: 112; LEFT: 352px; POSITION: absolute; TOP: 368px"
				tabIndex="3" runat="server" Width="152px" BackColor="#FFFFC0" BorderStyle="Groove" MaxLength="2"></asp:TextBox>
			<asp:TextBox id="txtTotAmt" style="Z-INDEX: 113; LEFT: 352px; POSITION: absolute; TOP: 416px"
				tabIndex="4" runat="server" BackColor="#FFFFC0" BorderStyle="Groove"></asp:TextBox>
			<asp:TextBox id="txtAmtPaid" style="Z-INDEX: 114; LEFT: 352px; POSITION: absolute; TOP: 464px"
				tabIndex="5" runat="server" BackColor="#FFFFC0" BorderStyle="Groove"></asp:TextBox>
			<asp:Label id="lblTotAmt" style="Z-INDEX: 115; LEFT: 224px; POSITION: absolute; TOP: 416px"
				runat="server" Font-Bold="True">Total Amount</asp:Label>
			<asp:Label id="lblAmtPaid" style="Z-INDEX: 116; LEFT: 224px; POSITION: absolute; TOP: 464px"
				runat="server" Font-Bold="True">Amount Paid</asp:Label>
			<asp:Calendar id="calStartDate" style="Z-INDEX: 117; LEFT: 568px; POSITION: absolute; TOP: 224px"
				runat="server" Width="220px" BorderWidth="1px" BackColor="#FFFFCC" DayNameFormat="FirstLetter"
				ForeColor="#663399" Height="200px" Font-Size="8pt" Font-Names="Verdana" BorderColor="#FFCC66"
				ShowGridLines="True" Visible="False">
				<TodayDayStyle ForeColor="White" BackColor="#FFCC66"></TodayDayStyle>
				<SelectorStyle BackColor="#FFCC66"></SelectorStyle>
				<NextPrevStyle Font-Size="9pt" ForeColor="#FFFFCC"></NextPrevStyle>
				<DayHeaderStyle Height="1px" BackColor="#FFCC66"></DayHeaderStyle>
				<SelectedDayStyle Font-Bold="True" BackColor="#CCCCFF"></SelectedDayStyle>
				<TitleStyle Font-Size="9pt" Font-Bold="True" ForeColor="#FFFFCC" BackColor="#990000"></TitleStyle>
				<OtherMonthDayStyle ForeColor="#CC9966"></OtherMonthDayStyle>
			</asp:Calendar>
			<asp:Calendar id="calEndDate" style="Z-INDEX: 118; LEFT: 568px; POSITION: absolute; TOP: 272px"
				runat="server" Width="220px" BorderWidth="1px" BackColor="#FFFFCC" DayNameFormat="FirstLetter"
				ForeColor="#663399" Height="200px" Font-Size="8pt" Font-Names="Verdana" BorderColor="#FFCC66"
				ShowGridLines="True" Visible="False">
				<TodayDayStyle ForeColor="White" BackColor="#FFCC66"></TodayDayStyle>
				<SelectorStyle BackColor="#FFCC66"></SelectorStyle>
				<NextPrevStyle Font-Size="9pt" ForeColor="#FFFFCC"></NextPrevStyle>
				<DayHeaderStyle Height="1px" BackColor="#FFCC66"></DayHeaderStyle>
				<SelectedDayStyle Font-Bold="True" BackColor="#CCCCFF"></SelectedDayStyle>
				<TitleStyle Font-Size="9pt" Font-Bold="True" ForeColor="#FFFFCC" BackColor="#990000"></TitleStyle>
				<OtherMonthDayStyle ForeColor="#CC9966"></OtherMonthDayStyle>
			</asp:Calendar>
			<asp:Label id="lblNewHeader" style="Z-INDEX: 119; LEFT: 280px; POSITION: absolute; TOP: 32px"
				runat="server" Width="252px" Font-Bold="True" ForeColor="Blue" Height="27px" Font-Size="Larger"
				Font-Underline="True">Booking A New Advertisement</asp:Label>
			<asp:Button id="cmdSubmit" style="Z-INDEX: 120; LEFT: 392px; POSITION: absolute; TOP: 512px"
				tabIndex="6" runat="server" Font-Bold="True" BackColor="#C0C0FF" Text="Submit"></asp:Button>
			<asp:RequiredFieldValidator id="fldvldAdName" style="Z-INDEX: 121; LEFT: 584px; POSITION: absolute; TOP: 128px"
				runat="server" Width="146px" ErrorMessage="Enter Valid Ad Name" ControlToValidate="txtAdName"></asp:RequiredFieldValidator>
			<asp:RequiredFieldValidator id="fldvldAdvName" style="Z-INDEX: 122; LEFT: 584px; POSITION: absolute; TOP: 176px"
				runat="server" Width="154px" ErrorMessage="Enter Valid Name" ControlToValidate="txtAdvName"></asp:RequiredFieldValidator>
			<asp:ImageButton id="cmdStartDate" style="Z-INDEX: 123; LEFT: 536px; POSITION: absolute; TOP: 232px"
				runat="server" ImageUrl="/Advertisement/imageButton.bmp" tabIndex="99"></asp:ImageButton>
			<asp:ImageButton id="cmdEndDate" style="Z-INDEX: 124; LEFT: 536px; POSITION: absolute; TOP: 280px"
				runat="server" ImageUrl="/Advertisement/imageButton2.bmp" tabIndex="99"></asp:ImageButton>
			<asp:Label id="lblDispMsg" style="Z-INDEX: 125; LEFT: 352px; POSITION: absolute; TOP: 80px"
				runat="server" Font-Bold="True" ForeColor="Red" tabIndex="99"></asp:Label>
			<asp:RegularExpressionValidator id="expvldDuration" style="Z-INDEX: 126; LEFT: 584px; POSITION: absolute; TOP: 320px"
				runat="server" Width="126px" ControlToValidate="txtAdDuration" ErrorMessage="Enter Valid Duration" ValidationExpression="[0-9]*"></asp:RegularExpressionValidator>
			<asp:RegularExpressionValidator id="expvldRotations" style="Z-INDEX: 127; LEFT: 584px; POSITION: absolute; TOP: 368px"
				runat="server" Width="142px" ControlToValidate="txtRotations" ErrorMessage="Enter Valid Rotation" ValidationExpression="[0-9]*"></asp:RegularExpressionValidator>
			<asp:RegularExpressionValidator id="expvldTotAmt" style="Z-INDEX: 128; LEFT: 584px; POSITION: absolute; TOP: 416px"
				runat="server" Width="152px" ControlToValidate="txtTotAmt" ErrorMessage="Enter Valid Amount" ValidationExpression="[0-9]*"></asp:RegularExpressionValidator>
			<asp:RegularExpressionValidator id="expvldAmtPaid" style="Z-INDEX: 129; LEFT: 584px; POSITION: absolute; TOP: 464px"
				runat="server" Width="120px" ControlToValidate="txtAmtPaid" ErrorMessage="Enter Valid Amount" ValidationExpression="[0-9]*"></asp:RegularExpressionValidator>
			<asp:Label id="lblTemp" style="Z-INDEX: 130; LEFT: 352px; POSITION: absolute; TOP: 248px" runat="server"
				Font-Bold="True" Width="257px" ForeColor="Red"></asp:Label>
			<asp:RegularExpressionValidator id="expvldAdName" style="Z-INDEX: 131; LEFT: 584px; POSITION: absolute; TOP: 128px"
				runat="server" Width="154px" ControlToValidate="txtAdName" ErrorMessage="Enter Valid  Ad Name" ValidationExpression="[a-z A-Z]*"></asp:RegularExpressionValidator>
			<asp:RegularExpressionValidator id="expvldAdvName" style="Z-INDEX: 132; LEFT: 584px; POSITION: absolute; TOP: 176px"
				runat="server" Width="130px" ControlToValidate="txtAdvName" ErrorMessage="Enter Valid Name" ValidationExpression="[a-z A-Z]*"></asp:RegularExpressionValidator>
		</form>
	</body>
</HTML>
