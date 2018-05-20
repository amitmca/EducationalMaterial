<%@ Page language="c#" Codebehind="endcontract.aspx.cs" AutoEventWireup="false" Inherits="Advertisement.endcontract" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.0 Transitional//EN" >
<HTML>
	<HEAD>
		<title>endcontract</title>
		<meta name="GENERATOR" Content="Microsoft Visual Studio .NET 7.1">
		<meta name="CODE_LANGUAGE" Content="C#">
		<meta name="vs_defaultClientScript" content="JavaScript">
		<meta name="vs_targetSchema" content="http://schemas.microsoft.com/intellisense/ie5">
	</HEAD>
	<body MS_POSITIONING="GridLayout" bgColor="antiquewhite">
		<form id="Form1" method="post" runat="server">
			<asp:Label id="lblRefund" style="Z-INDEX: 101; LEFT: 176px; POSITION: absolute; TOP: 208px"
				runat="server" Width="128px" Font-Bold="True" ForeColor="Black" Visible="False">Refunded Amount</asp:Label>
			<asp:TextBox id="txtRefund" style="Z-INDEX: 102; LEFT: 336px; POSITION: absolute; TOP: 208px"
				runat="server" Visible="False" ForeColor="Red" Font-Bold="True" BackColor="#FFFFC0" ReadOnly="True"
				BorderStyle="Groove"></asp:TextBox>
			<asp:Label id="lblEnd" style="Z-INDEX: 103; LEFT: 144px; POSITION: absolute; TOP: 104px" runat="server"
				Width="296px" Font-Bold="True" ForeColor="Red" Font-Italic="True">Do You Really Want To End The Contract </asp:Label>
			<asp:RadioButton id="chkYes" style="Z-INDEX: 104; LEFT: 464px; POSITION: absolute; TOP: 104px" runat="server"
				Text="Yes" GroupName="end"></asp:RadioButton>
			<asp:RadioButton id="chkNo" style="Z-INDEX: 105; LEFT: 536px; POSITION: absolute; TOP: 104px" runat="server"
				Width="48px" Text="No" GroupName="end" AutoPostBack="True"></asp:RadioButton>
			<asp:Button id="cmdEnd" style="Z-INDEX: 106; LEFT: 360px; POSITION: absolute; TOP: 160px" runat="server"
				Font-Bold="True" Text="End Now" BackColor="#C0C0FF"></asp:Button>
			<asp:Button id="cmdBack" style="Z-INDEX: 107; LEFT: 384px; POSITION: absolute; TOP: 256px" runat="server"
				Visible="False" Font-Bold="True" Width="64px" Text="Back" BackColor="#C0C0FF"></asp:Button>
			<asp:Label id="lblMsg" style="Z-INDEX: 108; LEFT: 224px; POSITION: absolute; TOP: 64px" runat="server"
				ForeColor="Red" Font-Bold="True" Width="288px"></asp:Label>
		</form>
	</body>
</HTML>
