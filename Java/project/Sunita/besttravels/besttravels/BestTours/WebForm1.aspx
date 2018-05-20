<%@ Page language="c#" Codebehind="WebForm1.aspx.cs" AutoEventWireup="false" Inherits="BestTours.WebForm1" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.0 Transitional//EN" >
<HTML>
	<HEAD>
		<title>WebForm1</title>
		<meta content="Microsoft Visual Studio .NET 7.1" name="GENERATOR">
		<meta content="C#" name="CODE_LANGUAGE">
		<meta content="JavaScript" name="vs_defaultClientScript">
		<meta content="http://schemas.microsoft.com/intellisense/ie5" name="vs_targetSchema">
	</HEAD>
	<body bgColor="#ffffff" MS_POSITIONING="GridLayout">
		<form id="Form1" method="post" runat="server">
			<asp:panel id="pnlHeader" style="Z-INDEX: 101; LEFT: -8px; POSITION: absolute; TOP: 56px" runat="server"
				Width="832px" Height="24px" BackColor="SeaShell" HorizontalAlign="Center">
				<asp:Button id="VehicleDetailsButton" runat="server" BackColor="#C0C0FF" Width="151px" BorderStyle="Groove"
					Text="Vehicle Details"></asp:Button>
				<asp:Button id="TouristPlacesButton" runat="server" BackColor="#C0C0FF" Width="158px" BorderStyle="Groove"
					Text="Tourist Places"></asp:Button>
				<asp:Button id="RegisterButton" runat="server" BackColor="#C0C0FF" Width="163px" BorderStyle="Groove"
					Text="Register"></asp:Button>
				<asp:Button id="TourPlansButton" runat="server" BackColor="#C0C0FF" Width="163px" BorderStyle="Groove"
					Text="Tour Plans"></asp:Button>
				<asp:Button id="SearchButton" runat="server" BackColor="#C0C0FF" Width="163px" BorderStyle="Groove"
					Text="Search"></asp:Button>
			</asp:panel><asp:panel id="Pnl7" style="Z-INDEX: 108; LEFT: 456px; POSITION: absolute; TOP: 96px" runat="server"
				Width="230px" Height="160px">
				<asp:ImageButton id="VehicleImgButton" runat="server" Height="160px" Width="228px" BorderStyle="Groove"
					ImageUrl="file:///C:\Inetpub\wwwroot\grp18\pics\vehicles1.jpg" AlternateText="Vehicle Details"></asp:ImageButton>
			</asp:panel><asp:panel id="Pnl8" style="Z-INDEX: 107; LEFT: 176px; POSITION: absolute; TOP: 96px" runat="server"
				Width="230px" Height="160px">
				<asp:ImageButton id="TouristImgButton" runat="server" Height="160px" Width="232px" BorderStyle="Groove"
					ImageUrl="file:///C:\Inetpub\wwwroot\grp18\pics\farm-tourism1.jpg" AlternateText="Tourist Places"></asp:ImageButton>
			</asp:panel><asp:panel id="Pnl5" style="Z-INDEX: 105; LEFT: 0px; POSITION: absolute; TOP: 96px" runat="server"
				Width="176px" Height="434px" BackColor="OldLace" HorizontalAlign="Center" BorderStyle="Groove" Visible="False">
				<asp:LinkButton id="LinkButton9" runat="server" BackColor="#FFFFC0" Height="24px" Width="159px"
					BorderStyle="Groove" ForeColor="Maroon" Font-Names="Comic Sans MS" Font-Size="Smaller">Help</asp:LinkButton>
				<TEXTAREA id="Tc3" style="OVERFLOW: visible; WIDTH: 158px; BORDER-TOP-STYLE: groove; FONT-FAMILY: 'Comic Sans MS'; BORDER-RIGHT-STYLE: groove; BORDER-LEFT-STYLE: groove; HEIGHT: 346px; BACKGROUND-COLOR: infobackground; BORDER-BOTTOM-STYLE: groove"
					name="Textarea4" rows="21" cols="17" runat="server"></TEXTAREA>
				<asp:LinkButton id="LinkButton8" runat="server" BackColor="#FFFFC0" Height="24px" Width="159px"
					BorderStyle="Groove" ForeColor="Maroon" Font-Names="Comic Sans MS" Font-Size="Smaller">About Us</asp:LinkButton>
				<asp:LinkButton id="LinkButton7" runat="server" BackColor="#FFFFC0" Height="24px" Width="159px"
					BorderStyle="Groove" ForeColor="Maroon" Font-Names="Comic Sans MS" Font-Size="Smaller">Terms & Conditions</asp:LinkButton>
			</asp:panel><asp:panel id="Pnl4" style="Z-INDEX: 104; LEFT: 0px; POSITION: absolute; TOP: 96px" runat="server"
				Width="168px" Height="432px" BackColor="OldLace" HorizontalAlign="Center" BorderStyle="Groove" Visible="False">
				<asp:LinkButton id="LinkButton6" runat="server" BackColor="#FFFFC0" Height="24px" Width="159px"
					BorderStyle="Groove" ForeColor="Maroon" Font-Names="Comic Sans MS" Font-Size="Smaller">Terms & Conditions</asp:LinkButton>
				<TEXTAREA id="Tc1" style="OVERFLOW: visible; WIDTH: 157px; DIRECTION: ltr; BORDER-TOP-STYLE: groove; FONT-FAMILY: 'Comic Sans MS'; BORDER-RIGHT-STYLE: groove; BORDER-LEFT-STYLE: groove; HEIGHT: 344px; BACKGROUND-COLOR: infobackground; BORDER-BOTTOM-STYLE: groove"
					rows="21" readOnly cols="17" runat="server"></TEXTAREA>
				<asp:LinkButton id="LinkButton5" runat="server" BackColor="#FFFFC0" Height="24px" Width="159px"
					BorderStyle="Groove" ForeColor="Maroon" Font-Names="Comic Sans MS" Font-Size="Smaller">About Us</asp:LinkButton>
				<asp:LinkButton id="LinkButton4" runat="server" BackColor="#FFFFC0" Height="24px" Width="159px"
					BorderStyle="Groove" ForeColor="Maroon" Font-Names="Comic Sans MS" Font-Size="Smaller">Help</asp:LinkButton>
			</asp:panel><asp:panel id="PnlSearch" style="Z-INDEX: 102; LEFT: 888px; POSITION: absolute; TOP: 600px"
				runat="server" Width="200px" Height="320px" BackColor="OldLace" HorizontalAlign="Center" BorderStyle="Groove"
				Visible="False">
				<asp:Label id="Lbl1" runat="server" BackColor="#FFFFC0" Width="186px">         Search</asp:Label>
				<asp:Label id="Label1" runat="server" Height="72px" Width="180px">Label</asp:Label>
				<asp:Label id="Label2" runat="server" Width="138px">Content To Search :</asp:Label>
				<asp:Label id="Label3" runat="server" Width="186px"></asp:Label>
				<asp:TextBox id="TextBox2" runat="server" Width="127px" BorderStyle="Groove"></asp:TextBox>
				<asp:Label id="Label5" runat="server" Height="80px" Width="186px"></asp:Label>
				<asp:LinkButton id="LinkButton10" runat="server" Width="111px">    Search Now</asp:LinkButton>
			</asp:panel><asp:panel id="Pnl3" style="Z-INDEX: 103; LEFT: 0px; POSITION: absolute; TOP: 96px" runat="server"
				Width="169px" Height="432px" BackColor="OldLace" HorizontalAlign="Center" BorderStyle="Groove">
				<asp:LinkButton id="LinkButton1" runat="server" BackColor="#FFFFC0" Height="24px" Width="159px"
					BorderStyle="Groove" Font-Names="Comic Sans MS" Font-Size="Smaller">About Us</asp:LinkButton>
				<TEXTAREA id="Tc2" style="OVERFLOW: visible; WIDTH: 156px; BORDER-TOP-STYLE: groove; FONT-FAMILY: 'Comic Sans MS'; BORDER-RIGHT-STYLE: groove; BORDER-LEFT-STYLE: groove; HEIGHT: 346px; BACKGROUND-COLOR: infobackground; BORDER-BOTTOM-STYLE: groove"
					rows="21" cols="17" runat="server"></TEXTAREA>
				<asp:LinkButton id="LinkButton2" runat="server" BackColor="#FFFFC0" Height="24px" Width="159px"
					BorderStyle="Groove" Font-Names="Comic Sans MS" Font-Size="Smaller">Help</asp:LinkButton>
				<asp:LinkButton id="LinkButton3" runat="server" BackColor="#FFFFC0" Height="24px" Width="159px"
					BorderStyle="Groove" Font-Names="Comic Sans MS" Font-Size="Smaller">Terms & Conditions</asp:LinkButton>
			</asp:panel><asp:panel id="Pnl6" style="Z-INDEX: 106; LEFT: 176px; POSITION: absolute; TOP: 288px" runat="server"
				Width="236px" Height="238px">
				<asp:Image id="Image1" runat="server" Height="238px" Width="512px" ImageUrl="file:///C:\Inetpub\wwwroot\grp18\pics\hampton.jpg"></asp:Image>
			</asp:panel><asp:label id="Lbl5" style="Z-INDEX: 109; LEFT: 184px; POSITION: absolute; TOP: 264px" runat="server"
				Width="442px" ForeColor="Maroon" Font-Names="Comic Sans MS" Font-Size="Small"></asp:label><asp:button id="Button6" style="Z-INDEX: 112; LEFT: 984px; POSITION: absolute; TOP: 144px" runat="server"
				Text="Button"></asp:button>
			<asp:DropDownList id="DropDownList1" style="Z-INDEX: 113; LEFT: 768px; POSITION: absolute; TOP: 562px"
				runat="server" Height="2px"></asp:DropDownList>
			<asp:DataGrid id="DataGrid1" style="Z-INDEX: 114; LEFT: 176px; POSITION: absolute; TOP: 290px"
				runat="server" HorizontalAlign="Center" BackColor="OldLace" Height="228px" Width="508px" BorderColor="Maroon"
				CellPadding="5" AutoGenerateColumns="False">
				<EditItemStyle HorizontalAlign="Center" VerticalAlign="Middle"></EditItemStyle>
				<FooterStyle HorizontalAlign="Center" VerticalAlign="Middle"></FooterStyle>
				<Columns>
					<asp:BoundColumn DataField="PK_D_DESTINATION_NAME" HeaderText="DestinationName"></asp:BoundColumn>
					<asp:BoundColumn DataField="D_DISTANCE" HeaderText="Distance"></asp:BoundColumn>
				</Columns>
			</asp:DataGrid>
			<asp:DataGrid id="dtgVehicle" style="Z-INDEX: 115; LEFT: 176px; POSITION: absolute; TOP: 288px"
				runat="server" HorizontalAlign="Center" BackColor="OldLace" Height="241px" Width="526px" BorderColor="Maroon"
				AutoGenerateColumns="False">
				<Columns>
					<asp:BoundColumn DataField="PK_VI_VEHICLE_NAME" HeaderText="VehicleName"></asp:BoundColumn>
					<asp:BoundColumn DataField="VI_VEHICLE_TYPE" HeaderText="VehicleType"></asp:BoundColumn>
					<asp:BoundColumn DataField="VI_FUEL_TYPE" HeaderText="FuelType"></asp:BoundColumn>
					<asp:BoundColumn DataField="VI_SEATING_CAPACITY" HeaderText="Seats"></asp:BoundColumn>
					<asp:BoundColumn DataField="VI_RENT_PER_DAY" HeaderText="Rent/day"></asp:BoundColumn>
					<asp:BoundColumn DataField="VI_RATE_PER_KM" HeaderText="Rate/km"></asp:BoundColumn>
				</Columns>
			</asp:DataGrid></form>
	</body>
</HTML>
