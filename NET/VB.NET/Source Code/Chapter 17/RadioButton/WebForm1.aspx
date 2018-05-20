<%@ Page Language="vb" AutoEventWireup="false" Codebehind="WebForm1.aspx.vb" Inherits="RadioButton.WebForm1"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.0 Transitional//EN">
<HTML>
	<HEAD>
		<title>WebForm1</title>
		<meta content="Microsoft Visual Studio .NET 7.1" name="GENERATOR">
		<meta content="Visual Basic .NET 7.1" name="CODE_LANGUAGE">
		<meta content="JavaScript" name="vs_defaultClientScript">
		<meta content="http://schemas.microsoft.com/intellisense/ie5" name="vs_targetSchema">
	</HEAD>
	<body MS_POSITIONING="GridLayout">
		<form id="Form1" method="post" runat="server">
			<asp:radiobuttonlist id="RadioButtonList1" style="Z-INDEX: 101; LEFT: 320px; POSITION: absolute; TOP: 128px"
				runat="server" AutoPostBack="True" Height="172px" Width="116px">
				<asp:ListItem Value="blue" Selected="True">Blue</asp:ListItem>
				<asp:ListItem Value="red">Red</asp:ListItem>
				<asp:ListItem Value="yellow">Yellow</asp:ListItem>
				<asp:ListItem Value="white">White</asp:ListItem>
			</asp:radiobuttonlist><asp:label id="Label2" style="Z-INDEX: 107; LEFT: 336px; POSITION: absolute; TOP: 80px" runat="server">Color:</asp:label><asp:label id="Label1" style="Z-INDEX: 106; LEFT: 144px; POSITION: absolute; TOP: 112px" runat="server">Vehicle:</asp:label><asp:textbox id="TextBox2" style="Z-INDEX: 105; LEFT: 120px; POSITION: absolute; TOP: 272px"
				runat="server"></asp:textbox><asp:radiobutton id="RadioButton2" style="Z-INDEX: 104; LEFT: 144px; POSITION: absolute; TOP: 184px"
				runat="server" AutoPostBack="True" GroupName="Type" Text="Truck"></asp:radiobutton><asp:radiobutton id="RadioButton1" style="Z-INDEX: 103; LEFT: 144px; POSITION: absolute; TOP: 144px"
				runat="server" AutoPostBack="True" GroupName="Type" Text="Car" Checked="True"></asp:radiobutton><asp:textbox id="TextBox1" style="Z-INDEX: 102; LEFT: 120px; POSITION: absolute; TOP: 224px"
				runat="server"></asp:textbox><asp:label id="Label3" style="Z-INDEX: 108; LEFT: 184px; POSITION: absolute; TOP: 16px" runat="server"
				Height="40px" Width="200px" Font-Bold="True" Font-Size="X-Large">Radio Buttons</asp:label></form>
	</body>
</HTML>
