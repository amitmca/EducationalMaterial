<%@ Page language="c#" Codebehind="Login_Page.aspx.cs" AutoEventWireup="false" Inherits="Group_17.WebForm1" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.0 Transitional//EN" >
<HTML>
	<HEAD>
		<title>Mega Mart Ad Agency</title>
	</HEAD>
	<BODY bgColor="aliceblue" onload="javascript:history.go(1)">
		<P align="center">
			<asp:Label id="lblHeader" runat="server" ForeColor="Indigo" BackColor="AliceBlue" Width="920px"
				Font-Size="X-Large" Height="64px" BorderStyle="Double" BorderColor="AliceBlue" Font-Bold="True"
				Font-Italic="True"> MEGA MART VIDEO-ADS MANAGEMENT</asp:Label>
			&nbsp;
			<meta content="Microsoft Visual Studio .NET 7.1" name="GENERATOR">
			<meta content="C#" name="CODE_LANGUAGE">
			<meta content="JavaScript" name="vs_defaultClientScript">
			<meta content="http://schemas.microsoft.com/intellisense/ie5" name="vs_targetSchema">
		</P>
		<form id="Form1" method="post" runat="server">
			<DIV style="Z-INDEX: 101; BORDER-LEFT-COLOR: dimgray; LEFT: 430px; BORDER-BOTTOM-COLOR: dimgray; WIDTH: 512px; BORDER-TOP-COLOR: dimgray; POSITION: absolute; TOP: 128px; HEIGHT: 320px; BACKGROUND-COLOR: lavender; BORDER-RIGHT-COLOR: dimgray"
				align="right" ms_positioning="GridLayout" id="grdLogin" title="Login Form" runat="server"><asp:label id="lblUsername" style="Z-INDEX: 101; LEFT: 40px; POSITION: absolute; TOP: 64px"
					runat="server" ForeColor="Navy">Username   *</asp:label><asp:label id="lblPass" style="Z-INDEX: 102; LEFT: 40px; POSITION: absolute; TOP: 120px" runat="server"
					ForeColor="Navy">Password   *</asp:label><asp:button id="btnLogin" style="Z-INDEX: 103; LEFT: 40px; POSITION: absolute; TOP: 176px" runat="server"
					ForeColor="Navy" Width="72px" Text="Login" BackColor="Silver"></asp:button><asp:button id="btnReset" style="Z-INDEX: 106; LEFT: 160px; POSITION: absolute; TOP: 176px"
					runat="server" ForeColor="Navy" Width="73px" Text="Reset" CausesValidation="False" BackColor="Silver"></asp:button><asp:label id="lblGridHead" style="Z-INDEX: 105; LEFT: 160px; POSITION: absolute; TOP: 8px"
					runat="server" ForeColor="Indigo" Width="100px" Font-Size="Medium" Font-Italic="True" Font-Bold="True">Login Form</asp:label><asp:requiredfieldvalidator id="rfvUsername" style="Z-INDEX: 107; LEFT: 320px; POSITION: absolute; TOP: 64px"
					runat="server" ForeColor="Sienna" Width="168px" ErrorMessage="Please Enter the UserName" ControlToValidate="txtUser"></asp:requiredfieldvalidator><asp:requiredfieldvalidator id="rfvPassword" style="Z-INDEX: 108; LEFT: 320px; POSITION: absolute; TOP: 120px"
					runat="server" ForeColor="SaddleBrown" Width="168px" ErrorMessage="Please Enter the Password" ControlToValidate="txtPass"></asp:requiredfieldvalidator>
				<asp:LinkButton id="lnkbtnForgotPass" style="Z-INDEX: 109; LEFT: 16px; POSITION: absolute; TOP: 224px"
					runat="server" ForeColor="Navy" Width="140px" CausesValidation="False">Forgot Password ?</asp:LinkButton>
				<asp:Label id="lblInvalidUser" style="Z-INDEX: 110; LEFT: 192px; POSITION: absolute; TOP: 224px"
					runat="server" Width="264px"></asp:Label>
				<asp:Label id="lblMessage" style="Z-INDEX: 111; LEFT: 256px; POSITION: absolute; TOP: 176px"
					runat="server" ForeColor="Navy" Width="176px">*   Fields are mandatory</asp:Label>
				<asp:TextBox id="txtPass" style="Z-INDEX: 105; LEFT: 160px; POSITION: absolute; TOP: 120px" runat="server"
					BackColor="#E0E0E0" TextMode="Password"></asp:TextBox>
				<asp:TextBox id="txtUser" style="Z-INDEX: 104; LEFT: 160px; POSITION: absolute; TOP: 64px" runat="server"
					BackColor="#E0E0E0"></asp:TextBox></DIV>
		</form>
		<DIV id="grdImage" style="WIDTH: 416px; POSITION: relative; HEIGHT: 400px" align="center"
			noWrap runat="server" ms_positioning="GridLayout">
			<asp:Image id="imgSunrise" style="Z-INDEX: 101; LEFT: 8px; POSITION: absolute; TOP: 8px" runat="server"
				Width="400px" Height="175px" ImageUrl="file:///C:\Inetpub\wwwroot\Group_17\Gaint_sparkler.jpg"
				ImageAlign="Middle"></asp:Image>
			<asp:Image id="imgSunset" style="Z-INDEX: 102; LEFT: 8px; POSITION: absolute; TOP: 216px" runat="server"
				Width="400px" Height="175px" BorderStyle="Dotted" BorderColor="DarkGoldenrod" ImageUrl="file:///C:\Inetpub\wwwroot\Group_17\Sunset_at_Murudeshwar.jpg"
				ImageAlign="Middle"></asp:Image>
			<asp:Label id="lblAdMessage" style="Z-INDEX: 103; LEFT: 48px; POSITION: absolute; TOP: 184px"
				runat="server" ForeColor="Purple" Width="354px" Font-Size="Small" Font-Bold="True" Font-Italic="True">We Serve You from Dawn to Dusk</asp:Label></DIV>
	</BODY>
</HTML>
