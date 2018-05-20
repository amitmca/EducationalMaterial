<%@ Page Language="vb" AutoEventWireup="false" Codebehind="Logon.aspx.vb" Inherits="FormBasedAuthentication.Logon"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.0 Transitional//EN">
<HTML>
	<HEAD>
		<title>Logon</title>
		<meta content="Microsoft Visual Studio .NET 7.1" name="GENERATOR">
		<meta content="Visual Basic .NET 7.1" name="CODE_LANGUAGE">
		<meta content="JavaScript" name="vs_defaultClientScript">
		<meta content="http://schemas.microsoft.com/intellisense/ie5" name="vs_targetSchema">
	</HEAD>
	<body MS_POSITIONING="GridLayout">
		<form id="Form1" method="post" runat="server">
			<asp:label id="Label1" style="Z-INDEX: 101; LEFT: 32px; POSITION: absolute; TOP: 88px" runat="server"
				Font-Names="Tahoma" Font-Bold="True" Font-Size="X-Small">User name</asp:label><asp:label id="Label2" style="Z-INDEX: 102; LEFT: 32px; POSITION: absolute; TOP: 136px" runat="server"
				Font-Names="Tahoma" Font-Bold="True" Font-Size="X-Small">Password</asp:label><asp:label id="Label3" style="Z-INDEX: 103; LEFT: 296px; POSITION: absolute; TOP: 184px" runat="server"
				Font-Names="Tahoma" Font-Bold="True" Font-Size="X-Small" ForeColor="Red"></asp:label><asp:label id="Label4" style="Z-INDEX: 104; LEFT: 32px; POSITION: absolute; TOP: 184px" runat="server"
				Font-Names="Tahoma" Font-Bold="True" Font-Size="X-Small">Persist Cookie</asp:label><asp:checkbox id="CheckBox1" style="Z-INDEX: 105; LEFT: 152px; POSITION: absolute; TOP: 184px"
				runat="server"></asp:checkbox><asp:textbox id="TextBox1" style="Z-INDEX: 106; LEFT: 152px; POSITION: absolute; TOP: 88px" runat="server"></asp:textbox><asp:textbox id="TextBox2" style="Z-INDEX: 107; LEFT: 152px; POSITION: absolute; TOP: 136px"
				runat="server" TextMode="Password"></asp:textbox><asp:label id="Label5" style="Z-INDEX: 108; LEFT: 152px; POSITION: absolute; TOP: 24px" runat="server"
				Font-Names="Tahoma" Font-Bold="True" Font-Size="Medium">Forms Authentication Example</asp:label><asp:button id="Button1" style="Z-INDEX: 109; LEFT: 40px; POSITION: absolute; TOP: 224px" runat="server"
				Text="Login" Width="80px"></asp:button><asp:requiredfieldvalidator id="RequiredFieldValidator1" style="Z-INDEX: 110; LEFT: 328px; POSITION: absolute; TOP: 88px"
				runat="server" Font-Names="Tahoma" Font-Bold="True" Font-Size="X-Small" ErrorMessage="Username cannot be blank" ControlToValidate="TextBox1"></asp:requiredfieldvalidator><asp:requiredfieldvalidator id="RequiredFieldValidator2" style="Z-INDEX: 111; LEFT: 328px; POSITION: absolute; TOP: 136px"
				runat="server" Font-Names="Tahoma" Font-Bold="True" Font-Size="X-Small" ErrorMessage="Password cannot be blank" ControlToValidate="TextBox2"></asp:requiredfieldvalidator></form>
	</body>
</HTML>
