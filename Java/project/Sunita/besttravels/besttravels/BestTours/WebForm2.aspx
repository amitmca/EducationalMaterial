<%@ Page language="c#" Codebehind="WebForm2.aspx.cs" AutoEventWireup="false" Inherits="BestTours.WebForm2" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.0 Transitional//EN" >
<HTML>
	<HEAD>
		<title>WebForm2</title>
		<meta content="Microsoft Visual Studio .NET 7.1" name="GENERATOR">
		<meta content="C#" name="CODE_LANGUAGE">
		<meta content="JavaScript" name="vs_defaultClientScript">
		<meta content="http://schemas.microsoft.com/intellisense/ie5" name="vs_targetSchema">
	</HEAD>
	<body bgColor="#ffffff" MS_POSITIONING="GridLayout">
		<form id="Form1" method="post" runat="server">
			<asp:label id="Label1" style="Z-INDEX: 101; LEFT: 344px; POSITION: absolute; TOP: 40px" runat="server"
				Width="214px" Font-Names="Comic Sans MS" ForeColor="Blue" Font-Size="Large"> Registration  Form</asp:label><asp:button id="BrowseCalendar2" style="Z-INDEX: 126; LEFT: 576px; POSITION: absolute; TOP: 344px"
				runat="server" Width="44px" Font-Names="Comic Sans MS" Font-Size="9pt" BorderStyle="Groove" Text="Cal" BackColor="DarkKhaki" CausesValidation="False"></asp:button><asp:textbox id="ReturnDate" style="Z-INDEX: 125; LEFT: 464px; POSITION: absolute; TOP: 344px"
				runat="server" Width="114px" ReadOnly="True"></asp:textbox><asp:button id="Button4" style="Z-INDEX: 119; LEFT: 456px; POSITION: absolute; TOP: 560px" runat="server"
				Width="88px" BorderStyle="Groove" Text="Skip" CausesValidation="False"></asp:button><asp:button id="Save" style="Z-INDEX: 118; LEFT: 248px; POSITION: absolute; TOP: 560px" runat="server"
				Width="88px" BorderStyle="Groove" Text="Save"></asp:button><asp:textbox id="ReprName" style="Z-INDEX: 113; LEFT: 464px; POSITION: absolute; TOP: 176px"
				runat="server"></asp:textbox>
			<DIV style="DISPLAY: inline; Z-INDEX: 104; LEFT: 240px; WIDTH: 160px; POSITION: absolute; TOP: 264px; HEIGHT: 24px"
				align="center" ms_positioning="FlowLayout">Tourist Destination :</DIV>
			<DIV style="DISPLAY: inline; Z-INDEX: 103; LEFT: 240px; WIDTH: 160px; POSITION: absolute; TOP: 224px; HEIGHT: 24px"
				align="center" ms_positioning="FlowLayout">Telephone Number :</DIV>
			<DIV id="DIV1" style="BORDER-RIGHT: 1px; BORDER-TOP: 1px; DISPLAY: inline; Z-INDEX: 102; LEFT: 240px; BORDER-LEFT: 1px; WIDTH: 160px; BORDER-BOTTOM: 1px; POSITION: absolute; TOP: 128px; HEIGHT: 24px"
				align="center" ms_positioning="FlowLayout">Company Name&nbsp;:</DIV>
			<DIV style="DISPLAY: inline; Z-INDEX: 105; LEFT: 576px; WIDTH: 161px; POSITION: absolute; TOP: 560px; HEIGHT: 24px"
				align="center" ms_positioning="FlowLayout">Total Amount</DIV>
			<DIV style="DISPLAY: inline; Z-INDEX: 106; LEFT: 240px; WIDTH: 160px; POSITION: absolute; TOP: 464px; HEIGHT: 24px"
				align="center" ms_positioning="FlowLayout">Available Vehicles</DIV>
			<DIV style="DISPLAY: inline; Z-INDEX: 107; LEFT: 240px; WIDTH: 160px; POSITION: absolute; TOP: 384px; HEIGHT: 24px"
				align="center" ms_positioning="FlowLayout">Vehicle Type :</DIV>
			<DIV style="DISPLAY: inline; Z-INDEX: 108; LEFT: 240px; WIDTH: 160px; POSITION: absolute; TOP: 424px; HEIGHT: 24px"
				align="center" ms_positioning="FlowLayout">Number of People :</DIV>
			<DIV style="DISPLAY: inline; Z-INDEX: 109; LEFT: 240px; WIDTH: 160px; POSITION: absolute; TOP: 344px; HEIGHT: 24px"
				align="center" ms_positioning="FlowLayout">Retrun Date :</DIV>
			<DIV style="DISPLAY: inline; Z-INDEX: 110; LEFT: 240px; WIDTH: 160px; POSITION: absolute; TOP: 304px; HEIGHT: 24px"
				align="center" ms_positioning="FlowLayout">Start Date :
			</DIV>
			<DIV id="Div2" style="BORDER-RIGHT: 1px; BORDER-TOP: 1px; DISPLAY: inline; Z-INDEX: 111; LEFT: 240px; BORDER-LEFT: 1px; WIDTH: 160px; BORDER-BOTTOM: 1px; POSITION: absolute; TOP: 168px; HEIGHT: 24px"
				align="center" ms_positioning="FlowLayout">Company RepresentativeName :&nbsp;</DIV>
			<asp:textbox id="CompanyName" style="Z-INDEX: 112; LEFT: 464px; POSITION: absolute; TOP: 128px"
				runat="server"></asp:textbox><asp:dropdownlist id="DDLDestination" style="Z-INDEX: 114; LEFT: 464px; POSITION: absolute; TOP: 264px"
				runat="server" Width="153px">
				<asp:ListItem Value="Select Destination">Select Destination</asp:ListItem>
			</asp:dropdownlist><asp:textbox id="Telephone" style="Z-INDEX: 115; LEFT: 464px; POSITION: absolute; TOP: 224px"
				runat="server"></asp:textbox><asp:dropdownlist id="DDLVehicleType" style="Z-INDEX: 116; LEFT: 464px; POSITION: absolute; TOP: 384px"
				runat="server" Width="152px" AutoPostBack="True">
				<asp:ListItem Value="Select Type">Select Type</asp:ListItem>
				<asp:ListItem Value="VAN">VAN</asp:ListItem>
				<asp:ListItem Value="CAR">CAR</asp:ListItem>
			</asp:dropdownlist><asp:textbox id="Total" style="Z-INDEX: 117; LEFT: 752px; POSITION: absolute; TOP: 560px" runat="server"
				Width="67px" ReadOnly="True"></asp:textbox><asp:requiredfieldvalidator id="RequiredFieldValidator1" style="Z-INDEX: 120; LEFT: 624px; POSITION: absolute; TOP: 120px"
				runat="server" Width="186px" ControlToValidate="CompanyName" Height="27px">* Company Name Mandatory</asp:requiredfieldvalidator><asp:requiredfieldvalidator id="RequiredFieldValidator2" style="Z-INDEX: 121; LEFT: 624px; POSITION: absolute; TOP: 168px"
				runat="server" Width="234px" ControlToValidate="ReprName">* Representative Name Mandatory</asp:requiredfieldvalidator><asp:calendar id="Calendar1" style="Z-INDEX: 122; LEFT: 672px; POSITION: absolute; TOP: 304px"
				runat="server" Width="168px" BorderStyle="Groove" BackColor="OldLace" Height="124px" SelectedDate="2006-11-21" Visible="False" BorderColor="#400000"></asp:calendar><asp:textbox id="StartDate" style="Z-INDEX: 123; LEFT: 464px; POSITION: absolute; TOP: 304px"
				runat="server" Width="114px" ReadOnly="True"></asp:textbox><asp:button id="BrowseCalendar1" style="Z-INDEX: 124; LEFT: 576px; POSITION: absolute; TOP: 304px"
				runat="server" Width="44px" Font-Names="Comic Sans MS" Font-Size="9pt" BorderStyle="Groove" Text="Cal" BackColor="DarkKhaki" CausesValidation="False"></asp:button><asp:calendar id="Calendar2" style="Z-INDEX: 127; LEFT: 672px; POSITION: absolute; TOP: 348px"
				runat="server" Width="177px" BorderStyle="Groove" BackColor="OldLace" Height="180px" Visible="False" BorderColor="Brown"></asp:calendar><asp:label id="ErrorDate" style="Z-INDEX: 128; LEFT: 624px; POSITION: absolute; TOP: 296px"
				runat="server" Width="210px" ForeColor="Red" Visible="False">Start Date Can not be before Tommorrow</asp:label><asp:label id="ErrorReturnDate" style="Z-INDEX: 129; LEFT: 624px; POSITION: absolute; TOP: 344px"
				runat="server" Width="210px" ForeColor="Red" Height="24px" Visible="False">Return Date Can be BEFORE Start Date </asp:label><asp:regularexpressionvalidator id="RegularExpressionValidator1" style="Z-INDEX: 130; LEFT: 632px; POSITION: absolute; TOP: 136px"
				runat="server" Width="162px" ControlToValidate="CompanyName" Height="35px" ErrorMessage="Only Characters allowed" ValidationExpression="([A-Z]|[a-z])*" Display="Dynamic"></asp:regularexpressionvalidator><asp:regularexpressionvalidator id="RegularExpressionValidator2" style="Z-INDEX: 131; LEFT: 632px; POSITION: absolute; TOP: 184px"
				runat="server" Width="154px" ControlToValidate="ReprName" ErrorMessage="Only characters allowed" ValidationExpression="([a-z]|[A-Z])*" Display="Dynamic"></asp:regularexpressionvalidator><asp:regularexpressionvalidator id="RegularExpressionValidator3" style="Z-INDEX: 132; LEFT: 624px; POSITION: absolute; TOP: 224px"
				runat="server" Width="234px" ControlToValidate="Telephone" ErrorMessage="Invalid Phone Number(11 digit format)" ValidationExpression="\d{11}" Display="Dynamic"></asp:regularexpressionvalidator><asp:comparevalidator id="CompareValidator1" style="Z-INDEX: 133; LEFT: 620px; POSITION: absolute; TOP: 384px"
				runat="server" Width="213px" ControlToValidate="DDLVehicleType" Height="32px" ErrorMessage="Please Select Vehicle Type" ValueToCompare="Select Type" Operator="NotEqual"></asp:comparevalidator><asp:comparevalidator id="CompareValidator4" style="Z-INDEX: 135; LEFT: 632px; POSITION: absolute; TOP: 264px"
				runat="server" ControlToValidate="DDLDestination" ErrorMessage="Please specify Destination" ValueToCompare="Select Destination" Operator="NotEqual"></asp:comparevalidator><asp:requiredfieldvalidator id="RequiredFieldValidator3" style="Z-INDEX: 136; LEFT: 624px; POSITION: absolute; TOP: 312px"
				runat="server" Width="188px" ControlToValidate="StartDate" Height="18px" ErrorMessage="Please Select Start Date"></asp:requiredfieldvalidator><asp:button id="AddMore" style="Z-INDEX: 137; LEFT: 352px; POSITION: absolute; TOP: 560px" runat="server"
				BorderStyle="Groove" Text="Add More" CausesValidation="False" Enabled="False"></asp:button><asp:listbox id="ListVehicles" style="Z-INDEX: 138; LEFT: 464px; POSITION: absolute; TOP: 464px"
				runat="server" Width="200px" Height="74px" SelectionMode="Multiple">
				<asp:ListItem Value="Select Vehicle">Select Vehicle</asp:ListItem>
			</asp:listbox><asp:textbox id="NumberOfPeople" style="Z-INDEX: 139; LEFT: 464px; POSITION: absolute; TOP: 424px"
				runat="server"></asp:textbox><asp:regularexpressionvalidator id="RegularExpressionValidator4" style="Z-INDEX: 140; LEFT: 622px; POSITION: absolute; TOP: 424px"
				runat="server" Width="174px" ControlToValidate="NumberOfPeople" Height="26px" ErrorMessage="Only Numbers Allowed" ValidationExpression="(\d)*"></asp:regularexpressionvalidator><asp:requiredfieldvalidator id="RequiredFieldValidator4" style="Z-INDEX: 141; LEFT: 632px; POSITION: absolute; TOP: 424px"
				runat="server" Width="224px" ControlToValidate="NumberOfPeople" Height="16px">* Please Specify Number Of People</asp:requiredfieldvalidator><asp:label id="LblErrorCnt" style="Z-INDEX: 142; LEFT: 624px; POSITION: absolute; TOP: 432px"
				runat="server" Width="201px" ForeColor="Red" Height="40px" Visible="False">Number Of people More than Seating Capacity</asp:label><asp:label id="NoVehicleErr" style="Z-INDEX: 143; LEFT: 48px; POSITION: absolute; TOP: 264px"
				runat="server" Width="153px" ForeColor="Red" Visible="False" Height="80px">Label</asp:label></form>
	</body>
</HTML>
