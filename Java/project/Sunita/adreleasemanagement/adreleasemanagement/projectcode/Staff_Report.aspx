<%@ Page language="c#" Codebehind="Staff_Report.aspx.cs" AutoEventWireup="false" Inherits="Group_17.WebForm3" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.0 Transitional//EN" >
<HTML>
	<HEAD>
		<title>WebForm3</title>
		<meta content="Microsoft Visual Studio .NET 7.1" name="GENERATOR">
		<meta content="C#" name="CODE_LANGUAGE">
		<meta content="JavaScript" name="vs_defaultClientScript">
		<meta content="http://schemas.microsoft.com/intellisense/ie5" name="vs_targetSchema">
	</HEAD>
	<body bgColor="aliceblue" onload="javascript:history.go(1)" MS_POSITIONING="GridLayout">
		<form id="Form1" method="post" runat="server">
			<asp:label id="lblReport" style="Z-INDEX: 105; LEFT: 360px; POSITION: absolute; TOP: 16px"
				runat="server" Font-Bold="True" Font-Size="Larger" ForeColor="DarkSlateGray" BackColor="#E0E0E0"
				Width="184px">Individual Staff Report</asp:label><asp:datagrid id="dgAdsView" style="Z-INDEX: 104; LEFT: 32px; POSITION: absolute; TOP: 58px" runat="server"
				Font-Size="Smaller" Width="904px" PageSize="5" GridLines="Vertical" CellPadding="3" AllowSorting="True" BorderWidth="2px" BorderStyle="None" BorderColor="MidnightBlue"
				Height="289px">
				<SelectedItemStyle Font-Bold="True" HorizontalAlign="Center" ForeColor="White" VerticalAlign="Middle"
					BackColor="#008A8C"></SelectedItemStyle>
				<EditItemStyle HorizontalAlign="Center" VerticalAlign="Middle"></EditItemStyle>
				<AlternatingItemStyle HorizontalAlign="Center" VerticalAlign="Middle" BackColor="Gainsboro"></AlternatingItemStyle>
				<ItemStyle HorizontalAlign="Center" ForeColor="Black" VerticalAlign="Middle" BackColor="#EEEEEE"></ItemStyle>
				<HeaderStyle Font-Size="Smaller" Font-Names="Verdana" Font-Italic="True" Font-Bold="True" BorderWidth="2px"
					ForeColor="BlanchedAlmond" BorderStyle="Solid" BorderColor="Gray" BackColor="#000084"></HeaderStyle>
				<FooterStyle HorizontalAlign="Right" ForeColor="Black" BackColor="#CCCCCC"></FooterStyle>
				<PagerStyle NextPageText="Next" Font-Size="Smaller" Font-Names="Verdana" Font-Italic="True"
					PrevPageText="Previous" HorizontalAlign="Right" ForeColor="Navy" Position="TopAndBottom"
					BackColor="Silver"></PagerStyle>
			</asp:datagrid>
			<DIV id="grdPrompt" style="Z-INDEX: 118; LEFT: 224px; WIDTH: 368px; POSITION: absolute; TOP: 400px; HEIGHT: 168px"
				runat="server" ms_positioning="GridLayout"><asp:label id="lblPrompt" style="Z-INDEX: 101; LEFT: 8px; POSITION: absolute; TOP: 24px" runat="server"
					Font-Bold="True" Font-Size="Small" ForeColor="MediumBlue" BackColor="Silver" Width="208px"></asp:label><asp:button id="btnOk" style="Z-INDEX: 102; LEFT: 24px; POSITION: absolute; TOP: 136px" runat="server"
					Width="80px" Text="OK"></asp:button><asp:button id="btnCancel" style="Z-INDEX: 103; LEFT: 136px; POSITION: absolute; TOP: 136px"
					runat="server" Width="80px" Text="Cancel"></asp:button></DIV>
			<asp:button id="btnLogout" style="Z-INDEX: 124; LEFT: 536px; POSITION: absolute; TOP: 520px"
				runat="server" ForeColor="Navy" BackColor="LightGray" Width="120px" Text="Logout"></asp:button><asp:button id="btnInsertNew" style="Z-INDEX: 124; LEFT: 304px; POSITION: absolute; TOP: 520px"
				runat="server" ForeColor="Navy" Width="152px" Height="24px" Text="Insert New Ad"></asp:button>
			<DIV id="grdInsertRec" style="Z-INDEX: 119; LEFT: 312px; WIDTH: 560px; POSITION: absolute; TOP: 48px; HEIGHT: 436px"
				align="left" noWrap runat="server" ms_positioning="GridLayout"><asp:label id="lblChannel" style="Z-INDEX: 101; LEFT: 144px; POSITION: absolute; TOP: 48px"
					runat="server" Width="120px" Height="10px">Channel Name</asp:label><asp:label id="lblTimeslot" style="Z-INDEX: 102; LEFT: 144px; POSITION: absolute; TOP: 80px"
					runat="server" Width="120px" Height="10px">Time Slot</asp:label><asp:label id="lblDuration" style="Z-INDEX: 103; LEFT: 144px; POSITION: absolute; TOP: 200px"
					runat="server" Width="120px" Height="10px">Duration</asp:label><asp:label id="lblDiscount" style="Z-INDEX: 104; LEFT: 144px; POSITION: absolute; TOP: 152px"
					runat="server" Width="120px" Height="10px">Discount</asp:label><asp:label id="lblApplicableRate" style="Z-INDEX: 106; LEFT: 144px; POSITION: absolute; TOP: 240px"
					runat="server" Width="120px" Height="10px">Applicable Rate</asp:label><asp:label id="lblRecommendations" style="Z-INDEX: 109; LEFT: 144px; POSITION: absolute; TOP: 320px"
					runat="server" Width="120px" Height="10px">Recommendations</asp:label><asp:dropdownlist id="ddlChannel" style="Z-INDEX: 110; LEFT: 312px; POSITION: absolute; TOP: 48px"
					runat="server" BackColor="#E0E0E0" Width="160px" Height="10px" AutoPostBack="True"></asp:dropdownlist><asp:dropdownlist id="ddlTimeslot" style="Z-INDEX: 111; LEFT: 312px; POSITION: absolute; TOP: 80px"
					runat="server" BackColor="#E0E0E0" Width="160px" Height="10px" AutoPostBack="True"></asp:dropdownlist><asp:dropdownlist id="ddlDuration" style="Z-INDEX: 112; LEFT: 312px; POSITION: absolute; TOP: 200px"
					runat="server" BackColor="#E0E0E0" Width="160px" Height="10px" AutoPostBack="True"></asp:dropdownlist><asp:label id="lblDiscountPer" style="Z-INDEX: 113; LEFT: 312px; POSITION: absolute; TOP: 152px"
					runat="server" ForeColor="Black" BackColor="#E0E0E0" Width="160px" Height="10px"></asp:label><asp:label id="lblAppRate" style="Z-INDEX: 114; LEFT: 304px; POSITION: absolute; TOP: 240px"
					runat="server" BackColor="#E0E0E0" Width="160px" Height="10px"></asp:label><asp:textbox id="txtRecommendations" style="Z-INDEX: 115; LEFT: 304px; POSITION: absolute; TOP: 320px"
					runat="server" BackColor="#E0E0E0" Width="160px" TextMode="MultiLine"></asp:textbox><asp:button id="btnAddRec" style="Z-INDEX: 108; LEFT: 88px; POSITION: absolute; TOP: 376px"
					runat="server" ForeColor="Navy" Width="114px" Text="Add Record"></asp:button><asp:button id="btnReset" style="Z-INDEX: 107; LEFT: 224px; POSITION: absolute; TOP: 376px"
					runat="server" ForeColor="Navy" Width="114px" Text="Reset"></asp:button><asp:label id="lblResponse" style="Z-INDEX: 116; LEFT: 168px; POSITION: absolute; TOP: 416px"
					runat="server" Width="192px"></asp:label><asp:button id="btnView" style="Z-INDEX: 105; LEFT: 368px; POSITION: absolute; TOP: 376px" runat="server"
					ForeColor="Navy" Width="104px" Text="View Records"></asp:button><asp:label id="lblAdMessage" style="Z-INDEX: 117; LEFT: 176px; POSITION: absolute; TOP: 8px"
					runat="server" Font-Size="Medium" ForeColor="Indigo" BackColor="#E0E0E0" Width="232px" Font-Italic="True">Add Advertisement Details</asp:label><asp:label id="lblTotal" style="Z-INDEX: 118; LEFT: 144px; POSITION: absolute; TOP: 280px"
					runat="server" Width="120px" Height="10px">Total Price</asp:label><asp:label id="lblTotalPrice" style="Z-INDEX: 119; LEFT: 304px; POSITION: absolute; TOP: 288px"
					runat="server" BackColor="#E0E0E0" Width="152px" BorderColor="White"></asp:label><asp:label id="lblNumTimes" style="Z-INDEX: 120; LEFT: 144px; POSITION: absolute; TOP: 120px"
					runat="server" Width="120px" Height="10px">Times Ad displayed  *</asp:label><asp:textbox id="txtNumTimes" style="Z-INDEX: 121; LEFT: 312px; POSITION: absolute; TOP: 120px"
					runat="server" BackColor="Gainsboro"></asp:textbox><asp:requiredfieldvalidator id="rfvTimes" style="Z-INDEX: 122; LEFT: 480px; POSITION: absolute; TOP: 128px"
					runat="server" ForeColor="Maroon" Width="72px" ErrorMessage="Required" ControlToValidate="txtNumTimes"></asp:requiredfieldvalidator></DIV>
		</form>
	</body>
</HTML>
