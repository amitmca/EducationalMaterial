<%@ Page language="c#" Codebehind="WebForm3.aspx.cs" AutoEventWireup="false" Inherits="BestTours.WebForm3" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.0 Transitional//EN" >
<HTML>
	<HEAD>
		<title>WebForm3</title>
		<meta content="Microsoft Visual Studio .NET 7.1" name="GENERATOR">
		<meta content="C#" name="CODE_LANGUAGE">
		<meta content="JavaScript" name="vs_defaultClientScript">
		<meta content="http://schemas.microsoft.com/intellisense/ie5" name="vs_targetSchema">
	</HEAD>
	<body bgColor="#ffffff" MS_POSITIONING="GridLayout">
		<form id="Form1" method="post" runat="server">
			<asp:datagrid id="RecordGrid" style="Z-INDEX: 101; LEFT: 160px; POSITION: absolute; TOP: 56px"
				runat="server" BackColor="Info" Width="553px" Height="117px" AutoGenerateColumns="False" BorderColor="Maroon"
				PageSize="5">
				<AlternatingItemStyle HorizontalAlign="Justify" BorderStyle="Groove" BorderColor="WhiteSmoke"></AlternatingItemStyle>
				<Columns>
					<asp:BoundColumn DataField="P_COMPANY_REPRESENTATIVE_NAME" HeaderText="Representative"></asp:BoundColumn>
					<asp:BoundColumn DataField="P_COMPANY_NAME" HeaderText="Company"></asp:BoundColumn>
					<asp:BoundColumn DataField="P_TELEPHONE" HeaderText="Tel"></asp:BoundColumn>
					<asp:BoundColumn DataField="P_DESTINATION_NAME" HeaderText="Destination"></asp:BoundColumn>
					<asp:BoundColumn DataField="P_START_DATE" HeaderText="StartDate"></asp:BoundColumn>
					<asp:BoundColumn DataField="P_RETURN_DATE" HeaderText="ReturnDate"></asp:BoundColumn>
				</Columns>
			</asp:datagrid><asp:label id="Message" style="Z-INDEX: 102; LEFT: 208px; POSITION: absolute; TOP: 592px" runat="server"
				Width="416px" Height="28px"></asp:label>
			<asp:DataGrid id="VehiclesGrid" style="Z-INDEX: 103; LEFT: 176px; POSITION: absolute; TOP: 264px"
				runat="server" BorderColor="Maroon" AutoGenerateColumns="False" Height="162px" BorderStyle="Groove"
				Width="496px" BackColor="Info">
				<Columns>
					<asp:BoundColumn DataField="P_SELECTED_VEHICLE" HeaderText="Vehicles Selected            "></asp:BoundColumn>
					<asp:BoundColumn DataField="P_VEHICLE_TYPE" HeaderText="VehicleType"></asp:BoundColumn>
					<asp:BoundColumn DataField="P_NUMBER_OF_PEOPLE" HeaderText="NumOfPeople"></asp:BoundColumn>
					<asp:BoundColumn DataField="P_TOTAL_AMOUNT" HeaderText="Total Amount"></asp:BoundColumn>
					<asp:EditCommandColumn ButtonType="PushButton" UpdateText="Update" HeaderText="Select One" CancelText="Cancel"
						EditText="Select"></asp:EditCommandColumn>
				</Columns>
			</asp:DataGrid>
			<asp:Label id="Label1" style="Z-INDEX: 104; LEFT: 80px; POSITION: absolute; TOP: 72px" runat="server"
				Width="408px" Visible="False" Font-Names="Comic Sans MS" Font-Size="11pt">No Vehicles Booked !!!         Please fill the Registration form....</asp:Label>
			<asp:LinkButton id="LinkButton1" style="Z-INDEX: 105; LEFT: 624px; POSITION: absolute; TOP: 488px"
				runat="server">Go To HomePage</asp:LinkButton></form>
	</body>
</HTML>
