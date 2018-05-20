<%@ Page Language="vb" AutoEventWireup="false" Codebehind="WebForm1.aspx.vb" Inherits="ListBoxes.WebForm1"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.0 Transitional//EN">
<HTML>
	<HEAD>
		<title>List Boxes Example</title>
		<meta content="Microsoft Visual Studio .NET 7.1" name="GENERATOR">
		<meta content="Visual Basic .NET 7.1" name="CODE_LANGUAGE">
		<meta content="JavaScript" name="vs_defaultClientScript">
		<meta content="http://schemas.microsoft.com/intellisense/ie5" name="vs_targetSchema">
	</HEAD>
	<body MS_POSITIONING="GridLayout">
		<form id="Form1" method="post" runat="server">
			<asp:listbox id="ListBox1" style="Z-INDEX: 101; LEFT: 38px; POSITION: absolute; TOP: 104px" runat="server"
				AutoPostBack="True" Height="142px" Width="176px">
				<asp:ListItem Value="Monday">Monday</asp:ListItem>
				<asp:ListItem Value="Tuesday">Tuesday</asp:ListItem>
				<asp:ListItem Value="Wednesday">Wednesday</asp:ListItem>
				<asp:ListItem Value="Thursday">Thursday</asp:ListItem>
				<asp:ListItem Value="Friday">Friday</asp:ListItem>
				<asp:ListItem Value="Saturday">Saturday</asp:ListItem>
				<asp:ListItem Value="Sunday">Sunday</asp:ListItem>
			</asp:listbox><asp:label id="Label2" style="Z-INDEX: 105; LEFT: 251px; POSITION: absolute; TOP: 80px" runat="server">Multiple selection List Box:</asp:label><asp:label id="Label1" style="Z-INDEX: 104; LEFT: 41px; POSITION: absolute; TOP: 72px" runat="server">Single selection ListBox:</asp:label><asp:listbox id="ListBox2" style="Z-INDEX: 103; LEFT: 248px; POSITION: absolute; TOP: 104px"
				runat="server" AutoPostBack="True" Height="134px" Width="188px" SelectionMode="Multiple">
				<asp:ListItem Value="January">January</asp:ListItem>
				<asp:ListItem Value="Febuary">Febuary</asp:ListItem>
				<asp:ListItem Value="March">March</asp:ListItem>
				<asp:ListItem Value="April">April</asp:ListItem>
				<asp:ListItem Value="May">May</asp:ListItem>
				<asp:ListItem Value="June">June</asp:ListItem>
				<asp:ListItem Value="July">July</asp:ListItem>
				<asp:ListItem Value="August">August</asp:ListItem>
				<asp:ListItem Value="September">September</asp:ListItem>
				<asp:ListItem Value="October">October</asp:ListItem>
				<asp:ListItem Value="November">November</asp:ListItem>
				<asp:ListItem Value="December">December</asp:ListItem>
			</asp:listbox><asp:textbox id="TextBox1" style="Z-INDEX: 102; LEFT: 38px; POSITION: absolute; TOP: 248px" runat="server"
				Height="23px" Width="400px"></asp:textbox><asp:label id="Label3" style="Z-INDEX: 106; LEFT: 112px; POSITION: absolute; TOP: 32px" runat="server"
				Height="32px" Width="312px" Font-Size="Larger" Font-Names="Verdana" Font-Bold="True">List Boxes Example</asp:label></form>
	</body>
</HTML>
