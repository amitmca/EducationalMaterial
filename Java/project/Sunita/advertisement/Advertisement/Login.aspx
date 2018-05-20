<%@ Page language="c#" Codebehind="Login.aspx.cs" AutoEventWireup="false" Inherits="Advertisement.WebForm1" enableViewState="False"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.0 Transitional//EN" >
<HTML>
	<HEAD>
		<title>Login Page</title>
		<meta content="Microsoft Visual Studio .NET 7.1" name="GENERATOR">
		<meta content="C#" name="CODE_LANGUAGE">
		<meta content="JavaScript" name="vs_defaultClientScript">
		<meta content="http://schemas.microsoft.com/intellisense/ie5" name="vs_targetSchema">
		<script>
		if(window.history.forward(1)!=-1)
		window.history.forward(1);
		
		</script>
	</HEAD>
	<body bgColor="white" MS_POSITIONING="GridLayout">
		<form id="Form1" method="post" runat="server">
			<asp:label id="lblTitle" style="Z-INDEX: 101; LEFT: 264px; POSITION: absolute; TOP: 72px" runat="server"
				Font-Size="X-Large" Font-Bold="True" ForeColor="Purple" BorderColor="White" BackColor="White"
				Height="56px" Width="505px">Welcome To CCTV Advertisements</asp:label><asp:requiredfieldvalidator id="fldvldUserId" style="Z-INDEX: 107; LEFT: 728px; POSITION: absolute; TOP: 280px"
				runat="server" Width="98px" ControlToValidate="txtUserId" ErrorMessage="Enter User ID"></asp:requiredfieldvalidator><asp:requiredfieldvalidator id="fldvldPassword" style="Z-INDEX: 108; LEFT: 728px; POSITION: absolute; TOP: 328px"
				runat="server" Width="98px" ControlToValidate="txtPassword" ErrorMessage="Enter Password"></asp:requiredfieldvalidator><asp:label id="lblError" style="Z-INDEX: 109; LEFT: 456px; POSITION: absolute; TOP: 200px"
				runat="server" ForeColor="Red" Width="182px" Visible="False">Not A Valid User / Password</asp:label><asp:panel id="Panel1" style="Z-INDEX: 110; LEFT: 312px; POSITION: absolute; TOP: 240px" runat="server"
				BackColor="#E0E0E0" Height="208px" Width="404px" BorderStyle="Ridge" HorizontalAlign="Justify">
				<P>&nbsp;</P>
				<P>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
					<asp:Label id="lblUserId" runat="server" Font-Bold="True" Width="80px">User ID</asp:Label>&nbsp;&nbsp;&nbsp;
					<asp:TextBox id="txtUserId" tabIndex="1" runat="server" Font-Bold="True" BackColor="#FFFFC0"
						BorderStyle="Groove"></asp:TextBox></P>
				<P>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
					<asp:Label id="lblPassword" runat="server" Font-Bold="True" Width="74px">Password</asp:Label>&nbsp;&nbsp;&nbsp;&nbsp;
					<asp:TextBox id="txtPassword" tabIndex="2" runat="server" Font-Bold="True" BackColor="#FFFFC0"
						BorderStyle="Groove" TextMode="Password"></asp:TextBox></P>
				<P>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
					<asp:Button id="cmdLogin" tabIndex="3" runat="server" Font-Bold="True" ForeColor="Black" BackColor="#C0C0FF"
						Width="66px" Text="Login"></asp:Button></P>
			</asp:panel></form>
	</body>
</HTML>
