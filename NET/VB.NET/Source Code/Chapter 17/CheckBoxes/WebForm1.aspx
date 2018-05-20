<%@ Page Language="vb" AutoEventWireup="false" Codebehind="WebForm1.aspx.vb" Inherits="CheckBoxes.WebForm1"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.0 Transitional//EN">
<HTML>
	<HEAD>
		<title>CheckBoxes example</title>
		<meta name="GENERATOR" content="Microsoft Visual Studio .NET 7.1">
		<meta name="CODE_LANGUAGE" content="Visual Basic .NET 7.1">
		<meta name="vs_defaultClientScript" content="JavaScript">
		<meta name="vs_targetSchema" content="http://schemas.microsoft.com/intellisense/ie5">
	</HEAD>
	<body MS_POSITIONING="GridLayout">
		<form id="Form1" method="post" runat="server">
			<asp:CheckBox id="CheckBox1" style="Z-INDEX: 101; LEFT: 54px; POSITION: absolute; TOP: 152px"
				runat="server" Text="Whole wheat" AutoPostBack="True"></asp:CheckBox>
			<asp:CheckBoxList id="CheckBoxList1" style="Z-INDEX: 105; LEFT: 310px; POSITION: absolute; TOP: 152px"
				runat="server" Width="126px" Height="157px" AutoPostBack="True">
				<asp:ListItem Value="cheese">Cheese</asp:ListItem>
				<asp:ListItem Value="sausage">Sausage</asp:ListItem>
				<asp:ListItem Value="tomato">Tomato</asp:ListItem>
				<asp:ListItem Value="ham">Ham</asp:ListItem>
			</asp:CheckBoxList>
			<asp:TextBox id="TextBox2" style="Z-INDEX: 104; LEFT: 55px; POSITION: absolute; TOP: 288px" runat="server"
				Width="243px" Height="25px"></asp:TextBox>
			<asp:TextBox id="TextBox1" style="Z-INDEX: 103; LEFT: 55px; POSITION: absolute; TOP: 240px" runat="server"
				Width="243px" Height="24px"></asp:TextBox>
			<asp:CheckBox id="CheckBox2" style="Z-INDEX: 102; LEFT: 54px; POSITION: absolute; TOP: 200px"
				runat="server" Text="Sesame seeds" AutoPostBack="True"></asp:CheckBox>
			<asp:Label id="Label1" style="Z-INDEX: 106; LEFT: 168px; POSITION: absolute; TOP: 32px" runat="server"
				Font-Bold="True" Font-Size="Large">Working with Checkboxes</asp:Label>
		</form>
	</body>
</HTML>
