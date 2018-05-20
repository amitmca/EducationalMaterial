<%@ Page Language="vb" AutoEventWireup="false" Codebehind="WebForm1.aspx.vb" Inherits="DropDownlist.WebForm1"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.0 Transitional//EN">
<HTML>
	<HEAD>
		<title>Drop Down List Example</title>
		<meta name="GENERATOR" content="Microsoft Visual Studio .NET 7.1">
		<meta name="CODE_LANGUAGE" content="Visual Basic .NET 7.1">
		<meta name="vs_defaultClientScript" content="JavaScript">
		<meta name="vs_targetSchema" content="http://schemas.microsoft.com/intellisense/ie5">
	</HEAD>
	<body MS_POSITIONING="GridLayout">
		<form id="Form1" method="post" runat="server">
			<asp:DropDownList id="DropDownList1" style="Z-INDEX: 101; LEFT: 168px; POSITION: absolute; TOP: 80px"
				runat="server" Width="144px" Height="22px" AutoPostBack="True">
				<asp:ListItem Value="Monday">Monday</asp:ListItem>
				<asp:ListItem Value="Tuesday">Tuesday</asp:ListItem>
				<asp:ListItem Value="Wednesday">Wednesday</asp:ListItem>
				<asp:ListItem Value="Thursday">Thursday</asp:ListItem>
				<asp:ListItem Value="Friday">Friday</asp:ListItem>
				<asp:ListItem Value="Saturday">Saturday</asp:ListItem>
				<asp:ListItem Value="Sunday">Sunday</asp:ListItem>
			</asp:DropDownList>
			<asp:TextBox id="TextBox1" style="Z-INDEX: 102; LEFT: 160px; POSITION: absolute; TOP: 136px"
				runat="server"></asp:TextBox>
			<asp:Label id="Label1" style="Z-INDEX: 103; LEFT: 128px; POSITION: absolute; TOP: 40px" runat="server"
				Height="24px" Width="248px" Font-Bold="True" Font-Names="Verdana" Font-Size="Larger">Drop Down List Example</asp:Label>
		</form>
	</body>
</HTML>
