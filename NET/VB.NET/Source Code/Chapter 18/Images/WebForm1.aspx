<%@ Page Language="vb" AutoEventWireup="false" Codebehind="WebForm1.aspx.vb" Inherits="Images.WebForm1"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.0 Transitional//EN">
<HTML>
	<HEAD>
		<title>Images Example</title>
		<meta name="GENERATOR" content="Microsoft Visual Studio .NET 7.1">
		<meta name="CODE_LANGUAGE" content="Visual Basic .NET 7.1">
		<meta name="vs_defaultClientScript" content="JavaScript">
		<meta name="vs_targetSchema" content="http://schemas.microsoft.com/intellisense/ie5">
	</HEAD>
	<body MS_POSITIONING="GridLayout">
		<form id="Form1" method="post" runat="server">
			&nbsp;
			<asp:Label id="Label1" style="Z-INDEX: 101; LEFT: 112px; POSITION: absolute; TOP: 24px" runat="server"
				ToolTip="Using Images in Web Forms" Font-Bold="True" Font-Size="Medium" Font-Names="Verdana">Using Images in Web Forms</asp:Label>
			<asp:Label id="Label3" style="Z-INDEX: 102; LEFT: 24px; POSITION: absolute; TOP: 184px" runat="server"
				Font-Bold="True" Width="184px" Height="40px" Font-Names="Verdana">Root Relative URL</asp:Label>
			<asp:Label id="Label4" style="Z-INDEX: 103; LEFT: 24px; POSITION: absolute; TOP: 296px" runat="server"
				Font-Bold="True" Width="224px" Height="16px" Font-Names="Verdana">Document Relative URL</asp:Label>
			<asp:Label id="Label2" style="Z-INDEX: 104; LEFT: 24px; POSITION: absolute; TOP: 88px" runat="server"
				Font-Bold="True" Width="128px" Height="16px" Font-Names="Verdana">Absolute URL</asp:Label>
			<asp:Image id="Image1" style="Z-INDEX: 105; LEFT: 375px; POSITION: absolute; TOP: 80px" runat="server"
				ImageUrl="file:///C:\downloads\Keerthi\from Charul\Chapter 17\Code\Images\Images.bmp" Width="145px"
				Height="56px"></asp:Image>
			<asp:Image id="Image2" style="Z-INDEX: 106; LEFT: 375px; POSITION: absolute; TOP: 168px" runat="server"
				ImageUrl="http://localhost/Images/Images1.bmp" Width="145px" Height="56px"></asp:Image>
			<asp:Image id="Image3" style="Z-INDEX: 107; LEFT: 376px; POSITION: absolute; TOP: 272px" runat="server"
				ImageUrl="/images/images2.bmp" Width="145" Height="56"></asp:Image>
		</form>
	</body>
</HTML>
