<%@ Page language="c#" Codebehind="acceptance.aspx.cs" AutoEventWireup="false" Inherits="Advertisement.acceptance" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.0 Transitional//EN" >
<HTML>
  <HEAD>
		<title>Acceptance Page</title>
		<meta name="GENERATOR" Content="Microsoft Visual Studio .NET 7.1">
		<meta name="CODE_LANGUAGE" Content="C#">
		<meta name="vs_defaultClientScript" content="JavaScript">
		<meta name="vs_targetSchema" content="http://schemas.microsoft.com/intellisense/ie5">
  </HEAD>
	<body MS_POSITIONING="GridLayout" bgColor="antiquewhite">
		<form id="Form1" method="post" runat="server">
			<asp:DataGrid id="dgAccept" style="Z-INDEX: 101; LEFT: 56px; POSITION: absolute; TOP: 176px"
				runat="server" AutoGenerateColumns="False" BorderColor="White" BorderStyle="Ridge" CellSpacing="1"
				BorderWidth="2px" BackColor="White" CellPadding="3" GridLines="None" Width="608px">
<SelectedItemStyle Font-Bold="True" ForeColor="White" BackColor="#9471DE">
</SelectedItemStyle>

<ItemStyle ForeColor="Black" BackColor="#DEDFDE">
</ItemStyle>

<HeaderStyle Font-Bold="True" ForeColor="#E7E7FF" BackColor="#4A3C8C">
</HeaderStyle>

<FooterStyle ForeColor="Black" BackColor="#C6C3C6">
</FooterStyle>

<Columns>
<asp:TemplateColumn HeaderText="Accept">
<ItemTemplate>
							<P>&nbsp;
								<asp:CheckBox id="chkAccept" runat="server"></asp:CheckBox></P>
						
</ItemTemplate>
</asp:TemplateColumn>
<asp:BoundColumn DataField="Ad_Name" HeaderText="Ad Name"></asp:BoundColumn>
<asp:BoundColumn DataField="Ad_Id" HeaderText="Ad ID"></asp:BoundColumn>
<asp:BoundColumn DataField="Start_Date" HeaderText="Start Date"></asp:BoundColumn>
<asp:BoundColumn DataField="End_Date" HeaderText="End Date"></asp:BoundColumn>
<asp:BoundColumn DataField="No_Rotations" HeaderText="No Rotations"></asp:BoundColumn>
<asp:BoundColumn DataField="Tot_Amount" HeaderText="Total Amount"></asp:BoundColumn>
</Columns>

<PagerStyle HorizontalAlign="Right" ForeColor="Black" BackColor="#C6C3C6">
</PagerStyle>
			</asp:DataGrid>
			<asp:Label id="Label1" style="Z-INDEX: 102; LEFT: 216px; POSITION: absolute; TOP: 72px" runat="server"
				ForeColor="#0000C0" Font-Bold="True" Font-Size="Larger" Font-Underline="True">Acceptence Of The Advertisements</asp:Label>
			<asp:Button id="cmdAccept" style="Z-INDEX: 103; LEFT: 336px; POSITION: absolute; TOP: 144px"
				runat="server" Text="Accept" BackColor="#C0C0FF" Font-Bold="True"></asp:Button>
		</form>
	</body>
</HTML>
