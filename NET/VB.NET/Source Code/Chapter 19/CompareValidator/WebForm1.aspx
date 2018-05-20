<%@ Page Language="vb" AutoEventWireup="false" Codebehind="WebForm1.aspx.vb" Inherits="CompareValidator.WebForm1"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.0 Transitional//EN">
<HTML>
	<HEAD>
		<title>WebForm1</title>
		<meta name="GENERATOR" content="Microsoft Visual Studio .NET 7.1">
		<meta name="CODE_LANGUAGE" content="Visual Basic .NET 7.1">
		<meta name="vs_defaultClientScript" content="JavaScript">
		<meta name="vs_targetSchema" content="http://schemas.microsoft.com/intellisense/ie5">
	</HEAD>
	<body MS_POSITIONING="GridLayout">
		<form id="Form1" method="post" runat="server">
			<asp:Label id="Label1" style="Z-INDEX: 106; LEFT: 160px; POSITION: absolute; TOP: 32px" runat="server"
				Font-Names="Verdana" Font-Bold="True">Compare Field Validator Example</asp:Label>
			<asp:TextBox id="TextBox1" style="Z-INDEX: 101; LEFT: 184px; POSITION: absolute; TOP: 136px"
				runat="server"></asp:TextBox>
			<asp:TextBox id="TextBox2" style="Z-INDEX: 102; LEFT: 176px; POSITION: absolute; TOP: 192px"
				runat="server"></asp:TextBox>
			<asp:Label id="Label3" style="Z-INDEX: 105; LEFT: 48px; POSITION: absolute; TOP: 192px" runat="server"
				Font-Names="Verdana" Font-Bold="True">Net Salary :</asp:Label>
			<asp:Label id="Label2" style="Z-INDEX: 104; LEFT: 48px; POSITION: absolute; TOP: 136px" runat="server"
				Font-Names="Verdana" Font-Bold="True">Gross Salary :</asp:Label>
			<asp:Button id="Button1" style="Z-INDEX: 103; LEFT: 152px; POSITION: absolute; TOP: 248px" runat="server"
				Text="Submit"></asp:Button>
			<asp:CompareValidator id="CompareValidator1" style="Z-INDEX: 107; LEFT: 360px; POSITION: absolute; TOP: 192px"
				runat="server" ErrorMessage="Net Salary must be less than gross salary" ControlToCompare="TextBox1"
				ControlToValidate="TextBox2" Type="Integer" Operator="LessThan"></asp:CompareValidator>
		</form>
	</body>
</HTML>
