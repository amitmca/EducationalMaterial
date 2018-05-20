<%@ Page Language="vb" AutoEventWireup="false" Codebehind="WebForm1.aspx.vb" Inherits="WebDataNavigation.WebForm1" SmartNavigation="true"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.0 Transitional//EN">
<HTML>
	<HEAD>
		<title>Web Data Navigation Example</title>
		<meta name="GENERATOR" content="Microsoft Visual Studio .NET 7.1">
		<meta name="CODE_LANGUAGE" content="Visual Basic .NET 7.1">
		<meta name="vs_defaultClientScript" content="JavaScript">
		<meta name="vs_targetSchema" content="http://schemas.microsoft.com/intellisense/ie5">
	</HEAD>
	<body MS_POSITIONING="GridLayout">
		<form id="Form1" method="post" runat="server">
			<asp:TextBox id=TextBox1 style="Z-INDEX: 101; LEFT: 264px; POSITION: absolute; TOP: 144px" runat="server" Text='<%# DataBinder.Eval(DataView1, "[0].au_fname") %>'>
			</asp:TextBox>
			<asp:Button id="Button4" style="Z-INDEX: 108; LEFT: 296px; POSITION: absolute; TOP: 264px" runat="server"
				Text="Next"></asp:Button>
			<asp:Button id="Button3" style="Z-INDEX: 107; LEFT: 191px; POSITION: absolute; TOP: 264px" runat="server"
				Text="Previous"></asp:Button>
			<asp:Button id="Button2" style="Z-INDEX: 106; LEFT: 368px; POSITION: absolute; TOP: 264px" runat="server"
				Text="Last"></asp:Button>
			<asp:Label id="Label2" style="Z-INDEX: 104; LEFT: 112px; POSITION: absolute; TOP: 208px" runat="server"
				Font-Bold="True" Font-Names="Verdana" Width="95px" Height="18px">Last Name</asp:Label>
			<asp:TextBox id=TextBox2 style="Z-INDEX: 102; LEFT: 264px; POSITION: absolute; TOP: 208px" runat="server" Text='<%# DataBinder.Eval(DataView1, "[0].au_lname") %>'>
			</asp:TextBox>&nbsp;
			<asp:Label id="Label1" style="Z-INDEX: 103; LEFT: 112px; WIDTH: 95px; POSITION: absolute; TOP: 144px; HEIGHT: 18px"
				runat="server" Font-Bold="True" Font-Names="Verdana">First Name</asp:Label>
			<asp:Button id="Button1" style="Z-INDEX: 105; LEFT: 120px; POSITION: absolute; TOP: 264px" runat="server"
				Text="First"></asp:Button>
			<asp:Label id="Label3" style="Z-INDEX: 109; LEFT: 88px; POSITION: absolute; TOP: 64px" runat="server"
				Font-Bold="True" Font-Names="Verdana" Font-Size="Large">Data Navigation in Web Forms</asp:Label>
		</form>
	</body>
</HTML>
