<%@ Page Language="vb" AutoEventWireup="false" Codebehind="WebForm1.aspx.vb" Inherits="Panels.WebForm1"%>
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
			<asp:Panel id="Panel1" style="Z-INDEX: 101; LEFT: 92px; POSITION: absolute; TOP: 161px" runat="server"
				Width="346px" Height="90px" BorderStyle="Solid" BorderWidth="1px"></asp:Panel>
			<asp:RadioButton id="RadioButton4" style="Z-INDEX: 106; LEFT: 91px; POSITION: absolute; TOP: 110px"
				runat="server" GroupName="ColorGroup" Text="Custom" AutoPostBack="True"></asp:RadioButton>
			<asp:RadioButton id="RadioButton3" style="Z-INDEX: 105; LEFT: 91px; POSITION: absolute; TOP: 82px"
				runat="server" GroupName="ColorGroup" Text="Blue" AutoPostBack="True"></asp:RadioButton>
			<asp:RadioButton id="RadioButton2" style="Z-INDEX: 104; LEFT: 92px; POSITION: absolute; TOP: 52px"
				runat="server" GroupName="ColorGroup" Text="Green" AutoPostBack="True"></asp:RadioButton>
			<asp:RadioButton id="RadioButton1" style="Z-INDEX: 103; LEFT: 93px; POSITION: absolute; TOP: 24px"
				runat="server" GroupName="ColorGroup" Text="Red" AutoPostBack="True"></asp:RadioButton>
			<asp:Panel id="Panel2" style="Z-INDEX: 102; LEFT: 239px; POSITION: absolute; TOP: 29px" runat="server"
				Width="198px" Height="102px" Visible="False">
				<asp:TextBox id="TextBox1" runat="server">255</asp:TextBox>
				<asp:Label id="Label1" runat="server">Red</asp:Label>
				<asp:TextBox id="TextBox2" runat="server">255</asp:TextBox>
				<asp:Label id="Label2" runat="server">Green</asp:Label>
				<asp:TextBox id="TextBox3" runat="server">255</asp:TextBox>
				<asp:Label id="Label3" runat="server">Blue</asp:Label>
				<asp:Button id="Button1" runat="server" Height="24px" Width="154px" Text="Apply"></asp:Button>
			</asp:Panel>
		</form>
	</body>
</HTML>
